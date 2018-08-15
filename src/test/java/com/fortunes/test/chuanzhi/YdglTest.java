package com.fortunes.test.chuanzhi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.powersi.biz.commbiz.outland.dto.OutDTO;
import com.powersi.dubbo.medicare.medicareSpecial.dto.OutLandHospitalDTO;
import com.powersi.dubbo.medicare.medicareSpecial.toFangDi.OutLandInterface;

/*
 * 1.2.13异地管理
 */
public class YdglTest extends DubboTest{
	@Autowired
	OutLandInterface outLandInterface;
	
	/*
	 * 保存异地申请信息(通)
	 * addOutLandInfo
	 */
	public void t1(){
		OutDTO ms=new OutDTO();
		ms.setBke080("430100");
		ms.setAac001("1063657358");
		ms.setAaa027("440111");
		ms.setBke087("441821");
		ms.setAac002("440103199008123038");
		ms.setBke069("13890876543");
		ms.setBke253("1");
		ms.setBke074("1");
		ms.setAae140("391");
		ms.setBke095("1");
		ms.setBke079("430000");
		ms.setBke076("liu");
		ms.setBke098("20161030");
		ms.setAab001("68135395");
		ms.setBke099("20991231");
		//ms.setYzz013("1");
		Map<String,Object> map=outLandInterface.addOutLandInfo(ms);
		out(map);
	}
	
	
	/*
	 * 异地医院信息保存(通)
	 * addOutLandHospitalInfo
	 */
	
	public void t2(){
		OutLandHospitalDTO ms=new OutLandHospitalDTO();
		
		List<Map<String,Object>> Listmap=new ArrayList<Map<String,Object>>();
		Map<String,Object> map=new HashMap<String, Object>();
		//异地医疗机构保存
		map.put("aaz107","471713");
		map.put("akb020","0343");
		map.put("aab069","中南大学湘雅医院");
		map.put("aka101","2");
		map.put("bke301","1");
		map.put("bke309","10");
		map.put("bke074","1");
		map.put("bke088","YDQR0020161101005");
		map.put("aac001","1063657358");
		Listmap.add(map);
		ms.setList(Listmap);
		outLandInterface.addOutLandHospitalInfo(ms);
		out(map);
	}
	
	
	/*
	 * 1.2.13.2异地申请审批（获取异地申请信息）(通)
	 * queryOutLandInfo
	 */
	
	public void t3(){
		OutDTO outdto=new OutDTO();
		outdto.setEndtime("20161101");
		outdto.setBke253("1");
		outdto.setStarttime("20161031");
		List list=outLandInterface.queryOutLandInfo(outdto);
		out(list);
	}
	
	
	/*
	 * 异地申请审批(通)
	 * auditOutLandInfo
	 * 入参：
	 *  1	aaz107	NUMBER(22)	定点医疗机构ID
		2	aaz267	NUMBER(22)	医疗待遇申请事件ID
		3	bfc001	NUMBER(22)	异地医药机构序列号
		4	bke088	NUMBER(22)	异地安置申请序列号
		5	aac001	NUMBER(22)	个人电脑号
		6	aab069	VARCHAR2(70)	组织机构名称
		7	bke301	VARCHAR2(30)	医药机构级别
		8	aka101	VARCHAR2(30)	医药机构等级
		9	bke309	VARCHAR2(30)	医疗机构类型00000000000000000
		10	aae005	VARCHAR2(30)	联系电话
		11	aae004	VARCHAR2(30)	联系人姓名
		12	aae007	VARCHAR2(6)	邮政编码
		13	aae100	CHAR (1)	有效标志,0,无效,1有效
		14	bke081	VARCHAR2(10)	异地安置县/区
		15	akb020	VARCHAR2(10)	医院编号
		16	bke074	VARCHAR2(30)	异地类型
		17	bkc016	VARCHAR2(30)	变更序列号
		18	aae013	VARCHAR2(200)	备注
		19	aae016	CHAR(1)	可编辑标志（0：不可修改；否则可修改）
		20	aae030	DATE	起效时间
		21	aae031	DATE	失效时间
	出参：
		参数1：
			键：issuccess   值：1，成功；0，失败。
			参数2：
			键：errMes     值：具体错误原因
	 */
	@Test
	public void t4(){
		OutLandHospitalDTO outLan=new OutLandHospitalDTO();
		Map<String,Object> map=new HashMap<String, Object>();
		List<Map<String,Object>> listmaps=new ArrayList<Map<String,Object>>();
		map.put("bke253","1");
		map.put("bke083","1");
		map.put("aac001","1063657358");
		map.put("bke088","YDQR0020161101005"); 
		listmaps.add(map);
		outLan.setOutList(listmaps);
		Map<String,Object> mapresult=outLandInterface.auditOutLandInfo(outLan);
		out(mapresult);
	}
	
	
	
	/*
	 * 异地正式取消(1.2.13.3.1获取异地申请信息)
	 * queryOutLandInfo
	 */
	
	public void t5(){
		OutDTO outdto=new OutDTO();
		List list=outLandInterface.queryOutLandInfo(outdto);
		out(list);
	}
	
	
	/*
	 * 异地正式取消(异地申请正式取消)(通)
	 * cancelOutLandInfo
	 */
	
	public void t6(){
		OutLandHospitalDTO outLanddto=new OutLandHospitalDTO();
		Map<String,Object> map=new HashMap<String, Object>();
		List<Map<String,Object>> listmaps=new ArrayList<Map<String,Object>>();
		map.put("bke253","1");
		map.put("bke083","1");
		map.put("aac001","1000320814");
		map.put("bke088","26955");
		listmaps.add(map);
		outLanddto.setOutList(listmaps);
		Map<String,Object> maps=outLandInterface.cancelOutLandInfo(outLanddto);
		out(maps);
	}
}
