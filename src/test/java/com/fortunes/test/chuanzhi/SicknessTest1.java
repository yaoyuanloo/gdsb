package com.fortunes.test.chuanzhi;


import com.fortunes.test.DubboTest;
import com.powersi.biz.medicare.medicareCommbiz.dto.DiseaseDirDTO;
import com.powersi.biz.medicare.medicareReimburse.dto.mediReimCardDTO;
import com.powersi.biz.medicare.medicareReimburse.dto.mediReimDeclareDTO;
import com.powersi.dubbo.entity.DTO.EnpersonDTO;
import com.powersi.dubbo.medicare.auditFee.MedicalAuditInterface;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SicknessTest1 extends DubboTest {


    @Autowired
    MedicalAuditInterface medicalAuditInterface;

    @Test
    public void t6() {
        mediReimCardDTO mrcdto = new mediReimCardDTO();
        Map<String, Object> inMap = new HashMap<String, Object>();
        inMap.put("aab069", "刘嘉喜");
        inMap.put("aaz065", "广州银行");
        inMap.put("aaz003", "123");
        inMap.put("bka151", "临时账户");
        inMap.put("bka148", "未复核");
        inMap.put("aae004", "刘嘉喜");
        inMap.put("aae005", "13367339716");
        inMap.put("aae006", "123");
        inMap.put("aae007", "412302");
        inMap.put("aae013", "");
        inMap.put("aae011", "zzh1");
        inMap.put("aae036", "2016-10-27");
        inMap.put("aae016_name", "已制单");
        inMap.put("bke957_name", "参保人已自行垫付医疗费");
        inMap.put("aae016", "0");
        inMap.put("bka152", "37");
        List lstFee = new ArrayList();
        lstFee.add(inMap);

        mrcdto.setJsonStr(lstFee);
        mrcdto.setAae016("1");

        Map<String, Object> m = medicalAuditInterface.auditReimCardInfo(mrcdto);
        out(m);

    }


}
