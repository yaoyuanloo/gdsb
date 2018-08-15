package com.fortunes.javamg.modules.gtxt.acceptance.birth;

import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwtabService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfocbService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinputService;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cxdwe on 2016/9/8.
 */
@Controller
@RequestMapping(value = "${adminPath}/gtxt/accept/birth")
public class BirthController extends BaseController {

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
    public String accept(String type, Model model){
        String typeName = "";
        String path = "";
        boolean checkMultiLabel = false;
        List<Map<String, String>> types = new ArrayList<Map<String, String>>();
        Map<String, String> map;
        if("syylfbx".equals(type)){
            typeName = "生育医疗费报销";
            checkMultiLabel = false;
            String[] typeNames =  {"分娩", "计生", "产检"};
            for(int i = 0; i < typeNames.length; i++){
                map = new HashMap<String, String>();
                map.put("id", String.valueOf(i));
                map.put("name", typeNames[i]);
                types.add(map);
            }
            path = "modules/gtxt/acceptance/birth/birthmedical";
        } else if("cqjcjgbg".equals(type)){
            typeName = "产前检查机构签约变更及剩余额定结算";
            path = "modules/gtxt/acceptance/birth/beforebirth";
        } else if("jhsyjt".equals(type)){
            typeName = "计划生育津贴";
            path = "modules/gtxt/acceptance/birth/plansubsidy";
        } else if("zyfmjt".equals(type)){
            typeName = "住院分娩津贴";
            path = "modules/gtxt/acceptance/birth/departmentsubsidy";
        } else if("wjypoyc".equals(type)){
            typeName = "未就业配偶孕产费用报销";
            path = "modules/gtxt/acceptance/birth/notemployebirth";
        }
        model.addAttribute("type", type);
        model.addAttribute("typename", typeName);
        model.addAttribute("types", types);
        model.addAttribute("checkMultiLabel", checkMultiLabel);
        return path;
    }
}
