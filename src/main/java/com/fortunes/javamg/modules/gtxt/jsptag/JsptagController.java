package com.fortunes.javamg.modules.gtxt.jsptag;

import com.fortunes.javamg.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wanyanhong on 2016/9/15.
 */

@Controller
@RequestMapping(value = "${adminPath}/gtxt/tag")
public class JsptagController extends BaseController{

    /**
     * 登记--家庭参保申报-受理页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"list",""})
    public String list(String tagid,HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("tagid",tagid);
        return "modules/gtxt/jsptag/taginfo";
    }





}
