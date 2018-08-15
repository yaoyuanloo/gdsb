package com.fortunes.test.dongruan;

import com.fortunes.test.DubboTest;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.neusoft.sl.si.collection.dubbo.employee.oncefee.param.ParamFlexibleEmploymentOnceFee;
import com.neusoft.sl.si.collection.dubbo.employee.oncefee.param.ParamQueryOf37And13Supply;
import com.neusoft.sl.si.collection.dubbo.employee.oncefee.result.ResultFlexibleEmploymentOnceFee;
import com.neusoft.sl.si.collection.dubbo.employee.oncefee.result.ResultQueryOf37And13Supply;
import com.neusoft.sl.si.collection.dubbo.employee.oncefee.service.DubboOnceFeePensionBPO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by cxd on 2016/11/1 0001.
 */
public class CXD1Test extends DubboTest {


    @Autowired
    DubboOnceFeePensionBPO service;

    /**
     * 37号文趸缴|查询
     */
    @Test
    public void test() {
        ParamQueryOf37And13Supply paramof37 = new ParamQueryOf37And13Supply();
        paramof37.setAac001("65437");
        ResultQueryOf37And13Supply o = service.queryBasicInfoOf37FilesOnceFeeSupply(paramof37);
        out(o);
    }

    /**
     * 37号文趸缴|核算
     */
    @Test
    public void test1() {
        ParamQueryOf37And13Supply paramof37 = new ParamQueryOf37And13Supply();
        paramof37.setAac001("65437");
        ResultQueryOf37And13Supply resultof37 = service.queryBasicInfoOf37FilesOnceFeeSupply(paramof37);

        ParamQueryOf37And13Supply auditparamof37 = new ParamQueryOf37And13Supply();
        auditparamof37.setAae180("5000");
        auditparamof37.setAae002("201609");
        auditparamof37.setYcxjfys("30");
        auditparamof37.setDatemap(resultof37.getDatemap());
        ResultQueryOf37And13Supply o = service.getAuditingInfoOf37FilesOnceFeeSupply(auditparamof37);
        out(o);
    }

    /**
     * 13号文趸缴|查询
     */
    @Test
    public void test2() {
        ParamQueryOf37And13Supply paramof37 = new ParamQueryOf37And13Supply();
        paramof37.setAac001("65413");
        ResultQueryOf37And13Supply o = service.queryBasicInfoOf13FilesOnceFeeSupply(paramof37);
        out(o);
    }

    /**
     * 13号文趸缴|核算
     */
    @Test
    public void test3() {

        ParamQueryOf37And13Supply paramof37 = new ParamQueryOf37And13Supply();
        paramof37.setAac001("65413");
        ResultQueryOf37And13Supply o1 = service.queryBasicInfoOf13FilesOnceFeeSupply(paramof37);
        out(o1);

        ParamQueryOf37And13Supply auditparamof37 = new ParamQueryOf37And13Supply();
        auditparamof37.setAae180("5000");
        auditparamof37.setAae002("201609");
        auditparamof37.setYcxjfys("30");
        auditparamof37.setDatemap(o1.getDatemap());
        ResultQueryOf37And13Supply o2 = service.getAuditingInfoOf13FilesOnceFeeSupply(auditparamof37);
        out(o2);

//        ParamQueryOf37And13Supply saveparamof37 = new ParamQueryOf37And13Supply();
//        saveparamof37.setDatemap(o1.getDatemap());
//        ResultQueryOf37And13Supply saveresultof37 = service.saveInfoOf13FilesOnceFeeSupply(saveparamof37);
//        out(o);
    }

    /**
     * 灵活就业人员一次性缴费|查询
     */
    @Test
    public void test4() {

    }

    /**
     * 灵活就业人员一次性缴费|核算
     */
    @Test
    public void test5() {
        ParamFlexibleEmploymentOnceFee param = new ParamFlexibleEmploymentOnceFee();
        param.setAac001("6546");
        ResultFlexibleEmploymentOnceFee result = service.queryBasicInfoOfFlexibleEmploymentOnceFee(param);
        out(result);

        ParamFlexibleEmploymentOnceFee queryparam = new ParamFlexibleEmploymentOnceFee();
        queryparam.setHistoricalpaymentlist(result.getHistoricalpaymentlist());
        queryparam.setDatemap(result.getDatemap());
        Map<String, String> map1 = Maps.newHashMap();
        Map<String, String> map2 = Maps.newHashMap();
        Map<String, String> map3 = Maps.newHashMap();
        map1.put("AAE041", "201405");
        map1.put("AAE042", "201406");
        map1.put("BAE189", "2");
        map2.put("AAE041", "201408");
        map2.put("AAE042", "201408");
        map2.put("BAE189", "2");
        map3.put("AAE041", "201410");
        map3.put("AAE042", "201412");
        map3.put("BAE189", "3");
        queryparam.setCurrentpaymentlist(Lists.newArrayList(map1, map2, map3));
        queryparam.setAae180("5000");
        queryparam.setAae002("201610");
        ResultFlexibleEmploymentOnceFee queryresult = service.getAuditingInfoOFflexibleEmploymentOnceFee(queryparam);
        out(queryresult);

    }
}
