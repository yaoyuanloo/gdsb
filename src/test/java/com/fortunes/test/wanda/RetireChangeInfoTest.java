package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020201.params.*;
import com.wondersgroup.interfaceServiceVS.retirementVS.r2.f14020201.vs.F14020201VService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * 养老待遇基本信息变更
 * Created by cxd on 2016/10/24.
 */
public class RetireChangeInfoTest extends DubboTest {

    @Resource
    F14020201VService retireChangeInfo;

    @Resource
    F14020201VService retireChangeInfo1;

    /**
     * 查询人员基本信息
     */
    @Test
    public void test(){
        PerInfoInputParams params = new PerInfoInputParams();
        params.setAac147("842334195608238078");
        PerInfoOutputParams out = retireChangeInfo.getIc10BaseInfo(params);
        out(out);
    }

    /**
     * 查询变更信息
     */
    @Test
    public void test1(){
        HistoryDetailInfoInputParams params = new HistoryDetailInfoInputParams();
        params.setAaz010(1000000993L);
        HistoryDetailInfoOutputParams out = retireChangeInfo.queryHistoryDetailInfo(new HistoryDetailInfoInputParams());
        out(out);
    }

    /**
     * 保存修改的人员信息
     */
    @Test
    public void test2(){
        UpdatePerInfoInputParams params = new UpdatePerInfoInputParams();
        params.setAac001(1000000993L);
        params.setAac147("852438195311039222");
        params.setAae005("123456789");
        params.setAac006(19920101L);
        params.setOutgoing("提交申请");
        params.setAaa121("F140223");
        UpdatePerInfoOutputParams out = retireChangeInfo.updateIc10BaseInfo(params);
        out(out);
    }
}
