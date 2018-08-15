package com.fortunes.test.wanda;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020105.params.CalculatePensionTreatmentInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020105.params.CalculatePensionTreatmentOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020105.params.JudgePrepareInfoInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020105.params.JudgePrepareInfoOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020105.params.JudgeRetirementQualificationInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020105.params.JudgeRetirementQualificationOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020105.params.PrepareInfoInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020105.params.PrepareInfoOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020105.params.SavePensionTreatmentInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020105.params.SavePensionTreatmentOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020105.vs.F14020105Service;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020301.params.BankDTO;

/*
 * 月定期养老待遇
 */
public class MonthlyTest extends DubboTest{
	
	@Autowired
	F14020105Service f14020105Service;

	/*
	 * 判断月定期养老待遇核定基本资格
	 * 入参：
	 *  private Long aac001; //人员ID
		private String aac007Str; //档案参加工作日期
		private String aaa027; //统筹区编码   
	       出参：
        /*业务是否成功 true表示成功，false表示失败*/
		/*private boolean bizSuccess;
		 错误码 
		private String errorCode;
		 信息 
		private String message;	
		private String ic08Flag; //是否需要建立视同账户提醒标志
		private String unemploymentBenefitFlag; //是否存在失业定期待遇
		 */
	public void t1(){
		JudgePrepareInfoInputParams inputParams = new JudgePrepareInfoInputParams();
		inputParams.setAac001(1000001348L);
		inputParams.setAaa027("440000");
		inputParams.setAac007Str("19920301");
		JudgePrepareInfoOutputParams outputParams = f14020105Service.judgePrepareInfo(inputParams);
		out(outputParams);

	}
	
	
	
	/*
	 * 判断月定期养老待遇核定资格
	 * 入参：
	 *  private String aaa027; //统筹区编码          
		private Long aac001; //人员ID             
		private String aac006Str; //档案出生日期      
		private String aac007Str; //档案参加工作日期    
		private String aic161; //退休类型           
		private String aac004; //性别             
		private String aic162Str; //核定退休日期 

	       出参：
      		/* 业务是否成功 true表示成功，false表示失败
			private boolean bizSuccess;
			 错误码 
			private String errorCode;
			 信息 
			private String message;	
			private String retirementAge; //退休年龄
			private Long bic071; //病退(非特殊工龄)提前年限:
	 		*/
	
	public void t2(){
		JudgeRetirementQualificationInputParams inputParams = new JudgeRetirementQualificationInputParams();
		inputParams.setAac001(1000001348L);
		inputParams.setAac004("1");
		inputParams.setAac006Str("19470710");
		inputParams.setAac007Str("19850101");
		inputParams.setAic161("2");
		inputParams.setAic162Str("20161026");
		inputParams.setAaa027("440000");
		JudgeRetirementQualificationOutputParams outputParams = f14020105Service.judgeRetirementQualification(inputParams);
		out(outputParams);
	}
	
	
	/*
	 * 获取月定期养老待遇准备信息
	 * 入参：
	 *  private Long aac001; //人员ID
		private String aac007Str; //档案参加工作日期
		private String aaa027; //统筹区编码	




	       出参：
      		private Long aab001; //单位ID                          
			private String aab999; //单位编码                          
			private String aab004; //单位名称                          
			private Long aac049; //首次参保年月                        
			private Long aae201; //实际缴费月数                        
			private Long bic096; //视同缴费年限                        
			private Double bic008; //个人账户存储额                       
			private Double bic009; //个人缴费存储额                       
			private Long aic301; //缴费终止年月                        
			private Long bic091; //转移视同月数                        
			private Double bic092; //转移视同总额                        
			private Double bic088; //截至2006年6月30日视同账户              
			private Long aae200; //缴费年限合计                        
			private Long aae003Max; //最后缴费月份                  
			private Long aaz159; //人员参保关系ID                      
			private Long bic220; ////1998年6月30日前的缴费年限            
			private Long bic221; //1998年6月30日前的特殊工种年限            
			private Long bic084; //视同年限截止时间                               
			private Long bic215; //连续工龄              
			private Long aaz261; //IC08主键
			private Long bic032; //退休前前特殊工种工作月数      
			private Double aic167; //帐户中个人缴费部分所占比例
	
 
	*/
	
	public void t3(){
		PrepareInfoInputParams infoInputParams = new PrepareInfoInputParams();
		infoInputParams.setAac001(1000001348L);
		infoInputParams.setAaa027("440000");
		PrepareInfoOutputParams outputParams = f14020105Service.getPrepareInfo(infoInputParams);
		out(outputParams);
	}
	
	
	
	/*
	 * 月定期养老待遇核定计算
	 * 入参：
	 *  private String aaa027; //统筹区编码
		private Long aac001; //人员ID
		private String aac006Str; //档案出生日期
		private Double bic008; //个人账户存储额
		private Long aac049; //首次参加工作日期
		private String aic162Str; //核定退休日期
		private String aac014; //专业技术职务等级代码
		private Long aae210; //待遇始发年月
		private Double bic105; //地方养老金总额
		private String bic123; //新老办法标志
		private Long aae201; //实际缴费年限
		private Long aic301; //缴费终止年月
		private Long bic096; //视同缴费年限
		private String aic161; //退休类型
		private Long bic220; ////1998年6月30日前的缴费月数（视同+实际）
		private Long bic221; ////1998年6月30日前的特殊工种年限


	       出参：
      		  /* 业务是否成功 true表示成功，false表示失败*/
			/*private boolean bizSuccess;
			 错误码 
			private String errorCode;
			 信息 
			private String message;	
		    private String details;// 待遇结果列表JSON
			private String deductOutDTOsStr; //补扣发信息JSON
			private Long aae030; //视同开始年月
			private Double bic113; //视同账户总额
			private Double aic164; //平均缴费指数
			private Double bic108; //视同缴费指数
			private Double aic164r; //实际缴费指数
			private String deemPayIndexStr; //视同缴费指数计算JSON
			private String amountDTOsStr; //视同总额计算记录JSON
			private String amountDTOs2Str; //转移视同总额计算记录JSON
			private String ac98Str; //实际缴费指数计算过程JSON
			 */
	
	public void t4() throws IllegalAccessException, InvocationTargetException{
		PrepareInfoInputParams infoInputParams = new PrepareInfoInputParams();
		infoInputParams.setAac001(1000001348L);
		infoInputParams.setAaa027("440000");
		PrepareInfoOutputParams outputParams = f14020105Service.getPrepareInfo(infoInputParams);
		out(outputParams);
		
		CalculatePensionTreatmentInputParams inputParams = new CalculatePensionTreatmentInputParams();
		BeanUtils.copyProperties(outputParams, inputParams);
		inputParams.setAaa027("440000");
		inputParams.setAac001(1000001348L);
		inputParams.setAic161("2");
		inputParams.setAac006Str("19470710");
		inputParams.setAic162Str("201610");
		inputParams.setAae210(201610L);
		CalculatePensionTreatmentOutputParams outputParams2 = f14020105Service.calculatePensionTreatment(inputParams);
		System.out.println(outputParams2);
	}
	
	
	

	/*
	 * 月定期养老待遇核定计算
	 * 入参：
	 *  private String aaa027; //统筹区编码
		private Long aac001; //人员ID
		private Long aab001; //单位ID
		private String aab004; //单位名称
		private Long aaz261; //养老退休行政审批ID
		private Long baz001; //因病鉴定ID
		private Long aac083; //退休前是原工伤定期待遇享受人员ID
		private Long aaz159; //人员参保关系ID
		private String aae140; //险种类型
		private Long aic301; //终止缴费年月
		private String aaa121; //业务类型
		private Long aaz002;  //业务日志
		private String outgoing; //流向
		private String details; //ac73json转换
		private Long bic220; ////1998年6月30日前的缴费月数（视同+实际）
		private Long bic221; ////1998年6月30日前的特殊工种年限
		private String deemPayIndexStr; //视同缴费指数计算Str
		private String amountDTOsStr; //视同总额计算记录Str
		private String amountDTOs2Str; //转移视同总额计算记录Str
		private String aae006; //家庭地址
		private String aae005; //固定电话
		private String aae321; //移动电话
		private Double aic164; //平均缴费指数
		private Double aic164r; //实际缴费指数
		private String aac006Str; //档案出生日期
		private Date aac006Date; //档案出生日期
		private String aac007Str; //档案参加工作日期
	    private Date aac007Date; //档案参加工作日期
		private String aic161; //退休类型
		private Date aic162Date; //退休日期
		private Long aae210; //待遇执行起始年月
		private String retirementAge; //退休年龄
		private String aac012; //个人身份
		private String aac020; //行政职务
		private String aac014; //专业技术职务
		private String aac015; //职业资格等级
		private String bac006; //用工性质
		private String bie086; //军转干部级别
		private String bie088; //归侨标志
		private String alc060; //护理依赖等级
		private String ala018; //因病劳动能力鉴定结论
		private Date alc034Date; //因病劳动能力鉴定时间
		private Long alc034; //因病劳动能力鉴定时间
		private String alc035; //因病或非因工劳动能力鉴定书编号
		private String bac178; //获得荣誉详细情况
		
		
		private Date aac049Date; //首次参保年月
		private Long aac049; //首次参保年月
		private Long aae201; //实际缴费月数
		private Long bic096; //视同缴费月数
		private Long bic215; //连续工龄
		private Long aae200; //缴费月数合计
		private Long bic071; //病退(非特殊工龄)提前月数
		private Long bic032; //退休前从事特殊工种工作月数
		private Long aae030; //视同开始时间
		private Double bic088; //截至2006年6月30日视同账户
		private Long bic091; //转入月数
		private Double bic092; //转入金额
		private Double bic113; //视同缴费账户总额
		private Double bic108; //视同缴费指数
		private Double bic008; //账户存储额
		private Double bic009; //个人缴费存储额
		private Double aic167; //个人缴费占账户存储额比例
		private Double bic104; //地方养老金标准
		private Double bic105; //地方养老金总额
		private String ac98Str; //实际缴费指数计算JSON
		private BankDTO bankDTO; //发放信息
		private String aic162Str; 
		private String bic123; //新老办法标志
		
		
		BankDTO 实体类的字段如下：
		private Long aaz257; // 享受定期待遇人员ID
		private Long aaz003; // 银行账号ID
		private Long aaz097; // 发放方式ID
		private Long aaz010; // 当时人ID
		private String aae140; // 险种类型
		private String aaa079; // 发放方式
		private String aae145; // 发放渠道
		private String aae147; // 本人定居生活地
		private String bae118; // 发放银行
		private String aae009; // 银行户名
		private String aae010; // 银行账号
		private String bab007; // 开户行名称
		private String aaa027; // 统筹区
		private Long aac001; // 人员ID
		private String aae016; // 审核状态

	       出参：
      		  /* 业务是否成功 true表示成功，false表示失败
				private boolean bizSuccess;
				 错误码 
				private String errorCode;
				 信息 
				private String message;	
		    */
	@Test
	public void t5() throws IllegalAccessException, InvocationTargetException, ParseException{
		PrepareInfoInputParams infoInputParams = new PrepareInfoInputParams();
		infoInputParams.setAac001(1000001348L);
		infoInputParams.setAaa027("440000");
		PrepareInfoOutputParams outputParams = f14020105Service.getPrepareInfo(infoInputParams);
		
		
		CalculatePensionTreatmentInputParams inputParams = new CalculatePensionTreatmentInputParams();
		BeanUtils.copyProperties(outputParams, inputParams);
		inputParams.setAaa027("440000");
		inputParams.setAac001(1000001348L);
		inputParams.setAic161("2");
		inputParams.setAac006Str("19470710");
		inputParams.setAic162Str("201610");
		inputParams.setAae210(201610L);
		CalculatePensionTreatmentOutputParams outputParams2 = f14020105Service.calculatePensionTreatment(inputParams);
		
		SavePensionTreatmentInputParams inputParams2 = new SavePensionTreatmentInputParams();
		BeanUtils.copyProperties(outputParams2, inputParams2);
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
		inputParams2.setBankDTO(bankDTO);
		inputParams2.setAac001(1000001348L);
		BeanUtils.copyProperties(inputParams, inputParams2);
		BeanUtils.copyProperties(outputParams, inputParams2);
		inputParams2.setRetirementAge("63");
		
		inputParams2.setAac006Date(org.apache.commons.lang3.time.DateUtils.parseDate("19470710","yyyyMMdd"));
		inputParams2.setAac007Date(org.apache.commons.lang3.time.DateUtils.parseDate("19470710","yyyyMMdd"));
		inputParams2.setAac049(199401L);
		SavePensionTreatmentOutputParams outputParams3 = f14020105Service.savePensionTreatment(inputParams2);
		System.out.println(outputParams3);
	}
}
