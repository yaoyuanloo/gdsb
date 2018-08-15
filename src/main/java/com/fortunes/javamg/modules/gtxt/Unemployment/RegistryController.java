/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.Unemployment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.fortunes.javamg.common.web.BaseController;


/**
 * 非广东省户籍人员一次性失业保险金（受理）
 * 
 */
@Controller
@RequestMapping(value = "${adminPath}/unemployment/registry")
public class RegistryController extends BaseController {
	
	@RequestMapping(value = {"list", ""})
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("1111111111111111111111");
		return "modules/gtxt/Unemployment/registry";
	}
	//非广东省户籍人员一次性失业保险金 重申 notGuangzhouCH.jsp
	@RequestMapping(value = {"notGuangzhouCH", ""})
	public String notGuangzhouCH(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/gtxt/Unemployment/notGuangzhouCH";
	}
}
