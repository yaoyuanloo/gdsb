package com.fortunes.test.wanda;

import com.fortunes.javamg.common.utils.DateUtils;
import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u1.f14030102.F14030102Service;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u1.f14030102.params.*;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

/**
 * Created by cxd on 2016/10/30 0030.
 */
public class BirthOncePlusTest extends DubboTest {
    @Autowired
    F14030102Service service;

    /**
     * 生育一次性待遇查询 checkOnceTreatmentOfBirth;
     *
     * OnceTreatmentOfBirthIP基类,该基类包含以下几个字段:
     * Long     aac001;    // 人员ID
     * String   aaa027;    // 统筹区编码
     *
     * OnceTreatmentOfBirthOP基类,该基类包含以下几个字段:
     * boolean  bizSuccess;
     * String   errorCode;
     * String   message;
     * Long     aae211;    //待遇核定年月
     * Long     aae210;    //待遇享受开始时间
     * Long     aic301;    //待遇享受结束时间
     * Long     ajc099;    // 剩余领取月数
     * Double   aae128;    //待遇金额
     */
    @Test
    public void test(){
        OnceTreatmentOfBirthIP p = new OnceTreatmentOfBirthIP();
        p.setAaa027("440000");
        p.setAac001(1000001694L);
        OnceTreatmentOfBirthOP o = service.checkOnceTreatmentOfBirth(p);
        out(o);
    }

    /**
     * 生育一次性待遇计算 queryOnceTreatmentOfBirth
     *
     * QueryOnceTreatmentOfBirthIP基类,该基类包含以下几个字段:
     * Long     aae211;    //待遇核定年月
     * Long     ajc099;    // 剩余领取月数
     * Double   aae128;    //待遇金额
     * String   aaa027;    // 统筹区编码
     * Long     aac001;    // 人员ID
     *
     * QueryOnceTreatmentOfBirthOP基类,该基类包含以下几个字段:
     * boolean  bizSuccess; //业务是否成功true表示成功，false表示失败
     * String   errorCode;  //错误码
     * String   message;    //信息
     * int      totalCounts;// 总记录条数
     * int      totalPage;  // 总页数
     * int      currentPage;// 当前页码
     * int      rows;       // Pagesize每页大小
     * List<OnceCalculationDetail> onceCalculationDetail ;
     *
     * OnceCalculationDetail实体包含以下字段:
     * String   aaa036;    //待遇项目名称
     * Double   aae128;    //待遇金额
     * String   aae013;    //备注
     */
    @Test
    public void test1(){
        QueryOnceTreatmentOfBirthIP p = new QueryOnceTreatmentOfBirthIP();
        p.setAaa027("440000");
        p.setAae128(4800D);
        p.setAjc099(6L);
        p.setAac001(1000001694L);
        p.setAae211(20161028L);
        QueryOnceTreatmentOfBirthOP o = service.queryOnceTreatmentOfBirth(p);
        out(o);
    }

    /**
     * 生育一次性保存 saveOnceTreatmentOfBirth
     *
     * SaveOnceTreatmentOfBirthIP基类,该基类包含以下几个字段:
     * Long     aae211;    //待遇核定年月
     * Long     aae210;    //待遇享受开始时间
     * Long     aic301;    //待遇享受结束时间
     * Long     ajc099;    // 剩余领取月数
     * Double   aae128;    //待遇金额
     * Long     aac001;    // 人员ID
     * String   aaa027;    // 统筹区编码
     * Date     bmc001;    //生育日期
     * List<OnceCalculationDetail> onceCalculationDetail ;
     *
     * OnceCalculationDetail包括一下字段：
     * String   aaa036;    //待遇项目名称
     * Double   aae128;    //待遇金额
     * String   aae013;    //备注
     *
     * SaveOnceTreatmentOfBirthOP基类,该基类包含以下几个字段:
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
        //查询
        OnceTreatmentOfBirthIP p1 = new OnceTreatmentOfBirthIP();
        p1.setAaa027("440000");
        p1.setAac001(1000001694L);
        OnceTreatmentOfBirthOP o1 = service.checkOnceTreatmentOfBirth(p1);
        out(o1);
        //计算
        QueryOnceTreatmentOfBirthIP p2 = new QueryOnceTreatmentOfBirthIP();
        p2.setAaa027("440000");
        p2.setAae128(4800D);
        p2.setAjc099(6L);
        p2.setAac001(1000001694L);
        p2.setAae211(20161028L);
        QueryOnceTreatmentOfBirthOP o2 = service.queryOnceTreatmentOfBirth(p2);
        out(o2);
        //保存
        SaveOnceTreatmentOfBirthIP p = new SaveOnceTreatmentOfBirthIP();
        p.setAac001(1000001694L);
        p.setAaa027("440000");
        try {
            p.setBmc001(DateUtils.parseDate("20161001", "yyyyMMdd"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(p1, p);
        BeanUtils.copyProperties(o1, p);
        BeanUtils.copyProperties(o2, p);
        SaveOnceTreatmentOfBirthOP o = service.saveOnceTreatmentOfBirth(p);
        out(o);
    }
}
