package com.fortunes.test.menhu;

import com.fortunes.test.DubboTest;
import com.yinhai.bcpcs.BcpRequest;
import com.yinhai.bcpcs.BcpResponse;
import com.yinhai.bcpcs.DefaultBcpClient;
import com.yinhai.bcpcs.IBcpClient;
import com.yinhai.bcpcs.exceptions.ClientException;
import com.yinhai.bcpcs.profile.DefaultProfile;
import com.yinhai.bcpcs.profile.IClientProfile;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cxdwe on 2016/10/24.
 */
public class CunchuHttpTest extends DubboTest {

    @Test
    public void uploadGetUrlTest() throws ClientException {
        BcpRequest request = new BcpRequest();

        request.setInput(new Object[]{getUploadParams()});
        /**
         * getProfile方法参数顺序：
         * 1、协同平台对外IP或域名（只暴露80端口）log
         * 2、接入系统key
         * 3、对外服务key
         **/
        IClientProfile profile = DefaultProfile.getProfile("http://xportal.tcpip.cxm:8082/bcp", "fd_gtxt", "GET_UPLOAD_URL", true);
        IBcpClient client = new DefaultBcpClient(profile, request);
        BcpResponse<Map> response = client.getResponse(Map.class);
        out(response);
    }

    @Test
    public void downloadGetUrlTest() throws ClientException {
        BcpRequest request = new BcpRequest();
        Map<String, Object> params = getdownloadParams("68276098cc5749a38129fd925521dbe7");
        request.setInput(new Object[]{params});
        /**
         * getProfile方法参数顺序：
         * 1、协同平台对外IP或域名（只暴露80端口）
         * 2、接入系统key
         * 3、对外服务key
         **/
        IClientProfile profile = DefaultProfile.getProfile("http://xportal.tcpip.cxm:8082/bcp", "fd_gtxt", "GET_DOWNLOAD_URL", true);
        IBcpClient client = new DefaultBcpClient(profile, request);
        BcpResponse<Map> response = client.getResponse(Map.class);
        out(response);
        System.out.println("------------ URL Start ------------");
        logger.info(turnUrl(params, response.getInvokeData()));
        System.out.println("------------ URL End ------------");
    }

    private Map<String, Object> getUploadParams() {
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

    /**
     * http://192.168.200.3:7005/yhucm/ucm/ucmAction!getFile.do?sysid=fd_gtxt&aab301=440100000000&yab003=4401&loginid=developer&busitype=busitype_a&fileid=68276098cc5749a38129fd925521dbe7&realid=8345&accesskey=h7ABAXBa1JozgD1Om9lSTg
     */
    public String turnUrl(Map<String, Object> params, Map<String, Object> response ){
        Map<String, Object> data = (Map<String, Object>)response.get("data");
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
































