package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020203.params.CommonTerminalInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020203.params.GetPerTerminalStopInfoOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020203.params.TerminalStopInfoSaveInputDTO;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020203.params.TerminalStopInfoSaveOutputDTO;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030202.F14030202ServiceVS;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 失业定期待遇停发
 * Created by cxd on 2016/10/28 0028.
 */
public class UnemploymentRegularTreatmentStopTest extends DubboTest {

    @Autowired
    F14030202ServiceVS service;

    /**
     * 获取失业待停发定期待遇信息
     *
     * CommonTerminalInputParams基类,该基类包含以下几个字段:
     * Long     aac001; // 人员ID
     * String   aae140; // 险种类型(“210”)
     * Long     baz057; // 代发代扣类型(传入1000000L）
     * String   aaa121; // 业务类型编码(“F140229”)
     *
     * GetPerTerminalStopInfoOutputParams基类,该基类包含以下几个字段:
     * boolean  bizSuccess; // 接口调用是否成功，true表示成功，false表示失败
     * String   errorCode;  // 错误码（失败时返回错误码）
     * String   message;    // 信息（失败时返回的错误信息）
     *
     * //成功时返回一下信息
     * Long     aaz257;   // 享受定期待遇人员ID
     * Long     aac001;   // 人员ID
     * String   aac063;   // 待遇享受人员类型
     * String   aae116;   // 待遇发放状态
     * String   aae140;   // 险种类型
     * Long     bac180;   // 定期待遇首次发放年月
     *
     * // 定期待遇项目列表
     *
     * private List<TerminalDTO> termianlList = new ArrayList<TerminalDTO>();
     *
     * TerminalDTO实体属性如下：
     * String   aaa036;   // 待遇项目代码
     * Long     aae041;   // 开始年月
     * Long     aae042;   // 终止年月
     * Double   aae019;   // 金额
     * Long     baz057;   // 代发代扣类型
     */
    @Test
    public void test(){
        //获取失业待停发定期待遇信息
        CommonTerminalInputParams input = new CommonTerminalInputParams();
        input.setAac001(1000001122L);
        input.setAaa121("F140229");
        input.setAae140("210");
        input.setBaz057(100000L);
        GetPerTerminalStopInfoOutputParams output = this.service.getUnemploymentTreatmentInfo(input);
        out(output);
    }

    /**
     * 保存失业定期待遇停发信息
     *
     * TerminalStopInfoSaveInputDTO基类,该基类包含以下几个字段:
     * Long     aac001;  // 人员ID
     * String   aaa027;  // 统筹区编码
     * String   aae140;  // 险种类型
     * Long     aaz257;  // 享受定期待遇人员ID
     * Long     aae041;  // 停发年月
     * String   aac063;  // 待遇享受人员类型
     * Long     aaz099;  // 待遇发放信息ID
     * String   aae160;  // 变更原因
     * Long     baz057;  // 代发代扣类型ID
     * String   bae243;  // 同时停发代发标志
     * String   aae013;  // 备注
     * String   aaa121;  // 业务类型编码
     *
     * TerminalStopInfoSaveOutputDTO基类,该基类包含以下几个字段:
     * boolean  bizSuccess; // 接口调用是否成功，true表示成功，false表示失败
     * String   errorCode;  // 错误码（失败时返回错误码）
     * String   message;    // 信息（失败时返回的错误信息）
     */
    @Test
    public void test1(){
        //获取失业待停发定期待遇信息
        CommonTerminalInputParams input = new CommonTerminalInputParams();
        input.setAac001(1000001122L);
        input.setAaa121("F140229");
        input.setAae140("210");
        input.setBaz057(100000L);
        GetPerTerminalStopInfoOutputParams output = this.service.getUnemploymentTreatmentInfo(input);
        //保存失业定期待遇停发信息
        TerminalStopInfoSaveInputDTO input2 = new TerminalStopInfoSaveInputDTO();
        BeanUtils.copyProperties(output, input2);
        input2.setAae041(201605L);
        input2.setAae160("1201");
        input2.setBae243("0");
        input2.setAaa121("F140229");
        TerminalStopInfoSaveOutputDTO output2 = this.service.saveUnemploymentSuspendedInfo(input2);
        out(output2);
    }
}
