package com.fortunes.test;

import com.google.common.collect.Maps;
import com.neusoft.dubbo.interfaces.OutInterface;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by cxd on 2016/11/2 0002.
 */
public class TT extends DubboTest {

    @Autowired
    OutInterface service;

    @Test
    public void test() {
        Map<String, Object> m = Maps.newHashMap();
        m.put("aac001", "1000007469");
        List<Map<String, Object>> o = service.getOutList(m);
        out(o);
    }
}
