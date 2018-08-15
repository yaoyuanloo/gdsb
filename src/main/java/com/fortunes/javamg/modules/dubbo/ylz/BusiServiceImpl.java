package com.fortunes.javamg.modules.dubbo.ylz;

import com.fortunes.gtxt.dubbo.GtxtBeanResult;
import com.fortunes.gtxt.dubbo.GtxtListResult;
import com.fortunes.gtxt.dubbo.ylz.BusiService;
import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.utils.DateUtils;
import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.modules.dubbo.busiinfo.bean.GtBusParam;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfo;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by cxd on 2016/10/17.
 */
@Service
@Transactional(readOnly = true)
public class BusiServiceImpl implements BusiService {
    private static final String DATE_PATTERN = "yyyy年MM月dd日 HH:mm:ss"; // 时间格式化模板

    @Autowired
    private GtYwinfoService gtYwinfoService;

    @Override
    public GtxtListResult<Map<String, Object>> findBusiList(Map<String, Object> paramMap) {
        int pageNo = (int) paramMap.get("page");
        int pageSize = (int) paramMap.get("rows");
        Page<GtYwinfo> page = new Page(pageNo, pageSize);
        GtYwinfo gtYwinfo = new GtYwinfo();
        if (StringUtils.isNotBlank((String) paramMap.get("zjlx"))) {
            if ("zjlx01".equals(paramMap.get("zjlx"))) {
                gtYwinfo.setSfzh((String) paramMap.get("zjh"));
            } else if ("zjlx02".equals(paramMap.get("zjlx"))) {
                gtYwinfo.setGrsbh((String) paramMap.get("zjh"));
            }
        }
        page = gtYwinfoService.findPage(page, gtYwinfo);
        List<Map<String, Object>> infos = Lists.newArrayList();
        Map<String, Object> map;
        for (GtYwinfo g : page.getList()) {
            map = Maps.newHashMap();
            map.put("ywlsh", g.getYwlsh());
            map.put("xm", g.getXm());
            map.put("ywmc", g.getYwmc());
            map.put("lczt", g.getLczt());
            map.put("clsj", DateUtils.formatDate(g.getCjdate(), DATE_PATTERN));
            infos.add(map);
        }
        return new GtxtListResult<Map<String, Object>>((int) page.getCount(), 0, page.getPageNo(), page.getPageSize(), infos);
    }

}
