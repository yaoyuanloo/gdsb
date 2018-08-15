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
 * 自主创业一次性领取失业保险金（受理）
 * 
 */
@Controller
@RequestMapping(value = "${adminPath}/unemployment/entrepreneur")
public class EntrepreneurController extends BaseController {
	
	@RequestMapping(value = {"list", ""})
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("1111111111111111111111");
		return "modules/gtxt/Unemployment/entrepreneurList";
	}
	//自主创业一次性领取失业保险金重申selfInnovateOnce.jsp
	@RequestMapping(value = {"selfInnovateOnce"})
	public String selfInnovateOnce(HttpServletRequest request, HttpServletResponse response, Model model) {

		return "modules/gtxt/Unemployment/selfInnovateOnce";
	}
}
