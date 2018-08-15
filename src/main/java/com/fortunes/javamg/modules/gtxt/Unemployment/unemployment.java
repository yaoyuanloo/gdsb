package com.fortunes.javamg.modules.gtxt.Unemployment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fortunes.javamg.common.web.BaseController;

/*
 * 失业页面
 */
@Controller
@RequestMapping(value = "${adminPath}/gtxt/unemployment")
public class unemployment extends BaseController {
/**
 * 失业待遇发放变更
 * @param request
 * @param response
 * @param model
 * @return
 */
	@RequestMapping(value = {"dyprovidechange"})
	public String dyprovideChange(String type,HttpServletRequest request, HttpServletResponse response, Model model) {
		
		 String typeName = "失业待遇发放变更";
	        String path = "";
	        boolean checkMultiLabel = false;
	        List<Map<String, String>> types = new ArrayList<Map<String, String>>();
	        Map<String, String> map;   
	        String[] typeNames =  {"待遇停发", "待遇恢复","待遇终结"};
	            for(int i = 0; i < typeNames.length; i++){
	                map = new HashMap<String, String>();
	                map.put("id", String.valueOf(i));
	                map.put("name", typeNames[i]);
	                types.add(map);
	            }
	            //path = "modules/gtxt/pension/normalchange";
	        model.addAttribute("type", type);
	        model.addAttribute("typename", typeName);
	        model.addAttribute("types", types);
	        model.addAttribute("checkMultiLabel", checkMultiLabel);
		return "modules/gtxt/Unemployment/dyprovidechangesl";
	}
	/**
	 * 失业待遇转入接续-受理页面
	 * @param type
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"payinputfllow"})
	public String payInputFllow(String type,HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/gtxt/Unemployment/payInputFllowSL";
	}
	/**
	 * 失业待遇转入申请-受理页面
	 * @param type
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"payInputApply"})
	public String payInputApply(String type,HttpServletRequest request, HttpServletResponse response, Model model) {
		 String typeName = "失业待遇转入申请";
	        String path = "";
	        boolean checkMultiLabel = false;
	        List<Map<String, String>> types = new ArrayList<Map<String, String>>();
	        Map<String, String> map;   
	        String[] typeNames =  {"省内转入", "跨省转入","从部队转入"};
	            for(int i = 0; i < typeNames.length; i++){
	                map = new HashMap<String, String>();
	                map.put("id", String.valueOf(i));
	                map.put("name", typeNames[i]);
	                types.add(map);
	            }
	            //path = "modules/gtxt/pension/normalchange";
	        model.addAttribute("type", type);
	        model.addAttribute("typename", typeName);
	        model.addAttribute("types", types);
	        model.addAttribute("checkMultiLabel", checkMultiLabel);
		
		return "modules/gtxt/Unemployment/payInputApplySL";
	}
	/**
	 * 失业待遇转出-受理页面
	 * @param type
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"payoutPut"})
	public String payoutPut(String type,HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/gtxt/Unemployment/payoutputSL";
	}
	/**
	 * 失业待遇转出申请-受理页面
	 * @param type
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"payOutputApply"})
	public String payOutputApply(String type,HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/gtxt/Unemployment/payOutputApplySL";
	}
	/**
	 * 失业待遇失业一次性待遇追回-受理页面
	 * @param type
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"onespayBack"})
	public String onespayBack(String type,HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/gtxt/Unemployment/onespayBackSL";
	}
	
	/**
	 * 失业定期待遇追回-受理页面
	 * @param type
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"regularpayBack"})
	public String regularpayBack(String type,HttpServletRequest request, HttpServletResponse response, Model model) {
		 String typeName = "失业定期待遇追回";
	      
	        boolean checkMultiLabel = true;
	        List<Map<String, String>> types = new ArrayList<Map<String, String>>();
	        Map<String, String> map;   
	        String[] typeNames =  {"失业金", "求职补贴","临时价格补贴"};
	            for(int i = 0; i < typeNames.length; i++){
	                map = new HashMap<String, String>();
	                map.put("id", String.valueOf(i));
	                map.put("name", typeNames[i]);
	                types.add(map);
	            }
	            //path = "modules/gtxt/pension/normalchange";
	        model.addAttribute("type", type);
	        model.addAttribute("typename", typeName);
	        model.addAttribute("types", types);
	        model.addAttribute("checkMultiLabel", checkMultiLabel);
		
		return "modules/gtxt/Unemployment/regularpayBackSL";
	}
	
	/**
	 * 失业定期待遇重核-受理页面
	 * @param type
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"trapprovedAgin"})
	public String trapprovedAgin(String type,HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/gtxt/Unemployment/tapprovedAginSL";
	}
	
	/**
	 * 失业个人资料修改-受理页面
	 * @param type
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"personinfoUpdate"})
	public String personinfoUpdate(String type,HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/gtxt/Unemployment/personinfoUpdateSL";
	}

	/**
	 * 养老历史缴费补缴-受理页面
	 * @param type
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"pastureHistorybujiao"})
	public String pastureHistorybujiao(String type,HttpServletRequest request, HttpServletResponse response, Model model) {
		//String typeName = "补缴内容";
		String typeName = "";
	    boolean checkMultiLabel = true;
		List<Map<String, String>> types = new ArrayList<Map<String, String>>();
		Map<String, String> map;
		String[] typeNames =  {"补录", "补缴",};
		for(int i = 0; i < typeNames.length; i++){
			map = new HashMap<String, String>();
			map.put("id", String.valueOf(i));
			map.put("name", typeNames[i]);
			types.add(map);
		}

		model.addAttribute("type", type);
		model.addAttribute("typename", typeName);
		model.addAttribute("types", types);
		model.addAttribute("checkMultiLabel", checkMultiLabel);

		return "modules/gtxt/backUp/pastureHistorybjSL";
	}
	/**
	 *职工应参未参补缴-受理页面
	 * @param type
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"staffsinsuredYesNObj"})
	public String staffsinsuredYesNObj(String type,HttpServletRequest request, HttpServletResponse response, Model model) {
		//String typeName = "补缴内容";
		String typeName = "";
		boolean checkMultiLabel = true;
		List<Map<String, String>> types = new ArrayList<Map<String, String>>();
		Map<String, String> map;
		String[] typeNames =  {"养老", "医疗","工伤","失业","生育"};
		for(int i = 0; i < typeNames.length; i++){
			map = new HashMap<String, String>();
			map.put("id", String.valueOf(i));
			map.put("name", typeNames[i]);
			types.add(map);
		}

		model.addAttribute("type", type);
		model.addAttribute("typename", typeName);
		model.addAttribute("types", types);
		model.addAttribute("checkMultiLabel", checkMultiLabel);

		return "modules/gtxt/backUp/staffsinsuredYesNObjSL";
	}

	/**
	 *职工社会保险退费-受理页面
	 * @param type
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"staffssbrebate"})
	public String staffssbrebate(String type,HttpServletRequest request, HttpServletResponse response, Model model) {
		//String typeName = "退费内容";
		String typeName = "";
		boolean checkMultiLabel = true;
		List<Map<String, String>> types = new ArrayList<Map<String, String>>();
		Map<String, String> map;
		String[] typeNames =  {"养老", "医疗","工伤","失业","生育"};
		for(int i = 0; i < typeNames.length; i++){
			map = new HashMap<String, String>();
			map.put("id", String.valueOf(i));
			map.put("name", typeNames[i]);
			types.add(map);
		}

		model.addAttribute("type", type);
		model.addAttribute("typename", typeName);
		model.addAttribute("types", types);
		model.addAttribute("checkMultiLabel", checkMultiLabel);

		return "modules/gtxt/backUp/staffssbrebateSL";
	}

}
