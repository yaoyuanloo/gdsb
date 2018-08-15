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
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfocb;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfocbService;

/**
 * 柜台受理业务从表Controller
 * @author Yang
 * @version 2016-09-09
 */
@Controller
@RequestMapping(value = "${adminPath}/gt/gtywinfocb")
public class GtYwinfocbController extends BaseController {

	@Autowired
	private GtYwinfocbService gtYwinfocbService;
	
	@ModelAttribute
	public GtYwinfocb get(@RequestParam(required=false) String id) {
		GtYwinfocb entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gtYwinfocbService.get(id);
		}
		if (entity == null){
			entity = new GtYwinfocb();
		}
		return entity;
	}
	
//	@RequiresPermissions("gt:gtYwinfocb:view")
	@RequestMapping(value = {"list", ""})
	public String list(GtYwinfocb gtYwinfocb,HttpServletRequest request, HttpServletResponse response, Model model) {
//		gtYwinfocb.setYwlsh("2546a630a89848318276d082c6570bb0");
		Page<GtYwinfocb> page = gtYwinfocbService.findPage(new Page<GtYwinfocb>(request, response), gtYwinfocb); 
		model.addAttribute("gtYwinfo", gtYwinfocb);
		model.addAttribute("page", page);
		return "modules/gtxt/gt/gtYwinfocblist";
	}

	@RequiresPermissions("gt:gtYwinfocb:view")
	@RequestMapping(value = "form")
	public String form(GtYwinfocb gtYwinfocb, Model model) {
		model.addAttribute("gtYwinfocb", gtYwinfocb);
		return "gtxt/gt/gtYwinfocbForm";
	}

	@RequiresPermissions("gt:gtYwinfocb:edit")
	@RequestMapping(value = "save")
	public String save(GtYwinfocb gtYwinfocb, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gtYwinfocb)){
			return form(gtYwinfocb, model);
		}
		gtYwinfocbService.save(gtYwinfocb);
		addMessage(redirectAttributes, "保存柜台受理业务从表成功");
		return "redirect:"+Global.getAdminPath()+"/gt/gtYwinfocb/?repage";
	}
	
	@RequiresPermissions("gt:gtYwinfocb:edit")
	@RequestMapping(value = "delete")
	public String delete(GtYwinfocb gtYwinfocb, RedirectAttributes redirectAttributes) {
		gtYwinfocbService.delete(gtYwinfocb);
		addMessage(redirectAttributes, "删除柜台受理业务从表成功");
		return "redirect:"+Global.getAdminPath()+"/gt/gtYwinfocb/?repage";
	}

}