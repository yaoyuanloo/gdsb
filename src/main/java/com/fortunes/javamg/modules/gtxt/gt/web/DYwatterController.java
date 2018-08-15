/**
 *
 */
package com.fortunes.javamg.modules.gtxt.gt.web;

import com.fortunes.javamg.common.config.Global;
import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwatter;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwtab;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwtabService;
import com.fortunes.javamg.modules.sys.entity.Dict;
import com.fortunes.javamg.modules.sys.service.DictService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 地级市业务属性Controller
 *
 * @author cxd
 * @version 2016-09-10
 */
@Controller
@RequestMapping(value = "${adminPath}/city/dYwatter")
public class DYwatterController extends BaseController {

    @Autowired
    private DYwatterService dYwatterService;

    @Autowired
    private DictService dictService;

    @Autowired
    private DYwtabService dywtabService;

    @ModelAttribute
    public DYwatter get(@RequestParam(required = false) String id) {
        DYwatter entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = dYwatterService.get(id);
        }
        if (entity == null) {
            entity = new DYwatter();
        }
        return entity;
    }

    @RequiresPermissions("city:dYwatter:view")
    @RequestMapping(value = {"list", ""})
    public String list(DYwatter dYwatter, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<DYwatter> page = dYwatterService.findPage(new Page<DYwatter>(request, response), dYwatter);
        model.addAttribute("page", page);
        return "modules/city/dYwatterList";
    }

    @RequiresPermissions("city:dYwatter:view")
    @RequestMapping(value = "form")
    public String form(DYwatter dYwatter, Model model) {
        model.addAttribute("dYwatter", dYwatter);
        return "modules/city/dYwatterForm";
    }

    @RequiresPermissions("city:dYwatter:edit")
    @RequestMapping(value = "save")
    public String save(DYwatter dYwatter, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, dYwatter)) {
            return form(dYwatter, model);
        }
        dYwatterService.save(dYwatter);
        addMessage(redirectAttributes, "保存地级市业务属性成功");
        return "redirect:" + Global.getAdminPath() + "/city/dYwatter/?repage";
    }


    @RequestMapping(value = "savedi")
    public String savedi(DYwatter dYwatter, String ywid, String dyHzd, String bbmb, String bqcltzd,
                         String hzdmb, String sjhzdmb, String dyBb, String dyJds, Model model, RedirectAttributes redirectAttributes) {
        DYwatter dywatter = dYwatterService.getByYwId(ywid);
        if (dywatter == null) {
            dywatter = new DYwatter();
            dywatter.setYwid(ywid);
            dYwatterService.save(dywatter);
            dywatter = dYwatterService.getByYwId(ywid);
        }
        dYwatter.setYwid(ywid);
        dYwatter.setId(dywatter.getId());
        dYwatterService.save(dYwatter);
        addMessage(redirectAttributes, "保存地级市业务属性成功");
        return "redirect:" + Global.getAdminPath() + "/city/dYwinfo/ywsx?id=" + ywid;
    }



    // TODO: 2016/10/25 0025
    @RequestMapping(value = "savedin")
    public String savedin(DYwatter dYwatter, String ywid, String dyHzd, String bbmb, String bqcltzd,
                          String hzdmb, String sjhzdmb, String dyBb, String dyJds, Model model, RedirectAttributes redirectAttributes) {
        DYwatter dywatter = dYwatterService.getByYwId(ywid);
        if (dywatter == null) {
            dywatter = new DYwatter();
            dywatter.setYwid(ywid);
            dYwatterService.save(dywatter);
            dywatter = dYwatterService.getByYwId(ywid);
        }
        dYwatter.setYwid(ywid);
        dYwatter.setId(dywatter.getId());
        dYwatterService.save(dYwatter);
        addMessage(redirectAttributes, "保存地级市业务属性成功");
        return "redirect:" + Global.getAdminPath() + "/city/dYwinfo/ywsxn?id=" + ywid;
    }

    @RequiresPermissions("city:dYwatter:edit")
    @RequestMapping(value = "delete")
    public String delete(DYwatter dYwatter, RedirectAttributes redirectAttributes) {
        dYwatterService.delete(dYwatter);
        addMessage(redirectAttributes, "删除地级市业务属性成功");
        return "redirect:" + Global.getAdminPath() + "/city/dYwatter/?repage";
    }

    /*
     * 业务——标签表保存
     */
    @RequestMapping(value = "savetab")
    public String savetab(DYwtab ywtab, String ywid, String tabid, Model model, RedirectAttributes redirectAttributes) {
//		DYwinfo  dy=dywinfoDao.getYwid(ywid);
        DYwtab dytab = new DYwtab();
        dytab.setYwid(ywid);
        dywtabService.deleteTabByDiYwId(dytab);

        if (StringUtils.isNotEmpty(tabid)) {
            String tabids[] = tabid.split(",");
            for (String s : tabids) {
                DYwtab dytabf = new DYwtab();
                dytabf.setYwid(ywid);
                dytabf.setQuerytagid(new Dict(s, ""));
                dywtabService.save(dytabf);
            }
        }
        //删除地级市业务和标签绑定表
        addMessage(redirectAttributes, "保存地级市业务属性成功");

        return "redirect:" + Global.getAdminPath() + "/city/dYwinfo/ywsx?id=" + ywid;
    }

    /**
     * todo 业务——标签表保存
     */
    @RequestMapping(value = "savetabn")
    public String savetabn(DYwtab ywtab, String ywid, String tabid, Model model, RedirectAttributes redirectAttributes) {
//		DYwinfo  dy=dywinfoDao.getYwid(ywid);
        DYwtab dytab = new DYwtab();
        dytab.setYwid(ywid);
        dywtabService.deleteTabByDiYwId(dytab);

        if (StringUtils.isNotEmpty(tabid)) {
            String tabids[] = tabid.split(",");
            for (String s : tabids) {
                DYwtab dytabf = new DYwtab();
                dytabf.setYwid(ywid);
                dytabf.setQuerytagid(new Dict(s, ""));
                dywtabService.save(dytabf);
            }
        }
        //删除地级市业务和标签绑定表
        addMessage(redirectAttributes, "保存地级市业务属性成功");

        return "redirect:" + Global.getAdminPath() + "/city/dYwinfo/ywsxn?id=" + ywid;
    }
    /**
     * 查询系统字典
     * @param type
     * @param response
     * @return

     @ResponseBody
     @RequestMapping(value = "treeData")
     public List<Map<String, Object>> treeData(@RequestParam(required=false) String type, HttpServletResponse response) {
     List<Map<String, Object>> mapList = Lists.newArrayList();
     Dict dict = new Dict();
     dict.setType(type);
     List<Dict> list = dictService.findTypebyList(dict);
     for (int i=0; i<list.size(); i++){
     Dict e = list.get(i);
     Map<String, Object> map = Maps.newHashMap();
     map.put("id", e.getId());
     //map.put("pId", e.getParentId());
     map.put("name", e.getLabel());
     mapList.add(map);
     }
     return mapList;
     } */
}