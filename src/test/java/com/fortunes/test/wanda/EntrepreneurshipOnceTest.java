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
 * 自主创业后领取一次性失业金核定
 * Created by cxd on 2016/10/30 0030.
 */
public class EntrepreneurshipOnceTest extends DubboTest {
    @Autowired
    F14030102Service service;

    /**
     * 自主创业一次性待遇核定查询 checkOnceTreatmentOfSelfEmployed
     * <p>
     * CheckOnceTreatmentOfSelfEmployedIP基类,该基类包含以下几个字段:
     * Long     aac001;   // 人员ID
     * String   aaa027;   // 统筹区编码
     * <p>
     * CheckOnceTreatmentOfSelfEmployedOP基类,该基类包含以下几个字段:
     * boolean  bizSuccess;
     * String   errorCode;
     * String   message;
     * Long     aae211;   //待遇核定年月
     * Long     aae210;   //待遇享受开始时间
     * Long     aic301;   //待遇享受结束时间
     * Long     ajc099;   // 剩余领取月数
     * Double   aae128;   //待遇金额
     */
    @Test
    public void test() {
        CheckOnceTreatmentOfSelfEmployedIP p = new CheckOnceTreatmentOfSelfEmployedIP();
        p.setAaa027("440000");
        p.setAac001(1000001694L);
        CheckOnceTreatmentOfSelfEmployedOP o = service.checkOnceTreatmentOfSelfEmployed(p);
        out(o);
    }

    /**
     * 自主创业一次性待遇计算
     * <p>
     * QueryOnceTreatmentOfSelfEmployedIP基类,该基类包含以下几个字段:
     * Long     ajc099;    // 剩余领取月数
     * Double   aae128;    //待遇金额
     * String   aaa027;    // 统筹区编码
     * Long     aac001;    // 人员ID
     * <p>
     * QueryOnceTreatmentOfSelfEmployedOP基类,该基类包含以下几个字段:
     * boolean  bizSuccess;    //业务是否成功true表示成功，false表示失败
     * String   errorCode;     //错误码
     * String   message;       //信息
     * int      totalCounts;   // 总记录条数
     * int      totalPage;     // 总页数
     * int      currentPage;   // 当前页码
     * int      rows;          // Pagesize每页大小
     * List<OnceCalculationDetail> onceCalculationDetail ;
     * <p>
     * OnceCalculationDetail实体包含以下字段:
     * String   aaa036;    //待遇项目名称
     * Double   aae128;    //待遇金额
     * String   aae013;    //备注
     */
    @Test
    public void test1() {
        QueryOnceTreatmentOfSelfEmployedIP p = new QueryOnceTreatmentOfSelfEmployedIP();
        p.setAaa027("440000");
        p.setAae128(4800D);
        p.setAjc099(6L);
        p.setAac001(1000001694L);
        QueryOnceTreatmentOfSelfEmployedOP o = service.queryOnceTreatmentOfSelfEmployed(p);
        out(o);
    }

    /**
     * 自主创业一次性保存
     * <p>
     * SaveOnceTreatmentOfSelfEmployedIP基类,该基类包含以下几个字段:
     * static   final long serialVersionUID = 1L;
     * Long     aae211;    //待遇核定年月
     * Long     aae210;    //待遇享受开始时间
     * Long     aic301;    //待遇享受结束时间
     * Long     ajc099;    // 剩余领取月数
     * Double   aae128;    //待遇金额
     * Long     aac001;    // 人员ID
     * String   aaa027;    // 统筹区编码
     * Date     aab008;    //开办企业日期
     * List<OnceCalculationDetail> onceCalculationDetail ;
     * <p>
     * OnceCalculationDetail包括一下字段：
     * String   aaa036;    //待遇项目名称
     * Double   aae128;    //待遇金额
     * String   aae013;    //备注
     * <p>
     * SaveOnceTreatmentOfSelfEmployedOP基类,该基类包含以下几个字段:
     * boolean  bizSuccess;
     * String   errorCode;
     * String   message;
     * <p>
     * 错误码和提示信息如下:
     * GDYLSY_001：传入参数为空
     * GDYLSY_002：基础信息错误
     * GDYLSY_003：操作不成功
     */
    @Test
    public void test2() {
        CheckOnceTreatmentOfSelfEmployedIP p1 = new CheckOnceTreatmentOfSelfEmployedIP();
        p1.setAaa027("440000");
        p1.setAac001(1000001694L);
        CheckOnceTreatmentOfSelfEmployedOP o1 = service.checkOnceTreatmentOfSelfEmployed(p1);

        QueryOnceTreatmentOfSelfEmployedIP p2 = new QueryOnceTreatmentOfSelfEmployedIP();
        p2.setAaa027("440000");
        p2.setAae128(4800D);
        p2.setAjc099(6L);
        p2.setAac001(1000001694L);
        QueryOnceTreatmentOfSelfEmployedOP o2 = service.queryOnceTreatmentOfSelfEmployed(p2);

        SaveOnceTreatmentOfSelfEmployedIP p = new SaveOnceTreatmentOfSelfEmployedIP();
        BeanUtils.copyProperties(p1, p);
        BeanUtils.copyProperties(o1, p);
        BeanUtils.copyProperties(o2, p);
        p.setAac001(1000001694L);
        p.setAaa027("440000");
        try {
            p.setAab008(DateUtils.parseDate("20161001", "yyyyMMdd"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SaveOnceTreatmentOfSelfEmployedOP o = service.saveOnceTreatmentOfSelfEmployed(p);
        out(o);
    }
}
