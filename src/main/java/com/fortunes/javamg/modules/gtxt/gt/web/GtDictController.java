/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.web;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.fortunes.javamg.common.config.Global;
import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtDict;
import com.fortunes.javamg.modules.gtxt.gt.service.GtDictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 字典Controller
 * 
 * @version 2014-05-16
 */
@Controller
@RequestMapping(value = "${adminPath}/gtxt/gt/gtdict")
public class GtDictController extends BaseController {

	@Autowired
	private GtDictService gtDictService;
	
	@ModelAttribute
	public GtDict get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return gtDictService.get(id);
		}else{
			return new GtDict();
		}
	}
	
	@RequiresPermissions("gt:gtdict:view")
	@RequestMapping(value = {"list", ""})
	public String list(GtDict gtDict, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<GtDict> typeList = gtDictService.findTypeList();
		model.addAttribute("typeList", typeList);
        Page<GtDict> page = gtDictService.findPage(new Page<GtDict>(request, response), gtDict);
        model.addAttribute("page", page);
		return "modules/gtxt/gt/gtDictList";
	}

	@RequiresPermissions("gt:gtdict:view")
	@RequestMapping(value = "form")
	public String form(GtDict gtDict, Model model) {
		model.addAttribute("dict", gtDict);
		return "modules/gtxt/gt/gtDictForm";
	}

	@RequiresPermissions("gt:gtdict:edit")
	@RequestMapping(value = "save")//@Valid 
	public String save(GtDict gtDict, Model model, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/gtxt/gt/gtdict/list?repage&type="+gtDict.getType();
		}
		if (!beanValidator(model, gtDict)){
			return form(gtDict, model);
		}
		gtDictService.save(gtDict);
		addMessage(redirectAttributes, "保存字典'" + gtDict.getLabel() + "'成功");
		return "redirect:" + adminPath + "/gtxt/gt/gtdict/list?repage&type="+gtDict.getType();
	}
	
	@RequiresPermissions("gt:gtdict:edit")
	@RequestMapping(value = "delete")
	public String delete(GtDict gtDict, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/gtxt/gt/gtdict/list?repage";
		}
		gtDictService.delete(gtDict);
		addMessage(redirectAttributes, "删除字典成功");
		return "redirect:" + adminPath + "/gtxt/gt/gtdict/list?repage&type="+gtDict.getType();
	}
	
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String type, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		GtDict dict = new GtDict();
		dict.setType(type);
		List<GtDict> list = gtDictService.findList(dict);
		for (int i=0; i<list.size(); i++){
			GtDict e = list.get(i);
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", e.getId());
			map.put("pId", e.getParentId());
			map.put("name", StringUtils.replace(e.getLabel(), " ", ""));
			mapList.add(map);
		}
		return mapList;
	}
	
	@ResponseBody
	@RequestMapping(value = "listData")
	public List<GtDict> listData(@RequestParam(required=false) String type) {
		GtDict dict = new GtDict();
		dict.setType(type);
		return gtDictService.findList(dict);
	}

}
