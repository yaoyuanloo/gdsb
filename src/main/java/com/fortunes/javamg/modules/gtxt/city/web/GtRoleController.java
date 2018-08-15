/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.web;

import java.util.List;

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
import com.fortunes.javamg.modules.gtxt.city.entity.DYwinfo;
import com.fortunes.javamg.modules.gtxt.city.entity.GtRole;
import com.fortunes.javamg.modules.gtxt.city.entity.GtSlroleDjyw;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoService;
import com.fortunes.javamg.modules.gtxt.city.service.GtRoleService;
import com.fortunes.javamg.modules.gtxt.city.service.GtSlroleDjywService;
import com.fortunes.javamg.modules.sys.entity.Office;
import com.fortunes.javamg.modules.sys.utils.UserUtils;

/**
 * 柜台受理角色管理Controller
 * @author 万
 * @version 2016-09-07
 */
@Controller
@RequestMapping(value = "${adminPath}/city/gtRole")
public class GtRoleController extends BaseController {

	@Autowired
	private DYwinfoService dYwinfoService;
	
	@Autowired
	private GtRoleService gtRoleService;
	
	@Autowired
	private GtSlroleDjywService gtsolrdjywService;
	
	@ModelAttribute
	public GtRole get(@RequestParam(required=false) String id) {
		GtRole entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gtRoleService.get(id);
		}
		if (entity == null){
			entity = new GtRole();
		}
		return entity;
	}
	
	@RequiresPermissions("city:gtRole:view")
	@RequestMapping(value = {"list", ""})
	public String list(GtRole gtRole,String jsname,HttpServletRequest request, HttpServletResponse response, Model model) {
		gtRole.setName(jsname);
		Page<GtRole> page = gtRoleService.findPage(new Page<GtRole>(request, response), gtRole); 
		model.addAttribute("page", page);
		model.addAttribute("jsname", jsname);
		return "modules/gtxt/city/gtRoleList";
	}

	@RequiresPermissions("city:gtRole:view")
	@RequestMapping(value = "form")
	public String form(GtRole gtRole, Model model) {
		gtRole.setZone(UserUtils.getUser().getCompany().getId());
		model.addAttribute("gtRole", gtRole);
		return "modules/gtxt/city/gtRoleForm";
	}
	@RequiresPermissions("city:gtRole:view")
	@RequestMapping(value = "shouquan")
	public String shouquan(Office office,GtRole gtrole, HttpServletRequest request,HttpServletResponse response,Model model) {
	/*	System.out.println("ssss"+gtrole);
		office.setId(request.getParameter("office.id"));
		office.setName(request.getParameter("office.name"));
		*/
	List<GtSlroleDjyw> getSlr=gtsolrdjywService.findYwListByRoleId(gtrole.getId());
       StringBuffer  sr=new StringBuffer();
		for (GtSlroleDjyw gtSlroleDjyw : getSlr) {
        sr.append(gtSlroleDjyw.getYwId().getId()+",");
		}
		 model.addAttribute("ywIdsRole",sr);
		 model.addAttribute("gtrole", gtrole);
		model.addAttribute("checked", true);
		return "modules/gtxt/city/sysDefSlroleForm2";
	}
	
	@RequiresPermissions("city:gtRole:edit")
	@RequestMapping(value = "save")
	public String save(GtRole gtRole, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gtRole)){
			return form(gtRole, model);
		}
		gtRoleService.save(gtRole);
		addMessage(redirectAttributes, "保存柜台受理角色管理成功");
		return "redirect:"+Global.getAdminPath()+"/city/gtRole/?repage";
	}
	
	@RequiresPermissions("city:gtRole:edit")
	@RequestMapping(value = "delete")
	public String delete(GtRole gtRole, RedirectAttributes redirectAttributes) {
		gtRoleService.delete(gtRole);
		addMessage(redirectAttributes, "删除柜台受理角色管理成功");
		return "redirect:"+Global.getAdminPath()+"/city/gtRole/?repage";
	}
	/*
	 * 受理角色与业务关系表
	 */
	@RequiresPermissions("city:gtRole:edit")
	@RequestMapping(value = "savedi")
	public String savedi(GtRole gtrole,String id,String ywIds, Model model, RedirectAttributes redirectAttributes) {
		

      
		//User user = UserUtils.getUser();
		//sysDefSlrole.setQyId(user.getCompany().getId());

		//sysDefSlrole.setQyId(UserUtils.getUser().getId());
		
		//删除此角色下的所有业务ID。在重新添加
		 gtsolrdjywService.deleteYwInfoListByRoleId(gtrole.getId());
		//添加
		 String ywid[] =gtrole.getYwIds().split(",");
		for (String s : ywid) {
			System.out.println(s);
			GtSlroleDjyw  ry=new GtSlroleDjyw();
			ry.setRoleid(gtrole.getId());
			DYwinfo  dy=new DYwinfo();
			dy.setId(s);
			ry.setYwId(dy);
			gtsolrdjywService.saveRoleidYwid(ry);
		}
		addMessage(redirectAttributes, "保存定制受理角色成功");
		return "redirect:"+Global.getAdminPath()+"/city/gtRole/?repage";
	}
	
	/*@RequiresPermissions("user")---treedatacheckInfo 20160908
    @ResponseBody
    @RequestMapping(value = "treeDataCheckInfo")
    public List<Map<String, Object>> treeDataCheckInfo(@RequestParam(required = false) String extId, @RequestParam(required = false) String type, HttpServletResponse response) {
        List<Map<String, Object>> mapList = Lists.newArrayList();
        Ywinfo y = new Ywinfo();
        y.setType(type);
        List<Ywinfo> list = ywinfoService.findList(y);
        Organization organization = organizationService.search(UserUtils.getUser().getCompany());
        if (organization != null && organization.getYwList() != null) {
            List<Ywinfo> ywList = organization.getYwList();
            String ids = "";
            for (Ywinfo yw : ywList) {
                ids += yw.getParentIds();
                ids += yw.getId() + ",";
            }
            for (int i = 0; i < list.size(); i++) {
                Ywinfo e = list.get(i);
                if (ids.indexOf("," + e.getId() + ",") > -1 && (StringUtils.isBlank(extId) || (extId != null && !extId.equals(e.getId()) && e.getParentIds().indexOf("," + extId + ",") == -1))) {
                    Map<String, Object> map = Maps.newHashMap();
                    map.put("id", e.getId());
                    map.put("pId", e.getParentId());
                    //map.put("pIds", e.getParentIds());
                    map.put("name", e.getName());
                    mapList.add(map);
                }
            }

        }
        return mapList;
    }*/

}