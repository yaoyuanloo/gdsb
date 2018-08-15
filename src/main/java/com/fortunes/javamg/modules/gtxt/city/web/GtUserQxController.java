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
import com.fortunes.javamg.modules.gtxt.city.entity.GtUserQx;
import com.fortunes.javamg.modules.gtxt.city.service.GtUserQxService;

/**
 * 柜台用户权限关联表Controller
 * @author wan
 * @version 2016-09-09
 */
@Controller
@RequestMapping(value = "${adminPath}/city/gtUserQx")
public class GtUserQxController extends BaseController {

	@Autowired
	private GtUserQxService gtUserQxService;
	
	@ModelAttribute
	public GtUserQx get(@RequestParam(required=false) String id) {
		GtUserQx entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gtUserQxService.get(id);
		}
		if (entity == null){
			entity = new GtUserQx();
		}
		return entity;
	}
	
	@RequiresPermissions("city:gtUserQx:view")
	@RequestMapping(value = {"list", ""})
	public String list(GtUserQx gtUserQx, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GtUserQx> page = gtUserQxService.findPage(new Page<GtUserQx>(request, response), gtUserQx); 
		model.addAttribute("page", page);
		return "gtxt/city/gtUserQxList";
	}

	@RequiresPermissions("city:gtUserQx:view")
	@RequestMapping(value = "form")
	public String form(GtUserQx gtUserQx, Model model) {
		model.addAttribute("gtUserQx", gtUserQx);
		return "gtxt/city/gtUserQxForm";
	}

	@RequiresPermissions("city:gtUserQx:edit")
	@RequestMapping(value = "save")
	public String save(GtUserQx gtUserQx, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gtUserQx)){
			return form(gtUserQx, model);
		}
		gtUserQxService.save(gtUserQx);
		addMessage(redirectAttributes, "保存柜台用户权限关联表成功");
		return "redirect:"+Global.getAdminPath()+"/city/gtUserQx/?repage";
	}
	
	@RequiresPermissions("city:gtUserQx:edit")
	@RequestMapping(value = "delete")
	public String delete(GtUserQx gtUserQx, RedirectAttributes redirectAttributes) {
		gtUserQxService.delete(gtUserQx);
		addMessage(redirectAttributes, "删除柜台用户权限关联表成功");
		return "redirect:"+Global.getAdminPath()+"/city/gtUserQx/?repage";
	}

}