package com.fortunes.test.wanda;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020103.params.*;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020103.vs.F14020103Service;
import com.ylzinfo.gad.dubbo.service.PreAccept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by cxd on 2016/10/19.
 */
public class YanglaoShitongTest extends DubboTest {

//    @Resource
    private PreAccept preAccept;

    @Autowired
    private F14020103Service historyApprovedService;

    @Test
    public void test1(){
        JudgeHistoryInfoInputParams params = new JudgeHistoryInfoInputParams();
        params.setAac001(Long.valueOf("1000001348"));
        JudgeHistoryInfoOutputParams outputParams = historyApprovedService.judgeHistoryInfo(params);
        out(outputParams);
    }

    @Test
    public void test2() {
        CalculateDeemCountInputParams params = new CalculateDeemCountInputParams();

        // 一般人群
        /*params.setDeemExp("[{startDate: '1996-01', endDate: '1996-12'},{startDate: '1997-01', endDate: '1997-10'}]");
        params.setAac001(Long.valueOf("1000001348"));
        params.setBic086("101");
        params.setBic094(Long.valueOf("201610"));
        params.setBic084(Long.valueOf("201610"));
        params.setBic085(Double.valueOf("1000"));
        params.setAaa027("440000");*/

        // 特殊人群
        params.setDeemExp("[{startDate: '1996-01', endDate: '1996-12'},{startDate: '1997-01', endDate: '1997-10'}]");
        params.setAac001(Long.valueOf("1000001348"));
        params.setBic086("102");
        params.setBic089("1004");
        params.setBic087(Double.valueOf("1000"));
        params.setBic094(Long.valueOf("201610"));
        params.setBic084(Long.valueOf("201610"));
        params.setBic085(Double.valueOf("1000"));
        params.setAaa027("440000"); // 统筹区

        CalculateDeemCountOutputParams out = historyApprovedService.calculateDeemCount(params);
        out(out);
    }

    @Test
    public void test3(){
        SaveHistoryInfoAuthInputParams params = new SaveHistoryInfoAuthInputParams();
        params.setAac001("1000001348");
        params.setAac013("1");
        params.setBic086("102");
        params.setBic085(Double.valueOf("1000"));
        params.setBic089("1004");
        params.setBic087("1000");
        params.setBic094(Long.valueOf("201610"));
        params.setBic084(Long.valueOf("201610"));
        params.setDeemExp("[{startDate: '1996-01', endDate: '1996-12'},{startDate: '1997-01', endDate: '1997-10'}]");

        SaveHistoryInfoAuthOutputParams out = historyApprovedService.saveHistoryInfoAuth(params);
        out(out);
    }

    @Test
    public void tt(){
        logger.error("-------------------------------");
        logger.error("-------------------------------");
        logger.warn("-------------------------------");
        logger.warn("-------------------------------");
    }
}






























