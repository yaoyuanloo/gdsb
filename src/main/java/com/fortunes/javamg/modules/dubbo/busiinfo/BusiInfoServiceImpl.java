package com.fortunes.javamg.modules.dubbo.busiinfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortunes.gtxt.dubbo.GtBusParam;
import com.fortunes.gtxt.dubbo.GtxtBeanResult;
import com.fortunes.gtxt.dubbo.fd.BusiInfoService;
import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfo;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.fortunes.javamg.modules.sys.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by cxd on 2016/10/26 0026.
 */
public class BusiInfoServiceImpl implements BusiInfoService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GtYwinfoService gtYwinfoService;

    @Override
    public GtxtBeanResult addGtywinfo(List<GtBusParam> gtList) {
        GtYwinfo gts;
        for(GtBusParam gt : gtList){
            gts = new GtYwinfo();
            gts.setYwlsh(gt.getYwlsh());
            gts.setSlhzh(gt.getSlhzh());
            gts.setHzdh(gt.getHzdh());
            gts.setHzhjs(gt.getHzhjs());
            gts.setYwid(gt.getYwid());
            gts.setYwbh(gt.getYwbh());
            gts.setYwmc(gt.getYwmc());
            gts.setGrsbh(gt.getGrsbh());
            gts.setSfzh(gt.getSfzh());
            gts.setDnh(gt.getDnh());
            gts.setXm(gt.getXm());
            gts.setDwbh(gt.getDwbh());
            gts.setDwmc(gt.getDwmc());
            gts.setSmjbh(gt.getSmjbh());
            gts.setSlr(new User(gt.getSlr()));
            gts.setFqbh(gt.getFqbh());
            if ("受理".equals(gt.getLczt())) {
                gts.setLczt("LCB000");
            }
            gts.setCjdate(gt.getCjdate());
            gts.setSlqy(gt.getSlqy());
            gts.setYzdh(gt.getYzdh());
//        gts.setBlgzr(Integer.valueOf(gt.getBlgzr()));
            gts.setSynergy(gt.getSynergy());

//        gtYwinfoService.save(gts);
            ObjectMapper m = new ObjectMapper();
            try {
                logger.info(m.writeValueAsString(gts));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        GtxtBeanResult busRs = new GtxtBeanResult();
        busRs.setMessage("添加成功");
        busRs.setErrorCode("0");
        busRs.setBizSuccess(true);
        return busRs;
    }
}
