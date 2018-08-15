package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u1.f14030103.F14030103Service;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u1.f14030103.params.*;
import com.wondersgroup.wssip.bc.generalbenefitmgmt.benefitauthmgr.model.dto.Ac0cSaveDTO;
import com.wondersgroup.wssip.bc.generalbenefitmgmt.socialdelivermgr.model.dto.BankAccountAduitDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 失业期间死亡待遇核定
 * Created by cxd on 2016/10/27 0027.
 */
public class DealperiodTest extends DubboTest {

    @Autowired
    F14030103Service service;

    /**
     * 失业期间死亡待遇核定校验
     * <p>
     * private Long aac001; 人员id
     * <p>
     * <p>
     * boolean bizSuccess;
     * String errorCode;
     * String message;
     * Double bic008; //个人账户存储额
     * Double bae073; //上年度在岗职工月平均工资
     * Long baz057;   //代发代扣类型
     * String sySzfFlag; // 是否已领取失业丧葬费标志(0已领取1未领取)
     * String gsSzfFlag; // 是否已领取工伤丧葬费标志(0已领取1未领取)
     * Long aac001; // 人员ID
     * Long aae410; // 业务年月
     * String aae140; // 险种类型
     * String aaa027;// 统筹区编码
     * Long bjc104; // 转入剩余可享受月数
     * Long ajc090; // 失业时间
     * Long ajc099; // 本次剩余可享受失业保险待遇月数
     * Long ajc097; // 应享受失业保险待遇月数
     * Long ajc092; // 未计发待遇的累计缴费月数
     * Long ajc059; // 上次结转至本次剩余享受月数
     * Long ajc071; // 失业保险本次缴费月数
     * Long ajc056; // 本次失业待遇终止年月
     * Long aab001; // 单位ID
     * Long ajc060; // 上次结转未计发缴费月数
     */
    @Test
    public void test() {
        F14030103InputParams input = new F14030103InputParams();
        input.setAac001(Long.valueOf("1000001122"));
        F14030103outputParams outparams = service.getf14030103Query(input);
        out(outparams);
    }

    /**
     * 失业期间死亡待遇核定计算
     * <p>
     * Long aac001;// 人员id
     * String aae138Str; // 死亡时间
     * String baa605; // 是否存在直系亲属标志
     * String baa607; // 是否同步处理在职死亡
     * Double bic008; // 个人账户存储额
     * <p>
     * <p>
     * Double paysum;//总额
     * Long baz039; // 待遇计算ID
     * Double kcje;// 扣发金额
     * List<Ac0cSaveDTO> detailResults;//待遇计算列表
     * List<RetroDeductOutDTO> deductOutDTOs;//补扣发信息
     * <p>
     * Ac0cSaveDTO字段属性如下:
     * String aaa036;    //待遇项目代码
     * Long aae041;    //开始年月
     * Long aae042;    //终止年月
     * String bae148;    //计算结果
     * Double aae129;    //核发金额
     * Long aaa200;    //运算要素编号
     * String aaa201;    //运算要素名称
     * String bae011;    //显示公式
     * String aae140;    //险种类型
     * String baa044;    //计算明细规则类型
     * String aae013;    //备注
     * String aae100;    //当前有效标志
     * <p>
     * RetroDeductOutDTO字段属性如下:
     * Long aae041; // 补扣发开始年月
     * Long aae042; // 补扣发截止年月
     * Double aae129; // 待遇补扣发总额
     * Double bae134; // 个人账户支付金额
     * String aaa036; // 待遇项目代码
     * String aaa077; // 补扣发业务类型代码
     * String aaa078; // 补扣发标志
     * Long bae069; // 补扣发月数
     * String aae013; // 备注
     * String czwkwFlag; // 仍在执行的扣发待遇标志
     * Long baz057; // 代发代扣类型
     * String aaa171; // 扣发方式
     * Double bac026; // 按月扣减金额
     * Long jhAae041; // 计划扣发开始年月
     * Long zhMonth; // 计划扣发月数
     */
    @Test
    public void test1() {
        F14030103InputCompParams inputcomp = new F14030103InputCompParams();
        inputcomp.setAac001(Long.valueOf("1000001122"));
        inputcomp.setAae138Str("201609");
        inputcomp.setBaa605("1");
        inputcomp.setBaa607("1");
        inputcomp.setBic008(310D);
        F14030103outputCompParams outcompParams = service.getf14030103Comp(inputcomp);
        out(outcompParams);
    }


    /**
     * 失业期间死亡待遇核定保存
     * <p>
     * F14030103InputSaveParams;基类,该基类包含以下几个字段:
     * Long aac001;// 个人ID
     * Long aab001;// 单位ID
     * String aae013;// 备注
     * String outgoing;// 流向
     * String aaa121; // 业务类型编码
     * Long baz057;
     * Long aaz159;// 人员参保关系ID
     * Long aaz257;// 定期 待遇领取人员ID
     * Date aae138;// 死亡时间
     * String baa607;// 是否同步处理在职死亡
     * String baa605;// 是否存在直系亲属
     * String aaa171;// 扣发处理方式
     * Double bic008; // 个人账户存储额（养老）
     * BankAccountAduitDTO bankAccountAduitvo; // 发放信息
     * List<RetroDeductOutDTO> retrdeductoutDto;// 补扣发
     * List<Ac0cSaveDTO> dyzcList;// 待遇组成
     * <p>
     * <p>
     * F14030103InputSaveParams;基类,该基类包含以下几个字段:
     * private boolean bizSuccess;
     * private String errorCode;
     * private String message;
     */
    @Test
    public void test2() {
        F14030103InputSaveParams input = new F14030103InputSaveParams();
        input.setAac001(Long.valueOf("1000001122"));
        input.setAab001(Long.valueOf("100000421"));
        input.setAae013("bz");
        input.setOutgoing("通过");
        input.setAaa121("F140216");
        input.setBaz057(Long.valueOf("100000"));
        input.setAaz159(Long.valueOf("1"));
        input.setAaz257(Long.valueOf("1000002223"));
        SimpleDateFormat simple = new SimpleDateFormat("yyyyMM");
        Date d;
        try {
            d = simple.parse("201609");
            input.setAae138(d);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        input.setBaa605("1");
        input.setBaa607("1");
        input.setAaa171("0");
        input.setBic008(310D);
        List<Ac0cSaveDTO> dyzcList = new ArrayList<Ac0cSaveDTO>();
        Ac0cSaveDTO ac0c = new Ac0cSaveDTO();
        ac0c.setAaa027("440000");
        ac0c.setAaa036("210122");
        ac0c.setAaa085("0");
        ac0c.setAaa200(Long.valueOf("100"));
        ac0c.setAaa201("失业抚恤金");
        ac0c.setAac001(Long.valueOf("1000001122"));
        ac0c.setAae041(Long.valueOf("201610"));
        ac0c.setAae042(Long.valueOf("201610"));
        ac0c.setAae100("1");
        ac0c.setAae129(120D);
        ac0c.setAae140("210");
        ac0c.setAaz100("200000003");
        ac0c.setBaa044("5");
        ac0c.setBac038("0");
        ac0c.setBae011("死亡");
        ac0c.setBae134(20D);
        ac0c.setBae148("1800");
        dyzcList.add(ac0c);
        input.setDyzcList(dyzcList);
        /* 发放信息 */
        BankAccountAduitDTO bank = new BankAccountAduitDTO();
        bank.setAac001(Long.valueOf("1000000577"));
        bank.setAaa079("1");
        bank.setAae145("11");
        bank.setAae147("1");
        bank.setBae118("001");
        bank.setBab007("测试银行");
        bank.setAae009("测试人员");
        bank.setAae010("62284800000000000");
        input.setBankAccountAduitvo(bank);
        F14030103outputSaveParams out = service.f14030103Save(input);
        out(out);
    }
}
