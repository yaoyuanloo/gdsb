package com.fortunes.test.dongruan;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.neusoft.sl.si.basicinfo.dubbo.employee.unit.param.UnitInsParamDTODubbo;
import com.neusoft.sl.si.basicinfo.dubbo.employee.unit.param.unitInsParamDTODubbo;
import com.neusoft.sl.si.basicinfo.dubbo.employee.unit.param.unitParamDTODubbo;
import com.neusoft.sl.si.basicinfo.dubbo.employee.unit.result.UnitInsResultDTODubbo;
import com.neusoft.sl.si.basicinfo.dubbo.employee.unit.result.UnitResultDTODubbo;
import com.neusoft.sl.si.basicinfo.dubbo.employee.unit.result.unitInsResultDTODubbo;
import com.neusoft.sl.si.basicinfo.dubbo.employee.unit.result.unitResultDTODubbo;
import com.neusoft.sl.si.basicinfo.dubbo.employee.unit.service.UnitQueryAB01DubboService;

/*
 * 公共接口查询
 */
public class PublicTest extends DubboTest{

	@Autowired
	UnitQueryAB01DubboService unitQueryAB01Dubbo;
	
	/*
	 * 单位基本信息查询
	 */
	public void t1(){
		unitParamDTODubbo param=new unitParamDTODubbo();
		param.setAAB001(1100010l);
		UnitResultDTODubbo ur=unitQueryAB01Dubbo.queryUnitInfo(param);
		System.out.println("结果信息："+ur.getMessage());

	}
	
	
	/*
	 * 单位险种信息查询
	 */
	@Test
	public void t2(){
		UnitInsParamDTODubbo param=new UnitInsParamDTODubbo();
		param.setAAB001(100000000360316l);
		UnitInsResultDTODubbo unresult=unitQueryAB01Dubbo.queryUnitInsInfo(param);
		System.out.println("结果信息111："+unresult.getMessage());

	}
}
