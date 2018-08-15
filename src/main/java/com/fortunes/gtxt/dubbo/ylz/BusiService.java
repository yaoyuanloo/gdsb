package com.fortunes.gtxt.dubbo.ylz;

import com.fortunes.gtxt.dubbo.GtBusParam;
import com.fortunes.gtxt.dubbo.GtxtBeanResult;
import com.fortunes.gtxt.dubbo.GtxtListResult;


import java.util.Map;

/**
 * Created by cxdwe on 2016/10/17.
 */
public interface BusiService {
    public GtxtListResult<Map<String, Object>> findBusiList(Map<String, Object> paramMap);

}
