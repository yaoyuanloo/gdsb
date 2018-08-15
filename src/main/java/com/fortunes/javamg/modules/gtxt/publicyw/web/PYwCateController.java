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
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PYwCate;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PYwCateService;

/**
 * 公共业务类别Controller
 * @author 杨
 * @version 2016-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/publicyw/pYwCate")
public class PYwCateController extends BaseController {

	@Autowired
	private PYwCateService pYwCateService;
	
	@ModelAttribute
	public PYwCate get(@RequestParam(required=false) String id) {
		PYwCate entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pYwCateService.get(id);
		}
		if (entity == null){
			entity = new PYwCate();
		}
		return entity;
	}
	
	@RequiresPermissions("publicyw:pYwCate:view")
	@RequestMapping(value = {"list", ""})
	public String list(PYwCate pYwCate, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PYwCate> page = pYwCateService.findPage(new Page<PYwCate>(request, response), pYwCate);
		model.addAttribute("page", page);
		model.addAttribute("pYwCate", pYwCate);
		return "modules/gtxt/publicyw/pYwCateList";
	}

	@RequiresPermissions("publicyw:pYwCate:view")
	@RequestMapping(value = "form")
	public String form(PYwCate pYwCate, Model model) {
		model.addAttribute("pYwCate", pYwCate);
		return "modules/gtxt/publicyw/pYwCateForm";
	}

	@RequiresPermissions("publicyw:pYwCate:edit")
	@RequestMapping(value = "save")
	public String save(PYwCate pYwCate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pYwCate)){
			return form(pYwCate, model);
		}
		pYwCateService.save(pYwCate);
		addMessage(redirectAttributes, "保存公共业务类别成功");
		return "redirect:"+Global.getAdminPath()+"/publicyw/pYwCate/list?repage";
	}
	
	@RequiresPermissions("publicyw:pYwCate:edit")
	@RequestMapping(value = "delete")
	public String delete(PYwCate pYwCate, RedirectAttributes redirectAttributes) {
		pYwCateService.delete(pYwCate);
		addMessage(redirectAttributes, "删除公共业务类别成功");
		return "redirect:"+Global.getAdminPath()+"/publicyw/pYwCate/list?repage";
	}
	
	@RequestMapping(value = {"listyw", ""})
	public String listyw(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		return "modules/gtxt/publicyw/pYwglinfoList";
	}

}