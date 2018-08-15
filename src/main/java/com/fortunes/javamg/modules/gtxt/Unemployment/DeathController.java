package com.fortunes.javamg.modules.gtxt.Unemployment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fortunes.javamg.common.web.BaseController;

/*
 * 失业死亡待遇
 */
@Controller
@RequestMapping(value = "${adminPath}/unemployment/death")
public class DeathController extends BaseController {
	
	@RequestMapping(value = {"list", ""})
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/gtxt/Unemployment/deathList";
	}
	//失业死亡待遇重申受理 unemploydead.jsp
	@RequestMapping(value = {"unemploydead"})
	public String unemploydead(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/gtxt/Unemployment/unemploydead";
	}
}