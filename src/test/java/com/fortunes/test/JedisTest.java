package com.fortunes.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortunes.javamg.common.utils.JedisUtils;
import com.fortunes.javamg.common.utils.SpringContextHolder;
import com.fortunes.javamg.modules.sys.entity.Dict;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by cxd on 2016/10/31 0031.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/jedis-test.xml"})
public class JedisTest {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

//    private static JedisPool jedisPool = SpringContextHolder.getBean(JedisPool.class);

    @Test
    public void test() {
        System.out.println("---------------- START ----------------");
        long startMili = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            JedisUtils.set("fd_gtxt.test" + i, "test" + i, 0);
        }
        logger.info("耗时：" + (System.currentTimeMillis() - startMili) + ":ms");
        System.out.println("----------------  END  ----------------");
    }

    @Test
    public void test1() {
        logger.info(JedisUtils.get("fd_gtxt.test*"));
    }

    @Test
    public void test2() {
        Jedis jedis = JedisUtils.getResource();
        Set<String> set = jedis.keys("fd_gtxt.test*");
        logger.info(set.size()+"");
    }

    @Test
    public void test3() {
        Jedis jedis = JedisUtils.getResource();
        Set<String> set = jedis.keys("fd_gtxt.test*");
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String keyStr = it.next();
            System.out.println(keyStr);
            jedis.del(keyStr);
        }
    }

    @Test
    public void test4() {
        System.out.println("---------------- START ----------------");
        long startMili = System.currentTimeMillis();
        List<String> list = Lists.newArrayList();
        for (int i = 1; i <= 1000; i++) {
            list.add("test" + i);
        }
        JedisUtils.setList("fd_gtxt.test", list, 0);
        logger.info("耗时：" + (System.currentTimeMillis() - startMili) + ":ms");
        System.out.println("----------------  END  ----------------");
    }

    @Test
    public void test5() {
        List<String> list = JedisUtils.getList("fd_gtxt.test");
        logger.info(list.toString());
    }

    @Test
    public void test6() {
        Dict d = new Dict("1", "test");
        try {
            Map<String, Object> map = PropertyUtils.describe(d);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
















