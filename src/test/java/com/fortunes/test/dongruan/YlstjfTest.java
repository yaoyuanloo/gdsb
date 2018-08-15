package com.fortunes.test.dongruan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearcancel.param.BasicinfoGRQFHXParam;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearcancel.param.DealPerArrearCancelParam;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearcancel.result.DealPerArrearCancelResult;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearcancel.result.PerArrearInfoResult;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearcancel.service.QueryPerArrearInfoDubboService;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearpay.param.DealPerArrearPayParam;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearpay.result.DealPerArrearPayResult;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearpay.service.PerArrearPayDubboService;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perfeeadjust.param.BasicinfoCEBTParam;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perfeeadjust.param.DealPerFeeAdjustParam;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perfeeadjust.result.DealPerFeeAdjustResult;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perfeeadjust.result.PerOldPayInfoResult;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perfeeadjust.service.PerFeeAdjustDubboService;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perfeereturn.param.BasicinfoGRTSParam;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perfeereturn.param.DealPerFeeReturnParam;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perfeereturn.result.DealPerFeeReturnResult;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perfeereturn.result.PerPayInfoResult;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perfeereturn.service.PerFeeReturnDubboService;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.regardfeemedicare.param.BasicinfoYLSTJFParam;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.regardfeemedicare.param.DealYLSTJFParam;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.regardfeemedicare.result.DealYLSTJFResult;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.regardfeemedicare.result.YLSTJFYSResult;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.regardfeemedicare.service.RegardFeeMedicareDubboService;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.unitarrearcancel.param.DealUnitArrearCancelParam;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.unitarrearcancel.result.DealUnitArrearCancelResult;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.unitarrearcancel.service.UnitArrearInfoDubboService;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.unitarrearpay.param.BasicinfoDWQFHXParam;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.unitarrearpay.param.DealUnitArrearPayParam;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.unitarrearpay.result.DealUnitArrearPayResult;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.unitarrearpay.result.UnitArrearInfoResult;
import com.neusoft.sl.si.collection.dubbo.employee.feeadjust.unitarrearpay.service.UnitArrearPayDubboService;
import com.neusoft.sl.si.collection.dubbo.employee.query.service.QueryGRBTXIDubboService;

public class YlstjfTest extends DubboTest{
	@Autowired
	RegardFeeMedicareDubboService regardfee;
	
	@Autowired
	QueryPerArrearInfoDubboService queryPerArrearInfo;
	
	@Autowired
	UnitArrearPayDubboService unit;
	
	@Autowired
	PerArrearPayDubboService perArr;
	
	
	@Autowired
	UnitArrearInfoDubboService unitArrea;
	
	@Autowired
	PerFeeReturnDubboService perFeeReturn;
	
	@Autowired
	PerFeeAdjustDubboService perFeeAdjustss;
	
	@Autowired
	PerFeeReturnDubboService perfeere;
	
	/*
	 * 医疗视同缴费月数查询(通)
	 * public YLSTJFYSResult queryRegardFeeMedicare(BasicinfoYLSTJFParam param);
	 * 入参：  private String aac001 = "";//单位编号
			private String aae140 = "310";//险种,310---医疗
	 */
	
	public void t1(){
		BasicinfoYLSTJFParam  basi=new BasicinfoYLSTJFParam();
		basi.setAac001("54321");
		basi.setAae140("310");
		YLSTJFYSResult ylst=regardfee.queryRegardFeeMedicare(basi);
		out(ylst.getRegardFeeMedicareTotalList());//医疗视同缴费月数汇总
		out(ylst.getRegardFeeMedicareDetailList());//医疗视同缴费月数明细
		out(ylst);
	}
	
	//[{"BAZ5A1":100000000320028,"BAZ002":2600000263798984,"AAC001":54321,"BAC120":0,"BAC121":2,"BAC122":3,"AAB034":null,"AAE011":"管理员","AAE036":20161012181051,"AAE013":null,"BAE016":null,"BAE017":null,"BAE018":null,"AAA027":null}]
	/*
	 * 保存医疗视同缴费月数维护(通)
	 */
	public void t2(){
		BasicinfoYLSTJFParam  basi=new BasicinfoYLSTJFParam();
		basi.setAac001("54321");
		basi.setAae140("310");
		YLSTJFYSResult ylst=regardfee.queryRegardFeeMedicare(basi);
		out(ylst.getRegardFeeMedicareTotalList());//医疗视同缴费月数汇总
		List<Map<String,Object>> regardFeeMedicareTotalList= ylst.getRegardFeeMedicareTotalList();
		out(ylst.getRegardFeeMedicareDetailList());//医疗视同缴费月数明细
		List<Map<String,Object>> regardFeeMedicareDetailList =  ylst.getRegardFeeMedicareDetailList();
		DealYLSTJFParam deal=new DealYLSTJFParam();
		deal.setNewRegardFeeMedicareTotalList(regardFeeMedicareTotalList);
		deal.setNewRegardFeeMedicareDetailList(regardFeeMedicareDetailList);
		
		Map<String,Object> remarkMap = new HashMap<String,Object>();//扩展参数，以备后用
        
        String aac001 = "54321";//个人id
        String aac999= "543210";//个人编号
        String aab001= "12345";//单位id
        String aab999="123450";//单位编号

        remarkMap .put("aac001",aac001);
		remarkMap .put("aac999",aac999);
		remarkMap .put("aab001",aab001);
		remarkMap .put("aab999",aab999);
		
		deal.setRemarkMap(remarkMap);
		DealYLSTJFResult dresult=regardfee.saveRegardFeeMedicare(deal);
		
		out(dresult);
	}
	
	
	
	
	/*
	 * 个人欠费信息查询(通)
	 * queryPerArrearInfo
	 */
	
	public void t3(){
		/*
		 * 查询个人欠费信息查询(通)
		 */
		BasicinfoGRQFHXParam basicin=new BasicinfoGRQFHXParam();
		basicin.setAac001s("54321");
		basicin.setAab001("12345");
		basicin.setBae152("0");
		basicin.setBae151("11");
		basicin.setBae165("1");
		basicin.setAaa115("10,20,24,25,26,27");//缴费类型
		basicin.setAae041("201010");		
		basicin.setAae042("201610");
		basicin.setAae140s("110,210,310");//险种
		PerArrearInfoResult presult=queryPerArrearInfo.queryPerArrearInfo(basicin);
		out(presult.getPerArrearInfoList());//医疗视同缴费月数维护
		out(presult);
	}
	
	
	/*
	 * 个人欠费核销
	 * doPerArrearCancel
	 * com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearcancel.service.QueryPerArrearInfoDubboService
	 */
	
	public void t4(){
		/*
		 *查询个人欠费（通）
		 */
		BasicinfoGRQFHXParam basicin=new BasicinfoGRQFHXParam();
		basicin.setAac001s("54321");
		basicin.setAab001("12345");
		basicin.setBae152("0");
		basicin.setBae151("11");
		basicin.setBae165("1");
		basicin.setAaa115("10,20,24,25,26,27");//缴费类型
		basicin.setAae041("201010");		
		basicin.setAae042("201610");
		basicin.setAae140s("110,210,310");//险种
		PerArrearInfoResult presult=queryPerArrearInfo.queryPerArrearInfo(basicin);
		
		
		/*
		 * 处理
		 */
		
		DealPerArrearCancelParam basicin1=new DealPerArrearCancelParam();
		basicin1.setPerArrearInfoList(presult.getPerArrearInfoList());
		DealPerArrearCancelResult dl=queryPerArrearInfo.doPerArrearCancel(basicin1);
		out(dl);
	}
	
	
	/*
	 * 单位欠费补缴（通）
	 * doPerArrearCancel
	 * com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearcancel.service.QueryPerArrearInfoDubboService
	 */
	public void t5(){
		/*
		 * 单位欠费信息查询（通）
		 */
		BasicinfoDWQFHXParam basi=new BasicinfoDWQFHXParam();
		Map<String,Object> remarkMap = new HashMap<String,Object>();//扩展参数
		String curPeriod = "201611";//台账年月
		String remark = "curPeriod";//备注
		String isCalcInterest = "1";//是否计算利息
		String isCalcLateFee = "1";//是否计算滞纳金
        String calcInterestStartDate = "201011";//计算利息开始日期
		String calcInterestEndDate = "201111";//计算利息截止日期               
		String calcLateFeeStartDate = "201011";//计算滞纳金开始日期
		String calcLateFeeEndDate = "201611";//计算滞纳金截止日期

        remarkMap.put("curPeriod",curPeriod);
        remarkMap.put("remark",remark);
        remarkMap.put("isCalcInterest",isCalcInterest);
        remarkMap.put("isCalcLateFee",isCalcLateFee);
        remarkMap.put("calcInterestStartDate",calcInterestStartDate);
        remarkMap.put("calcInterestEndDate",calcInterestEndDate);
        remarkMap.put("calcLateFeeStartDate",calcLateFeeStartDate);
        remarkMap.put("calcLateFeeEndDate",calcLateFeeEndDate);
		
		
		String aab001 = "12345";//单位编号
		String bae152 = "0";//缴费标志,0---欠费标志
		String aae041 = "200910";//开始时间
		String aae042 = "201610";//终止时间
		String aae140s = "210,310";//险种串
		String aaa115 = "10,20,24";//缴费类型
		basi.setAab001(aab001);
		basi.setBae152(bae152);
		basi.setAae041(aae041);
		basi.setAae042(aae042);
		basi.setAae140s(aae140s);
		basi.setAaa115(aaa115);
		UnitArrearInfoResult ua=unit.queryUnitArrearInfo(basi);
		out(ua);

		
		
		/*
		 * 单位补缴处理（通）
		 */
		DealUnitArrearPayParam d=new DealUnitArrearPayParam();
		d.setRemarkMap(remarkMap);
		d.setUnitArrearInfoList(ua.getUnitArrearInfoList());  

		DealUnitArrearPayResult de=unit.doUnitArrearPay(d);
		out(de);
	}
	
	
	
	/*
	 * 养老历史缴费补缴（清远）功能模块
	 * public PerArrearInfoResult queryPerArrearInfo(BasicinfoGRQFHXParam param);
	 * com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearpay.service.PerArrearPayDubboService
	 */
	public void t6(){
		/*
		 * 个人养老欠费信息查询(通)（只能查询养老险种）
		 */
		com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearpay.param.BasicinfoGRQFHXParam v=new com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearpay.param.BasicinfoGRQFHXParam();
		v.setAae140s("110");
		com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearpay.result.PerArrearInfoResult pe=perArr.queryPerArrearInfo(v);
		out(pe);
		/*
		 * 养老历史缴费补缴处理（通）
		 */
		Map<String,Object> remarkMap = new HashMap<String,Object>();//扩展参数
        
        String feeFounds = "1";//费用大类
		String curPeriod = "201611";//台账年月
		String feeBody = "1";//缴费主体  1单位，2个人
		String remark = "curPeriod";//备注
		String isCalcInterest = "1";//是否计算利息
		String isCalcLateFee = "1";//是否计算滞纳金
        String calcInterestStartDate = "201011";//计算利息开始日期
		String calcInterestEndDate = "201111";//计算利息截止日期               
		String calcLateFeeStartDate = "201011";//计算滞纳金开始日期
		String calcLateFeeEndDate = "201611";//计算滞纳金截止日期

        remarkMap.put("feeFounds",feeFounds);
        remarkMap.put("curPeriod",curPeriod);
        remarkMap.put("feeBody",feeBody);
        remarkMap.put("remark",remark);
        remarkMap.put("isCalcInterest",isCalcInterest);
        remarkMap.put("isCalcLateFee",isCalcLateFee);
        remarkMap.put("calcInterestStartDate",calcInterestStartDate);
        remarkMap.put("calcInterestEndDate",calcInterestEndDate);
        remarkMap.put("calcLateFeeStartDate",calcLateFeeStartDate);
        remarkMap.put("calcLateFeeEndDate",calcLateFeeEndDate);
		
		
		DealPerArrearPayParam dp=new DealPerArrearPayParam();
		dp.setPerArrearInfoList(pe.getPerArrearInfoList());
		dp.setRemarkMap(remarkMap);
		DealPerArrearPayResult dt= perArr.doPerArrearPay(dp);
		out(dt);
		
	}
	
	
	
	/*
	 * 个人欠费补缴（查询所有险种）
	 * public PerArrearInfoResult queryPerArrearInfo(BasicinfoGRQFHXParam param);
	 * com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearpay.service.PerArrearPayDubboService
	 */
	
	public void t7(){
		/*
		 * 人欠费信息查询（查询所有险种）（通）
		 */
		com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearpay.param.BasicinfoGRQFHXParam v=new com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearpay.param.BasicinfoGRQFHXParam();
		v.setAae140s("110,310");
		com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearpay.result.PerArrearInfoResult pe=perArr.queryPerArrearInfo(v);
		out(pe);
		
		/*
		 * 个人缴费补缴处理（通）
		 */
		Map<String,Object> remarkMap = new HashMap<String,Object>();//扩展参数
        
        String feeFounds = "1";//费用大类
		String curPeriod = "201611";//台账年月
		String feeBody = "1";//缴费主体  1单位，2个人
		String remark = "curPeriod";//备注
		String isCalcInterest = "1";//是否计算利息
		String isCalcLateFee = "1";//是否计算滞纳金
        String calcInterestStartDate = "201011";//计算利息开始日期
		String calcInterestEndDate = "201111";//计算利息截止日期               
		String calcLateFeeStartDate = "201011";//计算滞纳金开始日期
		String calcLateFeeEndDate = "201611";//计算滞纳金截止日期

        remarkMap.put("feeFounds",feeFounds);
        remarkMap.put("curPeriod",curPeriod);
        remarkMap.put("feeBody",feeBody);
        remarkMap.put("remark",remark);
        remarkMap.put("isCalcInterest",isCalcInterest);
        remarkMap.put("isCalcLateFee",isCalcLateFee);
        remarkMap.put("calcInterestStartDate",calcInterestStartDate);
        remarkMap.put("calcInterestEndDate",calcInterestEndDate);
        remarkMap.put("calcLateFeeStartDate",calcLateFeeStartDate);
        remarkMap.put("calcLateFeeEndDate",calcLateFeeEndDate);
		
		
		DealPerArrearPayParam dp=new DealPerArrearPayParam();
		dp.setPerArrearInfoList(pe.getPerArrearInfoList());
		dp.setRemarkMap(remarkMap);
		DealPerArrearPayResult dt= perArr.doPerArrearPay(dp);
		out("11111111111111111111111："+dt.getPerArrearPayResultList());
	}
	
	
	
	/*
	 * 单位欠费核销功能模块（通）
	 * public PerArrearInfoResult queryPerArrearInfo(BasicinfoGRQFHXParam param);
	 * com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearpay.service.PerArrearPayDubboService
	 */
	public void t8(){
		/*
		 * 单位欠费信息查询（通）
		 */
		com.neusoft.sl.si.collection.dubbo.employee.feeadjust.unitarrearcancel.param.BasicinfoDWQFHXParam b=new com.neusoft.sl.si.collection.dubbo.employee.feeadjust.unitarrearcancel.param.BasicinfoDWQFHXParam();
		com.neusoft.sl.si.collection.dubbo.employee.feeadjust.unitarrearcancel.result.UnitArrearInfoResult uit= unitArrea.queryUnitArrearInfo(b);
		out(uit);
		
		
		/*
		 * 单位欠费核销处理（通）
		 */

		DealUnitArrearCancelParam d=new DealUnitArrearCancelParam();
		d.setUnitArrearInfoList(uit.getUnitArrearInfoList());

		DealUnitArrearCancelResult t=unitArrea.doUnitArrearCancel(d);
		out("1111:"+t.getUnitArrearCancelResultList());
		
		out("2222:"+t);
	}
	
	
	/*
	 * 个人退收功能模块（通）
	 * public PerArrearInfoResult queryPerArrearInfo(BasicinfoGRQFHXParam param);
	 * com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearpay.service.PerArrearPayDubboService
	 */
	
	public void t9(){
		/*
		 * 个人实缴信息查询（通）
		 */
		BasicinfoGRTSParam ba=new BasicinfoGRTSParam();
		ba.setInsures("110");
		PerPayInfoResult per=perFeeReturn.queryPerPayInfo(ba);
		out(per);
		
		
		/*
		 * 个人补退处理（通）
		 */
		String returnBodyMode = "0";//	退费方式	
		String busiReason = "经办原因";//经办原因
		String remark = "退费原因";//退费原因
		String perBankType = "103";//个人开户银行
		String perBankAccountNumber = "100000000390194";//个人银行帐号
		String unitBankType = "100000000390194";//单位开户银行
		String unitBankAccountNumber = "103";//单位银行帐号
		String tzny = "201601";

		
		Map<String,Object> ParamM=new HashMap<String,Object>();
		ParamM.put("returnBodyMode",returnBodyMode);
		ParamM.put("busiReason",busiReason);
		ParamM.put("remark",remark);
		ParamM.put("perBankType",perBankType);
		ParamM.put("perBankAccountNumber",perBankAccountNumber);
		ParamM.put("unitBankType",unitBankType);
		ParamM.put("unitBankAccountNumber",unitBankAccountNumber);
		ParamM.put("tzny",tzny);
		DealPerFeeReturnParam da=new DealPerFeeReturnParam();
		da.setPerPayInfoList(per.getPerPayInfoList());
		da.setParamM(ParamM);
		DealPerFeeReturnResult dresult=perFeeReturn.doPerFeeReturn(da);
		out(dresult);
	}
	
	/*
	 * 差额不退处理模块
	 * public PerArrearInfoResult queryPerArrearInfo(BasicinfoGRQFHXParam param);
	 * com.neusoft.sl.si.collection.dubbo.employee.feeadjust.perarrearpay.service.PerArrearPayDubboService
	 */
	@Test
	public void t11(){
		/*
		 *个人原缴费信息查询(通)
		 */
		  BasicinfoCEBTParam ba=new BasicinfoCEBTParam();
		  Map<String,Object> paramM = new HashMap<String,Object>();
          String aab001 = "12345";
		  String oldCalcNo = "12345";//核定流水号
		  String personIDs = "54321";//人员编号串
		  String beginYearMonth = "201011";//开始对应费款所属期
		  String endYearMonth = "201611";//终止对应费款所属期		  		  
		  String insures = "210";//险种串		  
		  String feeTypes = "10,20,24";//缴费类型串
		  String feeObjects = "11";//缴费对象串
		  String feeResources = "11";//基金来源串		  
		  String feeFlags = "1";//缴费标志串
		  String tzny = "201611";	  
		  
		  paramM.put("aab001",aab001);
		  paramM.put("oldCalcNo",oldCalcNo);
		  paramM.put("personIDs",personIDs);
		  paramM.put("beginYearMonth",beginYearMonth);
		  paramM.put("endYearMonth",endYearMonth);
		  paramM.put("insures",insures);
		  paramM.put("feeTypes",feeTypes);
		  paramM.put("feeObjects",feeObjects);
		  paramM.put("feeResources",feeResources);
		  paramM.put("feeFlags",feeFlags);
		  paramM.put("tzny",tzny);
		  
		  ba.setParamM(paramM);
		  PerOldPayInfoResult per=perFeeAdjustss.queryPerFeeInfo(ba);
		  out(per);
		  
		  
		  /*
		   * 差额补退处理
		   */

		  DealPerFeeAdjustParam df=new DealPerFeeAdjustParam();
		  String returnBodyMode = "0"; //	退费方式	        
		  String remark = "差额补退处理"; //  
		  String perBankType = "103";//个人开户银行
		  String perBankAccountNumber = "100000000390194";//个人银行帐号
		  String unitBankType = "103";//单位银行帐号
		  String unitBankAccountNumber = "100000000390194";//单位开户银行
		  String tznys = "201601";      
		  String feebase = "3000"; //缴费基数  
		  String isCalcInterest = "1";   
		  String calcInterestStartDate = "201011";  // 利息开始时间
		  String calcInterestEndDate = "201011"; //  利息终止时间
		  String isCalcLateFee = "1";   
		  String calcLateFeeStartDate = "201011"; //  滞纳金开始时间
		  String calcLateFeeEndDate = "201011"; //   滞纳金终止时间
		  String isCJAccount = "1";//是否冲减账户：允许为空
		  String collectType = "1";//征集类型：允许为空
		  String isAutoCollect = "1";//是否自动征集：允许为空
		  String isAssigned = "0";//是否自动到账实收：允许为空
		  
		  Map<String,Object> mapsInfo=new HashMap<String, Object>();
		  mapsInfo.put("returnBodyMode", returnBodyMode);
		  mapsInfo.put("remark", remark);
		  mapsInfo.put("perBankType", perBankType);
		  mapsInfo.put("perBankAccountNumber", perBankAccountNumber);
		  mapsInfo.put("unitBankType", unitBankType);
		  mapsInfo.put("unitBankAccountNumber", unitBankAccountNumber);
		  mapsInfo.put("tznys", tznys);
		  mapsInfo.put("feebase", feebase);
		  mapsInfo.put("isCalcInterest", isCalcInterest);
		  mapsInfo.put("calcInterestStartDate", calcInterestStartDate);
		  mapsInfo.put("calcInterestEndDate", calcInterestEndDate);
		  mapsInfo.put("isCalcLateFee", isCalcLateFee);
		  
		  
		  
		  mapsInfo.put("calcLateFeeStartDate", calcLateFeeStartDate);
		  mapsInfo.put("calcLateFeeEndDate", calcLateFeeEndDate);
		  mapsInfo.put("isCJAccount", isCJAccount);
		  mapsInfo.put("collectType", collectType);
		  mapsInfo.put("isAutoCollect", isAutoCollect);
		  mapsInfo.put("isAssigned", isAssigned);
		  df.setPerOldPayInfoList(per.getPerOldPayInfoList());
		  df.setParamM(paramM);
		  DealPerFeeAdjustResult results= perFeeAdjustss.doPerFeeAdjust(df);
		  out(results);
	}
	
	
	
	
	
	
}
