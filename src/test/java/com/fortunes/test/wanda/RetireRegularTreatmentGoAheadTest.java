package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020203.params.CommonTerminalInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020204.F14020204ServiceVS;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020204.params.*;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 离退休待遇续发
 * Created by cxd on 2016/10/28 0028.
 */
public class RetireRegularTreatmentGoAheadTest extends DubboTest {

    @Autowired
    F14020204ServiceVS service;

    /**
     * 获取养老待续发定期待遇信息
     * CommonTerminalInputParams基类,该基类包含以下几个字段:
     * Long aac001; // 人员ID
     * String aae140; // 险种类型(“210”)
     * Long baz057; // 代发代扣类型(传入1000000L）
     * String aaa121; // 业务类型编码(“F140230”)
     *
     * GetPerTerminalContinueInfoOutputParams基类，该基类包含以下字段：
     * boolean bizSuccess;// 接口调用是否成功，true表示成功，false表示失败
     * String errorCode;// 错误码（失败时返回错误码）
     * String message;// 信息（失败时返回的错误信息）
     * //成功时返回以下信息
     * String aaa027; // 统筹区
     * Long aae041Itpt; // 上次停发时间
     * String aae160Itpt; // 停发原因
     * String aae013Itpt; // 停发备注
     * Date aae036Itpt; // 停发操作时间
     * String bae125Itpt; // 停发经办人
     * Long aaz257; // 享受定期待遇人员ID
     * Long aac001; // 人员ID
     * String aac063; // 待遇享受人员类型
     * String aae116; // 待遇发放状态
     * String aae140; // 险种类型
     * Long bac180; // 定期待遇首次发放年月
     *
     * //定期待遇项目列表
     * private List<TerminalDTO> termianlList = new ArrayList<TerminalDTO>();
     *
     * TerminalDTO实体类属性如下：
     * String aaa036; // 待遇项目代码
     * Long aae041; // 开始年月
     * Long aae042; // 终止年月
     * Double aae019; // 金额
     * Long baz057; // 代发代扣类型
     */
    @Test
    public void test(){
        CommonTerminalInputParams input = new CommonTerminalInputParams();
        input.setAac001(1000000951L);
        input.setAaa121("F140219");
        input.setAae140("110");
        input.setBaz057(100000L);
        GetPerTerminalContinueInfoOutputParams output = this.service.getPerTerminalContinueInfo(input);
        out(output);
    }

    /**
     * 计算养老定期待遇接续补扣发
     *
     * CalcContinueRetroDeductInputDTO基类，该基类包含以下属性：
     * String bae243; // 联动处理代发(养老)
     * Long aaz257; // 享受定期待遇人员ID
     * Long aac001; // 人员ID
     * String aae140; // 险种类型
     * String aaa027; // 统筹区编码
     * Long baz057; // 代发代扣类型ID
     * Long aae041; // 续发开始年月
     * Long aae041Itpt; // 上次停发年月
     *
     * CalcContinueRetroDeductOutputDTO基类，该基类包含以下属性：
     * boolean bizSuccess;// 接口调用是否成功，true表示成功，false表示失败
     * String errorCode;// 错误码（失败时返回错误码）
     * String message;// 信息（失败时返回的错误信息）
     *
     * // 补扣发信息列表
     * List<RetroDeductDTO> retroDeductList = new ArrayList<RetroDeductDTO>();
     * Double bfze; // 补发总额
     * Double kfze; // 扣发总额
     */
    @Test
    public void test1(){
        //获取养老待续发定期待遇信息
        CommonTerminalInputParams input = new CommonTerminalInputParams();
        input.setAac001(1000000951L);
        input.setAaa121("F140219");
        input.setAae140("110");
        input.setBaz057(100000L);
        GetPerTerminalContinueInfoOutputParams output = this.service.getPerTerminalContinueInfo(input);
        //计算养老定期待遇接续补扣发
        CalcContinueRetroDeductInputDTO input2 = new CalcContinueRetroDeductInputDTO();
        BeanUtils.copyProperties(output, input2);
        input2.setBae243("0");
        input2.setAae041(201605L);
        input2.setBaz057(100000L);
        CalcContinueRetroDeductOutputDTO output2 = this.service.calcContinueRetroDeductInfo(input2);
        out(output2);
    }

    /**
     * 保存养老定期待遇续发信息
     *
     * TerminalContinueSaveInputParams基类，该基类包含以下属性：
     * Long aac001; // 人员ID
     * String aae140; // 险种类型
     * String aaa027; // 统筹区
     * Long aaz257; // 享受定期待遇人员ID
     * String ldclbkfFlag; // 联动处理补扣发
     * Long zhMonth; // 计划扣发月数
     * Long jhAae041; // 计划扣发开始年月
     * String yqdkkxy; // 是否已签订扣款协议
     * String aaa171; // 扣款方式
     * Double bfze; // 补发总额
     * Double kfze; // 扣发总额
     * String aaa121; // 业务类型编码
     * String aae161; // 核销原因
     * Long aae041; // 续发开始年月
     * String aae160; // 续发原因
     * String bae243; // 联动处理代发
     *
     * //补扣发项目列表
     * private List<RetroDeductDTO> retroDeductList = new ArrayList<RetroDeductDTO>();
     *
     * //按月扣款明细列表（当扣款方式为2.按月扣款时提供）
     * private List<DeductDetailDTO> deductDetailList = new ArrayList<DeductDetailDTO>();
     *
     * RetroDeductDTO实体属性如下：
     * Long aae041; // 补扣发开始年月
     * Long aae042; // 补扣发截止年月
     * Double aae129; // 待遇补扣发总额
     * Double bae134; // 个人账户支付金额
     * String aaa036; // 待遇项目代码
     * String aaa077; // 补扣发业务类型代码
     * String aaa078; // 补扣发标志
     * Long bae069; // 补扣发月数
     * String aae013; // 备注
     * Long baz057; // 代发代扣类型
     * String aaa171; // 扣发方式
     * Double bac026; // 按月扣减金额
     * Long jhAae041; // 计划扣发开始年月
     * Long zhMonth; // 计划扣发月数
     * String retroDeductDetailStr; // 待遇明细拼接字符串
     *
     * DeductDetailDTO实体属性如下：
     * String aaa036; // 项目代码
     * Long aae002; // 计划扣发月份（6位如201605）
     * Double aae019; // 计划扣发月金额
     *
     * TerminalContinueSaveOutputParams基类，该基类包含以下属性：
     * boolean bizSuccess;// 接口调用是否成功，true表示成功，false表示失败
     * String errorCode;// 错误码（失败时返回错误码）
     * String message;// 信息（失败时返回的错误信息）
     */
    @Test
    public void test2(){
        //获取养老待续发定期待遇信息
        CommonTerminalInputParams input = new CommonTerminalInputParams();
        input.setAac001(1000000951L);
        input.setAaa121("F140219");
        input.setAae140("110");
        input.setBaz057(100000L);
        GetPerTerminalContinueInfoOutputParams output = this.service.getPerTerminalContinueInfo(input);
        //计算养老定期待遇接续补扣发
        CalcContinueRetroDeductInputDTO input2 = new CalcContinueRetroDeductInputDTO();
        BeanUtils.copyProperties(output, input2);
        input2.setBae243("0");
        input2.setAae041(201605L);
        input2.setBaz057(100000L);
        CalcContinueRetroDeductOutputDTO output2 = this.service.calcContinueRetroDeductInfo(input2);
        //保存养老定期待遇续发信息
        TerminalContinueSaveInputParams input3 = new TerminalContinueSaveInputParams();
        BeanUtils.copyProperties(output, input3);
        BeanUtils.copyProperties(output2, input3);
        input3.setAaa171("4");
        input3.setYqdkkxy("1");
        input3.setAae041(201605L);
        input3.setBae243("0");
        input3.setAae160("1300");
        input3.setLdclbkfFlag("1");
        TerminalContinueSaveOutputParams output3 = this.service.saveTerminalContinueInfo(input3);
        out(output3);
    }
}
