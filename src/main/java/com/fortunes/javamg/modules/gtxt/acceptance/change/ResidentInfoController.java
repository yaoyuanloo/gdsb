package com.fortunes.javamg.modules.gtxt.acceptance.change;

import com.fortunes.gtxt.dubbo.GtxtBeanResult;
import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwatter;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwinfo;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwtab;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwtabService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtSmjinfo;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfo;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinput;
import com.fortunes.javamg.modules.gtxt.gt.service.*;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialinfoService;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.param.PersonParamDubboDTO;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.result.PersonResultDubboListDTO;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.service.PersonDubboService;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.param.ResidentRegisterParam;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.result.ResidentRegisterResult;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.service.ResidentManageDubboService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cxd on 2016/11/3 0003.
 */
@Controller
@RequestMapping(value = "${adminPath}/gtxt/accept/residentinfo")
public class ResidentInfoController extends BaseController {

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
    @Autowired
    private YwMateinfoService ywMateinfoService;
    @Autowired
    private GtSmjinfoService gtSmjinfoService;

    @Autowired
    private PersonDubboService personService;

    @Autowired
    private ResidentManageDubboService residentService;

    @RequestMapping(value = "change")
    public String toChange(String type, String ywid, String hzdh, String slhzh, Model model) {
        String path = "", typeName = "", pcode = "";
        boolean checkMultiLabel = false;
        List<Map<String, String>> types = new ArrayList<Map<String, String>>();
        Map<String, String> map;
        DYwinfo dYwinfo = dYwinfoService.get(ywid);
        DYwatter dYwatter = dYwatterService.getByYwId(ywid);
        List<PMaterialinfo> materialinfos = null;
        List<DYwtab> tabs = null;
        if (dYwinfo != null && StringUtils.isNotBlank(dYwinfo.getId())) {
            materialinfos = pMaterialinfoService.queryInfo(dYwinfo.getId());
            tabs = dYwtabService.findYwtabByYwId(dYwinfo.getId());
        }
        List<GtYwinfo> gtYwinfos = gtYwinfoService.findByHzdh(hzdh);
        model.addAttribute("gtywinfos", gtYwinfos);
        model.addAttribute("hzdh", hzdh);
        model.addAttribute("slhzh", slhzh);
        model.addAttribute("type", type);
        model.addAttribute("typename", typeName);
        model.addAttribute("types", types);
        model.addAttribute("checkMultiLabel", checkMultiLabel);
        model.addAttribute("ywatter", dYwatter);
        model.addAttribute("ywinfo", dYwinfo);
        model.addAttribute("cailiaoList", materialinfos);
        model.addAttribute("tabs", tabs);
        return "modules/gtxt/acceptance/change/residentInfoChange";
    }

    @RequestMapping(value = "changeexamine")
    public String changeExamine(String ywlsh, String type, String examine, String business, Model model) throws IOException {
        GtYwinfo gtYwinfo = gtYwinfoService.getByYwlsh(ywlsh);
        GtYwinput gtYwinput = gtYwinputService.getByYwlshLczt(new GtYwinput(ywlsh, "LCB000"));
        Map<String, Object> jsonData;
        if (gtYwinput == null || (gtYwinput != null && gtYwinput.getJsoninfo() == null)) {
            jsonData = new HashMap<String, Object>();
        } else {
            ObjectMapper mapper = new ObjectMapper();
            jsonData = mapper.readValue(StringEscapeUtils.unescapeHtml4(gtYwinput.getJsoninfo()), Map.class);
        }
        List<PMaterialinfo> materialinfos = null;
        List<DYwtab> tabs = null;
        if(StringUtils.isNotBlank(gtYwinfo.getYwid())){
            materialinfos = pMaterialinfoService.queryInfo(gtYwinfo.getYwid());
            tabs = dYwtabService.findYwtabByYwId(gtYwinfo.getYwid());
        }
        DYwatter dYwatter = dYwatterService.getByYwId(gtYwinfo.getYwid());
        List<GtSmjinfo> gtSmjinfos = gtSmjinfoService.queryLsh(ywlsh);
        model.addAttribute("gtywinfo", gtYwinfo);
        model.addAttribute("jsonData", jsonData);
        model.addAttribute("dywatter", dYwatter);
        model.addAttribute("smjs", gtSmjinfos);
        model.addAttribute("type", type);
        model.addAttribute("cailiaoList", materialinfos);
        model.addAttribute("tabs", tabs);
        return "modules/gtxt/examine/window/change/residentInfoChange";
    }

    @ResponseBody
    @RequestMapping(value = "searchperson")
    public Object searchPerson(PersonParamDubboDTO person) {
        PersonResultDubboListDTO personList = personService.queryPersonInfoAc01(person);
        if (!personList.isBizSuccess()) {
            return new GtxtBeanResult(personList.isBizSuccess(), personList.getErrorCode(), personList.getMessage());
        }
        return personList;
    }

    /**
     * aac001 人员id
     * aac006 出生日期
     * aac003 姓名
     * aac004 联系人
     * aac005 民族
     * aac058 证件类型
     * aac147 证件号码
     *
     * @param importListDTO
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "changesave")
    public Object changeSave(ResidentRegisterParam importListDTO) {
        try {
            System.out.println("aac001 : "+BeanUtils.getProperty(importListDTO, "aac001"));
            System.out.println("aac006 : "+BeanUtils.getProperty(importListDTO, "aac006"));
            System.out.println("aac003 : "+BeanUtils.getProperty(importListDTO, "aac003"));
            System.out.println("aac004 : "+BeanUtils.getProperty(importListDTO, "aac004"));
            System.out.println("aac005 : "+BeanUtils.getProperty(importListDTO, "aac005"));
            System.out.println("aac058 : "+BeanUtils.getProperty(importListDTO, "aac058"));
            System.out.println("aac147 : "+BeanUtils.getProperty(importListDTO, "aac147"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        ResidentRegisterResult residresult = residentService.dubboResidentModify(importListDTO);
        return residresult;
    }

}
