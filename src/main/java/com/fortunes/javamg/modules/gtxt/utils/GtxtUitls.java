/**
 *
 */
package com.fortunes.javamg.modules.gtxt.utils;

import com.fortunes.javamg.common.utils.SpringContextHolder;
import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.modules.gtxt.city.dao.DWrittempinfoDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DWrittempinfo;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwtabService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinputService;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.HtmlUtils;

/**
 * 柜台系统工具类
 *
 * @version 2013-12-05
 */
public class GtxtUitls {

    @Autowired
    private DYwinfoService dYwinfoService;
    @Autowired
    private GtYwinfoService gtYwinfoService;
    @Autowired
    private GtYwinputService gtYwinputService;
    @Autowired
    private DYwatterService dYwatterService;
    @Autowired
    private PMaterialinfoService pMaterialinfoService;
    @Autowired
    private DYwtabService dYwtabService;

    private static DWrittempinfoDao dwrittempinfoDao = SpringContextHolder.getBean(DWrittempinfoDao.class);

    public  static  String getMOName(String val) {
        if(StringUtils.isNotEmpty(val)){
            DWrittempinfo d = new DWrittempinfo();
            d.setId(val);
            d = dwrittempinfoDao.get(d);
            return d.getName();
        }
    return "";
    }

    public static String htmlUnescape(String str){
        if(StringUtils.isBlank(str)) return "";
        return HtmlUtils.htmlUnescape(str);
    }

}
