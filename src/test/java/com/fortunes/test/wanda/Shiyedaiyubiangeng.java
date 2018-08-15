package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030208.F14030208ServiceVS;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030208.params.TreatProHistoryBaseInputParams;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030208.params.TreatProInputParams;
import com.wondersgroup.interfaceServiceVS.unemploymentVS.u2.f14030208.params.TreatProOutputParams;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cxd on 2016/10/26 0026.
 */
public class Shiyedaiyubiangeng extends DubboTest {

    @Autowired
    F14030208ServiceVS service;

    @Test
    public void test(){
        TreatProInputParams params = new TreatProInputParams();
        params.setAac147("861284195505071712");
        TreatProOutputParams out = service.queryBenefitInfo(new TreatProInputParams());
        out(out);
    }

    @Test
    public void test1(){
        TreatProHistoryBaseInputParams params = new TreatProHistoryBaseInputParams();
        params.setAaz257(1L);
        service.queryBenefitProvideHistoryBaseInfo(params);
    }
}
