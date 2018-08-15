package com.fortunes.test.dongruan;

import com.fortunes.test.DubboTest;
import com.neusoft.sl.si.collection.dubbo.employee.oncefee.param.RetireMedicalOneFeeParam;
import com.neusoft.sl.si.collection.dubbo.employee.oncefee.result.RetireMedicalOneFeeResult;
import com.neusoft.sl.si.collection.dubbo.employee.oncefee.service.RetireMedicalOneFeeDubboService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cxd on 2016/11/2 0002.
 */
public class TuixiuyiliaodunjiaoTest extends DubboTest {

    @Autowired
    RetireMedicalOneFeeDubboService service;

    /**
     * 退休医疗趸缴|查询人员实际缴费月数
     * <p>
     * RetireMedicalOneFeeParam基类,该基类包含以下几个字段:
     * Long     aac001;       //个人编号
     * Long     aab001;       //单位编号
     * String   aae140;       //险种类型
     * String   aaa027;       //所属统筹区
     * String   aac084;       //所属统筹区
     * String   aab019 ;      //单位类型
     * Integer  aic162;       //离退休日期
     * Integer  aae003;       //费款所属期
     * String   akc021;       //人员缴费类别
     * int      STFeeMonths;  //视同缴费月数
     * int      SJFeeMonths;  //实际缴费月数
     * Integer  aae002;       //结算期
     * String   aae180;       //个人缴费基数
     * double   feeRate;      //缴费比例
     * Integer  bae189;       //缴费月数
     */
    @Test
    public void test() {
        RetireMedicalOneFeeParam p = new RetireMedicalOneFeeParam();
        p.setAac001(54321L);
        p.setAae140("310");
        RetireMedicalOneFeeResult o = service.queryPersonSJFeeMonths(p);
        out(o);
    }

    /**
     * 退休医疗趸缴
     */
    @Test
    public void test1() {
        RetireMedicalOneFeeParam p = new RetireMedicalOneFeeParam();

        RetireMedicalOneFeeResult o = service.queryPersonSJFeeMonths(new RetireMedicalOneFeeParam());
        out(o);
    }

    /**
     * 退休医疗趸缴
     */
    @Test
    public void test2() {

    }
}
