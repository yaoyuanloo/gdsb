package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.F14020301ServiceVS;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.params.*;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cxdwe on 2016/10/28 0028.
 */
public class UnemploymentDeathTreatmentTest extends DubboTest {
    @Autowired
    F14020301ServiceVS service;

    /**
     *
     */
    @Test
    public void test() {
        //死亡一次性待遇查询
        RetireDeathQueryInputParams input = new RetireDeathQueryInputParams();
        input.setAac001(1000000001L);
        input.setAae160("6401");
        RetireDeathQueryOutputParams output = this.service.retireDeathInfoQuery(input);

        // 一次性待遇计算
        RetireDeathCalcInputParams input2 = new RetireDeathCalcInputParams();
        BeanUtils.copyProperties(output, input2);
        input2.setAae160("6401");
        input2.setAic301(201611L);
        input2.setBaa605("1");
        input2.setBaa606("0");
        input2.setBae243("0");
        RetireDeathCalcOutputParams output2 = this.service.retireDeathBenefitCalc(input2);

        // 死亡一次性待遇信息保存.
        RetireDeathSaveInputParams input3 = new RetireDeathSaveInputParams();
        BeanUtils.copyProperties(output, input3);
        BeanUtils.copyProperties(input2, input3);
        BeanUtils.copyProperties(output2, input3);
        input3.setTerminalDetailList(output2.getDetailList());
        BankDTO bankdto = new BankDTO();
        bankdto.setAaa079("2");
        bankdto.setAae009("张三");
        bankdto.setAae010("1111111111111111111");
        bankdto.setAae140("110");
        bankdto.setAae145("11");
        bankdto.setAae147("1");
        bankdto.setBae118("102");
        bankdto.setAaa027("440000");
        bankdto.setAac001(1000000001L);
        bankdto.setAaz010(1000000001L);
        bankdto.setAae016("0");
        input3.setBankVO(bankdto);
        input3.setAae160("6401");
        input3.setAab001(100000389L);
        input3.setAaa171("4");
        input3.setYqdkkxy("1");
        input3.setAaa076("13");
        RetireDeathSaveOutputParams output3 = this.service.retireDeathInfoSave(input3);
        out(output3);
    }
}
