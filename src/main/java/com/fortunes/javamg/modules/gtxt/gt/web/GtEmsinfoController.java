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
import com.fortunes.javamg.modules.gtxt.gt.entity.GtEmsinfo;
import com.fortunes.javamg.modules.gtxt.gt.service.GtEmsinfoService;

/**
 * 邮政送达详情表Controller
 * @author Yang
 * @version 2016-09-09
 */
@Controller
@RequestMapping(value = "${adminPath}/gt/gtEmsinfo")
public class GtEmsinfoController extends BaseController {

	@Autowired
	private GtEmsinfoService gtEmsinfoService;
	
	@ModelAttribute
	public GtEmsinfo get(@RequestParam(required=false) String id) {
		GtEmsinfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gtEmsinfoService.get(id);
		}
		if (entity == null){
			entity = new GtEmsinfo();
		}
		return entity;
	}
	
	@RequiresPermissions("gt:gtEmsinfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(GtEmsinfo gtEmsinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GtEmsinfo> page = gtEmsinfoService.findPage(new Page<GtEmsinfo>(request, response), gtEmsinfo); 
		model.addAttribute("page", page);
		return "gtxt/gt/gtEmsinfoList";
	}

	@RequiresPermissions("gt:gtEmsinfo:view")
	@RequestMapping(value = "form")
	public String form(GtEmsinfo gtEmsinfo, Model model) {
		model.addAttribute("gtEmsinfo", gtEmsinfo);
		return "gtxt/gt/gtEmsinfoForm";
	}

	@RequiresPermissions("gt:gtEmsinfo:edit")
	@RequestMapping(value = "save")
	public String save(GtEmsinfo gtEmsinfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gtEmsinfo)){
			return form(gtEmsinfo, model);
		}
		gtEmsinfoService.save(gtEmsinfo);
		addMessage(redirectAttributes, "保存邮政送达详情表成功");
		return "redirect:"+Global.getAdminPath()+"/gt/gtEmsinfo/?repage";
	}
	
	@RequiresPermissions("gt:gtEmsinfo:edit")
	@RequestMapping(value = "delete")
	public String delete(GtEmsinfo gtEmsinfo, RedirectAttributes redirectAttributes) {
		gtEmsinfoService.delete(gtEmsinfo);
		addMessage(redirectAttributes, "删除邮政送达详情表成功");
		return "redirect:"+Global.getAdminPath()+"/gt/gtEmsinfo/?repage";
	}

}