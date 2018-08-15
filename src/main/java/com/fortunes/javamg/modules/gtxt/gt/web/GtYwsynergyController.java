/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.web;

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
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwsynergy;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwsynergyService;

/**
 * 柜台协同从表Controller
 * @author YANG
 * @version 2016-09-16
 */
@Controller
@RequestMapping(value = "${adminPath}/gt/gtYwsynergy")
public class GtYwsynergyController extends BaseController {

	@Autowired
	private GtYwsynergyService gtYwsynergyService;
	
	@ModelAttribute
	public GtYwsynergy get(@RequestParam(required=false) String id) {
		GtYwsynergy entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gtYwsynergyService.get(id);
		}
		if (entity == null){
			entity = new GtYwsynergy();
		}
		return entity;
	}
	
	@RequiresPermissions("gt:gtYwsynergy:view")
	@RequestMapping(value = {"list", ""})
	public String list(GtYwsynergy gtYwsynergy, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GtYwsynergy> page = gtYwsynergyService.findPage(new Page<GtYwsynergy>(request, response), gtYwsynergy); 
		model.addAttribute("page", page);
		return "gtxt/gt/gtYwsynergyList";
	}

	@RequiresPermissions("gt:gtYwsynergy:view")
	@RequestMapping(value = "form")
	public String form(GtYwsynergy gtYwsynergy, Model model) {
		model.addAttribute("gtYwsynergy", gtYwsynergy);
		return "gtxt/gt/gtYwsynergyForm";
	}

	@RequiresPermissions("gt:gtYwsynergy:edit")
	@RequestMapping(value = "save")
	public String save(GtYwsynergy gtYwsynergy, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gtYwsynergy)){
			return form(gtYwsynergy, model);
		}
		gtYwsynergyService.save(gtYwsynergy);
		addMessage(redirectAttributes, "保存柜台协同从表成功");
		return "redirect:"+Global.getAdminPath()+"/gt/gtYwsynergy/?repage";
	}
	
	@RequiresPermissions("gt:gtYwsynergy:edit")
	@RequestMapping(value = "delete")
	public String delete(GtYwsynergy gtYwsynergy, RedirectAttributes redirectAttributes) {
		gtYwsynergyService.delete(gtYwsynergy);
		addMessage(redirectAttributes, "删除柜台协同从表成功");
		return "redirect:"+Global.getAdminPath()+"/gt/gtYwsynergy/?repage";
	}

}