package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020203.params.CommonTerminalInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020205.F14020205ServiceVS;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020205.params.GetPerTerminalRetroInfoOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020205.params.TerminalRetroInfoSaveInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020205.params.TerminalRetroInfoSaveOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.params.RetroDeductDTO;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 离退休待遇补发
 * Created by cxd on 2016/10/28 0028.
 */
public class RetireRegularTreatmentRepairTest extends DubboTest {

    @Autowired
    F14020205ServiceVS service;

    /**
     * 获取养老定期待遇信息
     * CommonTerminalInputParams基类,该基类包含以下几个字段:
     * Long aac001; // 人员ID
     * String aae140; // 险种类型(“110”)
     * Long baz057; // 代发代扣类型(传入1000000L）
     * String aaa121; // 业务类型编码(“F140220”)
     * <p>
     * GetPerTerminalRetroInfoOutputParams基类，该积累包含以下属性：
     * boolean bizSuccess;// 接口调用是否成功，true表示成功，false表示失败
     * String errorCode;// 错误码（失败时返回错误码）
     * String message;// 信息（失败时返回的错误信息）
     * //成功时返回以下信息
     * Long aaz257; // 享受定期待遇人员ID
     * Long aac001; // 人员ID
     * String aae140; // 险种类型
     * Long bac180; // 定期待遇首次发放年月
     * // 定期待遇项目列表
     * private List<TerminalDTO> termianlList = new ArrayList<TerminalDTO>();
     * <p>
     * TerminalDTO实体属性如下：
     * String aaa036; // 待遇项目代码
     * Long aae041; // 开始年月
     * Long aae042; // 终止年月
     * Double aae019; // 金额
     * Long baz057; // 代发代扣类型
     */
    @Test
    public void test() {
        //获取养老定期待遇信息
        CommonTerminalInputParams input = new CommonTerminalInputParams();
        input.setAac001(1000000977L);
        input.setAaa121("F140220");
        input.setAae140("110");
        input.setBaz057(100000L);
        GetPerTerminalRetroInfoOutputParams output = this.service.getPerTerminalRetroInfo(input);
        out(output);
    }

    /**
     * 保存养老定期待遇补发信息
     * <p>
     * TerminalRetroInfoSaveInputParams基类,该基类包含以下几个字段:
     * Long aaz257; // 享受定期待遇人员ID
     * Long aac001; // 人员ID
     * String aaa027; // 统筹区
     * String aae140; // 险种类型
     * //补发信息列表
     * private List<RetroDeductDTO> retrodeductList = new ArrayList<RetroDeductDTO>();
     * <p>
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
     * <p>
     * TerminalRetroInfoSaveOutputParams基类，该基类包含如下属性：
     * boolean bizSuccess;// 接口调用是否成功，true表示成功，false表示失败
     * String errorCode;// 错误码（失败时返回错误码）
     * String message;// 信息（失败时返回的错误信息）
     */
    @Test
    public void test1() {
        //获取养老定期待遇信息
        CommonTerminalInputParams input = new CommonTerminalInputParams();
        input.setAac001(1000000977L);
        input.setAaa121("F140220");
        input.setAae140("110");
        input.setBaz057(100000L);
        GetPerTerminalRetroInfoOutputParams output = this.service.getPerTerminalRetroInfo(input);
        //保存养老定期待遇补发信息
        TerminalRetroInfoSaveInputParams input2 = new TerminalRetroInfoSaveInputParams();
        BeanUtils.copyProperties(output, input2);
        input2.setAaa027("440000");
        input2.setAae140("110");
        //手动设置补发信息
        List<RetroDeductDTO> retroList = new ArrayList<RetroDeductDTO>();
        RetroDeductDTO retro = new RetroDeductDTO();
        retro.setAaa036("110001");
        retro.setAaa077("14");
        retro.setAaa078("1");
        retro.setAae041(201601L);
        retro.setAae042(201610L);
        retro.setAae129(13000D);
        retro.setBae069(10L);
        retro.setBaz057(100000L);
        retroList.add(retro);
        retro = new RetroDeductDTO();
        retro.setAaa036("110003");
        retro.setAaa077("14");
        retro.setAaa078("1");
        retro.setAae041(201604L);
        retro.setAae042(201610L);
        retro.setAae129(8000D);
        retro.setBae069(7L);
        retro.setBaz057(100000L);
        retroList.add(retro);
        input2.setRetrodeductList(retroList);
        TerminalRetroInfoSaveOutputParams output2 = this.service.savePerTerminalRetroInfo(input2);
        out(output2);
    }
}
