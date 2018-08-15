package com.fortunes.test.chuanzhi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.powersi.biz.medicare.medicareCoreBiz.dto.mediBizDTO;
import com.powersi.biz.medicare.medicareReimburse.dto.mediReimDeclareDTO;
import com.powersi.biz.medicare.medicareReimburse.dto.mediSearchPersonDTO;
import com.powersi.dubbo.medicare.inter.ReimDeclareSYInterface;

public class SyywTest extends DubboTest{
	@Autowired
	ReimDeclareSYInterface reimDeclareSyInterface;
	
	/*
	  * 个人累积(通)
	  */
	 public void testTotal(){
			mediSearchPersonDTO p = new mediSearchPersonDTO();
			p.setAac001("1000000004");
			p.setCurDate("201606");
			List l = reimDeclareSyInterface.queryPersonTotalInfo(p);
			out(l);
		}
		
	 /*
	  * 取消就诊信息（生育）(通)
	  */
		public void testCancleBiz(){
			mediReimDeclareDTO mdto=new mediReimDeclareDTO();
			mdto.setAae013("test");
			mdto.setAaz218("0000001611001199");
			mdto.setAkb020("0012");
			mdto.setBae010("SYLB0020161103003");
			mdto.setAaa027("441800");
			Map l = reimDeclareSyInterface.cancleBiz(mdto);
			out(l);
		}
		
	 	/*
	 	 * 取消业务场景信息(生育)(通)
	 	 */
	 @Test
		public void testCancleDeclare(){
			mediReimDeclareDTO mdto=new mediReimDeclareDTO();
			mdto.setAae013("test");
			mdto.setAae140("310");
			mdto.setBae010("SYLB0020161103003");
			mdto.setAaa027("441800");
			Map l = reimDeclareSyInterface.cancleDeclare(mdto);
			out(l);
		}
		
		/*
		 *结算信息保存 （通）
		 */
		public void calFee(){
			String bae010 = "SYLB0020161103001";
			Map<String,Object> reimd=reimDeclareSyInterface.calFee(bae010);
			out(reimd);
		}
		
		
		/*
		 * 取消结算信息(生育)(通)
		 */
		public void testCancleFee(){
			mediReimDeclareDTO mdto=new mediReimDeclareDTO();
			String bae010 = "SYLB0020161103001";
			mdto.setBae010(bae010);
			mdto.setAaa027("441800");
			Map<String,Object> reimd=reimDeclareSyInterface.cancelBizFinish(mdto);
			out(reimd);
		}

		
		/*
		 * 修改就诊信息(生育业务)(通)
		 */
		public void testModifyBiz(){
			mediBizDTO m = new mediBizDTO();
			m.setAae013("test");
			m.setAka130("51");
			m.setAab001("68068182");
			m.setAkb020("0012");
			m.setBka042("");
			m.setBka401("0");
			m.setBka940("");
			m.setBka006("511");
			m.setBka004("1");
			m.setBka008("广州白云山制药股份有限公司白云山何济公制药厂");
			m.setBka409("枣庄矿业（集团）有限责任公司枣庄医院");
			m.setAaz218("0000001611001195");
			m.setBka408("303");
			m.setBka928("");
			m.setAae140("510");
			m.setAka120("Z36.800");
			m.setAac001("1012459819");
			m.setAka121("特指产前筛查");
			m.setAac003("陈翠芬");
			m.setBkc110("3");
			m.setBka030("1");
			m.setBka032("20161030");
			m.setBkc111("1");
			m.setBka017("20161030");
			m.setBka116("373272257");
			m.setBke958("0");
			m.setBka939("");
			m.setDatam("111_x_52_x_44_x_46_x_48");
			//bka116
			//bka418
			m.setBilllist("[{\"bka418\":\"832\",\"bka116\":\"373272257\",\"bka416\":\"1\",\"bka404\":\"1\",\"aae019\":\"6000\",\"aae013\":\"\"}]");
			m.setDfbz("0");
			Map<String, Object> mPara = new HashMap<String, Object>();
			
			mPara.put("biz", m);
			mPara.put("preakb020", "0012");
			Map<String, Object> re = reimDeclareSyInterface.saveModifyBizInfo(mPara);
			out(re);
		}
		
		/*
		 * 费用录入（生育）(通)
		 */
		public void testSaveFee(){
			mediBizDTO m = new mediBizDTO();
			m.setAae013("test");
			m.setAka130("51");
			m.setAkb020("0012");
			m.setBka002("1");
			m.setBka006("511");
			m.setBka405("6000");
			m.setBka409("枣庄矿业（集团）有限责任公司枣庄医院");
			m.setAaz218("0000001611001195");
			m.setAka120("O28.900");
			m.setAka121("产前筛查异常");
			m.setAaa027("441800");
			m.setBkc111("1");
			m.setBka116("373272257");
			m.setBilllist("");
			m.setFeelist("%5B%7B%22serial_apply%22:%22%22,%22serial_fee%22:%220%22,%22hospital_id%22:%220012%22,%22serial_no%22:%220000001611001195%22,%22ordinal_no%22:%221%22,%22recipe_no%22:%22%22,%22input_date%22:%222016-11-02%2020:57:06%22,%22input_man%22:%22ysz%22,%22input_staff%22:%221030%22,%22fee_date%22:%222016-10-30%2000:00:01%22,%22saveflag%22:%220%22,%22item_code%22:%22311201023%22,%22item_name%22:%22%E4%BA%A7%E5%89%8D%E6%A3%80%E6%9F%A5%22,%22his_item_code%22:%22311201023%22,%22his_item_name%22:%22%E4%BA%A7%E5%89%8D%E6%A3%80%E6%9F%A5%22,%22model%22:%22%22,%22factory%22:%22%22,%22standard%22:%22%22,%22unit%22:%22%E5%85%83%22,%22price%22:%226000%22,%22dosage%22:%221%22,%22money%22:%226000%22,%22reduce_money%22:%220%22,%22usage_flag%22:%220%22,%22usage_days%22:%220%22,%22opp_serial_fee%22:%22%22,%22medi_item_type%22:%220%22,%22stat_type%22:%2206%22,%22staple_flag%22:%221%22,%22audit_flag%22:%22%22,%22self_scale%22:%220%22,%22fee_batch%22:%22%22%7D%5D");
			Map<String, Object> re = reimDeclareSyInterface.saveFee(m);
			out(re);
		}
		
		
		
		
		
	
		
		/*
		 * 生育业务个人就诊信息保存(通)
		 */
		public void testRD(){
			mediReimDeclareDTO mdto=new mediReimDeclareDTO();
			mdto.setBmc026("");
			mdto.setBka152("");
			mdto.setAaa027("441800");
			mdto.setAac007("2004-07-01");
			mdto.setAmc010("");
			mdto.setBlc014("undefined");
			mdto.setAab001("68068182");
			mdto.setBaa027("441802");
			mdto.setBka008("广州白云山制药股份有限公司白云山何济公制药厂");
			mdto.setBka004("1");
			mdto.setBka005("00");
			mdto.setBka086("");
			mdto.setBka042("58");
			mdto.setBka087("C");
			mdto.setBka088("");
			mdto.setBka089("");
			mdto.setBka085("1012459819");
			mdto.setBlc024("undefined");
			mdto.setBka414("1");
			mdto.setBka098("陈翠芬");
			mdto.setBka099("13412341234");
			mdto.setBke850("2");
			mdto.setAlc035("undefined");
			mdto.setAab019("10");
			mdto.setAab069("广州白云山制药股份有限公司白云山何济公制药厂");
			mdto.setBac004("13412341123");
			mdto.setBka107("");
			mdto.setAlc020("undefined");
			mdto.setBka102("1");
			mdto.setBka103("6000.00");
			mdto.setBka104("1");
			mdto.setAac004("女");
			mdto.setAac003("陈翠芬");
			mdto.setAac002("440107198310140649");
			mdto.setAac001("1012459819");
			mdto.setBka109("");
			mdto.setPoxb("");
			mdto.setBizlist("[{\"bka401\":\"0\",\"bkc110\":\"3\",\"aka130\":\"51\",\"bka006\":\"511\",\"bka928\":\"\",\"bka408\":\"303\",\"hospType1\":\"1\",\"hospType2\":\"2\",\"bka409\":\"枣庄矿业（集团）有限责任公司枣庄医院\",\"aaz107\":\"474695\",\"bka017\":\"20161030\",\"bka032\":\"20161030\",\"bka030\":\"1\",\"aka121\":\"产前筛查异常\",\"bka404\":\"1\",\"bka403\":\"1\",\"bka405\":\"6000.00\",\"aae013\":\"test\",\"akb020\":\"0012\",\"aka120\":\"O28.900\",\"datam\":\"111_x_52_x_44_x_46_x_48_x_\",\"bka939\":\"\",\"bka940\":\"\",\"iscp\":\"\",\"notaccepts\":\"\",\"bkc301s\":\"\",\"biznum\":\"0\",\"dfbz\":\"0\"}]");
			mdto.setBilllist("[{\"fee_counts\":\"1\",\"fees\":\"6000\",\"remark\":\"\",\"biznum\":\"0\"}]");
	
	    	Map<String,Object> reimd=reimDeclareSyInterface.saveReimDeclare(mdto);
	    	out(reimd);
		}
		
	
	
	
	
	
	
	
	
	 
	 
	 
	
}
