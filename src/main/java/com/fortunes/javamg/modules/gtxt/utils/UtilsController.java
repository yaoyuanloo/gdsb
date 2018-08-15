package com.fortunes.javamg.modules.gtxt.utils;

import com.fortunes.gtxt.dubbo.GtxtListResult;
import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.utils.DateUtils;
import com.fortunes.javamg.common.utils.IdGen;
import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwatter;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwinfo;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwtabService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfo;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfocb;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinput;
import com.fortunes.javamg.modules.gtxt.gt.entity.YwMateinfo;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfocbService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinputService;
import com.fortunes.javamg.modules.gtxt.gt.service.YwMateinfoService;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialinfoService;
import com.fortunes.javamg.modules.sys.entity.Dict;
import com.fortunes.javamg.modules.sys.utils.UserUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yinhai.bcpcs.BcpRequest;
import com.yinhai.bcpcs.BcpResponse;
import com.yinhai.bcpcs.DefaultBcpClient;
import com.yinhai.bcpcs.IBcpClient;
import com.yinhai.bcpcs.exceptions.ClientException;
import com.yinhai.bcpcs.profile.DefaultProfile;
import com.yinhai.bcpcs.profile.IClientProfile;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.*;

/**
 * Created by cxdwe on 2016/9/7.
 */
@Controller
@RequestMapping(value = "${adminPath}/gtxt/utils/util")
public class UtilsController extends BaseController {

    @Autowired
    private DYwinfoService dYwinfoService;
    @Autowired
    private GtYwinputService gtYwinputService;
    @Autowired
    private GtYwinfoService gtYwinfoService;
    @Autowired
    private GtYwinfocbService gtYwinfocbService;
    @Autowired
    private DYwatterService dYwatterService;
    @Autowired
    private PMaterialinfoService pMaterialinfoService;
    @Autowired
    private DYwtabService dYwtabService;
    @Autowired
    private YwMateinfoService ywMateinfoService;

    @RequestMapping(value = "fapiao")
    public String fapiao(String type, String qingdan, Model model) {

        model.addAttribute("type", type);
        model.addAttribute("qingdan", qingdan);
        return "modules/gtxt/utils/" + type + "/fapiao";
    }

    @RequestMapping(value = "qingdan")
    public String qingdan(String type, String qingdan, Model model) {
        if (StringUtils.isBlank(qingdan)) {
            qingdan = "";
        }
        model.addAttribute("type", type);
        return "modules/gtxt/utils/" + type + "/qingdan" + qingdan;
    }

    @ResponseBody
    @RequestMapping(value = "json")
    public Map<String, String> getPersonByIdCard(String type, String qingdan, Model model) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("pcno", "010203040");
        map.put("idno", "320321000000000000");
        map.put("sino", "4100000000");
        map.put("peosonname", "程旭东");
        map.put("oldhome", "江苏");
        map.put("dwbh", "60012761");
        map.put("dwmc", "深圳社保局测试部门");
        return map;
    }


    @RequestMapping(value = "teamwork")
    public String teamWork(String hzdh, String ywid, String ywmc, Model model) {
        List<GtYwinfo> gtYwinfos = gtYwinfoService.findByHzdh(hzdh);
        model.addAttribute("gtywinfos", gtYwinfos);
        model.addAttribute("ywid", ywid);
        model.addAttribute("ywmc", ywmc);
        return "modules/gtxt/utils/multibusiness/teamWork";
    }

    @RequestMapping(value = "yhtest")
    public String yhtest(Model model) {
        return "modules/yhtest";
    }

    @ResponseBody
    @RequestMapping(value = "pic")
    public BcpResponse<Map> pic() throws ClientException {
        BcpRequest request = new BcpRequest();
        /**
         * 构造并设置参数数组，参数数量以及顺序参考服务描述，如果服务的入参类型是自定义对象或者Map，均统一通过Map进行传参,如果是简单类型，
         * 直接传入即可 例如：参数数量为1，参数类型为对象，且包含 String id以及String name字段
         * Map<String,Object> p = new HashMap<String,Object>();
         * p.put("id","001");
         * p.put("name","john");
         * request.setInput(new Object[] { p });//如果接入的服务是dubbo服务
         * request.setInput(p);//如果接入的服务是其他服务
         **/
//        Map<String, Object> p = new HashMap<String, Object>();
//        p.put("sysid", "fd_gtxt");
//        p.put("aab301", "440100000000");
//        p.put("yab003", "4401");
//        p.put("loginid", "developer");
//        p.put("busitype", "busitype_a");
        request.setInput(new Object[]{getUploadParams()});
        /**
         * getProfile方法参数顺序：
         * 1、协同平台对外IP或域名（只暴露80端口）
         * 2、接入系统key
         * 3、对外服务key
         **/
        IClientProfile profile = DefaultProfile.getProfile("http://xportal.tcpip.cxm:8082/bcp", "fd_gtxt", "GET_UPLOAD_URL", true);
        //创建client
        IBcpClient client = new DefaultBcpClient(profile, request);
        //获取返回对象，通过泛型指定结果类型
        BcpResponse<Map> response = client.getResponse(Map.class);
        System.out.println(response);
        // 获取调用成功标识
        boolean isInvokeSuccess = response.isInvokeSuccess();

        return response;
    }

    @ResponseBody
    @RequestMapping(value = "ylz")
    public GtxtListResult<Map<String, Object>> findBusiList() {
        Map<String, Object> paramMap = Maps.newHashMap();
        int pageNo = 1;
        int pageSize = 15;
        Page<GtYwinfo> page = new Page(pageNo, pageSize);
        GtYwinfo gtYwinfo = new GtYwinfo();
        page = gtYwinfoService.findPage(page, gtYwinfo);
        List<Map<String, Object>> infos = Lists.newArrayList();
        Map<String, Object> map;
        for (GtYwinfo g : page.getList()) {
            map = Maps.newHashMap();
            map.put("ywlsh", g.getYwlsh());
            map.put("xm", g.getXm());
            map.put("ywmc", g.getYwmc());
            map.put("lczt", g.getLczt());
            map.put("clsj", DateUtils.formatDate(g.getCjdate(), "yyyy年MM月dd日 HH:mm:ss"));
            infos.add(map);
        }
        return new GtxtListResult<Map<String, Object>>((int)page.getCount(), 0, page.getPageNo(), page.getPageSize(), infos);

//        result = new GtxtListResult<>(false, "1", "测试错误");

//        return result;
    }

    @ResponseBody
    @RequestMapping(value = "getUploadParams")
    public Map<String, Object> getUploadParams() {
        Map<String, Object> p = new HashMap<String, Object>();
        p.put("sysid", "fd_gtxt");
        p.put("aab301", "440100000000");
        p.put("yab003", "4401");
        p.put("loginid", "developer");
        p.put("busitype", "busitype_a");
        return p;
    }

    @RequestMapping(value = "save")
    public String save(GtYwinfo gtYwinfo, String nextywid, String jsoninfo, String cls, String teamwork, String active, Model model, RedirectAttributes redirectAttributes) throws IOException {
        String ywlsh = IdGen.randomLongString();
        if (com.fortunes.javamg.common.utils.StringUtils.isBlank(gtYwinfo.getSlhzh()))
            gtYwinfo.setSlhzh(IdGen.randomLongString());
        if (com.fortunes.javamg.common.utils.StringUtils.isBlank(gtYwinfo.getHzdh()))
            gtYwinfo.setHzdh(IdGen.randomLongString());

        if(com.fortunes.javamg.common.utils.StringUtils.isNotBlank(cls)) {
            List<YwMateinfo> clList = new ArrayList<>();
            YwMateinfo ywMateinfo;
            ObjectMapper mapper = new ObjectMapper();
            List<String> clsData = mapper.readValue(StringEscapeUtils.unescapeHtml4(cls), List.class);
            for (String s : clsData) {
                ywMateinfo = new YwMateinfo(ywlsh, s);
                clList.add(ywMateinfo);
            }
            ywMateinfoService.save(clList);
        }

        GtYwinput gtYwinput = new GtYwinput();
        gtYwinput.setJsoninfo(jsoninfo);
        gtYwinput.setYwlsh(ywlsh);
        gtYwinput.setLczt("LCB000");
        gtYwinputService.save(gtYwinput);

        gtYwinfo.setYwlsh(ywlsh);
        gtYwinfo.setLczt("LCB000");
        gtYwinfo.setFpzt(new Dict("0", ""));
        gtYwinfo.setSlr(UserUtils.getUser());
        gtYwinfo.setSlqy("Z100");
        gtYwinfo.setFqbh("Z100");
        gtYwinfo.setCjdate(new Date());
        gtYwinfo.setSbfs(new Dict("0", "窗口业务"));
        gtYwinfoService.save(gtYwinfo);

        if (com.fortunes.javamg.common.utils.StringUtils.isNotBlank(nextywid)) {
            DYwinfo dYwinfo = dYwinfoService.get(nextywid);
            redirectAttributes.addAttribute(YWLSH, ywlsh);
            if (gtYwinfo.getYwid().equals(nextywid))
                redirectAttributes.addAttribute(SLHZH, gtYwinfo.getSlhzh());
            redirectAttributes.addAttribute(HZDH, gtYwinfo.getHzdh());
            return "redirect:" + adminPath + GtxtUitls.htmlUnescape(dYwinfo.getPywinfo().getAcceptaddress()) + "&ywid=" + dYwinfo.getId();
        }

        String flowcode, shjbcode;
        DYwatter dYwatter;

        List<GtYwinfo> checkHzList = gtYwinfoService.findByHzdh(gtYwinfo.getHzdh());
        if(checkHzList != null && checkHzList.size() > 0){
            for(GtYwinfo g : checkHzList){
                GtYwinfocb gtYwinfocb = new GtYwinfocb();
                gtYwinfocb.setYwlsh(g.getYwlsh());
                gtYwinfocb.setYwlc("LCB000");
                gtYwinfocb.setClyj("数据已提交");
                gtYwinfocb.setClr(gtYwinfocb.getCurrentUser());
                gtYwinfocbService.save(gtYwinfocb);
            }
        }
        if(com.fortunes.javamg.common.utils.StringUtils.isNotBlank(teamwork) && "1".equals(teamwork.trim())){
            dYwatter = dYwatterService.getByYwId(active);
            flowcode = dYwatter.getFlowcode().getValue();
            shjbcode = dYwatter.getShjbcode().getValue();

            GtYwinfo teamWorkGtYwinfo = new GtYwinfo();
            teamWorkGtYwinfo.setYwid(active);
            teamWorkGtYwinfo.setSynergy("1");
            teamWorkGtYwinfo.setHzdh(gtYwinfo.getHzdh());
            gtYwinfoService.updateSynergyByYwidHzdh(teamWorkGtYwinfo);
        } else {
            if(checkHzList != null && checkHzList.size() > 1){
                flowcode = "1";
                shjbcode = "3";
            }else{
                dYwatter = dYwatterService.getByYwId(gtYwinfo.getYwid());
                flowcode = dYwatter.getFlowcode().getValue();
                shjbcode = dYwatter.getShjbcode().getValue();
            }
        }

        if (shjbcode.equals("1")) {
            redirectAttributes.addAttribute(YWLSH, ywlsh);
            redirectAttributes.addAttribute(HZDH, gtYwinfo.getHzdh());
            return "redirect:" + adminPath + "/city/dWrittempinfo/dyyl";
        } else if (shjbcode.equals("2") || shjbcode.equals("3") || shjbcode.equals("4") || shjbcode.equals("5")) {
            if ("1".equals(flowcode)) {
                redirectAttributes.addAttribute(YWLSH, ywlsh);
                redirectAttributes.addAttribute(HZDH, gtYwinfo.getHzdh());
                return "redirect:" + adminPath + "/city/dWrittempinfo/dyyl";
            } else if ("2".equals(flowcode)) {
                redirectAttributes.addAttribute(YWLSH, ywlsh);
                redirectAttributes.addAttribute(HZDH, gtYwinfo.getHzdh());
                return "redirect:" + adminPath + "/gt/gtSmjinfo/list";
            } else {
                model.addAttribute("content", "不可识别流转配置！");
                return "/modules/gtxt/utils/test";
            }
        } else {
            model.addAttribute("content", "不可识别流转配置！");
            return "/modules/gtxt/utils/test";
        }
    }
}
