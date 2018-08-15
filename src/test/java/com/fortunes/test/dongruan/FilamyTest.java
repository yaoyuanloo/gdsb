package com.fortunes.test.dongruan;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.neusoft.sl.si.basicinfo.dubbo.employee.community.param.CommunityParamDubboDTO;
import com.neusoft.sl.si.basicinfo.dubbo.employee.community.result.CommunityResultDubboDTO;
import com.neusoft.sl.si.basicinfo.dubbo.employee.community.service.CommunityManageDubboService;
import com.neusoft.sl.si.basicinfo.dubbo.employee.family.param.BankAccountDTODubbo;
import com.neusoft.sl.si.basicinfo.dubbo.employee.family.param.FamilyParamDubboDTO;
import com.neusoft.sl.si.basicinfo.dubbo.employee.family.param.OrgInsuranceDTODubbo;
import com.neusoft.sl.si.basicinfo.dubbo.employee.family.result.FamilyResultDubboDTO;
import com.neusoft.sl.si.basicinfo.dubbo.employee.family.service.FamilyManageDubboService;

public class FilamyTest extends DubboTest {
	
	@Autowired
	FamilyManageDubboService familyManageDubbo;
	
	@Autowired
	CommunityManageDubboService communityManage;
	/*
	 * 家庭登记查询
	 * 接口类：com.neusoft.sl.si.basicinfo.dubbo.employee.family.service.FamilyManageDubboService
	 * 接口方法：接口方法：public FamilyResultDubboDTO dubboQueryFamilyInfo (FamilyParamDubboDTO familyParamDubboDTO);
	 * 入参：private String AAB999; 单位管理码
	 * 出参：private long BAZ002; 操作流水号
			private String AAB999; 单位管理码
			private String AAB400; 户主姓名
			private String AAC058; 户主证件类型
			private String AAC147; 户主证件号码
			private Long BAB100; 户籍人口数
			private String AAC300; 户口所在地行政区划代码
			private String AAC010; 户口所在地详细地址
			private String AAC301; 常住地行政区划代码
			private String AAE006; 常住地详细地址
			private String BAB101; 签发单位
			private String BAA120; 有效状态
			private String AAE013; 备注
			private BankAccountDTODubbo paymentAccount; 支出银行账户
			private BankAccountDTODubbo withdrawAccount; 收款银行账户
			private List<OrgInsuranceDTODubbo> orgInsuranceDTOList; 单位参保关系
			private String BizSuccess; 成功标识
			private String ErrorCode; 返回标志
			private String Message; 返回信息

	 */
	public void t1(){
		FamilyParamDubboDTO Fdto=new FamilyParamDubboDTO();
		Fdto.setAAC058("02");
		Fdto.setAAC147("2016102402");
		FamilyResultDubboDTO fr=familyManageDubbo.dubboQueryFamilyInfoByTypeAndCode(Fdto);
		System.out.println("fr.getAAB400:"+fr.getAAB400());
	}
	
	
	/*
	 * 家庭登记保存
	 * 入参：
	 *  private String AAB400; 户主姓名
		private String AAC058; 户主证件类型
		private String AAC147; 户主证件号码
		private Long BAB100; 户籍人口数
		private String AAC300; 户口所在地行政区划代码
		private BankAccountDTODubbo paymentAccount; 支出银行账户
		private BankAccountDTODubbo withdrawAccount; 收款银行账户
		private List<OrgInsuranceDTODubbo> orgInsuranceDTOList; 单位参保关系
		
	  出参
	  	private long BAZ002; 操作流水号
		private String AAB999; 单位管理码
		private String AAB400; 户主姓名
		private String AAC058; 户主证件类型
		private String AAC147; 户主证件号码
		private Long BAB100; 户籍人口数
		private String AAC300; 户口所在地行政区划代码
		private String AAC010; 户口所在地详细地址
		private String AAC301; 常住地行政区划代码
		private String AAE006; 常住地详细地址
		private BankAccountDTODubbo paymentAccount; 支出银行账户
		private BankAccountDTODubbo withdrawAccount; 收款银行账户
		private List<OrgInsuranceDTODubbo> orgInsuranceDTOList; 单位参保关系
		private String BizSuccess; 成功标识
		private String ErrorCode; 返回标志
		private String Message; 返回信息
		
		
		
		注：参数中BankAccountDTODubbo中键值对的对应说明，如下图：
		字段	含义	类型
		AAE009	银行户名	VARCHAR2(100)
		AAE010	银行帐号	VARCHAR2(40)
		AAF200	银行行别代码	VARCHAR2(3)
		 ‘注：参数中OrgInsuranceDTODubbo中键值对的对应说明，如下图：
		字段	含义	类型
		AAE140	险种类型	VARCHAR2(3)
		AAB050	单位参保日期	NUMBER(8)
		AAB051	单位参保缴费状态	VARCHAR2(1)
		BAA140	征收方式方案编号	VARCHAR2(10)


		

	 */
	public void t2(){
		FamilyParamDubboDTO paraDTO=new FamilyParamDubboDTO();//dubbo类型的家庭信息
		paraDTO.setAAB999("3000288");
		paraDTO.setAAB400("w1");
		paraDTO.setAAE013("34");
		paraDTO.setAAC058("02");
		paraDTO.setAAC147("110101198001010053");
		paraDTO.setBAB100(100l);
		paraDTO.setAAC300("440000000000");
		//ae03 ae04
		BankAccountDTODubbo payD=new BankAccountDTODubbo();
		payD.setAAE009("支付户名1");
		payD.setAAE010("1131");
		payD.setAAF200("104");
		paraDTO.setPaymentAccount(payD);
		BankAccountDTODubbo with=new BankAccountDTODubbo();
		with.setAAE009("收入户名1");
		with.setAAE010("1121");
		with.setAAF200("103");
		paraDTO.setWithdrawAccount(with);
		//ab02
		OrgInsuranceDTODubbo org = new OrgInsuranceDTODubbo();
        org.setAAE140("390");       
        org.setAAB050(Long.valueOf(20161023));
        org.setAAB051("2");
        org.setBAA140("20");  
        List<OrgInsuranceDTODubbo> orgDubboList = new ArrayList<OrgInsuranceDTODubbo>();
        orgDubboList.add(org);
        paraDTO.setOrgInsuranceDTOList(orgDubboList);

        
		
        FamilyResultDubboDTO fpdto=familyManageDubbo.dubboExecuteRegisterFamily(paraDTO);
        System.out.println("fpdto:"+fpdto.getErrorCode());
	}
	
	
	/*
	 * 家庭维护模块查询
	 */
	public void t3(){
		FamilyParamDubboDTO Fdto=new FamilyParamDubboDTO();
		Fdto.setAAB999("3000273");
		FamilyResultDubboDTO fr=familyManageDubbo.dubboQueryFamilyInfo(Fdto);
		System.out.println("fr.getAAB400:"+fr.getAAB400());
	}
	
	
	/*
	 * 家庭维护模块修改
	 */
	public void t4(){
		FamilyParamDubboDTO paraDTO=new FamilyParamDubboDTO();//dubbo类型的家庭信息
		paraDTO.setAAB999("3000301");
		paraDTO.setAAB400("w1");
		paraDTO.setAAE013("34");
		paraDTO.setAAC058("02");
		paraDTO.setAAC147("110101198001010053");
		paraDTO.setBAB100(100l);
		paraDTO.setAAC300("440000000000");
		//ae03 ae04
		BankAccountDTODubbo payD=new BankAccountDTODubbo();
		payD.setAAE009("支付户名2");
		payD.setAAE010("1132");
		payD.setAAF200("102");
		paraDTO.setPaymentAccount(payD);
		BankAccountDTODubbo with=new BankAccountDTODubbo();
		with.setAAE009("收入户名2");
		with.setAAE010("1122");
		with.setAAF200("102");
		paraDTO.setWithdrawAccount(with);
		//ab02
		OrgInsuranceDTODubbo org = new OrgInsuranceDTODubbo();
        org.setAAE140("390");       
        org.setAAB050(Long.valueOf(20161027));
        org.setAAB051("2");
        org.setBAA140("30");  
        List<OrgInsuranceDTODubbo> orgDubboList = new ArrayList<OrgInsuranceDTODubbo>();
        orgDubboList.add(org);
        paraDTO.setOrgInsuranceDTOList(orgDubboList);
        FamilyResultDubboDTO fpdto=familyManageDubbo.dubboExecuteModifyFamily(paraDTO);
        System.out.println("fpdto:"+fpdto.getErrorCode());
	}
	
	
	/*
	 * 社区/村登记查询
	 */
	
	public void t5(){
		CommunityParamDubboDTO cpd=new CommunityParamDubboDTO();
		cpd.setAAF031("变更的小村庄");
		CommunityResultDubboDTO cdto=communityManage.dubboQueryCommunityInfoByName(cpd);
		System.out.println("结果信息："+cdto.getErrorCode());

	}
	
	
	/*
	 * 社区/村登记保存
	 */
	public void t6(){
		CommunityParamDubboDTO param=new CommunityParamDubboDTO();//dubbo类型的家庭信息

		param.setAAF031("777");
		param.setAAF019("1");
		param.setAAB301("440000000000");
		//ae03 ae04
		BankAccountDTODubbo payD=new BankAccountDTODubbo();
		payD.setAAE009("支付户名1");
		payD.setAAE010("1131");
		payD.setAAF200("104");
		param.setPaymentAccount(payD);
		BankAccountDTODubbo with=new BankAccountDTODubbo();
		with.setAAE009("收入户名1");
		with.setAAE010("1121");
		with.setAAF200("103");
		param.setWithdrawAccount(with);
		//ab02
		OrgInsuranceDTODubbo org = new OrgInsuranceDTODubbo();
        org.setAAE140("390");       
        org.setAAB050(Long.valueOf(20161023));
        org.setAAB051("2");
        org.setBAA140("20");  
        List<OrgInsuranceDTODubbo> orgDubboList = new ArrayList<OrgInsuranceDTODubbo>();
        orgDubboList.add(org);
        param.setOrgInsuranceDTOList(orgDubboList);
        
        CommunityResultDubboDTO cdto=communityManage.dubboExecuteRegisterCommunity(param);
        System.out.println("结果信息："+cdto.getErrorCode());
	}
	
	
	
	/*
	 * 社区/村维护查询
	 */
	public void t7(){
		CommunityParamDubboDTO param=new CommunityParamDubboDTO();
		param.setAAB999("100000000280136");
		CommunityResultDubboDTO cdto=communityManage.dubboQueryCommunityInfo(param);
		System.out.println("结果信息："+cdto.getMessage());

	}
	
	
	/*
	 * 社区/村维护保存
	 */
	@Test
	public void t8(){
		CommunityParamDubboDTO param=new CommunityParamDubboDTO();//dubbo类型的家庭信息
		param.setAAB999("100000000390210");
		param.setAAF031("215");
		param.setAAF019("1");
		param.setAAB301("440000000000");
		
		BankAccountDTODubbo payD=new BankAccountDTODubbo();
		payD.setAAE009("支付2");
		payD.setAAE010("772");
		payD.setAAF200("102");
		param.setPaymentAccount(payD);
		BankAccountDTODubbo with=new BankAccountDTODubbo();
		with.setAAE009("收入2");
		with.setAAE010("882");
		with.setAAF200("102");
		param.setWithdrawAccount(with);
		//ab02
		OrgInsuranceDTODubbo org = new OrgInsuranceDTODubbo();
        org.setAAE140("390");       
        org.setAAB050(Long.valueOf(20161030));
        org.setAAB051("2");
        org.setBAA140("30");  
        List<OrgInsuranceDTODubbo> orgDubboList = new ArrayList<OrgInsuranceDTODubbo>();
        orgDubboList.add(org);
        param.setOrgInsuranceDTOList(orgDubboList);
        
        CommunityResultDubboDTO cr=communityManage.dubboExecuteModifyCommunity(param);
        System.out.println("结果信息cr："+cr.getMessage());
        
	}
	
	
	
}
