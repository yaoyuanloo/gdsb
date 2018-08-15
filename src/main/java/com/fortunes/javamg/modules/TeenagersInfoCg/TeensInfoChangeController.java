package com.fortunes.javamg.modules.TeenagersInfoCg;

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
@RequestMapping(value = "${adminPath}/gtxt/TeensInfoChange")
public class TeensInfoChangeController extends BaseController{

    /**
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"list",""})
    public String list(String type,HttpServletRequest request, HttpServletResponse response, Model model) {
        boolean checkMultiLabel = true;
        List<Map<String, String>> types = new ArrayList<Map<String, String>>();
        Map<String, String> map;
       // String typeName="变更内容";
        String typeName="";
        //信息变更--未成年单位缴费信息变更-受理页面
       if(type.equals("CompanyPaychange")){
            String[] typeNames={"注销","恢复"};
            for(int i = 0; i < typeNames.length; i++){
                map = new HashMap<String, String>();
                map.put("id", String.valueOf(i));
                map.put("name", typeNames[i]);
                types.add(map);
            }

        }else if (("RegularInfoChange").equals(type)){
           //信息变更--未成年参保普通信息变更-受理页面
            String[] typeNames={"人员类别","户籍性质","户籍类别","预计毕业年月",
            "银行信息","家庭信息","监护人信息","其他信息"};
            for(int i = 0; i < typeNames.length; i++){
                map = new HashMap<String, String>();
                map.put("id", String.valueOf(i));
                map.put("name", typeNames[i]);
                types.add(map);
            }
        }else if(("ImportInfoChange").equals(type)){
           //信息变更--未成年参保重要信息变更-受理页面
            String[] typeNames={"姓名","身份证号"};
            for(int i = 0; i < typeNames.length; i++){
                map = new HashMap<String, String>();
                map.put("id", String.valueOf(i));
                map.put("name", typeNames[i]);
                types.add(map);
            }
        }else if( ("PayInfoChange").equals(type)){
           //信息变更--未成年人缴费信息变动-受理页面
            String[] typeNames={"停保","恢复","缴费开始年月"};
            for(int i = 0; i < typeNames.length; i++){
                map = new HashMap<String, String>();
                map.put("id", String.valueOf(i));
                map.put("name", typeNames[i]);
                types.add(map);
            }
        }else if(("NationalChange").equals(type)){
           //信息变更--未成年人国籍变动-受理页面
            String[] typeNames={"中国转成港澳台外籍人员","港澳台外籍人员","转成中国国籍"};
            for(int i = 0; i < typeNames.length; i++){
                map = new HashMap<String, String>();
                map.put("id", String.valueOf(i));
                map.put("name", typeNames[i]);
                types.add(map);
            }
        }else if(("CompanyInfoChange").equals(type)){
           //信息变更-未成年单位信息变更-受理页面
            String[] typeNames={"单位名称","组织机构","单位地址","法人代表",
                    "缴费方式","网上密码","单位类别","银行信息","行政管理信息","其他信息"};
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
        return "modules/gtxt/TeenagersInfoCg/CompanyPaychangeSL";
    }






    /**
     * 信息变更--未成年人管理单位变动-受理页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"CompanyChange"})
    public String CompanyChange(String type,HttpServletRequest request, HttpServletResponse response, Model model) {

        boolean checkMultiLabel = true;
        List<Map<String, String>> types = new ArrayList<Map<String, String>>();
        Map<String, String> map;
      //  String typeName = "变动内容";
        String typeName = "";
        String[] typeNames = {"学校转个人", "个人转学校"};
        for (int i = 0; i < typeNames.length; i++) {
            map = new HashMap<String, String>();
            map.put("id", String.valueOf(i));
            map.put("name", typeNames[i]);
            types.add(map);
        }
        model.addAttribute("type", type);
        model.addAttribute("typename", typeName);
        model.addAttribute("types", types);
        model.addAttribute("checkMultiLabel", checkMultiLabel);
        return "modules/gtxt/TeenagersInfoCg/CompanyChangeSL";
    }
}
