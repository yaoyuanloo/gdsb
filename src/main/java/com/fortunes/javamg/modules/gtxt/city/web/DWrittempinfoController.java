/**
 *
 */
package com.fortunes.javamg.modules.gtxt.city.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortunes.javamg.modules.gtxt.city.entity.DWrittemp;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwinfo;
import com.fortunes.javamg.modules.gtxt.city.service.DWrittempService;

import com.fortunes.javamg.modules.gtxt.gt.entity.*;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfocbService;
import com.fortunes.javamg.modules.gtxt.utils.GtxtUitls;
import com.fortunes.javamg.modules.sys.utils.DictUtils;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinputService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.codehaus.jackson.map.ObjectMapper;
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
import com.fortunes.javamg.modules.gtxt.city.entity.DWrittempinfo;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwatter;
import com.fortunes.javamg.modules.gtxt.city.service.DWrittempinfoService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtDictService;
import com.fortunes.javamg.modules.sys.entity.Dict;
import com.fortunes.javamg.modules.sys.service.DictService;

import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文书模板信息表Controller
 *
 * @author YANG
 * @version 2016-09-07
 */
@Controller
@RequestMapping(value = "${adminPath}/city/dWrittempinfo")
public class DWrittempinfoController extends BaseController {

    @Autowired
    private DYwinfoService dYwinfoService;
    @Autowired
    private DWrittempService dWrittempService;
    @Autowired
    private DWrittempinfoService dWrittempinfoService;
    @Autowired
    private GtDictService gtDictService;
    @Autowired
    private DYwatterService dYwatterService;
    @Autowired
    private GtYwinfoService gtYwinfoService;
    @Autowired
    private GtYwinfocbService gtYwinfocbService;
    @Autowired
    private GtYwinputService gtYwinputService;
    @Autowired
    private DictService DictService;

    @ModelAttribute
    public DWrittempinfo get(@RequestParam(required = false) String id) {
        DWrittempinfo entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = dWrittempinfoService.get(id);
        }
        if (entity == null) {
            entity = new DWrittempinfo();
        }
        return entity;
    }

    @RequestMapping(value = {"list", ""})
    public String list(DWrittemp dWrittemp, String mbname,DWrittempinfo dWrittempinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
        dWrittempinfo.setCateId(dWrittemp.getId());
        dWrittempinfo.setName(mbname);
        Page<DWrittempinfo> page = dWrittempinfoService.findPage(new Page<DWrittempinfo>(request, response), dWrittempinfo);
        model.addAttribute("page", page);
        model.addAttribute("dWrittempinfo", dWrittempinfo);
        model.addAttribute("mbname", mbname);
        return "modules/gtxt/city/dWrittempinfoList";
    }


    @RequestMapping(value = "form")
    public String form(DWrittempinfo dWrittempinfo, Model model) {
        dWrittempinfo.setConment(HtmlUtils.htmlUnescape(dWrittempinfo.getConment()));
        model.addAttribute("dWrittempinfo", dWrittempinfo);
        List<DWrittemp> dWrittemp = dWrittempService.findList(new DWrittemp());
        model.addAttribute("dWrittemp", dWrittemp);
        return "modules/gtxt/city/dWrittempinfoForm";
    }


    @RequestMapping(value = "save")
    public String save(DWrittempinfo dWrittempinfo, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, dWrittempinfo)) {
            return form(dWrittempinfo, model);
        }
        dWrittempinfoService.save(dWrittempinfo);
        addMessage(redirectAttributes, "保存文书模板信息表成功");
        return "redirect:" + Global.getAdminPath() + "/city/dWrittempinfo/?repage";
    }

    @RequestMapping(value = "delete")
    public String delete(DWrittempinfo dWrittempinfo, RedirectAttributes redirectAttributes) {
        dWrittempinfoService.delete(dWrittempinfo);
        addMessage(redirectAttributes, "删除文书模板信息表成功");
        return "redirect:" + Global.getAdminPath() + "/city/dWrittempinfo/?repage";
    }

    @RequestMapping(value = "dyyl")
    public String getdyyl(String hzdh, String ywlsh, DWrittempinfo dWrittempinfo, Model model, RedirectAttributes redirectAttributes) throws IOException {
        //  hzdh = "0380ff29f3f14720a4aef8fe44b5c397";
        List<GtYwinfo> gtYwinfos = gtYwinfoService.findByHzdh(hzdh);
        GtYwinfo gtYwinfo = null;
        GtYwinput gtYwinput = null;
        if (gtYwinfos != null) {
            if (gtYwinfos.size() == 1) {
                gtYwinfo = gtYwinfos.get(0);
                gtYwinput = gtYwinputService.getByYwlshLczt(new GtYwinput(gtYwinfo.getYwlsh(), "LCB000"));
            } else {
                for (GtYwinfo g : gtYwinfos) {
                    if ("1".equals(g.getSynergy())) {
                        gtYwinfo = g;
                        gtYwinput = gtYwinputService.getByYwlshLczt(new GtYwinput(gtYwinfo.getYwlsh(), "LCB000"));
                    }
                }
                if (gtYwinfo == null) {
                    //多业务
                    gtYwinfo = gtYwinfos.get(0);
                    gtYwinput = gtYwinputService.getByYwlshLczt(new GtYwinput(gtYwinfo.getYwlsh(), "LCB000"));
                }
            }
        }
        Map<String, Object> jsonData = new HashMap<String, Object>();
        if (gtYwinput != null && StringUtils.isNotBlank(gtYwinput.getJsoninfo())) {
            ObjectMapper mapper = new ObjectMapper();
            jsonData = mapper.readValue(StringEscapeUtils.unescapeHtml4(gtYwinput.getJsoninfo()), Map.class);
        }
        DYwatter dYwatter = dYwatterService.getByYwId(gtYwinfo.getYwid());
        model.addAttribute("gtywinfo", gtYwinfo);
        model.addAttribute("jsonData", jsonData);
        model.addAttribute("dywatter", dYwatter);
//         受理模板编号
        DWrittempinfo slTemp = null;
//         报表模板编号
//        DWrittempinfo bbTemp = null;
//         收件模板编号
        DWrittempinfo sjTemp = null;
//         补齐材料模板编号
        DWrittempinfo bqTemp = null;
        if (dYwatter != null) {
            if (dYwatter.getSlTempid() != null)
                slTemp = dWrittempinfoService.get(dYwatter.getSlTempid());
//            if (dYwatter.getBbTempid() != null)
//                bbTemp = dWrittempinfoService.get(dYwatter.getBbTempid());
            if (dYwatter.getSjTempid() != null)
                sjTemp = dWrittempinfoService.get(dYwatter.getSjTempid());
            if (dYwatter.getBqTempid() != null)
                bqTemp = dWrittempinfoService.get(dYwatter.getBqTempid());
        }
        dWrittempinfo = dWrittempinfoService.get("6d23f779bd384ecbafb5601676a0d311");
        String conment = HtmlUtils.htmlUnescape(dWrittempinfo.getConment());
        model.addAttribute("gtywinfos", gtYwinfos);
        model.addAttribute("gtywinfo", gtYwinfo);
        model.addAttribute("jsondata", jsonData);
        model.addAttribute("atter", dYwatter);
        model.addAttribute("conment", conment);
        model.addAttribute("slTemp", slTemp);
//        model.addAttribute("bbTemp", bbTemp);
        model.addAttribute("sjTemp", sjTemp);
        model.addAttribute("bqTemp", bqTemp);
        return "modules/gtxt/city/dytempinfo";
    }

    /**
     * 获得模板方式
     *
     * @param
     * @param request
     * @param response
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "json")
    public List<Map<String, Object>> json(DWrittempinfo dWrittempinfo, HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Map<String, Object>> mapList = Lists.newArrayList();
        List<DWrittempinfo> list = dWrittempinfoService.finddwrittempinfoist("Z100");
        for (DWrittempinfo y : list) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("id", y.getId());
            map.put("name", y.getName());
            mapList.add(map);
        }
        return mapList;
    }

    @ResponseBody
    @RequestMapping(value = "treeData")
    public List<Map<String, Object>> treeData(@RequestParam(required = false) String type, HttpServletResponse response) {
        List<Map<String, Object>> mapList = Lists.newArrayList();

        List<Dict> list = DictUtils.getDictList("yw_tag");
        for (int i = 0; i < list.size(); i++) {
            Dict e = list.get(i);
            Map<String, Object> map = Maps.newHashMap();
            map.put("id", e.getValue());
            map.put("name", StringUtils.replace(e.getLabel(), " ", ""));
            mapList.add(map);
        }
        return mapList;
    }

    /**
     * flowcode 1 先受理后扫描, 2 先扫描后受理
     * shjbcode 1 打单业务, 2 快捷业务, 3 一级业务, 4 二级业务, 5 三级业务
     *
     * @return
     */
    @RequestMapping(value = "tiaozhuan")
    public String tiaozhuan(String hzdh, String ywlsh, DWrittempinfo dWrittempinfo, Model model, RedirectAttributes redirectAttributes) {
        GtYwinfo gtYwinfo = gtYwinfoService.getByYwlsh(ywlsh);
        gtYwinfo.setYwlsh(ywlsh);
        gtYwinfo.setLczt("LCB001");
        gtYwinfoService.updateLcztByHzdh(gtYwinfo);
        gtYwinfo.setCjdate(new Date());
        gtYwinfoService.updateCjdateByYwlsh(gtYwinfo);

        List<GtYwinfo> gtYwinfos = gtYwinfoService.findByHzdh(hzdh);

        if (gtYwinfos != null && gtYwinfos.size() > 0) {
            for (GtYwinfo g : gtYwinfos) {
                GtYwinfocb gtYwinfocb = new GtYwinfocb();
                gtYwinfocb.setYwlsh(g.getYwlsh());
                gtYwinfocb.setYwlc("LCB001");
                gtYwinfocb.setClyj("业务已受理");
                gtYwinfocb.setClr(gtYwinfocb.getCurrentUser());
                gtYwinfocbService.save(gtYwinfocb);
            }
        }

        gtYwinfo = null;
        if (gtYwinfos != null) {
            if (gtYwinfos.size() == 1) {
                gtYwinfo = gtYwinfos.get(0);
            } else {
                for (GtYwinfo g : gtYwinfos) {
                    if ("1".equals(g.getSynergy())) {
                        gtYwinfo = g;
                    }
                }
                if (gtYwinfo == null) {
                    //多业务
                    gtYwinfo = gtYwinfos.get(0);
                }
            }
        }

        String flowcode, shjbcode;
        DYwatter dYwatter = dYwatterService.getByYwId(gtYwinfo.getYwid());
        flowcode = dYwatter.getFlowcode().getValue();
        shjbcode = dYwatter.getShjbcode().getValue();

        if (shjbcode.equals("1")) {
            gtYwinfo.setFpzt(new Dict("1", ""));
            gtYwinfoService.updateFpztByHzdh(gtYwinfo);
            model.addAttribute("content", "办理结束, 业务已移交至后台！");
            model.addAttribute("finished", true);
            return "/modules/gtxt/utils/test";
        } else if (shjbcode.equals("2")) {
            if ("1".equals(flowcode)) {
                redirectAttributes.addAttribute(YWLSH, ywlsh);
                redirectAttributes.addAttribute(HZDH, hzdh);
                return "redirect:" + adminPath + "/gt/gtSmjinfo/list";
            } else if ("2".equals(flowcode)) {
                DYwinfo dYwinfo = dYwinfoService.get(gtYwinfo.getYwid());
                redirectAttributes.addAttribute(YWLSH, ywlsh);
                redirectAttributes.addAttribute(HZDH, hzdh);
                return "redirect:" + adminPath + GtxtUitls.htmlUnescape(dYwinfo.getPywinfo().getExamineaddress());
            } else {
                model.addAttribute("content", "不可识别流转配置！");
                return "/modules/gtxt/utils/test";
            }
        } else if (shjbcode.equals("3") || shjbcode.equals("4") || shjbcode.equals("5")) {
            if ("1".equals(flowcode)) {
                redirectAttributes.addAttribute(YWLSH, ywlsh);
                 redirectAttributes.addAttribute(HZDH, hzdh);
//                return "redirect:" + adminPath + "/gt/gtSmjinfo/list";
                return "redirect:" + adminPath + "/gt/gtSmjinfo/imagemenu";
            } else if ("2".equals(flowcode)) {
                gtYwinfo.setFpzt(new Dict("1", ""));
                gtYwinfoService.updateFpztByHzdh(gtYwinfo);
                model.addAttribute("content", "办理结束, 业务已移交至后台！");
                model.addAttribute("finished", true);
                return "/modules/gtxt/utils/test";
            } else {
                model.addAttribute("content", "不可识别流转配置！");
                return "/modules/gtxt/utils/test";
            }
        } else {
            model.addAttribute("content", "不可识别流转配置！");
            return "/modules/gtxt/utils/test";
        }

    }

    @RequestMapping(value = "showlist")
    public String showlist(String hzdh, String ywlsh, DWrittempinfo dWrittempinfo, Model model, RedirectAttributes redirectAttributes) {
        return "/modules/gtxt/utils/test";
    }


}