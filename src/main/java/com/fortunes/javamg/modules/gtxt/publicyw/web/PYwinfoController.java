/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortunes.javamg.modules.gtxt.publicyw.entity.PYwCate;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PYwCateService;

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
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PYwinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PYwinfoService;

import java.util.List;

/**
 * 公共业务信息表Controller
 * @author YANG
 * @version 2016-09-07
 */
@Controller
@RequestMapping(value = "${adminPath}/publicyw/pYwinfo")
public class PYwinfoController extends BaseController {

	@Autowired
	private PYwinfoService pYwinfoService;
	@Autowired
	private PYwCateService pYwCateService;
	@ModelAttribute
	public PYwinfo get(@RequestParam(required=false) String id) {
		PYwinfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pYwinfoService.get(id);
		}
		if (entity == null){
			entity = new PYwinfo();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(PYwCate pYwCate, PYwinfo pYwinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(StringUtils.isNotEmpty(pYwCate.getId())){
			pYwinfo.setPywCate(pYwCate);
		}
		Page<PYwinfo> page = pYwinfoService.findPage(new Page<PYwinfo>(request, response), pYwinfo);
		model.addAttribute("page", page);
		model.addAttribute("pYwCate", pYwCate);
		return "modules/gtxt/publicyw/pYwinfoList";
	}
	@RequestMapping(value = "pwywList")
	public String pwywList(PYwinfo pYwinfo, Model model,HttpServletRequest request, HttpServletResponse response) {
		/*if(StringUtils.isNotEmpty(pYwCate.getId())){
			pYwinfo.setPywCate(pYwCate);
		}*/
		Page<PYwinfo> page = pYwinfoService.findPage(new Page<PYwinfo>(request, response), pYwinfo);
		model.addAttribute("page", page);
		model.addAttribute("pYwinfo", pYwinfo);
		//model.addAttribute("pYwCate", pYwCate);
		
		
		/*
		//pYwinfo.setPywCate(pYwCate);
		Page<PYwinfo> page = pYwinfoService.findPage(new Page<PYwinfo>(request, response), pYwinfo);
		model.addAttribute("page", page);
		//model.addAttribute("pYwCate", pYwCate);
*/		return "modules/gtxt/publicyw/pYwglinfoList";
	}
	@RequestMapping(value = "pwywform")
	public String pwywform(PYwinfo pYwinfo, Model model,HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("pYwinfo", pYwinfo);
		//获取所有业务分类列表
		List<PYwCate> list=pYwCateService.findList(new PYwCate());
		model.addAttribute("pYwCate", list);
		return "modules/gtxt/publicyw/pYwglinfoForm";
	}
	@RequestMapping(value = "form")
	public String form(PYwinfo pYwinfo, Model model) {
		model.addAttribute("pYwinfo", pYwinfo);
		//获取所有业务分类列表
		List<PYwCate> list=pYwCateService.findList(new PYwCate());
		model.addAttribute("pYwCate", list);
		return "modules/gtxt/publicyw/pYwinfoForm";
	}
	@RequestMapping(value = "updatePYwinfo")
	public String updatePYwinfo(PYwinfo pYwinfo, Model model) {
		model.addAttribute("pYwinfo", pYwinfo);
		//获取所有业务分类列表
		List<PYwCate> list=pYwCateService.findList(new PYwCate());
		model.addAttribute("pYwCate", list);
		return "/modules/gtxt/publicyw/pYwglinfoForm";
	}
	@RequestMapping(value = "delPYwinfo")
	public String delPYwinfo(PYwinfo pYwinfo, Model model,HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes) {
		pYwinfoService.delete(pYwinfo);
		addMessage(redirectAttributes, "删除公共业务信息表成功");
		return "/modules/gtxt/publicyw/pYwglinfoList";
	}

	@RequestMapping(value = "save")
	public String save(PYwinfo pYwinfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pYwinfo)){
			return form(pYwinfo, model);
		}
		pYwinfoService.save(pYwinfo);
		addMessage(redirectAttributes, "保存公共业务信息表成功");
		return "redirect:"+Global.getAdminPath()+"/publicyw/pYwinfo/list?pywCate.id="+pYwinfo.getPywCate().getId();
	}

	@RequestMapping(value = "delete")
	public String delete(PYwinfo pYwinfo, RedirectAttributes redirectAttributes) {
		pYwinfoService.delete(pYwinfo);
		addMessage(redirectAttributes, "删除公共业务信息表成功");
		return "redirect:"+Global.getAdminPath()+"/publicyw/pYwinfo/list?pywCate.id="+pYwinfo.getPywCate().getId();
	}

}