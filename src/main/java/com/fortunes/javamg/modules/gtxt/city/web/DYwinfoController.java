/**
 *
 */
package com.fortunes.javamg.modules.gtxt.city.web;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortunes.javamg.modules.gtxt.city.entity.*;
import com.fortunes.javamg.modules.sys.entity.User;
import com.fortunes.javamg.modules.sys.utils.UserUtils;
import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
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
import com.fortunes.javamg.common.utils.Collections3;
import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.modules.gtxt.city.service.DConditionMaterialService;
import com.fortunes.javamg.modules.gtxt.city.service.DWrittempService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwConditionService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwMaterialService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwfzrService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwtabService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PConditionCate;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PConditioninfo;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialCate;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PYwCate;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PYwinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PConditionCateService;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PConditioninfoService;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialCateService;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PYwCateService;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PYwinfoService;

/**
 * 本地业务制定Controller
 *
 * @author xwm
 * @version 2016-09-07
 */
@Controller
@RequestMapping(value = "${adminPath}/city/dYwinfo")
public class DYwinfoController extends BaseController {

	@Autowired
	private DYwinfoService dYwinfoService;
	@Autowired
	private DYwfzrService dYwfzrService;

	@Autowired
	private PYwCateService pYwCateService;

	@Autowired
	private PYwinfoService pYwinfoService;

	@Autowired
	private DWrittempService dWrittempService;

	@Autowired
	private PMaterialCateService pMaterialCateService;

	@Autowired
	private DYwMaterialService dYwMaterialService;

	@Autowired
	private PConditioninfoService pConditioninfoService;
	@Autowired
	private DConditionMaterialService dConditionMaterialService;
	@Autowired
	private DYwtabService  dYwtabService;

	@Autowired
	private PConditionCateService pConditionCateService;


	@Autowired
	private com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialinfoService PMaterialinfoService;

	@Autowired
	private DYwConditionService dYwConditionService;
	@Autowired
	private DYwatterService dYwatterService;
	@ModelAttribute
	public DYwinfo get(@RequestParam(required=false) String id) {
		DYwinfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dYwinfoService.get(id);
		}
		if (entity == null){
			entity = new DYwinfo();
		}
		return entity;
	}

	//@RequiresPermissions("city:dYwinfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(DYwinfo dYwinfo,PYwCate pYwCate, HttpServletRequest request, HttpServletResponse response, Model model) {
		//Page<DYwinfo> page = dYwinfoService.findPage(new Page<DYwinfo>(request, response), dYwinfo);
		Page<PYwCate> page = pYwCateService.findPage(new Page<PYwCate>(request, response), pYwCate);
		model.addAttribute("page", page);
		return "/modules/gtxt/city/dYwinfoList";
	}




	/**
	 * 根据业务类别查找业务类别下的所有业务
	 * @param pYwCate
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getywList")
	public String formywList(String id,PYwCate pYwCate,PYwinfo pYwinfo, Model model,HttpServletRequest request, HttpServletResponse response) {
		pYwinfo.setPywCate(pYwCate);
        Page<PYwinfo> page = pYwinfoService.findPage(new Page<PYwinfo>(request, response), pYwinfo);
        model.addAttribute("page", page);
        model.addAttribute("pYwCate", pYwCate);
        DYwinfo  dj= new DYwinfo();
        dj.setOrgid("Z100");
        List<DYwinfo>  diList=dYwinfoService.findList(dj);
        StringBuffer ywid=new StringBuffer();
        for (DYwinfo dYwinfo : diList) {
            ywid.append(dYwinfo.getPywinfo().getId()+",");
        }
        model.addAttribute("listYwid", ywid);
        return "modules/gtxt/city/ywinfoList";

	}
	@RequestMapping(value = "pwywList")
	public String pwywList(PYwCate pYwCate,PYwinfo pYwinfo, Model model,HttpServletRequest request, HttpServletResponse response) {
		pYwinfo.setPywCate(pYwCate);
		Page<PYwinfo> page = pYwinfoService.findPage(new Page<PYwinfo>(request, response), pYwinfo);
		model.addAttribute("page", page);
		model.addAttribute("pYwCate", pYwCate);
		return "modules/gtxt/publicyw/pYwglinfoList";
	}
	@RequestMapping(value = "pwywform")
	public String pwywform(PYwinfo pYwinfo, Model model,HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("pYwinfo", pYwinfo);
		//获取所有业务分类列表
		List<PYwCate> list=pYwCateService.findList(new PYwCate());
		model.addAttribute("pYwCate", list);
		return "modules/gtxt/publicyw/pYwglinfoForm";
	}
    /**
     * 同步Dywinfo表
     *
     * @param ids
     * @param model
     * @param request
     * @param response
     * @return
     */
	@ResponseBody
    @RequestMapping(value = "tbDyinfo")
    public String formywList(String [] ids, Model model,HttpServletRequest request, HttpServletResponse response) {
       String msg="";
		try {
			for (int i = 0; i < ids.length; i++) {
				PYwinfo pywinfo = pYwinfoService.get(ids[i] + "");
				DYwinfo dyw = new DYwinfo();
				dyw.setPywinfo(pywinfo);
				dyw.setOrgid("Z100");

				List<DYwinfo>  djList=dYwinfoService.findList(dyw);
				if(djList.size()==0){
					dYwinfoService.saveDj(dyw);
				}
			 }
			msg="设定成功";
		} catch (Exception e) {
			e.printStackTrace();
			msg="设定失败";
		}
		JSONObject js=new JSONObject();
        js.put("msg", msg);
        js.put("checkboxValue", ids);
        model.addAttribute("msg", msg);
        return js.toString();
    }
	//@RequiresPermissions("city:dYwinfo:view")
	@RequestMapping(value = "form")
	public String form(DYwinfo dYwinfo, Model model) {
		model.addAttribute("dYwinfo", dYwinfo);
		return "/modules/gtxt/city/dYwinfoForm";
	}

	//@RequiresPermissions("city:dYwinfo:edit")
	@RequestMapping(value = "save")
	public String save(DYwinfo dYwinfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dYwinfo)){
			return form(dYwinfo, model);
		}
		dYwinfo.setOrgid("Z100");
		dYwinfoService.save(dYwinfo);
		addMessage(redirectAttributes, "保存本地业务制定成功");
		return "redirect:"+Global.getAdminPath()+"/city/dYwinfo/?repage";
	}

	//@RequiresPermissions("city:dYwinfo:edit")
	@RequestMapping(value = "delete")
	public String delete(DYwinfo dYwinfo, RedirectAttributes redirectAttributes) {
		dYwinfoService.delete(dYwinfo);
		addMessage(redirectAttributes, "删除本地业务制定成功");
		return "redirect:"+Global.getAdminPath()+"/city/dYwinfo/?repage";
	}
    @RequestMapping(value = {"index", ""})
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "modules/gtxt/city/ywsettingList";
    }
//	@ResponseBody
//	@RequestMapping(value = "treeDataCheck")
//	public String  treeDataCheck(@RequestParam(required = false) String extId, @RequestParam(required = false) String type, HttpServletResponse response) {
//		List<Map<String, Object>> mapList = Lists.newArrayList();
//		List<DYwinfo> targ = dYwinfoService.findChecksYwList();
//		JSONArray array = new JSONArray();
//		Set<String> set = new HashSet<String>();
//		for (DYwinfo targets : targ) {
//			if (!set.contains(targets.getPid())) {
//				Map<String, Object> map = Maps.newHashMap();
//				map.put("pId", targets.getId()+"1");
//				map.put("id", targets.getPid());
//				map.put("name", targets.getPname());
//				mapList.add(map);
//				array.put(map);
//				set.add(targets.getPid());
//			}
//			Map<String, Object> maps = Maps.newHashMap();
//			maps.put("pId", targets.getPid());
//			maps.put("id", targets.getId());
//			maps.put("name", targets.getName());
//			array.put(maps);
//			mapList.add(maps);
//		}
//		return array.toString();
//	}

    // TODO
    @RequestMapping(value = {"indexn", ""})
    public String indexn(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "modules/gtxt/city/ywsettingListn";
//        return "modules/gtxt/city/ywsettingList";
    }

    @ResponseBody
    @RequestMapping(value = "treeDataCheck")
    public String treeDataCheck(@RequestParam(required = false) String extId, @RequestParam(required = false) String type, HttpServletResponse response) {
        List<Map<String, Object>> mapList = Lists.newArrayList();
        List<DYwinfo> targ = dYwinfoService.findChecksYwList();
        JSONArray array = new JSONArray();
        Set<String> set = new HashSet<String>();
        for (DYwinfo targets : targ) {
            if (!set.contains(targets.getPid())) {
                Map<String, Object> map = Maps.newHashMap();
                map.put("pId", targets.getId() + "1");
                map.put("id", targets.getPid());
                map.put("name", targets.getPname());
                mapList.add(map);
                array.put(map);
                set.add(targets.getPid());
            }
            Map<String, Object> maps = Maps.newHashMap();
            maps.put("pId", targets.getPid());
            maps.put("id", targets.getId());
            maps.put("name", targets.getName());
            array.put(maps);
            mapList.add(maps);
        }
        return array.toString();
    }

	/**
	 * 获取机构JSON数据。
	 * @param extId 排除的ID
	 * @param type	类型（1：公司；2：部门/小组/其它：3：用户）
	 * @param grade 显示级别
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, @RequestParam(required=false) String type,
											  @RequestParam(required=false) Long grade, @RequestParam(required=false) Boolean isAll, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
//		List<DYwinfo> targ = dYwinfoService.findChecksYwList();
		List<DYwinfo> targ = dYwinfoService.findUserYwMenu(UserUtils.getUser().getId());
		Set<String> set = new HashSet<String>();
		for (DYwinfo targets : targ) {
			if (targets.getId().equals(extId))
				continue;
			if (!set.contains(targets.getPid())) {
				Map<String, Object> map = Maps.newHashMap();
				map.put("pId", targets.getId()+"1");
				map.put("id", targets.getPid());
				map.put("name", targets.getPname());
				mapList.add(map);
				set.add(targets.getPid());
			}
			Map<String, Object> maps = Maps.newHashMap();
			maps.put("pId", targets.getPid());
			maps.put("id", targets.getId());
			maps.put("name", targets.getName());
			mapList.add(maps);
		}
		return mapList;
	}

	/*
	 * 点击左边业务查询材料和条件信息
	 */
	@RequestMapping(value = {"ywsx", ""})
	public String ywsx(String id,HttpServletRequest request, HttpServletResponse response, Model model) {
		DYwinfo dyw = dYwinfoService.get(id);
		System.out.println("dyw:"+dyw.getPywinfo().getCode());
		System.out.println("dyw:"+dyw.getPywinfo().getName());

		System.out.println("dyw:"+dyw.getId());
		List<PMaterialinfo> listPMInfo=PMaterialinfoService.queryid(dyw.getId());
		List<PConditioninfo> listPCInfo=pConditioninfoService.queryid(dyw.getId());

		if(listPMInfo!=null && listPMInfo.size()>0){
			model.addAttribute("ywclcount", listPMInfo.size());
		if(listPMInfo!=null && listPMInfo.size()>0){
			model.addAttribute("ywclcount", listPMInfo.size());

		}else{
			model.addAttribute("ywclcount",0);
		}

		if(listPCInfo!=null && listPCInfo.size()>0){
			model.addAttribute("ywtjcount", listPCInfo.size());
		}else{
			model.addAttribute("ywtjcount",0);
		}

		}
		DYwatter  dYwatter= dYwatterService.getByYwId(id);
		if (dYwatter==null){
			  dYwatter=new DYwatter();
			  dYwatter.setYwid(id);
			dYwatterService.save(dYwatter);
		}
		//根据业务ID查询该业务绑定的标签
		DYwtab  tab=new DYwtab();
		tab.setYwid(dyw.getId());
		List<DYwtab> list=dYwtabService.findList(tab);
		model.addAttribute("tabList", list);
		model.addAttribute("dYwatter", dYwatter);
		model.addAttribute("dyw", dyw);
		model.addAttribute("ywid", id);
		List<User>  userList=dYwfzrService.userList(id);
		model.addAttribute("userList", userList);
		model.addAttribute("listPMInfo", listPMInfo);
		model.addAttribute("listPCInfo", listPCInfo);
		return "modules/gtxt/city/ywpropertyList";
			}


    /*
     * TODO 点击左边业务查询材料和条件信息
     */
    @RequestMapping(value = {"ywsxn", ""})
    public String ywsxn(String id, HttpServletRequest request, HttpServletResponse response, Model model) {
        DYwinfo dyw = dYwinfoService.get(id);
        List<PMaterialinfo> listPMInfo = PMaterialinfoService.queryid(dyw.getId());
        List<PConditioninfo> listPCInfo = pConditioninfoService.queryid(dyw.getId());

        if (listPMInfo != null && listPMInfo.size() > 0) {
            model.addAttribute("ywclcount", listPMInfo.size());
            if (listPMInfo != null && listPMInfo.size() > 0) {
                model.addAttribute("ywclcount", listPMInfo.size());

            } else {
                model.addAttribute("ywclcount", 0);
            }

            if (listPCInfo != null && listPCInfo.size() > 0) {
                model.addAttribute("ywtjcount", listPCInfo.size());
            } else {
                model.addAttribute("ywtjcount", 0);
            }

        }
        DYwatter dYwatter = dYwatterService.getByYwId(id);
        if (dYwatter == null) {
            dYwatter = new DYwatter();
            dYwatter.setYwid(id);
            dYwatterService.save(dYwatter);
        }
        //根据业务ID查询该业务绑定的标签
        DYwtab tab = new DYwtab();
        tab.setYwid(dyw.getId());
        List<DYwtab> list = dYwtabService.findList(tab);
        model.addAttribute("tabList", list);
        model.addAttribute("dYwatter", dYwatter);
        model.addAttribute("dyw", dyw);
        model.addAttribute("ywid", id);
        List<User> userList = dYwfzrService.userList(id);
        model.addAttribute("userList", userList);
        model.addAttribute("listPMInfo", listPMInfo);
        model.addAttribute("listPCInfo", listPCInfo);
        return "modules/gtxt/city/ywpropertyListn";
    }

//    /**
//     * TODO 点击左边业务查询材料和条件信息
//     */
//    @RequestMapping(value = {"testList", ""})
//    public String testList(String id, HttpServletRequest request, HttpServletResponse response, Model model) {
//        DYwinfo dyw = dYwinfoService.get(id);
//        System.out.println("dyw:" + dyw.getPywinfo().getCode());
//        System.out.println("dyw:" + dyw.getPywinfo().getName());
//
//        System.out.println("dyw:" + dyw.getId());
//        List<PMaterialinfo> listPMInfo = PMaterialinfoService.queryid(dyw.getId());
//        List<PConditioninfo> listPCInfo = pConditioninfoService.queryid(dyw.getId());
//
//        if (listPMInfo != null && listPMInfo.size() > 0) {
//            model.addAttribute("ywclcount", listPMInfo.size());
//            if (listPMInfo != null && listPMInfo.size() > 0) {
//                model.addAttribute("ywclcount", listPMInfo.size());
//
//            } else {
//                model.addAttribute("ywclcount", 0);
//            }
//
//            if (listPCInfo != null && listPCInfo.size() > 0) {
//                model.addAttribute("ywtjcount", listPCInfo.size());
//            } else {
//                model.addAttribute("ywtjcount", 0);
//            }
//
//        }
//        DYwatter dYwatter = dYwatterService.getByYwId(id);
//        if (dYwatter == null) {
//            dYwatter = new DYwatter();
//            dYwatter.setYwid(id);
//            dYwatterService.save(dYwatter);
//        }
//        //根据业务ID查询该业务绑定的标签
//        DYwtab tab = new DYwtab();
//        tab.setYwid(dyw.getId());
//        List<DYwtab> list = dYwtabService.findList(tab);
//        model.addAttribute("tabList", list);
//        model.addAttribute("dYwatter", dYwatter);
//        model.addAttribute("dyw", dyw);
//        model.addAttribute("ywid", id);
//        List<User> userList = dYwfzrService.userList(id);
//        model.addAttribute("userList", userList);
//        model.addAttribute("listPMInfo", listPMInfo);
//        model.addAttribute("listPCInfo", listPCInfo);
//        return "modules/gtxt/city/ywpropertyListn";
//    }

	/*
	 * 点击编辑材料查询业务材料
	 */

	/*
	 * 给业务绑定材料
	 * 点击编辑材料查询业务材料
	 */
	@RequestMapping(value = "ywcaiLiao")
	public String ywcaiLiao(Model model,String clcode) {
		System.out.println("ywid:"+clcode);
		List<PMaterialCate> listPM=pMaterialCateService.findAll();
		List<PMaterialinfo> listPMInfo=PMaterialinfoService.queryInfo(clcode);
		model.addAttribute("listPM", listPM);
		model.addAttribute("listPMInfo", listPMInfo);
		model.addAttribute("selectIds", Collections3.extractToString(listPMInfo, "id", ","));
		return "modules/gtxt/city/selectYwCailiao";
	}

	/*
	 * 点击编辑添加查询业务条件
	 */
	/*@RequestMapping(value = "ywtianjian")
	public String ywtianjian(Model model,String clcode) {
		System.out.println("ywid:"+clcode);
		List<PConditionCate> listPC=pConditionCateService.findAll();
		List<PConditioninfo> listPCInfo=pConditioninfoService.queryInfo(clcode);
		model.addAttribute("listPC", listPC);
		model.addAttribute("listPCInfo", listPCInfo);
		model.addAttribute("selectIds", Collections3.extractToString(listPCInfo, "id", ","));
		return "modules/gtxt/city/selectYwtiaojian";
	}
=======*/
    /*
     * 给业务绑定条件
	 * 点击编辑添加查询业务条件
	 */
	@RequestMapping(value = "ywtianjian")
	public String ywtianjian(Model model,String clcode) {
		System.out.println("ywid:"+clcode);
		List<PConditionCate> listPC=pConditionCateService.findAll();
		List<PConditioninfo> listPCInfo=pConditioninfoService.queryInfo(clcode);
		model.addAttribute("listPC", listPC);
		model.addAttribute("listPCInfo", listPCInfo);
		model.addAttribute("selectIds", Collections3.extractToString(listPCInfo, "id", ","));
		return "modules/gtxt/city/selectYwtiaojian";
	}


    /**
     * 业务分类下面的材料
     *
     * @param
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ywcaiLiaoInfo")
    public List<Map<String, Object>> ywcaiLiaoInfo(String pmId, HttpServletResponse response) {
        System.out.println("pmId:" + pmId);
        List<Map<String, Object>> mapList = Lists.newArrayList();
        PMaterialinfo pMaterialinfo = new PMaterialinfo();
        pMaterialinfo.setCateId(pmId);
        Page<PMaterialinfo> page = PMaterialinfoService.findPage(new Page<PMaterialinfo>(1, -1), pMaterialinfo);
        for (PMaterialinfo e : page.getList()) {
            Map<String, Object> map = Maps.newHashMap();
            System.out.println("e.getName:" + e.getName());
            map.put("id", e.getId());
            map.put("pId", 0);
            map.put("name", e.getName());
            mapList.add(map);
        }
        return mapList;
    }

    /**
     * 业务分类下面的条件
     *
     * @param
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ywtiaojianInfo")
    public List<Map<String, Object>> ywtiaojianInfo(String pmId, HttpServletResponse response) {
        System.out.println("pmId:" + pmId);
        List<Map<String, Object>> mapList = Lists.newArrayList();
        PConditioninfo pConditioninfo = new PConditioninfo();
        pConditioninfo.setCateId(pmId);
        Page<PConditioninfo> page = pConditioninfoService.findPage(new Page<PConditioninfo>(1, -1), pConditioninfo);
        for (PConditioninfo e : page.getList()) {
            Map<String, Object> map = Maps.newHashMap();
            System.out.println("e.getName:" + e.getName());
            map.put("id", e.getId());
            map.put("pId", 0);
            map.put("name", e.getName());
            mapList.add(map);
        }
        return mapList;
    }


    /*
     * 材料分配保存
     */
    @RequestMapping(value = "clsave")
    public String clSave(String[] idsArr, String ywcode, String ywid, RedirectAttributes redirectAttributes) {
        DYwMaterial dywmaterial;
        //dYwMaterialService.deleteYwid(ywcode);//先删除
        System.out.println("ywid:" + ywid);
        dYwMaterialService.deleteYwid(ywcode);//先删除
        System.out.println("ywid:" + ywid);
        for (int i = 0; i < idsArr.length; i++) {
            System.out.println("材料添加的数据：" + idsArr[i]);
            dywmaterial = new DYwMaterial();
            dywmaterial.setYwId(ywcode);
            dywmaterial.setPMateId(idsArr[i]);
            dYwMaterialService.save(dywmaterial);
        }
        addMessage(redirectAttributes, "分配成功 ");
        return "redirect:" + adminPath + "/city/dYwinfo/ywsx?id=" + ywid;
    }

    /*
    * 材料分配保存
    */
    @RequestMapping(value = "clsaven")
    public String clSaven(String[] idsArr, String ywcode, String ywid, RedirectAttributes redirectAttributes) {
        DYwMaterial dywmaterial;
        //dYwMaterialService.deleteYwid(ywcode);//先删除
        System.out.println("ywid:" + ywid);
        dYwMaterialService.deleteYwid(ywcode);//先删除
        System.out.println("ywid:" + ywid);
        for (int i = 0; i < idsArr.length; i++) {
            System.out.println("材料添加的数据：" + idsArr[i]);
            dywmaterial = new DYwMaterial();
            dywmaterial.setYwId(ywcode);
            dywmaterial.setPMateId(idsArr[i]);
            dYwMaterialService.save(dywmaterial);
        }
        addMessage(redirectAttributes, "分配成功 ");
        return "redirect:" + adminPath + "/city/dYwinfo/ywsxn?id=" + ywid;
    }

	/*
	 * 条件分配保存
	 */
/*	@RequestMapping(value = "tjsave")
	public String tjsave(String[] idsArr,String tjcode,String ywid, RedirectAttributes redirectAttributes) {
		DYwCondition dYwCondition;
		System.out.println("ywid:"+ywid);
		System.out.println("tjcode:"+tjcode);
		for (int i = 0; i < idsArr.length; i++) {
			System.out.println("添加添加的数据："+idsArr[i]);
			dYwCondition=new DYwCondition();
			dYwCondition.setYwId(tjcode);
			dYwCondition.setPConId(idsArr[i]);
			dYwConditionService.save(dYwCondition);
		}
		addMessage(redirectAttributes, "分配成功 ");
		return "redirect:" + adminPath + "/city/dYwinfo/ywsx?id="+ywid;
	}*/

	/*
	 * 保存业务信息
	 */
/*	public String ywInfo(){
		return null;
	}*/
	//设定流转方式
		@RequestMapping(value = "ylout")
		public String ylout(Model model,String ywid,RedirectAttributes redirectAttributes) {
			DYwatter dywatter=dYwatterService.getByYwId(ywid);
			if(dywatter==null){
				dywatter= new DYwatter();
				model.addAttribute("dywatter", dywatter);
			}else{
				model.addAttribute("dywatter", dywatter);
			}

			List<User>  userList=dYwfzrService.userList(ywid);
			model.addAttribute("userList", userList);
			return "modules/gtxt/city/ywsettingLzfs";
		}
		//设定流转方式的保存
		//DYwatter 业务属性表
		@RequestMapping(value = "saveYwlzfs")
		public String saveYwlzfs(DYwatter  dYwatter,Model model,String id,String jRevi,String jAss,String jClass,String jReviZe,RedirectAttributes redirectAttributes) {
			DYwatter dYwatterfow=dYwatterService.getByYwId(dYwatter.getYwid());
			if(dYwatterfow!=null){
			   dYwatter.setId(dYwatterfow.getId());
				dYwatterService.save(dYwatter);
			}
		/*	Dict dict=new  Dict();
			dict.setId(dYwatter.getLzfscode().getId());
			dYwatter.setLzfscode(dict);//业务审核流转方式

			Dict dict2=new  Dict();
			dict2.setId(dYwatter.getFlowcode().getId());
			dYwatter.setFlowcode(dict2);//主流分配方式

			Dict dict3=new  Dict();
			dict3.setId(dYwatter.getFlowcode().getId());
			dYwatter.setShjbcode(dict3);//审核级别*/

		//添加人员表
			if(StringUtils.isNotEmpty(dYwatter.getUserList())){
				String userIds[] =dYwatter.getUserList().split(",");
				DYwfzr fzr =new DYwfzr();
				fzr.setYwId(dYwatter.getYwid());
				if(userIds.length>0) {
					dYwfzrService.deleteByYwId(fzr);
					for (String userId : userIds) {
						DYwfzr fzra = new DYwfzr();
						fzra.setYwId(dYwatter.getYwid());
						fzra.setUserid(userId);
						dYwfzrService.saveDyFzr(fzra);
					}
				}
			}

		//保存业务负责人员表
		return "redirect:" + adminPath + "/city/dYwinfo/ywsx?id="+dYwatter.getYwid();
	}
	/*
	 * 条件分配保存
	 */
	@RequestMapping(value = "tjsave")
	public String tjSave(String[] idsArr,String tjcode,String ywid,RedirectAttributes redirectAttributes) {
		DYwCondition dYwCondition;
		dYwConditionService.deleteYwid(ywid);//先删除再保存
		System.out.println("ywid:"+ywid);
		System.out.println("tjcode:"+tjcode);
		for (int i = 0; i < idsArr.length; i++) {
			System.out.println("添加添加的数据："+idsArr[i]);
			dYwCondition=new DYwCondition();
			dYwCondition.setYwId(tjcode);
			dYwCondition.setPConId(idsArr[i]);
			dYwConditionService.save(dYwCondition);
		}
		addMessage(redirectAttributes, "分配成功 ");
		return "redirect:" + adminPath + "/city/dYwinfo/ywsx?id="+ywid;
	}

	/*
	 * 保存业务信息
	 */
	@RequestMapping(value = "ywInfoSave")
	public String ywInfoSave(String ywid,String bz,String gzr,String ywnr,String state,RedirectAttributes redirectAttributes){
		System.out.println("bz/1:"+bz);
		System.out.println("bz/2:"+gzr);
		System.out.println("bz/3:"+ywnr);
		System.out.println("bz/4:"+state);
		DYwinfo dyw=new DYwinfo();
		dyw.setId(ywid);
		dyw.setConment(ywnr);//业务内容
		dyw.setState(state);
		dyw.setDay(gzr);
		dyw.setRemarks(bz);
		dYwinfoService.updateywid(dyw);
		addMessage(redirectAttributes, "保存成功!");
		return "redirect:" + adminPath + "/city/dYwinfo/ywsx?id="+ywid;
	}


	/*
	 * 查询条件下面的材料
	 * 点击编辑材料查询业务材料
	 */
//	@RequestMapping(value = "tjcailiao")
//	public String tjCaiLiao(Model model,String conditionid) {
//		System.out.println("conditionid:"+conditionid);
//		List<PMaterialCate> listPM=pMaterialCateService.findAll();//材料
//
//		System.out.println(listPM.size());
//
//		List<PMaterialinfo> listPMInfo=PMaterialinfoService.qConditionCl(conditionid);//条件下面的材料
//		model.addAttribute("listPM", listPM);
//		model.addAttribute("listPMInfo", listPMInfo);
//		model.addAttribute("selectIds", Collections3.extractToString(listPMInfo, "id", ","));
//		return "modules/gtxt/city/selectCltiaojian";
//	}
	/*
	 * 条件材料分配保存
	 */
//	@RequestMapping(value = "tjcailiaosave")
//	public String tjCaiLiaoSave(String[] idsArrstj,String conditionid,String ywid,RedirectAttributes redirectAttributes) {
//		DConditionMaterial dConditionMaterial;
//		dConditionMaterialService.deletetj(conditionid);//先删除再保存
//		for (int i = 0; i < idsArrstj.length; i++) {
//			System.out.println("添加添加的数据："+idsArrstj[i]);
//			dConditionMaterial=new DConditionMaterial();
//			dConditionMaterial.setDConId(conditionid);
//			dConditionMaterial.setPMateId(idsArrstj[i]);
//			dConditionMaterialService.save(dConditionMaterial);
//		}
//		addMessage(redirectAttributes, "分配成功 ");
//		return "redirect:" + adminPath + "/city/dYwinfo/ywsx?id="+ywid;
//	}



//        //保存业务负责人员表
//        return "redirect:" + adminPath + "/city/dYwinfo/ywsx?id=" + dYwatter.getYwid();
//    }

    //todo 设定流转方式的保存
    //DYwatter 业务属性表
    @RequestMapping(value = "saveYwlzfsn")
    public String saveYwlzfsn(DYwatter dYwatter, Model model, String id, String jRevi, String jAss, String jClass, String jReviZe, RedirectAttributes redirectAttributes) {
        DYwatter dYwatterfow = dYwatterService.getByYwId(dYwatter.getYwid());
        if (dYwatterfow != null) {
            dYwatter.setId(dYwatterfow.getId());
            dYwatterService.save(dYwatter);
        }
		/*	Dict dict=new  Dict();
			dict.setId(dYwatter.getLzfscode().getId());
			dYwatter.setLzfscode(dict);//业务审核流转方式

			Dict dict2=new  Dict();
			dict2.setId(dYwatter.getFlowcode().getId());
			dYwatter.setFlowcode(dict2);//主流分配方式

			Dict dict3=new  Dict();
			dict3.setId(dYwatter.getFlowcode().getId());
			dYwatter.setShjbcode(dict3);//审核级别*/

        //添加人员表
        if (StringUtils.isNotEmpty(dYwatter.getUserList())) {
            String userIds[] = dYwatter.getUserList().split(",");
            DYwfzr fzr = new DYwfzr();
            fzr.setYwId(dYwatter.getYwid());
            if (userIds.length > 0) {
                dYwfzrService.deleteByYwId(fzr);
                for (String userId : userIds) {
                    DYwfzr fzra = new DYwfzr();
                    fzra.setYwId(dYwatter.getYwid());
                    fzra.setUserid(userId);
                    dYwfzrService.saveDyFzr(fzra);
                }
            }
        }

        //保存业务负责人员表
        return "redirect:" + adminPath + "/city/dYwinfo/ywsxn?id=" + dYwatter.getYwid();
    }

    /*
     * 条件分配保存
     */
//    @RequestMapping(value = "tjsave")
//    public String tjSave(String[] idsArr, String tjcode, String ywid, RedirectAttributes redirectAttributes) {
//        DYwCondition dYwCondition;
//        dYwConditionService.deleteYwid(ywid);//先删除再保存
//        System.out.println("ywid:" + ywid);
//        System.out.println("tjcode:" + tjcode);
//        for (int i = 0; i < idsArr.length; i++) {
//            System.out.println("添加添加的数据：" + idsArr[i]);
//            dYwCondition = new DYwCondition();
//            dYwCondition.setYwId(tjcode);
//            dYwCondition.setPConId(idsArr[i]);
//            dYwConditionService.save(dYwCondition);
//        }
//        addMessage(redirectAttributes, "分配成功 ");
//        return "redirect:" + adminPath + "/city/dYwinfo/ywsx?id=" + ywid;
//    }

    /*
     * 保存业务信息
     */
//    @RequestMapping(value = "ywInfoSave")
//    public String ywInfoSave(String ywid, String bz, String gzr, String ywnr, String state, RedirectAttributes redirectAttributes) {
//        System.out.println("bz/1:" + bz);
//        System.out.println("bz/2:" + gzr);
//        System.out.println("bz/3:" + ywnr);
//        System.out.println("bz/4:" + state);
//        DYwinfo dyw = new DYwinfo();
//        dyw.setId(ywid);
//        dyw.setConment(ywnr);//业务内容
//        dyw.setState(state);
//        dyw.setDay(gzr);
//        dyw.setRemarks(bz);
//        dYwinfoService.updateywid(dyw);
//        addMessage(redirectAttributes, "保存成功!");
//        return "redirect:" + adminPath + "/city/dYwinfo/ywsx?id=" + ywid;
//    }

    /*
      * todo 保存业务信息
      */
    @RequestMapping(value = "ywInfoSaven")
    public String testListSave(String ywid, String bz, String gzr, String ywnr, String state, RedirectAttributes redirectAttributes) {
        System.out.println("bz/1:" + bz);
        System.out.println("bz/2:" + gzr);
        System.out.println("bz/3:" + ywnr);
        System.out.println("bz/4:" + state);
        DYwinfo dyw = new DYwinfo();
        dyw.setId(ywid);
        dyw.setConment(ywnr);//业务内容
        dyw.setState(state);
        dyw.setDay(gzr);
        dyw.setRemarks(bz);
        dYwinfoService.updateywid(dyw);
        addMessage(redirectAttributes, "保存成功!");
        return "redirect:" + adminPath + "/city/dYwinfo/ywsxn?id=" + ywid;
    }

    /*
     * 查询条件下面的材料
     * 点击编辑材料查询业务材料
     */
    @RequestMapping(value = "tjcailiao")
    public String tjCaiLiao(Model model, String conditionid) {
        System.out.println("conditionid:" + conditionid);
        List<PMaterialCate> listPM = pMaterialCateService.findAll();//材料

        System.out.println(listPM.size());

        List<PMaterialinfo> listPMInfo = PMaterialinfoService.qConditionCl(conditionid);//条件下面的材料
        model.addAttribute("listPM", listPM);
        model.addAttribute("listPMInfo", listPMInfo);
        model.addAttribute("selectIds", Collections3.extractToString(listPMInfo, "id", ","));
        return "modules/gtxt/city/selectCltiaojian";
    }


    /*
     * 条件材料分配保存
     */
    @RequestMapping(value = "tjcailiaosave")
    public String tjCaiLiaoSave(String[] idsArrstj, String conditionid, String ywid, RedirectAttributes redirectAttributes) {
        DConditionMaterial dConditionMaterial;
        dConditionMaterialService.deletetj(conditionid);//先删除再保存
        for (int i = 0; i < idsArrstj.length; i++) {
            System.out.println("添加添加的数据：" + idsArrstj[i]);
            dConditionMaterial = new DConditionMaterial();
            dConditionMaterial.setDConId(conditionid);
            dConditionMaterial.setPMateId(idsArrstj[i]);
            dConditionMaterialService.save(dConditionMaterial);
        }
        addMessage(redirectAttributes, "分配成功 ");
        return "redirect:" + adminPath + "/city/dYwinfo/ywsx?id=" + ywid;
    }

    @RequestMapping(value = "ztreeData")
    public String ztreeData() {
        return "modules/gtxt/city/ztreeData";
    }
}