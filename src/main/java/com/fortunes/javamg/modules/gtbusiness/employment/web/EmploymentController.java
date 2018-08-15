package com.fortunes.javamg.modules.gtbusiness.employment.web;

import com.fortunes.javamg.common.web.BaseController;
//import cn.sinobest.jycyzjgl.object.vo.qyxnshbxbt.QyxnsbbtCkslSmParamVo;
//import cn.sinobest.jycyzjgl.object.vo.qyxnshbxbt.QyxnsbbtCkslSmResultVo;
//import cn.sinobest.jycyzjgl.service.qyxnshbxbt.cksl.iface.IQyxnsbbtCkslSmService;
//import com.powersi.biz.commbiz.outland.dto.HospDTO;
//import com.powersi.biz.commbiz.outland.dto.OutLandResultDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 华资
 */
@Controller
@RequestMapping(value = "${adminPath}/gtxtbusiness/employment")
public class EmploymentController extends BaseController {

//    @Resource
//    private IQyxnsbbtCkslSmService iqyxnsbbtCkslSmService;
//    @Resource
//    private OutLandInterface outLand;
//    @Resource
//    private PersonnelArchiveService personnelArchive;

    /**
     *
     */
    @RequestMapping(value = "getPages")
    public String getPages(String idCard, String idNo) {

//        //  GtxtListResult<Map<String, Object>> fs= personnelArchive.returnQueryByArchiveCode("201609270098");
//
//        OutLandResultDTO outLandParamDto = new OutLandResultDTO();
//
////        OutLandParamDTO ParamDto = new OutLandParamDTO();
////        ParamDto.setAac001("1057179797");
////        ParamDto.seta
//        List<HospDTO> host=new ArrayList<>();
//        HospDTO  st=new HospDTO();
//        st.setAac001("12321321");
//        host.add(st);
//        outLandParamDto.setList(host);

        return "modules/gtbusiness/employment/indextest";
    }
    @RequestMapping(value = "addSmsj")
    public String addSmsj(String idCard, String idNo) {
//        QyxnsbbtCkslSmParamVo vo = new QyxnsbbtCkslSmParamVo();
//        vo.setYwlsh("111");
//        vo.setYwlb("222");
//        vo.setSmlsh("333");
//        QyxnsbbtCkslSmResultVo fs = iqyxnsbbtCkslSmService.addSmsj(vo);
//        System.out.println(fs);
//
        return "modules/gtbusiness/employment/indextest";
    }

}























