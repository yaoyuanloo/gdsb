package com.fortunes.test.wanda;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020202.F14020202ServiceVS;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020202.params.SaveTreatProInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020202.params.SaveTreatProOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020202.params.TreatProAuditDetailInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020202.params.TreatProAuditDetailOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020202.params.TreatProHistoryBaseInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020202.params.TreatProHistoryBaseOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020202.params.TreatProHistoryDetailInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020202.params.TreatProHistoryDetailOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020202.params.TreatProInputParams;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030208.params.TreatProOutputParams;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030208.F14030208ServiceVS;


public class PensionTest extends DubboTest {
	
	
	@Autowired
	F14020202ServiceVS f14020202ServiceVS; 
	
	@Autowired
    F14030208ServiceVS f14030208ServiceVS;
	/*
	 *  获取人员基本信息（东软）(养老待遇发放信息变更)（已通）
	 *  1.校验是否失业人员
		2.校验是否正在领取待遇
		3.校验是否存在未办结修改业务
		4.成功返回失业待遇发放信息
		5.失败返回错误提示信息
	 * 接口名称： public String queryBenefitInfo()
	 *  
	 *  入参:private String aac147; //身份证
			private String aac002;//社保号
			
		出参：private String bac045; //社保编号
			 private String aac147; // 证件号码
			 private String aac003; // 姓名
			 private String aac004; // 性别
			 private Date aac006; // 出生日期
			 private String aac005; // 民族
			 private String bke143; // 医保类型
			 private String bab002; // 所属区
			 private String aae006; // 地址
			 private String aae005; // 固定电话
			 private String aae321; // 移动电话号码
			 private Date aac007; // 参加工作日期
			 private String aac060; // 生存状态
			 private String aac084; // 离退休标志
			 
			private Long aaz257; // 享受定期待遇人员ID
			private Long aaz099; // 待遇发放信息ID
			private Long aaz097; // 待遇发放方式登记事件ID
			private String aae145; // 发放渠道
			private String aaa079; // 拨付方式 
			private String aae147; // 本人定居生活地:
			private String bae118; // 发放银行
			private String bab007;// 开户行名称
			private String aae009; // 户名
			private String aae010; // 银行账号
		
	 */
	
    public void t1(){
		TreatProInputParams tpp=new TreatProInputParams();
		tpp.setAac147("855881195305093760");
		com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020202.params.TreatProOutputParams tpop=f14020202ServiceVS.queryBenefitInfo(tpp);
		System.out.println(tpop.getErrorCode());
		System.out.println(tpop.getAaa079());
		System.out.println(tpop.getAaz257());
		
		
    }
    
    
   
    
    
    /*
	 * 养老待遇发放信息变更保存（已通）
	 * 接口名称： public String saveBenefitProvideInfo()
	 *  
	 *  入参:private Long aaz257;//享受定期待遇人员ID 
			private String aae145 ;         //发放渠道     
			private String aaa079 ;         //拨付方式     
			private String aae147 ;         //本人定居生活地
			private String bae118; // 发放银行
			private String bab007;// 开户行名称
			private String aae009; // 户名
			private String aae010; // 银行账号
			private String outgoing; // 流向
			private String aaa121 ;         //业务类型 	
	 */
    @Test
    public void t2(){
		SaveTreatProInputParams stp=new SaveTreatProInputParams();
		stp.setAaz257(1000002105l);
		stp.setAae145("1");
		stp.setAaa079("1");
		stp.setAae147("1");
		stp.setBae118("1");
		stp.setBab007("1");
		stp.setAae009("1");
		stp.setAae010("1");
		stp.setOutgoing("1");
		stp.setAaa121("1");
		SaveTreatProOutputParams st=f14020202ServiceVS.saveBenefitProvideInfo(stp);
		System.out.println("结果信息："+st.isBizSuccess());
    }
	
	
	/*
	 * 获取养老待遇发放信息修改历史记录
	 * 接口名称： public String queryBenefitProvideHistoryBaseInfo()
	 *  
	 *  入参:private Long aaz257;// 享受定期待遇人员ID
		    
		出参: private Long   aaz002 ;//业务日志ID   
			 private String aac147; //证件号码
			 private String aac003; //姓名
			private String aaa121 ;//业务类型     
			private Date   aae036 ;//经办时间    
			private String bae125 ;//经办人姓名   
			private String aae016 ;//审核状态   
	 */
    public void t3(){
		TreatProHistoryBaseInputParams tbp=new TreatProHistoryBaseInputParams();
		tbp.setAaz257(null);
		TreatProHistoryBaseOutputParams params=f14020202ServiceVS.queryBenefitProvideHistoryBaseInfo(tbp);
    }

	/*
	 * 获取养老待遇发放信息修改记录单个记录的详细信息
	 * 接口名称： public String queryBenefitProvideHistoryDetailInfo()
	 *  
	 *  入参:private Long aac001;//人员ID
			private Long aaz002;//业务日志ID
		    
		出参: private String aae123; // 变更前信息
			 private String aae124; // 变更后信息
			 private String aae155; // 变更项目中文含义
	 */
    public void t4(){
		TreatProHistoryDetailInputParams tdp=new TreatProHistoryDetailInputParams();
		tdp.setAac001(null);
		tdp.setAaz002(null);
		TreatProHistoryDetailOutputParams thdp =f14020202ServiceVS.queryBenefitProvideHistoryDetailInfo(tdp);
    }
	
	
	
	
	/*
	 * 获取待初审养老待遇审核记录
	 * 接口名称： public String queryBenefitProvideAuditBaseInfo()
	 *  
	 *  入参:private String baa201;//办理状态
			private String aac147; // 证件号码
			private String startDate;//开始时间
			private String endDate;结束时间	
			
		出参：private Long aaz097; // 待遇发放方式登记事件ID 
			private String aac147; //证件号码
			private String aac003; //姓名
			private String aaa121 ;//业务类型     
			private Date   aae036 ;//经办时间    
			private String bae125 ;//经办人姓名   
			private String aae016 ;//审核状态   
	 */
    public void t5(){
		f14020202ServiceVS.queryBenefitProvideAuditBaseInfo(null);
    }
	
	
	/*
	 * 获取初审养老待遇待初审记录详细
	 * 1.校验是否存在人员基本信息
		2.校验是否存在重复人员基本信息
		3.成功返回人员基本信息
		4.失败返回错误提示信息
	 * 接口名称： public String queryBenefitProvideAuditDetailInfo()
	 *  
	 *  入参:private Long aac001;//人员ID
			private Long aaz002;//业务日志ID	
			
		出参：private String aae123; // 变更前信息
			private String aae124; // 变更后信息
			private String aae155; // 变更项目中文含义
		
	 */
    public void t6(){
		TreatProAuditDetailInputParams tpadi=new TreatProAuditDetailInputParams(); 
		tpadi.setAac001(null);
		tpadi.setAaz002(null);
		TreatProAuditDetailOutputParams p=f14020202ServiceVS.queryBenefitProvideAuditDetailInfo(tpadi);
    }
	
	
	
	
	
	
	
	
	
	/*
	 * 获取失业待遇发放信息修改历史记录
	 * 1.存在返回失业待遇修改历史记录
	 * 接口名称： public String queryBenefitProvideHistoryBaseInfo()
	 *  
	 *  入参:private Long aaz257; // 享受定期待遇人员ID
			
		出参   private Long   aaz002 ;//业务日志ID   
			private String aac147; //证件号码
			private String aac003; //姓名
			private String aaa121 ;//业务类型     
			private Date   aae036 ;//经办时间    
			private String bae125 ;//经办人姓名   
			private String aae016 ;//审核状态   
		
	 */
	
    public void t7(){
		TreatProHistoryBaseInputParams tpbp=new TreatProHistoryBaseInputParams();
		tpbp.setAaz257(null);
		TreatProHistoryBaseOutputParams tp=f14020202ServiceVS.queryBenefitProvideHistoryBaseInfo(tpbp);
    }
	
	
	/*
	 * 获取失业待遇发放信息修改历史记录单个记录的详细信息
	 * 1.存在返回历史记录的详细信息
	 * 接口名称： public String queryBenefitProvideHistoryDetailInfo()
	 *  
	 *  入参:private Long aac001;//人员ID
			private Long aaz002;//业务日志ID
			
		出参：private String aae123; // 变更前信息
			 private String aae124; // 变更后信息
			private String aae155; // 变更项目中文含义
		
	 */
	
    public void t8(){
		TreatProHistoryDetailInputParams tphip=new TreatProHistoryDetailInputParams();
		tphip.setAac001(null);
		tphip.setAaz002(null);
		TreatProHistoryDetailOutputParams t=f14020202ServiceVS.queryBenefitProvideHistoryDetailInfo(tphip);
    }
	
	
	/*
	 * 失业待遇发放信息修改保存
	 *  1.成功保存失业待遇发放信息并返回成功提示信息
		2.失败返回错误提示信息
	 * 接口名称： public String saveBenefitProvideInfo()
	 *  
	 *  入参:private Long aaz257;//享受定期待遇人员ID 
			private String aae145;//发放渠道     
			private String aaa079;//拨付方式     
			private String aae147;//本人定居生活地
			private String bae118;//发放银行
			private String bab007;//开户行名称
			private String aae009;//户名
			private String aae010;//银行账号
			private String outgoing;//流向
			private String aaa121;//业务类型 
		
	 */
	
    public void t9(){
		SaveTreatProInputParams stip=new SaveTreatProInputParams();
		stip.setAaz257(null);
		stip.setAae145(null);
		stip.setAaa079(null);
		
		stip.setAae147(null);
		stip.setBae118(null);
		
		stip.setBab007(null);
		stip.setAae009(null);
		stip.setAae010(null);
		stip.setOutgoing(null);
		stip.setAaa121(null);
		SaveTreatProOutputParams spp=f14020202ServiceVS.saveBenefitProvideInfo(stip);
    }
	
   
    
    
    
    /*
   	 *  获取人员基本信息（东软）(失业待遇发放信息变更)(已通)
   	 *  1.校验是否失业人员
   		2.校验是否正在领取待遇
   		3.校验是否存在未办结修改业务
   		4.成功返回失业待遇发放信息
   		5.失败返回错误提示信息
   	 * 接口名称： public String queryBenefitInfo()
   	 *  
   	 *  入参:private String aac147; //身份证
   			private String aac002;//社保号
   			
   		出参：private String bac045; //社保编号
   			 private String aac147; // 证件号码
   			 private String aac003; // 姓名
   			 private String aac004; // 性别
   			 private Date aac006; // 出生日期
   			 private String aac005; // 民族
   			 private String bke143; // 医保类型
   			 private String bab002; // 所属区
   			 private String aae006; // 地址
   			 private String aae005; // 固定电话
   			 private String aae321; // 移动电话号码
   			 private Date aac007; // 参加工作日期
   			 private String aac060; // 生存状态
   			 private String aac084; // 离退休标志
   			 
   			private Long aaz257; // 享受定期待遇人员ID
   			private Long aaz099; // 待遇发放信息ID
   			private Long aaz097; // 待遇发放方式登记事件ID
   			private String aae145; // 发放渠道
   			private String aaa079; // 拨付方式 
   			private String aae147; // 本人定居生活地:
   			private String bae118; // 发放银行
   			private String bab007;// 开户行名称
   			private String aae009; // 户名
   			private String aae010; // 银行账号
   		
   	 */
   
   public void t11(){
	   com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030208.params.TreatProInputParams p=new com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030208.params.TreatProInputParams();
	   p.setAac147("874705194308188032");
	   TreatProOutputParams tr=f14030208ServiceVS.queryBenefitInfo(p);
	   System.out.println("111111111："+tr.getErrorCode());
	   System.out.println("11111111:"+tr.getAaz257());
   }

    
    /*
   	 * 失业待遇发放信息变更保存(已通)
   	 * 接口名称： public String saveBenefitProvideInfo()
   	 *  
   	 *  入参:private Long aaz257;//享受定期待遇人员ID 
   			private String aae145 ;         //发放渠道     
   			private String aaa079 ;         //拨付方式     
   			private String aae147 ;         //本人定居生活地
   			private String bae118; // 发放银行
   			private String bab007;// 开户行名称
   			private String aae009; // 户名
   			private String aae010; // 银行账号
   			private String outgoing; // 流向
   			private String aaa121 ;         //业务类型 	
   	 */
   
       public void t12(){
   		com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030208.params.SaveTreatProInputParams stp=new com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030208.params.SaveTreatProInputParams();
   		stp.setAaz257(1000002050l);
   		stp.setAae145("1");
   		stp.setAaa079("1");
   		stp.setAae147("1");
   		stp.setBae118("1");
   		stp.setBab007("1");
   		stp.setAae009("1");
   		stp.setAae010("1");
   		stp.setOutgoing("1");
   		stp.setAaa121("1");
   		com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030208.params.SaveTreatProOutputParams st=f14030208ServiceVS.saveBenefitProvideInfo(stp);
   		System.out.println("结果信息："+st.isBizSuccess());
       }
    
}
