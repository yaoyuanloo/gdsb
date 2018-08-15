package com.fortunes.test.chuanzhi;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.powersi.biz.medicare.mediAudit.dto.KCE6DTO;
import com.powersi.biz.medicare.medicareCommbiz.dto.DiseaseDirDTO;
import com.powersi.biz.medicare.medicareCommbiz.dto.HospOutDTO;
import com.powersi.biz.medicare.medicareCommbiz.dto.MedInstDepManDTO;
import com.powersi.biz.medicare.medicareCoreBiz.dto.mediBizDTO;
import com.powersi.biz.medicare.medicareReimburse.dto.mediReimCardDTO;
import com.powersi.biz.medicare.medicareReimburse.dto.mediReimDeclareDTO;
import com.powersi.biz.medicare.medicareReimburse.dto.mediSearchPersonDTO;
import com.powersi.dubbo.common.TranscodingValueInterface;
import com.powersi.dubbo.entity.DTO.EnpersonDTO;
import com.powersi.dubbo.entity.inter.EnHospital;
import com.powersi.dubbo.entity.inter.Enperson;
import com.powersi.dubbo.medicare.auditFee.MedicalAuditInterface;
import com.powersi.dubbo.medicare.dto.AuditDTO;
import com.powersi.dubbo.medicare.dto.MedicalFeeDTO;
import com.powersi.dubbo.medicare.inter.ReimDeclareGSInterface;
import com.powersi.dubbo.medicare.inter.ReimDeclareInterface;
import com.powersi.dubbo.medicare.inter.ReimDeclareSYInterface;

public class SicknessTest extends DubboTest{
	
	
	@Autowired
	EnHospital enHospital;
	
	@Autowired
	Enperson enperson;
	
	
	@Autowired
	ReimDeclareInterface reimDeclareInterface;
	
	
	@Autowired
	MedicalAuditInterface medicalAuditInterface;
	
	
	
	
	
	@Autowired
	TranscodingValueInterface trans;
	
	

	

	/*获取疾病信息（创智）（已通）
	 * 借口名称：queMedOrgInfo
	 * 入参1	AKA020	VARCHAR2(20)	拼音助记码
		  2	AKA021	VARCHAR2(20)	五笔助记码
		  3	AKA035	VARCHAR2(3)	病种类别
		  4	AKA120	VARCHAR2(50)	疾病编码
		  5	AKA121	VARCHAR2(300)	疾病名称
          6	AKA122	VARCHAR2(1)	疾病分类
          
          出参：List<Map<String,Object>>
        AAZ164	NUMBER(16)	病种ID
		AKA120	VARCHAR2(50)	疾病编码
		AKA121	VARCHAR2(300)	疾病名称
		AKA122	VARCHAR2(1)	疾病分类
		AAZ149	NUMBER(16)	特殊病种ID
	 * 
	 */
    public void t1(){
    	DiseaseDirDTO DDT=new DiseaseDirDTO();
    	List<Map<String,Object>> list= enHospital.queMedOrgInfo(DDT);
    	System.out.println(list.size());
    	
    }
    
    
    /* 获取人员基金状态(已通)
	 * 借口名称：getPersonTreatmentInfo
	 * 入参：
	 *  1	AAC001	NUMBER(22)	个人电脑号
		2	AAE140	VARCHAR2(3)	待遇类型(1:个账注资；2：医保待遇；3：工伤待遇；4：生育待遇)
	      出参:
			 返回值：String（备注：0：无特殊待遇情形；1：待遇冻结；2：待遇开绿色通道；3：其他）
	 * 创智
	 */
    public void t2(){
    	EnpersonDTO edto=new EnpersonDTO();
    	edto.setAac001("1001292255");
    	edto.setAae140("2");
    	edto.setBka017("2012-10-10");
    	edto.setBka032("2013-10-10");
    	String	pt=enperson.getPersonTreatmentInfo(edto);
    	System.out.println("pt"+pt);
    	
    }
    
   
    
    
    /* 费用试算 （已通）
   	 * 借口名称：testFee
   	 * 入参： String bae010 //业务受理号
   	 * 出参: key	value	注释
			error	0	试算成功
					1	试算失败
			message	String	错误信息（如果试算成功则没有这个键值对）
			payinfo	List<Map<String, Object>>	计算结果（如果试算失败则没有这个键值对）
   	 * 创智
   	 */
     public void t4(){
    	 Map<String, Object> m=reimDeclareInterface.testFee("SYLB0020161103001");
    	 out(m);       	
     }
     
     
     /* 
      *  获取医院基本信息(本地)(已通)
    	 * 借口名称：queDepInfo
    	 * 
    	 * 入参：1	AKB020	VARCHAR2(20)	医院编号
				2	AAB069	VARCHAR2(100)	医疗机构名称
				3	AKB022	VARCHAR2(10)	医疗服务机构类型
				4	AKB023	VARCHAR2(2)	定点医疗机构类别
				5	BKC110	VARCHAR2(1)	医院级别（1、三级；3、二级；5、一级；9、无）
				6	AAZ267	NUMBER(22)	医疗待遇申请事件ID
				7	AMA011	VARCHAR2(1)	生育使用标志
				8	BKE996	VARCHAR2(1)	是否为延伸服务网点
			出参：
			1	aaz269	NUMBER(20)	医疗机构及药店ID
			2	aab003	VARCHAR2(20)	组织机构代码
			3	aaz107	NUMBER(20)	定点医疗机构ID
			4	aaz001	NUMBER(20)	组织ID
			5	aab069	VARCHAR2(100)	组织机构名称
			6	aka020	VARCHAR2(20)	拼音助记码
			7	aka021	VARCHAR2(20)	五笔助记码
			8	akb020	VARCHAR2(20)	医院编号
			9	akb023	VARCHAR2(2)	定点医疗机构类别
			10	bkc110	VARCHAR2(1)	医院级别（1、三级；3、二级；5、一级；9、无）
    	 * 创智
    	 */
      public void t3(){
     	MedInstDepManDTO mt=new MedInstDepManDTO();
     	mt.setAkb020("002001");
     	List<Map<String,Object>> list=enHospital.queDepInfo(mt);
        out(list);
        	
      }
     
     
     /*个人就诊信息保存（已通）创智
    	 * 借口名称：saveReimDeclare
    	 * 入参：1	aaa027	VARCHAR2(6)	统筹区编码
				2	bae010	VARCHAR2(20)	业务受理号
				3	aab001	NUMBER(10)	单位电脑号
				4	aab019	VARCHAR2(3)	单位类型代码
				5	aac001	NUMBER(20)	个人电脑号
				6	aac002	VARCHAR2(25)	公民身份号码
				7	aac003	VARCHAR2(20)	姓名
				8	aac004	VARCHAR2(1)	性别
				9	aac006	DATE	出生日期
				10	aac007	DATE	参加工作日期
				11	aae004	VARCHAR2(50)	联系人姓名
				12	aae006	VARCHAR2(80)	联系地址
				13	aae007	VARCHAR2(6)	邮政编码
				14	aae140	VARCHAR2(3)	所属险种
				15	aaz003	VARCHAR2(30)	账号
				16	amc010	VARCHAR2(50)	配偶姓名
				17	baa027	VARCHAR2(10)	当事人所在统筹区
				18	baa027	VARCHAR2(10)	当事人所在统筹区
				19	bac004	VARCHAR2(50)	联系人手机
				20	billlist	　List<<Map<String,Object>>	　单据信息（参数详见1.2.1.4.2）
				21	bizlist	　List<<Map<String,Object>>	　就诊业务信息（参数详见1.2.1.4.1）
				22	bka004	VARCHAR2(3)	人员类别
				23	bka005	VARCHAR2(3)	公务员级别
				24	bka008	VARCHAR2(200)	单位名称
				25	bka042	NUMBER(12)	对应的工伤生育业务号
				26	bka085	VARCHAR2(20)	申报对象编码
				27	bka086	VARCHAR2(100)	申报对象名称
				28	bka087	VARCHAR2(1)	拨付对象类型(H:医院 P:个人 C:单位)
				29	bka088	VARCHAR2(20)	拨付对象编码(当pka087为H时Hospital_ID,P时Indi_ID,C时Corp_ID)
				30	bka089	VARCHAR2(100)	拨付对象名称
				31	bka098	VARCHAR2(50)	申报人
				32	bka099	VARCHAR2(30)	联系电话
				33	bka101	DATE	经办日期
				34	bka102	NUMBER(8)	受理总人次
				35	bka103	NUMBER(12,2)	受理费用金额
				36	bka104	NUMBER(4)	受理单据数
				37	bka107	VARCHAR2(50)	受理人
				38	bka109	VARCHAR2(2)	处理状态标志
				39	bka149	VARCHAR2(3)	零报卡种类(
				40	bka152	NUMBER(16)	拨付账户ID
				41	bka414	VARCHAR2(2)	补充人员类别
				42	bka431	VARCHAR2(200)	不受理原因
				43	bke850	VARCHAR2(1)	零报账户来源
				44	bmc026	VARCHAR2(20)	配偶身份证号码
				
				
				1.2.4.6.1就诊信息（BizList）
				序号	字段名称	数据类型	注释
				1	aae013	VARCHAR2(100)	说明或者备注
				2	aaz107	NUMBER(20)	定点医疗机构ID
				3	aka120	VARCHAR2(20)	疾病编码(中心)
				4	aka121	VARCHAR2(300)	疾病名称
				5	aka130	VARCHAR2(6)	业务类别编号
				6	akb020	VARCHAR2(20)	医院编号
				7	bka006	VARCHAR2(6)	待遇类型
				8	bka016	VARCHAR2(1)	登记标志(0：正常 1：转院 2：二次返院（审批通过后RELA_SERIAL_NO为空） 3：急诊留观转住院 4：90天或180天结算)
				9	bka017	DATE	业务开始时间
				10	bka030	NUMBER(12)	住院天数
				11	bka032	DATE	业务结束日期
				12	bka401	CHAR(1)	0-普通零报 1- 手工零报
				13	bka403	NUMBER(4)	费用明细数
				14	bka404	NUMBER(4)	单据数
				15	bka405	NUMBER(10,2)	总金额
				16	bka408	VARCHAR2(100)	受理原因（对应码表bka408）
				17	bka409	VARCHAR2(100)	医院名称
				18	bka928	CHAR(1)	是否异地就医备案 0否 1是
				19	bka939	VARCHAR2(500)	呈批原因
				20	bka940	VARCHAR2(200)	呈批受理人意见
				21	bkc110	VARCHAR2(1)	医院级别
				
				1.2.4.6.2单据信息（BillList）
				序号	字段名称	数据类型	注释
				1	aae019	NUMBER(12,4)	金额
				2	bka404	NUMBER(4)	单据数
				3	aae013	VARCHAR2(100)	说明或者备注
				
				出参:（Map）：
					参数1：
					键：error	值：0，成功；1，失败。
					参数2：
					键：data		值：成功则返回受理号，失败则返回错误信息
    	 * 
    	 */
      @Test
      public void t5(){
        	mediReimDeclareDTO mdto=new mediReimDeclareDTO();
        	mdto.setAaa027("440104");
        	mdto.setAab001("53131219");
        	mdto.setAab019("90");
        	mdto.setAac001("1011740978");
        	mdto.setAac002("440105195909085000");
        	mdto.setAac003("林月妹");
        	mdto.setAac004("女");
        	mdto.setAac007("28825");
        	mdto.setAae004("林月妹");
        	mdto.setAae006("鹤鸣七巷22号201房");
        	mdto.setAae007("510235");
        	mdto.setAae100("1");
        	mdto.setAae140("310");
        	mdto.setBaa027("440105");
        	mdto.setBac004("15874273524");
        	mdto.setBae010("CZLB0020161027004");
        	mdto.setBka004("2");
        	mdto.setBka005("0");
        	mdto.setBka008("广州市海珠区退休职工管理委员会办公室");
        	mdto.setBka042("");
        	mdto.setBka083("10");
        	mdto.setBka084("P");
        	mdto.setBka085("1011740978");
        	mdto.setBka086("林月妹");
        	mdto.setBka087("P");
        	mdto.setBka088("1011740978");
        	mdto.setBka089("林月妹");
        	mdto.setBka098("林月妹");
        	mdto.setBka099("34370867、1360282325");
        	mdto.setBka101("20161027");
        	mdto.setBka102("1");
        	mdto.setBka103("60000");
        	mdto.setBka104("1");
        	mdto.setBka106("ysz123");
        	mdto.setBka107("ysz123");
        	mdto.setBka108("20161027");
        	mdto.setBka109("02");
        	mdto.setBka152("106963106");
        	mdto.setBka414("1");
        	mdto.setBka431("");
        	mdto.setBke850("1");
        	
        	
        	//"[{\"fee_counts\":\"1\",\"fees\":\"60000\",\"remark\":\"\",\"biznum\":\"0\"}]"
        	mdto.setBilllist("[{\"fee_counts\":\"1\",\"fees\":\"60000\",\"remark\":\"\",\"biznum\":\"0\"}]");
        	//[{\"bka401\":\"0\",\"bkc110\":\"1\",\"aka130\":\"12\",\"bka006\":\"120\",\"bka928\":\"\",\"bka016\":\"\",\"hospType1\":\"1\",\"hospType2\":\"2\",\"bka409\":\"广东省人民医院\",\"aaz107\":\"10374\",\"bka017\":\"20160926\",\"bka032\":\"20161011\",\"bka030\":\"15\",\"aka121\":\"良性或恶性未肯定瘤细胞\",\"bka404\":\"1\",\"bka403\":\"1\",\"bka405\":\"60000.00\",\"bka408\":\" '198'\",\"yy1\":\"待遇出错（起付线、比例或目录）\",\"yy2\":\"\",\"yy3\":\"\",\"yy4\":\"\",\"yy5\":\"\",\"aae013\":\"\",\"akb020\":\"002001\",\"aka120\":\"M80010/1\",\"datam\":\"135_x_138_x_141_x_162_x_8_x_\",\"bka939\":\"\",\"bka940\":\"\",\"iscp\":\"\",\"notaccepts\":\"\",\"bkc301s\":\"待遇出错（起付线、比例或目录）\",\"biznum\":\"0\",\"dfbz\":\"0\"}]"
        	mdto.setBizlist("[{\"bka401\":\"0\",\"aae140\":\"310\",\"bka014\":\"111\",\"bka037\":\"\",\"bka004\":\"2\",\"bkc110\":\"1\",\"aka130\":\"12\",\"bka006\":\"120\",\"bka928\":\"\",\"bka016\":\"\",\"hospType1\":\"1\",\"hospType2\":\"2\",\"bka409\":\"广东省人民医院\",\"aaz107\":\"10374\",\"bka017\":\"20160926\",\"bka032\":\"20161011\",\"bka030\":\"15\",\"aka121\":\"良性或恶性未肯定瘤细胞\",\"bka404\":\"1\",\"bka403\":\"1\",\"bka405\":\"60000.00\",\"bka408\":\"'198'\",\"yy1\":\"待遇出错（起付线、比例或目录）\",\"yy2\":\"\",\"yy3\":\"\",\"yy4\":\"\",\"yy5\":\"\",\"aae013\":\"\",\"akb020\":\"002001\",\"aka120\":\"M80010/1\",\"datam\":\"135_x_138_x_141_x_162_x_8_x_\",\"bka939\":\"\",\"bka940\":\"\",\"iscp\":\"\",\"notaccepts\":\"\",\"bkc301s\":\"待遇出错（起付线、比例或目录）\",\"biznum\":\"0\",\"dfbz\":\"0\"}]");
        	
        	
        	/*JSONObject  myJson = JSONObject.fromObject(mdto.getBizlist());
        	
        	JSONObject  bilJson = JSONObject.fromObject(mdto.getBilllist());
        	Map<String,Object> m = myJson; 
        	Map<String,Object> b = bilJson; 
        	
        	
        	
        	List<Map<String,Object>> lp=new ArrayList<Map<String,Object>>();
        	lp.add(m);
        	
        	List<Map<String,Object>> bp=new ArrayList<Map<String,Object>>();
        	bp.add(b);*/
        	
        	Map<String,Object> reimd=reimDeclareInterface.saveReimDeclare(mdto);
        	if("1".equals(reimd.get("issuccess"))){
        		System.out.println("电脑号:"+reimd.get("data"));
        	}
        	
      }
      
 	 /*
 	  * 参保人拨付账户信息审核（已通）auditReimCardInfo
 	  * 入参：
 	  * 1	aae016	VARCHAR2(1)	审核状态。0:未审核；1:审核通过；2:审核不通过
		2	JsonStr		审核list串。（参数详见下面JsonStr）
		
		1.2.4.25.1审核list串（JsonStr）
		序号	字段名称	数据类型	注释
		1	BKA152	NUMBER(16)	拨付账户ID
		2	AAZ003	VARCHAR2(30)	账号
		3	BKA151	VARCHAR2(1)	账户使用类别（1：默认账户，2：临时账户）
		4	AAE007	VARCHAR2(6)	邮政编码
		5	AAE006	VARCHAR2(80)	联系地址
		6	AAE005	VARCHAR2(30)	联系电话
		7	AAE004	VARCHAR2(50)	联系人姓名
		8	AAB069	VARCHAR2(100)	组织机构名称
		9	AAE013	VARCHAR2(100)	说明或者备注
		10	AAE011	VARCHAR2(10)	经办人
		11	AAE036	DATE	经办时间
			AAE016	VARCHAR2(2)	复核标记
		12	aae016_name	VARCHAR2(100)	复核标志（0录入，1复审）
		13	bke957_name	VARCHAR2(100)	维护原因。（1：已终止参保并注销医疗保险凭证，需拨付到本人其它银行账户，2：参保人已死亡，并注销医疗保险凭证，需拨付到继承人指定银行账户，3：单位已垫付医疗费用，需拨付到单位银行账户，4：参保人已自行垫付医疗费，5：单位无对公账号，改拨单位法人个人账户，6：其他）
		14	AAZ065	NUMBER(20)	银行ID
		15	BKA148	VARCHAR2(1)	零报卡是否使用标志
		16	AAE016	VARCHAR2(2)	复核标记
		
	出参定义（Map）：
			参数1：
			键：issuccess   值：1，成功；0，失败。
			参数2：
			键：errMes     值：具体错误原因，如果没有错误信息，返回“操作成功”。
 	  */
     public void t6(){
 		mediReimCardDTO mrcdto = new mediReimCardDTO();
    	Map<String,Object> inMap = new HashMap<String,Object>();
    	inMap.put("aab069", "刘嘉喜");
    	inMap.put("aaz065", "广州银行");
    	inMap.put("aaz003", "123");	
    	inMap.put("bka151", "临时账户");
    	inMap.put("bka148", "未复核");
    	inMap.put("aae004", "刘嘉喜");
    	inMap.put("aae005", "13367339716");
    	inMap.put("aae006", "123");
    	inMap.put("aae007", "412302");
    	inMap.put("aae013", "");
    	inMap.put("aae011", "zzh1");
    	inMap.put("aae036", "2016-10-27");
    	inMap.put("aae016_name", "已制单");
    	inMap.put("bke957_name", "参保人已自行垫付医疗费");
    	inMap.put("aae016", "0");
    	inMap.put("bka152", "37");
    	List lstFee = new ArrayList();
    	lstFee.add(inMap);
    	mrcdto.setJsonStr(lstFee);
    	mrcdto.setAae016("1");
    	Map<String,Object> m=medicalAuditInterface.auditReimCardInfo(mrcdto);
    	out(m);

     }
     
     
     /*
      * 获取生育认定信息（已通）getMaternityInf
      * 入参：1	AAC001	NUMBER(22) 	个人电脑号
      * 出参：返回值：List<Map<String,Object>>
			包含数据项：
			序号	字段名称	数据类型	注释
			1	serial_mn	NUMBER(16)	生育待遇资格认定ID
			2	born_date	NUMBER(8)	预产期
			3	admit_hosp_id	VARCHAR2(20) 	医疗机构编号
			4	hos_name	VARCHAR2(100)	组织机构名称
			5	amc010	VARCHAR2(50) 	配偶姓名
			6	bmc011	VARCHAR2(20)	配偶身份证号码
			7	bmc012	ARCHAR2(50)	配偶工作单位/住址
			8	audit_date	NUMBER(8)	申请日期
			9	mn_begin_date	NUMBER(8)	医疗生效时间
			10	mn_end_date	NUMBER(8)	医疗失效时间
			11	bmc004	NUMBER(20)	申请生育门诊定点医疗机构
			12	back_hosp_id	NUMBER(20)	申请生育住院定点医疗机构
			13	aac001	NUMBER(20)	人员ID
			14	aaz107	NUMBER(20)	定点医疗机构ID
			15	akb020	NUMBER(20)	医疗机构编号
      * 
      */
    
     public void t7(){
    	 EnpersonDTO edto=new EnpersonDTO();
     	 edto.setAac001("1000107200");
    	 List<Map<String,Object>> hp=enperson.getMaternityInf(edto);
    	 System.out.println("hpL:"+hp.size());
    	 
     }
    
   
     /* 获取工伤认定信息（已通）
 	 * 借口名称：getInjuryInf
 	 * 创智
 	 * 入参：1	AAC001	NUMBER(22) 	个人电脑号
 	 * 出参：1	injury_medic_cert	VARCHAR2(20)	认定书编号
			2	injury_part	VARCHAR2(3) 	伤害部位
			3	injury_degree_code	VARCHAR2(1) 	伤害程度
			4	disease_name	VARCHAR2(2000) 	伤残病种名称
			5	begin_date	NUMBER(8) 	医疗终结期开始时间
			6	end_date	NUMBER(8)	医疗终结期结束时间
			7	indi_id	NUMBER(20)	个人电脑号
			8	serial_wi	NUMBER(16)	工伤认定信息ID
 	 */
     public void t8(){
     	EnpersonDTO edto=new EnpersonDTO();
     	edto.setAac001("1001292255");
     	List<Map<String,Object>> lp=enperson.getInjuryInf(edto);
     	System.out.println("lp"+lp.size());
     	
     }
     
     
     /* 1.2.2.8结算信息保存（已通） 创智
    	 * 借口名称：calFee
    	 *入参 ：String bae010 //业务受理号
    	 *出参：key	value	注释
				error	0	计算成功
					1	计算失败
				message	String	错误信息（如果计算成功则没有这个键值对）
				payinfo	List<Map<String, Object>>	计算结果（如果计算失败则没有这个键值对）
    	 *
    	 */
     
      public void t9(){
     	 Map<String, Object> m=reimDeclareInterface.calFee("CZLB0020161020001");
     	 System.out.println("1111111111:"+m.get("issuccess"));
     	 out(m);
        	
      }
      
      
    /* 费用录入保存 （通）
  	 * 借口名称：saveFee
  	 * 创智
  	 * 入参： 1	AKB020	VARCHAR2(20)	医院编号
			2	bae010	VARCHAR2(20)	业务受理号
			3	AAZ218	VARCHAR2(20)	业务序列号
			4	AAZ213	NUMBER(12)	费用序列号
			5	AKA063	VARCHAR2(6)	统计类别
			6	AKE003	VARCHAR2(1)	项目药品类型(0:项目，1：西药，2：中成药，3：中草药)
			7	AKE001	VARCHAR2(20)	中心药品项目编码
			8	AKE002	VARCHAR2(100)	中心药品项目名称
			9	AKE005	VARCHAR2(20)	医院药品项目编码
			10	AKE006	VARCHAR2(100)	医院药品项目名称
			11	AAZ267	NUMBER(12)	申请序列号
			12	BKA051	VARCHAR2(20)	费用发生时间（YYYY-MM-DD HH24:MI:SS）
			13	BKA052	VARCHAR2(30)	剂型
			14	BKA053	VARCHAR2(50)	厂家
			15	BKA054	VARCHAR2(300)	规格
			16	BKA055	VARCHAR2(20)	计量单位
			17	BKA056	NUMBER(10,4)	单价
			18	BKA057	NUMBER(12,4)	用量
			19	BKA058	NUMBER(12,4)	金额
			20	BKA059	NUMBER(12,4)	冲减金额（主要为计算方便使用）
			21	BKA060	VARCHAR2(1)	使用标志（1：出院带药 2：抢救用药 3：急诊）
			22	BKA061	NUMBER(12)	出院带药天数
			23	BKA062	NUMBER(12)	对应费用序列号
			24	BKA063	VARCHAR2(20)	录入人工号
			25	BKA064	VARCHAR2(50)	录入人
			26	BKA065	VARCHAR2(20)	录入时间（YYYY-MM-DD HH24:MI:SS）
			27	BKA066	VARCHAR2(1)	计算标志
			28	BKA067	VARCHAR2(1)	费用冻结标志，用来表识参保人所在单位的基本医疗保险被冻结期间录入的费用。0：未冻结；1：已冻结；2：冻结已处理
			29	BKA068	NUMBER(12)	对应冻结的费用序列号
			30	BKA069	VARCHAR2(20)	费用上传时间（YYYY-MM-DD HH24:MI:SS）
			31	BKA070	VARCHAR2(20)	处方号
			32	BKA071	VARCHAR2(20)	对应医院费用号
			33	BKA072	VARCHAR2(20)	处方医院编号
			34	BKA073	VARCHAR2(50)	处方医院名称
			35	BKA074	VARCHAR2(20)	处方医生编号
			36	BKA075	VARCHAR2(50)	处方医生姓名
			37	BKA076	VARCHAR2(1)	审核标志
			38	BKA511	VARCHAR2(20)	城镇职工先自付比例
			39	BKA512	VARCHAR2(20)	城乡居民先自付比例
		出参：
		出参定义（Map）：
		参数1：
		键：error	值：0，成功；1，失败。
		参数2：
		键：data		值：具体错误原因，如果没有错误信息，返回“操作成功”。
  	 */
    public void t10(){
		mediBizDTO m = new mediBizDTO();
		m.setBkc111("0");
		m.setBka002("1");
		m.setAka130("12");
		m.setBka006("120");
		m.setBka116("373272177");
		m.setAkb020("002001");
		m.setBka405("6000");
		m.setAaa027("441800");
		m.setAaz218("0000001610001130");
		/*
		 * 费用列表数据
		 */
		m.setFeelist("%5B%7B%22serial_apply%22:%22%22,%22serial_fee%22:%220%22,%22hospital_id%22:%22002001%22,%22serial_no%22:%220000001610001130%22,%22ordinal_no%22:%221%22,%22recipe_no%22:%22%22,%22input_date%22:%222016-10-31%2011:04:32%22,%22input_man%22:%22ysz%22,%22input_staff%22:%221034%22,%22fee_date%22:%222016-10-05%2000:00:01%22,%22saveflag%22:%220%22,%22item_code%22:%22250501005%22,%22item_name%22:%22%E9%BA%BB%E9%A3%8E%E8%8F%8C%E9%95%9C%E6%A3%80%22,%22his_item_code%22:%22250501005%22,%22his_item_name%22:%22%E9%BA%BB%E9%A3%8E%E8%8F%8C%E9%95%9C%E6%A3%80%22,%22model%22:%22%22,%22factory%22:%22%22,%22standard%22:%22%22,%22unit%22:%22%E5%85%83%22,%22price%22:%223000%22,%22dosage%22:%2210%22,%22money%22:%2230000%22,%22reduce_money%22:%220%22,%22usage_flag%22:%220%22,%22usage_days%22:%220%22,%22opp_serial_fee%22:%22%22,%22medi_item_type%22:%220%22,%22stat_type%22:%2210%22,%22staple_flag%22:%221%22,%22audit_flag%22:%22%22,%22self_scale%22:%22%22,%22fee_batch%22:%22%22%7D,%7B%22serial_apply%22:%22%22,%22serial_fee%22:%220%22,%22hospital_id%22:%22002001%22,%22serial_no%22:%220000001610001130%22,%22ordinal_no%22:%221%22,%22recipe_no%22:%22%22,%22input_date%22:%222016-10-31%2011:04:50%22,%22input_man%22:%22ysz%22,%22input_staff%22:%221034%22,%22fee_date%22:%222016-10-05%2000:00:01%22,%22saveflag%22:%220%22,%22item_code%22:%22120100005%22,%22item_name%22:%22%E2%85%A2%E7%BA%A7%E6%8A%A4%E7%90%86%22,%22his_item_code%22:%22120100005%22,%22his_item_name%22:%22%E2%85%A2%E7%BA%A7%E6%8A%A4%E7%90%86%22,%22model%22:%22%22,%22factory%22:%22%22,%22standard%22:%22%22,%22unit%22:%22%E5%85%83%22,%22price%22:%22300%22,%22dosage%22:%22100%22,%22money%22:%2230000%22,%22reduce_money%22:%220%22,%22usage_flag%22:%220%22,%22usage_days%22:%220%22,%22opp_serial_fee%22:%22%22,%22medi_item_type%22:%220%22,%22stat_type%22:%2213%22,%22staple_flag%22:%221%22,%22audit_flag%22:%22%22,%22self_scale%22:%220%22,%22fee_batch%22:%22%22%7D%5D");
		m.setAka120("M80010/1");
		m.setBka409("广东省人民医院");
		m.setAka121("良性或恶性未肯定瘤细胞");
//		Map<String, Object> re = reimDeclareInterface.saveFee(m);
//		out(re);
    }
    
    
    
    /* 取消业务场景信息
	 * 借口名称：cancleDeclare
	 * 创智
	 * 入参：  1	bae010	VARCHAR2(22)	业务受理号
			2	akb020	VARCHAR2(20)	医院编号
			3	aaz218	VARCHAR2(20)	业务序列号
			4	aae140	VARCHAR2(3)	险种
			5	bka116	NUMBER(12)	登帐号
		出参：
		出参：（Map）：
		参数1：
		键：issuccess	值：1，成功；0，失败。
		参数2：
		键：errMes     值：具体错误原因。
	 */
    
	 public void t11(){
		mediReimDeclareDTO mdto=new mediReimDeclareDTO();
		mdto.setAae013("test");
		mdto.setAae140("310");
		mdto.setBae010("CZLB0020161028014");
		mdto.setAaa027("441800");
		mdto.setBaa027("441800");
		Map map = reimDeclareInterface.cancleDeclare(mdto);
		out(map);
		
	 }
	 
	 /*
	  * 获取医院基本信息(异地)(已通)。接口名称:queHospOutInfo
	  * 入参：（HospOutDTO）,具体：
				序号	字段名称	数据类型	注释
				1	AKB020	VARCHAR2(20)	医院编号
				2	AAB069	VARCHAR2(100)	医疗机构名称
				3	BAF305	VARCHAR2(20)	所属省
				4	BAF306	VARCHAR2(20)	所属市
				5	BAF307	VARCHAR2(20)	所属区
				6	BKC122	VARCHAR2(1)	异地类型
				7	AAA027	VARCHAR2(6)	统筹区编码
				8	AKB022	VARCHAR2(10)	医疗服务机构类型
				9	AKB023	VARCHAR2(2)	定点医疗机构类别
				10	BKC110	VARCHAR2(1)	医院级别（1、三级；3、二级；5、一级；9、无）
				11	AAE016	VARCHAR2(1)	复核标志（0录入，1复审）
				12	AAE011	VARCHAR2(20)	经办人
		出参：1	aaz269	NUMBER(20)	医疗机构及药店ID
			2	aab003	VARCHAR2(20)	组织机构代码
			3	aaz107	NUMBER(20)	定点医疗机构ID
			4	aaz001	NUMBER(20)	组织ID
			5	aab069	VARCHAR2(100)	组织机构名称
			6	aka020	VARCHAR2(20)	拼音助记码
			7	aka021	VARCHAR2(20)	五笔助记码
			8	akb020	VARCHAR2(20)	医院编号
			9	akb023	VARCHAR2(2)	定点医疗机构类别
			10	bkc110	VARCHAR2(1)	医院级别（1、三级；3、二级；5、一级；9、无）
			11	aka101	VARCHAR2(2)	医院等级(甲、乙、丙)
			12	aae004	VARCHAR2(50)	联系人姓名
			13	aae005	VARCHAR2(200)	联系电话
			14	aae006	VARCHAR2(100)	VARCHAR2(100)
			15	aab013	VARCHAR2(50)	法定代表人姓名
			16	aae007	VARCHAR2(6)	邮政编码
			17	bkc199	VARCHAR2(500)	经营范围
			18	baf305	VARCHAR2(20)	所属省
			19	baf306	VARCHAR2(20)	所属市
			20	baf307	VARCHAR2(20)	所属区
			21	bkc122	VARCHAR2(1)	异地类型
			22	akb011	VARCHAR2(1)	与经办机构实时联网标识
			23	aae013	VARCHAR2(100)	说明或者备注
			24	AAE016	VARCHAR2(1)	复核标志（0录入，1复审）
			25	baf305_name	VARCHAR2(30)	地区名称
			26	akb023_name	VARCHAR2(2)	定点医疗机构类别
			27	bkc122_name	VARCHAR2(20)	异地类型
			28	akb011_name	VARCHAR2(1)	与经办机构实时联网标识
			29	bkc110_name	VARCHAR2(1)	医院级别（1、三级；3、二级；5、一级；9、无）
			30	aka101_name	VARCHAR2(2)	医院等级(甲、乙、丙)
			31	aae016_name	VARCHAR2(1)	复核标志（0录入，1复审）
	  */
	 public void t12(){
		 HospOutDTO ho=new HospOutDTO();
		 ho.setAkb020("028003");
		 List<Map<String,Object>> lm=enHospital.queHospOutInfo(ho);
		 out(lm);
	 }
	 
	 
	 /*
	  * 
	  * 1.2.2.11查询审核数据费用明细（扣减）(已通)
	  * 入参
	  * 1	bka116	NUMBER(22)	登账号
		2	akb020	VARCHAR2(20)	医院编号
		3	aaz218	VARCHAR2(20)	业务序列号
		4	strDealPhase	VARCHAR2(2)	费用审核阶段
		
		
		出参
		1	ACCOUNT_ID	NUMBER(22)	登帐号
		2	HOSPITAL_ID	VARCHAR2(20)	医院编号
		3	SERIAL_NO	VARCHAR2(20)	业务序列号
		4	SERIAL_FEE	NUMBER(12)	费用序列号
		5	STAT_TYPE	VARCHAR2(6)	统计类别
		6	HIS_ITEM_NAME	VARCHAR2(100)	医院药品项目名称
		7	ITEM_CODE	VARCHAR2(20)	中心药品项目编码
		8	MEDI_ITEM_TYPE	VARCHAR2(1)	项目药品类型(0:项目，1：西药，2：中成药，3：中草药)
		9	PRICE	NUMBER(10,4)	单价
		10	DOSAGE	NUMBER(12,4)	用量
		11	MODEL	VARCHAR2(30)	剂型
		12	STANDARD	VARCHAR2(300)	规格
		13	FEE_DATE	DATE	费用发生时间
		14	MONEY	NUMBER(12,4)	金额
		15	ALL_CASH	NUMBER(12,4)	现金全自费金额
		16	PART_CASH	NUMBER(12,4)	现金部分自费
		17	AUDIT_MONEY	NUMBER(12,4)	审核扣减金额
		18	AUDIT_REASON_ID	NUMBER(6)	拒付原因编号
		19	AUDIT_REASON	VARCHAR2(100)	拒付原因
		20	ITEM_NAME	VARCHAR2(100)	中心药品项目名称
		21	HIS_ITEM_CODE	VARCHAR2(20)	医院药品项目编码
		22	AUDIT_DOCTOR	VARCHAR2(20)	审核医生
		23	STAFF_1	VARCHAR2(20)	审核人
		24	AUDIT_DATE1	DATE	审核时间
		25	STAFF_2	VARCHAR2(20)	复核人
		26	AUDIT_DATE2	DATE	复审日期
	  */
	 
	 public void t13(){
		 AuditDTO adto=new AuditDTO();
		 adto.setBka116("373272073");
		 adto.setAaz218("0000001610001026");
		 adto.setAkb020("002001");
		 adto.setStrDealPhase("1");
		 List<Map<String,Object>> lm= medicalAuditInterface.getAuditFeeDetailInfoYL(adto);
		 System.out.println("lm:"+lm.size());
		 out(lm);
	 }
	 
	 
	 
	 /*
	  * 
	  * 1.2.2.11查询可审核处理的数据(已通)
	  * 入参
	  * 1	bka126	VARCHAR2(1) 	登帐标志(1:已初审 2:已复审 3:督察未通过 4:督察通过)
		2	bae010	VARCHAR2(22)	业务受理号
		3	bka004	VARCHAR2(3)	人员类别
		4	aka130	VARCHAR2(2)	业务类别编号
		5	aae140	VARCHAR2(3)	险种
		
		
		出参
			74	audit_flag	NUMBER(1)	生育待遇资格认定ID
			75	idcard	VARCHAR2(20)	公民身份号码
			76	name	VARCHAR2(50)	姓名
			77	sex	VARCHAR2(1)	性别
			78	begin_date	Date	业务开始时间
			79	in_dept_name	VARCHAR2(50)	入院科室名称
			80	in_area_name	VARCHAR2(50)	入院病区名称
			81	corp_name	VARCHAR2(200)	单位名称
			82	in_bed	VARCHAR2(20)	入院床位号
			83	patient_id	VARCHAR2(20)	医院业务号
			84	disease2	VARCHAR2(300)	疾病名称2
			85	disease3	VARCHAR2(300)	疾病名称3
			86	in_days	NUMBER(12)	住院天数
			87	icd	VARCHAR2(20)	疾病诊断
			88	disease	VARCHAR2(300)	疾病名称
			89	end_date	VARCHAR2(8)	业务结束日期
			90	injury_birth_sn	NUMBER(12)	工伤生育业务号
			91	account_id	NUMBER(12)	登帐号
			92	hospital_id	VARCHAR2(20)	医院编号
			93	hospital_name	VARCHAR2(100)	医疗机构名称
			94	hosp_level	VARCHAR2(1)	医院级别
			95	serial_no	VARCHAR2(20)	业务序列号
			96	indi_id	NUMBER(20)	个人电脑号
			97	pers_type	VARCHAR2(3)	人员类别
			98	biz_type	VARCHAR2(2)	业务类别编号
			99	treatment_type	VARCHAR2(6)	待遇类型
			100	treatment_type_last	VARCHAR2(20)	调整金额
			101	in_disease	VARCHAR2(20)	疾病编码(中心)
			102	reimburse_flag	VARCHAR2(1)	中心报帐标志
			103	fin_date	VARCHAR2(8)	完成时间
			104	beds	NUMBER(4)	床日数
			105	ration_times	NUMBER(3,1)	定额数
			106	first_audit_staff	VARCHAR2(10)	初审人工号
			107	first_audit_staff1	VARCHAR2(50)	初审人姓名
			108	second_audit_staff	VARCHAR2(10)	复审人工号
			109	second_audit_staff	VARCHAR2(50)	复审人姓名
			110	violate_flag	VARCHAR2(1)	违规标志
			111	violate	VARCHAR2(256)	违规原因
			112	hospout_flag	VARCHAR2(1)	外地标志
			113	month_decl_sn	VARCHAR2(22)	业务受理号
			114	pay_type	VARCHAR2(1)	结算方式
			115	final_pay_type	VARCHAR2(1)	最终结算方式
			116	cancel_reason	VARCHAR2(256)	取消审签原因
			117	district_code	VARCHAR2(10)	业务所属统筹区
			118	district_name	VARCHAR2(50)	统筹区
			119	bpe001	NUMBER(22)	内控稽核状态
			120	bka414	VARCHAR2(2)	补充人员类别
			121	out_biz_type	VARCHAR2(4)	冻结原因
			122	insur_no	VARCHAR2(3)	险种
			123	remark	VARCHAR2(150)	备注
			124	decl_phase	VARCHAR2(2)	处理状态
			125	deal_flag	VARCHAR2(2)	处理状态2
			126	finish_flag	VARCHAR2(1)	登帐标志
			127	pay_money	NUMBER(22)	结算金额
			128	betrey_flag	VARCHAR2(4)	结果类型
			129	qfx_self_pay	CHAR2(1)	分类标志
			130	fundpay	NUMBER(22)	支付金额
			131	fee_total	NUMBER(22)	结算金额
			132	selecthosp_flag	CHAR2(1)	选点标志
			133	ration_money120	NUMBER(22)	住院定额
			134	ration_money12D	NUMBER(22)	恶性肿瘤限额结算项目
			135	ration_money12F	NUMBER(22)	综合ICU住院
			136	insr_code	VARCHAR2(40)	医疗证号
			137	age	CHAR2(2)	公医年龄
			138	diagnose_type	VARCHAR2(100)	场景值
			139	hosp_audit_flag	CHAR2(1)	异地医疗机构审核标志
			140	corpfund	NUMBER(22)	单位支付金额
			141	deductfund	NUMBER(22)	个人支付金额
			142	fee_flag	CHAR2(1)	费用标记
			143	treat_flag	CHAR2(1)	待遇标记
			144	adjust_flag	CHAR2(1)	审核标记
			145	audit_money	NUMBER(12,2)	审核金额
			146	accept_note	VARCHAR2(256)	受理说明
	  */
	 
	 public void t15(){
		 KCE6DTO kce=new KCE6DTO();
		 kce.setAae140("310");
		 kce.setAka130("12");
		 kce.setBka004("1");
		 kce.setBae010("CZLB0020161020001");
		 kce.setBka126("1");
		 List<Map<String,Object>> lm= medicalAuditInterface.getAuditBizInfoYL(kce);
		 System.out.println("lm:"+lm.size());
		 out(lm);
	 }
	 
	 
	 /*
	  * 
	  * 1.2.2.11就诊信息查询
	  * 入参
	  * 1	begin_date	Date	就诊开始时间
		2	end_date	Date 	就诊结束时间
		3	arg_name	VARCHAR2(30)	参数名(字典项)：个人电脑号(aac001)\姓名(aac003)\身份证(aac002)
		4	arg_value	VARCHAR2(1000)	参数值
		5	his_query	NUMBER(1)	是否查询历史信息（字典项）：{'his':'是','1':'否'}
		6	insur_no	NUMBER(1)	是否查询异地信息（字典项）：{'71':'是','0':'否'}
		
		
		出参
			1	HOSPITAL_ID	VARCHAR2(20)	医院编号
			2	HOSPITAL_NAME	VARCHAR2(100)	医院名称
			3	SERIAL_NO	VARCHAR2(20)	业务序列号
			4	CASE_ID	NUMBER(12)	病例分型序号
			5	BIZ_TYPE	VARCHAR2(6)	业务类别编号
				BIZ_STAT	VARCHAR2(4)	业务大类
				NAME	VARCHAR2(20)	姓名
				SEX	VARCHAR2(1)	性别
				PERS_TYPE	VARCHAR2(6)	人员类别
				BEGIN_DATE	DATE	业务开始时间
				END_DATE	DATE	业务结束日期
				FIN_DATE	DATE	完成时间
				INDI_ID	NUMBER(12)	个人电脑号
				CORP_ID	NUMBER(12)	单位电脑号
				IDCARD	VARCHAR2(25)	公民身份号码
				DISTRICT_CODE	VARCHAR2(6)	统筹区编码
				OFFICE_GRADE	VARCHAR2(6)	公务员级别
				CORP_NAME	VARCHAR2(200)	单位名称
				IN_DISEASE	VARCHAR2(20)	入院疾病诊断
				IN_AREA_NAME	VARCHAR2(20)	入院病区
				IN_DEPT_NAME	VARCHAR2(50)	入院科室名称
				IN_BED	VARCHAR2(20)	入院床位号
				BED_TYPE	VARCHAR2(1)	床位类型
				PATIENT_ID	VARCHAR2(20)	医院业务号
				REMARK	VARCHAR2(500)	备注
				POS_CODE	VARCHAR2(20)	POS机编号
				REIMBURSE_FLAG	VARCHAR2(1)	中心报帐标志
				FIN_DISEASE	VARCHAR2(20)	出院疾病诊断
				IC_NO	VARCHAR2(25)	IC卡号
				TREATMENT_TYPE	VARCHAR2(6)	待遇类型
				FINISH_FLAG	VARCHAR2(1)	完成标志
				SURE_DATE	Date	审定结算日期
				DECL_SN	VARCHAR2(22)	业务受理号
				DEAL_PHASE	VARCHAR2(20)	处理状态
				SPECIAL_FLAG	VARCHAR2(1)	门特标志
				TOTAL_PAY	NUMBER(12,2)	支付金额
				BASE_PAY	NUMBER(12,2)	基本统筹支付金额
				CASH_PAY	NUMBER(12,2)	现金支付金额
				CORP_PAY	NUMBER(12,2)	企业补充支付金额
			出参：Map<String,Object>：
			list getBizTotal包含数据项：
			序号	字段名称	数据类型	注释
			1	BIZ_YEAR	NUMBER(12)	本年总业务次数
			2	DRUG_YEAR	NUMBER(12)	本年购药次数
			3	DIAG_YEAR	NUMBER(12)	本年门诊次数
			4	INHOSP_YEAR	NUMBER(12)	本年住院次数
			5	SPECIAL_YEAR	NUMBER(12)	本年门特次数
				MM_YEAR	NUMBER(12)	本年门慢次数
				FEE_YEAR	NUMBER(12,2)	本年业务发生费用
				FUND_YEAR	NUMBER(12,2)	本年基金支付
				ACCT_YEAR	NUMBER(12,2)	本年个人账户支付
				ADDITIONAL_YEAR	NUMBER(12,2)	本年大病支付
				RETIRE_YEAR	NUMBER(12,2)	离休基金支付
				OFFICIAL_YEAR	NUMBER(12,2)	公医支付
				DIAG_ITEM_YEAR	NUMBER(12,2)	门诊诊疗项目公务员基金支付
				MONTH_DIAG_YEAR	NUMBER(12,2)	当前月份门诊公务员支付累积
				CORP_ADD_YEAR	NUMBER(12,2)	企业补充支付
				F1201	NUMBER(12,2)	住院和门特个人自付（含起付线后个人负担）累计
				F1202	NUMBER(12,2)	企业补充住院和门特个人自付的基本医疗费用（不包括门慢）累计
				F1203	NUMBER(12,2)	公务员住院和门特个人自付（含起付线后个人负担）累计
				F1204	NUMBER(12,2)	公务员住院和门特个人自费（含起付线后个人负担）累计
	  */
	 
	 public void t16(){
		 MedicalFeeDTO mdto=new MedicalFeeDTO();
		 mdto.setBegin_date("20161001");
		 mdto.setEnd_date("20161029");
		 mdto.setArg_name("aac001");
		 mdto.setArg_value("1010792059");
		 mdto.setHis_query("");
		 mdto.setInsur_no("31");
		 Map<String,Object> map=medicalAuditInterface.getPersonSquare(mdto);
		 System.out.println("map:"+map.size());
		 out(map);
	 }
	 
	 
	 
	 /*
	  * 
	  * 1.2.2.11费用信息查询
	  * 入参
	  * 1	exec_flag		固定值 hospfeeiteminfo
		2	his_query		固定值为空
		3	hospital_id	VARCHAR2(20)	医院编码
		4	serial_no	VARCHAR2(20)	业务序列号
		
		
		出参
			1	stat_type	VARCHAR2(50)	代码类型
			2	stat_name	VARCHAR2(100)	显示值
			3	zfy	NUMBER(12,2)	费用金额
			4	qzf	NUMBER(12,2)	全自费
			5	blzf	NUMBER(12,2)	部分自费
	  */
	 public void t17(){
		 MedicalFeeDTO mfdto=new MedicalFeeDTO();
		 mfdto.setExec_flag("hospfeeiteminfo");
		 mfdto.setHis_query("");
		 mfdto.setHospital_id("002001");
		 mfdto.setSerial_no("0000001607000388");
		 List<Map<String,Object>> lm=medicalAuditInterface.queryMedicalFee(mfdto);
		 System.out.println("lm:"+lm.size());
		 out(lm);
	 }
	 
	 
	 /*
	  * 
	  * 1.2.2.22`获取参保人拨付账户信息(已通)
	  * 入参
	  * 1	queryType	VARCHAR2(50)	字典项，1：公民身份证号码；2：姓名；3：个人电脑号；4：受理号；5：公医证号
		2	queryCond	VARCHAR2(500)	参数值
		3	bka087	VARCHAR2(1)	拨付对象类型(H:医院 P:个人 C:单位)
		4	bka149	VARCHAR2(3)	零报卡种类(相当于险种大类)
		5	aae016	VARCHAR2(1)	审核状态。0:未审核；1:审核通过；2:审核不通过
		
		
		出参
			1	BKA152	NUMBER(16)	拨付账户ID
			2	bke850	VARCHAR2(1)	零报账户来源
			3	AAZ010	NUMBER(20)	当事人ID
			4	BKA087	VARCHAR2(1)	拨付对象类型(H:医院 P:个人 C:单位)
			5	BKA087_NAME	VARCHAR2(30)	参数值。
			6	AAE140	VARCHAR2(3)	险种
			7	AAZ003	VARCHAR2(30)	账号
			8	BKA149	VARCHAR2(3)	零报卡种类(相当于险种大类)
			9	BKA150	VARCHAR2(100)	账户变更原因
			10	BKA151	VARCHAR2(1)	账户使用类别（1：默认账户，2：临时账户）
			11	AAE100	VARCHAR2(1)	有效标志,0,无效,1有效
			12	AAE007	VARCHAR2(6)	邮政编码
			13	AAE006	VARCHAR2(80)	联系地址
			14	AAE005	VARCHAR2(30)	联系电话
			15	AAE004	VARCHAR2(50)	联系人姓名
			16	AAB069	VARCHAR2(100)	组织机构名称
			17	AAE013	VARCHAR2(100)	说明或者备注
			18	AAC002	VARCHAR2(30)	公民身份号码
			19	AAE011	VARCHAR2(10)	经办人
			20	AAE036	DATE	经办时间
			21	AAZ065	NUMBER(20)	银行ID
			22	AAZ065_NAME	VARCHAR2(100)	参数值
			23	BKA148	VARCHAR2(1)	零报卡是否使用标志
			24	BAE010	VARCHAR2(20)	业务受理号
			25	BAZ002	VARCHAR2(10)	修改人ID
			26	AAE016	VARCHAR2(2)	复核标记。（0：已制单，1：已审核 ，2：已批次汇总 ，3：已领导审签，4：已市局汇总，5：领导审签 ，6：已拨付汇总 ，7：已出纳确认，8：已银行回盘 ，9：需二次报盘 ，10：已回盘确认）
			27	AAE016_NAME	VARCHAR2(100)	参数值
			28	AAE015	DATE	复核(审批)时间
			29	AAE014	VARCHAR2(20)	复核(审批)人
			30	BKE957	VARCHAR2(100)	维护原因。（1:已终止参保并注销医疗保险凭证，需拨付到本人其它银行账户，2：参保人已死亡，并注销医疗保险凭证，需拨付到继承人指定银行账户，3：单位已垫付医疗费用，需拨付到单位银行账户，4：参保人已自行垫付医疗费，5：单位无对公账号，改拨单位法人个人账户，6：其他）
			31	bke957_name	VARCHAR2(500)	参数值。
			32	baz003	DATE	修改时间
	  */
	 public void t18(){
		 mediReimCardDTO mrdto=new mediReimCardDTO();
		 mrdto.setQueryCond("aac001");
		 mrdto.setQueryType("1010792059");
		 mrdto.setBka087("p");
		 mrdto.setBka149("1");
		 mrdto.setAae016("1");
//		 Map<String, Object> m=medicalAuditInterface.queryReimCard(mrdto);
//		 out(m);
	 }
	 
	 /*
	  * 取消就诊信息(通)
	  */
	 public void t19(){
		mediReimDeclareDTO mdto=new mediReimDeclareDTO();
		mdto.setAae013("test");
		mdto.setAae140("310");
		mdto.setAaz218("0000001610001130");
		mdto.setAkb020("002001");
		mdto.setBae010("CZLB0020161028014");
		mdto.setAaa027("441800");
		mdto.setBaa027("441800");
		Map map = reimDeclareInterface.cancleBiz(mdto);
		out(map);

	 }
	 
	 
	 /*
	  *修改就诊信息(通)
	  */
	 
	 public void t20(){
		 mediBizDTO m = new mediBizDTO();
			m.setBka401("0");
			m.setBkc111("0");
			m.setBke958("0");
			m.setDfbz("0");
			m.setBka004("2");
			m.setBkc110("1");
			m.setBka030("15");
			m.setAka130("12");
			m.setBka006("120");
			m.setBka116("373272171");
			m.setBka408("198");
			m.setAae013("");
			m.setBka928("");
			m.setAkb020("002001");
			m.setBka017("20160926");
			m.setBka032("20161011");
			m.setAab001("53131219");
			m.setAac001("1011740978");
			m.setAaz218("0000001610001124");
			m.setBilllist("[{\"bka418\":\"764\",\"bka116\":\"373272177\",\"bka416\":\"1\",\"bka404\":\"1\",\"aae019\":\"6000\",\"aae013\":\"\"}]");
			m.setDatam("135_x_138_x_141_x_162_x_8");
			m.setAka120("M80010/1");
			m.setBka409("广东省人民医院");
			m.setBka008("广州市海珠区退休职工管理委员会办公室");
			m.setAka121("良性或恶性未肯定瘤细胞");
			m.setAac003("林月妹");

			

			Map<String, Object> mPara = new HashMap<String, Object>();
			
			mPara.put("biz", m);
			mPara.put("preakb020", "002001");
			Map<String, Object> re = reimDeclareInterface.saveModifyBizInfo(mPara);
			out(re);


	 }
	 
	 
	 /*
	  *取消结算信息
	  *cancelBizFinish
	  */
	 
	 public void t21(){
		 mediReimDeclareDTO mdto=new mediReimDeclareDTO();
			String bae010 = "CZLB0020161028018";//"CZLB0020161013005";
			mdto.setBae010(bae010);
			Map<String,Object> reimd=reimDeclareInterface.cancelBizFinish(mdto);
			out(reimd); 


	 }
	 
	 
	 /*
	  *取消结算信息
	  *cancelBizFinish
	  */
	 
	 public void t22(){
		 mediReimDeclareDTO mdto=new mediReimDeclareDTO();
			String bae010 = "CZLB0020161028018";//"CZLB0020161013005";
			mdto.setBae010(bae010);
			Map<String,Object> reimd=reimDeclareInterface.cancelBizFinish(mdto);
			out(reimd); 
	 }
	
	 
	 
	 
	 
	
}
