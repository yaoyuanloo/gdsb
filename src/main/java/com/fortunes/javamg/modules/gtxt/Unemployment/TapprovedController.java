/**
 * 
 *//*
package com.fortunes.javamg.modules.gtxt.Unemployment;

import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwatter;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwinfo;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwtab;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwtabService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfo;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfocbService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinputService;
import com.fortunes.javamg.modules.gtxt.gt.service.YwMateinfoService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialinfoService;
import com.ylzinfo.gad.dubbo.dto.Params;
import com.ylzinfo.gad.dubbo.dto.Result;
import com.ylzinfo.gad.dubbo.service.MessagePush;
import com.ylzinfo.gad.dubbo.service.PreAccept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.fortunes.javamg.common.web.BaseController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


*//**
 * 失业定期待遇审核
 * 
 *//*
@Controller
@RequestMapping(value = "${adminPath}/unemployment/tapproved")
public class TapprovedController extends BaseController {

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

    @Resource
    private PreAccept preAccept;

    @Resource
    private MessagePush messagePush;

	@RequestMapping(value = {"list", ""})
	public String list(String type, String ywid, String hzdh, String slhzh, Model model) {

        Params params = new Params();
        long lsh000 = 123456;
        params.put("lsh000", lsh000);
        Result result = preAccept.queryByLsh000(params);
        System.out.println(result);

        params = new Params();
        params.put("aac058", "0");//发送对象的证件类型
        params.put("aac147", "123456123412341234");//发送对象的证件号
        params.put("businessName", "ceshi");//业务名称
        params.put("progress", "已办结");//业务进度名称
        result = messagePush.businessNoticeSend(params);
        System.out.println(result);

        boolean checkMultiLabel = false;
        List<Map<String, String>> types = new ArrayList<Map<String, String>>();
        Map<String, String> map;
        DYwinfo dYwinfo = dYwinfoService.get(ywid);
        DYwatter dYwatter = dYwatterService.getByYwId(ywid);
        List<PMaterialinfo> materialinfos = null;
        List<DYwtab> tabs = null;
        if (dYwinfo != null && StringUtils.isNotBlank(dYwinfo.getId())) {
            materialinfos = pMaterialinfoService.queryInfo(dYwinfo.getId());
            tabs = dYwtabService.findYwtabByYwId(dYwinfo.getId());
        }
        List<GtYwinfo> gtYwinfos = gtYwinfoService.findByHzdh(hzdh);
        String[] typeNames = {"门诊报销", "自费项目报销"};
        for (int i = 0; i < typeNames.length; i++) {
            map = new HashMap<String, String>();
            map.put("id", String.valueOf(i));
            map.put("name", typeNames[i]);
            types.add(map);
        }
        model.addAttribute("gtywinfos", gtYwinfos);
        model.addAttribute("hzdh", hzdh);
        model.addAttribute("slhzh", slhzh);
        model.addAttribute("type", type);
        model.addAttribute("types", types);
        model.addAttribute("checkMultiLabel", checkMultiLabel);
        model.addAttribute("ywatter", dYwatter);
        model.addAttribute("ywinfo", dYwinfo);
        model.addAttribute("cailiaoList", materialinfos);
        model.addAttribute("tabs", tabs);
		return "modules/gtxt/Unemployment/tapprovedList";
	}

	

	
	
	

}
*/