package com.fortunes.test;

import com.fortunes.javamg.common.utils.EhCacheUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cxd on 2016/11/2 0002.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/ehcache-test.xml"})
public class EhCahceTest {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() {
        System.out.println("---------------- START ----------------");
        long startMili = System.currentTimeMillis();
        for (int i = 1; i <= 10000; i++) {
            EhCacheUtils.put("fd_gtxt_test" + i, "test" + i);
        }
        logger.info("耗时：" + (System.currentTimeMillis() - startMili) + ":ms");
        System.out.println("---------------- FIND  ----------------");
        for (int i = 1; i <= 100; i++) {
            System.out.println(EhCacheUtils.get("fd_gtxt_test" + (i * 100)));
        }
        System.out.println("----------------  END  ----------------");
    }

}
