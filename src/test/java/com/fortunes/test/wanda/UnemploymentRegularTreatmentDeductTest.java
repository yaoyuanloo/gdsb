package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020203.params.CommonTerminalInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020204.params.DeductDetailDTO;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020206.params.GetTerminalDeductInfoOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020206.params.TerminalDeductInfoSaveInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020206.params.TerminalDeductInfoSaveOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.params.RetroDeductDTO;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030205.F14030205ServiceVS;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 失业定期待遇扣发
 * Created by cxd on 2016/10/28 0028.
 */
public class UnemploymentRegularTreatmentDeductTest extends DubboTest {

    @Autowired
    F14030205ServiceVS service;

    /**
     * 获取失业定期待遇信息
     *
     * CommonTerminalInputParams基类,该基类包含以下几个字段:
     * Long     aac001;  // 人员ID
     * String   aae140;  // 险种类型(“210”)
     * Long     baz057;  // 代发代扣类型(传入1000000L）
     * String   aaa121;  // 业务类型编码(“F140232”)
     *
     * CommonTerminalInputParams基类,该基类包含以下几个字段:
     * boolean  bizSuccess; // 接口调用是否成功，true表示成功，false表示失败
     * String   errorCode;  // 错误码（失败时返回错误码）
     * String   message;    // 信息（失败时返回的错误信息）
     * //成功时返回以下信息
     * Long     aaz257;    // 享受定期待遇人员ID
     * Long     aac001;    // 人员ID
     * String   aae140;    // 险种类型
     * Long     bac180;    // 定期待遇首次发放年月
     * // 定期待遇项目列表
     * private List<TerminalDTO> termianlList = new ArrayList<TerminalDTO>();
     * TerminalDTO实体属性如下：
     * String   aaa036;    // 待遇项目代码
     * Long     aae041;    // 开始年月
     * Long     aae042;    // 终止年月
     * Double   aae019;    // 金额
     * Long     baz057;    // 代发代扣类型
     */
    @Test
    public void test(){
        //获取失业定期待遇信息
        CommonTerminalInputParams input = new CommonTerminalInputParams();
        input.setAac001(1000001122L);
        input.setAaa121("F140232");
        input.setAae140("210");
        input.setBaz057(100000L);
        GetTerminalDeductInfoOutputParams output = this.service.getUnemploymentDeductInfo(input);
        out(output);
    }

    /**
     * 保存失业定期待遇扣发信息
     *
     * TerminalDeductInfoSaveInputParams基类,该基类包含以下几个字段:
     * Long     aac001;      // 人员ID
     * String   aae140;      // 险种类型
     * String   aaa027;      // 统筹区
     * Long     aaz257;      // 享受定期待遇人员ID
     * String   ldclbkfFlag; // 联动处理补扣发
     * Long     zhMonth;     // 计划扣发月数
     * Long     jhAae041;    // 计划扣发开始年月
     * String   yqdkkxy;     // 是否已签订扣款协议
     * String   aaa171;      // 扣款方式
     * String   aaa121;      // 业务类型编码
     * String   aae161;      // 核销原因
     * //扣发项目列表
     * private List<RetroDeductDTO> retroDeductList = new ArrayList<RetroDeductDTO>();
     * //按月扣发明细列表（扣款方式为‘2.按月扣发’ 时提供）
     * private List<DeductDetailDTO> deductDetailList = new ArrayList<DeductDetailDTO>();
     *
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
     * String   retroDeductDetailStr;// 待遇明细拼接字符串
     *
     * DeductDetailDTO实体属性如下：
     * String   aaa036;     // 项目代码
     * Long     aae002;     // 计划扣发月份（6位如201605）
     * Double   aae019;     // 计划扣发月金额
     *
     * TerminalDeductInfoSaveOutputParams基类，该基类包含如下属性：
     * boolean  bizSuccess; // 接口调用是否成功，true表示成功，false表示失败
     * String   errorCode;  // 错误码（失败时返回错误码）
     * String   message;    // 信息（失败时返回的错误信息）
     */
    @Test
    public void test1(){
        //获取失业定期待遇信息
        CommonTerminalInputParams input = new CommonTerminalInputParams();
        input.setAac001(1000001122L);
        input.setAaa121("F140232");
        input.setAae140("210");
        input.setBaz057(100000L);
        GetTerminalDeductInfoOutputParams output = this.service.getUnemploymentDeductInfo(input);
        //保存失业定期待遇扣发信息
        TerminalDeductInfoSaveInputParams input2 = new TerminalDeductInfoSaveInputParams();
        BeanUtils.copyProperties(output, input2);
        input2.setAaa121("F140231");
        input2.setAaa171("2");
        input2.setAaa027("440000");
        //手动设置扣发项目
        List<RetroDeductDTO> deductList = new ArrayList<RetroDeductDTO>();
        //第一个扣发项目
        RetroDeductDTO deduct = new RetroDeductDTO();
        deduct.setAaa036("210322");
        deduct.setAaa077("24");
        deduct.setAaa078("2");
        deduct.setAae041(201601L);
        deduct.setAae042(201610L);
        deduct.setAae129(10000D);
        deduct.setBae069(10L);
        deduct.setBaz057(100000L);
        deduct.setJhAae041(201611L);
        deduct.setBac026(833.33D);
        deduct.setZhMonth(12l);
        deductList.add(deduct);
        //第二个扣发项目
        deduct = new RetroDeductDTO();
        deduct.setAaa036("210421");
        deduct.setAaa077("24");
        deduct.setAaa078("2");
        deduct.setAae041(201605L);
        deduct.setAae042(201610L);
        deduct.setAae129(7000D);
        deduct.setBae069(6L);
        deduct.setBaz057(100000L);
        deduct.setJhAae041(201611L);
        deduct.setBac026(1166.70D);
        deduct.setZhMonth(6l);
        deductList.add(deduct);
        input2.setRetroDeductList(deductList);
        //设置扣发项目按月扣发明细
        List<DeductDetailDTO> deductdetailList = new ArrayList<DeductDetailDTO>();
        //第一个扣发项目按月扣发明细（计划扣发月数12，计划扣发开始年月201611）
        DeductDetailDTO deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210322");
        deductdto.setAae002(201611L);
        deductdto.setAae019(833.33D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210322");
        deductdto.setAae002(201612L);
        deductdto.setAae019(833.33D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210322");
        deductdto.setAae002(201701L);
        deductdto.setAae019(833.33D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210322");
        deductdto.setAae002(201702L);
        deductdto.setAae019(833.33D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210322");
        deductdto.setAae002(201703L);
        deductdto.setAae019(833.33D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210322");
        deductdto.setAae002(201704L);
        deductdto.setAae019(833.33D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210322");
        deductdto.setAae002(201705L);
        deductdto.setAae019(833.33D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210322");
        deductdto.setAae002(201706L);
        deductdto.setAae019(833.33D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210322");
        deductdto.setAae002(201707L);
        deductdto.setAae019(833.33D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210322");
        deductdto.setAae002(201708L);
        deductdto.setAae019(833.33D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210322");
        deductdto.setAae002(201709L);
        deductdto.setAae019(833.33D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210322");
        deductdto.setAae002(201710L);
        deductdto.setAae019(833.37D);
        deductdetailList.add(deductdto);
        //第二个扣发项目按月扣发明细（计划扣发月数6，计划扣发开始年月201611）
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210421");
        deductdto.setAae002(201611L);
        deductdto.setAae019(1166.67D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210421");
        deductdto.setAae002(201612L);
        deductdto.setAae019(1166.67D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210421");
        deductdto.setAae002(201701L);
        deductdto.setAae019(1166.67D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210421");
        deductdto.setAae002(201702L);
        deductdto.setAae019(1166.67D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210421");
        deductdto.setAae002(201703L);
        deductdto.setAae019(1166.67D);
        deductdetailList.add(deductdto);
        deductdto = new DeductDetailDTO();
        deductdto.setAaa036("210421");
        deductdto.setAae002(201704L);
        deductdto.setAae019(1166.65D);
        deductdetailList.add(deductdto);
        input2.setDeductDetailList(deductdetailList);
        TerminalDeductInfoSaveOutputParams output2 = this.service.saveUnemploymentDeductInfo(input2);
        out(output2);
    }
}
