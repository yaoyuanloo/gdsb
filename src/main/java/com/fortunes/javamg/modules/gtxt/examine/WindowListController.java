package com.fortunes.javamg.modules.gtxt.examine;

import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwatter;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwtab;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwtabService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtSmjinfo;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfo;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfocb;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinput;
import com.fortunes.javamg.modules.gtxt.gt.service.GtSmjinfoService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfocbService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinputService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialinfoService;
import com.fortunes.javamg.modules.sys.entity.Dict;
import org.apache.commons.lang3.StringEscapeUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.*;

/**
 * Created by cxdwe on 2016/9/6.
 */
@Controller
@RequestMapping(value = "${adminPath}/gtxt/examine/window")
public class WindowListController extends BaseController {

    @Autowired
    private DYwinfoService dYwinfoService;
    @Autowired
    private GtYwinfoService gtYwinfoService;
    @Autowired
    private GtYwinfocbService gtYwinfocbService;
    @Autowired
    private GtYwinputService gtYwinputService;
    @Autowired
    private DYwatterService dYwatterService;
    @Autowired
    private PMaterialinfoService pMaterialinfoService;
    @Autowired
    private DYwtabService dYwtabService;
    @Autowired
    private GtSmjinfoService gtSmjinfoService;

    @RequestMapping(value = "list")

    public String list(String type, Model model) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map;
        map = new HashMap<String, String>();
        map.put("name", "住院报销");
        map.put("business", "medical");
        map.put("examine", "department");
        map.put("type", "department");
        map.put("typename", "住院报销");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "异地就医申请登记");
        map.put("business", "medical");
        map.put("examine", "ydinput");
        map.put("type", "ydinput");
        map.put("typename", "异地就医申请登记");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "合并其他险种的住院报销");
        map.put("business", "medical");
        map.put("examine", "mergedepartment");
        map.put("type", "mergedepartment");
        map.put("typename", "合并其他险种的住院报销");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "门诊报销");
        map.put("business", "medical");
        map.put("examine", "clinic");
        map.put("type", "clinic");
        map.put("typename", "门诊报销");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "长住异地人员管理");
        map.put("business", "medical");
        map.put("examine", "longLivenotPlaceSh");
        map.put("type", "longLivenotPlaceSh");
        map.put("typename", "长住异地人员管理");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "生育医疗费报销");
        map.put("business", "birth");
        map.put("examine", "birthmedical");
        map.put("type", "birthmedical");
        map.put("typename", "生育医疗费报销");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "产前检查机构签约变更及剩余额定结算");
        map.put("business", "birth");
        map.put("examine", "beforebirth");
        map.put("type", "beforebirth");
        map.put("typename", "产前检查机构签约变更及剩余额定结算");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "计划生育津贴");
        map.put("business", "birth");
        map.put("examine", "plansubsidy");
        map.put("type", "plansubsidy");
        map.put("typename", "计划生育津贴");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "工伤康复费报销");
        map.put("business", "injury");
        map.put("examine", "recovery");
        map.put("type", "recovery");
        map.put("typename", "工伤康复费报销");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "工伤医疗费报销");
        map.put("business", "injury");
        map.put("examine", "recovery");
        map.put("type", "medical");
        map.put("typename", "工伤医疗费报销");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "工伤死亡待遇核定");
        map.put("business", "injury");
        map.put("examine", "death");
        map.put("type", "death");
        map.put("typename", "工伤死亡待遇核定");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "工伤康复器具费报销");
        map.put("business", "injury");
        map.put("examine", "recoverytool");
        map.put("type", "recoverytool");
        map.put("typename", "工伤康复器具费报销");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "工伤伤残费报销");
        map.put("business", "injury");
        map.put("examine", "invalidism");
        map.put("type", "invalidism");
        map.put("typename", "工伤伤残费报销");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "一次性医疗补助金");
        map.put("business", "injury");
        map.put("examine", "oneoffsubsidy");
        map.put("type", "oneoffsubsidy");
        map.put("typename", "一次性医疗补助金");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "伤残级别更改不补差");
        map.put("business", "injury");
        map.put("examine", "invalidismgrade");
        map.put("type", "invalidismgrade");
        map.put("typename", "伤残级别更改不补差");
        list.add(map);


        map = new HashMap<String, String>();
        map.put("name", "失业待遇发放变更");
        map.put("business", "unempolyment");
        map.put("examine", "dyprovidechangesh");
        map.put("type", "dyprovidechangesh");
        map.put("typename", "失业待遇发放变更");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "失业待遇转入接续");
        map.put("business", "unempolyment");
        map.put("examine", "payInputFllowSH");
        map.put("type", "payInputFllowSH");
        map.put("typename", "失业待遇转入接续");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "失业待遇转入申请");
        map.put("business", "unempolyment");
        map.put("examine", "payInputApplySH");
        map.put("type", "payInputApplySH");
        map.put("typename", "失业待遇转入申请");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "失业待遇转出");
        map.put("business", "unempolyment");
        map.put("examine", "payoutputSH");
        map.put("type", "payoutputSH");
        map.put("typename", "失业待遇转出");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "失业待遇转出申请");
        map.put("business", "unempolyment");
        map.put("examine", "payOutputApplySH");
        map.put("type", "payOutputApplySH");
        map.put("typename", "失业待遇转出申请");
        list.add(map);



        map = new HashMap<String, String>();
        map.put("name", "失业死亡待遇");
        map.put("business", "unempolyment");
        map.put("examine", "diepaySH");
        map.put("type", "diepaySH");
        map.put("typename", "失业死亡待遇");
        list.add(map);



        map = new HashMap<String, String>();
        map.put("name", "失业死亡待遇重核");
        map.put("business", "unempolyment");
        map.put("examine", "unemployDaathchSh");
        map.put("type", "unemployDaathchSh");
        map.put("typename", "失业死亡待遇重核");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "非广东省户籍人员一次性失业保险金重核");
        map.put("business", "unempolyment");
        map.put("examine", "unGuangzhouChSh");
        map.put("type", "unGuangzhouChSh");
        map.put("typename", "非广东省户籍人员一次性失业保险金重核");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "自主创业一次性失业保险金重核");
        map.put("business", "unempolyment");
        map.put("examine", "selfWorkOnce");
        map.put("type", "selfWorkOnce");
        map.put("typename", "自主创业一次性失业保险金重核");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "非广东省户籍人员一次性失业保险金");
        map.put("business", "unempolyment");
        map.put("examine", "nogdProonesuneplaySH");
        map.put("type", "nogdProonesuneplaySH");
        map.put("typename", "非广东省户籍人员一次性失业保险金");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "自主创业一次性失业保险金");
        map.put("business", "unempolyment");
        map.put("examine", "persononesUneplaySH");
        map.put("type", "persononesUneplaySH");
        map.put("typename", "自主创业一次性失业保险金");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "生育加发失业保险金重核");
        map.put("business", "unempolyment");
        map.put("examine", "birthAddUnemploySh");
        map.put("type", "birthAddUnemploySh");
        map.put("typename", "生育加发失业保险金重核");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "生育加发失业保险金");
        map.put("business", "unempolyment");
        map.put("examine", "steadyemploySH");
        map.put("type", "steadyemploySH");
        map.put("typename", "生育加发失业保险金");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "稳定就业一次性失业保险金");
        map.put("business", "unempolyment");
        map.put("examine", "stabllyemploySh");
        map.put("type", "stabllyemploySh");
        map.put("typename", "稳定就业一次性失业保险金");
        list.add(map);
        
        map = new HashMap<String, String>();
        map.put("name", "稳定就业一次性失业保险金重核");
        map.put("business", "unempolyment");
        map.put("examine", "stabllyemployShch");
        map.put("type", "stabllyemployShch");
        map.put("typename", "稳定就业一次性失业保险金重核");
        list.add(map);


        map = new HashMap<String, String>();
        map.put("name", "失业一次性待遇追回");
        map.put("business", "unempolyment");
        map.put("examine", "onespayBackSH");
        map.put("type", "onespayBackSH");
        map.put("typename", "失业一次性待遇追回");
        list.add(map);


        map = new HashMap<String, String>();
        map.put("name", "失业定期待遇追回");
        map.put("business", "unempolyment");
        map.put("examine", "regularpayBackSH");
        map.put("type", "regularpayBackSH");
        map.put("typename", "失业定期待遇追回");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "失业定期待遇重核");
        map.put("business", "unempolyment");
        map.put("examine", "tapprovedAginSH");
        map.put("type", "tapprovedAginSH");
        map.put("typename", "失业定期待遇重核");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "失业个人资料修改");
        map.put("business", "unempolyment");
        map.put("examine", "personinfoUpdateSH");
        map.put("type", "personinfoUpdateSH");
        map.put("typename", "失业个人资料修改");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "养老历史缴费补缴");
        map.put("business", "backUp");
        map.put("examine", "pastureHistorybjSH");
        map.put("type", "pastureHistorybjSH");
        map.put("typename", "养老历史缴费补缴");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "职工应参未参补缴");
        map.put("business", "backUp");
        map.put("examine", "staffsinsuredYesNObjSH");
        map.put("type", "staffsinsuredYesNObjSH");
        map.put("typename", "职工应参未参补缴");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "职工社会保险退费");
        map.put("business", "backUp");
        map.put("examine", "staffssbrebateSH");
        map.put("type", "staffssbrebateSH");
        map.put("typename", "职工社会保险退费");
        list.add(map);



        map = new HashMap<String, String>();
        map.put("name", "部队养老保险关系转出");
        map.put("business", "transter");
        map.put("examine", "armypensionout");
        map.put("type", "armypensionout");
        map.put("typename", "部队养老保险关系转出");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "部队养老保险关系转入");
        map.put("business", "transter");
        map.put("examine", "armypensionIn");
        map.put("type", "armypensionIn");
        map.put("typename", "部队养老保险关系转出");
        list.add(map);


        map = new HashMap<String, String>();
        map.put("name", "部队养老保险关系转入申请");
        map.put("business", "transter");
        map.put("examine", "armypensionapply");
        map.put("type", "armypensionapply");
        map.put("typename", "部队养老保险关系转入申请");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "行业统筹企业养老保险关系转出");
        map.put("business", "transter");
        map.put("examine", "pensionOuthytc");
        map.put("type", "pensionOuthytc");
        map.put("typename", "行业统筹企业养老保险关系转出");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "行业统筹企业养老保险关系转入");
        map.put("business", "transter");
        map.put("examine", "pensionInhytc");
        map.put("type", "pensionInhytc");
        map.put("typename", "行业统筹企业养老保险关系转出");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "跨省失业保险关系转出");
        map.put("business", "transter");
        map.put("examine", "outSunemployout");
        map.put("type", "outSunemployout");
        map.put("typename", "跨省失业保险关系转出");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "跨省失业保险关系转入申请");
        map.put("business", "transter");
        map.put("examine", "outSunemployInApply");
        map.put("type", "outSunemployInApply");
        map.put("typename", "跨省失业保险关系转入申请");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "跨省失业保险关系转入");
        map.put("business", "transter");
        map.put("examine", "outSunemployIn");
        map.put("type", "outSunemployIn");
        map.put("typename", "跨省失业保险关系转入");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "跨省养老保险关系转出");
        map.put("business", "transter");
        map.put("examine", "outSpensionBxout");
        map.put("type", "outSpensionBxout");
        map.put("typename", "跨省失业保险关系转出");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "跨省养老保险关系转入");
        map.put("business", "transter");
        map.put("examine", "outSpensionBxIn");
        map.put("type", "outSpensionBxIn");
        map.put("typename", "跨省养老保险关系转出");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "跨省养老保险关系转入申请");
        map.put("business", "transter");
        map.put("examine", "outSpensionBxLinkInApply");
        map.put("type", "outSpensionBxLinkInApply");
        map.put("typename", "跨省养老保险关系转入申请");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "跨省医疗保险关系转出");
        map.put("business", "transter");
        map.put("examine", "outSyLbXLinkOut");
        map.put("type", "outSyLbXLinkOut");
        map.put("typename", "跨省医疗保险关系转出");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "跨省医疗保险关系转入");
        map.put("business", "transter");
        map.put("examine", "outSyLbXLinkIn");
        map.put("type", "outSyLbXLinkIn");
        map.put("typename", "跨省医疗保险关系转出");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "跨省医疗保险关系转入申请");
        map.put("business", "transter");
        map.put("examine", "outYlBxlinkInApply");
        map.put("type", "outYlBxlinkInApply");
        map.put("typename", "跨省医疗保险关系转入申请");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "省内失业保险关系转出");
        map.put("business", "transter");
        map.put("examine", "inunployeeBxLinkOut");
        map.put("type", "inunployeeBxLinkOut");
        map.put("typename", "省内失业保险关系转出");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "省内失业保险关系转入");
        map.put("business", "transter");
        map.put("examine", "inunployeeBxLinkIn");
        map.put("type", "inunployeeBxLinkIn");
        map.put("typename", "省内失业保险关系转入");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "省内失业保险关系转入申请");
        map.put("business", "transter");
        map.put("examine", "inunemployeeBxApplysh");
        map.put("type", "inunemployeeBxApplysh");
        map.put("typename", "省内失业保险关系转入");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "省内养老保险关系转入申请");
        map.put("business", "transter");
        map.put("examine", "inpensionBxLinkInApply");
        map.put("type", "inpensionBxLinkInApply");
        map.put("typename", "省内失业保险关系转入");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "省内养老保险关系转出");
        map.put("business", "transter");
        map.put("examine", "inSpensionBxout");
        map.put("type", "inSpensionBxout");
        map.put("typename", "省内养老保险关系转出");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "省内养老保险关系转入");
        map.put("business", "transter");
        map.put("examine", "inSpensionBxLinkIn");
        map.put("type", "inSpensionBxLinkIn");
        map.put("typename", "省内养老保险关系转入");
        list.add(map);


        map = new HashMap<String, String>();
        map.put("name", "省内医疗保险关系转出");
        map.put("business", "transter");
        map.put("examine", "inSyLbXLinkOut");
        map.put("type", "inSyLbXLinkOut");
        map.put("typename", "省内医疗保险关系转出");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "省内医疗保险关系转入");
        map.put("business", "transter");
        map.put("examine", "inSyLbXLinkIn");
        map.put("type", "inSyLbXLinkIn");
        map.put("typename", "省内医疗保险关系转入");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "省内医疗保险关系转入申请");
        map.put("business", "transter");
        map.put("examine", "inYlBxLinkInApply");
        map.put("type", "inYlBxLinkInApply");
        map.put("typename", "省内医疗保险关系转入申请");
        list.add(map);



        map = new HashMap<String, String>();
        map.put("name", "居民家庭登记");
        map.put("business", "Register");
        map.put("examine", "famillyDeclareSH");
        map.put("type", "famillyDeclareSH");
        map.put("typename", "居民家庭登记");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "家庭参保申报");
        map.put("business", "Register");
        map.put("examine", "homeDeclareSH");
        map.put("type", "homeDeclareSH");
        map.put("typename", "家庭参保申报");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "未成年个人参保申报");
        map.put("business", "Register");
        map.put("examine", "yangmenDeclareSH");
        map.put("type", "yangmenDeclareSH");
        map.put("typename", "未成年个人参保申报");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "未成年单位登记");
        map.put("business", "Register");
        map.put("examine", "ymcompanyDeclareSH");
        map.put("type", "ymcompanyDeclareSH");
        map.put("typename", "未成年单位登记");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "在校学生参保申报");
        map.put("business", "Register");
        map.put("examine", "studentDeclareSH");
        map.put("type", "studentDeclareSH");
        map.put("typename", "在校学生参保申报");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "未成年单位缴费信息变更");
        map.put("business", "TeenagersInfoCg");
        map.put("examine", "CompanyPaychangeSH");
        map.put("type", "CompanyPaychangeSH");
        map.put("typename", "未成年单位缴费信息变更");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "未成年参保普通信息变更");
        map.put("business", "TeenagersInfoCg");
        map.put("examine", "CompanyPaychangeSH");
        map.put("type", "CompanyPaychangeSH");
        map.put("typename", "未成年参保普通信息变更");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "未成年参保重要信息变更");
        map.put("business", "TeenagersInfoCg");
        map.put("examine", "CompanyPaychangeSH");
        map.put("type", "CompanyPaychangeSH");
        map.put("typename", "未成年参保重要信息变更");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "未成年人国籍变动");
        map.put("business", "TeenagersInfoCg");
        map.put("examine", "CompanyPaychangeSH");
        map.put("type", "CompanyPaychangeSH");
        map.put("typename", "未成年人国籍变动");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "未成年人管理单位变动");
        map.put("business", "TeenagersInfoCg");
        map.put("examine", "CompanyPaychangeSH");
        map.put("type", "CompanyPaychangeSH");
        map.put("typename", "未成年人管理单位变动");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "未成年人缴费信息变动");
        map.put("business", "TeenagersInfoCg");
        map.put("examine", "CompanyPaychangeSH");
        map.put("type", "CompanyPaychangeSH");
        map.put("typename", "未成年人缴费信息变动");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "未成年单位信息变更");
        map.put("business", "TeenagersInfoCg");
        map.put("examine", "CompanychangeSH");
        map.put("type", "CompanychangeSH");
        map.put("typename", "未成年单位信息变更");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "趸缴养老保险费");
        map.put("business", "OnesPaying");
        map.put("examine", "WholesaleSH");
        map.put("type", "WholesaleSH");
        map.put("typename", "趸缴养老保险费");
        list.add(map);

        map = new HashMap<String, String>();
        map.put("name", "趸缴医疗保险费");
        map.put("business", "OnesPaying");
        map.put("examine", "WholesaleSH");
        map.put("type", "WholesaleSH");
        map.put("typename", "趸缴医疗保险费");
        list.add(map);


        map = new HashMap<String, String>();
        map.put("name", "一次性缴纳养老保险费");
        map.put("business", "OnesPaying");
        map.put("examine", "OnesPaypasureSH");
        map.put("type", "OnesPaypasureSH");
        map.put("typename", "一次性缴纳养老保险费");
        list.add(map);

        model.addAttribute("list", list);

        return "modules/gtxt/examine/window/list";
    }

    @RequestMapping(value = "detail")
    public String detail(String ywlsh, String type, String examine, String business, Model model) throws IOException {
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
        return "modules/gtxt/examine/window/" + business + "/" + examine;
    }

    /**
     * @param ywlsh
     * @param jsoninfo
     * flowcode           1 先受理后扫描, 2 先扫描后受理
     * shjbcode           1 打单业务, 2 快捷业务, 3 一级业务, 4 二级业务, 5 三级业务
     * @param model
     * @param redirectAttributes
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "save")
    public String save(String ywlsh, String jsoninfo, Model model, RedirectAttributes redirectAttributes) throws IOException {
        GtYwinput gtYwinput = new GtYwinput();
        gtYwinput.setJsoninfo(jsoninfo);
        gtYwinput.setYwlsh(ywlsh);

        GtYwinfo gtYwinfo = gtYwinfoService.getByYwlsh(ywlsh);
        String oldLczt = gtYwinfo.getLczt();
        gtYwinfo.setYwlsh(ywlsh);

        GtYwinfocb gtYwinfocb = new GtYwinfocb();
        gtYwinfocb.setYwlsh(ywlsh);
        gtYwinfocb.setClyj("业务已初审");
        gtYwinfocb.setClr(gtYwinfocb.getCurrentUser());

        String flowcode, shjbcode;
		DYwatter dYwatter = dYwatterService.getByYwId(gtYwinfo.getYwid());
        flowcode = dYwatter.getFlowcode().getValue();
        shjbcode = dYwatter.getShjbcode().getValue();
        if (shjbcode.equals("1")) {
            gtYwinput.setLczt("LCB007");
            gtYwinputService.save(gtYwinput);

            gtYwinfo.setLczt("LCB007");
            gtYwinfoService.updateLcztByYwlsh(gtYwinfo);

            gtYwinfocb.setYwlc("LCB007");
            gtYwinfocbService.save(gtYwinfocb);

            gtYwinfo.setFpzt(new Dict("2", ""));
            gtYwinfoService.updateFpztByHzdh(gtYwinfo);
            model.addAttribute("content", "业务办理成功！");
            model.addAttribute("finished", true);
            return "/modules/gtxt/utils/test";
        } else if (shjbcode.equals("2")) {
            gtYwinput.setLczt("LCB007");
            gtYwinputService.save(gtYwinput);

            gtYwinfo.setLczt("LCB007");
            gtYwinfoService.updateLcztByYwlsh(gtYwinfo);

            gtYwinfocb.setYwlc("LCB007");
            gtYwinfocbService.save(gtYwinfocb);

            gtYwinfo.setFpzt(new Dict("2", ""));
            gtYwinfoService.updateFpztByHzdh(gtYwinfo);
            model.addAttribute("content", "业务办理成功！");
            model.addAttribute("finished", true);
            return "/modules/gtxt/utils/test";
        } else if (shjbcode.equals("3") || shjbcode.equals("4") || shjbcode.equals("5")) {
            if("LCB004".equals(oldLczt)){
                gtYwinput.setLczt("LCB005");
                gtYwinputService.save(gtYwinput);

                gtYwinfo.setLczt("LCB005");
                gtYwinfoService.updateLcztByYwlsh(gtYwinfo);

                gtYwinfocb.setYwlc("LCB005");
                gtYwinfocbService.save(gtYwinfocb);

                model.addAttribute("content", "业务已初审！");
                model.addAttribute("finished", true);
            }
            return "/modules/gtxt/utils/test";
        } else {
            model.addAttribute("content", "不可识别流转配置！");
            return "/modules/gtxt/utils/test";
        }
    }

}
