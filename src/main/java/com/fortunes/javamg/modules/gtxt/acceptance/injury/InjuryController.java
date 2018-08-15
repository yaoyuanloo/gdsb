package com.fortunes.javamg.modules.gtxt.acceptance.injury;

import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwatter;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwinfo;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwtab;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwtabService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfo;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinput;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfocbService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinputService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialinfoService;
import com.fortunes.javamg.modules.sys.entity.Dict;
import com.fortunes.javamg.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.*;

/**
 * Created by cxdwe on 2016/9/8.
 */
@Controller
@RequestMapping(value = "${adminPath}/gtxt/accept/injury")
public class InjuryController extends BaseController {

    @Autowired
    private DYwinfoService dYwinfoService;
    @Autowired
    private GtYwinputService gtYwinputService;
    @Autowired
    private GtYwinfoService gtYwinfoService;
    @Autowired
    private GtYwinfocbService gtYwinfocbService;
    @Autowired
    private DYwatterService dYwatterService;
    @Autowired
    private PMaterialinfoService pMaterialinfoService;
    @Autowired
    private DYwtabService dYwtabService;

    @RequestMapping(value = "accept")
    public String accept(GtYwinfo gtYwinfo, String type, String ywid, Model model) {
        String path = "", typeName = "", pcode = "";
        boolean checkMultiLabel = false;
        List<Map<String, String>> types = new ArrayList<Map<String, String>>();
        Map<String, String> map;
        DYwinfo dYwinfo = dYwinfoService.get(ywid);
        DYwatter dYwatter = dYwatterService.getByYwId(ywid);
        List<PMaterialinfo> materialinfos = null;
        List<DYwtab> tabs = null;
        if(dYwinfo != null && StringUtils.isNotBlank(dYwinfo.getId())){
            materialinfos = pMaterialinfoService.queryInfo(dYwinfo.getId());
            tabs = dYwtabService.findYwtabByYwId(dYwinfo.getId());
        }
        if("gskffbx".equals(type)) {
            typeName = "工伤康复费报销";
            checkMultiLabel = false;
            String[] typeNames =  {"违规市外就医", "常住异地", "交通事故", "申请分段报销"};
            for(int i = 0; i < typeNames.length; i++){
                map = new HashMap<String, String>();
                map.put("id", String.valueOf(i));
                map.put("name", typeNames[i]);
                types.add(map);
            }
            path = "modules/gtxt/acceptance/injury/recovery";
        } else if("gsylfbx".equals(type)) {
            checkMultiLabel = false;
            String[] typeNames =  {"违规市外就医", "常住异地", "交通事故", "申请分段报销"};
            for(int i = 0; i < typeNames.length; i++){
                map = new HashMap<String, String>();
                map.put("id", String.valueOf(i));
                map.put("name", typeNames[i]);
                types.add(map);
            }
            path = "modules/gtxt/acceptance/injury/recovery";
        } else if("gsswdyhd".equals(type)) {
            typeName = "工伤死亡待遇核定";
            checkMultiLabel = true;
            String[] typeNames =  {"丧葬补助金", "一次性工亡补助金", "供养亲属抚恤金", "公证委托"};
            for(int i = 0; i < typeNames.length; i++){
                map = new HashMap<String, String>();
                map.put("id", String.valueOf(i));
                map.put("name", typeNames[i]);
                types.add(map);
            }
            path = "modules/gtxt/acceptance/injury/death";
        } else if("gskfqjfbx".equals(type)) {
            typeName = "工伤康复器具费报销";
            path = "modules/gtxt/acceptance/injury/recoverytool";
        } else if("gsscfbx".equals(type)) {
            typeName = "工伤伤残费报销";
            path = "modules/gtxt/acceptance/injury/invalidism";
        } else if("ycxylbzj".equals(type)) {
            typeName = "一次性医疗补助金";
            path = "modules/gtxt/acceptance/injury/oneoffsubsidy";
        } else if("scjbggbbc".equals(type)) {
            typeName = "伤残级别更改不补差";
            path = "modules/gtxt/acceptance/injury/invalidismgrade";
        } else {
            model.addAttribute("content", "不可识别流转配置！");
            return "/modules/gtxt/utils/test";
        }
        model.addAttribute("gtYwinfo", gtYwinfo);
        model.addAttribute("type", type);
        model.addAttribute("typename", typeName);
        model.addAttribute("types", types);
        model.addAttribute("checkMultiLabel", checkMultiLabel);
        model.addAttribute("ywatter", dYwatter);
        model.addAttribute("ywinfo", dYwinfo);
        model.addAttribute("cailiaoList", materialinfos);
        model.addAttribute("tabs", tabs);
        return path;
    }

    /**
     * @param jsoninfo
     * @param flowcode           1 先受理后扫描, 2 先扫描后受理
     * @param shjbcode           1 打单业务, 2 快捷业务, 3 一级业务, 4 二级业务, 5 三级业务
     * @param gtYwinfo
     * @param model
     * @param redirectAttributes
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "save")
    public String save(GtYwinfo gtYwinfo, String jsoninfo, String flowcode, String shjbcode, Model model, RedirectAttributes redirectAttributes) throws IOException {
        String ywlsh = UUID.randomUUID().toString();
        if (StringUtils.isBlank(gtYwinfo.getSlhzh()))
            gtYwinfo.setSlhzh(UUID.randomUUID().toString());
        if (StringUtils.isBlank(gtYwinfo.getHzdh()))
            gtYwinfo.setHzdh(UUID.randomUUID().toString());

        GtYwinput gtYwinput = new GtYwinput();
        gtYwinput.setJsoninfo(jsoninfo);
        gtYwinput.setYwlsh(ywlsh);
        gtYwinput.setLczt("LCB000");
        gtYwinputService.save(gtYwinput);

        gtYwinfo.setYwlsh(ywlsh);
        gtYwinfo.setLczt("LCB000");
        gtYwinfo.setSlr(UserUtils.getUser());
        gtYwinfo.setSlqy("Z100");
        gtYwinfo.setFqbh("Z100");
        gtYwinfo.setCjdate(new Date());
        gtYwinfo.setSbfs(new Dict("0", "窗口业务"));
        gtYwinfoService.save(gtYwinfo);

        if (shjbcode.equals("1")) {
            redirectAttributes.addAttribute(YWLSH, ywlsh);
            return "redirect:" + adminPath + "/city/dWrittempinfo/dyyl";
        } else if (shjbcode.equals("2") || shjbcode.equals("3") || shjbcode.equals("4") || shjbcode.equals("5")) {
            if ("1".equals(flowcode)) {
                redirectAttributes.addAttribute(YWLSH, ywlsh);
                return "redirect:" + adminPath + "/city/dWrittempinfo/dyyl";
            } else if ("2".equals(flowcode)) {
                redirectAttributes.addAttribute(YWLSH, ywlsh);
                return "redirect:" + adminPath + "/gt/gtSmjinfo/list";
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
