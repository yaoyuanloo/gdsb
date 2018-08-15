package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020306.F14020306Service;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020306.params.*;
import com.wondersgroup.wssip.bc.generalbenefitmgmt.socialdelivermgr.model.dto.BankAccountAduitDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 重复待遇清理
 * Created by cxd on 2016/10/27 0027.
 */
public class RepeatRetireClean extends DubboTest {

    @Autowired
    F14020306Service service;

    /**
     * 重复待遇清理校验               *****(ok)
     * long aac001 人员id
     * <p>
     * Double bic008 = 0.0; // 个人账户存储额
     * Double bic009 = 0.0; // 个人缴费存储额
     * Long aae201; // 实际缴费月数
     * Long aac049; // 首次参保年月
     * Long aab001; // 单位ID
     * Long baz057;
     * String aae140; // 险种类型
     * String aae410;// 业务年月
     * Long aac001;// 人员id
     * String aaa027; // 统筹区编码
     */
    @Test
    public void test() {
        F14020306QueryInputParams input = new F14020306QueryInputParams();
        input.setAac001(Long.valueOf("1000000046"));
        F14020306QueryOutputParams out = service.queryF14020306Info(input);
        out(out);
    }

    /**
     * 重复待遇清理计算待遇
     * <p>
     * F14020306ComputeInputParams
     * <p>
     * Long aac001; // 个人ID
     * String aaa027; // 统筹区编码
     * Long aic301; // 终止年月
     * String aaa076; // 待遇核定类型
     * Double bic008; // 个人账户存储额
     * Long baz057; // TODO
     * <p>
     * F14020306ComputeOutputParams
     * <p>
     * boolean bizSuccess;
     * String errorCode;
     * String message;
     * Double yfje;//已发金额
     * Double paysum;//总额
     * Double kcje;// 扣发金额
     * List<Ac0cSaveDTO> detailResults;//待遇计算列表
     * List<RetroDeductOutDTO> deductOutDTOs;//补扣发信息
     * List<Ac82SaveDTO> listAc82;//已发信息
     * Long baz057;
     * String aae140;// 险种类型
     * <p>
     * <p>
     * Ac0cSaveDTO字段属性如下:
     * <p>
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
     * <p>
     * RetroDeductOutDTO字段属性如下:
     * <p>
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
     * <p>
     * AC82SaveDTO属性字段如下:
     * Long aaz220; // 人员应付计划事件ID
     * Long aaz030; // 应付计划事件ID
     * Long aac001; // 人员ID
     * Long aab001; // 单位ID
     * String aae140; // 险种类型
     * String aaa027; // 统筹区编码
     * String baf307; // 所属区
     * Long aae002; // 费款所属期
     * String aae006; // 地址
     * String aae007; // 邮政编码
     * String bae118; // 银行代码
     * String bae119; // 银行网点代码
     * String bab007; // 银行名称
     * String aae009; // 户名
     * String aae010; // 银行帐号
     * Long aaz009; // 代发机构ID
     * String aab301; // 所属行政区代码
     * Long aaz097; // 待遇发放方式登记事件ID
     * Long aaz099; // 待遇发放信息ID
     * Long aaz159; // 人员参保关系ID
     * String aae145; // 发放渠道
     * String aaa079; // 拨付方式
     * String bae023; // 支付状态
     * Double bae135; // 应发金额
     * Double bae136; // 扣回金额
     * Double aae019; // 实发金额
     * String bae024; // 应付来源
     * String aae013; // 备注
     */
    @Test
    public void test1() {
        F14020306ComputeInputParams inputcom = new F14020306ComputeInputParams();
        inputcom.setAaa121("F140207");
        inputcom.setAaa076("16");
        inputcom.setAac001(Long.valueOf("1000000046"));
        inputcom.setAic301(Long.valueOf("201601"));
        inputcom.setBic008(310D);
        inputcom.setBaz057(Long.valueOf(10000));
        F14020306ComputeOutputParams outputcomp = service.f14020306computeteam(inputcom);
        out(outputcomp);
    }


    /**
     * 重复待遇清理保存
     * <p>
     * Long aac001;// 个人ID
     * String aaa171;// 追回处理类型
     * Long aab001;// 单位ID
     * String aic301;// 应终止年月
     * String aae013;// 备注
     * Long baz039;// 待遇计算ID
     * Long aaz257;// 定期 待遇领取人员ID
     * <p>
     * Double paysum;// 支付总额
     * Double kcje;// 扣发金额
     * Double yfTotal;// 应发总额
     * Double sfje;// 扣发金额
     * <p>
     * Long aae201; // 实际缴费月数
     * Double bic008; // 个人账户存储额
     * Double bic009; // 个人缴费存储额
     * String aae140; // 险种类型
     * BankAccountAduitDTO bankAccountAduitvo;
     * List<RetroDeductOutDTO> retrdeductoutDto = new ArrayList<RetroDeductOutDTO>();// 补扣发
     * <p>
     * BankAccountAduitDTO 字段属性如下：
     * Long   aaz097 ;         //待遇发放方式登记事件ID
     * Long   aac001 ;         //人员ID
     * Long   aaz257 ;         //享受定期待遇人员ID
     * Long   aaz003 ;         //当事人银行账号ID
     * String aae145 ;         //发放渠道
     * String aaa079 ;         //拨付方式
     * String aae006 ;         //地址
     * String aae007 ;         //邮政编码
     * Long   aaz009 ;         //代发机构ID
     * String bae118 ;         //银行代码
     * String bae119 ;         //银行网点代码
     * String bab007 ;         //银行名称
     * String aae009 ;         //户名
     * String aae010 ;         //银行帐号
     * String aaa126 ;         //开户状态标志
     * String aaa027 ;         //统筹区编码
     * String bae183 ;         //异地发放标志
     * String aab301 ;         //所属行政区代码
     * String aae013 ;         //备注
     * String aae005 ;         //联系电话
     * String aae147 ;         //本人定居生活地
     * String bae127 ;         //备用标识
     * String aae413 ;         //审批人姓名
     * String bae128 ;         //业务描述
     * String aaa121 ;         //业务类型
     * Long   aaz002 ;         //业务日志ID
     * <p>
     * <p>
     * <p>
     * boolean bizSuccess;
     * String errorCode;
     * String message
     */
    @Test
    public void test2() {
        F14020306SaveInputParams saveparams = new F14020306SaveInputParams();
        saveparams.setAac049("201404");
        saveparams.setAac001(Long.valueOf("1000000046"));
        saveparams.setAaa171("0");
        saveparams.setAab001(Long.valueOf("100000421"));
        saveparams.setAic301("201002");
        saveparams.setAae013("bz");
        saveparams.setBaz039(Long.valueOf("200003"));
        saveparams.setAaz257(Long.valueOf("100000"));
        saveparams.setPaysum(310D);
        saveparams.setKcje(10D);
        saveparams.setYfje(1D);
        saveparams.setYfTotal(30D);
        saveparams.setSfje(300D);
        saveparams.setAae201(Long.valueOf("3"));
        saveparams.setBic008(310D);
        saveparams.setBic009(50D);
        saveparams.setAae140("110");
        BankAccountAduitDTO bank = new BankAccountAduitDTO();
        bank.setAac001(Long.valueOf("1000000577"));
        bank.setAaa079("1");
        bank.setAae145("11");
        bank.setAae147("1");
        bank.setBae118("001");
        bank.setBab007("测试银行");
        bank.setAae009("测试人员");
        bank.setAae010("62284800000000000");
        saveparams.setBankAccountAduitvo(bank);
        F14020306SaveOutputParams outputParams = service.saveF14020306Info(saveparams);
        out(outputParams);
    }
}
