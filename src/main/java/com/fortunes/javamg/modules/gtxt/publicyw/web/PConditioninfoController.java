/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortunes.javamg.modules.gtxt.publicyw.entity.PConditionCate;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PConditionCateService;
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
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PConditioninfo;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PConditioninfoService;

import java.util.List;

/**
 * 公共条件信息表Controller
 * @author 杨
 * @version 2016-09-07
 */
@Controller
@RequestMapping(value = "${adminPath}/publicyw/pConditioninfo")
public class PConditioninfoController extends BaseController {
	@Autowired
	private PConditionCateService pConditionCateService;
	@Autowired
	private PConditioninfoService pConditioninfoService;
	
	@ModelAttribute
	public PConditioninfo get(@RequestParam(required=false) String id) {
		PConditioninfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pConditioninfoService.get(id);
		}
		if (entity == null){
			entity = new PConditioninfo();
		}
		return entity;
	}
	

	@RequestMapping(value = {"list", ""})
	public String list(PConditionCate  pConditionCate,PConditioninfo pConditioninfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		pConditioninfo.setCateId(pConditionCate.getId());
		Page<PConditioninfo> page = pConditioninfoService.findPage(new Page<PConditioninfo>(request, response), pConditioninfo);
		model.addAttribute("page", page);
		model.addAttribute("pConditioninfo", pConditioninfo);
		return "modules/gtxt/publicyw/pConditioninfoList";
	}


	@RequestMapping(value = "form")
	public String form(PConditioninfo pConditioninfo, Model model) {
		model.addAttribute("pConditioninfo", pConditioninfo);
		//获取所有业务分类列表
		List<PConditionCate> list=pConditionCateService.findList(new PConditionCate());
		model.addAttribute("pConditionCate", list);
		return "modules/gtxt/publicyw/pConditioninfoForm";
	}


	@RequestMapping(value = "save")
	public String save(PConditioninfo pConditioninfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pConditioninfo)){
			return form(pConditioninfo, model);
		}
		pConditioninfoService.save(pConditioninfo);
		addMessage(redirectAttributes, "保存公共条件信息表成功");
		return "redirect:"+Global.getAdminPath()+"/publicyw/pConditioninfo/?repage";
	}
	

	@RequestMapping(value = "delete")
	public String delete(PConditioninfo pConditioninfo, RedirectAttributes redirectAttributes) {
		pConditioninfoService.delete(pConditioninfo);
		addMessage(redirectAttributes, "删除公共条件信息表成功");
		return "redirect:"+Global.getAdminPath()+"/publicyw/pConditioninfo/?repage";
	}

}