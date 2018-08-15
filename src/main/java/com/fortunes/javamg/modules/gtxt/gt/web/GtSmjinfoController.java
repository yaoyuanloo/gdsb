/**
 *
 */
package com.fortunes.javamg.modules.gtxt.gt.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Maps;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwatter;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwinfo;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoService;
import com.fortunes.javamg.modules.gtxt.gt.entity.*;
import com.fortunes.javamg.modules.gtxt.gt.service.*;
import com.fortunes.javamg.modules.gtxt.utils.GtxtUitls;
import com.fortunes.javamg.modules.sys.entity.Dict;

import org.activiti.engine.impl.util.json.JSONArray;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfo;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialinfoService;

/**
 * 业务影像表Controller
 * @author Yang
 * @version 2016-09-10
 */
@Controller
@RequestMapping(value = "${adminPath}/gt/gtSmjinfo")
public class GtSmjinfoController extends BaseController {

	@Autowired
	private DYwinfoService dYwinfoService;
	@Autowired
	private GtSmjinfoService gtSmjinfoService;
	@Autowired
	private GtYwinfoService gtYwinfoService;
	@Autowired
	private GtYwinfocbService gtYwinfocbService;
	@Autowired
	private DYwatterService dYwatterService;
	@Autowired
	private PMaterialinfoService PMaterialinfoService;
	@Autowired
	private GtSmjcbService gtSmjcbService;
	
	@ModelAttribute
	public GtSmjinfo get(@RequestParam(required=false) String id) {
		GtSmjinfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gtSmjinfoService.get(id);
		}
		if (entity == null){
			entity = new GtSmjinfo();
		}
		return entity;
	}

//	@RequiresPermissions("gt:gtSmjinfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(String hzdh, String ywlsh, GtSmjinfo gtSmjinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		String pz=request.getSession().getServletContext().getRealPath("");
		model.addAttribute("pz", pz);
		model.addAttribute("ywlsh", ywlsh);
		model.addAttribute("hzdh", hzdh);
		return "modules/gtxt/gt/gtSmjinfoList";
	}
	//选择高拍仪型号
	@RequestMapping(value = {"imagemenu", ""})
	public String imagemenu(String hzdh, String ywlsh, GtSmjinfo gtSmjinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		String pz=request.getSession().getServletContext().getRealPath("");
		model.addAttribute("pz", pz);
		model.addAttribute("ywlsh", ywlsh);
		model.addAttribute("hzdh", hzdh);
		return "modules/gtxt/gt/imagemenu";
	}
    //选择高拍仪型号 良田s520r 和 史大龙
 	@RequestMapping(value = {"images520rinfo", ""})
	public String images520rinfo(String hzdh, String ywlsh,String type, GtSmjinfo gtSmjinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		String pz=request.getSession().getServletContext().getRealPath("");
		model.addAttribute("pz", pz);
		model.addAttribute("ywlsh", ywlsh);
		model.addAttribute("hzdh", hzdh);
		model.addAttribute("cameratype",type);
		return "modules/gtxt/imageinfo/images520rinfo";
	}

	/*
	 * 影像预览
	 */
	@RequestMapping(value = "listShow")
	public String listShow(Model model,HttpServletRequest request,String ywlsh){
		//String ywlsh="3ee4f872e1054cec8ed262f10c6a1c6a";
		String pz=request.getSession().getServletContext().getRealPath("");
		List<GtSmjinfo> gtSmjinfo=gtSmjinfoService.queryLsh(ywlsh);
		model.addAttribute("gtSmjinfo", gtSmjinfo);
		model.addAttribute("pz", pz);
		model.addAttribute("ywlsh", ywlsh);
		return "modules/gtxt/gt/gtShowSmjin";
	}

	@RequiresPermissions("gt:gtSmjinfo:view")
	@RequestMapping(value = "form")
	public String form(GtSmjinfo gtSmjinfo, Model model) {
		model.addAttribute("gtSmjinfo", gtSmjinfo);
		return "modules/gtxt/gt/gtSmjinfoForm";
	}

	//@RequiresPermissions("gt:gtSmjinfo:edit")
	@RequestMapping(value = "save")
	public String save(RedirectAttributes redirectAttributes,String logo,String ywlsh,Model model,String clm) {
		String msg="";
		System.out.println("111111111111");
		System.out.println("ywlsh:"+ywlsh);
		System.out.println("clm:"+clm);
		System.out.println("logo:"+logo);
		JSONArray array = new JSONArray();
		GtSmjcb gtsmjcb=null;
		GtSmjcb gtsmjcbs=null;
		GtSmjinfo gtSmjinfo=null;
		String[] pathArray=logo.split("\\|");
		String[] ywlius=ywlsh.split(",");
		List<String> tmp = new ArrayList<String>();
	    for(String str:pathArray){
	          if(str!=null && str.length()!=0){
	                tmp.add(str);
	         }
	    }
	    pathArray = tmp.toArray(new String[0]);
		String[] clid=clm.split(",");
		Map<String,String> map=new HashMap<String, String>();
		for(int i=0;i<clid.length;i++){
			if(map.containsKey(ywlius[i])){
				gtSmjinfo=new GtSmjinfo();
				gtSmjinfo.setYwlsh(ywlius[i]);
				gtSmjinfo.setMaterial(clid[i]);
				List<GtSmjinfo> gt=gtSmjinfoService.getMaterialid(gtSmjinfo);//获取影像id
				gtSmjinfo.setType(String.valueOf(2));
				gtSmjinfo.setYwlsh(ywlius[i]);
				gtSmjinfo.setMaterial(clid[i]);
				/*gtSmjinfo.setSmjpath(smjpath);*/
				gtSmjinfoService.updateId(gtSmjinfo);//如果存在就修改清单表里面的type
				gtsmjcbs=new GtSmjcb();
				gtsmjcbs.setSmjid(gt.get(0).getId());
				gtsmjcbs.setSmjmc(pathArray[i].substring(pathArray[i].lastIndexOf("/")+1,pathArray[i].lastIndexOf(".")));
				gtsmjcbs.setSmjpath(gt.get(0).getSmjpath());
				gtSmjcbService.save(gtsmjcbs);
				
				gtsmjcb=new GtSmjcb();//存在则往清单
				gtsmjcb.setSmjid(gt.get(0).getId());
				gtsmjcb.setSmjmc(pathArray[i].substring(pathArray[i].lastIndexOf("/")+1,pathArray[i].lastIndexOf(".")));
//				gtsmjcb.setSmjpath(pathArray[i].substring(7,pathArray[i].length()));
				gtsmjcb.setSmjpath(pathArray[i]);
				gtSmjcbService.save(gtsmjcb);
				msg="设定成功！";
				array.put(msg);
			}else{
				System.out.println(pathArray[i]);
				map.put(ywlius[i],ywlius[i]);
				gtSmjinfo=new GtSmjinfo();//不存在则是影像
				gtSmjinfo.setYwlsh(ywlius[i]);
				gtSmjinfo.setType(String.valueOf(1));
				gtSmjinfo.setSmjmc(pathArray[i].substring(pathArray[i].lastIndexOf("/")+1,pathArray[i].lastIndexOf(".")));
//				gtSmjinfo.setSmjpath(pathArray[i].substring(7,pathArray[i].length()));
				gtSmjinfo.setSmjpath(pathArray[i]);
				gtSmjinfo.setMaterial(clid[i]);
				gtSmjinfoService.save(gtSmjinfo);
				msg="设定成功！";
				array.put(msg);
			}
		}
		System.out.println(array.toString());
		return array.toString();
		
	}

	
	@RequestMapping(value = "Qdsave")
	public String Qdsave(String ywlsh,RedirectAttributes redirectAttributes,Model model,String logoqd,String yxid,String yxName) {
		logoqd=logoqd.replace("|", ",");
		GtSmjcb gtsmjcb=null;
		String[] fileArray=logoqd.split(",");
		System.out.println("fileArray:"+fileArray.length);
		for (int i = 0; i < fileArray.length; i++) {
			System.out.println(fileArray[i]);
			if(fileArray[i].length()==0){
				continue;
			}
			gtsmjcb=new GtSmjcb();
			gtsmjcb.setSmjid(yxid);
			gtsmjcb.setSmjmc(yxName);
			gtsmjcb.setSmjpath(fileArray[i].substring(7,fileArray[i].length()));
			gtsmjcb.setSmjhjs(String.valueOf(fileArray.length-1));
			gtSmjcbService.save(gtsmjcb);
		}
		addMessage(redirectAttributes, "保存清单成功");
		//return "redirect:"+Global.getAdminPath()+"/gt/gtSmjinfo/?repage";
		return "redirect:" + adminPath + "/gt/gtSmjinfo/list?ywlsh="+ywlsh;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "showQd")
	public String showQd(String yxid){
		Map<String, Object> map = Maps.newHashMap();
		JSONArray array = new JSONArray();
		List<GtSmjcb> gt=gtSmjcbService.queryMateriainfoName(yxid);
		for (GtSmjcb gtSmjcb : gt) {
			System.out.println(gtSmjcb.getSmjpath());
			map.put("id",gtSmjcb.getId());
			map.put("smjmc",gtSmjcb.getSmjmc());
			map.put("smjpath",gtSmjcb.getSmjpath());
			map.put("ywlsh",gtSmjcb.getSmjhjs());
			map.put("type",gtSmjcb.getRemarks());
			map.put("name",gtSmjcb.getDelFlag());
			array.put(map);
		}
		System.out.println(array.toString());
		return array.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "showcl")
	public String showcl(String id){
		
		System.out.println("材料编号:"+id);
		
		Map<String, Object> map = Maps.newHashMap();
		JSONArray array = new JSONArray();
		List<PMaterialinfo> gt=PMaterialinfoService.queryXl(id);
		for (PMaterialinfo pMaterialinfo : gt) {
			System.out.println(pMaterialinfo.getId());
			map.put("id",pMaterialinfo.getId());
			map.put("name",pMaterialinfo.getName());
			array.put(map);
		}
		System.out.println(array.toString());
		return array.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "showyw")
	public String showyw(String id){
		Map<String, Object> map = Maps.newHashMap();
		JSONArray array = new JSONArray();
		List<GtYwinfo> gt=gtYwinfoService.queryhzdh(id);
		for (GtYwinfo gtYwinfo : gt) {
			map.put("id",gtYwinfo.getYwlsh());
			map.put("name",gtYwinfo.getYwmc());
			array.put(map);
		}
		System.out.println(array.toString());
		return array.toString();
	}
	
	

    /**
     * flowcode 1 先受理后扫描, 2 先扫描后受理
     * shjbcode 1 打单业务, 2 快捷业务, 3 一级业务, 4 二级业务, 5 三级业务
     * @return
     */
//	@RequiresPermissions("gt:gtSmjinfo:edit")
	@RequestMapping(value = "update")
	public String update(GtYwinfo gtYwinfo, String ywlsh, GtSmjinfo gtSmjinfo, Model model, RedirectAttributes redirectAttributes) {
		gtYwinfo = gtYwinfoService.getByYwlsh(ywlsh);
//        gtYwinfo.setYwlsh(ywlsh);
//		hzdh = "0380ff29f3f14720a4aef8fe44b5c397";

		gtYwinfo.setLczt("LCB002");
		gtYwinfoService.updateLcztByHzdh(gtYwinfo);

		List<GtYwinfo> gtYwinfos = gtYwinfoService.findByHzdh(gtYwinfo.getHzdh());

		if(gtYwinfos != null && gtYwinfos.size() > 0){
			for(GtYwinfo g : gtYwinfos){
				GtYwinfocb gtYwinfocb = new GtYwinfocb();
				gtYwinfocb.setYwlsh(g.getYwlsh());
				gtYwinfocb.setYwlc("LCB002");
				gtYwinfocb.setClyj("业务已扫描");
				gtYwinfocb.setClr(gtYwinfocb.getCurrentUser());
				gtYwinfocbService.save(gtYwinfocb);
			}
		}

		gtYwinfo = null;
		if(gtYwinfos != null ) {
			if (gtYwinfos.size() == 1) {
				gtYwinfo = gtYwinfos.get(0);
			} else {
				for (GtYwinfo g : gtYwinfos) {
					if ("1".equals(g.getShry())) {
						gtYwinfo = g;
					}
				}
				if(gtYwinfo == null){
					//多业务
					gtYwinfo = gtYwinfos.get(0);
				}
			}
		}

		String flowcode, shjbcode;
		DYwatter dYwatter = dYwatterService.getByYwId(gtYwinfo.getYwid());
		flowcode = dYwatter.getFlowcode().getValue();
		shjbcode = dYwatter.getShjbcode().getValue();

		if (shjbcode.equals("2")) {
			if ("1".equals(flowcode)) {
				redirectAttributes.addAttribute(YWLSH, ywlsh);
				redirectAttributes.addAttribute(HZDH, gtYwinfo.getHzdh());
				DYwinfo dYwinfo = dYwinfoService.get(gtYwinfo.getYwid());
				return "redirect:" + adminPath + GtxtUitls.htmlUnescape(dYwinfo.getPywinfo().getExamineaddress());
			} else if ("2".equals(flowcode)) {
				redirectAttributes.addAttribute(YWLSH, ywlsh);
				redirectAttributes.addAttribute(HZDH, gtYwinfo.getHzdh());
				return "redirect:" + adminPath + "/city/dWrittempinfo/dyyl";
			} else {
				model.addAttribute("content", "不可识别流转配置！");
				return "/modules/gtxt/utils/test";
			}
		} else if (shjbcode.equals("3") || shjbcode.equals("4") || shjbcode.equals("5")) {
			if ("1".equals(flowcode)) {
                gtYwinfo.setFpzt(new Dict("1", ""));
                gtYwinfoService.updateFpztByHzdh(gtYwinfo);
				model.addAttribute("content", "办理结束, 业务已移交至后台！");
				model.addAttribute("finished", true);
				return "/modules/gtxt/utils/test";
			} else if ("2".equals(flowcode)) {
				redirectAttributes.addAttribute(YWLSH, ywlsh);
				redirectAttributes.addAttribute(HZDH, gtYwinfo.getHzdh());
				return "redirect:" + adminPath + "/city/dWrittempinfo/dyyl";
			} else {
				model.addAttribute("content", "不可识别流转配置！");
				return "/modules/gtxt/utils/test";
			}
		} else {
			model.addAttribute("content", "不可识别流转配置！");
			return "/modules/gtxt/utils/test";
		}
	}

}