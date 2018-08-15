package com.fortunes.javamg.modules.gtxt.Unemployment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fortunes.javamg.common.web.BaseController;

/*
 * 稳定就业一次性失业保险金
 */
@Controller
@RequestMapping(value = "${adminPath}/unemployment/steady")
public class SteadyController extends BaseController {
	
	@RequestMapping(value = {"list", ""})
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("1111111111111111111111");
		return "modules/gtxt/Unemployment/steadyList";
	}
	//稳定就业一次性失业保险保险金重申
	@RequestMapping(value = {"stableEmployOnce"})
	public String stableEmployOnce(HttpServletRequest request, HttpServletResponse response, Model model) {

		return "modules/gtxt/Unemployment/stableEmployOnce"; 
	}
}
