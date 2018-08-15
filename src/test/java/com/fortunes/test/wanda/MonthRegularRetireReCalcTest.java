package com.fortunes.test.wanda;

import com.fortunes.javamg.common.utils.DateUtils;
import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020106.params.*;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020106.vs.F14020106Service;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.params.BankDTO;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

/**
 * 月定期养老待遇重算
 * Created by cxd on 2016/10/29 0029.
 */
public class MonthRegularRetireReCalcTest extends DubboTest {
    @Autowired
    F14020106Service service;

    /**
     * 判断月定期养老待遇重算资格
     *
     * JudgeReCalculateQualificationInputParams;基类,该基类包含以下几个字段:
     * Long     aac001;  //人员ID
     * String   aaa027;  //统筹区编码
     *
     * JudgeReCalculateQualificationOutputParams;基类,该基类包含以下几个字段:
     * boolean  bizSuccess;
     * String   errorCode;
     * String   message;
     * Long     aaz257;      //享受定期待遇人员ID
     * Long     aaz099;      //待遇发放信息ID
     * String   ac73NewStr;  //新办法待遇项目JSON
     */
    @Test
    public void test(){
        //判断养老待遇重算资格
        JudgeReCalculateQualificationInputParams inputParams = new JudgeReCalculateQualificationInputParams();
        inputParams.setAac001(1000001348L);
        inputParams.setAaa027("440000");
        JudgeReCalculateQualificationOutputParams outputParams = service.judgeReCalculateQualification(inputParams);
        out(outputParams);
    }

    /**
     * 获取月定期养老待遇重算准备信息
     *
     * ReCalculatePreInfoInputParams基类,该基类包含以下几个字段:
     * Long     aac001;   //人员ID
     * Long     aaz257;   //享受定期待遇人员ID
     * Long     aaz099;   //待遇发放信息ID
     * String   aaa027;   //统筹区编码
     *
     * ReCalculatePreInfoOutputParams基类,该基类包含以下几个字段:
     * Long     aac001;          //人员ID
     * Long     aab001;          //单位ID
     * String   aab004;          //单位名称
     * Long     aaz261;          //养老退休行政审批ID
     * Long     baz001;          //因病鉴定ID
     * Long     aac083;          //退休前是原工伤定期待遇享受人员ID
     * Long     aaz159;          //人员参保关系ID
     * String   aae140;          //险种类型
     * Long     aic301;          //终止缴费年月
     * String   aaa121;          //业务类型
     * Long     aaz002;           //业务日志
     * String   details;         //ac73json转换
     * Long     bic220;          ////1998年6月30日前的缴费月数（视同+实际）
     * Long     bic221;          ////1998年6月30日前的特殊工种年限
     * String   deemPayIndexStr; //视同缴费指数计算Str
     * String   amountDTOsStr;   //视同总额计算记录Str
     * String   amountDTOs2Str;  //转移视同总额计算记录Str
     * String   aae006;          //家庭地址
     * String   aae005;          //固定电话
     * String   aae321;          //移动电话
     * Double   aic164;          //平均缴费指数
     * Double   aic164r;         //实际缴费指数
     * String   aac006Str;       //档案出生日期
     * Date     aac006Date;      //档案出生日期
     * String   aac007Str;       //档案参加工作日期
     * Date     aac007Date;      //档案参加工作日期
     * String   aic161;          //退休类型
     * Date     aic162Date;      //退休日期
     * Long     aae210;          //待遇执行起始年月
     * String   retirementAge;   //退休年龄
     * String   aac012;          //个人身份
     * String   aac020;          //行政职务
     * String   aac014;          //专业技术职务
     * String   aac015;          //职业资格等级
     * String   bac006;          //用工性质
     * String   bie086;          //军转干部级别
     * String   bie088;          //归侨标志
     * String   alc060;          //护理依赖等级
     * String   ala018;          //因病劳动能力鉴定结论
     * Date     alc034Date;      //因病劳动能力鉴定时间
     * Long     alc034;          //因病劳动能力鉴定时间
     * String   alc035;          //因病或非因工劳动能力鉴定书编号
     * String   bac178;          //获得荣誉详细情况
     * Date     aac049Date;      //首次参保年月
     * Long     aac049;          //首次参保年月
     * Long     aae201;          //实际缴费月数
     * Long     bic096;          //视同缴费月数
     * Long     bic215;          //连续工龄
     * Long     aae200;          //缴费月数合计
     * Long     bic071;          //病退(非特殊工龄)提前月数
     * Long     bic032;          //退休前从事特殊工种工作月数
     * Long     aae030;          //视同开始时间
     * Double   bic088;          //截至2006年6月30日视同账户
     * Long     bic091;          //转入月数
     * Double   bic092;          //转入金额
     * Double   bic113;          //视同缴费账户总额
     * Double   bic108;          //视同缴费指数
     * Double   bic008;          //账户存储额
     * Double   bic009;          //个人缴费存储额
     * Double   aic167;          //个人缴费占账户存储额比例
     * Double   bic104;          //地方养老金标准
     * Double   bic105;          //地方养老金总额
     * Long     aae003Max;       //最后缴费日期
     * Long     aaz257;          //享受定期待遇人员ID
     * Long     aac006;          //出生日期
     * Long     aac007;          //参加工作日期
     * Long     aic162;          //离退休日期
     * Long     bic084;          //视同年限截止时间
     */
    @Test
    public void test1(){
        //判断养老待遇重算资格
        JudgeReCalculateQualificationInputParams inputParams = new JudgeReCalculateQualificationInputParams();
        inputParams.setAac001(1000001348L);
        inputParams.setAaa027("440000");
        JudgeReCalculateQualificationOutputParams outputParams = service.judgeReCalculateQualification(inputParams);
        //获取养老待遇重算准备信息 .
        ReCalculatePreInfoInputParams inputParams2 = new ReCalculatePreInfoInputParams();
        BeanUtils.copyProperties(outputParams, inputParams2);
        inputParams2.setAac001(1000001348L);
        inputParams2.setAaa027("440000");
        ReCalculatePreInfoOutputParams outputParams2 = service.getReCalculatePreInfo(inputParams2);
        out(outputParams2);
    }

    /**
     * 月定期养老待遇重算计算
     *
     * ReCalculatePensionTreatmentInputParams基类,该基类包含以下几个字段:
     * Long     aac001;     //人员ID
     * String   aaa027;     //统筹区编码
     * String   aac006Str;  //档案出生日期
     * Double   bic008;     //个人账户存储额
     * Long     aac049;     //首次参加工作日期
     * String   aic162Str;  //核定退休日期
     * String   aac014;     //专业技术职务等级代码
     * Long     aae210;     //待遇始发年月
     * Double   bic105;     //地方养老金总额
     * String   bic123;     //新老办法标志
     * Long     aae201;     //实际缴费年限
     * Long     aic301;     //缴费终止年月
     * Long     bic096;     //视同缴费年限
     * String   aic161;     //退休类型
     * Long     bic220;     ////1998年6月30日前的缴费月数（视同+实际）
     * Long     bic221;     ////1998年6月30日前的特殊工种年限
     * String   aaa036_re;  //重核类型
     * Long     bic071;     //病退或其他非特殊工龄提前退休提前年限
     * String   aac019;     //特殊工种类型
     * Long     bic032;     //退休前前特殊工种工作月数
     *
     *
     * ReCalculatePensionTreatmentOutputParams基类,该基类包含以下几个字段:
     * boolean  bizSuccess;
     * String   errorCode;
     * String   message;
     * String   details;         // 待遇结果列表JSON
     * String   deductOutDTOsStr;//补扣发信息JSON
     * Long     aae030;          //视同开始年月
     * Double   bic113;          //视同账户总额
     * Double   aic164;          //平均缴费指数
     * Double   bic108;          //视同缴费指数
     * Double   aic164r;         //实际缴费指数
     * String   deemPayIndexStr; //视同缴费指数计算JSON
     * String   amountDTOsStr;   //视同总额计算记录JSON
     * String   amountDTOs2Str;  //转移视同总额计算记录JSON
     * String   ac98Str;         //实际缴费指数计算过程JSON
     * String   newOrOld;        //新老办法标志
     * String   ac73OldStr;      //老办法待遇项目JSON
     * String   ac73NewStr;      //新办法待遇项目JSON
     */
    @Test
    public void test2(){
        //判断养老待遇重算资格
        JudgeReCalculateQualificationInputParams inputParams = new JudgeReCalculateQualificationInputParams();
        inputParams.setAac001(1000001348L);
        inputParams.setAaa027("440000");
        JudgeReCalculateQualificationOutputParams outputParams = service.judgeReCalculateQualification(inputParams);
        //获取养老待遇重算准备信息 .
        ReCalculatePreInfoInputParams inputParams2 = new ReCalculatePreInfoInputParams();
        BeanUtils.copyProperties(outputParams, inputParams2);
        inputParams2.setAac001(1000001348L);
        inputParams2.setAaa027("440000");
        ReCalculatePreInfoOutputParams outputParams2 = service.getReCalculatePreInfo(inputParams2);
        //重算养老基本待遇
        ReCalculatePensionTreatmentInputParams inputParams3 = new ReCalculatePensionTreatmentInputParams();
        BeanUtils.copyProperties(outputParams2, inputParams3);
        BeanUtils.copyProperties(inputParams2, inputParams3);
        inputParams3.setAic162Str("201001");
        inputParams3.setAic301(200912L);
        inputParams3.setAac006Str("19470710");
        ReCalculatePensionTreatmentOutputParams outputParams3 = service.reCalculatePensionTreatment(inputParams3);
        out(outputParams3);
    }

    /**
     * 月定期养老待遇重算计算补扣发
     *
     * GetCompareResultInputParams基类,该基类包含以下几个字段:
     * Long     aac001;         //人员ID
     * String   details;        // 待遇结果列表JSON
     * Long     aae210;         //待遇始发年月
     * Long     aaz257;         //定期待遇人员ID
     * String   reCalculateType;//重算类型
     * String   aaa027;         //统筹区编码
     *
     * GetCompareResultOutputParams基类,该基类包含以下几个字段:
     * boolean  bizSuccess;
     * String   errorCode;
     * String   message;
     * String   originalAc61Json;   //单项重核原有待遇项目除重核待遇项目外的JSON
     * String   ac73SaveDTOs2Json;  //每年增资新增项目JSON
     * String   ac76SaveDTOsJson;   //按待遇项目补扣发记录JSON
     * String   deductionForRecalDTOsJson;  //按每月总额补扣发JSON
     */
    @Test
    public void test3(){
        //判断养老待遇重算资格
        JudgeReCalculateQualificationInputParams inputParams = new JudgeReCalculateQualificationInputParams();
        inputParams.setAac001(1000001348L);
        inputParams.setAaa027("440000");
        JudgeReCalculateQualificationOutputParams outputParams = service.judgeReCalculateQualification(inputParams);
        //获取养老待遇重算准备信息 .
        ReCalculatePreInfoInputParams inputParams2 = new ReCalculatePreInfoInputParams();
        BeanUtils.copyProperties(outputParams, inputParams2);
        inputParams2.setAac001(1000001348L);
        inputParams2.setAaa027("440000");
        ReCalculatePreInfoOutputParams outputParams2 = service.getReCalculatePreInfo(inputParams2);
        //重算养老基本待遇
        ReCalculatePensionTreatmentInputParams inputParams3 = new ReCalculatePensionTreatmentInputParams();
        BeanUtils.copyProperties(outputParams2, inputParams3);
        BeanUtils.copyProperties(inputParams2, inputParams3);
        inputParams3.setAic162Str("201001");
        inputParams3.setAic301(200912L);
        inputParams3.setAac006Str("19470710");
        ReCalculatePensionTreatmentOutputParams outputParams3 = service.reCalculatePensionTreatment(inputParams3);
        //获取重算后每月补扣发
        GetCompareResultInputParams compareResultInputParams = new GetCompareResultInputParams();
        BeanUtils.copyProperties(outputParams3, compareResultInputParams);
        BeanUtils.copyProperties(inputParams2, compareResultInputParams);
        GetCompareResultOutputParams compareResultOutputParams = new GetCompareResultOutputParams();
        compareResultInputParams.setAae210(201001L);
        compareResultInputParams.setReCalculateType("2");
        compareResultOutputParams = service.getCompareResult(compareResultInputParams);
        out(compareResultOutputParams);
    }

    /**
     * 月定期养老待遇重算保存
     *
     * SaveReCalPensionTreatmentInputParams;基类,该基类包含以下几个字段:
     * String   deductOutDTOsStr;//补扣发信息JSON
     * String   newOrOld;        //新老办法标志
     * String   ac73OldStr;      //老办法待遇项目JSON
     * String   ac73NewStr;      //新办法待遇项目JSON
     * String   aaa027;          //统筹区编码
     * Long     aac001;          //人员ID
     * Long     aab001;          //单位ID
     * String   aab004;          //单位名称
     * Long     aaz261;          //养老退休行政审批ID
     * Long     baz001;          //因病鉴定ID
     * Long     aac083;          //退休前是原工伤定期待遇享受人员ID
     * Long     aaz159;          //人员参保关系ID
     * String   aae140;          //险种类型
     * Long     aic301;          //终止缴费年月
     * String   aaa121;          //业务类型
     * Long     aaz002;          //业务日志
     * String   outgoing;        //流向
     * String   details;         //ac73json转换
     * Long     bic220;          ////1998年6月30日前的缴费月数（视同+实际）
     * Long     bic221;          ////1998年6月30日前的特殊工种年限
     * String   deemPayIndexStr; //视同缴费指数计算Str
     * String   amountDTOsStr;   //视同总额计算记录Str
     * String   amountDTOs2Str;  //转移视同总额计算记录Str
     * String   aae006;          //家庭地址
     * String   aae005;          //固定电话
     * String   aae321;          //移动电话
     * Double   aic164;          //平均缴费指数
     * Double   aic164r;         //实际缴费指数
     * String   aac006Str;       /档案出生日期
     * Date     aac006Date;      //档案出生日期
     * String   aac007Str;       //档案参加工作日期
     * Date     aac007Date;      //档案参加工作日期
     * String   aic161;          //退休类型
     * Date     aic162Date;      //退休日期
     * Long     aae210;          //待遇执行起始年月
     * String   retirementAge;   //退休年龄
     * String   aac012;          //个人身份
     * String   aac020;          //行政职务
     * String   aac014;          //专业技术职务
     * String   aac015;          //职业资格等级
     * String   bac006;          //用工性质
     * String   bie086;          //军转干部级别
     * String   bie088;          //归侨标志
     * String   alc060;          //护理依赖等级
     * String   ala018;          //因病劳动能力鉴定结论
     * Date     alc034Date;      //因病劳动能力鉴定时间
     * Long     alc034;          //因病劳动能力鉴定时间
     * String   alc035;          //因病或非因工劳动能力鉴定书编号
     * String   bac178;          //获得荣誉详细情况
     * Date     aac049Date;      //首次参保年月
     * Long     aac049;          //首次参保年月
     * Long     aae201;          //实际缴费月数
     * Long     bic096;          //视同缴费月数
     * Long     bic215;          //连续工龄
     * Long     aae200;          //缴费月数合计
     * Long     bic071;          //病退(非特殊工龄)提前月数
     * Long     bic032;          //退休前从事特殊工种工作月数
     * Long     aae030;          //视同开始时间
     * Double   bic088;          //截至2006年6月30日视同账户
     * Long     bic091;          //转入月数
     * Double   bic092;          //转入金额
     * Double   bic113;          //视同缴费账户总额
     * Double   bic108;          //视同缴费指数
     * Double   bic008;          //账户存储额
     * Double   bic009;          //个人缴费存储额
     * Double   aic167;          //个人缴费占账户存储额比例
     * Double   bic104;          //地方养老金标准
     * Double   bic105;          //地方养老金总额
     * String   ac98Str;         //实际缴费指数计算JSON
     * BankDTO  bankDTO;         //发放信息
     * String   aic162Str;
     * String   bic123;          //新老办法标志
     * Long     aaz257;          //享受定期待遇人员ID
     *
     * BankDTO 实体类的字段如下：
     * Long     aaz257; // 享受定期待遇人员ID
     * Long     aaz003; // 银行账号ID
     * Long     aaz097; // 发放方式ID
     * Long     aaz010; // 当时人ID
     * String   aae140; // 险种类型
     * String   aaa079; // 发放方式
     * String   aae145; // 发放渠道
     * String   aae147; // 本人定居生活地
     * String   bae118; // 发放银行
     * String   aae009; // 银行户名
     * String   aae010; // 银行账号
     * String   bab007; // 开户行名称
     * String   aaa027; // 统筹区
     * Long     aac001; // 人员ID
     * String   aae016; // 审核状态
     *
     * 错误码和提示信息如下:
     * GDYLSY_F14020106_001 传入参数为空
     * GDYLSY_F14020106_002 传入AAC001为空
     * GDYLSY_F14020106_003 传入核定退休日期为空
     * GDYLSY_F14020106_004 返回参数为空！判断出错！
     */
    @Test
    public void test4(){
        //判断养老待遇重算资格
        JudgeReCalculateQualificationInputParams inputParams = new JudgeReCalculateQualificationInputParams();
        inputParams.setAac001(1000001348L);
        inputParams.setAaa027("440000");
        JudgeReCalculateQualificationOutputParams outputParams = service.judgeReCalculateQualification(inputParams);
        //获取养老待遇重算准备信息 .
        ReCalculatePreInfoInputParams inputParams2 = new ReCalculatePreInfoInputParams();
        BeanUtils.copyProperties(outputParams, inputParams2);
        inputParams2.setAac001(1000001348L);
        inputParams2.setAaa027("440000");
        ReCalculatePreInfoOutputParams outputParams2 = service.getReCalculatePreInfo(inputParams2);
        //重算养老基本待遇
        ReCalculatePensionTreatmentInputParams inputParams3 = new ReCalculatePensionTreatmentInputParams();
        BeanUtils.copyProperties(outputParams2, inputParams3);
        BeanUtils.copyProperties(inputParams2, inputParams3);
        inputParams3.setAic162Str("201001");
        inputParams3.setAic301(200912L);
        inputParams3.setAac006Str("19470710");
        ReCalculatePensionTreatmentOutputParams outputParams3 = service.reCalculatePensionTreatment(inputParams3);
        //获取重算后每月补扣发
//        GetCompareResultInputParams compareResultInputParams = new GetCompareResultInputParams();
//        BeanUtils.copyProperties(outputParams3, compareResultInputParams);
//        BeanUtils.copyProperties(inputParams2, compareResultInputParams);
//        GetCompareResultOutputParams compareResultOutputParams = new GetCompareResultOutputParams();
//        compareResultInputParams.setAae210(201001L);
//        compareResultInputParams.setReCalculateType("2");
//        compareResultOutputParams = service.getCompareResult(compareResultInputParams);
        //保存重算
        SaveReCalPensionTreatmentInputParams inputParams4 = new SaveReCalPensionTreatmentInputParams();
        BeanUtils.copyProperties(outputParams3, inputParams4);
        BeanUtils.copyProperties(outputParams2, inputParams4);
        BeanUtils.copyProperties(outputParams, inputParams4);
        BeanUtils.copyProperties(inputParams2, inputParams4);
        inputParams4.setAic301(200912L);
        inputParams4.setAac006Str("19470710");
        inputParams4.setAic162Str("201001");
        BankDTO bankDTO = new BankDTO();
        bankDTO.setAaa079("2");
        bankDTO.setAae009("张三");
        bankDTO.setAae010("1111111111111111111");
        bankDTO.setAae140("110");
        bankDTO.setAae145("11");
        bankDTO.setAae147("1");
        bankDTO.setBae118("102");
        bankDTO.setAaa027("440000");
        bankDTO.setAac001(1000000968L);
        bankDTO.setAaz010(1000000968L);
        bankDTO.setAae016("0");
        inputParams4.setBankDTO(bankDTO);
        inputParams2.setAac001(1000001348L);
        BeanUtils.copyProperties(inputParams, inputParams2);
        BeanUtils.copyProperties(outputParams, inputParams2);
        inputParams4.setRetirementAge("63");
        try {
            inputParams4.setAac006Date(DateUtils.parseDate("19470710", "yyyyMMdd"));
            inputParams4.setAac007Date(DateUtils.parseDate("19850101", "yyyyMMdd"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        inputParams4.setAac049(199401L);
        inputParams4.setAaz002(2L);
        inputParams4.setDetails(outputParams3.getDetails());
        inputParams4.setAc73NewStr(outputParams3.getAc73NewStr());
        inputParams4.setAc73OldStr(outputParams3.getAc73OldStr());
        SaveReCalPensionTreatmentOutputParams outputParams4 = service.saveReCalPensionTreatment(inputParams4);
        out(outputParams4);
    }
}
