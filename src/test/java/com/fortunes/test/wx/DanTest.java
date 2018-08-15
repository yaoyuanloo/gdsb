package com.fortunes.test.wx;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.gtxt.dubbo.GtxtListResult;
import com.fortunes.test.DubboTest;
import com.insigma.dubbo.api.PersonnelArchiveService;
import com.insigma.dubbo.bean.PersonnelArchiveView;
import com.insigma.dubbo.bean.SimpleBeanParam;
import com.insigma.dubbo.bean.SimpleMapParam;
import com.insigma.dubbo.bean.SimpleResult;

public class DanTest extends DubboTest{
	
	@Autowired
    PersonnelArchiveService personnelArchives;
	
	/**
		 * 档案借阅public SimpleResult saveBorrowRecord(SimpleMapParam<Map<String,String>> mapParam) throws Exception;
		 * @param mapParam
		 * @return
		 * @throws Exception 
		 * 接口细则：1.  参数输入为Ma<String,Object>
			相应的key-value为页面的输入项。
			页面的ipnut都是可填写的，红色的表示必填；
			"aac002" ="身份证号:"	
			"aac003" ="姓名:"	
			"bec063" ="工作证号:"
			"aab004" ="单位名称:"
			"bee015" ="借档日期"
			"bec085" ="档案编号:"
			"bec089" ="档案名称:"
		 	  2.  输出为Json串：code：（0成功，1失败），message。
		 */
	@Test
	public void t1() throws Exception, ParseException{
		Map<String,String> maps=new HashMap<String, String>();
    	maps.put("aac002","43102119891229450");
    	maps.put("aac003","张三");
    	maps.put("bec063","0001");
    	maps.put("aab004","张三");
    	maps.put("bee015","1111111111111");
    	maps.put("curUsrName","admin");
    	maps.put("bec085","0023");
    	maps.put("bec089","测试");
    	System.out.println("时间："+maps.get("bee015"));
		SimpleMapParam<Map<String,String>>  map = new SimpleMapParam<Map<String,String>>(maps);
		SimpleResult sr  = personnelArchives.saveBorrowRecord(map);
		out(sr);
	}
	
	
	
	/*
	 * 接口名称：/**
	 * 档案查阅
	 * @param record
	 * @return
	 * @throws Exception 
	 * public SimpleResult saveReviewRecord(SimpleMapParam<Map<String,String>> mapParam) throws Exception;
			接口细则：1.  参数输入为Ma<String,Object>
			相应的key-value为页面的输入项。
			页面的ipnut都是可填写的，红色的表示必填；
			"aac002" ="身份证号:"	
			"aac003" ="姓名:"	
			"bec063" ="工作证号:"
			"aab004" ="单位名称:"
			"bee023" ="查阅日期"
			"bee024" ="查阅经办人"
			"bec085" ="档案编号:"
			"bec089" ="档案名称:"
	 	  2.  输出为Json串：code：（0成功，1失败），message。
	 */
	public void t2() throws Exception{
		Map<String,String> maps=new HashMap<String, String>();
    	maps.put("aac002","1");
    	maps.put("aac003","2");
    	maps.put("bec063","3");
    	maps.put("aab004","4");
    	maps.put("bee023","1111111111111");
    	maps.put("bee024","1");
    	maps.put("bec085","001");
    	maps.put("bec089","1");
		SimpleMapParam<Map<String,String>>  map = new SimpleMapParam<Map<String,String>>(maps);
		SimpleResult sr  = personnelArchives.saveReviewRecord(map);
		System.out.println(sr.getMessage());
	}
	
	/*
	 * 接口：/**
	 * 保存开具的档案证明
	 * @param params
	 * @return
	 * @throws Exception 
	 * public SimpleResult saveConfirmation(SimpleMapParam<Map<String,String>> mapParam) throws Exception;
		接口细则：1.  参数输入为Ma<String,Object>
		相应的key-value为页面的输入项。
		页面的ipnut都是可填写的，红色的表示必填；
		"aac002" ="身份证号:"	
		"aac003" ="姓名:"	
		"bec100" ="开具证明类型:"
			 	  2.  输出为Json串：code：（0成功，1失败），message.
	*/
	public void t3() throws Exception{
		Map<String,String> maps=new HashMap<String, String>();
		maps.put("aac002","1");
    	maps.put("aac003","1");
    	maps.put("bec100","1");
    	SimpleMapParam<Map<String,String>>  map = new SimpleMapParam<Map<String,String>>(maps);
    	SimpleResult sr = null;
		sr = personnelArchives.saveConfirmation(map);
		out(sr);
			
    	
	}
	
	
	/*
	 * 接口：/**
	 * 根据档案编号查询借阅记录
	 * @param archiveCode
	 * @return
	 * public GtxtListResult<Map<String,Object>> returnQueryByArchiveCode(String archiveCode);
		接口细则：1.  参数输入为String
		页面的ipnut只有档案编号是可以输入查询(onblur事件)，其他都是只读项，红色的表示必填；
		" bec085" ="档案编号"	
			 	  2.  输出为Json串：code：（0成功，1失败），message，value:
		"aac002" ="借阅人身份证号:"	
		"aac003" ="借阅人姓名:"	
		"bec063" ="借阅人工作证号:"
		"aab004" ="借阅人单位名称:"
		"bee015" ="借档日期"
		"bee018" ="借档经办人"
		"bec089" ="档案名称:"
		" bec095" ="借阅ID:"
	 */
	

	
	
	public void t4(){
    	GtxtListResult<Map<String, Object>> ras=personnelArchives.returnQueryByArchiveCode("201609270098");
     	out(ras);
	}
	
	
	
	
	
	/*
	 * 接口名称：/**
	 * 档案转入受理登记-根据档案类型查询所需资料
	 * @param archiveType
	 * public GtxtListResult<Map<String, Object>> transINqueryMateriarByArchiveType(String archiveType);
		接口细则：1.  参数输入为String
		页面的ipnut都是可填写的，红色的表示必填；
		" bec081" ="档案类别:"	
			 	  2.  输出为Json串：code：（0成功，1失败），message,
		value:
						  " aaa102" ="材料代码:"
		" aaa103" ="材料名称:"
			 * @return
	 */
	
	
	public void t5(){
		GtxtListResult<Map<String, Object>> gt=personnelArchives.transINqueryMateriarByArchiveType("1");
		out(gt);
		
	}
	
	
	/*
	 * 接口名称：/**
	 * 档案转入受理登记-保存受理登记记录
	 * @param params
	 * @return
	 * @throws Exception 
	 * public SimpleResult transINsavepre(SimpleMapParam<Map<String,String>> mapParam) throws Exception;
		接口细则：1.  参数输入为Ma<String,Object>
		相应的key-value为页面的输入项。
		页面的ipnut都是可填写的，红色的表示必填；
		
		" bec081" ="档案类别:"	
		"bec090" ="原档案编号:" 
		"aac003" ="姓名:" 
		"aac002" ="身份证号:" 
		"bec083" ="是否缺失材料:"
		"bee003" ="备注:"
		" aaa102" ="材料代码:"(选中的，值用逗号隔开)
			 	  2.  输出为Json串：code：（0成功，1失败），message.
	 */
	public void t6() throws Exception{
		Map<String,String> maps=new HashMap<String, String>();
    	maps.put("bec081","1");
    	maps.put("bec090","2");
    	maps.put("aac003","3");
    	maps.put("aac002","4");
    	maps.put("bec083","1");
    	maps.put("bee003","1");
    	maps.put("aaa102","1");
		SimpleMapParam<Map<String,String>>  map = new SimpleMapParam<Map<String,String>>(maps);
		SimpleResult sim=personnelArchives.transINsavepre(map);
		out(sim);
	}
	
	
	public void t7() throws Exception, ParseException{
		PersonnelArchiveView p=new PersonnelArchiveView();
		p.setAab004("1");
		p.setAab019("1");
		p.setAab020("1");
		p.setAab022("1");
		p.setAab130("1");
		p.setAac001(1l);
		p.setAac002("1");
		p.setAac003("1");
		p.setAac004("1");
		p.setAac005("1");
		p.setAac006(1l);
		p.setAac007(1l);
		p.setAac009("1");
		p.setAac010("1");
		p.setAac011("1");
		p.setAac017("1");
		p.setAac024("1");
		p.setAac058("1");
		p.setAac067("1");
		p.setAac147("1");
		p.setAac161("1");
		p.setAae005("1");
		p.setAae006("1");
		p.setAca111("1");
		p.setBeb003("1");
		p.setBeb004("1");
		p.setBeb005("1");
		p.setBeb006("1");
		p.setBec001("1");
		p.setBec063("1");
		p.setBec081("1");
		p.setBec085("1");
		p.setBec086("1");
		p.setBec087("1");
		p.setBec088("1");
		p.setBec089("1");
		p.setBec090("1");
		p.setBec091(org.apache.commons.lang3.time.DateUtils.parseDate("2016-10-30","yyyy-MM-dd"));
		p.setBec092("1");
		p.setBec093("1");
		p.setBec094(org.apache.commons.lang3.time.DateUtils.parseDate("2016-10-30","yyyy-MM-dd"));
		p.setBec101(1l);
		p.setBec300("1");
		p.setBec301("1");
		p.setBee011("1");
		p.setBee013("1");
    	SimpleBeanParam<PersonnelArchiveView> o=new SimpleBeanParam<PersonnelArchiveView>();
    	o.setT(p);
		SimpleResult sim=personnelArchives.transINregister(o);
		out(sim);
	}
}
