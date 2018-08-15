package com.fortunes.test.chuanzhi;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.powersi.dubbo.injury.outInter_fangdi.MaternityRegService_fd;
import com.powersi.dubbo.injury.outInter_fangdi.TreatmentApprobateService_fd;
import com.powersi.dubbo.injury.outInter_fangdi.dto.TreatmentApprobateDTO;
import com.powersi.dubbo.injury.outInter_fangdi.dto.TreatmentRegisterDTO;

/*
 * 生育待遇信息
 */
public class YlTest  extends DubboTest{
	
	
	@Autowired  
	MaternityRegService_fd maternity;
	
	
	
	@Autowired
	TreatmentApprobateService_fd treatmentApprobate;
	
	/*
	 *1.7.1.1获取人员生育信息(通)	
	 *入参：	AAC001	NUMBER(20)	FALSE	人员ID
	 *出参：     1	AAC058	VARCHAR2(2)	FALSE	身份证件类型
			2	AAC001	NUMBER(20)	TRUE	个人电脑号
			3	AAC002	VARCHAR2(20)	FALSE	公民身份号码
			4	AAC003	VARCHAR2(50)	FALSE	姓名
			5	AAC004	VARCHAR2(1)	FALSE	性别
			6	AAE030	VARCHAR2(6)	FALSE	开始时间
			7	AAB001	NUMBER(20)	FALSE	单位id
			8	AAB019	VARCHAR2(2)	FALSE	单位类型
			9	AAB999	VARCHAR2(10)	FALSE	单位管理码
			10	AAB069	VARCHAR2(100)	FALSE	单位名称
			11	AAZ157	NUMBER(16)	FALSE	人员社会保险明细ID
	 */
	public void t1(){
		TreatmentRegisterDTO tr=new TreatmentRegisterDTO();
		tr.setAac001(1012459819l);
		List list=maternity.registerInfAjaxQuery(tr);
		out(list);
	}
	
	
	
	/*
	 *生育信息登记保存(已通)
	 *入参：	1	AAC001	NUMBER(20)	FALSE	人员ID
			2	AAZ107	NUMBER(20)	FALSE	定点医疗机构ID
			3	AMC027	VARCHAR2(1)	FALSE	晚育标志
			4	AAZ157	NUMBER(16)	FALSE	人员社会保险明细ID
			5	AAB001	NUMBER(16)	FALSE	单位编号
			6	AAZ159	NUMBER(16)	FALSE	人员参保关系ID
			7	AMC021	VARCHAR2(20)	FALSE	生育证号
			8	Ylks	NUMBER(8)	FALSE	医疗生效时间
			9	Yljs	NUMBER(8)	FALSE	医疗失效时间
			10	BMC013	NUMBER(8)	FALSE	预产期
			11	AKB020	VARCHAR2(20)	FALSE	医疗机构编号
			12	BAA020	VARCHAR2(1)	FALSE	生育特殊登记标志：1：为特殊登记
			
	 *出参：     出参定义（Map）：
			参数1：
			键：issuccess   值：1，成功；0，失败。
			参数2：
			键：errMes     值：具体错误原因
	 */
	public void t2(){
		TreatmentRegisterDTO tr=new TreatmentRegisterDTO();
		tr.setAac001(1012459819l);
		Map<String,Object> map=maternity.registerInfSave(tr);
		out(map);
	}
	
	
	/*
	 * 1.7.1.2生育信息登记修改保存(已通)
	 *regInfUpdate
	 * 入参：入参定义（TreatmentRegisterDTO trDTO）,具体：
		序号	字段名称	数据类型	主键	注释
		1	AAC001	NUMBER(20)	FALSE	人员ID
		2	AAZ107	NUMBER(20)	FALSE	定点医疗机构ID
		3	AMC027	VARCHAR2(1)	FALSE	晚育标志
		4	AAZ157	NUMBER(16)	FALSE	人员社会保险明细ID
		5	AAB001	NUMBER(16)	FALSE	单位编号
		6	AAZ159	NUMBER(16)	FALSE	人员参保关系ID
		7	AMC021	VARCHAR2(20)	FALSE	生育证号
		8	Ylks	NUMBER(8)	FALSE	医疗生效时间
		9	Yljs	NUMBER(8)	FALSE	医疗失效时间
		10	BMC013	NUMBER(8)	FALSE	预产期
		11	AKB020	VARCHAR2(20)	FALSE	医疗机构编号
		12	BAA020	VARCHAR2(1)	FALSE	生育特殊登记标志：1：为特殊登记
		
		出参：
			出参定义（Map）：
			参数1：
			键：issuccess   值:1，成功；0，失败。
			参数2：
			键：errMes     值：具体错误原因
	 */
	
	public void t3(){
		TreatmentRegisterDTO tr=new TreatmentRegisterDTO();
		tr.setCaae030(20160928l);
		tr.setBmc013(20161031l);
		tr.setAab999("68068182");
		tr.setLxys(0);
		tr.setAkb020("0010");
		tr.setAac002("44010419611110441X");
		tr.setAae031(20170928l);
		tr.setAac003("测试");
		tr.setAac004("1");
		tr.setAae030(20160928l);
		tr.setAaz107(475232l);
		tr.setAac001(1000859171l);
		tr.setBka030("测试");
		tr.setAmc021("123qqq");
		tr.setAaz238(21l);
		tr.setAab069("111");
		tr.setAab019("10");
		tr.setAmc027("0");
		tr.setLjys("0");
		Map<String,Object> map=maternity.regInfUpdate(tr);
		out(map);
	}
	
	
	
	/*
	 * 1.7.2.1获取生育登记修改（已经通）
	 * 入参：
	 * 	11	AAB001	NUMBER(20)	FALSE	单位ID
		22	AAZ238	NUMBER(16)	FALSE	生育待遇资格认定ID
		33	AAE030	NUMBER(8)	FALSE	医疗生效时间
		44	AAC001	NUMBER(20)	FALSE	人员ID
		
	出参：
		
		1	AAC058	VARCHAR2(2)	FALSE	身份证件类型
		2	AAC001	NUMBER(20)	TRUE	个人电脑号
		3	AAC002	VARCHAR2(20)	FALSE	公民身份号码
		4	AAC003	VARCHAR2(50)	FALSE	姓名
		5	AAC004	VARCHAR2(1)	FALSE	性别
		6	BKA030	VARCHAR2(200)	FALSE	申请治疗医院名称
		7	AAE030	NUMBER(8)	FALSE	医疗生效时间
		8	AAB019	VARCHAR2(2)	FALSE	单位类型
		9	AAB999	VARCHAR2(10)	FALSE	单位管理码
		10	AAB069	VARCHAR2(100)	FALSE	单位名称
		11	AAZ157	NUMBER(16)	FALSE	人员社会保险明细ID
		12	ljys	NUMBER(16)	FALSE	累计缴费月数 
	 */
	public void t4(){
		TreatmentRegisterDTO tr=new TreatmentRegisterDTO();
		tr.setAab001(68068182l);
		tr.setAaz238(21l);
		tr.setAae030(20160928l);
		tr.setAac001(1000859171l);
		List list=maternity.changeRegInf(tr);
		out(list);
	}
	
	
	
	
	
	/*
	 * 1.7.2.1生育登记修改删除（已通）
	 * 入参：
	 * 11	AAZ238	NUMBER(16)	FALSE	生育待遇资格认定ID
		
		  出参定义（Map）:
			参数1:
				键:issuccess   值:1，成功；0，失败。
			参数2:
				键:errMes      值:具体错误原因
	 */
		
	public void t6(){
		TreatmentRegisterDTO tr=new TreatmentRegisterDTO();
		tr.setAaz238(39l);
		Map<String,Object> map=maternity.registerInfDelete(tr);
		out(map);
	}
	
	
	/*
	 * 生育待遇资格认定（获取生育信息）（已通）
	 * 入参:
	 *		1	AAC001	NUMBER(20)	FALSE	人员ID
	        出参:
		  1	AAA075	VARCHAR2(1)	FALSE	待遇享受资格认证标志
			2	AAC001	NUMBER(20)	FALSE	人员ID
			3	AAE005	VARCHAR2(20)	FALSE	联系电话
			4	AAE127	NUMBER(8)	FALSE	申请日期
			5	AAZ107	NUMBER(20)	FALSE	定点医疗机构ID
			6	AAZ157	NUMBER(16)	FALSE	人员社会保险明细ID
			7	AAZ159	NUMBER(16)	FALSE	人员参保关系ID
			8	AAZ172	NUMBER(16)	FALSE	人员待遇申请事件ID
			9	AAZ238	NUMBER(16)	FALSE	生育待遇资格认定ID
			10	AMC010	VARCHAR2(50)	FALSE	配偶姓名
			11	AMC020	NUMBER(8)	FALSE	计划生育手术或生育日期
			12	AMC021	VARCHAR2(20)	FALSE	生育证号
			13	AAA027	VARCHAR2(6)	FALSE	统筹区编码
			14	AMC027	VARCHAR2(1)	FALSE	晚育标志
			15	PRSENO	NUMBER(12)	FALSE	PRSENO
			16	BMC011	VARCHAR2(20)	FALSE	配偶身份证号码
			17	BMC012	VARCHAR2(50)	FALSE	配偶工作单位/住址
			18	AMC034	VARCHAR2(4)	FALSE	人员类型
			19	AAE030	NUMBER(8)	FALSE	医疗生效时间
			20	AAE031	NUMBER(8)	FALSE	医疗失效时间
			21	AKB020	VARCHAR2(20)	FALSE	医疗机构编号
			22	BMC013	NUMBER(8)	FALSE	预产期
			23	AAB001	NUMBER(16)	FALSE	单位编号
			24	BAA020	VARCHAR2(1)	FALSE	生育特殊登记标志：1：为特殊登记
			25	BKA030	VARCHAR2(80)	FALSE	医院名称

			2)数据集名称人员信息(list),内容如下:
			序号	字段名称	数据类型	主键	注释
			1	AAC058	VARCHAR2(2)	FALSE	身份证件类型
			2	AAC001	NUMBER(20)	TRUE	个人电脑号
			3	AAC002	VARCHAR2(20)	FALSE	公民身份号码
			4	AAC003	VARCHAR2(50)	FALSE	姓名
			5	AAC004	VARCHAR2(1)	FALSE	性别
			6	BKA030	VARCHAR2(200)	FALSE	申请治疗医院名称
			7	AAE030	NUMBER(8)	FALSE	医疗生效时间
			8	AAB019	VARCHAR2(2)	FALSE	单位类型
			9	AAB999	VARCHAR2(10)	FALSE	单位管理码
			10	AAB069	VARCHAR2(100)	FALSE	单位名称
			11	AAZ157	NUMBER(16)	FALSE	人员社会保险明细ID
			12	ljys	NUMBER(16)	FALSE	累计缴费月数 
	 */
	public void t7(){
		TreatmentApprobateDTO tr=new TreatmentApprobateDTO();
		tr.setAac001(1000859171l);
		List list=treatmentApprobate.insuranceInfQuery(tr);
		out(list);
	}
	
	
	/*
	 * 1.7.3.2资格认证保存（接口问题 没通）
	 * 入参:
	 *		入参定义（TreatmentApprobateDTO taDTO）,具体：
				序号	字段名称	数据类型	主键	注释
				11	AAC001	NUMBER(20)	FALSE	人员ID
				22	AAC002	VARCHAR2(20)	FALSE	身份证号
				33	AAC003	VARCHAR2(20)	FALSE	身份证
				44	AAC058	VARCHAR2(2)	FALSE	身份证件类型
				55	AAB999	VARCHAR2(10)	FALSE	单位管理码
				66	AAB003	VARCHAR2(20)	FALSE	组织机构代码
				77	AAB004	VARCHAR2(100)	FALSE	单位名称
				88	AAB069	VARCHAR2(100)	FALSE	单位名称
				99	AAC004	VARCHAR2(1)	FALSE	性别
				10	AAE030	DATE	FALSE	医疗期开始时间
				11	ljys	NUMBER(20)	FALSE	累计缴费月数
				12	AMC020	NUMBER(8)	FALSE	计划生育手术或生育日期
				13	AMC021	VARCHAR2(20)	FALSE	生育证号
				14	AMC027	VARCHAR2(1)	FALSE	晚育标志
				15	AMC010	VARCHAR2(50)	FALSE	配偶姓名
				16	BMC011	VARCHAR2(20)	FALSE	配偶身份证号码
				17	BMC012	VARCHAR2(50)	FALSE	配偶工作单位/住址
				18	BKA030	VARCHAR2(80)	FALSE	医院名称
				19	AAE005	VARCHAR2(20)	FALSE	短信接收电话
				20	AAZ157	NUMBER(16)	FALSE	人员社会保险明细ID
				21	AAZ159	NUMBER(16)	FALSE	人员参保关系ID
				22	AAZ107	NUMBER(20)	FALSE	定点医疗机构ID
				23	beginDate	VARCHAR2(6)	FALSE	开始时间
				24	endDate	VARCHAR2(6)	FALSE	结束时间
				25	AAZ172	NUMBER(16)	TRUE	人员待遇申请事件ID
				26	AMC022	VARCHAR2(20)	FALSE	出生证号
				27	AMC050	VARCHAR2(1)	FALSE	业务类型(1,生育,2,计划生育手术
				28	AMC026	VARCHAR2(2)	FALSE	生育类别
				29	AMC029	VARCHAR2(20)	FALSE	计划生育手术类别
				30	AAC016	VARCHAR2(3)	FALSE	就业状态
				31	AMC051	VARCHAR2(1)	FALSE	领取独生子女证标志,0,未领,1,已领
				32	AMC052	VARCHAR2(20)	FALSE	独生子女证号
				33	AMC031	NUMBER(3)	FALSE	胎次
				34	AMC028	NUMBER(3)	FALSE	胎儿数
				35	AAZ238	NUMBER(20)	FALSE	生育待遇资格认定ID
				36	BMC013	NUMBER(8)	FALSE	预产期
				37	AAB019	VARCHAR2(2)	FALSE	单位类型
				38	AKB020	VARCHAR2(20)	FALSE	医疗服务机构编号
				39	AAB001	NUMBER(16)	FALSE	单位编号
	        出参:
		  出参定义（Map）：
			参数1：
			键：issuccess   值：1，成功；0，失败。
			参数2：
			键：errMes     值：具体错误原因
	 */
	@Test
	public void t8(){
		TreatmentApprobateDTO dto=new TreatmentApprobateDTO();
		dto.setAkb020("0010");
		dto.setAmc031(1l);
		dto.setAac001(-1l);
		dto.setAmc020(20161031l);
		dto.setAaz238(21l);
		dto.setAmc022("112233");
		dto.setBmc013(20161031l);
		dto.setYljs(20170928l);
		dto.setAmc021("123qqq");
		dto.setAmc050("1");
		dto.setAmc026("1");
		dto.setYlks(20160928l);
		dto.setAmc028(1l);
		dto.setAaz107(475232l);
		dto.setAaa027("441802");
		dto.setUserid("123123");
		Map<String,Object> map=treatmentApprobate.approbateInfSave(dto);
		out(map);
	}
	
	
	
	
	/*
	 * 1.7.3.21.7.4生育待遇资格认定查询（不通）
	 * 入参:
	 *		11	AAZ238	NUMBER(16)	FALSE	生育待遇资格认定ID
	        出参:
		  1	AMC020	NUMBER(8)	FALSE	计划生育手术或生育日期
			2	AMC021	VARCHAR2(20)	FALSE	生育证号
			3	AMC027	VARCHAR2(1)	FALSE	晚育标志
			4	AMC010	VARCHAR2(50)	FALSE	配偶姓名
			5	BMC011	VARCHAR2(20)	FALSE	配偶身份证号码
			6	BMC012	VARCHAR2(50)	FALSE	配偶工作单位/住址
			7	AAE005	VARCHAR2(20)	FALSE	联系电话
			8	AAC002	VARCHAR2(50)	FALSE	姓名
			9	AAC003	VARCHAR2(20)	FALSE	身份证
			10	AAC004	VARCHAR2(1)	FALSE	性别
			11	AAC058	VARCHAR2(2)	FALSE	身份证件类型
			12	AAE030	NUMBER(8)	FALSE	医疗生效时间
			13	AAZ107	NUMBER(20)	FALSE	定点医疗机构ID
			14	AAE031	VARCHAR2(6)	FALSE	调整结束时间
			15
				BMC013	NUMBER(8)	FALSE	预产期
			16	AKB020	VARCHAR2(20)	FALSE	医疗机构编号
			17	AMC022	VARCHAR2(20)	FALSE	出生证号
			18	AMC050	VARCHAR2(1)	FALSE	业务类型(1,生育,2,计划生育手术
			19	AMC026	VARCHAR2(2)	FALSE	生育类别
			20	AMC029	VARCHAR2(20)	FALSE	计划生育手术类别
			21	AAC016	VARCHAR2(3)	FALSE	就业状态
			22	AMC051	VARCHAR2(1)	FALSE	领取独生子女证标志,0,未领,1,已领
			23	AMC031	NUMBER(3)	FALSE	胎次
			24	AMC052	VARCHAR2(20)	FALSE	独生子女证号
			25	AMC028	NUMBER(3)	FALSE	胎儿数
			26	AAB069	VARCHAR2(100)	FALSE	单位名称
	 */
	
	public void t9(){
		TreatmentApprobateDTO dto=new TreatmentApprobateDTO();
		dto.setAaz238(5l);
		List list=treatmentApprobate.changeApprobateInf(dto);
		out(list);
	}
	
	
	
	/*
	 * 1.7.3.21.7.4生育待遇资格认定修改(已通)
	 * 入参:
	 *		11		AAZ172	NUMBER(22)		人员待遇申请事件ID
	        出参:
		 	AAZ172	NUMBER(22)		人员待遇申请事件ID
	 */
	
	public void t10(){
		TreatmentApprobateDTO dto=new TreatmentApprobateDTO();
		dto.setAaz172(116l);
		Map<String,Object> map=treatmentApprobate.approbateChangeAjaxQuery(dto);
		out(map);
	}
	
	
	/*
	 * 1.7.3.21.7.4生育待遇资格认定删除(已通)
	 * 入参:
	 *		11		AAZ172	NUMBER(22)		人员待遇申请事件ID
	        出参:
		 	AAZ172	NUMBER(22)		人员待遇申请事件ID
	 */
	public void t11(){
		TreatmentApprobateDTO dto=new TreatmentApprobateDTO();
		dto.setAaz238(39l);
		Map<String,Object> map=treatmentApprobate.approbateInfDelete(dto);
		out(map);
	}
	
	
	/*
	 * 1.7.3.21.7.4生育待遇资格认定保存(已通)
	 * 入参:
	 *		11	AAZ107	NUMBER(20)	FALSE	定点医疗机构ID
				22	AAE005	VARCHAR2(20)	FALSE	短信接收电话
				33	AMC020	NUMBER(8)	FALSE	计划生育手术或生育日期
				44	AMC021	VARCHAR2(20)	FALSE	生育证号
				55	AMC027	VARCHAR2(1)	FALSE	晚育标志
				66	AMC010	VARCHAR2(50)	FALSE	配偶姓名
				77	BMC011	VARCHAR2(20)	FALSE	配偶身份证号码
				88	BMC012	VARCHAR2(50)	FALSE	配偶工作单位/住址
				99	AAZ238	NUMBER(20)	FALSE	生育待遇资格认定ID
				10	Ylks	VARCHAR2(6)	FALSE	医疗开始时间
				11	Yljs	VARCHAR2(6)	FALSE	医疗结束时间
				12	BMC013	NUMBER(8)	FALSE	预产期
				13	AKB020	VARCHAR2(20)	FALSE	医疗机构编号
				14	AMC022	VARCHAR2(20)	FALSE	出生证号
				15	AMC050	VARCHAR2(1)	FALSE	业务类型(1,生育,2,计划生育手术
				16	AMC026	VARCHAR2(2)	FALSE	生育类别
				17	AMC029	VARCHAR2(20)	FALSE	计划生育手术类别
				18	AAC016	VARCHAR2(3)	FALSE	就业状态
				19	AMC051	VARCHAR2(1)	FALSE	领取独生子女证标志,0,未领,1,已领
				20	AMC052	VARCHAR2(20)	FALSE	独生子女证号
				21	AMC031	NUMBER(3)	FALSE	胎次
				22	AMC028	NUMBER(3)	FALSE	胎儿数
	        出参:
		 	出参定义（Map）：
			参数1：
			键：issuccess   值：1，成功；0，失败。
			参数2：
			键：errMes     值：具体错误原因
	 */
	
	public void t12(){
		TreatmentApprobateDTO dto=new TreatmentApprobateDTO();
		dto.setAkb020("0010");
		dto.setAmc031(1l);
		dto.setAac002("44010419611110441X");
		dto.setAac001(-1l);
		dto.setAmc020(20161031l);
		dto.setAaz238(21l);
		dto.setAmc022("112233");
		dto.setBmc013(20161031l);
		dto.setYljs(20170928l);
		dto.setAmc021("123qqq");
		dto.setAmc050("1");
		dto.setAmc026("1");
		dto.setYlks(20160928l);
		dto.setAmc028(1l);
		dto.setAmc027("0");
		dto.setAac058("01");
		dto.setAaz107(475232l);
		dto.setAab069("1111111111");
		dto.setAac003("1");
		Map<String,Object> map=treatmentApprobate.approbateInfSave(dto);
		out(map);
	}
}
