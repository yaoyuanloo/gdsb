package com.fortunes.test.dongruan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortunes.test.DubboTest;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.param.PersonDubboInsuranceDTO;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.param.PersonParamDubboDTO;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.result.PersonResultDubboListDTO;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.service.PersonDubboService;
import com.neusoft.sl.si.basicinfo.dubbo.employee.person.service.PersonManageDubboService;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.param.OrgDubboInsuranceDTO;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.param.ResidentBatchImportDTO;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.param.ResidentListParamDTO;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.param.ResidentParamDTO;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.param.ResidentRegisterParam;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.param.ResidentStopParam;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.result.ResidentListResultDTO;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.result.ResidentRegisterResult;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.result.ResidentResultDTO;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.result.ResidentStopResult;
import com.neusoft.sl.si.basicinfo.dubbo.resident.person.service.ResidentManageDubboService;
import com.neusoft.sl.si.collection.dubbo.employee.feehistory.param.FeeHistoryMakeupParam;
import com.neusoft.sl.si.collection.dubbo.employee.feehistory.result.FeeHistoryMakeupResult;
import com.neusoft.sl.si.collection.dubbo.employee.feehistory.service.FeeHistoryMakeupDubboService;
import com.neusoft.sl.si.collection.dubbo.employee.oncefee.param.ParamQueryOf37And13Supply;
import com.neusoft.sl.si.collection.dubbo.employee.oncefee.result.ResultQueryOf37And13Supply;
import com.neusoft.sl.si.collection.dubbo.employee.oncefee.service.DubboOnceFeePensionBPO;
import com.neusoft.sl.si.collection.dubbo.employee.query.param.FeeInfoQueryParam;
import com.neusoft.sl.si.collection.dubbo.employee.query.result.FeeInfoQueryResult;
import com.neusoft.sl.si.collection.dubbo.employee.query.service.PersonOnceFeeInfoQueryDubboService;
import com.neusoft.sl.si.settle.dubbo.common.param.BankAccount;
import com.neusoft.sl.si.settle.dubbo.common.param.PersonBaseInfo;
import com.neusoft.sl.si.settle.dubbo.common.param.SettleInfoParam;
import com.neusoft.sl.si.settle.dubbo.common.param.UnitBaseInfo;
import com.neusoft.sl.si.settle.dubbo.common.result.SettleInfoResultItems;
import com.neusoft.sl.si.settle.dubbo.common.service.GetSettleInfoItemService;
import com.neusoft.sl.si.settle.dubbo.medicare.param.MedApplyForm;
import com.neusoft.sl.si.settle.dubbo.medicare.param.MedCertificate;
import com.neusoft.sl.si.settle.dubbo.medicare.param.MedCertificatePrintParam;
import com.neusoft.sl.si.settle.dubbo.medicare.param.MedContactNote;
import com.neusoft.sl.si.settle.dubbo.medicare.param.MedSettleInfoParam;
import com.neusoft.sl.si.settle.dubbo.medicare.result.MedCertificateResult;
import com.neusoft.sl.si.settle.dubbo.medicare.result.MedSettleInfoResult;
import com.neusoft.sl.si.settle.dubbo.medicare.service.SaveMedCertificateDubboService;
import com.neusoft.sl.si.settle.dubbo.medicare.service.SaveMedSettleInfoDubboService;
import com.neusoft.sl.si.settle.dubbo.pension.param.ProvApplyForm;
import com.neusoft.sl.si.settle.dubbo.pension.param.ProvCertificate;
import com.neusoft.sl.si.settle.dubbo.pension.param.ProvContactNote;
import com.neusoft.sl.si.settle.dubbo.pension.param.ProvPensionCertificateParam;
import com.neusoft.sl.si.settle.dubbo.pension.param.ProvPensionSettleInApplyParam;
import com.neusoft.sl.si.settle.dubbo.pension.result.ProvPensionCertificateResult;
import com.neusoft.sl.si.settle.dubbo.pension.result.ProvPensionSettleInApplyResult;
import com.neusoft.sl.si.settle.dubbo.pension.service.SaveProvCertificateDubboService;
import com.neusoft.sl.si.settle.dubbo.pension.service.SaveProvPensionContactNoteDubboService;
import com.neusoft.sl.si.settle.dubbo.unemploy.param.UnemployAppliedFormParam;
import com.neusoft.sl.si.settle.dubbo.unemploy.param.UnemployCertificateParam;
import com.neusoft.sl.si.settle.dubbo.unemploy.param.UnemployCertificatePrintParam;
import com.neusoft.sl.si.settle.dubbo.unemploy.param.UnemployContactNoteParam;
import com.neusoft.sl.si.settle.dubbo.unemploy.param.UnemployContactNotePrintParam;
import com.neusoft.sl.si.settle.dubbo.unemploy.param.UnemployRecordSummaryParam;
import com.neusoft.sl.si.settle.dubbo.unemploy.result.UnemployCertificatePrintResult;
import com.neusoft.sl.si.settle.dubbo.unemploy.result.UnemployContactNotePrintResult;
import com.neusoft.sl.si.settle.dubbo.unemploy.service.SaveUnemployCertificateDubboService;
import com.neusoft.sl.si.settle.dubbo.unemploy.service.SaveUnemployNoteDubboService;


/**
 * Created by cxd on 2016/10/25 0025.
 */
public class DRTest extends DubboTest {

	@Autowired
	DubboOnceFeePensionBPO dubboOnceFeePension;
	
	/*@Autowired
	UnitDubboService unitDubboService;*/
	
	/*@Autowired
	UnemployFundWithholdMedicalQueryDubboService unemployFundWithhold;*/
	
	@Autowired
	SaveProvPensionContactNoteDubboService saveProvPension;

	@Autowired
	SaveMedSettleInfoDubboService saveMedSettleInfo;
	
	
	@Autowired
	SaveMedCertificateDubboService certificate;
	
	@Autowired
	SaveProvCertificateDubboService saveProvCertificate;
	
	
	@Autowired
	PersonDubboService personDubbo;
	
	
	@Autowired
	FeeHistoryMakeupDubboService feeHistoryMakeup;
	
	
	
	
	
	@Autowired
	PersonOnceFeeInfoQueryDubboService PersonOnceFeeInfo;
	
	@Autowired
	SaveUnemployNoteDubboService saveUnemployNote;
	
	@Autowired
	SaveUnemployCertificateDubboService saveUnemployCerti;
	
	@Autowired
	GetSettleInfoItemService getSettleInfoItem;
	
	
	@Autowired
	ResidentManageDubboService residentManage;
	
	
	@Autowired
	PersonManageDubboService person;
	
	
	@Autowired
	DubboOnceFeePensionBPO dubb;
	/*
	 * 东软 粤人社发[2011]37号文趸缴
	 */
    public void t1(){
    	ParamQueryOf37And13Supply p=new ParamQueryOf37And13Supply();
    	p.setAac999("65437");
    	ResultQueryOf37And13Supply rf=dubboOnceFeePension.queryBasicInfoOf37FilesOnceFeeSupply(p);
    	System.out.println(rf.getMessage());
    }
    
    
    /*
	 * 失业金代缴医疗保险信息查询(已通)
	 * 入参://缴费标志
		private String bae152;
		//开始年月
	    private Integer begin;
	    //终止年月
	    private Integer end;
	    //非类型
	    private String aaa115;
	    //个人编号
	    private Long aac001;
	    //单位编号
	    private Long aab001;
	    //险种类型
	    private String aae140;
	    //基金来源
	    private String bae151;
	 */
    
    public void t2(){
    	/*FeeInfoQueryParam fp=new FeeInfoQueryParam();
    	fp.setAac001(218l);
    	FeeInfoQueryResult fr=unemployFundWithhold.queryUnemployFundWithholdMedical(fp);
    	System.out.println(fr.getMessage());*/
    }
    
    /*
	 * 省内转入申请（联系函出具）(已通)
	 */
    public void t3(){
    	ProvPensionSettleInApplyParam ppsa=new ProvPensionSettleInApplyParam();
    	 PersonBaseInfo personBaseInfo = new PersonBaseInfo();
         personBaseInfo.setBirthday(19990909l);
         personBaseInfo.setComment("commment");
         personBaseInfo.setName("testt");
         personBaseInfo.setPersonId(1000212l);
         personBaseInfo.setPersonNumber("12221112121");
         personBaseInfo.setSex("1");
         personBaseInfo.setSocialEnsureNumber("1121211112");
         personBaseInfo.setTransferAccountType("1");
         UnitBaseInfo unitBaseInfo = new UnitBaseInfo();
         unitBaseInfo.setName("unitname");
         unitBaseInfo.setUnitNumber(1121l);
         unitBaseInfo.setUnitType("10");
         BankAccount bankAccount = new BankAccount(); 
         bankAccount.setBankType("11");
         bankAccount.setAccountName("1212");
         bankAccount.setAccountNumber("221212");
         ProvApplyForm provApplyForm = new ProvApplyForm();
         provApplyForm.setPersonId(personBaseInfo.getPersonId());
         ProvContactNote provContactNote = new ProvContactNote();
         provContactNote.setTgtAgencyState("129902");
         provContactNote.setPersonId(personBaseInfo.getPersonId());
         provContactNote.setChangeDate(20111111l);
         provContactNote.setSysTraceId("1212333244411");
         provContactNote.setSrcAgencyState("233212");
         ppsa.setBankAccount(bankAccount);
         ppsa.setPersonBaseInfo(personBaseInfo);
         ppsa.setUnitBase(unitBaseInfo);
         ppsa.setProvApplyForm(provApplyForm);
         ppsa.setProvContactNote(provContactNote);
    	 ProvPensionSettleInApplyResult pr=saveProvPension.dubboSaveProvPensionContactNote(ppsa);
    	 System.out.println(pr.getErrorCode());
    }
    
    
     /*
   	  * 医疗转入申请(已通)
   	  */
       public void t4(){
    	   PersonBaseInfo personBaseInfo = new PersonBaseInfo();
           personBaseInfo.setBirthday(19990909l);
           personBaseInfo.setComment("commment");
           personBaseInfo.setName("testt");
           personBaseInfo.setPersonId(1000212l);
           personBaseInfo.setPersonNumber("12221112121");
           personBaseInfo.setSex("1");
           personBaseInfo.setSocialEnsureNumber("1121211112");
           personBaseInfo.setTransferAccountType("1");
           UnitBaseInfo unitBaseInfo = new UnitBaseInfo();
           unitBaseInfo.setName("unitname");
           unitBaseInfo.setUnitNumber(1121l);
           unitBaseInfo.setUnitType("10");
           MedContactNote medContactNote= new MedContactNote();
           medContactNote.setContactNoteNumber("1");
           medContactNote.setTgtAgencyState("111111");
           medContactNote.setSocialEnsureNumber(personBaseInfo.getSocialEnsureNumber());
           medContactNote.setName(personBaseInfo.getName());
           medContactNote.setOriginalMedicalInsurance("310");
           medContactNote.setOriginalAgencyName("原参保地");
           medContactNote.setPersonId(personBaseInfo.getPersonId());
           medContactNote.setSrcAgencyState("129900");
           medContactNote.setSysTraceId("121212");
           medContactNote.setBirthday(19881010l);
           MedApplyForm applyForm= new MedApplyForm();
           applyForm.setName(personBaseInfo.getName());
           applyForm.setPersonId(personBaseInfo.getPersonId());
           applyForm.setSocialEnsureNumber(personBaseInfo.getSocialEnsureNumber());
           applyForm.setSex(personBaseInfo.getSex());
           applyForm.setOriginalAgencyState("129999");
           applyForm.setOriginalAgencyName("经办机构");
           applyForm.setSysTraceId("12121212121");
           applyForm.setOriginalAgencyStateName("代理");
           MedSettleInfoParam medSettleInfoParam=new MedSettleInfoParam();
           medSettleInfoParam.setBusinessID("UCA321");
           medSettleInfoParam.setPersonBaseInfo(personBaseInfo);
           medSettleInfoParam.setUnitBaseInfo(unitBaseInfo);
           medSettleInfoParam.setMedApplyFormParam(applyForm);
           medSettleInfoParam.setMedContactNoteParam(medContactNote);
           MedSettleInfoResult mr= saveMedSettleInfo.dubboSaveMedSettleInfo(medSettleInfoParam);
           System.out.println("mr:"+mr.getErrorCode());
          
       }
       
       
         /*
     	  * .医疗缴费凭证打印(已通)
     	  */
         public void t5(){
        	 PersonBaseInfo personBaseInfo = new PersonBaseInfo();
             personBaseInfo.setBirthday(19990909l);
             personBaseInfo.setComment("commment");
             personBaseInfo.setName("testt");
             personBaseInfo.setPersonId(1000212l);
             personBaseInfo.setPersonNumber("12221112121");
             personBaseInfo.setSex("1");
             personBaseInfo.setSocialEnsureNumber("1121212");
             personBaseInfo.setTransferAccountType("1");
             UnitBaseInfo unitBaseInfo = new UnitBaseInfo();
             unitBaseInfo.setName("unitname");
             unitBaseInfo.setUnitNumber(1121l);
             unitBaseInfo.setUnitType("10");
             MedCertificate medCertificate = new MedCertificate();
             medCertificate.setMedicareCertificateNumber("1212");
             medCertificate.setSrcAgencyState("129900");
             medCertificate.setPersonId(1000212l);
             medCertificate.setMedicalInsurance("380");
             medCertificate.setTgtAgencyState("129900");
             medCertificate.setSocialEnsureNumber("1212");
             medCertificate.setName("混");
             MedCertificatePrintParam medCertificatePrintParam=new MedCertificatePrintParam();
             medCertificatePrintParam.setPersonBaseInfo(personBaseInfo);
             medCertificatePrintParam.setUnitBaseInfo(unitBaseInfo);
             medCertificatePrintParam.setMedCertificateParam(medCertificate);
             
             MedCertificateResult mc=certificate.dubboSaveMedCertificate(medCertificatePrintParam);
             System.out.println("mc:"+mc.getErrorCode());
         }
         
         
         /*
     	  * 省内参保缴费凭证(已通)
     	  */
         public void t6(){
        	 PersonBaseInfo personBaseInfo = new PersonBaseInfo();
             personBaseInfo.setBirthday(19990909l);
             personBaseInfo.setComment("commment");
             personBaseInfo.setName("testt");
             personBaseInfo.setPersonId(100000000291873l);
             personBaseInfo.setPersonNumber("100000000280124");
             personBaseInfo.setSex("1");
             personBaseInfo.setSocialEnsureNumber("1121212");
             personBaseInfo.setTransferAccountType("1");
             UnitBaseInfo unitBaseInfo = new UnitBaseInfo();
             unitBaseInfo.setName("unitname");
             unitBaseInfo.setUnitNumber(1121l);
             unitBaseInfo.setUnitType("10");
             ProvCertificate provCertificate = new ProvCertificate();
             provCertificate.setPersonId(personBaseInfo.getPersonId());
             provCertificate.setSrcAgencyState("123341");
             
             ProvPensionCertificateParam provPensionCertificateParam=new ProvPensionCertificateParam();
             
             provPensionCertificateParam.setPersonBaseInfo(personBaseInfo);
             provPensionCertificateParam.setProvCertificate(provCertificate);
             provPensionCertificateParam.setUnitBaseInfo(unitBaseInfo);
             
             ProvPensionCertificateResult ppc=saveProvCertificate.dubboSaveProvCertificate(provPensionCertificateParam);
             System.out.println("ppc:"+ppc.getErrorCode());
         }
         
         
         /*
     	  * 2、	人员基本信息查询(已通)
     	  * private Long AAC001;
     	  * private String AAC002;
     	  * private String AAC058;
     	  * private String AAC147;
     	  */
         public void t7(){
        	 PersonParamDubboDTO pdto=new PersonParamDubboDTO();
        	 PersonResultDubboListDTO pr=personDubbo.queryPersonInfoAc01(pdto);
        	 System.out.println("结果信息："+pr.getErrorCode());
        	 System.out.println("结果信息："+pr.getResultList().size());
         }
         
         /*
          * 4、	人员险种信息查询(已通)
          */
         public void t8(){
        	 PersonParamDubboDTO pdto=new PersonParamDubboDTO();
        	 pdto.setAac001(100000000280144l);
        	 PersonResultDubboListDTO pr=personDubbo.queryPersonInsAc02(pdto);
        	 System.out.println("结果信息："+pr.getErrorCode());
        	 System.out.println("结果信息："+pr.getResultList().size());
         }
         
         
         /*
          * 居民停保(已通)
          */
         
         public void t9(){
        	/* PersonParamDubboDTO pd=new PersonParamDubboDTO();
        	 pd.setAac058("03");
        	 pd.setAac147("11111111");
        	 pd.setAae160("1");
        	 pd.setAccount("admin");
        	 pd.setBusinessID("121");
        	 PersonResultDubboDTO pr=personDubbo.executePersonPause(pd);
        	 System.out.println("结果信息："+pr.getErrorCode());*/
        	 
        	 
        	 ResidentParamDTO b = new ResidentParamDTO();
        	 b.setAac001(100000000280144l);
        	 b.setAae035(20160101l);
        	 b.setAab001(100000000280137l); 
        	 List<PersonDubboInsuranceDTO>
        	 personInsuranceDTOList = new ArrayList<PersonDubboInsuranceDTO>();
        	 PersonDubboInsuranceDTO personInsuranceDTO = new
        	 PersonDubboInsuranceDTO(); personInsuranceDTO.setAae140("390");
        	 personInsuranceDTOList.add(personInsuranceDTO);
        	 b.setPersonInsuranceDTOList(personInsuranceDTOList);
        	 b.setAae160("92131"); b.setAccount("admin"); b.setBusinessID("UCA121");
        	 ResidentResultDTO c = residentManage.dubboResidentPause(b);
        	 out(c);
         }
         
         
         /*
          * 居民续保(已通)
          */
        
         public void t10(){
        	/* PersonParamDubboDTO pd=new PersonParamDubboDTO();
        	 pd.setAab001New(100000000280137l);
        	 pd.setAac058("03");
        	 pd.setAac147("11111111");
        	 pd.setAae160("1");
        	 pd.setAccount("admin");
        	 pd.setBusinessID("121");
        	 PersonResultDubboDTO pr=personDubbo.executePersonResume(pd);
        	 System.out.println("结果信息："+pr.getErrorCode());*/
        	 
        	 
        	 ResidentParamDTO b = new ResidentParamDTO();
        	 b.setAab001New(100000000280137l);
        	 b.setAac001(100000000280144l);
        	 b.setAae035(22001010l);
        	 b.setAab001(100000000280137l);
        	 List<OrgDubboInsuranceDTO> personInsuranceDTOList = new ArrayList<OrgDubboInsuranceDTO>();
        	 OrgDubboInsuranceDTO
        	 personInsuranceDTO = new OrgDubboInsuranceDTO();
        	 personInsuranceDTO.setAae140("390");
        	 personInsuranceDTOList.add(personInsuranceDTO);
        	 b.setOrgInsuranceDTOList(personInsuranceDTOList); b.setAae160("92131");
        	 b.setAccount("admin"); b.setBusinessID("UCA121");
        	 ResidentResultDTO c =residentManage.dubboResidentResume(b);
        	 out(c);
         }
         
         
         /*
          * 人员一次性缴费信息查询(已通)
          */
        
         public void t11(){
        	 FeeInfoQueryParam fp=new FeeInfoQueryParam();
         	 fp.setAac001(218l);
        	 FeeInfoQueryResult fresult=PersonOnceFeeInfo.queryPerOnceFeeInfo(fp);
        	 System.out.println("结果信息："+fresult.getErrorCode());
         }
         
         
         /**
         * 人员缴费历史信息补录(批量)（已通）
         * @param feeHistoryMakeupParam
         * @return
         */
         public void t12(){
        	 FeeHistoryMakeupParam fmp=new FeeHistoryMakeupParam();
        	 
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

        	 FeeHistoryMakeupResult fh=feeHistoryMakeup.saveFeeHistoryInfo(fmp);
        	 out(fh);
         }
         
         
         /**
         * 人员缴费历史信息补录(单个)(通)
         * @param feeHistoryMakeupParam
         * @return
         */

        
         public void t13(){
        	 FeeHistoryMakeupParam acc2=new FeeHistoryMakeupParam(); 
        	 
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
				
					acc2.setAab001((long)411423);
				
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

        	 
        	 
        	 FeeHistoryMakeupResult fee=feeHistoryMakeup.saveOneFeeHistoryInfo(acc2);
        	 out(fee);
         }
         
         /*
          * 失业转入申请(已通)
          */
         public void t14(){
        	UnemployContactNotePrintParam contactNotePrintParam=new UnemployContactNotePrintParam();
     		PersonBaseInfo person = new PersonBaseInfo();
     		person.setPersonId(Long.parseLong("123455"));
     		UnitBaseInfo unit = new UnitBaseInfo();
     		UnemployContactNoteParam con = new UnemployContactNoteParam();
     		con.setPersonId(Long.parseLong("123455"));
     		con.setSrcAgencyState("460299");
     		con.setTgtAgencyState("129900");
     		con.setInsurance("210");
     		con.setUnemployContactNoteType("1");
     		con.setTransferInAgencyName("转入地机构");
     		con.setTransferOutAgencyName("转出地机构");

     		UnemployAppliedFormParam form = new UnemployAppliedFormParam();
     		form.setPersonId(Long.parseLong("123455"));
     		form.setSrcAgencyState("460299");
     		form.setTgtAgencyState("129900");
     		form.setTransferInAgencyName("转入地机构");
     		form.setTransferOutAgencyName("转出地机构");
     		form.setIsHaveOriHousehold("1");
     		form.setIsHaveOriIdCard("1");

     		UnemployRecordSummaryParam certSummary = new UnemployRecordSummaryParam();

     		contactNotePrintParam.setPersonBaseInfoDTO(person);
     		contactNotePrintParam.setUnitBaseInfoDTO(unit);
     		contactNotePrintParam.setAppliedFormDTO(form);
     		contactNotePrintParam.setContactNoteDTO(con);
     		contactNotePrintParam.setUnemployRecordSummaryDTO(certSummary);

        	 
        	 UnemployContactNotePrintResult uresult=saveUnemployNote.dubboCreateUnemployContactNote(contactNotePrintParam);
        	 System.out.println("结果信息："+uresult.getMessage());
        	 
         }
         
         
         /*
          * 失业缴费凭证打印(已通)
          */
        
         public void t15(){
        	UnemployCertificatePrintParam certificatePrintParam=new UnemployCertificatePrintParam();
     		UnemployCertificateParam certificateParam = new UnemployCertificateParam();
     		certificateParam.setAgencyState("120000");
     		certificateParam.setPersonId(Long.parseLong("1234567"));
     		certificateParam.setName("张三");
     		certificateParam.setSocialEnsureNumber("371424198810011822");
     		PersonBaseInfo person = new PersonBaseInfo();
     		person.setPersonId(Long.parseLong("1234567"));
     		UnitBaseInfo unit = new UnitBaseInfo();

     		certificatePrintParam.setCertificateDTO(certificateParam);
     		certificatePrintParam.setPersonBaseInfoDTO(person);
     		certificatePrintParam.setUnitBaseInfoDTO(unit);

        	 UnemployCertificatePrintResult uresult=saveUnemployCerti.dubboCreateUnemployCert(certificatePrintParam);
        	 System.out.println("结果信息："+uresult.getMessage());
        	 
         }
         
         
         /*
          * 关系转入\转出查询(公共接口，ac06,条件：电脑号,变更类型)(已通)
          */
         public void t16(){
        	 SettleInfoParam settleInfoParam=new SettleInfoParam();
        	 settleInfoParam.setPersonId(100000000280125l);
        	 SettleInfoResultItems sl=getSettleInfoItem.executeQuerySettleInfoItems(settleInfoParam);
        	 System.out.println("结果信息："+sl.getMessage());
         }
         
         
         /*
          * 单位基本信息变更
          */
         public void t17(){
        	/*UnitParamDubboDTO b = new UnitParamDubboDTO();
        	
        	b.setAab010("11");
        	
     		b.setAab001(1234567L);
     		b.setBab051("321");
     		b.setBab052("322");
     		b.setBab053("323");
     		BankDTO  bank = new BankDTO();
     		bank.setAae009("2");
     		bank.setAae010("6");
     		bank.setAaf200("8");
     		b.setWithdrawAccount(bank);
     		b.setAab301("11");

     		UnitResultDubboDTO c = unitDubboService.executeModifyUnitInfo(b);
     		System.out.println("c:"+c.getMessage());*/
         }
         
         
         /*
          * 居民注销
          * 入参：private Long aac001;// 个人编号
				private Long aab001;// 单位编号
				private Long aae035;// 变更时间
				private String aae160;// 变更原因

          */
         
         public void t18(){
        	ResidentStopParam b = new ResidentStopParam();
        	b.setAac001(100000000280144l);
        	b.setAab001(100000000280137l);
        	b.setAae035(20161010l);
        	b.setAae160("91101");
        	ResidentStopResult resid=residentManage.dubboResidentStop(b);
     		out(resid);
         }
         
         
         
         /*
          * 居民批量变更
          */
         public void t20(){
        	ResidentListParamDTO b = new ResidentListParamDTO();
 			b.setAab001New(100000000280137l);
 			List<ResidentBatchImportDTO> importListDTO = new ArrayList<ResidentBatchImportDTO>();
 			ResidentBatchImportDTO a=new ResidentBatchImportDTO();
            a.setAac999("100000000433058");
            a.setAac001(100000000280144l);
     		a.setAac050("12");  //需保
     		a.setAae160("12345");
     		a.setAae035(30125602l);
 			b.setAccount("admin"); 
 			b.setBusinessID("UCA121");
 			importListDTO.add(a);
 			b.setImportListDTO(importListDTO);
 			ResidentListResultDTO c = residentManage.dubboBatch(b);
 			out(c);
         }
         
         
         /*
          * 居民批量变更
          */
        
         public void t21(){
        	ResidentListParamDTO b = new ResidentListParamDTO();
 			b.setAab001New(100000000280137l);
 			List<ResidentBatchImportDTO> importListDTO = new ArrayList<ResidentBatchImportDTO>();
 			ResidentBatchImportDTO a=new ResidentBatchImportDTO();
            a.setAac999("100000000433058");
     		a.setAac050("41");  //信息维护
     		a.setAac003("wuj");
     		a.setAac004("1");
     		a.setAac005("1");
     		a.setAac006(20111111l);
            a.setAaz067(123564l);
            a.setAac006(52648524l);
     		a.setAac147("124343");
     		a.setAac058("03");
     		a.setAac161("TLS");
 			b.setAccount("admin"); 
 			b.setBusinessID("UCA121");
 			importListDTO.add(a);
 			b.setImportListDTO(importListDTO);
 			ResidentListResultDTO c = residentManage.dubboBatch(b);
 			out(c);
         }
         
         
         /*
          * 居民批量变更
          */
        
         public void t22(){
        	 ResidentListParamDTO b = new ResidentListParamDTO();
     		b.setAab001New(100000000280137l);
     		List<ResidentBatchImportDTO> importListDTO = new ArrayList<ResidentBatchImportDTO>();
     		ResidentBatchImportDTO a=new ResidentBatchImportDTO();
     		a.setAae035(20160302l);
     		a.setAac050("11");  //新参保登记
     		a.setAac003("张三李四");
     		a.setAac004("1");
     		a.setAac005("1");
     		a.setAac006(11111111l);
     		a.setAac147("124343");
     		a.setAac058("03");
     		a.setAac161("TLS");
     		b.setAccount("admin"); 
     		b.setBusinessID("UCA121");
     		importListDTO.add(a);
     		b.setImportListDTO(importListDTO);
     		ResidentListResultDTO c = residentManage.dubboBatch(b);
     		out(c);

         }
         
         /*
          * 居民基本信息维护(通)
          */
         @Test
         public void t23(){
        	ResidentRegisterParam importListDTO=new ResidentRegisterParam();
        	importListDTO.setAac001(100000000280144l);
  			importListDTO.setAac006(20181818l);
  			importListDTO.setAac003("niuniu");
  			importListDTO.setAac004("1");
  			importListDTO.setAac005("2");
  			importListDTO.setAac058("03");
  			importListDTO.setAac147("123411");
        	ResidentRegisterResult residresult=residentManage.dubboResidentModify(importListDTO);
        	out("11111111:"+residresult.getMessage());
         }
         /*
          * 人员基本信息维护
          */
         public void t24(){
        	 person.updatePersonInfo(null);
         }
         
         
         /*
          * 人员参保登记
          */
         
         public void t25(){
        	 
         }
         
         
        
         
        
}
