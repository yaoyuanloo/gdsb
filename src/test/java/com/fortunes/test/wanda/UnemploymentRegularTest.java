package com.fortunes.test.wanda;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u1.f14030101.F14030101Service;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u1.f14030101.params.*;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * 失业定期待遇核定
 * Created by cxd on 2016/10/27 0027.
 */
public class UnemploymentRegularTest extends DubboTest {

    @Autowired
    F14030101Service service;

    /**
     * 定期失业待遇核定
     *
     * PeriodUnemploymentQueryIP基类,该基类包含以下几个字段:
     * Long   aac001;   //人员ID
     *
     * PeriodUnemploymentQueryOP基类,该基类包含以下几个字段:
     * boolean bizSuccess;
     * String errorCode;
     * String message;
     * Long aac001; // 人员ID
     * String aac147;//身份证号
     * Long bje009; // 上次领取失业金时间
     * String tipFlag;//是否需要提示还存在未转移的缴费记录
     * Long ajc060; // 上次结转未计发缴费月数
     * Long ajc059; // 上次结转至本次剩余享受月数
     * Long bjc104; // 转入剩余可享受月数
     * Long ajc071; // 失业保险本次缴费月数
     * Long ajc072;//失业保险本次累计缴费月数
     * Long bje008; // 应享受求职补贴月数
     * Double ajc061; // 失业前十二个月平均缴费工资
     * Long ajc092; // 未计发待遇的累计缴费月数
     * Long ajc097; // 应享受失业保险待遇月数
     * Long ajc099; // 本次剩余可享受失业保险待遇月数
     * Double bab323; // 当地城镇居民最低生活保障标准
     * Double bab324; // 最低生活保障标准计发比例
     * Double bab325; // 求职补贴计发比例
     * Long aae211;//待遇核定年月
     * Long aae210;//待遇享受开始年月
     *
     * --农民工一次性补助用到的变量--
     *
     * String receiveSubsidyOfMigrantWorkerFlag;//能否享受农民工一次性生活补助 （1：可以，2：不可以）
     * int ajc053;//农民工原连续缴费月数
     * int ajc054 ; //农民工中断前缴费的月数
     * double ajc055;//中断前平均缴费工资
     * double  ajc057;//中断缴费前12个月平均缴费工资
     * String aac028;//农民工标识
     *
     * Long ajc090;//失业登记日期
     * String acc101;//失业登记证号
     * Long bje007;//劳动关系终止时间
     * String bjy002;//劳动关系终止原因
     * Long aab001;//单位代码
     * String aab004;//失业前单位名称
     */
    @Test
    public void test(){
        PeriodUnemploymentQueryIP p = new PeriodUnemploymentQueryIP();
        p.setAac001(1000001705L);
        PeriodUnemploymentQueryOP o = service.PeriodUmemploymentApprove(p);
        out(o);
    }

    /**
     * 定期失业待遇计算
     *
     * PeriodUnemploymentCalculationIP基类,该基类包含以下几个字段:
     * String aaa027; // 统筹区编码
     * Double ajc061; // 失业前十二个月平均缴费工资
     * Long aae210;//待遇享受开始时间
     * Long ajc099; // 本次剩余可享受失业保险待遇月数
     * Long bje008; // 应享受求职补贴月数
     * int ajc053;//农民工原连续缴费月数
     * int ajc054 ; //农民工中断前缴费的月数
     * double ajc055;//中断前平均缴费工资
     * double  ajc057;//中断缴费前12个月平均缴费工资
     * String aac028;//农民工标识（0：不是，1：是）
     *
     *
     * PeriodUnemploymentCalculationOP基类,该基类包含以下几个字段:
     * boolean bizSuccess;//业务是否成功true表示成功，false表示失败
     * String errorCode;//错误码
     * String message;//信息
     * List<PeriodCalculationDetail> umemploymentDistributionInformationList ;
     * int totalCounts;    // 总记录条数
     * int totalPage;      // 总页数
     * int currentPage;    // 当前页码
     * int rows;           // Pagesize每页大小
     *
     * PeriodCalculationDetail实体包含以下字段:
     * String aaa036;//待遇项目名称
     * Double aae128;//待遇金额
     * Long ajc099;//享受月数
     * String aae013;//备注
     * Long aae041 ;//待遇享受开始时间
     * Long aae042 ;//待遇享受终止时间
     *
     */
    @Test
    public void test1(){
        PeriodUnemploymentCalculationIP periodUnemploymentCalculationIP = new PeriodUnemploymentCalculationIP();
        periodUnemploymentCalculationIP.setAaa027("440000");
        periodUnemploymentCalculationIP.setAjc061(5784.58);
        periodUnemploymentCalculationIP.setAae210(201610L);
        periodUnemploymentCalculationIP.setAjc099(3L);
        periodUnemploymentCalculationIP.setBje008(3L);
        periodUnemploymentCalculationIP.setAjc053(54);
        periodUnemploymentCalculationIP.setAjc054(0);
        periodUnemploymentCalculationIP.setAjc055(0);
        periodUnemploymentCalculationIP.setAjc057(0);
        periodUnemploymentCalculationIP.setAac028("1");

        PeriodUnemploymentCalculationOP o = service.PeriodUmemploymentCalculation(periodUnemploymentCalculationIP);
        out(o);
    }

    /**
     * 定期失业待遇核定保存
     *
     * PeriodUnemploymentSaveIP基类,该基类包含以下几个字段
     * Long   aac001;   //人员ID
     * Long   bje009; // 上次领取失业金时间
     * Long   ajc060; // 上次结转未计发缴费月数
     * Long   ajc059; // 上次结转至本次剩余享受月数
     * Long   bjc104; // 转入剩余可享受月数
     * Long   ajc071; // 失业保险本次缴费月数
     * Long   ajc072;//失业保险本次累计缴费月数
     * Long   bje008; // 应享受求职补贴月数
     * Double ajc061; // 失业前十二个月平均缴费工资
     * Long   ajc092; // 未计发待遇的累计缴费月数
     * Long   ajc097; // 应享受失业保险待遇月数
     * Long   ajc099; // 本次剩余可享受失业保险待遇月数
     * Double bab323; // 当地城镇居民最低生活保障标准
     * Double bab324; // 最低生活保障标准计发比例
     * Double bab325; // 求职补贴计发比例
     * Long   aae211;//待遇核定年月
     * Long   aae210;//待遇享受开始年月
     * String aac028;//农民工标识
     * List<PeriodCalculationDetail> umemploymentDistributionInformationList ;//待遇项目明细
     *
     * 调用就业接口查询到的失业信息
     *
     * Long ajc090;//失业登记日期
     * String acc101;//失业登记证号
     * Long bje007;//劳动关系终止时间
     * String bjy002;//劳动关系终止原因
     * Long aab001;//单位代码
     * String aab004;//失业前单位名称
     *
     * PeriodCalculationDetail包括一下字段：
     * String aaa036;//待遇项目名称
     * Double aae128;//待遇金额
     * Long ajc099;//享受月数
     * String aae013;//备注
     * Long aae041 ;//待遇享受开始时间
     * Long aae042 ;//待遇享受终止时间
     *
     * PeriodUnemploymentSaveOP基类,该基类包含以下几个字段:
     * boolean bizSuccess;
     * String errorCode;
     * String message;
     *
     * 错误码和提示信息如下:
     * GDYLSY_001：传入参数为空
     * GDYLSY_002：基础信息错误
     * GDYLSY_003：操作不成功
     */
    @Test
    public void test2(){
        PeriodUnemploymentQueryIP p1 = new PeriodUnemploymentQueryIP();
        p1.setAac001(1000001705L);
        PeriodUnemploymentQueryOP o1 = service.PeriodUmemploymentApprove(p1);

        PeriodUnemploymentCalculationIP periodUnemploymentCalculationIP = new PeriodUnemploymentCalculationIP();
        periodUnemploymentCalculationIP.setAaa027("440000");
        periodUnemploymentCalculationIP.setAjc061(5784.58);
        periodUnemploymentCalculationIP.setAae210(201610L);
        periodUnemploymentCalculationIP.setAjc099(3L);
        periodUnemploymentCalculationIP.setBje008(3L);
        periodUnemploymentCalculationIP.setAjc053(54);
        periodUnemploymentCalculationIP.setAjc054(0);
        periodUnemploymentCalculationIP.setAjc055(0);
        periodUnemploymentCalculationIP.setAjc057(0);
        periodUnemploymentCalculationIP.setAac028("1");
        PeriodUnemploymentCalculationOP o2 = service.PeriodUmemploymentCalculation(periodUnemploymentCalculationIP);

        PeriodUnemploymentSaveIP p = new PeriodUnemploymentSaveIP();
        BeanUtils.copyProperties(o1, p);
        p.setUmemploymentDistributionInformationList(o2.getUmemploymentDistributionInformationList());
        PeriodUnemploymentSaveOP o = service.PeriodUmemploymentSave(p);
        out(o);
    }

}






































