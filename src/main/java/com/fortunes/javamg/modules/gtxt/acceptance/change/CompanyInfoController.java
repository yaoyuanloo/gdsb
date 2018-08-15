package com.fortunes.javamg.modules.gtxt.acceptance.change;

import com.fortunes.javamg.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cxd on 2016/11/3 0003.
 */
@Controller
@RequestMapping(value = "${adminPath}/gtxt/accept/companyinfo")
public class CompanyInfoController extends BaseController {

    @RequestMapping(value = "change")
    public String change(){

        return "modules/gtxt/acceptance/change/companyInfoChange";
    }
}
