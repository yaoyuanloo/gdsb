/**
 *
 */
package com.fortunes.javamg.modules.gtxt.acceptance.pension;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortunes.gtxt.dubbo.GtxtBeanResult;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwatter;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwinfo;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwtab;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwtabService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfo;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfocbService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinputService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialinfoService;

import com.google.common.collect.Maps;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.param.PersonParamDubboDTO;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.result.PersonResultDubboListDTO;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.service.PersonDubboService;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020105.params.JudgePrepareInfoInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020105.params.JudgePrepareInfoOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020105.vs.F14020105Service;
import com.yinhai.dubbo.common.AbstractResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.modules.sys.entity.User;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020102.F14020102Service;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020102.params.PersonInfoInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020102.params.PersonInfoOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020102.params.SpecialWorkInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020102.params.SpecialWorkOutputParams;
import com.wondersgroup.local.qyyl.q1.f14020102.vo.TsgzExpVO;
import com.wondersgroup.wssip.bc.interfacebenefitmgmt.publicrelationsmgr.model.dto.PersonBaseInfoDTO;

/**
 * 测试Controller
 *
 * @version 2013-10-17
 */
@Controller
@RequestMapping(value = "${adminPath}/gtxt/accept/pension")
public class PensionController extends BaseController {

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

//    @Autowired
    private F14020102Service dubboVS;

    @Autowired
    private PersonDubboService personService;

//    @Autowired
    F14020105Service monthRetireCheckService;

    //
    @RequestMapping(value = {"list"})
    public String list() {
        return "modules/gtxt/acceptance/pension/stjzList";
    }

    //视同建账受理
    @RequestMapping(value = {"stjzListSl"})
    public String stjzListSl(String type, Model model) {

        type = "stjz";
        String typeName = "养老视同建账";
        String path = "";
        boolean checkMultiLabel = false;
        List<Map<String, String>> types = new ArrayList<Map<String, String>>();
        Map<String, String> map;
        String[] typeNames = {"建账", "变更"};
        for (int i = 0; i < typeNames.length; i++) {
            map = new HashMap<String, String>();
            map.put("id", String.valueOf(i));
            map.put("name", typeNames[i]);
            types.add(map);
        }
        //path = "modules/gtxt/pension/normalchange";
        model.addAttribute("type", type);
        model.addAttribute("typename", typeName);
        model.addAttribute("types", types);
        model.addAttribute("checkMultiLabel", checkMultiLabel);
        // return "modules/gtxt/acceptance/pension/pensonsinglecount";


        return "modules/gtxt/acceptance/pension/stjzList";
    }

    //视同建账受理(万达)
    @RequestMapping(value = {"stjz"})
    public String stjz(String type, Model model) {

        return "modules/gtxt/acceptance/pension/shitongjianzhang";
    }

    //养老待遇核定受理
    @RequestMapping(value = {"verifyListSL"})
    public String verifyListSL() {
        return "modules/gtxt/acceptance/pension/verifyList";
    }

    //退休死亡待遇核定受理
    @RequestMapping(value = {"retireDeathTreat"})
    public String retireDeathTreat() {
        return "modules/gtxt/acceptance/pension/retireDeathTreat";
    }

    //养老个人账户结算
    @RequestMapping(value = {"pensonsinglecountSl"})
    public String pensonsinglecountSl(String type, Model model) {

        String typeName = "养老个人账户分类";
        String path = "";
        boolean checkMultiLabel = false;
        List<Map<String, String>> types = new ArrayList<Map<String, String>>();
        Map<String, String> map;
        String[] typeNames = {"丧失国籍", "在职死亡", "多地参保个人账户清理", "退休人员结算"};
        for (int i = 0; i < typeNames.length; i++) {
            map = new HashMap<String, String>();
            map.put("id", String.valueOf(i));
            map.put("name", typeNames[i]);
            types.add(map);
        }
        //path = "modules/gtxt/pension/normalchange";
        model.addAttribute("type", type);
        model.addAttribute("typename", typeName);
        model.addAttribute("types", types);
        model.addAttribute("checkMultiLabel", checkMultiLabel);
        return "modules/gtxt/acceptance/pension/pensonsinglecount";

    }

    //一般人员建帐审核
    @RequestMapping(value = {"normalSh"})
    public String normallist() {
        return "modules/gtxt/examine/window/pension/normal";
    }

    //特殊人群建帐审核
    @RequestMapping(value = {"specialSh"})
    public String specialSh() {
        return "modules/gtxt/examine/window/pension/special";
    }

    //一般人员建账变更
    @RequestMapping(value = {"normalchangeSh"})
    public String normalchangeSh(String type, Model model) {

        String typeName = "一般人员建账变更";
        String path = "";
        boolean checkMultiLabel = false;
        List<Map<String, String>> types = new ArrayList<Map<String, String>>();
        Map<String, String> map;
        String[] typeNames = {"转入补建账", "一般人群变特殊人群"};
        for (int i = 0; i < typeNames.length; i++) {
            map = new HashMap<String, String>();
            map.put("id", String.valueOf(i));
            map.put("name", typeNames[i]);
            types.add(map);
        }
        //path = "modules/gtxt/pension/normalchange";
        model.addAttribute("type", type);
        model.addAttribute("typename", typeName);
        model.addAttribute("types", types);
        model.addAttribute("checkMultiLabel", checkMultiLabel);
        return "modules/gtxt/examine/window/pension/normalchange";

    }

    //特殊人员建账变更审核
    @RequestMapping(value = {"specialchangeSh"})
    public String specialchangeSh(String type, Model model) {
        String typeName = "特殊人员建账变更";
        String path = "";
        boolean checkMultiLabel = false;
        List<Map<String, String>> types = new ArrayList<Map<String, String>>();
        Map<String, String> map;
        String[] typeNames = {"特殊人群变一般人群", "特殊人群补建账"};
        for (int i = 0; i < typeNames.length; i++) {
            map = new HashMap<String, String>();
            map.put("id", String.valueOf(i));
            map.put("name", typeNames[i]);
            types.add(map);
        }
        //path = "modules/gtxt/pension/normalchange";
        model.addAttribute("type", type);
        model.addAttribute("typename", typeName);
        model.addAttribute("types", types);
        model.addAttribute("checkMultiLabel", checkMultiLabel);

        return "modules/gtxt/examine/window/pension/specialchange";
    }

    //养老业务待遇审核
    @RequestMapping(value = {"pensionTreatmentSh"})
    public String pensionTreatmentSh() {
        return "modules/gtxt/examine/window/pension/pensionTreatment";
    }

    //退休死亡待遇核定审核
    @RequestMapping(value = {"retireDeathTreatSh"})
    public String retireDeathTreatSh() {
        return "modules/gtxt/examine/window/pension/retireDeathTreatSh";
    }

    ////养老个人结算审核
    @RequestMapping(value = {"pensonsinglecountSh"})
    public String pensonsinglecountSh() {
        return "modules/gtxt/examine/window/pension/pensonsinglecountSh";
    }

    //视同建账变更受理
    @RequestMapping(value = {"stjzchangeList"})
    public String stjzchangeList() {
        return "modules/gtxt/acceptance/pension/stjzchangeList";
    }

    //特殊工种认定
    @RequestMapping(value = {"IdSpecialWorkList"})
    public String IdSpecialWorkList(String type, String ywid, String hzdh, String slhzh, Model model) {
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
        return "modules/gtxt/acceptance/pension/IdSpecialWorkList";
    }

    //特殊工种认定    受理  基本信息查询
    @ResponseBody
    @RequestMapping(value = {"IdSpecialWorkSelect"})
    public Map<String, Object> IdSpecialWorkSelect(String dnh, String sfzh) {
        //查询基本信息
        PersonInfoInputParams perSonInfoInputParams = new PersonInfoInputParams();
        perSonInfoInputParams.setAac002(dnh);
        perSonInfoInputParams.setAac147(sfzh);
        PersonInfoOutputParams perSonInfoOutParams = dubboVS.getPersonInfo(perSonInfoInputParams);
        Map<String, Object> map = Maps.newHashMap();
        if (true == perSonInfoOutParams.isBizSuccess()) {
            PersonBaseInfoDTO personBaseInfoDTO = perSonInfoOutParams.getPersonBaseInfoDTO();
            System.out.println("返回信息：" + personBaseInfoDTO + "--" + perSonInfoOutParams.getErrorCode() + "----" + perSonInfoOutParams.isBizSuccess() + "---" + perSonInfoOutParams.getMessage());
            if (null != personBaseInfoDTO) {
                try {
                    map = PropertyUtils.describe(personBaseInfoDTO);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
//                map.put("aac004", personBaseInfoDTO.getAac004() != null ? personBaseInfoDTO.getAac004() : "");  //性别
//                map.put("aac002", personBaseInfoDTO.getAac002() != null ? personBaseInfoDTO.getAac002() : "");  //社保卡号
//                map.put("aac147", personBaseInfoDTO.getAac147() != null ? personBaseInfoDTO.getAac147() : "");  //身份证号
//                map.put("aae004", personBaseInfoDTO.getAae004() != null ? personBaseInfoDTO.getAae004() : "");
//                map.put("aae005", personBaseInfoDTO.getAae005() != null ? personBaseInfoDTO.getAae005() : "");
//                map.put("aac067", personBaseInfoDTO.getAac067() != null ? personBaseInfoDTO.getAac067() : "");
//                map.put("aac002", personBaseInfoDTO.getAac002() != null ? personBaseInfoDTO.getAac002() : "");
//                map.put("aac003", personBaseInfoDTO.getAac003() != null ? personBaseInfoDTO.getAac003() : "");
//                map.put("aac147", personBaseInfoDTO.getAac147() != null ? personBaseInfoDTO.getAac147() : "");
//                map.put("aac004", personBaseInfoDTO.getAac004() != null ? personBaseInfoDTO.getAac004() : "");
//                map.put("aac006", personBaseInfoDTO.getAac006().toString() != null ? personBaseInfoDTO.getAac006().toString() : "");
//                map.put("aac007", personBaseInfoDTO.getAac007().toString() != null ? personBaseInfoDTO.getAac007().toString() : "");
//                map.put("aae006", personBaseInfoDTO.getAae006() != null ? personBaseInfoDTO.getAae006() : "");
//                map.put("aac001", personBaseInfoDTO.getAac001().toString() != null ? personBaseInfoDTO.getAac001().toString() : ""); //人员ID
//                map.put("aaa027", personBaseInfoDTO.getAaa027() != null ? personBaseInfoDTO.getAaa027() : "");//统筹区编码
            } else {
                System.out.println("返回信息：" + perSonInfoOutParams.getErrorCode() + "----" + perSonInfoOutParams.isBizSuccess() + "---" + perSonInfoOutParams.getMessage());
            }
        }
        return map;
    }

    /**
     * 特殊工种认定 审核 保存
     * <p>
     * TsgzExpVO实体包含以下字段:
     * String   aae041Date; //开始日期
     * String   aae042Date; //截止日期
     * String   aac001;     //人员ID
     * Long     aae200;     //月数
     * String   aab004;     //单位名称
     * String   aab019;     //所属行业
     * String   baz125;     //文件依据
     * String   aaa027;     //统筹区编码
     * String   aac019;     //工种类型
     */
    @ResponseBody
    @RequestMapping(value = {"IdSpecialWorkSave"})
    public Map<String, String> IdSpecialWorkSave(String info) {
        List<TsgzExpVO> list = new ArrayList<TsgzExpVO>();
        String json2 = info.replaceAll("&quot;", "\"");
        JSONObject object = JSONObject.fromObject(json2);
        SpecialWorkInputParams specialWorkI = new SpecialWorkInputParams();
        specialWorkI.setAac001(("".equals(object.getString("aac001"))) ? 0 : object.getLong("aac001"));
        specialWorkI.setAae013(object.getString("aae013").trim());
        try {
            String inputs = object.getString("inputs").trim();
            String tabList = inputs.substring(1, inputs.length() - 1);
            JSONArray array = JSONArray.fromObject(tabList);
            for (int i = 0; i < array.size(); i++) { //把list封装进TsgzExpVO
                JSONObject object2 = array.getJSONObject(i);
                TsgzExpVO tsgz = new TsgzExpVO();
                String aae041Date = object2.getString("t2").trim();
                String aae042Date = object2.getString("t3").trim();
                tsgz.setAae041Date(aae041Date);//开始日期
                tsgz.setAae042Date(aae042Date);//结束日期
                tsgz.setAac001(object.getString("aac001").trim());//人员ID
                tsgz.setAae200(getMonth(aae041Date, aae042Date));//月数
                tsgz.setAab004(object2.getString("t4").trim());//单位名称
                tsgz.setAab019(object2.getString("t5").trim());//所属行业
                tsgz.setBaz125(object2.getString("t6").trim());//文件依据
                tsgz.setAaa027(object.getString("aaa027").trim());//统筹区编码
                tsgz.setAac019(object2.getString("t7").trim());//工种类型
                list.add(tsgz);
                specialWorkI.setTsgzExpList(list);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        SpecialWorkOutputParams workOut = dubboVS.saveTsgzInfo(specialWorkI);
        System.out.println("---------" + workOut.getErrorCode() + "-----" + workOut.isBizSuccess() + "-----" + workOut.getMessage());

        Map<String, String> map = new HashMap<String, String>();
        if (null != workOut && workOut.isBizSuccess() == true) {
            map.put("mess", "success");
        } else {
            map.put("mess", "error");
        }
        return map;
    }

    @RequestMapping(value = "monthretirecheck")
    public String monthRetireCheck() {

        return "modules/gtxt/acceptance/pension/monthRetireCheck";
    }

    @ResponseBody
    @RequestMapping(value = "monthretirecheckfind")
    public Object monthRetireCheckFind(PersonParamDubboDTO person) {
        PersonResultDubboListDTO personList = personService.queryPersonInfoAc01(person);
        if(!personList.isBizSuccess()) {
            return new GtxtBeanResult(personList.isBizSuccess(), personList.getErrorCode(), personList.getMessage());
        }
        JudgePrepareInfoInputParams inputParams = new JudgePrepareInfoInputParams();
        inputParams.setAac001(1000001348L);
        inputParams.setAaa027("440000");
        inputParams.setAac007Str("19920301");
        return monthRetireCheckService.judgePrepareInfo(inputParams);
    }

    @RequestMapping(value = "print")
    public String pringRetireCard() {
        return "modules/gtxt/acceptance/pension/pringretirecard";
    }

    public static long getMonth(String starDate, String endDate) {//日期格式为YYYYMM
        int yearS = Integer.parseInt(starDate.substring(0, 4));
        int yearE = Integer.parseInt(endDate.substring(0, 4));
        int monthS = Integer.parseInt(starDate.substring(4));
        int monthE = Integer.parseInt(endDate.substring(4));
        if (monthE >= monthS)
            return (monthE - monthS) + (yearE - yearS) * 12;
        else
            return (yearE - yearS) * 12 - (monthS - monthE);
    }

}
