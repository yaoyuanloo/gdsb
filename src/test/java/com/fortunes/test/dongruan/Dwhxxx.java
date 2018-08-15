package com.fortunes.test.dongruan;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fortunes.test.DubboTest;
import com.neusoft.sl.si.basicinfo.bpo.employee.familydubbo.FamilyDubbo;
import com.neusoft.sl.si.collection.dubbo.employee.oncefee.param.ParamQueryOf37And13Supply;
import com.neusoft.sl.si.collection.dubbo.employee.oncefee.result.ResultQueryOf37And13Supply;
import com.neusoft.sl.si.collection.dubbo.employee.oncefee.service.DubboOnceFeePensionBPO;
import com.neusoft.sl.si.collection.dubbo.employee.query.service.QueryDWHXXIDubboService;
import com.neusoft.sl.si.collection.dubbo.employee.query.service.QueryGRBTXIDubboService;
import com.neusoft.sl.si.collection.dubbo.employee.query.service.QueryPersonPaymentInfoBPO;
import com.neusoft.sl.si.collection.dubbo.employee.query.service.QueryRYQKHXXIDubboService;
import com.neusoft.sl.si.collection.dubbo.employee.query.service.QueryUnitPaymentInfoBPO;
import com.neusoft.sl.si.common.code.service.QueryAA10DubboService;
import com.neusoft.sl.si.common.pensionpersonaccountinfo.service.QueryYLGRZHXXDubboService;
import com.neusoft.sl.si.settle.dubbo.pension.service.SavePensionCertificateService;
import com.neusoft.sl.si.settle.dubbo.pension.service.SavePensionContactNoteService;
import com.neusoft.sl.si.settle.dubbo.pension.service.SaveTempNoteService;
import com.neusoft.sl.si.settle.dubbo.urbanrual.service.SaveUrbanRuralContactNoteDubboService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dubbo-test.xml"})
public class Dwhxxx extends DubboTest {
	@Resource
	private QueryDWHXXIDubboService queryDWQKHX;
	@ Resource
	private QueryAA10DubboService  queryAA10;
	@ Resource
	private QueryYLGRZHXXDubboService queryYLGR ;
	@ Resource  
	private QueryPersonPaymentInfoBPO queryPerson;
	@Resource 
	private QueryUnitPaymentInfoBPO queryUnit;
	@Resource
	private FamilyDubbo familyDubbo;
	@Resource
	private QueryGRBTXIDubboService queryGRBTX;
	@Resource
	private QueryRYQKHXXIDubboService queryRYQKH;
	@Resource 
	private SavePensionContactNoteService savePensionContact;
	@Resource
	private SavePensionCertificateService savePensionCertificate;
	@Resource
	private SaveTempNoteService saveTempNote;
	
	@Resource
	private SaveUrbanRuralContactNoteDubboService saveSaveUrbanRural;
	
	
    @Test
    public void test() {
    	/*
    	 * 1.单位核销信息查询
    	 */
    /*	  DWHXXIDubboParam dwhxxIDubbo = new DWHXXIDubboParam();
    	  dwhxxIDubbo.setAab001("12345");
    	  dwhxxIDubbo.setAab004("");
    	  dwhxxIDubbo.setAae140s("310");
    	  dwhxxIDubbo.setAae041("201110");
    	  dwhxxIDubbo.setAae042("201610");
    	  dwhxxIDubbo.setPage_rows(10);
    	  dwhxxIDubbo.setPage(1);
          DWHXXIDubboResult result = queryDWQKHX.queryUnitArrearCancelInfo(dwhxxIDubbo);
          System.out.println(result.getMessage()+"===="+result.isBizSuccess()+"=====");
          Map<String,Object> map = result.getUnitArrearCancelInfoList().get(0);
          for(String key :map.keySet()){
        	  System.out.println("key="+key+"====value="+map.get(key));
          }*/
    	/*
    	 * 2.码表查询
//    	 */
//    	    AA10Param aa10Param = new AA10Param();
//    	    aa10Param.setAAA100("aae140");//查询险种
//    	    AA10Result result =  queryAA10.queryCodeTable(aa10Param);
//          System.out.println(result.getMessage()+"===="+result.isBizSuccess()+"=====");
//          List<Map<String,Object> > list = result.getAa10List();
//          Map<String,Object> map = result.getAa10List().get(0);
//          for(String key :map.keySet()){
//        	  System.out.println("key="+key+"====value="+map.get(key));
//    	
//          }
    	/*
    	 * 3.个人养老账户查询
    	 */
//    	  PensionPersonaccountInfoParam pensionInfo = new PensionPersonaccountInfoParam();
//    	  pensionInfo.setAAC001("123");//个人编号
//    	  PensionPersonaccountInfoResult result = queryYLGR.queryYLGRZHXX(pensionInfo);
//          System.out.println(result.getMessage()+"===="+result.isBizSuccess()+"=====");
//         List<Map<String,Object> > list = result.getPensionPersonaccountInfoList();
//         for(int i=0 ;i<list.size() ;i++ ){
//        	 Map<String,Object> map = result.getPensionPersonaccountInfoList().get(i);
//             for(String key :map.keySet()){
//           	  System.out.println("key="+key+"====value="+map.get(key));
//       	
//             }
//         }
         /*
          * 4.个人参保信息查询
          */
//     	DubboResultOfPaymentDetail result=new DubboResultOfPaymentDetail();
//		DubboParamOfPaymentDetail param=new DubboParamOfPaymentDetail();
//		param.setAAC001("6544");
//		param.setAAE140("110");
//		param.setBAE152("1");//0欠费 1实缴信息
//		result= queryPerson.queryPersonPaymentInfo(param);		
//		 System.out.println(result.getMessage()+"===="+result.isBizSuccess()+"=====");
//		  List<Map<String,Object> > list = result.getPaymentinfolist();
//        for(int i=0 ;i<list.size() ;i++ ){
//       	 Map<String,Object> map = list.get(i);
//            for(String key :map.keySet()){
//          	  System.out.println("key="+key+"====value="+map.get(key));
//      	
//            }
//        }
        /*
         * 5.单位历史历史缴费信息查询
         */
//        DubboResultOfPaymentDetail result=new DubboResultOfPaymentDetail();
//		DubboParamOfPaymentDetail param=new DubboParamOfPaymentDetail();
//		param.setAAB001("12345");
//		param.setAAE140("310");
//		param.setBAE152("1");
//		result=queryUnit.queryUnitPaymentInfo(param);
//		 System.out.println(result.getMessage()+"===="+result.isBizSuccess()+"=====");
//		  List<Map<String,Object> > list = result.getPaymentinfolist();
//        for(int i=0 ;i<list.size() ;i++ ){
//       	 Map<String,Object> map = list.get(i);
//            for(String key :map.keySet()){
//          	  System.out.println("key="+key+"====value="+map.get(key));
//      	
//            }
//        }
        /*
         * 6.居民家庭登记保存
         *
         */
    	
    	/*FamilyParamDubboDTO  param = new FamilyParamDubboDTO();
       //家庭登记保存(受理)  
       
    	param.setAAB400("2016102401");
		param.setAAC058("02");
		param.setAAC147("2016102402");
		param.setBAB100(10l);
		param.setAAC300("440000000000");
		
		OrgInsuranceDTODubbo org = new OrgInsuranceDTODubbo();
        org.setAAE140("390");       
        org.setAAB050(Long.valueOf(20161024));
        org.setAAB051("1");
        org.setBAA140("30");  
        List<OrgInsuranceDTODubbo> orgDubboList = new ArrayList<OrgInsuranceDTODubbo>();
        orgDubboList.add(org);
		param.setOrgInsuranceDTOList(orgDubboList);
		FamilyResultDubboDTO result =familyDubbo.executeRegisterFamily(param);

		 System.out.println(result.getMessage()+"===="+result.isBizSuccess()+"=====");
		  List<OrgInsuranceDTODubbo> list = result.getOrgInsuranceDTOList();
      for(int i=0 ;i<list.size() ;i++ ){
     	 
        	  System.out.println("====value="+list.get(i).getAAA027());
    	
      }
        System.out.println("受理保存结束--------------");*/
    	/*
    	 * 7.家庭登记查询(受理)
    	 */
//    	FamilyParamDubboDTO  familyParamDubboDTO = new FamilyParamDubboDTO();
//    	familyParamDubboDTO.setAAC058("2");//证件类型
//    	familyParamDubboDTO.setAAC147("1111");//证件号码
//    	FamilyResultDubboDTO familyResultDubboDTO2 = null;
//    	 familyResultDubboDTO2 =familyDubbo.queryFamilyInfoByTypeAndCode(familyParamDubboDTO);
//        System.out.println("==========familyResultDubboDTO.isBizSuccess()="+familyResultDubboDTO2.isBizSuccess());
//        System.out.println("受理保存结束--------------");
    	
    	/*
    	 * 8.个人补退信息查询
    	 */
/*    	GRBTXIDubboParam  param = new GRBTXIDubboParam();
    	param.setAab001("12345");
    	param.setAac001s("54321");
    	param.setAae140s("110,210,310");
    	param.setAae041("201110");
    	param.setAae042("201610");
    	GRBTXIDubboResult result = queryGRBTX.queryPerFeeReturnInfo(param);
    	System.out.println(result.getMessage()+"===="+result.isBizSuccess()+"=====");
    	print(result.getPerFeeReturnInfoList());*/
    	/*
    	 * 9.人员欠款核销信息查询
    	 */
    	/*RYQKHXXIDubboParam param = new RYQKHXXIDubboParam();
    	param.setAab001("12345");
    	param.setAac001s("54321");
    	param.setAae140s("110,210,310");
    	param.setAae041("201110");
    	param.setAae042("201610");
    	RYQKHXXIDubboResult result = queryRYQKH.queryPerArrearCancelInfo(param);
    	System.out.println(result.getMessage()+"===="+result.isBizSuccess()+"=====");
    	print(result.getPerArrearCancelInfoList());*/
    	/*
    	 * 10.跨省养老保险转入申请（联系函出具）
    	 * 
    	 */
/*    	PersonBaseInfo personBaseInfoDTO = new PersonBaseInfo();
		personBaseInfoDTO.setPersonId(1234567l);
		personBaseInfoDTO.setHouseholdAddress("kijooo");
		personBaseInfoDTO.setTransferAccountType("1");

		ContactNote contactNoteDTO = new ContactNote();
		contactNoteDTO.setIsOnline("0");
		contactNoteDTO.setOnlineUpload("0");
		contactNoteDTO.setSrcAgencyState("110112");
		contactNoteDTO.setPersonId(12345l);
		contactNoteDTO.setPersonNumber("12344");
		contactNoteDTO.setName("lily");
		contactNoteDTO.setSex("1");
		contactNoteDTO.setSocialEnsureNumber("1234567788765");
		contactNoteDTO.setTransferAccountType("1");
		contactNoteDTO.setBusProcessCode("T01");
		contactNoteDTO.setTgtAgencyState("440122");
		contactNoteDTO.setNationAgencyId(12345l);
		contactNoteDTO.setHouseholdAddress("kijooo");
		contactNoteDTO.setRepeatFeeFlag("2");
		contactNoteDTO.setPersonBankName("工商");
		contactNoteDTO.setPersonAccountName("123");
		contactNoteDTO.setPersonAccount("123456");

		ApplyForm applyFormDTO = new ApplyForm();
		applyFormDTO.setPersonId(1234567l);
		applyFormDTO.setName("lily");
		applyFormDTO.setSex("1");
		applyFormDTO.setSocialEnsureNumber("1234567788765");
		applyFormDTO.setHouseholdAddress("kijooo");
		applyFormDTO.setFormerPersonNumber("12344");
		applyFormDTO.setOriginalAgencyState("110112");
		applyFormDTO.setOriginalAgencyName("45");
		applyFormDTO.setOriginalAgencyStateName("123");

		applyFormDTO.setHasIdCard("1");

		BankAccount bankAccountDTO=new BankAccount();
		bankAccountDTO.setBankType("103");
		bankAccountDTO.setAccountName("272116");
		bankAccountDTO.setAccountNumber("272116");
		//bankAccountDTO.setAccountUsage("2");
		
		UnitBaseInfo unitBaseInfoDTO = new UnitBaseInfo();
		unitBaseInfoDTO.setUnitManagedNumber("000002");
		unitBaseInfoDTO.setName("测试单位1");
		unitBaseInfoDTO.setUnitType("10");
		
		PensionSettleInApplyParam p = new PensionSettleInApplyParam();
		p.setPersonBaseInfoDTO(personBaseInfoDTO);
		p.setApplyFormDTO(applyFormDTO);
		p.setContactNoteDTO(contactNoteDTO);
		p.setBankAccountDTO(bankAccountDTO);
		p.setUnitBaseInfoDTO(unitBaseInfoDTO);
    	PensionSettleInApplyResult result = savePensionContact.executeCreateContactNote(p);
    	System.out.println(result.getMessage()+"===="+result.isBizSuccess()+"=====");
    	System.out.println("name1="+result.getApplyFormDTO().getName()+"===name2="+result.getContactNoteDTO().getName());*/
    	/*
    	 * 11.基本养老保险参保缴费凭证（跨省、城乡）保存接口
    	 */
    	/*PersonBaseInfo personBaseInfoDTO = new PersonBaseInfo();
		personBaseInfoDTO.setPersonId(100000000280125l);
		personBaseInfoDTO.setHouseholdAddress("kijooo");
		personBaseInfoDTO.setTransferAccountType("1");

		PensionCertificate pensionCertificate=new PensionCertificate();
		pensionCertificate.setAgencyState("112321");
		pensionCertificate.setAgencyName("jilin");
		pensionCertificate.setAddress("jilinshi");
		pensionCertificate.setPhone("18256563545");
		pensionCertificate.setZip("110112");
		pensionCertificate.setContactPerson("xiaoming");
		pensionCertificate.setContactPhone("19267645654");
		pensionCertificate.setGiveupAddFee("1");
		pensionCertificate.setRemark("beizhu");
		pensionCertificate.setBillType("1");
		pensionCertificate.setInsurance("110");
		
		UnitBaseInfo unitBaseInfoDTO = new UnitBaseInfo();
		unitBaseInfoDTO.setUnitManagedNumber("000002");
		unitBaseInfoDTO.setName("测试单位1");
		unitBaseInfoDTO.setUnitType("10");
		
		PensionCertificatePrintParam p = new PensionCertificatePrintParam();
		p.setPersonBaseInfoDTO(personBaseInfoDTO);
		p.setCertificateDTO(pensionCertificate);
		p.setUnitBaseInfoDTO(unitBaseInfoDTO);	
		PensionCertificatePrintResult result=savePensionCertificate.executeCreateCertificate(p);
		System.out.println(result.getMessage()+"===="+result.isBizSuccess()+"=====");*/

    	 /*
    	  * 12.临时账户转移联系函打印保存接口
    	  */
    	/*PersonBaseInfo personBaseInfoDTO = new PersonBaseInfo();
		personBaseInfoDTO.setPersonId(1234567l);
		personBaseInfoDTO.setHouseholdAddress("kijooo");
		personBaseInfoDTO.setTransferAccountType("1");

		TempContactNote contactNoteDTO = new TempContactNote();
		contactNoteDTO.setIsOnline("0");
		contactNoteDTO.setSrcAgencyState("110112");
		contactNoteDTO.setPersonId(12345l);
		contactNoteDTO.setPersonNumber("12344");
		contactNoteDTO.setName("lily");
		contactNoteDTO.setSex("1");
		contactNoteDTO.setSocialEnsureNumber("1234567788765");
		contactNoteDTO.setTgtAgencyState("440122");
		contactNoteDTO.setNationAgencyId(12345l);
		contactNoteDTO.setHouseholdAddress("kijooo");
		
		ApplyForm applyFormDTO = new ApplyForm();
		applyFormDTO.setPersonId(1234567l);
		applyFormDTO.setName("lily");
		applyFormDTO.setSex("1");
		applyFormDTO.setSocialEnsureNumber("1234567788765");
		applyFormDTO.setHouseholdAddress("kijooo");
		applyFormDTO.setFormerPersonNumber("12344");
		applyFormDTO.setOriginalAgencyState("110112");
		applyFormDTO.setOriginalAgencyName("45");
		applyFormDTO.setOriginalAgencyStateName("123");

		applyFormDTO.setHasIdCard("1");

		BankAccount bankAccountDTO=new BankAccount();
		bankAccountDTO.setBankType("103");
		bankAccountDTO.setAccountName("272116");
		bankAccountDTO.setAccountNumber("272116");
		//bankAccountDTO.setAccountUsage("2");
		
		UnitBaseInfo unitBaseInfoDTO = new UnitBaseInfo();
		unitBaseInfoDTO.setUnitManagedNumber("000002");
		unitBaseInfoDTO.setName("测试单位1");
		unitBaseInfoDTO.setUnitType("10"); 
		
		TempNoteSendParam p = new TempNoteSendParam();
		p.setPersonBaseInfoDTO(personBaseInfoDTO);
		p.setApplyFormDTO(applyFormDTO);
		p.setTempContactNoteDTO(contactNoteDTO);
		p.setUnitBaseInfoDTO(unitBaseInfoDTO);
		TempNoteSendResult result=saveTempNote.executeCreateReceipt(p);
		System.out.println(result.getMessage()+"===="+result.isBizSuccess()+"=====");
		*/
		
    	

		/*
		 * 10.26
		 */
		
    	/*PersonBaseInfo personBaseInfoDTO = new PersonBaseInfo();
		personBaseInfoDTO.setPersonId(100000000980164l);
		personBaseInfoDTO.setHouseholdAddress("kijooo");
		personBaseInfoDTO.setTransferAccountType("1");

		UrbanRuralPensionContactNote contactNoteDTO = new UrbanRuralPensionContactNote();
		contactNoteDTO.setIsOnline("0");
		contactNoteDTO.setSrcAgencyState("110112");
		contactNoteDTO.setPersonId(100000000980164l);
		contactNoteDTO.setPersonNumber("12344");
		contactNoteDTO.setName("lily");
		contactNoteDTO.setSex("1");
		contactNoteDTO.setSocialEnsureNumber("1234567788765");
		contactNoteDTO.setBusProcessCode("T01");
		contactNoteDTO.setTgtAgencyState("100152");
		contactNoteDTO.setNationAgencyId(12345l);
		contactNoteDTO.setHouseholdAddress("kijooo");
		contactNoteDTO.setRepeatFeeFlag("2");
		contactNoteDTO.setPersonBankName("103");
		contactNoteDTO.setPersonAccountName("123");
		contactNoteDTO.setPersonAccount("123456");
		contactNoteDTO.setNewInsurance("110");
		contactNoteDTO.setOriginalInsurance("170");

		UrbanRuralPensionAppliedForm applyFormDTO = new UrbanRuralPensionAppliedForm();
		applyFormDTO.setPersonId(100000000980164l);
		applyFormDTO.setName("lily");
		applyFormDTO.setSex("1");
		applyFormDTO.setSocialEnsureNumber("1234567788765");
		applyFormDTO.setHouseholdAddress("kijooo");
		applyFormDTO.setFormerPersonNumber("12344");
		applyFormDTO.setSrcAgencyState("110112");
		applyFormDTO.setTgtAgencyState("100152");
		applyFormDTO.setOriginalInsurance("170");
		applyFormDTO.setNewInsurance("110");


		applyFormDTO.setHasIdCard("1");

		BankAccount bankAccountDTO=new BankAccount();
		bankAccountDTO.setBankType("103");
		bankAccountDTO.setAccountName("272116");
		bankAccountDTO.setAccountNumber("272116");
		//bankAccountDTO.setAccountUsage("2");
		
		UnitBaseInfo unitBaseInfoDTO = new UnitBaseInfo();
		unitBaseInfoDTO.setUnitManagedNumber("000002");
		unitBaseInfoDTO.setName("测试单位1");
		unitBaseInfoDTO.setUnitType("10");
		
		UrbanRuralPensionSettleInApplyParam p = new UrbanRuralPensionSettleInApplyParam();
		p.setPersonBaseInfoDTO(personBaseInfoDTO);
		p.setApplyFormDTO(applyFormDTO);
		p.setContactNoteDTO(contactNoteDTO);
		p.setBankAccountDTO(bankAccountDTO);
		p.setUnitBaseInfoDTO(unitBaseInfoDTO);
		UrbanRuralPensionSettleInApplyResult result=saveSaveUrbanRural.dubboExecuteCreateContactNote(p);
		
		System.out.println(result.getMessage()+"===="+result.isBizSuccess()+"=====");
		*/

    }
    
    
    
    
    
    
    
    public static void print(List<Map<String,Object> > list){
       for(int i=0 ;i<list.size() ;i++ ){
      	 Map<String,Object> map = list.get(i);
           for(String key :map.keySet()){
         	  System.out.println("key="+key+"====value="+map.get(key));
     	
           }
       }
    }

}
