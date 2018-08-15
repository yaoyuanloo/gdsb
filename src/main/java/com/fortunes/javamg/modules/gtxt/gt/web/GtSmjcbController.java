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
import com.fortunes.javamg.modules.gtxt.gt.entity.GtSmjcb;
import com.fortunes.javamg.modules.gtxt.gt.service.GtSmjcbService;

/**
 * 扫描件清单表Controller
 * @author Yang
 * @version 2016-09-09
 */
@Controller
@RequestMapping(value = "${adminPath}/gt/gtSmjcb")
public class GtSmjcbController extends BaseController {

	@Autowired
	private GtSmjcbService gtSmjcbService;
	
	@ModelAttribute
	public GtSmjcb get(@RequestParam(required=false) String id) {
		GtSmjcb entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gtSmjcbService.get(id);
		}
		if (entity == null){
			entity = new GtSmjcb();
		}
		return entity;
	}
	
	@RequiresPermissions("gt:gtSmjcb:view")
	@RequestMapping(value = {"list", ""})
	public String list(GtSmjcb gtSmjcb, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GtSmjcb> page = gtSmjcbService.findPage(new Page<GtSmjcb>(request, response), gtSmjcb); 
		model.addAttribute("page", page);
		return "gtxt/gt/gtSmjcbList";
	}

	@RequiresPermissions("gt:gtSmjcb:view")
	@RequestMapping(value = "form")
	public String form(GtSmjcb gtSmjcb, Model model) {
		model.addAttribute("gtSmjcb", gtSmjcb);
		return "gtxt/gt/gtSmjcbForm";
	}

	@RequiresPermissions("gt:gtSmjcb:edit")
	@RequestMapping(value = "save")
	public String save(GtSmjcb gtSmjcb, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gtSmjcb)){
			return form(gtSmjcb, model);
		}
		gtSmjcbService.save(gtSmjcb);
		addMessage(redirectAttributes, "保存扫描件清单表成功");
		return "redirect:"+Global.getAdminPath()+"/gt/gtSmjcb/?repage";
	}
	
	@RequiresPermissions("gt:gtSmjcb:edit")
	@RequestMapping(value = "delete")
	public String delete(GtSmjcb gtSmjcb, RedirectAttributes redirectAttributes) {
		gtSmjcbService.delete(gtSmjcb);
		addMessage(redirectAttributes, "删除扫描件清单表成功");
		return "redirect:"+Global.getAdminPath()+"/gt/gtSmjcb/?repage";
	}

}