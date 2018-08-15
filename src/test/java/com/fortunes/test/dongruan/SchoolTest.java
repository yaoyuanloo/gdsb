package com.fortunes.test.dongruan;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.neusoft.sl.si.basicinfo.dubbo.employee.family.param.BankAccountDTODubbo;
import com.neusoft.sl.si.basicinfo.dubbo.employee.family.param.OrgInsuranceDTODubbo;
import com.neusoft.sl.si.basicinfo.dubbo.employee.school.param.SchoolParamDubboDTO;
import com.neusoft.sl.si.basicinfo.dubbo.employee.school.result.SchoolResultDubboDTO;
import com.neusoft.sl.si.basicinfo.dubbo.employee.school.service.SchoolManageDubboService;

public class SchoolTest extends DubboTest{
	@Autowired
	SchoolManageDubboService schoolManage;
	
	/*
	 * 学校登记模块查询
	 */
	
	public void t1(){
		SchoolParamDubboDTO param=new SchoolParamDubboDTO();
		param.setAAB004("学校名称1");
		SchoolResultDubboDTO sldto=schoolManage.dubboQuerySchoolInfoByName(param);
		System.out.println("结果数据sldto:"+sldto.getMessage());
	}
	
	

	/*
	 * 学校登记模块保存
	 */
	public void t2(){
		SchoolParamDubboDTO param=new SchoolParamDubboDTO();
		param.setAAB004("学校名称3");
		param.setAAB451("23");
		param.setAAB301("440000000000");
		//ae03 ae04
		BankAccountDTODubbo payD=new BankAccountDTODubbo();
		payD.setAAE009("支付学校3");
		payD.setAAE010("7723");
		payD.setAAF200("103");
		param.setPaymentAccount(payD);
		BankAccountDTODubbo with=new BankAccountDTODubbo();
		with.setAAE009("收入学校3");
		with.setAAE010("8823");
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
		SchoolResultDubboDTO sldto=schoolManage.dubboExecuteRegisterSchool(param);
		System.out.println("结果数据sldto:"+sldto.getMessage());
	}
	
	
	/*
	 * 学校维护模块查询
	 */
	
	public void t3(){
		SchoolParamDubboDTO param=new SchoolParamDubboDTO();
		param.setAAB999("3000341");
		SchoolResultDubboDTO sldto=schoolManage.dubboQuerySchoolInfo(param);
		System.out.println("结果数据sldto:"+sldto.getMessage());
	}
	
	

	/*
	 * 学校登记模块保存
	 */
	@Test
	public void t4(){
		SchoolParamDubboDTO param=new SchoolParamDubboDTO();
		param.setAAB999("3000341");
		param.setAAB451("30");
		param.setAAB301("440000000000");
		//ae03 ae04
		BankAccountDTODubbo payD=new BankAccountDTODubbo();
		payD.setAAE009("支付学校12");
		payD.setAAE010("77222");
		payD.setAAF200("102");
		param.setPaymentAccount(payD);
		BankAccountDTODubbo with=new BankAccountDTODubbo();
		with.setAAE009("收入学校22");
		with.setAAE010("88222");
		with.setAAF200("102");
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
		SchoolResultDubboDTO sldto=schoolManage.dubboExecuteModifySchool(param);
		System.out.println("结果数据sldto111111:"+sldto.getMessage());
	}
	
}
