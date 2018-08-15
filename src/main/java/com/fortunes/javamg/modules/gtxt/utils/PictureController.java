package com.fortunes.javamg.modules.gtxt.utils;

import com.fortunes.javamg.common.web.BaseController;
import com.google.common.collect.Maps;
import com.yinhai.dubbo.entity.GenericResult;
import com.yinhai.dubbo.ucm.service.DubboUcmService;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cxd on 2016/11/1 0001.
 */
@Controller
@RequestMapping(value = "${adminPath}/gtxt/utils/pic")
public class PictureController extends BaseController {

    @Autowired
    DubboUcmService service;

    /**
     * 上传寻址
     */
    @RequestMapping(value = "getupload")
    public GenericResult getUploadUrl(){
        GenericResult o = service.getUploadUrl(getWayParams());
        return o;
    }

    /**
     * 下载寻址
     *
     * 68276098cc5749a38129fd925521dbe7
     */
    @RequestMapping(value = "getdownload")
    public GenericResult getDownloadUrl(){
        Map<String, Object> params = getdownloadParams("68276098cc5749a38129fd925521dbe7");
        GenericResult o = null;
        try {
            o = service.getDownloadUrl(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    /**
     * 下载寻址(批量)
     *
     * 7785a0ad713e4dc099430f3fa8a6bbc9, 6f64381f573641bdbf5d9b6124531e3f
     */
    @RequestMapping(value = "getdownloadmulti")
    public GenericResult getDownloadUrlBatch(){
        Map<String, Object> params = getdownloadMultiParams("7785a0ad713e4dc099430f3fa8a6bbc9,6f64381f573641bdbf5d9b6124531e3f");
        GenericResult o = null;
        try {
            o = service.getDownloadUrlBatch(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }


    private Map<String, Object> getWayParams() {
        Map<String, Object> p = Maps.newHashMap();
        p.put("sysid", "fd_gtxt");
        p.put("aab301", "440100000000");
        p.put("yab003", "4401");
        p.put("loginid", "developer");
        p.put("busitype", "busitype_a");
        return p;
    }


    private Map<String, Object> getdownloadParams(String fileId) {
        Map<String, Object> p = Maps.newHashMap();
        p.put("sysid", "fd_gtxt");
        p.put("aab301", "440100000000");
        p.put("yab003", "4401");
        p.put("loginid", "developer");
        p.put("busitype", "busitype_a");
        p.put("fileid", fileId);
        return p;
    }


    private Map<String, Object> getdownloadMultiParams(String fileidstr) {
        Map<String, Object> p = Maps.newHashMap();
        p.put("sysid", "fd_gtxt");
        p.put("aab301", "440100000000");
        p.put("yab003", "4401");
        p.put("loginid", "developer");
        p.put("busitype", "busitype_a");
        p.put("fileidstr", fileidstr);
        return p;
    }

    /**
     * http://192.168.200.3:7005/yhucm/ucm/ucmAction!getFile.do?sysid=fd_gtxt&aab301=440100000000&yab003=4401&loginid=developer&busitype=busitype_a&fileid=68276098cc5749a38129fd925521dbe7&realid=8345&accesskey=h7ABAXBa1JozgD1Om9lSTg
     */
    private String turnUrl(Map<String, Object> params, Map<String, Object> data ){
        Object urlpre = data.get("downloadurl");
        Object sysid = params.get("sysid");
        Object aab301 = params.get("aab301");
        Object yab003 = params.get("yab003");
        Object loginid = params.get("loginid");
        Object busitype = params.get("busitype");
        Object fileid = params.get("fileid");
        Object realid = data.get("realid");
        Object accesskey = data.get("accesskey");
        return urlpre + "/ucm/ucmAction!getFile.do"
                + "?sysid=" + sysid
                + "&yab003=" + yab003
                + "&aab301=" + aab301
                + "&loginid=" + loginid
                + "&busitype=" + busitype
                + "&fileid=" + fileid
                + "&realid=" + realid
                + "&accesskey=" + accesskey;
    }

}
