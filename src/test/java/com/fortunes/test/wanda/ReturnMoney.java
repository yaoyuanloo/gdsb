package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020304.F14020304Service;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020304.params.*;
import com.wondersgroup.wssip.bc.generalbenefitmgmt.socialdelivermgr.model.dto.BankAccountAduitDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cxd on 2016/10/27 0027.
 */
public class ReturnMoney extends DubboTest {

    @Autowired
    F14020304Service service;

    /**
     * 退个人账户存储额校验
     * <p>
     * F14020304QueryInputParams基类,该基类包含以下几个字段:
     * Long aac001; //人员id
     * String aaa121; //业务类型
     * private boolean bizSuccess;
     * String errorCode;
     * String message;
     * String aae140; // 险种类型
     * Double bic008 = 0.0; // 个人账户存储额
     * Double bic009 = 0.0; // 个人缴费存储额
     * Long aae201; // 实际缴费月数
     * Long aac049; // 首次参保年月
     * Long aab001; // 单位ID
     * Long aaz159; // 人员参保关系ID
     * String aae410;// 业务年月
     * Long aac001;// 人员id
     * String aaa027; // 统筹区编码
     */
    @Test
    public void test() {
        F14020304QueryInputParams input = new F14020304QueryInputParams();
        input.setAaa121("F140203");
        input.setAac001(Long.valueOf("1000000486"));
        F14020304QueryOutputParams output = service.queryf14020304Info(input);
        out(output);
    }

    /**
     * 退个人账户计算
     * <p>
     * Long aac001; // 个人ID
     * String aaa027; // 统筹区编码
     * Long aic301; // 终止年月
     * Double bic008; // 个人账户存储额
     * Double bic009; // 个人缴费存储额
     * Long aae201;//实际缴费月数
     * String aaa121;//业务类型编码
     * <p>
     * <p>
     * <p>
     * private List<Ac0cSaveDTO> detailResults;//待遇计算列表
     * <p>
     * Ac0cSaveDTO字段属性如下:
     * <p>
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
     */
    @Test
    public void test1() {
        F14020304ComputeInputParams f14020304computeinputparams = new F14020304ComputeInputParams();
        f14020304computeinputparams.setAac001(Long.valueOf("1000000486"));
        f14020304computeinputparams.setAaa027("440000");
        f14020304computeinputparams.setAae201(Long.valueOf("3"));
        f14020304computeinputparams.setAic301(Long.valueOf("201609"));
        f14020304computeinputparams.setBic008(310D);
        f14020304computeinputparams.setBic009(100D);
        F14020304ComputeOutputParams outparams = service.calcCorpInsuInJobEndOnce(f14020304computeinputparams);
        out(outparams);
    }


    /**
     * 退回个人账户存储额保存
     */
    @Test
    public void test2() {
        F14020304SaveInputParams saveinput = new F14020304SaveInputParams();
        saveinput.setAac001(Long.valueOf("1000000577"));
        saveinput.setAic301("201609");
        saveinput.setAaa027("440000");
        saveinput.setAaa121("F140203");
        saveinput.setOutgoing("通过");
        saveinput.setAae140("110");
        saveinput.setBic008(310D);
        saveinput.setAab001(Long.valueOf("100000421"));
        saveinput.setAae013("bz");
        saveinput.setAae160("1");
        saveinput.setBic008(310D);
        saveinput.setBic009(50D);
        saveinput.setAac049("201009");
        saveinput.setAaz159(Long.valueOf("0"));
        saveinput.setAaz257(Long.valueOf("100000"));
        BankAccountAduitDTO bank = new BankAccountAduitDTO();
        bank.setAac001(Long.valueOf("1000000577"));
        bank.setAaa079("1");
        bank.setAae145("11");
        bank.setAae147("1");
        bank.setBae118("001");
        bank.setBab007("测试银行");
        bank.setAae009("测试人员");
        bank.setAae010("62284800000000000");
        saveinput.setBankAccountAduitvo(bank);
        F14020304SaveOutputParams output = service.savef14020304Info(saveinput);
        out(output);
    }
}
