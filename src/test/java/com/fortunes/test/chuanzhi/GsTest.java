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
import com.powersi.dubbo.common.TranscodingValueInterface;
import com.powersi.dubbo.medicare.inter.ReimDeclareGSInterface;

public class GsTest extends DubboTest{
	@Autowired
	ReimDeclareGSInterface reimDeclareGSInterface;
	
	
	@Autowired
	TranscodingValueInterface trans;
	/*
	 * 个人累积（工伤）(通)
	 */
	
	public void testTotal(){
		mediSearchPersonDTO p = new mediSearchPersonDTO();
		p.setAac001("1000000004");
		p.setCurDate("201606");
		List l = reimDeclareGSInterface.queryPersonTotalInfo(p);
		out(l);
	}
	
	/*
	 * 取消就诊信息
	 */
	public void testCancleBiz(){
		mediReimDeclareDTO mdto=new mediReimDeclareDTO();
		mdto.setAae013("test");
		mdto.setAaz218("0000001611001201");
		mdto.setAaa027("441800");
		mdto.setAkb020("002001");
		mdto.setBae010("GSLB0020161103001");
		Map l = reimDeclareGSInterface.cancleBiz(mdto);
		out(l);
	}
	
	/*
	 * 取消业务场景信息
	 */
	public void testCancleDeclare(){
		mediReimDeclareDTO mdto=new mediReimDeclareDTO();
		mdto.setAae013("test");
		mdto.setAaa027("440000");
		mdto.setBae010("GSLB0020161103001");
		Map l = reimDeclareGSInterface.cancleDeclare(mdto);
		out(l);
	}
	/*
	 * 结算信息保存(通)
	 */
	
	public void testCalFee(){
		String bae010 = "GSLB0020161103001";
		Map<String,Object> reimd=reimDeclareGSInterface.calFee(bae010);
		out(reimd);
	}
	
	/*
	 * 费用试算(通)
	 */
	public void testFee(){
		String bae010 = "GSLB0020161103001";
		Map<String,Object> reimd=reimDeclareGSInterface.testFee(bae010);
		out(reimd);
	}
	
	/*
	 * 取消费用结算
	 */
	public void testCancleFee(){
		mediReimDeclareDTO mdto=new mediReimDeclareDTO();
		String bae010 = "GSLB0020161103001";
		mdto.setBae010(bae010);
		mdto.setAaa027("441800");
		Map<String,Object> reimd=reimDeclareGSInterface.cancelBizFinish(mdto);
		out(reimd);
	}
	
	/*
	 * 修改就诊信息（工伤）(通)
	 */
	public void testModifyBiz(){
		mediBizDTO m = new mediBizDTO();
		m.setDfbz("0");
		m.setDatam("74_x_73_x_77");
		m.setAaa027("440000");
		m.setAae013("");
		m.setAka130("41");
		m.setAab001("41305210");
		m.setAkb020("002001");
		m.setBka042("");
		m.setBka401("0");
		m.setBka940("");
		m.setBka006("410");
		m.setBka008("广州番禺万泰文具礼品盒有限公司");
		m.setBka409("广东省人民医院");
		m.setAaz218("0000001611001201");
		m.setBka408("0");
		m.setBka928("");
		m.setAae140("410");
		m.setAka120("M84.300");
		m.setAac001("1058732077");
		m.setAka121("应力性骨折");
		m.setAac003("陈丹");
		m.setBkc110("1");
		m.setBka030("1");
		m.setBka032("20161019");
		m.setBkc111("0");
		m.setBka017("20161019");
		m.setBka116("373272263");
		m.setBke958("0");
		m.setBka939("");
		m.setBilllist("[{\"bka418\":\"838\",\"bka116\":\"373272263\",\"bka416\":\"1\",\"bka404\":\"3\",\"aae019\":\"100\",\"aae013\":\"\"}]");
		Map<String, Object> mPara = new HashMap<String, Object>();
		mPara.put("biz", m);
		mPara.put("preakb020", "002001");
		Map<String, Object> re = reimDeclareGSInterface.saveModifyBizInfo(mPara);
		out(re);
	}
	
	/*
	 * 费用录入保存(通)
	 */
	
	public void testSaveFee(){
		mediBizDTO m = new mediBizDTO();
		m.setAae013("");
		m.setAka130("41");
		m.setAkb020("002001");
		m.setBka002("1");
		m.setBka006("410");
		m.setBka405("500");
		m.setBka409("广东省人民医院");
		m.setAaz218("0000001611001201");
		m.setAka120("M80940/6");
		m.setAka121("转移性基底鳞状细胞癌");
		m.setAaa027("440000");
		m.setBkc111("0");
		m.setBka116("373272263");
		m.setFeelist("%5B%7B%22serial_apply%22:%22%22,%22serial_fee%22:%220%22,%22hospital_id%22:%22002001%22,%22serial_no%22:%220000001611001201%22,%22ordinal_no%22:%221%22,%22recipe_no%22:%22%22,%22input_date%22:%222016-11-03%2015:28:37%22,%22input_man%22:%22%E7%B3%BB%E7%BB%9F%E7%AE%A1%E7%90%86%E5%91%98%22,%22input_staff%22:%22100%22,%22fee_date%22:%222016-10-19%2000:00:01%22,%22saveflag%22:%220%22,%22item_code%22:%22X-J07AH-A001-B001%22,%22item_name%22:%22A%E3%80%81C%E3%80%81Y%E3%80%81W135%E7%BE%A4%E8%84%91%E8%86%9C%E7%82%8E%E7%90%83%E8%8F%8C%E5%A4%9A%E7%B3%96%E7%96%AB%E8%8B%97%22,%22his_item_code%22:%22X-J07AH-A001-B001%22,%22his_item_name%22:%22A%E3%80%81C%E3%80%81Y%E3%80%81W135%E7%BE%A4%E8%84%91%E8%86%9C%E7%82%8E%E7%90%83%E8%8F%8C%E5%A4%9A%E7%B3%96%E7%96%AB%E8%8B%97%22,%22model%22:%22000%22,%22factory%22:%22%22,%22standard%22:%22%22,%22unit%22:%22%E5%85%83%22,%22price%22:%22100%22,%22dosage%22:%221%22,%22money%22:%22100%22,%22reduce_money%22:%220%22,%22usage_flag%22:%220%22,%22usage_days%22:%220%22,%22opp_serial_fee%22:%22%22,%22medi_item_type%22:%221%22,%22stat_type%22:%2202%22,%22staple_flag%22:%223%22,%22audit_flag%22:%22%22,%22self_scale%22:%221%22,%22fee_batch%22:%22%22%7D%5D");
		m.setBilllist("");
		m.setAaa027("441800");
		Map<String, Object> re = reimDeclareGSInterface.saveFee(m);
		out(re);
	}
	

	/*
	 * 个人就诊信息保存（通）
	 */
	public void testRD(){
		mediReimDeclareDTO mdto=new mediReimDeclareDTO();
		mdto.setBka414("1");
		mdto.setBka152("");
		mdto.setAaa027("440000");
		mdto.setBka098("陈丹");
		mdto.setAac007("2009-07-16");
		mdto.setBka099("123654987156");
		mdto.setAac006("1989-07-15");
		mdto.setBke850("2");
		mdto.setBizlist("[{\"bka401\":\"0\",\"bkc110\":\"1\",\"aka130\":\"41\",\"bka006\":\"410\",\"bka928\":\"\",\"bka408\":\"\",\"hospType1\":\"1\",\"hospType2\":\"2\",\"bka409\":\"广东省人民医院\",\"aaz107\":\"10374\",\"bka017\":\"20161019\",\"bka032\":\"20161019\",\"bka030\":\"1\",\"aka121\":\"转移性基底鳞状细胞癌\",\"bka404\":\"3\",\"bka403\":\"1\",\"bka405\":\"500.00\",\"dfbz\":\"0\",\"aae013\":\"\",\"akb020\":\"002001\",\"aka120\":\"M80940/6\",\"datam\":\"74_x_73_x_77\",\"bka939\":\"\",\"bka940\":\"\",\"iscp\":\"\",\"notaccepts\":\"\",\"bkc301s\":\"\",\"biznum\":\"0\"}]");
		mdto.setAab019("90");
		mdto.setAab069("广州番禺万泰文具礼品盒有限公司");
		mdto.setAab001("41305210");
		mdto.setBac004("15874273524");
		mdto.setBaa027("440404");
		mdto.setBka107("");
		mdto.setAlc020("201610");
		mdto.setBka008("广州番禺万泰文具礼品盒有限公司");
		mdto.setBka101("2016-11-03");
		mdto.setBka102("1");
		mdto.setBka103("500.00");
		mdto.setBka004("1");
		mdto.setBka104("3");
		mdto.setBka005("00");
		mdto.setBka086("");
		mdto.setBka042("147");
		mdto.setBka087("C");
		mdto.setBka088("");
		mdto.setBka089("");
		mdto.setBka085("1058732077");
		mdto.setAac004("女");
		mdto.setAac003("陈丹");
		mdto.setAac002("429006198907151845");
		mdto.setAac001("1058732077");
		mdto.setAae140("410");
		mdto.setBka109("");
		mdto.setAaa027("441800");
		mdto.setBilllist("[{\"fee_counts\":\"3\",\"fees\":\"500\",\"remark\":\"\",\"biznum\":\"0\"}]");
    	Map<String,Object> reimd=reimDeclareGSInterface.saveReimDeclare(mdto);
    	out(reimd);
	}
	
	
	/* * 获取码值信息*/
	@Test
	public void code(){
		List<Map<String,Object>> codes= trans.querySYSCode("AAC066");
		out(codes);
	}
}
