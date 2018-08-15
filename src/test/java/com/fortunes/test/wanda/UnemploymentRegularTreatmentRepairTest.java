package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020203.params.CommonTerminalInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020205.params.GetPerTerminalRetroInfoOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020205.params.TerminalRetroInfoSaveInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020205.params.TerminalRetroInfoSaveOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.params.RetroDeductDTO;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030204.F14030204ServiceVS;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cxdwe on 2016/10/28 0028.
 */
public class UnemploymentRegularTreatmentRepairTest extends DubboTest {

    @Autowired
    F14030204ServiceVS service;

    /**
     * 获取失业定期待遇信息
     * <p>
     * CommonTerminalInputParams基类,该基类包含以下几个字段:
     * Long     aac001;  // 人员ID
     * String   aae140;  // 险种类型(“210”)
     * Long     baz057;  // 代发代扣类型(传入1000000L）
     * String   aaa121;  // 业务类型编码(“F140231”)
     * <p>
     * GetPerTerminalRetroInfoOutputParams基类，该积累包含以下属性：
     * boolean  bizSuccess; // 接口调用是否成功，true表示成功，false表示失败
     * String   errorCode;  // 错误码（失败时返回错误码）
     * String   message;    // 信息（失败时返回的错误信息）
     * //成功时返回以下信息
     * Long     aaz257;  // 享受定期待遇人员ID
     * Long     aac001;  // 人员ID
     * String   aae140;  // 险种类型
     * Long     bac180;  // 定期待遇首次发放年月
     * // 定期待遇项目列表
     * private List<TerminalDTO> termianlList = new ArrayList<TerminalDTO>();
     * <p>
     * TerminalDTO实体属性如下：
     * String   aaa036;  // 待遇项目代码
     * Long     aae041;  // 开始年月
     * Long     aae042;  // 终止年月
     * Double   aae019;  // 金额
     * Long     baz057;  // 代发代扣类型
     */
    @Test
    public void test() {
        //获取失业定期待遇信息
        CommonTerminalInputParams input6 = new CommonTerminalInputParams();
        input6.setAac001(1000001122L);
        input6.setAaa121("F140231");
        input6.setAae140("210");
        input6.setBaz057(100000L);
        GetPerTerminalRetroInfoOutputParams output6 = this.service.getUnemploymentRetroInfo(input6);
        out(output6);
    }

    /**
     * 保存失业定期待遇补发信息
     * <p>
     * TerminalRetroInfoSaveInputParams基类,该基类包含以下几个字段:
     * Long     aaz257;  // 享受定期待遇人员ID
     * Long     aac001;  // 人员ID
     * String   aaa027;  // 统筹区
     * String   aae140;  // 险种类型
     * <p>
     * //补发信息列表
     * private List<RetroDeductDTO> retrodeductList = new ArrayList<RetroDeductDTO>();
     * <p>
     * RetroDeductDTO实体属性如下：
     * Long     aae041;      // 补扣发开始年月
     * Long     aae042;      // 补扣发截止年月
     * Double   aae129;      // 待遇补扣发总额
     * Double   bae134;      // 个人账户支付金额
     * String   aaa036;      // 待遇项目代码
     * String   aaa077;      // 补扣发业务类型代码
     * String   aaa078;      // 补扣发标志
     * Long     bae069;      // 补扣发月数
     * String   aae013;      // 备注
     * Long     baz057;      // 代发代扣类型
     * String   aaa171;      // 扣发方式
     * Double   bac026;      // 按月扣减金额
     * Long     jhAae041;    // 计划扣发开始年月
     * Long     zhMonth;     // 计划扣发月数
     * String   retroDeductDetailStr; // 待遇明细拼接字符串
     * <p>
     * TerminalRetroInfoSaveOutputParams基类，该基类包含如下属性：
     * boolean  bizSuccess; // 接口调用是否成功，true表示成功，false表示失败
     * String   errorCode;  // 错误码（失败时返回错误码）
     * String   message;    // 信息（失败时返回的错误信息）
     */
    @Test
    public void test1() {
        //获取失业定期待遇信息
        CommonTerminalInputParams input6 = new CommonTerminalInputParams();
        input6.setAac001(1000001122L);
        input6.setAaa121("F140231");
        input6.setAae140("210");
        input6.setBaz057(100000L);
        GetPerTerminalRetroInfoOutputParams output6 = this.service.getUnemploymentRetroInfo(input6);
        //保存失业定期待遇补发信息
        TerminalRetroInfoSaveInputParams input7 = new TerminalRetroInfoSaveInputParams();
        BeanUtils.copyProperties(output6, input7);
        input7.setAaa027("440000");
        input7.setAae140("210");
        //手动设置补发项目
        List<RetroDeductDTO> retroList = new ArrayList<RetroDeductDTO>();
        //第一个补发项目
        RetroDeductDTO retro = new RetroDeductDTO();
        retro.setAaa036("210322");
        retro.setAaa077("14");
        retro.setAaa078("1");
        retro.setAae041(201601L);
        retro.setAae042(201610L);
        retro.setAae129(13000D);
        retro.setBae069(10L);
        retro.setBaz057(100000L);
        retroList.add(retro);
        //第二个补发项目
        retro = new RetroDeductDTO();
        retro.setAaa036("210103");
        retro.setAaa077("14");
        retro.setAaa078("1");
        retro.setAae041(201604L);
        retro.setAae042(201610L);
        retro.setAae129(8000D);
        retro.setBae069(7L);
        retro.setBaz057(100000L);
        retroList.add(retro);
        input7.setRetrodeductList(retroList);
        TerminalRetroInfoSaveOutputParams output7 = this.service.saveUnemploymentRetroInfo(input7);
        out(output7);
    }
}
