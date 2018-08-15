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
import com.fortunes.javamg.modules.gtxt.gt.entity.YwMateinfo;
import com.fortunes.javamg.modules.gtxt.gt.service.YwMateinfoService;

/**
 * 业务和材料生成表Controller
 * @author Yang
 * @version 2016-09-16
 */
@Controller
@RequestMapping(value = "${adminPath}/gt/ywMateinfo")
public class YwMateinfoController extends BaseController {

	@Autowired
	private YwMateinfoService ywMateinfoService;
	
	@ModelAttribute
	public YwMateinfo get(@RequestParam(required=false) String id) {
		YwMateinfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ywMateinfoService.get(id);
		}
		if (entity == null){
			entity = new YwMateinfo();
		}
		return entity;
	}
	
	@RequiresPermissions("gt:ywMateinfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(YwMateinfo ywMateinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<YwMateinfo> page = ywMateinfoService.findPage(new Page<YwMateinfo>(request, response), ywMateinfo); 
		model.addAttribute("page", page);
		return "gtxt/gt/ywMateinfoList";
	}

	@RequiresPermissions("gt:ywMateinfo:view")
	@RequestMapping(value = "form")
	public String form(YwMateinfo ywMateinfo, Model model) {
		model.addAttribute("ywMateinfo", ywMateinfo);
		return "gtxt/gt/ywMateinfoForm";
	}

	@RequiresPermissions("gt:ywMateinfo:edit")
	@RequestMapping(value = "save")
	public String save(YwMateinfo ywMateinfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ywMateinfo)){
			return form(ywMateinfo, model);
		}
		ywMateinfoService.save(ywMateinfo);
		addMessage(redirectAttributes, "保存材料生成表成功");
		return "redirect:"+Global.getAdminPath()+"/gt/ywMateinfo/?repage";
	}
	
	@RequiresPermissions("gt:ywMateinfo:edit")
	@RequestMapping(value = "delete")
	public String delete(YwMateinfo ywMateinfo, RedirectAttributes redirectAttributes) {
		ywMateinfoService.delete(ywMateinfo);
		addMessage(redirectAttributes, "删除材料生成表成功");
		return "redirect:"+Global.getAdminPath()+"/gt/ywMateinfo/?repage";
	}

}