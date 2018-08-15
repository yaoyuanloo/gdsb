package com.fortunes.test.chuanzhi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.neusoft.sl.si.settle.dubbo.pension.service.SaveProvCertificateDubboService;
import com.powersi.dubbo.injury.outInter_fangdi.InjuryDeathRegistService_fd;
import com.powersi.dubbo.injury.outInter_fangdi.InjuryInfoEditService_fd;
import com.powersi.dubbo.injury.outInter_fangdi.PreventionService_fd;
import com.powersi.dubbo.injury.outInter_fangdi.dto.InjuryAccidentReportDTO;
import com.powersi.dubbo.injury.outInter_fangdi.dto.InjuryDeathRegistDTO;
import com.powersi.dubbo.injury.outInter_fangdi.dto.PresDTO;
import com.powersi.dubbo.injury.outInter_fangdi.dto.PreventionDTO;
import com.powersi.dubbo.injury.outInter_fangdi.dto.PreventionFeeDTO;

/*
 * 
 */
public class GsyffTest extends DubboTest{
	
	@Autowired
	PreventionService_fd preventionService;
	
	@Autowired
	SaveProvCertificateDubboService  po;
	
	
	@Autowired
	InjuryInfoEditService_fd injuryInfoEdit;
	
	@Autowired
	InjuryDeathRegistService_fd injuryDeathRegist;
	/*
	 * 增加预防费用
	 * 出参：
	 * 1	AAA027	VARCHAR2(6)	false	统筹区编码
		2	AAE016	VARCHAR2(10)	false	复核标志
		3	AAE036	NUMBER(8) 	false	申报日期
		4	BAB001	NUMBER(22)	false	单位ID
		
	     入参：
		
		1	BAB001	NUMBER(22)	false	上级单位ID
		2	AAZ001	NUMBER(22)	false	单位ID
		3	BAB999	VARCHAR2(10)	false	单位管理码
		4	AAB002	VARCHAR2(20)	false	社会保险登记证编码
		5	AAB006	VARCHAR2(50)	false	工商营业执照种类
		6	AAB069	VARCHAR2(100)	false	单位名称
		7	AAB007	VARCHAR2(50)	false	工商营业执照号码
		8	AAB008	DATE	false	工商营业发照日期
		9	AAB009	NUMBER(7)	false	工商营业执照有效期
		10	BAB019	VARCHAR2(10)	false	单位类型
		11	AAB030	VARCHAR2(20)	false	税号
		12	AAE013	VARCHAR2(100)	false	备注
		13	AAZ066	NUMBER(22)	false	税务机构ID
		14	BAC100	VARCHAR2(100)	false	单位专管员姓名
		15	BAC101	VARCHAR2(100)	false	单位专管员所在部门
		16	BAC102	VARCHAR2(100)	false	单位专管员电话
		17	BAC103	VARCHAR2(100)	false	单位专管员手机
		18	BAZ420	NUMBER(22)	false	工伤预防费登记事件ID
		19	AAE011	VARCHAR2(10)	false	经办人
		20	AAE036	NUMBER(8) 	false	申报日期
		21	AAE014	VARCHAR2(50)	false	经办姓名
		22	AAE015	DATE	false	复核时间
		23	AAC001	NUMBER(20)	false	人员ID
		24	AAE016	VARCHAR2(10)	false	复核标志
		25	AAE0161			
		26	AAA027	VARCHAR2(6)	false	统筹区编码
		27	AAZ002	NUMBER(22)	false	辅助器具项目ID
	 */
	public void t1(){
		PreventionDTO pdto=new PreventionDTO();
		List list=preventionService.queryPreventionInstis(pdto);
		out(list);
	}
	
	/*
	 * 预防费用保存
	 * 入参：1	BAB001	NUMBER(22)	false	单位ID
			2	BAZ424	NUMBER(22)	false	辅助器具项目ID
			3	AKC225	NUMBER(22)	false	单价
			4	AKB082	NUMBER(22)	false	预留比例
			5	AKC226	NUMBER(22)	false	数量
			6	AAE058	NUMBER(22)	false	总金额
			
			
		出参:
		出参定义：
			参数1：
			键：issuccess   值：1，成功；0，失败。
			参数2：
			键：errMes     值：具体错误原因
	 */
	public void t2(){
		PreventionFeeDTO p=new PreventionFeeDTO();
		List list=new ArrayList();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("bab001", "9");
		map.put("baz424", "400301");
		map.put("akc226", "12");
		map.put("akc225", "12");
		map.put("aae058", "144");
		map.put("akb082", "0.00");
		list.add(map);
		p.setInsertList(list);
		Map<String,Object> maps=preventionService.savePreventionFeeInfo(p);
		out(maps);
	}
	
	
	
	/*
	 * 预防费用保存
	 * 入参：1	BAB001	NUMBER(22)	false	单位ID
			2	BAZ424	NUMBER(22)	false	辅助器具项目ID
			3	AKC225	NUMBER(22)	false	单价
			4	AKB082	NUMBER(22)	false	预留比例
			5	AKC226	NUMBER(22)	false	数量
			6	AAE058	NUMBER(22)	false	总金额
			
			
		出参:
		出参定义：
			参数1：
			键：issuccess   值：1，成功；0，失败。
			参数2：
			键：errMes     值：具体错误原因
	 */
	
	public void t3(){
		PreventionFeeDTO p=new PreventionFeeDTO();
		List list=new ArrayList();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("bab001", "9");
		map.put("baz424", "400301");
		map.put("akc226", "12");
		map.put("akc225", "12");
		map.put("aae058", "144");
		map.put("akb082", "0.00");
		list.add(map);
		p.setInsertList(list);
		Map<String,Object> maps=preventionService.savePreventionFeeInfo(p);
		out(maps);
	}
	
	
	/*
	 * 工伤信息修改（获取工伤信息）(已通)
	 * 入参：1	aaz128	NUMBER(16)	FALSE	工伤申报ID
			
			
		出参:
		1	aab001	NUMBER(22)	 FALSE	单位ID
			2	aab003	    VARCHAR2(20)	     FALSE	组织机构代码
			3	aab069	VARCHAR2(100)	FALSE	单位名称
			4	aac003	VARCHAR2(50)	FALSE	姓名
			5	aac002	VARCHAR2(20)	FALSE	公民身份号码
			6	alc020	DATE	FALSE	事故时间
			7	alc042	VARCHAR2(3)	FALSE	伤害部位1
			8	alc043	VARCHAR2(3)	FALSE	伤害部位2
			9	alc044	VARCHAR2(3)	FALSE	伤害部位3
			10	alc006	VARCHAR2(500)	FALSE	伤害事件情况
			11	aaz128	NUMBER(16)	FALSE	工伤申报ID
			12	aac001	NUMBER(20)	FALSE	人员ID
			13	alc026	NUMBER(8)	FALSE	报告日期
			14	aae036	NUMBER(8)	FALSE	经办时间
			15	aaz151	NUMBER(16)	FALSE	劳动能力鉴定ID
			16	aaz127	NUMBER(16)	FALSE	工伤认定信息ID
	 */
	public void t4(){
		InjuryAccidentReportDTO indto=new InjuryAccidentReportDTO();
		indto.setAaz128(83l);
		List list=injuryInfoEdit.checkInjuryInfo(indto);
		out(list);
	}
	
	
	/*
	 * 工伤信息修改审核（获取工伤信息）(已通)
	 * 入参：   1	begintime	VARCHAR2(6)	FALSE	开始时间
			2	aae016	VARCHAR2(2)	FALSE	复核标志
			3	endtime	VARCHAR2(6)	FALSE	结束时间
			
			
		出参:
		  1	bba010	    NUMBER(12)	     FALSE	    事件编号
			2	aac002	VARCHAR2(20)	FALSE	公民身份号码
			3	aac003	VARCHAR2(50)	FALSE	姓名
			4	aae011	VARCHAR2(50)	FALSE	经办人
			5	aae036	DATE	FALSE	经办时间
			6	aae014	VARCHAR2(12)	FALSE	复核人
			7	aae015	NUMBER(8)	FALSE	复核时间
			8	aae016	VARCHAR2(2)	FALSE	复核标志
			9	aae0161	VARCHAR2(2)	FALSE	复核标志
			10	aae013	VARCHAR2(300)	FALSE	备注
	 */
	public void t5(){
		PresDTO indto=new PresDTO();
		indto.setBegintime("20161017");
		indto.setAae016("1");
		indto.setEndtime("20171031");
		List list=injuryInfoEdit.injuryEditInfoQuery(indto);
		out(list);
	}
	
	
	
	/*
	 * 工亡待遇核定申请（获取工亡人员信息）
	 * 入参：   1	aac001	VARCHAR2(20)	FALSE	人员ID
			
			
		出参:
		  1	aab999	VARCHAR2(20)	FALSE	单位管理码
			2	aab069	VARCHAR2(100)	FALSE	组织机构名称
			3	aac003	VARCHAR2(20)	FALSE	姓名
			4	alc005	VARCHAR2(20)	FALSE	工伤申报备案编号
			5	aac060	    VARCHAR2(2)	    FALSE	    生存状态
			6	aac006	DATE	FALSE	出生日期
			7	aac004	VARCHAR2(1)	FALSE	性别
			8	aac066	VARCHAR2(3)	TRUE	参保身份
			9	aaz157	NUMBER(16)	FALSE	人员社会保险明细ID
			10	aae005	VARCHAR2(20)	FALSE	短信接收电话
			11	alc021	VARCHAR2(1)	FALSE	伤害程度
			12	alc029	VARCHAR2(1)	FALSE	工伤认定标志
			13	aae013	VARCHAR2(500)	FALSE	备注
			14	aaz128	NUMBER(16)	FALSE	工伤申报ID
			15	alc027	VARCHAR2(1)	FALSE	工伤类别
			16	aae014	VARCHAR2(12)	FALSE	复核人
			17	aae014_id	VARCHAR2(12)	FALSE	复核人
			18	aae015	NUMBER(8)	FALSE	复核时间
			19	aaz127	NUMBER(16)	FALSE	工伤认定信息ID
			20	aaa027	VARCHAR2(6)	FALSE	统筹区编码
	 */
	@Test
	public void t6(){
		InjuryDeathRegistDTO in=new InjuryDeathRegistDTO();
		in.setAac001(1049381776l);
		List list=injuryDeathRegist.queryInfo(in);
		out(list);
	}
}
