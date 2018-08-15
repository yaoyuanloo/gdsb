package com.fortunes.test.chuanzhi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.powersi.biz.medicare.mediAudit.dto.KCE6DTO;
import com.powersi.biz.medicare.mediAudit.dto.KCE8DTO;
import com.powersi.biz.medicare.medicareReimburse.dto.mediReimCardDTO;
import com.powersi.dubbo.medicare.auditFee.MedicalAuditInterface;
import com.powersi.dubbo.medicare.dto.AuditDTO;
import com.powersi.dubbo.medicare.dto.MedicalFeeDTO;

public class PublicjkTest extends DubboTest{
	@Autowired
	MedicalAuditInterface med;
	
	/*
	 * 就诊信息查询(通)
	 */
	public void queryjzInfo(){
		MedicalFeeDTO md=new MedicalFeeDTO();
		md.setEnd_date("20161103");
		md.setExec_flag("0");
		md.setArg_value("1058777360");
		md.setBegin_date("20000101");
		md.setInsur_no("310");
		md.setArg_name("aac001");
		md.setSerial_no("0230361601630909");
		md.setBiz_type("1");
		Map<String,Object> list=med.getPersonSquare(md);
		out(list);
	}
	
	
	/*
	 * 费用信息查询
	 */
	@Test
	public void queryMedicalFee(){
		MedicalFeeDTO me=new MedicalFeeDTO();
		me.setHospital_id("023036");
		me.setExec_flag("hospfeeiteminfo");
		me.setSerial_no("0230361601630909");
		List list=med.queryMedicalFee(me);
		out(list);
	}
	
	
	/*
	 * 参保人拨付账户信息维护(通)
	 */
	public void query(){
		mediReimCardDTO mrcdto=new mediReimCardDTO();
		mrcdto.setUpdateFlag("");
		mrcdto.setAaz003_r("");
		mrcdto.setAae140("310");
		mrcdto.setAac002("440102195502042810");
		mrcdto.setAae005("13678909865");
		mrcdto.setAae004("%E6%9C%B1%E7%A3%8A%E6%98%8E");
		mrcdto.setAae007("510000");
		mrcdto.setAab069("朱磊明");
		mrcdto.setAae006("%E5%B9%BF%E5%B7%9E%E5%B8%82");
		mrcdto.setAae013("%E6%B5%8B%E8%AF%95");
		mrcdto.setBka087("P");
		mrcdto.setBka152("");
		mrcdto.setBka151("%E4%B8%B4%E6%97%B6%E8%B4%A6%E6%88%B7");
		mrcdto.setAaz003("1234567890");
		mrcdto.setBke957("4");
		mrcdto.setAaz065("200004001");
		mrcdto.setAaz010("1007543982");
		mrcdto.setBka149("1");
	    Map<String,Object> maps=med.saveReimCard(mrcdto);
		out(maps);
	}
	
	
	/*
	 * 业务信息多级审核/业务信息多级取消审核
	 */
	
	public void saveAuditBizYL(){
		KCE6DTO asDTO = new KCE6DTO();
		AuditDTO da=new AuditDTO();
		List<KCE6DTO> s=new ArrayList<KCE6DTO>();
		
		asDTO.setBka116("-9");          
		asDTO.setAkb020("01");
		asDTO.setAaz218("-8");	
		asDTO.setBae010("-7");     //业务交接号
		asDTO.setBka122("1");	 //整比扣减标记
		asDTO.setBka123("tt");	 //扣减原因
		asDTO.setBka037("1");	 // 零报标志
		asDTO.setBkc110("1");	 // 医院级别	
		asDTO.setAuditflag("1");  	 //审核标志 1初审，2复审，-1取消初审 -2取消复审
		
		if("-1,1".indexOf("1") >= 0){   
		asDTO.setBka004("1");     //人员类别

		if("-1".equals("1")){     
		asDTO.setBka138("0");
		asDTO.setBka140("0");
		asDTO.setBka142("0");
		asDTO.setBka126("0");
		asDTO.setBkc010("");
		}else{
		asDTO.setBka137("fd");
		asDTO.setBka138("1");
		asDTO.setBka139("fd");
		asDTO.setBka140("1");
		asDTO.setBka141("fd");
		asDTO.setBka142("1");
		asDTO.setBka126("1");
		asDTO.setBkc010(String.valueOf((new Date())));
		}
		}else if("-2,2".indexOf("1") >= 0){
		if("-2".equals("1")){
		asDTO.setBka143("");
		asDTO.setBka126("1");
		}else{
		asDTO.setBka143("fd");
		asDTO.setBka126("2");
		}
		}else if("-4,4".indexOf("1") >= 0){
		if("-4".equals("1")){
		asDTO.setBka145("");
		asDTO.setBka146("0");
		asDTO.setBka126("4");
		}else{
		asDTO.setBka145("fd");
		asDTO.setBka146("L");
		asDTO.setBka126("4");
		}
		}
		
		s.add(asDTO);
		da.setAsDTO(s);
		da.setAudit_flag("1");
		da.setAae016("1");
		int i=med.saveAuditBizYL(da);
		System.out.println(i);
	}
	
	
	/*
	 * 明细扣减信息保存/明细扣减信息修改
	 */
	
	public void saveAuditFeeDetailYL(){
		KCE8DTO asDTO = new KCE8DTO();
		AuditDTO da=new AuditDTO();
		List<KCE8DTO> s=new ArrayList<KCE8DTO>();
		
		 
		asDTO.setBka116("-11111");       //登帐号
		asDTO.setBka203("1");	 //审核类别（1：月审核 2：年终清算审核）
		asDTO.setAaz213("-1");	 //费用序列号
		asDTO.setAka063("1");	 //统计类别
		asDTO.setAke001("00");	 //社保三大目录统一编码
		asDTO.setAke002("tt");	 //社保三大目录名称
		asDTO.setAke003("0");	//三大目录类别
		asDTO.setAke005("0");	//医疗机构三大目录编码
		asDTO.setAke006("tt");	//医疗机构三大目录名称
		asDTO.setBka058("100.0");	 //原费用
		asDTO.setBka206("20");	 //审核扣减金额
		asDTO.setBka207("1");	//拒付原因编号
		asDTO.setBka208("tt");	 //拒付原因
		                                                        //
		asDTO.setBka205("123");	 //审核人工号
		asDTO.setBka209("fd");	 //审核人
		asDTO.setBka210(new Date());	 //审核时间	
		asDTO.setAae100("1");	 //当前有效标志
		da.setFeeDTO(s);
		da.setAae016("1");
		
		s.add(asDTO);
		
		int i= med.saveAuditFeeDetailYL(da);
		System.out.println(i);
	}
	
}
