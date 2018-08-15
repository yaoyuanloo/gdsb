package com.fortunes.test.menhu;

import com.fortunes.test.DubboTest;
import com.yinhai.dubbo.entity.GenericResult;
import com.yinhai.dubbo.ucm.service.DubboUcmService;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cxd on 2016/11/1 0001.
 */
public class CunchuDubboTest extends DubboTest {

    @Autowired
    DubboUcmService service;

    /**
     * 上传寻址
     */
    @Test
    public void test(){
        GenericResult o = service.getUploadUrl(getWayParams());
        out(o);
    }

    /**
     * 下载寻址
     *
     * 68276098cc5749a38129fd925521dbe7
     */
    @Test
    public void test1(){
        Map<String, Object> params = getdownloadParams("68276098cc5749a38129fd925521dbe7");
        GenericResult o = null;
        try {
            o = service.getDownloadUrl(params);
            Map<String, Object> m = PropertyUtils.describe(o);
            System.out.println(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out(o);
        out(turnUrl(params, (Map<String, Object>)o.getData()));
    }

    /**
     * 下载寻址(批量)
     *
     * 7785a0ad713e4dc099430f3fa8a6bbc9, 6f64381f573641bdbf5d9b6124531e3f
     */
    @Test
    public void test2(){
        Map<String, Object> params = getdownloadMultiParams("7785a0ad713e4dc099430f3fa8a6bbc9,6f64381f573641bdbf5d9b6124531e3f");
        GenericResult o = null;
        try {
            o = service.getDownloadUrlBatch(params);
            Map<String, Object> m = PropertyUtils.describe(o);
            System.out.println(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out(o);
//        out(turnUrl(params, (Map<String, Object>)o.getData()));
    }



    private Map<String, Object> getWayParams() {
        /**
         * request.setInput(new Object[] { p });//如果接入的服务是dubbo服务
         * request.setInput(p);//如果接入的服务是其他服务
         **/
        Map<String, Object> p = new HashMap<String, Object>();
        p.put("sysid", "fd_gtxt");
        p.put("aab301", "440100000000");
        p.put("yab003", "4401");
        p.put("loginid", "developer");
        p.put("busitype", "busitype_a");
        return p;
    }


    private Map<String, Object> getdownloadParams(String fileId) {
        Map<String, Object> p = new HashMap<String, Object>();
        p.put("sysid", "fd_gtxt");
        p.put("aab301", "440100000000");
        p.put("yab003", "4401");
        p.put("loginid", "developer");
        p.put("busitype", "busitype_a");
        p.put("fileid", fileId);
        return p;
    }


    private Map<String, Object> getdownloadMultiParams(String fileidstr) {
        Map<String, Object> p = new HashMap<String, Object>();
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
