package com.fortunes.javamg.modules.gtbusiness.medical.web;

import com.fortunes.gtxt.dubbo.GtxtListResult;
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
import com.google.common.collect.Maps;
import com.insigma.dubbo.api.PersonnelArchiveService;
//import com.powersi.biz.commbiz.outland.dto.HospDTO;
//import com.powersi.biz.commbiz.outland.dto.OutLandParamDTO;
//import com.powersi.biz.commbiz.outland.dto.OutLandResultDTO;
//import com.powersi.dubbo.OutLandInterface;
import org.apache.commons.lang3.StringEscapeUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * 医疗保险业务
 */
@Controller
@RequestMapping(value = "${adminPath}/gtxtbusiness/medical")
public class MedicalBuController extends BaseController {


//    @Resource
//    private OutLandInterface outLand;
//    @Resource
//    private PersonnelArchiveService personnelArchive;

    /**
     * 异地就医等级查询人员信息
     *//*
    @RequestMapping(value = "getPersInfo")
    @ResponseBody
    public OutLandResultDTO getPersInfo(String idCard, String idNo) {

        //  GtxtListResult<Map<String, Object>> fs= personnelArchive.returnQueryByArchiveCode("201609270098");

        OutLandResultDTO outLandParamDto = new OutLandResultDTO();

//        OutLandParamDTO ParamDto = new OutLandParamDTO();
//        ParamDto.setAac001("1057179797");
//        ParamDto.seta
        List<HospDTO> host=new ArrayList<>();
        HospDTO  st=new HospDTO();
        st.setAac001("12321321");
        host.add(st);
        outLandParamDto.setList(host);

//        OutLandParamDTO ParamDto = new OutLandParamDTO();
//        ParamDto.setAac001("1057179797");
//        resultDto = outLand.getOutInfo(ParamDto);
       // OutLandParamDTO outLandParamDto= new OutLandParamDTO();
//           outLandParamDto.setAac001("1057179797");
//            outLandParamDto.setAac002("460028198602086816");
//            outLandParamDto.setAac003("陈海全");
//            outLandParamDto.setAac004("1");
//            outLandParamDto.setAab001("41300076");
//            outLandParamDto.setAab004("黄浦江制衣(广州)有限公司");
//            outLandParamDto.setAaa027("440113");
//            outLandParamDto.setBke074("1");
//            outLandParamDto.setBke083("5");
//            outLandParamDto.setBke084("杨晴");
//            outLandParamDto.setBke085(new Date());
//            outLandParamDto.setBke086("1029");
//            outLandParamDto.setAae140("310");
//            outLandParamDto.setBke095("1");
//            outLandParamDto.setBke098("20160723");
//            outLandParamDto.setBke099("20160804");
//            outLandParamDto.setBke253("1");
//            outLandParamDto.setBke606("规范的股份规范的股份");
//            outLandParamDto.setBke069("13909876543");
//            outLandParamDto.setBke071("1111111");
//            outLandParamDto.setBke077("fd");
//            outLandParamDto.setYzz013("1");

//            List<HospDTO> lista=new ArrayList<HospDTO>();
//            HospDTO hstp=new HospDTO();
//            hstp.setAkb020("530111304");
//            hstp.setAab069("昆明同仁医院");
//            hstp.setBke301("1");
//            hstp.setAka101("2");
//            hstp.setBke309("10");
//            hstp.setBkc016(Long.parseLong("32"));
//            lista.add(hstp);
//            outLandParamDto.setList(lista);
//            OutLandResultDTO  dtos= outLand.insertOutInfo(outLandParamDto);
            //            OutLandResultDTO  dt=  outLand.getOutInfo(outLandParamDto);
//         System.out.println(dtos);
//        return dtos;
        return outLandParamDto;
    }*/




    /**
     * 异地就医等级查询人员信息
     */
    @RequestMapping(value = "fyMedical")
    public String fyMedical(String idCard, String idNo) {


        return "modules/gtbusiness/medical/fymedical";
    }

}























