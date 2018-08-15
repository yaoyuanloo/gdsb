/**
 *
 */
package com.fortunes.javamg.modules.gtxt.gt.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortunes.javamg.modules.gtxt.city.entity.DYwatter;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfocb;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfocbService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PYwinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PYwinfoService;
import com.fortunes.javamg.modules.gtxt.utils.GtxtUitls;
import com.fortunes.javamg.modules.sys.entity.Dict;
import com.fortunes.javamg.modules.sys.entity.Menu;
import com.fortunes.javamg.modules.sys.entity.User;
import com.fortunes.javamg.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fortunes.javamg.common.config.Global;
import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfo;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.fortunes.javamg.modules.sys.service.SystemService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 柜台业务受理表Controller
 * @author Yang
 * @version 2016-09-09
 */
@Controller
@RequestMapping(value = "${adminPath}/gt/gtYwinfo")
public class GtYwinfoController extends BaseController {
    @Autowired
    private PYwinfoService pYwinfoService;
	@Autowired
	private GtYwinfoService gtYwinfoService;

	@Autowired
	private SystemService systemService;

    @Autowired
    private DYwatterService  dYwatterService;

	@Autowired
	private GtYwinfocbService  gtYwinfocbService;
	@ModelAttribute
	public GtYwinfo get(@RequestParam(required=false) String id) {
		GtYwinfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gtYwinfoService.get(id);
		}
		if (entity == null){
			entity = new GtYwinfo();
		}
		return entity;
	}


	@RequestMapping(value = {"list", ""})
	public String list(GtYwinfo gtYwinfo, HttpServletRequest request, HttpServletResponse response, Model model) {

		Page<GtYwinfo> page = gtYwinfoService.findPage(new Page<GtYwinfo>(request, response), gtYwinfo);

		model.addAttribute("gtYwinfo", gtYwinfo);
		model.addAttribute("page", page);
		return "modules/gtxt/gt/gtYwinfolist";
	}

	@RequestMapping(value = {"detail", ""})
	public String detail(String  ywlsh, HttpServletRequest request, HttpServletResponse response, Model model) {

		GtYwinfo gtywinfo= systemService.findgtYwinfoBylsh(ywlsh).get(0);
		model.addAttribute("gtywinfo",gtywinfo);
		return "modules/gtxt/gt/gtYwinfodetail";
	}


	@RequestMapping(value = "form")
	public String form(GtYwinfo gtYwinfo, Model model) {
		model.addAttribute("gtYwinfo", gtYwinfo);
		return "modules/gtxt/gt/gtYwinfoForm";
	}


	@RequestMapping(value = "save")
	public String save(GtYwinfo gtYwinfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gtYwinfo)){
			return form(gtYwinfo, model);
		}
		gtYwinfoService.save(gtYwinfo);
		addMessage(redirectAttributes, "保存柜台业务受理表成功");
		return "redirect:"+Global.getAdminPath()+"/gtxt/gt/gtYwinfo/?repage";
	}


	@RequestMapping(value = "delete")
	public String delete(GtYwinfo gtYwinfo, RedirectAttributes redirectAttributes) {
		gtYwinfoService.delete(gtYwinfo);
		addMessage(redirectAttributes, "删除柜台业务受理表成功");
		return "redirect:"+Global.getAdminPath()+"/gtxt/gt/gtYwinfo/?repage";
	}


	/**
	 * 二级人员查询未分配业务
	 * @param gtYwinfo
	 * @param redirectAttributes
	 * @return
     */
	@RequestMapping(value = "ywnoTask")
	public String ywnoTask(GtYwinfo gtYwinfo, HttpServletRequest request, HttpServletResponse response,Model model, RedirectAttributes redirectAttributes) {
		User user = UserUtils.getUser();
		//1、根据用户ID查询该用户的业务范围。并且属于归属地为珠海市的。
		Map  map=new HashMap();
		map.put("userId",user.getId());
		map.put("fpzt","1");
		map.put("lczts","LCB005");

		Page<GtYwinfo> page =gtYwinfoService.findYwInfoByUserId(new Page<GtYwinfo>(request, response), map);

        model.addAttribute("gtYwinfo", gtYwinfo);
		model.addAttribute("page",page);
		return "modules/gtxt/gt/assignYwinfolist";
	}


	/**
	 * 柜台审核人员获取业务列表
	 * @param
	 * @param
	 * @return
	 */
	@RequestMapping(value = "ywInfoListPer")
	public String ywInfoListPer(GtYwinfo gtYwinfo, HttpServletRequest request, HttpServletResponse response,Model model, RedirectAttributes redirectAttributes) {
		User user = UserUtils.getUser();
		//1、根据用户ID查询该用户的业务范围。并且属于归属地为珠海市的。
	 	//gtYwinfo.setShry(user);
      //  gtYwinfo.setLczt("LCB004");
		String sql="and A.SHR='"+user.getId()+"' AND A.FPZT='2' and A.LCZT<>'LCB007' OR ( A.SLR = '"+user.getId()+"' AND A.FPZT='0')";
		gtYwinfo.getSqlMap().put("dsf",sql);
		Page<GtYwinfo> page = new Page<GtYwinfo>(request, response);
		page.setOrderBy("cjdate DESC");
		page = gtYwinfoService.findPage(page, gtYwinfo);
		model.addAttribute("gtYwinfo", gtYwinfo);
		model.addAttribute("page",page);
		return "modules/gtxt/gt/ywinfotasklist";
	}

    /**
	 * 点击获取任务
	 * @param gtYwinfo
	 * @param request
	 * @param response
	 * @param model
	 * @param redirectAttributes
     * @return
     */
	@RequestMapping(value = "getywInfoListPer")
	public String getywInfoListPer(GtYwinfo gtYwinfo, HttpServletRequest request, HttpServletResponse response,Model model, RedirectAttributes redirectAttributes) {
		User user = UserUtils.getUser();
		//1、根据用户ID查询该用户的业务范围。并且属于归属地为珠海市的。
		//gtYwinfo.setShry(user);
		gtYwinfo=new GtYwinfo();
		gtYwinfo.setFpzt(new Dict("1",""));
		GtYwinfo  gtywinfos=gtYwinfoService.findywinfoPre(gtYwinfo);
		if(gtywinfos!=null){
			gtywinfos.setShry(user);
            Dict  dict=new Dict();
            dict.setValue("2");
            gtywinfos.setFpzt(dict);
            gtywinfos.setLczt("LCB004");
			gtYwinfoService.save(gtywinfos);
			addMessage(redirectAttributes, "成功获取一条业务单");
		}else{
			addMessage(redirectAttributes, "暂无任务");
		}
		return "redirect:"+Global.getAdminPath()+"/gt/gtYwinfo/ywInfoListPer";

	}
	/**
	 * 二级审核跳转
	 * @param
	 * @param
	 * @return
	 */
	@RequestMapping(value = "ywinfoBoShpage")
	public String ywinfoBoShpage(GtYwinfo gtYwinfo, HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		GtYwinfo gt = gtYwinfoService.getByYwlsh(gtYwinfo.getYwlsh());
		DYwatter dYwatter = dYwatterService.getByYwId(gt.getYwid());
		//去复审
		model.addAttribute("gtinfo", gt);
		return "modules/gtxt/gt/rechecksp";
		}

    /**
     * 审核跳转
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "ywinfoShpage")
    public String ywinfoShpage(GtYwinfo gtYwinfo, HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		GtYwinfo gt = gtYwinfoService.getByYwlsh(gtYwinfo.getYwlsh());
		DYwatter dYwatter = dYwatterService.getByYwId(gt.getYwid());
		if (gt.getFpzt().getValue().equals("2") && gt.getLczt().equals("LCB005")) {
		//	if (dYwatter.getShjbcode().getValue().equals("3") || dYwatter.getShjbcode().getValue().equals("4") || dYwatter.getShjbcode().getValue().equals("5")) {
				//去复审
				model.addAttribute("gtinfo", gt);
				return "modules/gtxt/gt/recheck";
			//}
		} else {
			PYwinfo pywinfo = pYwinfoService.findYwinfoListBydiYwId(gt.getYwid());
			if (pywinfo != null && pywinfo.getAcceptaddress() != null) {
				System.out.println(Global.getAdminPath() + pywinfo.getExamineaddress());
				return "redirect:" + Global.getAdminPath() + GtxtUitls.htmlUnescape(pywinfo.getExamineaddress()) + "&ywlsh=" + gtYwinfo.getYwlsh();
			}
		}
		return null;
	}


	/**
	 * 业务审批列表
	 * @param gtYwinfo
	 * @param request
	 * @param response
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "getYwsp")
	public String getYwsp(GtYwinfo gtYwinfo, HttpServletRequest request, HttpServletResponse response,Model model, RedirectAttributes redirectAttributes) {

		//gtYwinfo.setShry(user);
		User user = UserUtils.getUser();
		//1、根据用户ID查询该用户的业务范围。并且属于归属地为珠海市的。
	//	Map  map=new HashMap();
		//map.put("userId",user.getId());
		//	map.put("lczt","LCB007");
		GtYwinfo  gt=new GtYwinfo();
		gt.setLczt("LCB006");
	Page<GtYwinfo> page =gtYwinfoService.findPage(new Page<GtYwinfo>(request, response), gt);
	/*	Map  map=new HashMap();
		//map.put("userId",user.getId());
		map.put("lczt","LCB006");
		Page<GtYwinfo> page =gtYwinfoService.findYwInfoByUserId(new Page<GtYwinfo>(request, response), map);
*/
		//model.addAttribute("gtYwinfo", gt);
		model.addAttribute("page",page);

		return "modules/gtxt/gt/gtYwspList";

	}
	/**
	 * 业务审批
	 * @param gtywinfoCb
	 * @param request
	 * @param response
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "ywsp")
	public String ywsp(GtYwinfocb gtywinfoCb,HttpServletRequest request,  HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		GtYwinfo gt = gtYwinfoService.getByYwlsh(gtywinfoCb.getYwlsh());
		DYwatter dYwatter = dYwatterService.getByYwId(gt.getYwid());
		GtYwinfocb  gtywcb=new GtYwinfocb();
		User user = UserUtils.getUser();

		//二级审批
		if(dYwatter.getShjbcode().getValue().equals("4")){
			//更改业务状态
			gt.setLczt("LCB007");
			gtYwinfoService.save(gt);
			GtYwinfocb  gtcb=new GtYwinfocb();
			gtcb.setYwlsh(gt.getYwlsh());
			gtcb.setClr(user);
			gtcb.setCljg("成功");
			gtcb.setYwlc("LCB007");
			gtcb.setClyj("已审批,并办结");
			gtYwinfocbService.save(gtcb);
			addMessage(redirectAttributes, "业务已审批并办结");

		}

		return "redirect:"+Global.getAdminPath()+"/gt/gtYwinfo/getYwsp";
	}
	/**
	 * 业务复审
	 * @param gtywinfoCb
	 * @param request
	 * @param response
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "ywfs")
	public String ywfs(GtYwinfocb gtywinfoCb,HttpServletRequest request,  HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		GtYwinfo gt = gtYwinfoService.getByYwlsh(gtywinfoCb.getYwlsh());
		DYwatter dYwatter = dYwatterService.getByYwId(gt.getYwid());
		GtYwinfocb  gtywcb=new GtYwinfocb();
		User user = UserUtils.getUser();
		//办结复审
		if(dYwatter.getShjbcode().getValue().equals("3")){
			//更改业务状态
			gt.setLczt("LCB007");
			gtYwinfoService.save(gt);
			GtYwinfocb  gtcb=new GtYwinfocb();
			gtcb.setYwlsh(gt.getYwlsh());
			gtcb.setClr(user);
			gtcb.setCljg("成功");
			gtcb.setYwlc("LCB007");
			gtcb.setClyj("已处理");
			gtYwinfocbService.save(gtcb);
			addMessage(redirectAttributes, "业务已办结");
		}
		//二级审批
		if(dYwatter.getShjbcode().getValue().equals("4")){
			//更改业务状态
			gt.setLczt("LCB006");
			gt.setFpzt(new Dict("3",""));
			gtYwinfoService.save(gt);
			GtYwinfocb  gtcb=new GtYwinfocb();
			gtcb.setYwlsh(gt.getYwlsh());
			gtcb.setClr(user);
			gtcb.setCljg("成功");
			gtcb.setYwlc("LCB006");
			gtcb.setClyj("已复审");
			gtYwinfocbService.save(gtcb);
			addMessage(redirectAttributes, "业务已复审");

		}
		return "redirect:"+Global.getAdminPath()+"/gt/gtYwinfo/ywInfoListPer";
	}

	/**
	 * 跳转业务复审页面
	 * @param gtYwinfo
	 * @param request
	 * @param response
	 * @param model
	 * @param redirectAttributes
     * @return
     */
	@RequestMapping(value = "ywfsPage")
	public String ywfsPage(GtYwinfo gtYwinfo,HttpServletRequest request,  HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		GtYwinfo gt = gtYwinfoService.getByYwlsh(gtYwinfo.getYwlsh());
		DYwatter dYwatter = dYwatterService.getByYwId(gt.getYwid());
		if (gt.getFpzt().getValue().equals("2") && gt.getLczt().equals("LCB005")) {
		//	if (dYwatter.getShjbcode().getValue().equals("3") || dYwatter.getShjbcode().getValue().equals("4") || dYwatter.getShjbcode().getValue().equals("5")) {
				//去复审
				model.addAttribute("gtinfo", gt);
				return "modules/gtxt/gt/recheck";
		//	}
		}
		return null;
	}
    /**
     * 二级人员查询已分配业务
     * @param gtYwinfo
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "ywYesTask")
    public String ywYesTask(GtYwinfo gtYwinfo, HttpServletRequest request, HttpServletResponse response,Model model, RedirectAttributes redirectAttributes) {
        User user = UserUtils.getUser();
        //1、根据用户ID查询该用户的业务范围。并且属于归属地为珠海市的。
        Map  map=new HashMap();
        map.put("userId",user.getId());
        map.put("lczt","LCB004");

        Page<GtYwinfo> page =gtYwinfoService.findYwInfoByUserId(new Page<GtYwinfo>(request, response), map);
        model.addAttribute("gtYwinfo", gtYwinfo);
        model.addAttribute("page",page);
        return "modules/gtxt/gt/assignYwinfolist";
    }


    /**
	 * 分配任务
	 * @param gtYwinfo
	 * @param request
	 * @param response
	 * @param model
	 * @param redirectAttributes
     * @return
     */
	@RequestMapping(value = "toAssign")
	public String toAssign(GtYwinfo gtYwinfo, String id,String name,JsonMap ywlsh,String userList,HttpServletRequest request, HttpServletResponse response,Model model, RedirectAttributes redirectAttributes) {
		Map<String, String> ywls = ywlsh.getMaps();
		User  usid=new User();
		usid.setId(id);
		for (Map.Entry<String, String> entry : ywls.entrySet()){
			GtYwinfo  gt=gtYwinfoService.getByYwlsh(entry.getKey());
			//获取柜台业务
			if(!gt.getLczt().equals("LCB005")) {
				gt.setLczt("LCB004");
			}
			gt.setShry(usid);
            Dict  dict=new Dict();
            dict.setValue("2");
            gt.setFpzt(dict);
			gtYwinfoService.save(gt);
		}

		return "modules/gtxt/gt/assignYwinfolist";
	}



	//}
	@ResponseBody
	@RequestMapping(value = "findxietong")
	public List<GtYwinfo> findGtywinfoByHzdh(String hzdh){
		return gtYwinfoService.findByHzdh(hzdh);
	}


	/**
	 * 获取菜单列表
	 */
	@RequestMapping(value = "meunList")
	public String meunList(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {

		//登记业务 d9c84c5871f8402c9c403c2475273080
		//失业业务 e9caac39cd3a4079b9ad821af991a680
		//养老业务 25f904ffce724f7c9a4ed0c9c58f87e2
		//医疗业务 0541e119ab5944149c4dd818c63e946e

		List<Menu> alllist = UserUtils.getMenuList();

		/*for(Menu m : alllist){
			System.out.println(m.getName() + " : "+ m.getParent().getId());
			if("eda3705747564734b6d2439241674255".equals(m.getParent().getId())){
			}
		}*/
		List dengjiyewu = new ArrayList();
		List shiyeyewu = new ArrayList();
		List yanglaoyewu = new ArrayList();
		List yiliaoyewu = new ArrayList();

		for (int i = 0; i < alllist.size(); i++) {
			Menu menu = (Menu) alllist.get(i);
			String pid = menu.getParentId();
			if (pid.equals("24055919aed04df195e882628c159cd5")) {
				dengjiyewu.add(menu);
			}

			if (pid.equals("e9caac39cd3a4079b9ad821af991a680")) {
				shiyeyewu.add(menu);
			}

			if (pid.equals("25f904ffce724f7c9a4ed0c9c58f87e2")) {
				yanglaoyewu.add(menu);
			}

			if (pid.equals("0541e119ab5944149c4dd818c63e946e")) {
				yiliaoyewu.add(menu);
			}
		}

		model.addAttribute("dengjiyewu", dengjiyewu);
		model.addAttribute("shiyeyewu", shiyeyewu);
		model.addAttribute("yanglaoyewu", yanglaoyewu);
		model.addAttribute("yiliaoyewu", yiliaoyewu);
		return "modules/gtxt/gt/meunList";
	}


}