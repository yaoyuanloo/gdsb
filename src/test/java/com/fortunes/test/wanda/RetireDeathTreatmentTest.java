package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.F14020301ServiceVS;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.params.*;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cxd on 2016/10/28 0028.
 */
public class RetireDeathTreatmentTest extends DubboTest {

    @Autowired
    F14020301ServiceVS service;

    /**
     * 获取待终止离退休人员定期待遇信息
     * public RetireDeathQueryOutputParams retireDeathInfoQuery(
     * RetireDeathQueryInputParams inputParams);
     * 5.1.1服务接口方法参数类设计标准
     * 提供
     * com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.params.RetireDeathQueryInputParams基类,该基类包含以下几个字段:
     * private Long aac001; // 人员ID
     * private String aae160; // 待遇核定类型(1401.离退休死亡，6401.在职死亡)
     * 5.1.2 服务接口方法返回值类设计标准
     * 提供
     * com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.params.RetireDeathQueryOutputParams基类,该基类包含以下几个字段:
     * protected boolean bizSuccess;// 接口调用是否成功，true表示成功，false表示失败
     * protected String errorCode;// 错误码（失败时返回错误码）
     * protected String message;// 信息（失败时返回的错误信息）
     * //成功时返回以下信息
     * private String aaa027; // 统筹区
     * private Long aac001; // 人员ID
     * private Long aaz257; // 享受定期待遇人员ID
     * private Double bic008; // 个人账户存储额
     * private Double bic009; // 个人缴费存储额
     * private Long aae201; // 实际缴费月数
     * private String aaa076; // 待遇核定类型
     * private String aic161; // 离退休类别
     * private Long aac049; // 首次参保缴费年月
     * private Double bae073; // 上年度在岗职工月平均工资
     * private String aae140; // 险种类型
     * private Long aaz159; // 参保关系ID
     * private String baa606; // 是否存在供养直系亲属标志
     * private String baa605; // 是否存在供养直系亲属标志
     * private String ajc501; // 是否领取失业死亡丧葬费标志
     * private String alc300; // 是否领取工伤死亡丧葬费标志
     */
    @Test
    public void test() {
        //死亡一次性待遇查询
        RetireDeathQueryInputParams input = new RetireDeathQueryInputParams();
        input.setAac001(1000000964L);
        input.setAae160("1401");
        RetireDeathQueryOutputParams output = this.service.retireDeathInfoQuery(input);
        out(output);
    }

    /**
     * 计算死亡终止一次性待遇以及补扣发
     * public RetireDeathCalcOutputParams retireDeathBenefitCalc(
     * RetireDeathCalcInputParams inputParams);
     * 5.2.1服务接口方法参数类设计标准
     * 提供
     * com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.params.RetireDeathCalcInputParams基类,该基类包含以下几个字段:
     * private Long aac001; // 人员ID
     * private String aaa027; // 统筹区
     * private Long aaz257; // 享受定期待遇人员ID
     * private Double bic008; // 个人账户存储额
     * private String aic161; // 离退休类别
     * private Long aic301; // 待遇终止年月
     * private String aae160; // 变更原因
     * private String baa606; // 是否存在供养直系亲属标志
     * private String baa605; // 是否存在直系亲属标志
     * private String ajc501; // 是否领取失业死亡丧葬费标志
     * private String alc300; // 是否领取工伤死亡丧葬费标志
     * private String bae243; // 是否联动处理代发标志
     * <p>
     * 5.2.2 服务接口方法返回值类设计标准
     * 提供
     * com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.params.RetireDeathCalcOutputParams基类，该基类包含如下属性：
     * protected boolean bizSuccess;// 接口调用是否成功，true表示成功，false表示失败
     * protected String errorCode;// 错误码（失败时返回错误码）
     * protected String message;// 信息（失败时返回的错误信息）
     * private Double paysum; // 待遇发放总额
     * private Double yfje; // 应发金额
     * private Double sfje; // 实发金额
     * private Double kcje;// 补扣发金额
     * private String bkFlag;// 补扣标志
     * //待遇项目列表
     * private List<TerminalDetailDTO> detailList =
     * new ArrayList<TerminalDetailDTO>();
     * //补扣发项目列表
     * private List<RetroDeductDTO> retroDeductList =
     * new ArrayList<RetroDeductDTO>();
     * <p>
     * TerminalDetailDTO实体属性如下：
     * private String aaa036; // 待遇项目代码
     * private Long aae041; // 开始年月
     * private Long aae042; // 终止年月
     * private Double aae129; // 核发金额
     * private String bae011; // 显示公式
     * private String aae140; // 险种类型
     * private String aaa027; // 统筹区编码
     * private Long aac001; // 人员ID
     * private String aaz100; // 待遇方案ID
     * private String bac038; // 是否存在定期待遇
     * private String aaa085; // 定期标志
     * private String bae148; // 计算结果
     * private Long aaa200; // 运算要素编号
     * private String aaa201; // 运算要素名称
     * private String baa044; // 计算明细规则类型
     * private String aae013; // 备注
     * private String aae100; // 当前有效标志
     * private Double bae134; // 个人帐户支付金额
     * <p>
     * RetroDeductDTO实体属性如下：
     * private Long aae041; // 补扣发开始年月
     * private Long aae042; // 补扣发截止年月
     * private Double aae129; // 待遇补扣发总额
     * private Double bae134; // 个人账户支付金额
     * private String aaa036; // 待遇项目代码
     * private String aaa077; // 补扣发业务类型代码
     * private String aaa078; // 补扣发标志
     * private Long bae069; // 补扣发月数
     * private String aae013; // 备注
     * private Long baz057; // 代发代扣类型
     * private String aaa171; // 扣发方式
     * private Double bac026; // 按月扣减金额
     * private Long jhAae041; // 计划扣发开始年月
     * private Long zhMonth; // 计划扣发月数
     * private String retroDeductDetailStr; // 待遇明细拼接字符串
     */
    @Test
    public void test1() {
        //死亡一次性待遇查询
        RetireDeathQueryInputParams input = new RetireDeathQueryInputParams();
        input.setAac001(1000000964L);
        input.setAae160("1401");
        RetireDeathQueryOutputParams output = this.service.retireDeathInfoQuery(input);

        // 一次性待遇计算
        RetireDeathCalcInputParams input2 = new RetireDeathCalcInputParams();
        BeanUtils.copyProperties(output, input2);
        input2.setAae160("1401");
        input2.setAic301(201605L);
        input2.setBaa605("1");
        input2.setBaa606("0");
        input2.setBae243("0");
        RetireDeathCalcOutputParams output2 = this.service.retireDeathBenefitCalc(input2);
        out(output2);
    }

    /**
     * 保存死亡一次性待遇、补扣发信息
     * public RetireDeathSaveOutputParams retireDeathInfoSave(
     * RetireDeathSaveInputParams inputParams);
     * 5.2.1服务接口方法参数类设计标准
     * 提供
     * com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.params.RetireDeathCalcInputParams基类,该基类包含以下几个字段:
     * private Long aac001;// 个人ID
     * private Long aab001;// 单位ID
     * private String aae160;// 变更原因
     * private Long aic301;// 应终止年月
     * private Long aae138; // 死亡时间
     * private String aae013;// 备注
     * private Long aaz257;// 定期 待遇领取人员ID
     * private String aaa076;// 待遇核定类型
     * private Double paysum;// 支付总额
     * private String aac049;// 首次参保缴费年月
     * private BankDTO bankVO = new BankDTO(); // 发放信息vo
     * private Double kcje;// 扣发金额
     * private String aaa171;// 扣发处理方式
     * private String aic161; // 离退休类别
     * private Long aic162; // 离退休日期
     * // 遗属列表（如果gyzxqsFlag为1时即存在供养亲属时提供）
     * private List<SurvivorDTO> survivorList =
     * new ArrayList<SurvivorDTO>();
     * private Double bic008; // 个人账户存储额
     * private Double bic009; // 个人缴费存储额
     * private String bae243; // 是否联动处理代发标志
     * private String gyzxqsFlag; // 是否存在供养亲属标志
     * private String yqdkkxy; // 是否已签订扣款协议
     * private String aaa121; // 业务类型编码
     * // 补扣发列表（在职死亡人员不存在补扣发信息）
     * private List<RetroDeductDTO> retroDeductList =
     * new ArrayList<RetroDeductDTO>();
     * // 一次性待遇明细
     * private List<TerminalDetailDTO> terminalDetailList =
     * new ArrayList<TerminalDetailDTO>();
     * <p>
     * SurvivorDTO实体属性如下：
     * private Long aac001; // 人员ID
     * private String aac058; // 证件类型
     * private String aac147; // 证件号码
     * private String aac003; // 姓名
     * private String aac004; // 性别
     * private Long aac006; // 出生日期
     * private String aae005; // 固定电话
     * private String aac067; // 移动电话
     * private String aae144; // 供养关系
     * private String bae391; // 完全丧失劳动能力标志
     * <p>
     * RetroDeductDTO实体属性如下：
     * private Long aae041; // 补扣发开始年月
     * private Long aae042; // 补扣发截止年月
     * private Double aae129; // 待遇补扣发总额
     * private Double bae134; // 个人账户支付金额
     * private String aaa036; // 待遇项目代码
     * private String aaa077; // 补扣发业务类型代码
     * private String aaa078; // 补扣发标志
     * private Long bae069; // 补扣发月数
     * private String aae013; // 备注
     * private Long baz057; // 代发代扣类型
     * private String aaa171; // 扣发方式
     * private Double bac026; // 按月扣减金额
     * private Long jhAae041; // 计划扣发开始年月
     * private Long zhMonth; // 计划扣发月数
     * private String retroDeductDetailStr; // 待遇明细拼接字符串
     * <p>
     * TerminalDetailDTO实体属性如下：
     * private String aaa036; // 待遇项目代码
     * private Long aae041; // 开始年月
     * private Long aae042; // 终止年月
     * private Double aae129; // 核发金额
     * private String bae011; // 显示公式
     * private String aae140; // 险种类型
     * private String aaa027; // 统筹区编码
     * private Long aac001; // 人员ID
     * private String aaz100; // 待遇方案ID
     * private String bac038; // 是否存在定期待遇
     * private String aaa085; // 定期标志
     * private String bae148; // 计算结果
     * private Long aaa200; // 运算要素编号
     * private String aaa201; // 运算要素名称
     * private String baa044; // 计算明细规则类型
     * private String aae013; // 备注
     * private String aae100; // 当前有效标志
     * private Double bae134; // 个人帐户支付金额
     * <p>
     * 5.2.2 服务接口方法返回值类设计标准
     * 提供
     * com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.params.RetireDeathSaveOutputParams基类,该基类包含以下几个字段:
     * protected boolean bizSuccess;// 接口调用是否成功，true表示成功，false表示失败
     * protected String errorCode;// 错误码（失败时返回错误码）
     * protected String message;// 信息（失败时返回的错误信息）
     */
    @Test
    public void test2() {
        //死亡一次性待遇查询
        RetireDeathQueryInputParams input = new RetireDeathQueryInputParams();
        input.setAac001(1000000964L);
        input.setAae160("1401");
        RetireDeathQueryOutputParams output = this.service.retireDeathInfoQuery(input);

        // 一次性待遇计算
        RetireDeathCalcInputParams input2 = new RetireDeathCalcInputParams();
        BeanUtils.copyProperties(output, input2);
        input2.setAae160("1401");
        input2.setAic301(201605L);
        input2.setBaa605("1");
        input2.setBaa606("0");
        input2.setBae243("0");
        RetireDeathCalcOutputParams output2 = this.service.retireDeathBenefitCalc(input2);

        // 死亡一次性待遇信息保存.
        RetireDeathSaveInputParams input3 = new RetireDeathSaveInputParams();
        BeanUtils.copyProperties(output, input3);
        BeanUtils.copyProperties(input2, input3);
        BeanUtils.copyProperties(output2, input3);
        input3.setTerminalDetailList(output2.getDetailList());
        BankDTO bankdto = new BankDTO();
        bankdto.setAaa079("2");
        bankdto.setAae009("张三");
        bankdto.setAae010("1111111111111111111");
        bankdto.setAae140("110");
        bankdto.setAae145("11");
        bankdto.setAae147("1");
        bankdto.setBae118("102");
        bankdto.setAaa027("440000");
        bankdto.setAac001(1000000964L);
        bankdto.setAaz010(1000000964L);
        bankdto.setAae016("0");
        input3.setBankVO(bankdto);
        input3.setAae160("1401");
        input3.setAab001(100000389L);
        input3.setAaa171("4");
        input3.setYqdkkxy("1");
        input3.setAaa076("13");
        RetireDeathSaveOutputParams output3 = this.service.retireDeathInfoSave(input3);
        out(output3);
    }
}
