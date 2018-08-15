/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.web;

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
import com.fortunes.javamg.modules.gtxt.city.entity.DWrittemp;
import com.fortunes.javamg.modules.gtxt.city.service.DWrittempService;

/**
 * 地级市业务分类Controller
 * @author 杨
 * @version 2016-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/city/dWrittemp")
public class DWrittempController extends BaseController {

	@Autowired
	private DWrittempService dWrittempService;
	
	@ModelAttribute
	public DWrittemp get(@RequestParam(required=false) String id) {
		DWrittemp entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dWrittempService.get(id);
		}
		if (entity == null){
			entity = new DWrittemp();
		}
		return entity;
	}

	@RequestMapping(value = {"list", ""})
	public String list(DWrittemp dWrittemp, String name,HttpServletRequest request, HttpServletResponse response, Model model) {
		dWrittemp.setName(name);
		model.addAttribute("dWrittemp", dWrittemp);
		Page<DWrittemp> page = dWrittempService.findPage(new Page<DWrittemp>(request, response), dWrittemp);
		model.addAttribute("page", page);
		model.addAttribute("name", name);
		return "modules/gtxt/city/dWrittempList";
	}

	@RequestMapping(value = "form")
	public String form(DWrittemp dWrittemp, Model model) {
		model.addAttribute("dWrittemp", dWrittemp);
		return "modules/gtxt/city/dWrittempForm";
	}

	@RequestMapping(value = "save")
	public String save(DWrittemp dWrittemp, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dWrittemp)){
			return form(dWrittemp, model);
		}
		dWrittemp.setZone("Z100");
		dWrittempService.save(dWrittemp);
		addMessage(redirectAttributes, "保存地级市业务分类成功");
		return "redirect:"+Global.getAdminPath()+"/city/dWrittemp/?repage";
	}
	
	@RequiresPermissions("city:dWrittemp:edit")
	@RequestMapping(value = "delete")
	public String delete(DWrittemp dWrittemp, RedirectAttributes redirectAttributes) {
		dWrittempService.delete(dWrittemp);
		addMessage(redirectAttributes, "删除地级市业务分类成功");
		return "redirect:"+Global.getAdminPath()+"/city/dWrittemp/?repage";
	}

}