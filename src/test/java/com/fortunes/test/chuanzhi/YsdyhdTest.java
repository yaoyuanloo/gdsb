package com.fortunes.test.chuanzhi;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.powersi.dubbo.injury.outInter_fangdi.RelationApprovedServicr_fd;
import com.powersi.dubbo.injury.outInter_fangdi.dto.InjuryRelationCalculateDTO;

public class YsdyhdTest extends DubboTest{
	@Autowired
	RelationApprovedServicr_fd relationApproved;
	
	/*
	 * 获取遗属及主人信息
	 * 入参：
	 * 1	aac039	NUMBER(16,2)	FALSE	人员工资
		2	aaz127	NUMBER(16)	FALSE	工伤认定信息ID
		3	aac001	NUMBER(20)	FALSE	人员ID
		4	aab001	NUMBER(20)	FALSE	单位编号
		
		出参定义：
		返回值：List<Map>
		包含数据项：
		序号	字段名称	数据类型	主键	注释
		1	injuryInfList	list	FALSE	工亡人员信息
		2	applyInfList	list	FALSE	供养亲属申请
		3	apprInfList	list	FALSE	已有的供养亲属
	 */
	@Test
	public void t1(){
		InjuryRelationCalculateDTO In=new InjuryRelationCalculateDTO();
		In.setAac039(BigDecimal.valueOf(3000.99));
		In.setAaz127(60l);
		In.setAac001(1011701366l);
		In.setAab001(55028227l);
		List list=relationApproved.ApprovedInfQuery(In);
		out(list);
	}
}
