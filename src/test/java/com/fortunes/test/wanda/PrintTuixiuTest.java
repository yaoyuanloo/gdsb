package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020108.vs.F14020108Service;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by cxd on 2016/10/24.
 */
public class PrintTuixiuTest extends DubboTest {

    @Resource
    public F14020108Service printRetireService;

    /**
     * 打印退休证明 -- 查询
     *
     * baa027; //所属区
     * bic301; //打印标识
     * aac147; //证件号码
     * aic162; //离退休日期
     * aab004; //单位名称
     */
    @Test
    public void test() {
//        params.setAac147("861284195505071712");
        printRetireService.queryRetiredPersons(null);
    }


    @Test
    public void test1() {
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
    }
}































