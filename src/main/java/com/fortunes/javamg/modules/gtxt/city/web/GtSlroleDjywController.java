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
import com.fortunes.javamg.modules.gtxt.city.entity.GtSlroleDjyw;
import com.fortunes.javamg.modules.gtxt.city.service.GtSlroleDjywService;

/**
 * 柜台受理角色业务管理表Controller
 * @author 万
 * @version 2016-09-08
 */
@Controller
@RequestMapping(value = "${adminPath}/city/gtSlroleDjyw")
public class GtSlroleDjywController extends BaseController {

	@Autowired
	private GtSlroleDjywService gtSlroleDjywService;
	
	@ModelAttribute
	public GtSlroleDjyw get(@RequestParam(required=false) String id) {
		GtSlroleDjyw entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gtSlroleDjywService.get(id);
		}
		if (entity == null){
			entity = new GtSlroleDjyw();
		}
		return entity;
	}
	
	@RequiresPermissions("city:gtSlroleDjyw:view")
	@RequestMapping(value = {"list", ""})
	public String list(GtSlroleDjyw gtSlroleDjyw, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GtSlroleDjyw> page = gtSlroleDjywService.findPage(new Page<GtSlroleDjyw>(request, response), gtSlroleDjyw); 
		model.addAttribute("page", page);
		return "gtxt/city/gtSlroleDjywList";
	}

	@RequiresPermissions("city:gtSlroleDjyw:view")
	@RequestMapping(value = "form")
	public String form(GtSlroleDjyw gtSlroleDjyw, Model model) {
		model.addAttribute("gtSlroleDjyw", gtSlroleDjyw);
		return "gtxt/city/gtSlroleDjywForm";
	}

	@RequiresPermissions("city:gtSlroleDjyw:edit")
	@RequestMapping(value = "save")
	public String save(GtSlroleDjyw gtSlroleDjyw, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gtSlroleDjyw)){
			return form(gtSlroleDjyw, model);
		}
		gtSlroleDjywService.save(gtSlroleDjyw);
		addMessage(redirectAttributes, "保存柜台受理角色业务管理表成功");
		return "redirect:"+Global.getAdminPath()+"/city/gtSlroleDjyw/?repage";
	}
	
	@RequiresPermissions("city:gtSlroleDjyw:edit")
	@RequestMapping(value = "delete")
	public String delete(GtSlroleDjyw gtSlroleDjyw, RedirectAttributes redirectAttributes) {
		gtSlroleDjywService.delete(gtSlroleDjyw);
		addMessage(redirectAttributes, "删除柜台受理角色业务管理表成功");
		return "redirect:"+Global.getAdminPath()+"/city/gtSlroleDjyw/?repage";
	}

}