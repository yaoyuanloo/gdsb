package com.fortunes.test.chuanzhi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.powersi.biz.medicare.medicareSpecial.dto.MediSpecDTO;
import com.powersi.dubbo.medicare.medicareSpecial.dto.ChangeHospitalDTO;
import com.powersi.dubbo.medicare.medicareSpecial.toFangDi.ChangeHospitalInterface;
import com.powersi.dubbo.medicare.medicareSpecial.toFangDi.SecondReturnHospitalInterface;

public class ZzzyglTest extends DubboTest{
	@Autowired
	ChangeHospitalInterface changeHosp;
	
	
	@Autowired
	SecondReturnHospitalInterface secondReturn;
	/*
	 * 1.2.9.1转诊转院业务信息保存 (通)
	 * addChangeHospitalInfo
	 * 入参:
		 * 1c			
			2	bae100	VARCHAR2(20)	经办人姓名
			3	aae036	DATE	经办时间
			4	bka143	VARCHAR2(20)	复核人工号
			5	aae014	VARCHAR2(20)	复核人
			6	aae015	DATE	复核时间
			7	aae016	VARCHAR2(2)	复核标志
			8	aae100	VARCHAR2(2)	有效标志
			9	aae013	VARCHAR2(100)	备注
			10	bka137	VARCHAR2(20)	审核人工号
			11	bke021	VARCHAR2(20)	审批人
			12	bke022	DATE	初审时间
			13	bke023	VARCHAR2(2)	初审标志
			14	bke024	VARCHAR2(500)	初审意见
			15	aac002	VARCHAR2(25)	公民身份号码
			16	aaz107	NUMBER(22)	定点医疗机构ID
			17	aae035_start	DATE	变更日期_开始
			18	aae035_end	DATE	变更日期_结束
			19	aae127_start	DATE	申请日期_开始
			20	aae127_end	DATE	申请日期_结束
			21	akb020	NUMBER(20)	医院编码
			22	akb021	VARCHAR2(100)	医疗服务机构名称
			23	akc030	VARCHAR2(100)	申请原因
			24	bke001	VARCHAR2(200)	详细地址
			25	bke002	VARCHAR2(200)	诊断依据
			26	bke003	VARCHAR2(50)	推荐病种
			27	bke004	VARCHAR2(50)	并发症
			28	bke005	VARCHAR2(6)	分型
			29	bke006	VARCHAR2(6)	病情严重等级
			30	bke025	VARCHAR2(50)	专家鉴定病种（关联AKA120）
			31	bke026	VARCHAR2(50)	专家鉴定并发症（关联AKA120）
			32	aab069	VARCHAR2(200)	组织机构名称
			33	aac003	VARCHAR2(50)	姓名
			34	bke027	VARCHAR2(6)	专家鉴定分型（新增码表）
			35	bke028	VARCHAR2(6)	专家鉴定病情严重等级（新增码表）
			36	bke029	VARCHAR2(50)	审核推荐病种（关联AKA120）
			37	bke030	VARCHAR2(50)	审核并发症（关联AKA120）
			38	bke031	VARCHAR2(6)	审核分型（新增码表）
			39	bke032	VARCHAR2(6)	审核病情严重等级（新增码表）
			40	aae019	NUMBER(22)	金额
			41	bke011	VARCHAR2(200)	病情摘要
			42	bke012	VARCHAR2(200)	治疗方案
			43	bke013	VARCHAR2(200)	医院意见
			44	bke014	VARCHAR2(20)	科室电话
			45	bke015	VARCHAR2(50)	就诊科室
			46	bke016	VARCHAR2(20)	申请人电话
			47	bke017	VARCHAR2(20)	申请医师
			48	bke018	VARCHAR2(20)	主任医师
			49	bke019	NUMBER(22)	主任意见时间
			50	bke020	NUMBER(22)	医师意见时间
			51	bke034	NUMBER(22)	医院意见时间
			52	akb081	NUMBER(22)	实际支付金额
			53	bkb016	NUMBER(22)	已使用限额
			54	bke033	VARCHAR2(20)	联系电话
			55	bke009	VARCHAR2(1000)	本次住院病情摘要
			56	bke010	VARCHAR2(1000)	转入医院医务科意见
			57	bke007	VARCHAR2(1000)	上次住院病情摘要
			58	bke008	VARCHAR2(1000)	转出医院医务科意见
			59	aaz267	NUMBER(22)	申请序列号
			60	aac001	NUMBER(22)	个人电脑号
			61	aae030	DATE	就诊日期
			62	aae031	DATE	结束日期
			63	aae127	DATE	申请日期
			64	aae189	VARCHAR2(500)	复审意见
			65	aaz002	NUMBER(22)	业务日志ID
			66	bke610	NUMBER(22)	医疗待遇申请历史ID
			67	aka083	VARCHAR2(3)	医疗特殊业务申请类型
			68	aka084	VARCHAR2(1)	针对特定就诊事件标志
			69	aaa027	VARCHAR2(6)	统筹区编码
			70	bke035	VARCHAR2(2)	申请类型
			71	bkb100	VARCHAR2(1)	申请标志(0:医院申请  1:中心申请)
			72	aaz107_in	NUMBER(22)	定点医疗机构ID 入
			73	aaz107_out	NUMBER(22)	定点医疗机构ID 出
			74	aab069_in	VARCHAR2(200)	组织机构名称 入
			75	aab069_out	VARCHAR2(200)	组织机构名称 出
			76	Bke036	VARCHAR2(30)	医院审批人 (转出医院医师姓名)
			77	bke038	VARCHAR2(50)	所属疾病
			78	bke037	VARCHAR2(20)	外地医院编码
			79	aae139	VARCHAR2(1)	异地标志
			80	aae190	VARCHAR2(1000)	医嘱
			81	aaz286	NUMBER(22)	原就诊医疗机构ID
			82	aaz294	NUMBER(22)	转往定点医疗机构ID
			83	aka079	VARCHAR2(1)	独立结算标志
			84	aka101	VARCHAR2(2)	医院等级
			85	akb041	VARCHAR2(20)	原就诊医疗服务机构编号
			86	akc172	VARCHAR2(2)	转往医院名称
			87	ake014	DATE	转院日期
			88	ake015	VARCHAR2(200)	转院原因
			89	ake017	VARCHAR2(20)	转往医疗服务机构编号
			90	bke040	NUMBER(22)	预计住院天数
			91	pke041	NUMBER(22)	预计住院费用
			92	bke061	VARCHAR2(2)	特殊项目类别(1内置材料、2移植介入造影、3大额治疗项目、4人工晶体、5心脏起搏器、6其他检查治疗
			93	bke042	VARCHAR2(200)	申请理由
			94	bke043	VARCHAR2(200)	医院机构相关意见
			95	pke044	VARCHAR2(200)	既往住院情况
			96	pke045	VARCHAR2(200)	诊疗计划
			97	bke046	VARCHAR2(20)	上次住院诊断
			98	aac004	VARCHAR2(1)	性别
			99	bac001	VARCHAR2(3)	公务员级别
			100	bka004	VARCHAR2(3)	人员类别
			101	aac006	DATE	出生日期
			102	bke047	DATE	转出医院意见时间
			103	bke048	DATE	转入医院签署意见时间
			104	bke049	VARCHAR2(10)	是否是自主转院或者是因病情需要转院
			105	bke050	VARCHAR2(20)	本次住院诊断
			106	bke051	VARCHAR2(200)	目的地
			107	bke052	VARCHAR2(200)	申请类型
			108	bke054	VARCHAR2(100)	单位意见
			109	bke055	VARCHAR2(1)	申请方式
			110	aab001	NUMBER(22)	单位电脑号
			111	aab301	VARCHAR2(6)	所属行政区代码
			112	aae006	VARCHAR2(100)	联系地址
			113	aae007	VARCHAR2(6)	邮政编码
			114	akb040	VARCHAR2(100)	安置地社保机构名称
			115	pke069	VARCHAR2(20)	联系电话
			116	pke070	VARCHAR2(6)	开户局邮政编码
			117	pke071	VARCHAR2(30)	开户局邮政储蓄所名称
			118	pke072	VARCHAR2(70)	邮寄的详细地址
			119	pke073	VARCHAR2(20)	邮政帐户
			120	pke074	VARCHAR2(20)	异地类型
			121	pke075	CHAR(1)	邮寄标志
			122	pke076	VARCHAR2(30)	联系人
			123	pke077	VARCHAR2(30)	与联系人关系
			124	pke078	VARCHAR2(1)	邮寄方式
			125	bke079	VARCHAR2(30)	异地安置省份名称
			126	bke080	VARCHAR2(30)	异地安置城市名称
			127	aaz218	VARCHAR2(20)	业务序列号
			128	aac007	DATE	参加工作日期
			129	aac012	VARCHAR2(3)	个人身份
			130	aka120	VARCHAR2(50)	疾病编码
			131	aka121	VARCHAR2(300)	疾病名称
			132	bka006	VARCHAR2(6)	待遇类别
			133	bka155	VARCHAR2(50)	待遇类型名称
			134	BKA019	VARCHAR2(20)	科室
			135	bka023	VARCHAR2(20)	床位号
			136	bka025	VARCHAR2(20)	住院号
			137	aae140	VARCHAR2(3)	险种类别
			138	aka130	VARCHAR2(2)	业务类型编码
			139	bka012	VARCHAR2(20)	关联业务序列号
			140	bac028	VARCHAR2(40)	公医证号
			141	bac010	VARCHAR2(2)	公医级别
			142	bkc016	NUMBER(22)	批次
			143	bke060	VARCHAR2(100)	原就诊医疗服务机构名称
			144	bke127	VARCHAR2(1000)	病人意见
			145	bke128	VARCHAR2(30)	申请病人(或家属)
			146	bke129	DATE	病人意见时间
			147	bka042	NUMBER(22)	对应的工伤生育业务号
			148	bke058	VARCHAR2(2)	医院审核标志
			149	bke057	DATE	医院审核时间
			150	bke056	VARCHAR2(500)	医院审核意见
			151	bka017	DATE	业务开始时间
			152	bka032	DATE	业务结束日期
			153	bke053	VARCHAR2(30)	转入医院签署意见人
			154	bke810	VARCHAR2(30)	是否扩大用药范围
			155	bke812	NUMBER(22)	特殊范围目录使用申请ID
			156	bkb085	VARCHAR2(20)	关联申请序列号
			157	bka183	VARCHAR2(50)	医疗特殊业务申请类型名称
			158	bke809	NUMBER(22)	审核数量
			159	bke875	VARCHAR2(200)	药品规格
			160	bke876	VARCHAR2(200)	药品用量
			161	bpe001	NUMBER(22)	内控稽核状态
			162	bka100	VARCHAR2(25)	IC 卡号
	 */
	public void t1(){
		MediSpecDTO ms=new MediSpecDTO();
		ms.setAac001(440229197911093218l);
		ms.setAac003("涂杰");
		ms.setAac001(1007725703l);
		ms.setBke036("liu");
		ms.setAae140("310");
		ms.setAka083("121");
		ms.setBka004("1");
		ms.setAab069("广州市江裕物业管理有限公司");
		ms.setBke060("广东省人民医院");
		ms.setAac007("2002-04-01");
		ms.setAab001("56074547");
		ms.setAae011("1029");
		ms.setAkb020("002001");
		ms.setAke017("002007");
		ms.setAaz218("0000001610001035");
		ms.setAac004("1");
		ms.setAkc172("广东药学院附属第一医院");
		ms.setBke127("同意转院");
		ms.setBke128("涂杰");
		ms.setBke008("转出医院同意");
		ms.setAka130("12");
		ms.setAkb021("广东省人民医院");
		Map<String,Object> maps=changeHosp.addChangeHospitalInfo(ms);
		out(maps);
	}
	
	
	/*
	 * 1.2.9.2获取转诊转院业务信息(已通)(初审复审)
	 * queryChangeHospitalInfo
	 * 入参定义（MediSpecDTO）,具体：
		序号	字段名称	数据类型	注释
		1	aae011	VARCHAR2(20)	经办人工号
		2	bae100	VARCHAR2(20)	经办人姓名
		3	aae036	DATE	经办时间
		4	bka143	VARCHAR2(20)	复核人工号
		5	aae014	VARCHAR2(20)	复核人
		6	aae015	DATE	复核时间
		7	aae016	VARCHAR2(2)	复核标志
		8	aae100	VARCHAR2(2)	有效标志
		9	aae013	VARCHAR2(100)	备注
		10	bka137	VARCHAR2(20)	审核人工号
		11	bke021	VARCHAR2(20)	审批人
		12	bke022	DATE	初审时间
		13	bke023	VARCHAR2(2)	初审标志
		14	bke024	VARCHAR2(500)	初审意见
		15	aac002	VARCHAR2(25)	公民身份号码
		16	aaz107	NUMBER(22)	定点医疗机构ID
		17	aae035_start	DATE	变更日期_开始
		18	aae035_end	DATE	变更日期_结束
		19	aae127_start	DATE	申请日期_开始
		20	aae127_end	DATE	申请日期_结束
		21	akb020	NUMBER(20)	医院编码
		22	akb021	VARCHAR2(100)	医疗服务机构名称
		23	akc030	VARCHAR2(100)	申请原因
		24	bke001	VARCHAR2(200)	详细地址
		25	bke002	VARCHAR2(200)	诊断依据
		26	bke003	VARCHAR2(50)	推荐病种
		27	bke004	VARCHAR2(50)	并发症
		28	bke005	VARCHAR2(6)	分型
		29	bke006	VARCHAR2(6)	病情严重等级
		30	bke025	VARCHAR2(50)	专家鉴定病种（关联AKA120）
		31	bke026	VARCHAR2(50)	专家鉴定并发症（关联AKA120）
		32	aab069	VARCHAR2(200)	组织机构名称
		33	aac003	VARCHAR2(50)	姓名
		34	bke027	VARCHAR2(6)	专家鉴定分型（新增码表）
		35	bke028	VARCHAR2(6)	专家鉴定病情严重等级（新增码表）
		36	bke029	VARCHAR2(50)	审核推荐病种（关联AKA120）
		37	bke030	VARCHAR2(50)	审核并发症（关联AKA120）
		38	bke031	VARCHAR2(6)	审核分型（新增码表）
		39	bke032	VARCHAR2(6)	审核病情严重等级（新增码表）
		40	aae019	NUMBER(22)	金额
		41	bke011	VARCHAR2(200)	病情摘要
		42	bke012	VARCHAR2(200)	治疗方案
		43	bke013	VARCHAR2(200)	医院意见
		44	bke014	VARCHAR2(20)	科室电话
		45	bke015	VARCHAR2(50)	就诊科室
		46	bke016	VARCHAR2(20)	申请人电话
		47	bke017	VARCHAR2(20)	申请医师
		48	bke018	VARCHAR2(20)	主任医师
		49	bke019	NUMBER(22)	主任意见时间
		50	bke020	NUMBER(22)	医师意见时间
		51	bke034	NUMBER(22)	医院意见时间
		52	akb081	NUMBER(22)	实际支付金额
		53	bkb016	NUMBER(22)	已使用限额
		54	bke033	VARCHAR2(20)	联系电话
		55	bke009	VARCHAR2(1000)	本次住院病情摘要
		56	bke010	VARCHAR2(1000)	转入医院医务科意见
		57	bke007	VARCHAR2(1000)	上次住院病情摘要
		58	bke008	VARCHAR2(1000)	转出医院医务科意见
		59	aaz267	NUMBER(22)	申请序列号
		60	aac001	NUMBER(22)	个人电脑号
		61	aae030	DATE	就诊日期
		62	aae031	DATE	结束日期
		63	aae127	DATE	申请日期
		64	aae189	VARCHAR2(500)	复审意见
		65	aaz002	NUMBER(22)	业务日志ID
		66	bke610	NUMBER(22)	医疗待遇申请历史ID
		67	aka083	VARCHAR2(3)	医疗特殊业务申请类型
		68	aka084	VARCHAR2(1)	针对特定就诊事件标志
		69	aaa027	VARCHAR2(6)	统筹区编码
		70	bke035	VARCHAR2(2)	申请类型
		71	bkb100	VARCHAR2(1)	申请标志(0:医院申请  1:中心申请)
		72	aaz107_in	NUMBER(22)	定点医疗机构ID 入
		73	aaz107_out	NUMBER(22)	定点医疗机构ID 出
		74	aab069_in	VARCHAR2(200)	组织机构名称 入
		75	aab069_out	VARCHAR2(200)	组织机构名称 出
		76	Bke036	VARCHAR2(30)	医院审批人 (转出医院医师姓名)
		77	bke038	VARCHAR2(50)	所属疾病
		78	bke037	VARCHAR2(20)	外地医院编码
		79	aae139	VARCHAR2(1)	异地标志
		80	aae190	VARCHAR2(1000)	医嘱
		81	aaz286	NUMBER(22)	原就诊医疗机构ID
		82	aaz294	NUMBER(22)	转往定点医疗机构ID
		83	aka079	VARCHAR2(1)	独立结算标志
		84	aka101	VARCHAR2(2)	医院等级
		85	akb041	VARCHAR2(20)	原就诊医疗服务机构编号
		86	akc172	VARCHAR2(2)	转往医院名称
		87	ake014	DATE	转院日期
		88	ake015	VARCHAR2(200)	转院原因
		89	ake017	VARCHAR2(20)	转往医疗服务机构编号
		90	bke040	NUMBER(22)	预计住院天数
		91	pke041	NUMBER(22)	预计住院费用
		92	bke061	VARCHAR2(2)	特殊项目类别(1内置材料、2移植介入造影、3大额治疗项目、4人工晶体、5心脏起搏器、6其他检查治疗
		93	bke042	VARCHAR2(200)	申请理由
		94	bke043	VARCHAR2(200)	医院机构相关意见
		95	pke044	VARCHAR2(200)	既往住院情况
		96	pke045	VARCHAR2(200)	诊疗计划
		97	bke046	VARCHAR2(20)	上次住院诊断
		98	aac004	VARCHAR2(1)	性别
		99	bac001	VARCHAR2(3)	公务员级别
		100	bka004	VARCHAR2(3)	人员类别
		101	aac006	DATE	出生日期
		102	bke047	DATE	转出医院意见时间
		103	bke048	DATE	转入医院签署意见时间
		104	bke049	VARCHAR2(10)	是否是自主转院或者是因病情需要转院
		105	bke050	VARCHAR2(20)	本次住院诊断
		106	bke051	VARCHAR2(200)	目的地
		107	bke052	VARCHAR2(200)	申请类型
		108	bke054	VARCHAR2(100)	单位意见
		109	bke055	VARCHAR2(1)	申请方式
		110	aab001	NUMBER(22)	单位电脑号
		111	aab301	VARCHAR2(6)	所属行政区代码
		112	aae006	VARCHAR2(100)	联系地址
		113	aae007	VARCHAR2(6)	邮政编码
		114	akb040	VARCHAR2(100)	安置地社保机构名称
		115	pke069	VARCHAR2(20)	联系电话
		116	pke070	VARCHAR2(6)	开户局邮政编码
		117	pke071	VARCHAR2(30)	开户局邮政储蓄所名称
		118	pke072	VARCHAR2(70)	邮寄的详细地址
		119	pke073	VARCHAR2(20)	邮政帐户
		120	pke074	VARCHAR2(20)	异地类型
		121	pke075	CHAR(1)	邮寄标志
		122	pke076	VARCHAR2(30)	联系人
		123	pke077	VARCHAR2(30)	与联系人关系
		124	pke078	VARCHAR2(1)	邮寄方式
		125	bke079	VARCHAR2(30)	异地安置省份名称
		126	bke080	VARCHAR2(30)	异地安置城市名称
		127	aaz218	VARCHAR2(20)	业务序列号
		128	aac007	DATE	参加工作日期
		129	aac012	VARCHAR2(3)	个人身份
		130	aka120	VARCHAR2(50)	疾病编码
		131	aka121	VARCHAR2(300)	疾病名称
		132	bka006	VARCHAR2(6)	待遇类别
		133	bka155	VARCHAR2(50)	待遇类型名称
		134	BKA019	VARCHAR2(20)	科室
		135	bka023	VARCHAR2(20)	床位号
		136	bka025	VARCHAR2(20)	住院号
		137	aae140	VARCHAR2(3)	险种类别
		138	aka130	VARCHAR2(2)	业务类型编码
		139	bka012	VARCHAR2(20)	关联业务序列号
		140	bac028	VARCHAR2(40)	公医证号
		141	bac010	VARCHAR2(2)	公医级别
		142	bkc016	NUMBER(22)	批次
		143	bke060	VARCHAR2(100)	原就诊医疗服务机构名称
		144	bke127	VARCHAR2(1000)	病人意见
		145	bke128	VARCHAR2(30)	申请病人(或家属)
		146	bke129	DATE	病人意见时间
		147	bka042	NUMBER(22)	对应的工伤生育业务号
		148	bke058	VARCHAR2(2)	医院审核标志
		149	bke057	DATE	医院审核时间
		150	bke056	VARCHAR2(500)	医院审核意见
		151	bka017	DATE	业务开始时间
		152	bka032	DATE	业务结束日期
		153	bke053	VARCHAR2(30)	转入医院签署意见人
		154	bke810	VARCHAR2(30)	是否扩大用药范围
		155	bke812	NUMBER(22)	特殊范围目录使用申请ID
		156	bkb085	VARCHAR2(20)	关联申请序列号
		157	bka183	VARCHAR2(50)	医疗特殊业务申请类型名称
		158	bke809	NUMBER(22)	审核数量
		159	bke875	VARCHAR2(200)	药品规格
		160	bke876	VARCHAR2(200)	药品用量
		161	bpe001	NUMBER(22)	内控稽核状态
		162	bka100	VARCHAR2(25)	IC 卡号
	 */
	@Test
	public void t2(){
		MediSpecDTO ms=new MediSpecDTO();
		ms.setAac001(440229197911093218l);
		ms.setAac003("涂杰");
		ms.setAac001(1007725703l);
		ms.setBke036("liu");
		ms.setAae140("310");
		ms.setAka083("121");
		ms.setBka004("1");
		ms.setAab069("广州市江裕物业管理有限公司");
		ms.setBke060("广东省人民医院");
		ms.setAac007("2002-04-01");
		ms.setAab001("56074547");
		ms.setAae011("1029");
		ms.setAkb020("002001");
		ms.setAke017("002007");
		ms.setAaz218("0000001610001035");
		ms.setAac004("1");
		ms.setAkc172("广东药学院附属第一医院");
		ms.setBke127("同意转院");
		ms.setBke128("涂杰");
		ms.setBke008("转出医院同意");
		ms.setAka130("12");
		ms.setAkb021("广东省人民医院");
		List list=changeHosp.queryChangeHospitalInfo(ms);
		out(list);
	}
	
	/*
	 * 转诊转院业务信息初审（已通）
	 */
	public void t3(){
		ChangeHospitalDTO cdto=new ChangeHospitalDTO();
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Map<String,Object> mp=new HashMap<String, Object>();
		mp.put("aaz267","11000298");
		mp.put("bka137","1049");
		mp.put("bke021","jjn");
		mp.put("bke024","通过");
		mp.put("aae016","2");
		mp.put("aac001","1007725703");
		mp.put("aaa027","440104");
		mp.put("aae140","310");
		list.add(mp);
		cdto.setChangeList(list);
		Map<String,Object> map=changeHosp.auditChangeHospitalInfo(cdto);
		out(map);
	}
	
	/*
	 * 1.2.9.5转诊转院业务信息复审(已通)
	 */
	public void t4(){
		ChangeHospitalDTO cdto=new ChangeHospitalDTO();
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Map<String,Object> mp=new HashMap<String, Object>();
		mp.put("aaz267","11000298");
		mp.put("bka143","1049");
		mp.put("aae014","jjn");
		mp.put("aae189","不通过");
		mp.put("aae016","4");
		mp.put("aac001","1007725703");
		mp.put("aaa027","440104");
		mp.put("aae140","310");
		list.add(mp);
		cdto.setChangeList(list);
		Map<String,Object> map=changeHosp.checkChangeHospitalInfo(cdto);
		out(map);
	}
	
	
	/*
	 * 1二次返院业务申请信息保存 (已通)
	 * addSecondReturnHospitalInfo
	 */
	
	public void t5(){
		MediSpecDTO ms = new MediSpecDTO();
		ms.setAac001(1007725703);
		ms.setAac002("440229197911093218");
		ms.setBke036("li");
		ms.setAae140("310");
		ms.setAka083("122");
		ms.setBke017("liu");
		ms.setBke018("lei");
		ms.setBka004("1");
		ms.setBke060("广东省人民医院");
		ms.setAab001("56074547");
		ms.setAae013("测试");
		ms.setAae011("1029");
		ms.setAaz218("0000001610001024");
		ms.setBke008("同意二次返院");
		ms.setAkb021("广东省人民医院");
		ms.setBke009("测试病情摘要");
		ms.setBae100("杨晴");
		ms.setAkb020("002001");
		ms.setBka017("2016-09-25");
		ms.setBka012("0000001610001035");
		ms.setBka032("2016-10-11");
		ms.setBke050("J11.101");
		ms.setAaa027("441821");
		ms.setAac004("1");
		Map<String,Object> map=secondReturn.addSecondReturnHospitalInfo(ms);
		out(map);
	}
	
	/*
	 * 二次返院业务申请信息初审
	 * auditSecondReturnHospitalInfo
	 */
	
	public void t6(){
		ChangeHospitalDTO c=new ChangeHospitalDTO();
		List<Map<String,Object>> mp=new ArrayList<Map<String,Object>>();
		Map<String,Object> maps=new HashMap<String, Object>();
		maps.put("aaz267","11000301");
		maps.put("bka137","1049");
		maps.put("bke021","jjn");
		maps.put("bke024","通过");
		maps.put("aae016","2");
		maps.put("aac001","1007725703");
		maps.put("aaa027","440104");
		mp.add(maps);
		c.setChangeList(mp);
		Map<String,Object> map=secondReturn.auditSecondReturnHospitalInfo(c);
		out(map);
	}
	
	
	/*
	 * 二次返院业务申请信息复审（已通）
	 * auditSecondReturnHospitalInfo
	 */
	
	public void t7(){
		ChangeHospitalDTO c=new ChangeHospitalDTO();
		List<Map<String,Object>> mp=new ArrayList<Map<String,Object>>();
		Map<String,Object> maps=new HashMap<String, Object>();
		maps.put("aaz267","11000301");
		maps.put("bka143","1049");
		maps.put("aae014","jjn");
		maps.put("aae189","不通过");
		maps.put("aae016","4");
		maps.put("aac001","1007725703");
		maps.put("aaa027","440104");
		mp.add(maps);
		c.setChangeList(mp);
		Map<String,Object> map=secondReturn.checkSecondReturnHospitalInfo(c);
		out(map);
	}
	
}
