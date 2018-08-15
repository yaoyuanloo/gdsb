package com.fortunes.test.chuanzhi;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.powersi.biz.medicare.medicareCommbiz.dto.MedInstDepManDTO;
import com.powersi.biz.medicare.medicareSpecial.dto.MediSpecDTO;
import com.powersi.biz.medicare.mzSelectHosp.dto.MzSelectHospDTO;
import com.powersi.dubbo.injury.outInter_fangdi.MaternityRegService_fd;
import com.powersi.dubbo.medicare.medicareSpecial.dto.ChangeHospitalDTO;
import com.powersi.dubbo.medicare.medicareSpecial.dto.SpecialAndChronicDTO;
import com.powersi.dubbo.medicare.medicareSpecial.toFangDi.ChangeHospitalInterface;
import com.powersi.dubbo.medicare.medicareSpecial.toFangDi.DesignatedHospitalRecordAddInterface;
import com.powersi.dubbo.medicare.medicareSpecial.toFangDi.HospitalQueryInterface;
import com.powersi.dubbo.medicare.medicareSpecial.toFangDi.OutLandInterface;
import com.powersi.dubbo.medicare.medicareSpecial.toFangDi.PatientSelectedHospitalInterface;
import com.powersi.dubbo.medicare.medicareSpecial.toFangDi.SecondReturnHospitalInterface;
import com.powersi.dubbo.medicare.medicareSpecial.toFangDi.SpecialAndChronicDiseaseInterface;
import com.powersi.dubbo.medicare.medicareSpecial.toFangDi.SpecialAndChronicInterface;

public class ZhuangzhengTest extends DubboTest{
	
	@Autowired
	ChangeHospitalInterface changeHospitalInterface;
	
	@Autowired
	DesignatedHospitalRecordAddInterface designated;
	
	@Autowired
	HospitalQueryInterface hospitalQueryInterface;
	
	@Autowired
	OutLandInterface outLandInterface;
	
	
	@Autowired
	PatientSelectedHospitalInterface patientSelected;
	
	@Autowired
	SecondReturnHospitalInterface secondReturn;
	
	
	@Autowired
	SpecialAndChronicDiseaseInterface specialAnd;
	
	@Autowired
	SpecialAndChronicInterface specialAndChronic;
	
	
	@Autowired  
	MaternityRegService_fd Maternity;
	/**
	 * 新增非定点医院就医备案信息(已通)
	 * 接口名称：public Map addDesignatedHospitalRecord(MediSpecDTO dto);
	 * @param dto (aac001:个人电脑号；aac002:身份证号；aac003:姓名；aac004:性别；aac006:出生日期；aac007:工作日期；
	 * aab001:单位电脑号；aae140:险种；bka006:待遇类别；bka004:人员类别；aab069:单位名称；aaa027:所属区；
	 * aae011:申请人工号；bae100:申请人；aae127:申请时间；aae030:开始日期；aae031:结束日期；aae013:备注；
	 * akb020:医疗机构编码；akb021:医疗机构名称;bke011:病情摘要；bke003:病种编码)
	 * 
	 * @return  issuccess：成功标志(0:失败；1:成功)；errMes：处理结果信息；aaz267:申请序列号
	 * @throws ParseException 
	 */
	
	public void t1() throws ParseException{
		MediSpecDTO ms=new MediSpecDTO();
		ms.setAac001(1060780253);
		ms.setAac002("441622198308123067");
		ms.setAac003("郑妮娟");
		ms.setAac004("1");
		ms.setAae030(org.apache.commons.lang3.time.DateUtils.parseDate("2016-10-30", "yyyy-MM-dd"));
		ms.setAae031(org.apache.commons.lang3.time.DateUtils.parseDate("2016-11-30", "yyyy-MM-dd"));
		ms.setBka006("120");
		ms.setAac006(org.apache.commons.lang3.time.DateUtils.parseDate("1983-08-12", "yyyy-MM-dd"));
		ms.setAac007("2006-05-01");
		Map<String,Object> m=designated.addDesignatedHospitalRecord(ms);
		out(m);
	}
	
	

	/**
	 * 门诊选定医院(新增)(已通)
	 * 接口名称：public Map addDesignatedHospitalRecord(MediSpecDTO dto);
	 */
	
	public void t2() throws ParseException{
		MzSelectHospDTO msh=new MzSelectHospDTO();
		msh.setBka006("110");
		msh.setAac066("393");
		msh.setAaa027("440104");
		msh.setAab069("广州市土地房产管理职业学校");
		msh.setAac006("19970916");
		msh.setBae100("杨晴");
		msh.setAac001("3500367206");
		msh.setAac002("441721199709161025");
		msh.setAab001("68086245");
		msh.setAae013("备注测试");
		msh.setAkb020("002001");
		msh.setAae011("1029");
		msh.setAkb021("广东省人民医院");
		msh.setAae031("20161231");
		msh.setAae140("310");
		msh.setAae030("20160101");
		Map<String,Object> m=patientSelected.addPatientSelectedHospitalInfo(msh);
		out(m);
	}
	
	
	/**
	 * 门诊选定医院(查询)(已通)
	 * 接口名称：public Map addDesignatedHospitalRecord(MediSpecDTO dto);
	 */
	
	public void t3() throws ParseException{
		MzSelectHospDTO mz=new MzSelectHospDTO();
		mz.setAac001("3500367206");
		List list=patientSelected.queryPatientSelectedHospitalInfo(mz);
		out(list);
		
	}
	
	
	/**
	 * 门诊选定医院(初审)(通)
		list：(aaz267:序列号；bka137:初审人工号；bkb102:初审人；bkb103:初审意见；
	 * aae016:审核标志(2:初审通过；3：初审不通过)
	 * 接口名称：public Map addDesignatedHospitalRecord(MediSpecDTO dto);
	 */
	
	public void t4() throws ParseException{
		ChangeHospitalDTO ch=new ChangeHospitalDTO();
		List<Map<String,Object>> listmap=new ArrayList<Map<String,Object>>();
		Map<String,Object> maps=new HashMap<String, Object>();
		maps.put("bka137", "1049");
		maps.put("bkb102", "jjn");
		maps.put("bkb103", "同意");
		maps.put("aae016", "2");
		maps.put("aac001","3500367206");
		maps.put("aaa027","440104");
		maps.put("aaz267","11000296");
		listmap.add(maps);
		ch.setPatientList(listmap);
		Map<String,Object> m=patientSelected.auditPatientSelectedHospitalInfo(ch);
		out(m);
		
	}
	
	
	/**
	 * 4、门诊选定医院复审：传入参数是List(下面的参数必传)(通)
		list：(aaz267:序列号；bka143:复审人工号；aae014:复审人；bkb087:复审意见；
	 * aae016:审核标志(4:复审通过；5：复审不通过)

	 */
	@Test
	public void t5() throws ParseException{
		ChangeHospitalDTO changeHospitalDTO=new ChangeHospitalDTO();
		List<Map<String,Object>> listmap=new ArrayList<Map<String,Object>>();
		Map<String,Object> maps=new HashMap<String, Object>();
		maps.put("bka143", "1049");
		maps.put("aae014", "jjn");
		maps.put("bkb087", "同意");
		maps.put("aae016", "4");
		maps.put("aac001","3500367206");
		maps.put("aaa027","440104");
		maps.put("aaz267","11000296");
		listmap.add(maps);
		changeHospitalDTO.setPatientList(listmap);
		Map<String,Object> m=patientSelected.checkPatientSelectedHospitalInfo(changeHospitalDTO);
		out(m);
		
	}
	
	
	
	/* * 获取医院信息(已通)*/
	 
	public void t6(){
		MedInstDepManDTO med=new MedInstDepManDTO();
		med.setAkb020("002001");
		List list=hospitalQueryInterface.queryHospitalInfo(med);
		out(list);
	}
	
	
	
	/* * 获取疾病信息(已通)*/
	 
	
	public void t7(){
		SpecialAndChronicDTO sp=new SpecialAndChronicDTO();
		sp.setAka083("132");
		List list=specialAnd.getDiseaseInfo(sp);
		/*Map<String,Object> map=JSONObject.fromObject(list.get(0));
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}*/
	}
	
	
	
	/* * 门特（门慢）特殊业务信息保存(已通) */
	 
	
	public void t8() throws ParseException{
		MediSpecDTO meds=new MediSpecDTO();
		meds.setAac002("440111197704282113");
		meds.setAac003("曾祥沃");
		meds.setAac001(1002623440l);
		meds.setBke011("测试数据");
		meds.setBke034(org.apache.commons.lang3.time.DateUtils.parseDate("2016-10-30","yyyy-MM-dd"));
		meds.setBke013("同意申请");
		meds.setBke014("13678909876");
		meds.setBke015("23");
		meds.setAae140("310");
		meds.setBke016("13678909876");
		meds.setAka083("132");
		meds.setBka017("wang");
		meds.setBke018("liu");
		meds.setBke019(org.apache.commons.lang3.time.DateUtils.parseDate("2016-10-30","yyyy-MM-dd"));
		meds.setBka004("1");
		meds.setAac006(org.apache.commons.lang3.time.DateUtils.parseDate("1977-04-28","yyyy-MM-dd"));
		meds.setAac003("曾祥沃");
		meds.setAac004("1");
		meds.setAab069("广州英之略劳动咨询有限公司");
		meds.setAac007("1996-07-01");
		
		meds.setBke020(org.apache.commons.lang3.time.DateUtils.parseDate("2016-10-30","yyyy-MM-dd"));
		meds.setAae036(org.apache.commons.lang3.time.DateUtils.parseDate("2016-10-30","yyyy-MM-dd"));
		meds.setAab001("80021911");
		meds.setBke003("I10.x00");
		meds.setAae031(org.apache.commons.lang3.time.DateUtils.parseDate("2099-12-31","yyyy-MM-dd"));
		meds.setAae030(org.apache.commons.lang3.time.DateUtils.parseDate("2016-10-01","yyyy-MM-dd"));
		meds.setAkb021("广东省人民医院");
		meds.setAkb020("002001");
		meds.setAaa027("441821");
		Map<String,Object> mp=specialAndChronic.addSpecialAndChronicInfo(meds);
		out(mp);
	}
	
	
	
	 /** 查询门特（门慢）特殊业务信息*  /(已经通)
	  * 
	  */
	
	public void t9(){
		MediSpecDTO me=new MediSpecDTO();
		me.setAac001(1002623440l);
		me.setAka083("132");
		List list=specialAndChronic.querySpecialAndChronicInfo(me);
		out(list);
	}
	
	
	
	 /** 门特（门慢）特殊业务审核(初审)(已通)*/
	
	public void t10(){
		SpecialAndChronicDTO sp=new SpecialAndChronicDTO();
		List<Map<String,Object>> listmap=new ArrayList<Map<String,Object>>();
		Map<String,Object> maps=new HashMap<String, Object>();
		maps.put("aaz267","11000294");
		maps.put("bka137","1049");
		maps.put("bke021","jjn");
		maps.put("bke024","不通过");
		maps.put("aae016","2");
		maps.put("aac001","1002623440");
		maps.put("aaa027","441821");
		listmap.add(maps);
		sp.setList(listmap);
		Map<String,Object> m=specialAndChronic.auditSpecialAndChronicInfo(sp);
		out(m);
	}
	
	
	 /** 门特（门慢）特殊业务审核(复审)(已通)*/
	public void t11(){
		SpecialAndChronicDTO sp=new SpecialAndChronicDTO();
		List<Map<String,Object>> listmap=new ArrayList<Map<String,Object>>();
		Map<String,Object> maps=new HashMap<String, Object>();
		maps.put("aaz267","11000294");
		maps.put("bka143","1049");
		maps.put("aae014","jjn");
		maps.put("aae189","不通过");
		maps.put("aae016","4");
		maps.put("aac001","1002623440");
		maps.put("aaa027","441821");
		listmap.add(maps);
		sp.setList(listmap);
		Map<String,Object> m=specialAndChronic.auditSpecialAndChronicInfo(sp);
		out(m);
	}
	
	
	
	
	
	
}
