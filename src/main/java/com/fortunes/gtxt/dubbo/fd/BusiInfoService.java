package com.fortunes.gtxt.dubbo.fd;

import com.fortunes.gtxt.dubbo.GtBusParam;
import com.fortunes.gtxt.dubbo.GtxtBeanResult;

import java.util.List;

/**
 * Created by cxdwe on 2016/10/17.
 */
public interface BusiInfoService {
    public GtxtBeanResult addGtywinfo(List<GtBusParam> gtList);
}
