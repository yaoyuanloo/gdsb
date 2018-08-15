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
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinput;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinputService;

/**
 * 柜台业务录入表Controller
 * @author Yang
 * @version 2016-09-09
 */
@Controller
@RequestMapping(value = "${adminPath}/gt/gtYwinput")
public class GtYwinputController extends BaseController {

	@Autowired
	private GtYwinputService gtYwinputService;
	
	@ModelAttribute
	public GtYwinput get(@RequestParam(required=false) String id) {
		GtYwinput entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gtYwinputService.get(id);
		}
		if (entity == null){
			entity = new GtYwinput();
		}
		return entity;
	}
	
	@RequiresPermissions("gt:gtYwinput:view")
	@RequestMapping(value = {"list", ""})
	public String list(GtYwinput gtYwinput, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GtYwinput> page = gtYwinputService.findPage(new Page<GtYwinput>(request, response), gtYwinput); 
		model.addAttribute("page", page);
		return "gtxt/gt/gtYwinputList";
	}

	@RequiresPermissions("gt:gtYwinput:view")
	@RequestMapping(value = "form")
	public String form(GtYwinput gtYwinput, Model model) {
		model.addAttribute("gtYwinput", gtYwinput);
		return "gtxt/gt/gtYwinputForm";
	}

	@RequiresPermissions("gt:gtYwinput:edit")
	@RequestMapping(value = "save")
	public String save(GtYwinput gtYwinput, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gtYwinput)){
			return form(gtYwinput, model);
		}
		gtYwinputService.save(gtYwinput);
		addMessage(redirectAttributes, "保存柜台业务录入表成功");
		return "redirect:"+Global.getAdminPath()+"/gt/gtYwinput/?repage";
	}
	
	@RequiresPermissions("gt:gtYwinput:edit")
	@RequestMapping(value = "delete")
	public String delete(GtYwinput gtYwinput, RedirectAttributes redirectAttributes) {
		gtYwinputService.delete(gtYwinput);
		addMessage(redirectAttributes, "删除柜台业务录入表成功");
		return "redirect:"+Global.getAdminPath()+"/gt/gtYwinput/?repage";
	}

}