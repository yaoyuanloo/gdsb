/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fortunes.javamg.common.config.Global;
import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PConditionCate;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PConditionCateService;

/**
 * 业务条件分类Controller
 * @author YANG
 * @version 2016-09-07
 */
@Controller
@RequestMapping(value = "${adminPath}/publicyw/pConditionCate")
public class PConditionCateController extends BaseController {

	@Autowired
	private PConditionCateService pConditionCateService;
	
	@ModelAttribute
	public PConditionCate get(@RequestParam(required=false) String id) {
		PConditionCate entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pConditionCateService.get(id);
		}
		if (entity == null){
			entity = new PConditionCate();
		}
		return entity;
	}
	
	@RequiresPermissions("publicyw:pConditionCate:view")
	@RequestMapping(value = {"list", ""})
	public String list(PConditionCate pConditionCate, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PConditionCate> page = pConditionCateService.findPage(new Page<PConditionCate>(request, response), pConditionCate); 
		model.addAttribute("page", page);
		model.addAttribute("pConditionCate", pConditionCate);
		return "modules/gtxt/publicyw/pConditionCateList";
	}

	@RequiresPermissions("publicyw:pConditionCate:view")
	@RequestMapping(value = "form")
	public String form(PConditionCate pConditionCate, Model model) {
		model.addAttribute("pConditionCate", pConditionCate);
		return "modules/gtxt/publicyw/pConditionCateForm";
	}

	@RequiresPermissions("publicyw:pConditionCate:edit")
	@RequestMapping(value = "save")
	public String save(PConditionCate pConditionCate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pConditionCate)){
			return form(pConditionCate, model);
		}
		pConditionCateService.save(pConditionCate);
		addMessage(redirectAttributes, "保存业务条件分类成功");
		return "redirect:"+Global.getAdminPath()+"/publicyw/pConditionCate/?repage";
	}
	
	@RequiresPermissions("publicyw:pConditionCate:edit")
	@RequestMapping(value = "delete")
	public String delete(PConditionCate pConditionCate, RedirectAttributes redirectAttributes) {
		pConditionCateService.delete(pConditionCate);
		addMessage(redirectAttributes, "删除业务条件分类成功");
		return "redirect:"+Global.getAdminPath()+"/publicyw/pConditionCate/?repage";
	}

}