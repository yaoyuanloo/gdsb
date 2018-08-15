package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030201.F14030201Service;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030201.params.PersonInfoInputParams;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030201.params.PersonInfoOutputParams;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030201.params.UnemploymentPaymentsInputParams;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030201.params.UnemploymentPaymentsOutputParams;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by cxdwe on 2016/10/25 0025.
 */
public class MonthUnemployment extends DubboTest {

    @Resource
    F14030201Service monthUnemployment;

    /**
     * 领取失业金区间按月登记 -- 查询
     *
     * String aac147;//身份证号
     * String aac058;//证件类型
     */
    @Test
    public void test(){
        PersonInfoInputParams params = new PersonInfoInputParams();
        params.setAac147("806162198601122341");
        PersonInfoOutputParams out = monthUnemployment.queryTreatmentApprovedInfo(params);
        out(out);
    }

    /**
     * 领取失业金区间按月登记 -- 保存
     *
     * String aac147;//身份证号
     * String aac058;//证件类型
     * String ajc073; // 备注
     * Long aae127; // 申请时间
     * Long aae003; // 报到月份
     * String aae011; // 经办人
     * String bae125; // 经办人姓名
     * Date aae036; // 经办时间
     */
    @Test
    public void test1(){
        UnemploymentPaymentsInputParams params = new UnemploymentPaymentsInputParams();
        params.setAac147("806162198601122341");
        params.setAac058("01");
        params.setAae127(20160201L);
        params.setAae003(201601L);
        UnemploymentPaymentsOutputParams out = monthUnemployment.saveJc21(params);
        out(out);
    }
}
