package com.fortunes.javamg.modules.dubbo.busiinfo;//package com.fortunes.javamg.modules.dubbo.ylz;

import com.fortunes.javamg.modules.dubbo.busiinfo.bean.GtBusParam;
import com.fortunes.javamg.modules.dubbo.busiinfo.bean.GtBusResult;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfo;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.fortunes.javamg.modules.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GtBusiServiceImpl implements GtBusiService {
    private static final String DATE_PATTERN = "yyyy年MM月dd日 HH:mm:ss"; // 时间格式化模板

    @Autowired
    private GtYwinfoService gtYwinfoService;


    @Override
    public GtBusResult addGtywinfo(GtBusParam gt) {
        GtYwinfo  gts=new GtYwinfo();
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
        gts.setLczt(gt.getLczt());
        gts.setCjdate(gt.getCjdate());
        gts.setSlqy(gt.getSlqy());
        gts.setYzdh(gt.getYzdh());
        gts.setBlgzr(Integer.valueOf(gt.getBlgzr()));
        gts.setSynergy(gt.getSynergy());

        gtYwinfoService.save(gts);
        GtBusResult  busRs=new GtBusResult();
        busRs.setMessage("添加成功");
        busRs.setErrorCode("0");
        busRs.setBizSuccess(true);
        return busRs;
    }
}
