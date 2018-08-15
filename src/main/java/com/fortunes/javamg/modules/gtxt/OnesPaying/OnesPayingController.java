package com.fortunes.javamg.modules.gtxt.OnesPaying;

import com.fortunes.javamg.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanyanhong on 2016/9/15.
 */

@Controller
@RequestMapping(value = "${adminPath}/gtxt/OnesPaying")
public class OnesPayingController extends BaseController{

    /**
     * 趸缴与一次性缴费-
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"list",""})
    public String list(String type,HttpServletRequest request, HttpServletResponse response, Model model) {
        boolean checkMultiLabel = true;
      // String  typeName="趸缴类型";
        String  typeName="";
        List<Map<String, String>> types = new ArrayList<Map<String, String>>();
        Map<String, String> map;

       if(type.equals("WholesalePasure")){
          //趸缴养老保险费
            String[] typeNames={"本市户籍延续缴费人员","趸缴养老保险费",
            "高龄延续缴费人员一次性趸缴养老保险保险费","城镇职工基本养老" +
                    "保险延长缴费五年人员趸缴纳养老保险费"};
            for(int i = 0; i < typeNames.length; i++){
                map = new HashMap<String, String>();
                map.put("id", String.valueOf(i));
                map.put("name", typeNames[i]);
                types.add(map);
            }


        }else if(("OnesPaypasure").equals(type)){
           //一次性缴纳养老保险费
           String[] typeNames={"广东省离开机关事业单位人员一次性缴纳养老保险费",
                   "早期下乡知青一次性缴纳养老保险费",

                  };
           for(int i = 0; i < typeNames.length; i++){
               map = new HashMap<String, String>();
               map.put("id", String.valueOf(i));
               map.put("name", typeNames[i]);
               types.add(map);
           }
       }

        model.addAttribute("type", type);
        model.addAttribute("typename", typeName);
        model.addAttribute("types", types);
        model.addAttribute("checkMultiLabel", checkMultiLabel);
        return "modules/gtxt/OnesPaying/WholesaleOnesSL";
    }


    /**
     * 趸缴与一次性缴费-趸缴医疗保险费-受理页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"WholesaleYL"})
    public String WholesaleYL(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "modules/gtxt/OnesPaying/WholesaleYLSL";
    }


}
