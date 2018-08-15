/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialCate;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialCateService;
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
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialinfoService;

import java.util.List;

/**
 * 公共业务材料表Controller
 * @author 杨
 * @version 2016-09-07
 */
@Controller
@RequestMapping(value = "${adminPath}/publicyw/pMaterialinfo")
public class PMaterialinfoController extends BaseController {
	@Autowired
	private PMaterialCateService pMaterialCateService;
	@Autowired
	private PMaterialinfoService pMaterialinfoService;
	
	@ModelAttribute
	public PMaterialinfo get(@RequestParam(required=false) String id) {
		PMaterialinfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pMaterialinfoService.get(id);
		}
		if (entity == null){
			entity = new PMaterialinfo();
		}
		return entity;
	}
	

	@RequestMapping(value = {"list", ""})
	public String list(PMaterialCate pMaterialCate,PMaterialinfo pMaterialinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(StringUtils.isNotEmpty(pMaterialCate.getId())) {
			pMaterialinfo.setCateId(pMaterialCate.getId());
		}
		Page<PMaterialinfo> page = pMaterialinfoService.findPage(new Page<PMaterialinfo>(request, response), pMaterialinfo);
	//	model.addAttribute("pMaterialCate", pMaterialCate);
		model.addAttribute("pMaterialinfo", pMaterialinfo);
		model.addAttribute("page", page);
		return "modules/gtxt/publicyw/pMaterialinfoList";
	}


	@RequestMapping(value = "form")
	public String form(PMaterialinfo pMaterialinfo, Model model) {
		model.addAttribute("pMaterialinfo", pMaterialinfo);
		//获取所有业务分类列表
		List<PMaterialCate> list=pMaterialCateService.findList(new PMaterialCate());
		model.addAttribute("PMaterialCate", list);
		return "modules/gtxt/publicyw/pMaterialinfoForm";
	}


	@RequestMapping(value = "save")
	public String save(PMaterialinfo pMaterialinfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pMaterialinfo)){
			return form(pMaterialinfo, model);
		}
		pMaterialinfoService.save(pMaterialinfo);
		addMessage(redirectAttributes, "保存公共业务材料表成功");
		return "redirect:"+Global.getAdminPath()+"/publicyw/pMaterialinfo/list?cateId="+pMaterialinfo.getCateId();
	}
	

	@RequestMapping(value = "delete")
	public String delete(PMaterialinfo pMaterialinfo, RedirectAttributes redirectAttributes) {
		pMaterialinfoService.delete(pMaterialinfo);
		addMessage(redirectAttributes, "删除公共业务材料表成功");
		return "redirect:"+Global.getAdminPath()+"/publicyw/pMaterialinfo/?repage";
	}

}