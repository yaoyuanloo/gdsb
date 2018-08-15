/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.fortunes.javamg.common.config.Global;
import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwinfoGroup2;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoGroup2Service;

/**
 * 本地业务属性定义Controller
 * @author YUAN
 * @version 2016-09-07
 */
@Controller
@RequestMapping(value = "${adminPath}/gtxt/city/dYwinfoGroup2")
public class DYwinfoGroup2Controller extends BaseController {

	@Autowired
	private DYwinfoGroup2Service dYwinfoGroup2Service;
	
	@ModelAttribute
	public DYwinfoGroup2 get(@RequestParam(required=false) String id) {
		DYwinfoGroup2 entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dYwinfoGroup2Service.get(id);
		}
		if (entity == null){
			entity = new DYwinfoGroup2();
		}
		return entity;
	}
	
	@RequiresPermissions("city:dYwinfoGroup2:view")
	@RequestMapping(value = {"list", ""})
	public String list(DYwinfoGroup2 dYwinfoGroup2, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DYwinfoGroup2> page = dYwinfoGroup2Service.findPage(new Page<DYwinfoGroup2>(request, response), dYwinfoGroup2); 
		model.addAttribute("page", page);
		return "modules/gtxt/city/dYwinfoGroup2List";
	}

	@RequiresPermissions("city:dYwinfoGroup2:view")
	@RequestMapping(value = "form")
	public String form(DYwinfoGroup2 dYwinfoGroup2, Model model) {
		model.addAttribute("dYwinfoGroup2", dYwinfoGroup2);
		return "modules/gtxt/city/dYwinfoGroup2Form";
	}

	@RequiresPermissions("city:dYwinfoGroup2:edit")
	@RequestMapping(value = "save")
	public String save(DYwinfoGroup2 dYwinfoGroup2, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dYwinfoGroup2)){
			return form(dYwinfoGroup2, model);
		}
		dYwinfoGroup2Service.save(dYwinfoGroup2);
		addMessage(redirectAttributes, "保存本地业务属性定义成功");
		return "redirect:"+Global.getAdminPath()+"/city/dYwinfoGroup2/?repage";
	}
	
	@RequiresPermissions("city:dYwinfoGroup2:edit")
	@RequestMapping(value = "delete")
	public String delete(DYwinfoGroup2 dYwinfoGroup2, RedirectAttributes redirectAttributes) {
		dYwinfoGroup2Service.delete(dYwinfoGroup2);
		addMessage(redirectAttributes, "删除本地业务属性定义成功");
		return "redirect:"+Global.getAdminPath()+"/city/dYwinfoGroup2/?repage";
	}
	
	  
		@ResponseBody
		@RequestMapping(value = "treeDataCheck")
		public List<Map<String, Object>> treeDataCheck(@RequestParam(required = false) String extId, @RequestParam(required = false) String type, HttpServletResponse response) {
			List<Map<String, Object>> mapList = Lists.newArrayList();
			List<DYwinfoGroup2> targ = dYwinfoGroup2Service.findChecksYwList();
			for (DYwinfoGroup2 targets : targ) {
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", targets.getId());
				map.put("pId", targets.getYwId());
				//map.put("pIds", e.getParentIds());
				map.put("name", targets.getDay());
				//map.put("pname", targets.getConment());
				
				mapList.add(map);
			}
			Map<String, Map> msp = new HashMap<String, Map>();
			//把list中的数据转换成msp,去掉同一id值多余数据，保留查找到第一个id值对应的数据
			for (int i = mapList.size() - 1; i >= 0; i--) {
				Map map = mapList.get(i);
				String id = map.get("id").toString();
				map.remove("id");
				msp.put(id, map);
			}
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			//把msp再转换成list,就会得到根据某一字段去掉重复的数据的List<Map>
			Set<String> mspKey = msp.keySet();
			for (String key : mspKey) {
				Map newMap = msp.get(key);
				newMap.put("id", key);
				list.add(newMap);
			}

			return list;
		}
		/**
		 * 点击业务类别查找业务信息
		 *
		 * @param targetsDj
		 * @param request
		 * @param response
		 * @param model
		 * @return
		 */
		@RequestMapping(value = "ywinfo")
		public String form(DYwinfoGroup2 targetsDj, HttpServletRequest request, HttpServletResponse response, Model model) {
			DYwinfoGroup2 tss = new DYwinfoGroup2();
////			tss.setJDmbh(targetsDj.getId());
//			List<DYwinfoGroup2> tarCaiList = new ArrayList<DYwinfoGroup2>();
//			//Targets ts = targetsService.getModePare(tss);
//			DYwinfoGroup2 dj = dYwinfoGroup2Service.getModePare(tss);
//			DYwinfoGroup2 djs = dYwinfoGroup2Service.getModePareNo(tss);
//			model.addAttribute("targetsDj", djs);
//			model.addAttribute("targets", dj);
//			if (StringUtils.isNotEmpty(dj.getJMate())) {
//				String[] cailiaoID = dj.getJMate().split(",");
//				Targets targa = new Targets();
//				for (String s : cailiaoID) {
//					targa.setJDmbh(s);
//					Targets ts = targetsService.getModePare(targa);
//					tarCaiList.add(ts);
//				}
	//
//			}
//			List<Targets> tags = targetsService.findTags(targetsDj.getId());
//			String tagnames = "";
//			for (int i = 0; i < tags.size(); i++) {
//				if (i > 0) tagnames += ",";
//				tagnames += tags.get(i).getJDmmc();
//			}
//			//根据用户机构选择该机构设定过的业务条件
//			TargetsDj  targdj=new TargetsDj();
//			targdj.setJDmnr(targetsDj.getId());
//			List<TargetsDj>  oldywtjList=targetsDjService.findList(targdj);
//			model.addAttribute("targetsList", tarCaiList);
//			model.addAttribute("targetsDj", dj);
//			model.addAttribute("tagnames", tagnames);
//			model.addAttribute("oldywtjList", oldywtjList);
			return "modules/gtxt/city/ywsettingForm";
		}


}