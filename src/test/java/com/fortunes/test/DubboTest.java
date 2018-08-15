package com.fortunes.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by cxdwe on 2016/10/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dubbo-test.xml"})
public abstract class DubboTest implements Serializable {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    /*public void out(AbstractResult o){
        System.out.println("------------ Out Start ------------");
        try {
            ObjectMapper m = new ObjectMapper();
//            if(!o.isBizSuccess()) throw new Exception();
            logger.info(m.writeValueAsString(o));
        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (Exception e) {
            logger.error(o.getMessage());
        }
        System.out.println("------------ Out END ------------");
    }*/

    public void out(Object o){
        System.out.println("------------ Out Start ------------\n");
        try {
            ObjectMapper m = new ObjectMapper();
            logger.info(m.writeValueAsString(o));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        System.out.println("\n------------ Out END ------------");

    }
}
