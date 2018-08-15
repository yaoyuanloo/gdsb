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
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialCate;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialCateService;

/**
 * 业务材料分类Controller
 * @author 杨
 * @version 2016-09-07
 */
@Controller
@RequestMapping(value = "${adminPath}/publicyw/pMaterialCate")
public class PMaterialCateController extends BaseController {

	@Autowired
	private PMaterialCateService pMaterialCateService;
	
	@ModelAttribute
	public PMaterialCate get(@RequestParam(required=false) String id) {
		PMaterialCate entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pMaterialCateService.get(id);
		}
		if (entity == null){
			entity = new PMaterialCate();
		}
		return entity;
	}
	
	@RequiresPermissions("publicyw:pMaterialCate:view")
	@RequestMapping(value = {"list", ""})
	public String list(PMaterialCate pMaterialCate, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PMaterialCate> page = pMaterialCateService.findPage(new Page<PMaterialCate>(request, response), pMaterialCate); 
		model.addAttribute("page", page);
		model.addAttribute("pMaterialCate", pMaterialCate);
		return "modules/gtxt/publicyw/pMaterialCateList";
	}

	@RequiresPermissions("publicyw:pMaterialCate:view")
	@RequestMapping(value = "form")
	public String form(PMaterialCate pMaterialCate, Model model) {
		model.addAttribute("pMaterialCate", pMaterialCate);
		return "modules/gtxt/publicyw/pMaterialCateForm";
	}

	@RequiresPermissions("publicyw:pMaterialCate:edit")
	@RequestMapping(value = "save")
	public String save(PMaterialCate pMaterialCate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pMaterialCate)){
			return form(pMaterialCate, model);
		}
		pMaterialCateService.save(pMaterialCate);
		addMessage(redirectAttributes, "保存业务材料分类成功");
		return "redirect:"+Global.getAdminPath()+"/publicyw/pMaterialCate/?repage";
	}
	
	@RequiresPermissions("publicyw:pMaterialCate:edit")
	@RequestMapping(value = "delete")
	public String delete(PMaterialCate pMaterialCate, RedirectAttributes redirectAttributes) {
		pMaterialCateService.delete(pMaterialCate);
		addMessage(redirectAttributes, "删除业务材料分类成功");
		return "redirect:"+Global.getAdminPath()+"/publicyw/pMaterialCate/?repage";
	}

}