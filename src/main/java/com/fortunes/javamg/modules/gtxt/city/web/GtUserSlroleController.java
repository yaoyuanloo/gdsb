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
import com.fortunes.javamg.modules.gtxt.city.entity.GtUserSlrole;
import com.fortunes.javamg.modules.gtxt.city.service.GtUserSlroleService;

/**
 * 柜台用户受理角色关联表Controller
 * @author wan
 * @version 2016-09-09
 */
@Controller
@RequestMapping(value = "${adminPath}/city/gtUserSlrole")
public class GtUserSlroleController extends BaseController {

	@Autowired
	private GtUserSlroleService gtUserSlroleService;
	
	@ModelAttribute
	public GtUserSlrole get(@RequestParam(required=false) String id) {
		GtUserSlrole entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gtUserSlroleService.get(id);
		}
		if (entity == null){
			entity = new GtUserSlrole();
		}
		return entity;
	}
	
	@RequiresPermissions("city:gtUserSlrole:view")
	@RequestMapping(value = {"list", ""})
	public String list(GtUserSlrole gtUserSlrole, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GtUserSlrole> page = gtUserSlroleService.findPage(new Page<GtUserSlrole>(request, response), gtUserSlrole); 
		model.addAttribute("page", page);
		return "gtxt/city/gtUserSlroleList";
	}

	@RequiresPermissions("city:gtUserSlrole:view")
	@RequestMapping(value = "form")
	public String form(GtUserSlrole gtUserSlrole, Model model) {
		model.addAttribute("gtUserSlrole", gtUserSlrole);
		return "gtxt/city/gtUserSlroleForm";
	}

	@RequiresPermissions("city:gtUserSlrole:edit")
	@RequestMapping(value = "save")
	public String save(GtUserSlrole gtUserSlrole, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gtUserSlrole)){
			return form(gtUserSlrole, model);
		}
		gtUserSlroleService.save(gtUserSlrole);
		addMessage(redirectAttributes, "保存柜台用户受理角色关联表成功");
		return "redirect:"+Global.getAdminPath()+"/city/gtUserSlrole/?repage";
	}
	
	@RequiresPermissions("city:gtUserSlrole:edit")
	@RequestMapping(value = "delete")
	public String delete(GtUserSlrole gtUserSlrole, RedirectAttributes redirectAttributes) {
		gtUserSlroleService.delete(gtUserSlrole);
		addMessage(redirectAttributes, "删除柜台用户受理角色关联表成功");
		return "redirect:"+Global.getAdminPath()+"/city/gtUserSlrole/?repage";
	}

}