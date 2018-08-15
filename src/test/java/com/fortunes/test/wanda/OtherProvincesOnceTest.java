package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u1.f14030102.F14030102Service;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u1.f14030102.params.*;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 非本省一次性待遇核定
 * Created by cxd on 2016/10/30 0030.
 */
public class OtherProvincesOnceTest extends DubboTest {
    @Autowired
    F14030102Service service;

    /**
     * 非本省一次性待遇核定查询
     *
     * CheckOnceTreatmentOfNonProvinceIP基类,该基类包含以下几个字段:
     * Long     aac001;  // 人员ID
     * String   aaa027;  // 统筹区编码
     *
     * CheckOnceTreatmentOfNonProvinceOP基类,该基类包含以下几个字段:
     * boolean  bizSuccess;
     * String   errorCode;
     * String   message;
     * Long     aae014;     //法定退休年龄
     * Long     ajc056;     // 本次失业待遇终止年月
     * Long     ajc099;     // 本次剩余可享受失业保险待遇月数
     * Long     bic034;     //失业金缴费年限
     * Long     bjc104;     // 转入剩余可享受月数
     * Long     ajc0990;    //求职补贴发放月数
     * Long     aae041;     //缴费开始时间
     * Long     aae042;     //缴费结束时间
     * Long     ajc071;     // 失业保险本次缴费月数
     * Double   ajc061;     // 失业前十二个月平均缴费工资
     * Double   baa003;     //年度最低工资标准
     * Double   aae128;     //一次性待遇金额
     * Long     aae211;     //待遇核定年月
     * Long     aae210;     //待遇享受开始时间
     * Long     aic301;     //待遇享受结束时间
     * Long     ajc097;     // 应享受失业保险待遇月数
     * --农民工一次性补助用到的变量--
     * String   receiveSubsidyOfMigrantWorkerFlag;      //能否享受农民工一次性生活补助
     * Long     breakPoint; //中断月份
     * int      ajc053;     //农民工原连续缴费月数
     * int      ajc054 ;    //农民工中断前缴费的月数
     * double   ajc055;     //中断前平均缴费工资
     * double   ajc057;     //中断缴费前12个月平均缴费工资
     * String   aac028;     //农民工标识
     */
    @Test
    public void test(){
        CheckOnceTreatmentOfNonProvinceIP p = new CheckOnceTreatmentOfNonProvinceIP();
        p.setAaa027("440000");
        p.setAac001(1000001705L);
        CheckOnceTreatmentOfNonProvinceOP o = service.checkOnceTreatmentOfNonProvinceOP(p);
        out(o);
    }

    /**
     * 非本省一次性待遇计算
     *
     * QueryOnceTreatmentOfNonProvinceIP基类,该基类包含以下几个字段:
     * String   aaa027;  // 统筹区编码
     * Long     aac001;  // 人员ID
     * Long     aae014;  //法定退休年龄
     * Long     bic034;  //失业金缴费年限
     * Long     ajc099;  // 本次剩余可享受失业保险待遇月数
     * Double   ajc061;  // 失业前十二个月平均缴费工资
     * Long     aae211;  //待遇核定年月
     * int      ajc053;  //农民工原连续缴费月数
     * int      ajc054;  //农民工中断前缴费的月数
     * double   ajc055;  //中断前平均缴费工资
     * double   ajc057;  //中断缴费前12个月平均缴费工资
     * String   aac028;  //农民工标识
     *
     * QueryOnceTreatmentOfNonProvinceOP基类,该基类包含以下几个字段:
     * boolean  bizSuccess;     //业务是否成功true表示成功，false表示失败
     * String   errorCode;      //错误码
     * String   message;        //信息
     * int      totalCounts;    // 总记录条数
     * int      totalPage;      // 总页数
     * int      currentPage;    // 当前页码
     * int      rows;           // Pagesize每页大小
     * List<OnceCalculationDetail> onceCalculationDetail ;
     *
     * OnceCalculationDetail实体包含以下字段:
     * String   aaa036;  //待遇项目名称
     * Double   aae128;  //待遇金额
     * String   aae013;  //备注
     */
    @Test
    public void test1(){
        QueryOnceTreatmentOfNonProvinceIP p = new QueryOnceTreatmentOfNonProvinceIP();
        p.setAaa027("440000");
        p.setAac001(1000001705L);
        p.setAae014(204911L);
        p.setBic034(78L);
        p.setAjc099(3L);
        p.setAjc061(5784.58D);
        p.setAjc053(14);
        p.setAjc054(39);
        p.setAjc055(3831.69);
        p.setAjc057(4772.25);
        p.setAac028("1");
        p.setAae211(20161028L);
        QueryOnceTreatmentOfNonProvinceOP o = service.queryOnceTreatmentOfNonProvinceIP(p);
        out(o);
    }

    /**
     * 非本省一次性保存 saveOnceTreatmentOfNonProvinceOP
     *
     * SaveOnceTreatmentOfNonProvinceIP基类,该基类包含以下几个字段:
     * Long     aae014;     //法定退休年龄
     * Long     ajc056;     // 本次失业待遇终止年月
     * Long     ajc099;     // 本次剩余可享受失业保险待遇月数
     * Long     bic034;     //失业金缴费年限
     * Long     bjc104;     // 转入剩余可享受月数
     * Long     ajc0990;    //求职补贴发放月数
     * Long     aae041;     //缴费开始时间
     * Long     aae042;     //缴费结束时间
     * Long     ajc071;     // 失业保险本次缴费月数
     * Double   ajc061;     // 失业前十二个月平均缴费工资
     * Double   baa003;     //年度最低工资标准
     * Double   aae128;     //一次性待遇金额
     * Long     aae211;     //待遇核定年月
     * Long     aae210;     //待遇享受开始时间
     * Long     aic301;     //待遇享受结束时间
     * Long     ajc097;     // 应享受失业保险待遇月数
     * Long     aac001;     // 人员ID
     * String   aaa027;     // 统筹区编码
     * List<OnceCalculationDetail> onceCalculationDetail ;
     *
     * --农民工一次性补助用到的变量--
     * String   receiveSubsidyOfMigrantWorkerFlag;//能否享受农民工一次性生活补助
     * Long     breakPoint; //中断月份
     * int      ajc053;     //农民工原连续缴费月数
     * int      ajc054;     //农民工中断前缴费的月数
     * double   ajc055;     //中断前平均缴费工资
     * double   ajc057;     //中断缴费前12个月平均缴费工资
     * String   aac028;     //农民工标识
     *
     * OnceCalculationDetail包括一下字段：
     * String   aaa036;     //待遇项目名称
     * Double   aae128;     //待遇金额
     * String   aae013;     //备注
     */
    @Test
    public void test2(){
        CheckOnceTreatmentOfNonProvinceIP p1 = new CheckOnceTreatmentOfNonProvinceIP();
        p1.setAaa027("440000");
        p1.setAac001(1000001705L);
        CheckOnceTreatmentOfNonProvinceOP o1 = service.checkOnceTreatmentOfNonProvinceOP(p1);

        QueryOnceTreatmentOfNonProvinceIP p2 = new QueryOnceTreatmentOfNonProvinceIP();
        p2.setAaa027("440000");
        p2.setAac001(1000001705L);
        p2.setAae014(204911L);
        p2.setBic034(78L);
        p2.setAjc099(3L);
        p2.setAjc061(5784.58D);
        p2.setAjc053(14);
        p2.setAjc054(39);
        p2.setAjc055(3831.69);
        p2.setAjc057(4772.25);
        p2.setAac028("1");
        p2.setAae211(20161028L);
        QueryOnceTreatmentOfNonProvinceOP o2 = service.queryOnceTreatmentOfNonProvinceIP(p2);

        SaveOnceTreatmentOfNonProvinceIP p = new SaveOnceTreatmentOfNonProvinceIP();
        BeanUtils.copyProperties(p1, p);
        BeanUtils.copyProperties(o1, p);
        BeanUtils.copyProperties(o2, p);
        SaveOnceTreatmentOfNonProvinceOP o = service.saveOnceTreatmentOfNonProvinceOP(p);
        out(o);
    }
}



































