package com.fortunes.javamg.modules.gtxt.Register;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortunes.javamg.common.utils.StringUtils;
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
import com.fortunes.javamg.modules.gtxt.gt.service.YwMateinfoService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialinfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fortunes.javamg.common.web.BaseController;
//import com.neusoft.sl.si.basicinfo.bpo.employee.familydubbo.ContactDTODubbo;
//import com.neusoft.sl.si.basicinfo.bpo.employee.familydubbo.FamilyDubbo;
//import com.neusoft.sl.si.basicinfo.bpo.employee.familydubbo.FamilyParamDubboDTO;
//import com.neusoft.sl.si.basicinfo.bpo.employee.familydubbo.FamilyResultDubboDTO;
//import com.neusoft.sl.si.basicinfo.bpo.employee.familydubbo.OrgInsuranceDTODubbo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanyanhong on 2016/9/15.
 */

@Controller
@RequestMapping(value = "${adminPath}/gtxt/Register")
public class RegisterController extends BaseController{

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
//   @Resource
//    private FamilyDubbo familyDubbo;

    /**
     * 登记--家庭参保申报-受理页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"famillyDeclare"})
    public String famillyDeclare(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "modules/gtxt/Register/famillyDeclareSL";
    }


    /**
     * 登记--居民家庭登记-受理页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"homeDeclare"})
    public String homeDeclare(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "modules/gtxt/Register/homeDeclareSL";
    }
    /*
     * 居民家庭登记 受理信息查询
     */
    @ResponseBody
    @RequestMapping(value = {"homeDeclareSelect"})
    public Map<String,String> homeDeclareSelect(String type,String zjhm) {
    	System.out.println("居民家庭登记--------------");
//    	//家庭登记查询(受理)
//    	FamilyParamDubboDTO  familyParamDubboDTO = new FamilyParamDubboDTO();
//    	familyParamDubboDTO.setAAC058(type);//证件类型
//    	familyParamDubboDTO.setAAC147(zjhm);//证件号码
//    	FamilyResultDubboDTO familyResultDubboDTO2 = null;
//    	 familyResultDubboDTO2 =familyDubbo.queryFamilyInfoByTypeAndCode(familyParamDubboDTO);
//        System.out.println("==========familyResultDubboDTO.isBizSuccess()="+familyResultDubboDTO2.isBizSuccess());
//        System.out.println("受理保存结束--------------");
        Map<String,String> map = new HashMap<String, String>();
//        map.put("aab400",familyResultDubboDTO2.getAAB400());
//        map.put("aac058", familyResultDubboDTO2.getAAC058());
//        map.put("aac147", familyResultDubboDTO2.getAAC147());
//        map.put("aac010", familyResultDubboDTO2.getAAC010());
    	return map;
    }
    /*
     * 居民家庭登记 受理信息查询
     */
    @RequestMapping(value = {"homeDeclareSave"})
    public Map<String,String> homeDeclareSave() {
//    	System.out.println("居民家庭登记--------------");
//    	//家庭登记查询(受理)
//    	FamilyParamDubboDTO  familyParamDubboDTO = new FamilyParamDubboDTO();
//       //家庭登记保存(受理)  
//       
//        familyParamDubboDTO.setAAB400("we");/**  户主姓名 */
//        familyParamDubboDTO.setAAB401("1222");/*** 户口簿编号*/
//        familyParamDubboDTO.setAAC058("01"); /** * 户主证件类型*/
//        familyParamDubboDTO.setAAC147("110101198001010053");
////        familyParamDubboDTO.setBAB100((long)12);
//        familyParamDubboDTO.setAAE013("12");
//        ContactDTODubbo contact = new ContactDTODubbo();
//        contact.setAAE005("1211111111");
//        familyParamDubboDTO.setContactDTO(contact);;
//        OrgInsuranceDTODubbo org = new OrgInsuranceDTODubbo();
//        org.setAAE140("390");
////        org.setAAB050((long)20161017);
//        org.setAAB051("1");
//        org.setBAA140("30");    
//        List<OrgInsuranceDTODubbo> orgInsuranceDTOList = new ArrayList<OrgInsuranceDTODubbo>();
//        orgInsuranceDTOList.add(org);
//        familyParamDubboDTO.setOrgInsuranceDTOList(orgInsuranceDTOList);
//       
////       FamilyResultDubboDTO familyResultDubboDTO = familyDubbo.executeRegisterFamily(familyParamDubboDTO);
////        System.out.println("==========familyResultDubboDTO.isBizSuccess()="+familyResultDubboDTO.isBizSuccess());
//        System.out.println("受理保存结束--------------");
        Map<String,String> map = new HashMap<String, String>();
//        map.put("aab400",familyResultDubboDTO2.getAAB400());
//        map.put("aac058", familyResultDubboDTO2.getAAC058());
//        map.put("aac010", familyResultDubboDTO2.getAAC010());
    	return map;
    }
    /**
     * 登记--未成年个人参保申报-受理页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"yangmenDeclare"})
    public String yangmenDeclare(String ywid, String hzdh, String slhzh, Model model) {
        String path = "", pcode = "";
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
        model.addAttribute("types", types);
        model.addAttribute("checkMultiLabel", checkMultiLabel);
        model.addAttribute("ywatter", dYwatter);
        model.addAttribute("ywinfo", dYwinfo);
        model.addAttribute("cailiaoList", materialinfos);
        model.addAttribute("tabs", tabs);
        return "modules/gtxt/Register/yangmenDeclareSL";
    }
    /**
     * 登记--未成年单位登记-受理页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"ymCompanyDeclare"})
    public String ymCompanyDeclare(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "modules/gtxt/Register/ymcompanyDeclareSL";
    }

    /**
     * 登记--在校学生参保申报-受理页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"studentDeclare"})
    public String studentDeclare(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "modules/gtxt/Register/studentDeclareSL";
    }

  
}
