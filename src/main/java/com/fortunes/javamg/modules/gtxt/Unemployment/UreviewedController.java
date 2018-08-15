package com.fortunes.javamg.modules.gtxt.Unemployment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fortunes.javamg.common.web.BaseController;


/*
 * 失业窗口审核
 */
@Controller
@RequestMapping(value = "${adminPath}/unemployment/ureviewed")
public class UreviewedController extends BaseController {
	
	@RequestMapping(value = {"list", ""})
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/gtxt/Unemployment/ureviewedList";
	}

	

	
	
	

}
