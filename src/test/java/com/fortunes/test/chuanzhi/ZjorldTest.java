package com.fortunes.test.chuanzhi;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.powersi.dubbo.injury.outInter_fangdi.CityLabourEvalManageService_fd;
import com.powersi.dubbo.injury.outInter_fangdi.dto.LabourEvalManageDTO;
import com.powersi.dubbo.injury.outInter_fangdi.dto.auditBatchInfoDto;
import com.powersi.dubbo.injury.outInter_fangdi.dto.expertChooseDto;

public class ZjorldTest extends DubboTest{
	
	@Autowired
	CityLabourEvalManageService_fd cityLabourEvalManage;
	
	/*
	 * 1.4.6专家鉴定结论代录(保存劳鉴申请信息)
	 * expertResInpSave
	 * 
	 */
	
	public void t1(){
		LabourEvalManageDTO lad=new LabourEvalManageDTO();
		/*lad.setBlc753("测试1");
		lad.setBlz510("测试2");
		lad.setBhz988("测试3");
		lad.setBhz989("测试4");
		lad.setAla040("测试5");
		lad.setAlc060("1");
		lad.setTglx(tglx);
		lad.setAae031(1);
		lad.setAab001(1);
		lad.setAab001(aab001);*/
		Map<String,Object> map=cityLabourEvalManage.expertResInpSave(lad);
		
	}
	
	/*
	 * 78 获取代录信息 查询queryResultInfo
	 */
	public void t2(){
		LabourEvalManageDTO la=new LabourEvalManageDTO();
		la.setBlz510("71");
		la.setAac001(1000047560l);
		la.setAaa027("441802");
		List list=cityLabourEvalManage.queryResultInfo(la);
		out(list);
	}
	
	
	/*	
	 * 鉴定专家抽取 抽取信息保存choPlanQuery
	 */
	public void t3(){
		expertChooseDto dto=new expertChooseDto();
		dto.setBaz220("441802");
		dto.setBhk542("1");
		dto.setBhk541("1");
		dto.setBaz215("55");
		dto.setAkf001("1");
		dto.setBaz201("40,41,39");
		dto.setBhk541("undefined");
		dto.setBhk542("undefined");
		List list=cityLabourEvalManage.choPlanQuery(dto);
		out(list);
	}
	
	
	/*	
	 * 获取抽取批次记录
	 * auidtBatchQuery
	 */
	public void t4(){
		auditBatchInfoDto au=new auditBatchInfoDto();
		au.setAaz612("4");
		au.setAaa027("441802");
		List list=cityLabourEvalManage.auidtBatchQuery(au);
		out(list);
	}
	
	
	/*	
	 * 查询需要鉴定的信息
	 * auidtBatchQuery
	 */
	public void t5(){
		auditBatchInfoDto au=new auditBatchInfoDto();
		au.setAaz612("4");
		au.setAaa027("441802");
		List list=cityLabourEvalManage.auditBatchQuery(au);
		out(list);
	}
	
	
	/*	
	 * 保存鉴定信息
	 * auidtBatchQuery
	 */
	public void t6(){
		LabourEvalManageDTO la=new LabourEvalManageDTO();
		la.setBhk538("0");
		la.setPlantype("1");
		la.setBhk533("12");
		la.setBhk532("20161101阿斯顿");
		Map<String,Object> map=cityLabourEvalManage.checkPlanSave(la);
		out(map);
	}
	
	
	
	/*	
	 * 获取鉴定申请信息
	 * evalCheckInfQuery
	 */
	@Test
	public void t7(){
		LabourEvalManageDTO la=new LabourEvalManageDTO();
		la.setPlantype("1");
		la.setBhk533("12");
		List list=cityLabourEvalManage.evalCheckInfQuery(la);
		out(list);
	}
	
	
	
	
	
	
}
