package com.fortunes.test.dongruan;

import com.fortunes.test.DubboTest;
import com.google.common.collect.Lists;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.param.PersonDubboInsuranceDTO;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.param.PersonInfoRegisterParam;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.result.PersonInfoRegisterResult;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.service.PersonManageDubboService;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.param.ResidentRegisterParam;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.param.ResidentStopParam;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.result.ResidentRegisterResult;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.result.ResidentStopResult;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.service.ResidentManageDubboService;
import com.neusoft.sl.si.collection.dubbo.employee.feehistory.param.FeeHistoryMakeupParam;
import com.neusoft.sl.si.collection.dubbo.employee.feehistory.result.FeeHistoryMakeupResult;
import com.neusoft.sl.si.collection.dubbo.employee.feehistory.service.PensionHistoryFeeMakeupDubboService;
import com.neusoft.sl.si.collection.dubbo.resident.refund.param.RefundModifyParam;
import com.neusoft.sl.si.collection.dubbo.resident.refund.result.RefundModifyResult;
import com.neusoft.sl.si.collection.dubbo.resident.refund.service.QY_RefundDubboService;
import com.neusoft.sl.si.settle.dubbo.common.param.PersonBaseInfo;
import com.neusoft.sl.si.settle.dubbo.common.param.UnitBaseInfo;
import com.neusoft.sl.si.settle.dubbo.pension.param.TempActMsg;
import com.neusoft.sl.si.settle.dubbo.pension.param.TempActMsgAcceptParam;
import com.neusoft.sl.si.settle.dubbo.pension.param.TempActMsgSendParam;
import com.neusoft.sl.si.settle.dubbo.pension.result.TempActMsgAcceptResult;
import com.neusoft.sl.si.settle.dubbo.pension.result.TempActMsgSendResult;
import com.neusoft.sl.si.settle.dubbo.pension.service.SaveTempActMsgAcceptDubboService;
import com.neusoft.sl.si.settle.dubbo.pension.service.SaveTempActMsgSendDubboService;
import com.neusoft.sl.si.settle.dubbo.unemploy.param.UnemployContactNotePrintParam;
import com.neusoft.sl.si.settle.dubbo.unemploy.result.UnemployContactNotePrintResult;
import com.neusoft.sl.si.settle.dubbo.unemploy.service.SaveUnemployNoteDubboService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by cxd on 2016/11/1 0001.
 */
public class CXDTest extends DubboTest {

//    @Autowired
//    QY_RefundDubboService service;

//    @Autowired
//    SaveUnemployNoteDubboService service1;

    @Autowired
    ResidentManageDubboService service2;

    @Autowired
    SaveTempActMsgSendDubboService service3;

    @Autowired
    SaveTempActMsgAcceptDubboService service4;

    @Autowired
    PersonManageDubboService service5;

    @Autowired
    PensionHistoryFeeMakeupDubboService service6;

    /**
     * 城乡居民医疗缴费退费（清远）
     */
    @Test
    public void test() {
        UnemployContactNotePrintParam p = new UnemployContactNotePrintParam();

//        UnemployContactNotePrintResult o = service1.dubboCreateUnemployContactNote(p);
//        out(o);
    }

    /**
     * 城乡居民医疗缴费退费（清远）
     */
    @Test
    public void test1() {
        RefundModifyParam p = new RefundModifyParam();

//        RefundModifyResult o = service.Refund(p);
//        out(o);
    }

    /**
     * 居民注销
     * <p>
     * ResidentStopParam,
     * Long aac001;// 个人编号
     * Long aab001;// 单位编号
     * Long aae035;// 变更时间
     * String aae160;// 变更原因
     * <p>
     * ResidentStopResult,该类包含以下几个字段:
     * String BizSuccess;
     * String ErrorCode;
     * String Message;
     */
    @Test
    public void test2() {
        ResidentStopParam p = new ResidentStopParam();
        p.setAac001(100000000280144L);
        p.setAab001(100000000280137L);
        p.setAae035(20160101L);
        p.setAae160("1234");
        ResidentStopResult o = service2.dubboResidentStop(p);
        out(o);
    }

    /**
     * 居民参保登记
     * <p>
     * ResidentRegisterParam,该类包含以下几个字段:
     * 单位信息
     * Long     aab001;    //单位编号
     * String   aab069;    //单位名称
     * String   aaf019;    //单位类型
     * 家庭信息ab54
     * Long     aaz067;     //家庭编号
     * String   aab400;     //户主姓名
     * String   hz_aac058;  //户主证件类型
     * String   hz_aac147;  //户主证件号码
     * 人员信息ac01
     * Long     aac001;     // ID
     * String   aac003;     // 姓名
     * String   aac058;     // 证件类型
     * String   aac147;     // 证件号码
     * String   aac004;     // 性别
     * String   aac005;     // 民族
     * <p>
     * Long     aac006;     // 出生日期
     * String   bac037;     //居民类别
     * String   bac938;     //居民特殊类别
     * String   bac078;     //特殊人员证件编号
     * String   aac069;     //与户主关系
     * <p>
     * String   aae004;     //联系人姓名
     * String   aae005;     //固定电话
     * String   aac067;     // 手机号码
     * String   aae006;     //联系地址
     * String   aae007;     //邮证编码
     * <p>
     * String   bac070;     //学籍证号
     * String   bac073;     //学院
     * String   bac075;     //专业
     * String   bac074;     //系
     * String   bac071;     //年级
     * <p>
     * String   bac072;     //班级
     * Long     bac076;     //入学年度
     * Long     bac977;     //毕业年度
     * String   bac979;     //新生儿标志
     * String   bac080;     //新生儿变更标志
     * <p>
     * String   bac085;     //水源保护区标识
     * String   bac087;     //水源保护区等级
     * String   bac086;     //水源保护区人员类型
     * String   aac042;     //监护人姓名
     * String   aac044;     //监护人证件号码
     * <p>
     * String   bac982;     //缴费方式
     * String   aac161;     //国家/地区代码
     * String   aac002;     //社会保障号码
     * String   aac999;     //个人编号
     * <p>
     * String   account;    //经办员
     * Long     aae035;     //变更日期
     * String   aae160;     //变更原因
     * String   aac050;     //变更类型
     * <p>
     * BankDTO paymentAccount;      //征缴银行账户
     * BankDTO withdrawAccount;     //发放银行账户
     * List<PersonDubboInsuranceDTO> personInsuranceDTOList;    //人员参保险种信息
     * List<OrgDubboInsuranceDTO> orgInsuranceDTOList;          //组织参保险种信息
     * <p>
     * 入参类中单位信息和家庭信息对应说明，如下：
     * 对应字段	    字段类型	        含义
     * AAB001	    NUMBER(16)	    单位编号
     * aab069	    VARCHAR2(100)	单位名称
     * aaf019	    VARCHAR2(3)	    单位类型
     * AAZ067	    NUMBER(16)	    家庭编号
     * AAB400	    VARCHAR2(50)	户主姓名
     * AAC058	    VARCHAR2(2)	    户主证件类型
     * AAC147	    VARCHAR2(20)	户主证件号码
     * <p>
     * 入参类中人员信息对应说明，如下：
     * 对应字段	字段类型	        字段含义
     * aac001	NUMBER(20)	    ID
     * aac003	VARCHAR2(50)	姓名
     * aac058	VARCHAR2(2)	    证件类型
     * aac147	VARCHAR2(22)	证件号码
     * aac004	VARCHAR2(1)	    性别
     * aac005	VARCHAR2(2)	    民族
     * aac006	NUMBER(8)	    出生日期
     * Bac037	VARCHAR2(3)	    居民类别
     * bac938	VARCHAR2(3)	    居民特殊类别
     * bac078	VARCHAR2(20)	特殊人员证件编号
     * aac069	VARCHAR2(3)	    与户主关系
     * aae004	VARCHAR2(50)	联系人姓名
     * aae005	VARCHAR2(40)	固定电话
     * aac067	VARCHAR2(11)	手机号码
     * aae006	VARCHAR2(150)	联系地址
     * aae007	VARCHAR2(6)	    邮证编码
     * bac070	VARCHAR2(40)	学籍证号
     * bac073	VARCHAR2(50)	学院
     * bac075	VARCHAR2(50)	专业
     * bac074	VARCHAR2(50)	系
     * bac071	VARCHAR2(20)	年级
     * bac072	VARCHAR2(100)	班级
     * bac076	NUMBER(4)	    入学年度
     * bac977	NUMBER(4)	    毕业年度
     * bac979	VARCHAR2(1)	    新生儿标志
     * bac080	VARCHAR2(1)	    新生儿变更标志
     * bac085	VARCHAR2(3)	    水源保护区标识
     * bac087	VARCHAR2(3)	    水源保护区等级
     * bac086	VARCHAR2(3)	    水源保护区人员类型
     * aac042	VARCHAR2(50)	监护人姓名
     * aac044	VARCHAR2(3)	    监护人证件号码
     * bac982	VARCHAR2(3)	    缴费方式
     * aac161	VARCHAR2(3)	    国家/地区代码
     * aac002	VARCHAR2(20)	社会保障号码
     * aac999	VARCHAR2(20)	个人编号
     * <p>
     * 入参类中personInsuranceDTOList中键值对的对应说明，如下
     * <p>
     * 对应字段	字段类型	        字段名称
     * AAC001	NUMBER(20)	    个人编号
     * AAE140	VARCHAR2(3)	    险种类型
     * AAC031	VARCHAR2(1)	    参保状态
     * AAC049	NUMBER(8)	    首次参保日期
     * AAC030	NUMBER(8)	    个人参保日期
     * AAB034	VARCHAR2(20)	经办机构编码
     * AAB004	VARCHAR2(200)	单位名称
     * <p>
     * 入参类中orgInsuranceDTOList中键值对的对应说明，如下
     * <p>
     * 对应字段	字段类型	        字段名称
     * AAE140	VARCHAR2(3)     险种类型
     * <p>
     * 入参类中paymentAccount中键值对的对应说明，如下
     * 对应字段	字段类型	        字段名称
     * AAE009	VARCHAR2(100)	银行户名
     * AAE010	VARCHAR2(40)	银行账号
     * AAF200	VARCHAR2(3)	    银行行别代码
     * <p>
     * 入参类中withdrawAccount中键值对的对应说明，如下
     * 对应字段	字段类型	        字段名称
     * AAE009	VARCHAR2(100)	银行户名
     * AAE010	VARCHAR2(40)	银行账号
     * AAF200	VARCHAR2(3)	    银行行别代码
     * 服务接口方法返回值类
     * ResidentRegisterResult
     * String BizSuccess;
     * String ErrorCode;
     * String Message;
     */
    @Test
    public void test3() {
        ResidentRegisterParam p = new ResidentRegisterParam();
        p.setAab001(100000000280137L);
        p.setAac003("小明");
        p.setAac058("01");
        p.setAac147("320321201601010073");
        p.setAac004("1");
        p.setAac005("01");
        p.setAac006(20160101L);
        ResidentRegisterResult o = service2.dubboResidentRegist(p);
        out(o);
    }

    /**
     * 人员参保登记
     * <p>
     * PersonManageDubboService
     * 接口方法：
     * public PersonInfoRegisterResult dubboRegisterPersonInfo (PersonInfoRegisterParam params);
     * 3.1.	服务接口交易号
     * NB_GTXT_GGYW_103
     * 3.2.	服务接口方法入参类
     * 提供
     * com.neusoft.sl.si.basicinfo.dubbo.employee.person.param.PersonInfoRegisterParam,该类包含以下几个字段:
     * 单位信息ab01
     * private String aab999; // 单位编号
     * private String aab004; // 单位名称
     * 人员信息ac01
     * private Long aac001;// ID
     * private String aac058; // 证件类型
     * private String aac147;// 证件号码
     * private String aac003;// 姓名
     * private String aac004;// 性别
     * private String aac005;// 民族
     * private Long aac006;// 出生日期
     * private Long aac007;// 参加工作日期
     * private String aac020;// 行政职务
     * private String aac014;// 专业技术职务
     * private String aac015;// 国家职业资格等级（工人技术等级）
     * private String aac084;// 离退休状态
     * private Long aic162;// 离退休日期
     * private String aac012;// 个人身份
     * private String aac009;// 户口性质
     * private String aac019;// 特殊工种名称
     * private Integer workMonths;// 工龄(月)
     * private String aac013;// 用工形式
     * private String bac014;// 公务员标志
     * private String retiredSoldier;// 退役军人标志
     * private String bac137;// 军残级别
     * private Long bac936;// 伤残军警身份年月
     * private String akc021;// 医疗人员类别
     * private String aac161;// 国家/地区代码
     * private String aac011;// 学历
     * private String aac067;// 手机号码
     * private String aae006;// 联系地址
     * private String aae159;// 邮箱
     * private String aae007;// 邮编
     * private String aae473;// 养老账户类别
     * private Long bac033;// 首次参加基本养老时间
     * private Long bac034;// 养老视同缴费月数
     * private String aac300;// 户口所在地行政区划
     * private String aac010;// 户口所在地地址
     * private String aac002;//社会保障号码
     * private String aac999;//个人编号
     * 变更信息
     * private Long aae035;// 变更日期
     * private String aae160;// 变更原因
     * 人员参保险种信息
     * private String aae140;// 参保险种
     * private Long aac030;// 参保日期
     * private String aac031;// 参保状态
     * private List<PersonDubboInsuranceDTO> personInsuranceDTOList = new ArrayList<PersonDubboInsuranceDTO>();
     * 入参类中人员信息对应说明，如下：
     * 对应字段	字段类型	字段名称
     * BAZ002	NUMBER(16)	操作序号
     * AAC001	NUMBER(16)	电脑编号
     * AAC999	VARCHAR2(20)	个人管理码
     * AAC003	VARCHAR2(50)	姓名
     * AAC002	VARCHAR2(18)	社会保障号码
     * AAC058	VARCHAR2(2)	证件类型
     * AAC147	VARCHAR2(22)	证件号码
     * AAC004	VARCHAR2(1)	性别
     * AAC005	VARCHAR2(2)	民族
     * AAC006	NUMBER(8)	出生日期
     * AAC007	NUMBER(8)	参加工作时间
     * AAC009	VARCHAR2(2)	户口性质
     * AAC161	VARCHAR2(3)	国家/地区代码
     * AAC011	VARCHAR2(2)	文化程度
     * AAC012	VARCHAR2(2)	个人身份
     * AAC013	VARCHAR2(1)	用工形式
     * AAC014	VARCHAR2(1)	专业技术职务级别
     * AAC015	VARCHAR2(1)	国家职业资格等级（工人技术等级）
     * AAC017	VARCHAR2(2)	婚姻状况
     * AAC019	VARCHAR2(1)	特殊工种类别
     * AAC020	VARCHAR2(3)	行政职务级别
     * AAC024	VARCHAR2(2)	政治面貌
     * AAC028	VARCHAR2(1)	农民工标识
     * AAC084	VARCHAR2(1)	离退休状态
     * AIC162	NUMBER(8)	离退休日期
     * AKC021	VARCHAR2(2)	医疗人员类别
     * AAE138	NUMBER(8)	死亡日期
     * AAE473	VARCHAR2(3)	养老账户类别
     * AAZ500	VARCHAR2(40)	社会保障卡卡号
     * BAE500	VARCHAR2(1)	公安比对标志
     * AAE004	VARCHAR2(50)	联系人
     * AAE005	VARCHAR2(40)	固定电话
     * AAC067	VARCHAR2(11)	手机号码
     * AAC300	VARCHAR2(20)	户口所在地行政区划代码
     * AAC010	VARCHAR2(150)	户口所在地详细地址
     * AAC301	VARCHAR2(20)	常住地行政区划代码
     * AAE006	VARCHAR2(150)	常住地详细地址
     * AAE007	VARCHAR2(6)	邮政编码
     * AAC042	VARCHAR2(50)	监护人姓名
     * AAC043	VARCHAR2(2)	监护人证件类型
     * AAC044	VARCHAR2(22)	监护人证件号码
     * BAC062	VARCHAR2(3)	人员登记状态
     * BAC031	VARCHAR2(1)	公务员标志
     * BAC032	VARCHAR2(1)	军转人员标志
     * BAC033	NUMBER(8)	首次参加基本养老时间
     * BAC034	NUMBER(3)	养老视同缴费月数
     * BAC935	VARCHAR2(1)	军残级别
     * BAC936	NUMBER(6)	伤残军警身份年月
     * BAC037	VARCHAR2(3)	居民类别
     * BAC938	VARCHAR2(3)	居民特殊类别
     * BAC939	VARCHAR2(20)	特殊人员证件编号
     * AAC069	VARCHAR2(3)	与户主关系
     * BAC070	VARCHAR2(40)	学籍证号
     * BAC071	VARCHAR2(20)	年级
     * BAC072	VARCHAR2(100)	班级
     * BAC073	VARCHAR2(50)	学院
     * BAC074	VARCHAR2(50)	系
     * BAC075	VARCHAR2(50)	专业
     * BAC076	NUMBER(4)	入学年度
     * BAC977	NUMBER(4)	毕业年度
     * BAC078	VARCHAR2(1)	嫁入女入赘男
     * BAC979	VARCHAR2(1)	新生儿标志
     * BAC080	VARCHAR2(1)	新生儿变更标志
     * BAC081	VARCHAR2(3)	本地化-备用
     * BAC982	VARCHAR2(3)	本地化-备用
     * BAC083	VARCHAR2(3)	本地化-备用
     * BAC084	VARCHAR2(3)	本地化-备用
     * BAC085	VARCHAR2(3)	本地化-备用
     * BAC086	VARCHAR2(3)	本地化-备用
     * BAC087	VARCHAR2(3)	本地化-备用
     * BAC088	VARCHAR2(3)	本地化-备用
     * BAC089	VARCHAR2(3)	本地化-备用
     * BAC090	VARCHAR2(3)	本地化-备用
     * BAC091	VARCHAR2(3)	本地化-备用
     * BAC092	VARCHAR2(3)	本地化-备用
     * BAC093	VARCHAR2(3)	本地化-备用
     * BAC094	VARCHAR2(3)	本地化-备用
     * BAC095	VARCHAR2(3)	本地化-备用
     * BAC096	VARCHAR2(3)	本地化-备用
     * BAC097	VARCHAR2(3)	本地化-备用
     * BAC098	VARCHAR2(3)	本地化-备用
     * BAC899	VARCHAR2(3)	本地化-备用
     * BAC100	VARCHAR2(3)	本地化-备用
     * AAE013	VARCHAR2(200)	备注
     * BAE016	VARCHAR2(50)	创建人
     * BAE017	NUMBER(14)	创建时间
     * BAE018	VARCHAR2(16)	创建机构编码
     * AAE011	VARCHAR2(50)	经办人
     * AAE036	NUMBER(14)	经办时间
     * AAB034	VARCHAR2(16)	社会保险经办机构编码
     * AAA027	VARCHAR2(6)	统筹区编码
     * <p>
     * 入参类中personInsuranceDTOList中键值对的对应说明，如下
     * 对应字段	字段类型	字段名称
     * AAC001	NUMBER(20)	个人编号
     * AAE140	VARCHAR2(3)	险种类型
     * AAC031	VARCHAR2(1)	参保状态
     * AAC049	NUMBER(8)	首次参保日期
     * AAC030	NUMBER(8)	个人参保日期
     * AAB034	VARCHAR2(20)	经办机构编码
     * AAB004	VARCHAR2(200)	单位名称
     * <p>
     * 3.3.	服务接口方法返回值类
     * com.neusoft.sl.si.basicinfo.dubbo.employee.person.result.PersonInfoRegisterResult,该类包含以下几个字段:
     * private String BizSuccess;
     * private String ErrorCode;
     * private String Message;
     */
    @Test
    public void test33() {
        PersonInfoRegisterParam p = new PersonInfoRegisterParam();
//        p.setAab001("1234567");
        p.setAac003("小明");
        p.setAac058("01");
        p.setAac147("320321201601020073");
        p.setAac004("1");
        p.setAac005("01");
        p.setAac006(20160102L);
        p.setAac007(20160103L);
        p.setAac084("1");
        p.setAac009("1");
        p.setAac013("1");
        p.setAac161("CHN");
        p.setAac067("12345678901");

        p.setAae473("1");
        p.setAac300("1202100000000001");

        p.setAae035(20160102L);
        p.setAae160("11");
        PersonDubboInsuranceDTO per = new PersonDubboInsuranceDTO();
        per.setAae140("110");
        per.setAac030(20160101L);
        per.setAac031("1");
        p.setPersonInsuranceDTOList(Lists.newArrayList(per));
        PersonInfoRegisterResult o = service5.dubboRegisterPersonInfo(p);
        out(o);
    }

    /**
     * 发送临时账户通知书
     * <p>
     * 服务接口方法入参类
     * 提供
     * com.neusoft.sl.si.settle.dubbo.pension.param. TempActMsgSendParam,该类包含以下几个字段:
     * <p>
     * <p>
     * private TempActMsg tempActMsgDTO
     * 列名	类型	注释	英文翻译
     * AAZ341	VARCHAR2(18)	系统跟踪流水号	sysTraceId
     * AAB301	VARCHAR2(6)	转入地行政区划代码	srcAgencyState
     * AAB299	VARCHAR2(6)	转出地行政区划代码	tgtAgencyState
     * AAE270	VARCHAR2(70)	联系函编号	noticeNumber
     * BAC999	VARCHAR2(20)	转出地个人编号	formerPersonNumber
     * AAC001	NUMBER(20)	个人编号	personId
     * AAC999	VARCHAR2(20)	个人管理码	personNumber
     * AAC002	VARCHAR2(20)	社会保障号码	socialEnsureNumber
     * AAC003	VARCHAR2(50)	姓名	name
     * AAC004	VARCHAR2(1)	性别	sex
     * AAC006	NUMBER(8)	出生日期	birthday
     * AAC010	VARCHAR2(150)	户籍地地址	householdAddress
     * AAB004	VARCHAR2 (8)	原工作单位名称	srcUnitName
     * BAC999	VARCHAR2(20)	转出地原个人编码	formerPersonNumber
     * AAE004	VARCHAR2(10)	新就业地社保机构联系人	agencyContactPerson
     * AAE005	VARCHAR2(50)	新就业地社保机构联系电话	agencyPhone
     * AAB300	VARCHAR2(200)	新就业地社保机构名称	transferInAgencyName
     * AAA146	VARCHAR2(200)	转出地社保机构名称	transferOutAgencyName
     * AAZ198	NUMBER(18)	对方养老转移经办机构流水号	nationAgencyId
     * CAE037	VARCHAR2(3)	是否联网下载	onlineDownload
     * CZE111	VARCHAR2(50)	经办人(本地化-上传方)	uploadOperator
     * BZE136	NUMBER(8)	经办时间(本地化-上传方)	uploadOperateTime
     * AAE013	VARCHAR2(150)	备注	remark
     * AAE011	VARCHAR2(50)	经办人	operator
     * AAE036	NUMBER(14)	经办时间	operateTime
     * BAE016	VARCHAR2(50)	创建人	creater
     * BAE017	NUMBER(14)	创建时间	createrTime
     * <p>
     * private PersonBaseInfo personBaseInfoDTO;// 个人基本信息
     * AAC001	NUMBER(20)	个人编号	personId
     * AAC999	VARCHAR2(20)	个人管理码	personNumber
     * AAC002	VARCHAR2(20)	社会保障号码	socialEnsureNumber
     * AAC003	VARCHAR2(50)	姓名	name
     * AAC004	VARCHAR2(1)	性别	sex
     * AAC006	NUMBER(8)	出生日期	birthday
     * AAC010	VARCHAR2(150)	户籍地地址	householdAddress
     * <p>
     * private UnitBaseInfo unitBaseInfoDTO;// 单位基本信息
     * AAB999	VARCHAR2(20)	单位管理码	unitManagedNumber
     * AAB004	VARCHAR2(200)	单位名称	name
     * AAB019	VARCHAR2(2)	单位类型	unitType
     * <p>
     * <p>
     * 1.3服务接口方法返回值类
     * com.neusoft.sl.si.settle.dubbo.pension.result. TempActMsgSendResult,该类包含以下几个字段:
     * private String BizSuccess;
     * private String ErrorCode;
     * private String Message;
     * private TempActMsg tempActMsgDTO
     * 列名	类型	注释	英文翻译
     * AAZ341	VARCHAR2(18)	系统跟踪流水号	sysTraceId
     * AAB301	VARCHAR2(6)	转入地行政区划代码	srcAgencyState
     * AAB299	VARCHAR2(6)	转出地行政区划代码	tgtAgencyState
     * AAE270	VARCHAR2(70)	联系函编号	noticeNumber
     * BAC999	VARCHAR2(20)	转出地个人编号	formerPersonNumber
     * AAC001	NUMBER(20)	个人编号	personId
     * AAC999	VARCHAR2(20)	个人管理码	personNumber
     * AAC002	VARCHAR2(20)	社会保障号码	socialEnsureNumber
     * AAC003	VARCHAR2(50)	姓名	name
     * AAC004	VARCHAR2(1)	性别	sex
     * AAC006	NUMBER(8)	出生日期	birthday
     * AAC010	VARCHAR2(150)	户籍地地址	householdAddress
     * AAB004	VARCHAR2 (8)	原工作单位名称	srcUnitName
     * BAC999	VARCHAR2(20)	转出地原个人编码	formerPersonNumber
     * AAE004	VARCHAR2(10)	新就业地社保机构联系人	agencyContactPerson
     * AAE005	VARCHAR2(50)	新就业地社保机构联系电话	agencyPhone
     * AAB300	VARCHAR2(200)	新就业地社保机构名称	transferInAgencyName
     * AAA146	VARCHAR2(200)	转出地社保机构名称	transferOutAgencyName
     * AAZ198	NUMBER(18)	对方养老转移经办机构流水号	nationAgencyId
     * CAE037	VARCHAR2(3)	是否联网下载	onlineDownload
     * CZE111	VARCHAR2(50)	经办人(本地化-上传方)	uploadOperator
     * BZE136	NUMBER(8)	经办时间(本地化-上传方)	uploadOperateTime
     * AAE013	VARCHAR2(150)	备注	remark
     * AAE011	VARCHAR2(50)	经办人	operator
     * AAE036	NUMBER(14)	经办时间	operateTime
     * BAE016	VARCHAR2(50)	创建人	creater
     * BAE017	NUMBER(14)	创建时间	createrTime
     */
    @Test
    public void test4() {
        PersonBaseInfo personBaseInfoDTO = new PersonBaseInfo();
        personBaseInfoDTO.setPersonId(100000000980234l);
        personBaseInfoDTO.setHouseholdAddress("kijooo");
        personBaseInfoDTO.setTransferAccountType("1");

        TempActMsg tempActMsg = new TempActMsg();
        tempActMsg.setNoticeNumber("12341111");
        tempActMsg.setSrcAgencyState("110112");
        tempActMsg.setPersonId(100000000980234l);
        tempActMsg.setPersonNumber("100000000980235");
        tempActMsg.setSocialEnsureNumber("100000000980235");
        tempActMsg.setName("alice");
        tempActMsg.setSex("1");
        tempActMsg.setBirthday(19980112l);
        tempActMsg.setHouseholdAddress("jilin");
        tempActMsg.setSrcUnitName("jilin");
        tempActMsg.setFormerPersonNumber("100000000980235");
        tempActMsg.setTransferInAgencyName("jilin");
        tempActMsg.setTransferOutAgencyName("sy");
        tempActMsg.setNationAgencyId(118990l);
        tempActMsg.setAgencyContactPerson("lojic");
        tempActMsg.setAgencyPhone("18245434565");
        tempActMsg.setRemark("hehe");
        tempActMsg.setTgtAgencyState("190210");
        tempActMsg.setOnlineDownload("0");

        UnitBaseInfo unitBaseInfoDTO = new UnitBaseInfo();
        unitBaseInfoDTO.setUnitManagedNumber("000002");
        unitBaseInfoDTO.setName("测试单位1");
        unitBaseInfoDTO.setUnitType("10");

        TempActMsgSendParam p = new TempActMsgSendParam();
        p.setPersonBaseInfoDTO(personBaseInfoDTO);
        p.setUnitBaseInfoDTO(unitBaseInfoDTO);
        p.setTempActMsgDTO(tempActMsg);
        TempActMsgSendResult o = service3.dubboExecuteSetupTempActNote(p);
        out(o);
    }

    /**
     * 接收临时账户通知书
     * <p>
     * TempActMsgAcceptParam,该类包含以下几个字段:
     * <p>
     * private TempActMsg tempActMsgDTO
     * 列名	    类型	注释	英文翻译
     * AAZ341	    VARCHAR2(18)    系统跟踪流水号	        sysTraceId
     * AAB301	    VARCHAR2(6)	    转入地行政区划代码	        srcAgencyState
     * AAB299	    VARCHAR2(6)	    转出地行政区划代码	        tgtAgencyState
     * AAE270	    VARCHAR2(70)    联系函编号               noticeNumber
     * BAC999	    VARCHAR2(20)    转出地个人编号            formerPersonNumber
     * AAC001	    NUMBER(20)	    个人编号                 personId
     * AAC999	    VARCHAR2(20)    个人管理码               personNumber
     * AAC002	    VARCHAR2(20)    社会保障号码              socialEnsureNumber
     * AAC003	    VARCHAR2(50)    姓名	                    name
     * AAC004	    VARCHAR2(1)	    性别	                    sex
     * AAC006	    NUMBER(8)	    出生日期	                birthday
     * AAC010	    VARCHAR2(150)   户籍地地址	            householdAddress
     * AAB004	    VARCHAR2 (8)    原工作单位名称	        srcUnitName
     * BAC999	    VARCHAR2(20)    转出地原个人编码	        formerPersonNumber
     * AAE004	    VARCHAR2(10)    新就业地社保机构联系人	    agencyContactPerson
     * AAE005	    VARCHAR2(50)    新就业地社保机构联系电话	agencyPhone
     * AAB300	    VARCHAR2(200)   新就业地社保机构名称	    transferInAgencyName
     * AAA146	    VARCHAR2(200)   转出地社保机构名称	        transferOutAgencyName
     * AAZ198	    NUMBER(18)	    对方养老转移经办机构流水号	nationAgencyId
     * CAE037	    VARCHAR2(3)	    是否联网下载	            onlineDownload
     * CZE111	    VARCHAR2(50)    经办人(本地化-上传方)	    uploadOperator
     * BZE136	    NUMBER(8)	    经办时间(本地化-上传方)	uploadOperateTime
     * AAE013	    VARCHAR2(150)   备注	                    remark
     * AAE011	    VARCHAR2(50)    经办人	                operator
     * AAE036	    NUMBER(14)	    经办时间	                operateTime
     * BAE016	    VARCHAR2(50)    创建人	                creater
     * BAE017	    NUMBER(14)	    创建时间	                createrTime
     * <p>
     * private PersonBaseInfo personBaseInfoDTO;// 个人基本信息
     * AAC001	    NUMBER(20)	    个人编号	    personId
     * AAC999	    VARCHAR2(20)	个人管理码	personNumber
     * AAC002	    VARCHAR2(20)	社会保障号码	socialEnsureNumber
     * AAC003	    VARCHAR2(50)	姓名	        name
     * AAC004	    VARCHAR2(1)	    性别	        sex
     * AAC006	    NUMBER(8)	    出生日期	    birthday
     * AAC010	    VARCHAR2(150)	户籍地地址	householdAddress
     * <p>
     * private UnitBaseInfo unitBaseInfoDTO;// 单位基本信息
     * AAB999	    VARCHAR2(20)	单位管理码	unitManagedNumber
     * AAB004	    VARCHAR2(200)	单位名称	    name
     * AAB019	    VARCHAR2(2)	    单位类型	    unitType
     * <p>
     * 2.3服务接口方法返回值类
     * <p>
     * TempActMsgAcceptResult,该类包含以下几个字段:
     * String       BizSuccess;
     * String       ErrorCode;
     * String       Message;
     * TempActMsg   tempActMsgDTO
     * 列名	    类型	            注释	英文翻译
     * AAZ341	VARCHAR2(18)	系统跟踪流水号	        sysTraceId
     * AAB301	VARCHAR2(6)	    转入地行政区划代码	        srcAgencyState
     * AAB299	VARCHAR2(6)	    转出地行政区划代码        tgtAgencyState
     * AAE270	VARCHAR2(70)	联系函编号	            noticeNumber
     * BAC999	VARCHAR2(20)	转出地个人编号	        formerPersonNumber
     * AAC001	NUMBER(20)	    个人编号	                personId
     * AAC999	VARCHAR2(20)	个人管理码	            personNumber
     * AAC002	VARCHAR2(20)	社会保障号码	            socialEnsureNumber
     * AAC003	VARCHAR2(50)	姓名	                    name
     * AAC004	VARCHAR2(1)	    性别	                    sex
     * AAC006	NUMBER(8)	    出生日期	                birthday
     * AAC010	VARCHAR2(150)	户籍地地址	            householdAddress
     * AAB004	VARCHAR2 (8)	原工作单位名称	        srcUnitName
     * BAC999	VARCHAR2(20)	转出地原个人编码	        formerPersonNumber
     * AAE004	VARCHAR2(10)	新就业地社保机构联系人	    agencyContactPerson
     * AAE005	VARCHAR2(50)	新就业地社保机构联系电话	agencyPhone
     * AAB300	VARCHAR2(200)	新就业地社保机构名称	    transferInAgencyName
     * AAA146	VARCHAR2(200)	转出地社保机构名称	        transferOutAgencyName
     * AAZ198	NUMBER(18)	    对方养老转移经办机构流水号	nationAgencyId
     * CAE037	VARCHAR2(3)	    是否联网下载	            onlineDownload
     * CZE111	VARCHAR2(50)	经办人(本地化-上传方)	    uploadOperator
     * BZE136	NUMBER(8)	    经办时间(本地化-上传方)	uploadOperateTime
     * AAE013	VARCHAR2(150)	备注                     remark
     * AAE011	VARCHAR2(50)	经办人	                operator
     * AAE036	NUMBER(14)	    经办时间	                operateTime
     * BAE016	VARCHAR2(50)	创建人	                creater
     * BAE017	NUMBER(14)	    创建时间	                createrTime
     */
    @Test
    public void test5() {
        PersonBaseInfo personBaseInfoDTO = new PersonBaseInfo();
        personBaseInfoDTO.setPersonId(200000000980242l);
        personBaseInfoDTO.setHouseholdAddress("kijooo");
        personBaseInfoDTO.setTransferAccountType("1");

        TempActMsg tempActMsg = new TempActMsg();
        tempActMsg.setNoticeNumber("22345671118");
        tempActMsg.setSrcAgencyState("110112");
        tempActMsg.setPersonId(200000000980242l);
        tempActMsg.setPersonNumber("200000000980242");
        tempActMsg.setSocialEnsureNumber("200000000980242");
        tempActMsg.setName("alice");
        tempActMsg.setSex("1");
        tempActMsg.setBirthday(19980112l);
        tempActMsg.setHouseholdAddress("jilin");
        tempActMsg.setSrcUnitName("jilin");
        tempActMsg.setFormerPersonNumber("200000000980242");
        tempActMsg.setTransferInAgencyName("jilin");
        tempActMsg.setTransferOutAgencyName("sy");
        tempActMsg.setNationAgencyId(118990l);
        tempActMsg.setAgencyContactPerson("lojic");
        tempActMsg.setAgencyPhone("18245434565");
        tempActMsg.setRemark("hehe");
        tempActMsg.setTgtAgencyState("190210");
        tempActMsg.setOnlineDownload("0");


        UnitBaseInfo unitBaseInfoDTO = new UnitBaseInfo();
        unitBaseInfoDTO.setUnitManagedNumber("000002");
        unitBaseInfoDTO.setName("测试单位1");
        unitBaseInfoDTO.setUnitType("10");

        TempActMsgAcceptParam p = new TempActMsgAcceptParam();
        p.setPersonBaseInfoDTO(personBaseInfoDTO);
        p.setUnitBaseInfoDTO(unitBaseInfoDTO);
        p.setTempActMsgDTO(tempActMsg);

        TempActMsgAcceptResult o = service4.dubboExecuteAcceptSetupTempActNote(p);
        out(o);
    }


    /**
     * 养老缴费历史信息补录( 单个 、批量 )
     */
    @Test
    public void test6() {
        FeeHistoryMakeupParam acc2 = new FeeHistoryMakeupParam();

        acc2.setAac001(411l);
        //单位部分缴费基数

        acc2.setBae180(new BigDecimal(1000));
        //单位缴费比例
        acc2.setAaa042(new BigDecimal(0.6));
        //单位划拨比例
        acc2.setAaa043(new BigDecimal(0.4));
        //设置单位应缴统筹

        //设置单位应缴划入账户

        //设置单位实缴统筹

        //设置单位实缴划入账户

        //个人部分缴费基数
        acc2.setAae180(new BigDecimal(1000));
        //个人缴费比例
        acc2.setAaa041(new BigDecimal(0.6));
        //个人划拨比例
        acc2.setAaa045(new BigDecimal(0.4));
        //设置个人应缴统筹

        //设置个人应缴划入账户

        //设置个人实缴统筹

        //设置个人实缴划入账户

        //缴费类型
        acc2.setAaa115("10");
        //实收年月
        acc2.setAae150(201611);
        //缴费主体类型
        acc2.setBae165("2");
        //参保组织编号

        acc2.setAab001((long) 411423);

        //险种类型
        acc2.setAae140("110");
        //结算期
        acc2.setAae002(201610);
        //费款所属期
        acc2.setAae003(201610);
        //缴费大类
        acc2.setBae230("1");
        //基金来源
        acc2.setBae151("2");
        //离退休状态
        acc2.setAac084("1");
        //操作序号

        //给baz221赋值（核定流水号）


        FeeHistoryMakeupResult fee = service6.saveOnePensionHistoryFeeInfo(acc2);
        out(fee);


        FeeHistoryMakeupParam fmp = new FeeHistoryMakeupParam();

        fmp.setAac001(411l);//参保组织编号
        fmp.setAab001(411423l);
             /*fmp.setBae180(new BigDecimal(100));
        	 fmp.setAae081(new BigDecimal(100));
        	 fmp.setAae082(new BigDecimal(100));
        	 fmp.setAae180(new BigDecimal(100));
        	 fmp.setAae080(new BigDecimal(100));
        	 fmp.setAae083(new BigDecimal(100));
        	 fmp.setAaa115("10");
        	 fmp.setAae150(201609);
        	 fmp.setBae165("2");*/

        fmp.setStartTime(201608);

        fmp.setEndTime(201608);
        //险种类型
        fmp.setAae140("110");
        //结算期
        	/* fmp.setAae002(201608);
			//费款所属期
        	 fmp.setAae003(201608);
			//缴费大类
        	 fmp.setBae230("1");
			//基金来源
        	 fmp.setBae151("11");
			//离退休状态
        	 fmp.setAac084("1");*/

        FeeHistoryMakeupResult o = service6.savePensionHistoryFeeInfo(fmp);
        out(o);
    }
}
