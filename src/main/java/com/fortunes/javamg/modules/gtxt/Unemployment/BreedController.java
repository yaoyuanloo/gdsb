package com.fortunes.javamg.modules.gtxt.Unemployment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fortunes.javamg.common.web.BaseController;

/*
 * 生育加发失业保险
 */
@Controller
@RequestMapping(value = "${adminPath}/unemployment/breed")
public class BreedController extends BaseController {
	
	@RequestMapping(value = {"list", ""})
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("1111111111111111111111");
		return "modules/gtxt/Unemployment/breedList";
	}
	//生育加发失业保险金重申
	@RequestMapping(value = {"birthAddUnemploy"})
	public String birthAddUnemploy(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/gtxt/Unemployment/birthAddUnemploy";
	}
}
