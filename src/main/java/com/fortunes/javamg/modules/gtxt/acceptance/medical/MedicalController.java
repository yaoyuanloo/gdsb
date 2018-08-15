package com.fortunes.javamg.modules.gtxt.acceptance.medical;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.neusoft.dubbo.interfaces.OutInterface;
import com.powersi.biz.commbiz.outland.dto.OutDTO;
import com.fortunes.javamg.common.utils.IdGen;
import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwatter;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwinfo;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwtab;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwtabService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfo;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfocb;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinput;
import com.fortunes.javamg.modules.gtxt.gt.entity.YwMateinfo;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfocbService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinputService;
import com.fortunes.javamg.modules.gtxt.gt.service.YwMateinfoService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialinfoService;
import com.fortunes.javamg.modules.gtxt.utils.GtxtUitls;
import com.fortunes.javamg.modules.sys.entity.Dict;
import com.fortunes.javamg.modules.sys.utils.UserUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * Created by cxd on 2016/9/6.
 */
@Controller
@RequestMapping(value = "${adminPath}/gtxt/accept/medical")
public class MedicalController extends BaseController {

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

//    @Resource
//    private OutInterface outInterface;

    @RequestMapping(value = "accept")
    public String accept(String type, String ywid, String hzdh, String slhzh, Model model) {
        String path = "", typeName = "", pcode = "";
        boolean checkMultiLabel = false;
        List<Map<String, String>> types = Lists.newArrayList();
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
        if ("zybx".equals(type)) {
            checkMultiLabel = false;
            String[] typeNames = {"市内住院", "市外住院", "生育补助", "一次性转诊", "责任分担", "震波碎石", "他院检查", "门诊放疗化疗", "血透", "普通住院", "外伤、急诊住院"};
            for (int i = 0; i < typeNames.length; i++) {
                map = new HashMap<String, String>();
                map.put("id", String.valueOf(i));
                map.put("name", typeNames[i]);
                types.add(map);
            }
            path = "modules/gtxt/acceptance/medical/department";
        } else if ("stjz".equals(type)) {
            typeName = "视同建账";
            checkMultiLabel = false;
            String[] typeNames = {"建账", "变更"};
            for (int i = 0; i < typeNames.length; i++) {
                map = new HashMap<String, String>();
                map.put("id", String.valueOf(i));
                map.put("name", typeNames[i]);
                types.add(map);
            }
            path = "modules/gtxt/acceptance/medical/accounts";
        } else if ("mzbx".equals(type)) {
            checkMultiLabel = false;
            String[] typeNames = {"门诊报销", "自费项目报销"};
            for (int i = 0; i < typeNames.length; i++) {
                map = new HashMap<String, String>();
                map.put("id", String.valueOf(i));
                map.put("name", typeNames[i]);
                types.add(map);
            }
            path = "modules/gtxt/acceptance/medical/clinic";
        } else if ("lzyd".equals(type)) {
            boolean operatecheckMultiLabel = false;
            typeName = "业务分类";
            checkMultiLabel = false;
            String[] typeNames = {"常住异地人员管理", "用人单位指派外地工作人员", "个人身份参保", "离退休人员", "港澳们及外籍人员"};
            for (int i = 0; i < typeNames.length; i++) {
                map = new HashMap<String, String>();
                map.put("id", String.valueOf(i));
                map.put("name", typeNames[i]);
                types.add(map);
            }
            boolean operateMultiLabel = false;
            String operateName = "操作分类";
            Map<String, String> operatemap;
            List<Map<String, String>> operatetypes = new ArrayList<Map<String, String>>();
            String[] operateNames = {"登记", "注销", "修改"};
            for (int i = 0; i < operateNames.length; i++) {
                operatemap = new HashMap<String, String>();
                operatemap.put("id", String.valueOf(i));
                operatemap.put("name", typeNames[i]);
                operatetypes.add(operatemap);
            }
            model.addAttribute("operatetypes", operatetypes);
            model.addAttribute("operateMultiLabel", operateMultiLabel);
            path = "modules/gtxt/acceptance/medical/longLivenotPlace";
        } else if ("ydinput".equals(type)) {  //异地就医申请登记
            typeName = "异地就医申请登记";
            checkMultiLabel = false;
            path = "modules/gtxt/acceptance/medical/ydinput";
            Map outlistMap = Maps.newHashMap();
            outlistMap.put("aac001", "1000710388");
//            List outlist = outInterface.getOutList(outlistMap);
            OutDTO outDTO = new OutDTO();
            outDTO.setAac001("1000710388");
            outDTO.setBke088("YDQR2020150322003");
            outDTO.setAkc030("测试");
//            int booint = outInterface.insertOutInfo(outDTO);
//            System.out.println("----------- "+booint);
//            System.out.println(outlist);
        }  else {
            model.addAttribute("content", "不可识别流转配置！");
            return "/modules/gtxt/utils/test";
        }
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
        return path;
    }

    /**
     * @param jsoninfo
     * @param gtYwinfo
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "save")
    public String save(GtYwinfo gtYwinfo, String nextywid, String jsoninfo, String cls, String teamwork, String active, Model model, RedirectAttributes redirectAttributes) throws IOException {
        String ywlsh = IdGen.randomLongString();
        if (StringUtils.isBlank(gtYwinfo.getSlhzh()))
            gtYwinfo.setSlhzh(IdGen.randomLongString());
        if (StringUtils.isBlank(gtYwinfo.getHzdh()))
            gtYwinfo.setHzdh(IdGen.randomLongString());

        if(StringUtils.isNotBlank(cls)) {
            List<YwMateinfo> clList = new ArrayList<>();
            YwMateinfo ywMateinfo;
            ObjectMapper mapper = new ObjectMapper();
            List<String> clsData = mapper.readValue(StringEscapeUtils.unescapeHtml4(cls), List.class);
            for (String s : clsData) {
                ywMateinfo = new YwMateinfo(ywlsh, s);
                clList.add(ywMateinfo);
            }
            ywMateinfoService.save(clList);
        }

        GtYwinput gtYwinput = new GtYwinput();
        gtYwinput.setJsoninfo(jsoninfo);
        gtYwinput.setYwlsh(ywlsh);
        gtYwinput.setLczt("LCB000");
        gtYwinputService.save(gtYwinput);

        gtYwinfo.setYwlsh(ywlsh);
        gtYwinfo.setLczt("LCB000");
        gtYwinfo.setFpzt(new Dict("0", ""));
        gtYwinfo.setSlr(UserUtils.getUser());
        gtYwinfo.setSlqy("Z100");
        gtYwinfo.setFqbh("Z100");
        gtYwinfo.setCjdate(new Date());
        gtYwinfo.setSbfs(new Dict("0", "窗口业务"));
        gtYwinfoService.save(gtYwinfo);

        if (StringUtils.isNotBlank(nextywid)) {
            DYwinfo dYwinfo = dYwinfoService.get(nextywid);
            redirectAttributes.addAttribute(YWLSH, ywlsh);
            if (gtYwinfo.getYwid().equals(nextywid))
                redirectAttributes.addAttribute(SLHZH, gtYwinfo.getSlhzh());
            redirectAttributes.addAttribute(HZDH, gtYwinfo.getHzdh());
            return "redirect:" + adminPath + GtxtUitls.htmlUnescape(dYwinfo.getPywinfo().getAcceptaddress()) + "&ywid=" + dYwinfo.getId();
        }

        String flowcode, shjbcode;
        DYwatter dYwatter;

        List<GtYwinfo> checkHzList = gtYwinfoService.findByHzdh(gtYwinfo.getHzdh());
        if(checkHzList != null && checkHzList.size() > 0){
            for(GtYwinfo g : checkHzList){
                GtYwinfocb gtYwinfocb = new GtYwinfocb();
                gtYwinfocb.setYwlsh(g.getYwlsh());
                gtYwinfocb.setYwlc("LCB000");
                gtYwinfocb.setClyj("数据已提交");
                gtYwinfocb.setClr(gtYwinfocb.getCurrentUser());
                gtYwinfocbService.save(gtYwinfocb);
            }
        }
        if(StringUtils.isNotBlank(teamwork) && "1".equals(teamwork.trim())){
            dYwatter = dYwatterService.getByYwId(active);
            flowcode = dYwatter.getFlowcode().getValue();
            shjbcode = dYwatter.getShjbcode().getValue();

            GtYwinfo teamWorkGtYwinfo = new GtYwinfo();
            teamWorkGtYwinfo.setYwid(active);
            teamWorkGtYwinfo.setSynergy("1");
            teamWorkGtYwinfo.setHzdh(gtYwinfo.getHzdh());
            gtYwinfoService.updateSynergyByYwidHzdh(teamWorkGtYwinfo);
        } else {
            if(checkHzList != null && checkHzList.size() > 1){
                flowcode = "1";
                shjbcode = "3";
            }else{
                dYwatter = dYwatterService.getByYwId(gtYwinfo.getYwid());
                flowcode = dYwatter.getFlowcode().getValue();
                shjbcode = dYwatter.getShjbcode().getValue();
            }
        }

        if (shjbcode.equals("1")) {
            redirectAttributes.addAttribute(YWLSH, ywlsh);
            redirectAttributes.addAttribute(HZDH, gtYwinfo.getHzdh());
            return "redirect:" + adminPath + "/city/dWrittempinfo/dyyl";
        } else if (shjbcode.equals("2") || shjbcode.equals("3") || shjbcode.equals("4") || shjbcode.equals("5")) {
            if ("1".equals(flowcode)) {
                redirectAttributes.addAttribute(YWLSH, ywlsh);
                redirectAttributes.addAttribute(HZDH, gtYwinfo.getHzdh());
                return "redirect:" + adminPath + "/city/dWrittempinfo/dyyl";
            } else if ("2".equals(flowcode)) {
                redirectAttributes.addAttribute(YWLSH, ywlsh);
                redirectAttributes.addAttribute(HZDH, gtYwinfo.getHzdh());
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
























