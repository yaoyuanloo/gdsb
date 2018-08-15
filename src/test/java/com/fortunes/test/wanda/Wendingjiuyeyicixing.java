package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u1.f14030102.F14030102Service;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u1.f14030102.params.*;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 稳定就业一次性待遇核定
 * Created by cxd on 2016/10/28 0028.
 */
public class Wendingjiuyeyicixing extends DubboTest {

    @Autowired
    F14030102Service service;

    /**
     * 稳定就业一次性待遇核定
     * CheckOnceTreatmentOfStableEmploymentIP基类,该基类包含以下几个字段:
     * Long     aac001;  // 人员ID
     * String   aaa027;  // 统筹区编码
     *
     * CheckOnceTreatmentOfStableEmploymentOP基类,该基类包含以下几个字段:
     * boolean  bizSuccess;
     * String   errorCode;
     * String   message;
     * Long     aae211;     //待遇核定年月
     * Long     aae210;     //待遇享受开始时间
     * Long     aic301;     //待遇享受结束时间
     * Long     ajc099;     // 剩余领取月数
     * Double   aae128;     //待遇金额
     * Long     aab001;     // 单位ID
     * String   aab004;     // 单位名称
     * Long     ajc072;     //失业保险本次累计缴费月数
     * Long     aae041;     //缴费开始时间
     * Long     aae042;     //缴费结束时间
     */
    @Test
    public void test(){
        CheckOnceTreatmentOfStableEmploymentIP p = new CheckOnceTreatmentOfStableEmploymentIP();
        p.setAac001(1000001694L);
        p.setAaa027("440000");
        CheckOnceTreatmentOfStableEmploymentOP o = service.checkOnceTreatmentOfStableEmployment(p);
        out(o);
    }

    /**
     * 稳定就业一次性待遇计算
     *
     * QueryOnceTreatmentOfStableEmploymentIP基类,该基类包含以下几个字段:
     * Long     ajc099;     // 剩余领取月数
     * Double   aae128;     //待遇金额
     * String   aaa027;     // 统筹区编码
     * Long     aac001;     // 人员ID
     *
     * 2.2服务接口方法返回值类设计标准
     *
     * PeriodUnemploymentCalculationOP基类,该基类包含以下几个字段:
     * boolean  bizSuccess; //业务是否成功true表示成功，false表示失败
     * String   errorCode;  //错误码
     * String   message;    //信息
     *
     * private List<OnceCalculationDetail> onceCalculationDetail ;
     * int totalCounts;    // 总记录条数
     * int totalPage;      // 总页数
     * int currentPage;    // 当前页码
     * int rows;           // Pagesize每页大小
     *
     * OnceCalculationDetail实体包含以下字段:
     * String aaa036;   //待遇项目名称
     * Double aae128;   //待遇金额
     * String aae013;   //备注
     */
    @Test
    public void test1(){
//        CheckOnceTreatmentOfStableEmploymentIP p1 = new CheckOnceTreatmentOfStableEmploymentIP();
//        p1.setAac001(1000001694L);
//        p1.setAaa027("440000");
//        CheckOnceTreatmentOfStableEmploymentOP o1 = service.checkOnceTreatmentOfStableEmployment(p1);
        QueryOnceTreatmentOfStableEmploymentIP p = new QueryOnceTreatmentOfStableEmploymentIP();
        p.setAaa027("440000");
        p.setAae128(4800D);
        p.setAjc099(6L);
        p.setAac001(1000001694L);
        QueryOnceTreatmentOfStableEmploymentOP o = service.queryOnceTreatmentOfStableEmployment(p);
        out(o);
    }

    /**
     * 稳定就业一次性保存
     * SaveOnceTreatmentOfStableEmploymentIP基类,该基类包含以下几个字段:
     * Long     aac001;     // 人员ID
     * String   aaa027;     // 统筹区编码
     * Long     aae211;     //待遇核定年月
     * Long     aae210;     //待遇享受开始时间
     * Long     aic301;     //待遇享受结束时间
     * Long     ajc099;     // 剩余领取月数
     * Double   aae128;     //待遇金额
     * Long     aab001;     // 单位ID
     * String   aab004;     // 单位名称
     * Long     ajc072;     //失业保险本次累计缴费月数
     * Long     aae041;     //缴费开始时间
     * Long     aae042;     //缴费结束时间
     * List <OnceCalculationDetail> onceCalculationDetail ;
     *
     * OnceCalculationDetail包括一下字段：
     * String   aaa036;  //待遇项目名称
     * Double   aae128;  //待遇金额
     * String   aae013;  //备注
     *
     * SaveOnceTreatmentOfStableEmploymentOP基类,该基类包含以下几个字段:
     * boolean  bizSuccess;
     * String   errorCode;
     * String   message;
     * 错误码和提示信息如下:
     * GDYLSY_001：传入参数为空
     * GDYLSY_002：基础信息错误
     * GDYLSY_003：操作不成功
     */
    @Test
    public void test2(){
        CheckOnceTreatmentOfStableEmploymentIP p1 = new CheckOnceTreatmentOfStableEmploymentIP();
        p1.setAac001(1000001694L);
        p1.setAaa027("440000");
        CheckOnceTreatmentOfStableEmploymentOP o1 = service.checkOnceTreatmentOfStableEmployment(p1);

        QueryOnceTreatmentOfStableEmploymentIP p2 = new QueryOnceTreatmentOfStableEmploymentIP();
        p2.setAaa027("440000");
        p2.setAae128(4800D);
        p2.setAjc099(6L);
        p2.setAac001(1000001694L);
        QueryOnceTreatmentOfStableEmploymentOP o2 = service.queryOnceTreatmentOfStableEmployment(p2);

        SaveOnceTreatmentOfStableEmploymentIP p = new SaveOnceTreatmentOfStableEmploymentIP();
        BeanUtils.copyProperties(o1, p);
        p.setAac001(1000001694L);
        p.setAaa027("440000");
        p.setOnceCalculationDetail(o2.getOnceCalculationDetail());

        SaveOnceTreatmentOfStableEmploymentOP o = service.saveOnceTreatmentOfStableEmployment(p);
        out(o);
    }
}
