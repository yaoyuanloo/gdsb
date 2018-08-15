package com.fortunes.javamg.modules.gtxt.acceptance.archives;

import java.util.HashMap;
import java.util.Map;

import com.fortunes.gtxt.dubbo.GtxtListResult;
import com.fortunes.javamg.common.config.Global;
import com.fortunes.javamg.common.web.BaseController;
import com.insigma.dubbo.api.PersonnelArchiveService;
import com.insigma.dubbo.bean.SimpleMapParam;
import com.insigma.dubbo.bean.SimpleResult;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Coradisan on 2016/10/17 0017.
 */
@Controller
@RequestMapping(value = "${adminPath}/wx/WXCompany")
public class WXController extends BaseController {
	
	
	
//	@Resource
    private PersonnelArchiveService personnelArchives;
	
    /**
     * 档案借阅登记
     */
    @RequestMapping(value = "dajydj")
    public String dajydj(HttpServletRequest request, HttpServletResponse response, Model model) {
    	return "modules/gtxt/acceptance/archives/dajydj";
    }
    
    
    @RequestMapping(value = "dajydjsave")
    public String dajydjsave(HttpServletRequest request, HttpServletResponse response, Model model,String aac002,String aac003,String bec063,String aab004,String bee015,String bec085,String bec089,RedirectAttributes redirectAttributes) {
    	if(aac002==null || "".equals(aac002)){
    		return "modules/gtxt/acceptance/archives/dajydj";
    	}
    	System.out.println("aac002:"+aac002);
    	System.out.println("aac003:"+aac003);
    	System.out.println("bec063:"+bec063);
    	System.out.println("aab004:"+aab004);
    	System.out.println("bee015:"+bee015);
    	System.out.println("bec085:"+bec085);
    	System.out.println("bec089:"+bec089);
    	Map<String,String> maps=new HashMap<String, String>();
    	maps.put("aac002",aac002);
    	maps.put("aac003",aac003);
    	maps.put("bec063",bec063);
    	maps.put("aab004",aab004);
    	maps.put("bee015",bee015);
    	maps.put("bec085",bec085);
    	maps.put("bec089",bec089);
    	SimpleMapParam<Map<String,String>>  map = new SimpleMapParam<Map<String,String>>(maps);
    	SimpleResult sr = null;
		try {
			sr = personnelArchives.saveBorrowRecord(map);
			System.out.println("网新借阅添加:"+sr.getErrorCode());
			if("0".equals(sr.getErrorCode())){
				addMessage(redirectAttributes, "借阅成功!");
			}else{
				addMessage(redirectAttributes, "借阅失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "redirect:"+Global.getAdminPath()+"/wx/WXCompany/dajydj";
    }

    /**
     * 档案查阅登记
     * @throws
     */
    @RequestMapping(value = "dacydj")
    public String dacydj(HttpServletRequest request, HttpServletResponse response, Model model){
    	return "modules/gtxt/acceptance/archives/dacydj";
    }

    
    
    @RequestMapping(value = "dacydjsave")
    public String dacydjsave(HttpServletRequest request, HttpServletResponse response, Model model,String aac002,String aac003,String bec063,String aab004,String bee023,String bee024,String bec085,String bec089,RedirectAttributes redirectAttributes){
    	if(aac002==null || "".equals(aac002)){
    		return "modules/gtxt/acceptance/archives/dacydj";
    	}
    	System.out.println("aac002:"+aac002);
    	System.out.println("aac003:"+aac002);
    	System.out.println("bec063:"+bec063);
    	System.out.println("aab004:"+aab004);
    	System.out.println("bee023:"+bee023);
    	System.out.println("bee024:"+bee024);
    	System.out.println("bec085:"+bec085);
    	System.out.println("bec089:"+bec089);
    	Map<String,String> maps=new HashMap<String, String>();
    	maps.put("aac002",aac002);
    	maps.put("aac003",aac003);
    	maps.put("bec063",bec063);
    	maps.put("aab004",aab004);
    	maps.put("bee023",bee023);
    	maps.put("bee024",bee024);
    	maps.put("bec085",bec085);
    	maps.put("bec089",bec089);
    	SimpleMapParam<Map<String,String>>  map = new SimpleMapParam<Map<String,String>>(maps);
    	SimpleResult sr = null;
		try {
			sr = personnelArchives.saveReviewRecord(map);
			System.out.println("网新查阅添加:"+sr.getErrorCode());
			if("0".equals(sr.getErrorCode())){
				addMessage(redirectAttributes, "借阅成功!");
			}else{
				addMessage(redirectAttributes, "借阅失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:"+Global.getAdminPath()+"/wx/WXCompany/dacydj";
    }
    /**
     * 档案归还
     */
    @RequestMapping(value = "dagh")
    public String dagh(HttpServletRequest request, HttpServletResponse response, Model model) {
     	return "modules/gtxt/acceptance/archives/dagh";
    }
    
    /*
     * 查询档案归还
     */
    @ResponseBody
	@RequestMapping(value = "returnedfile")
	public Map<String,Object> returnedfile(String bec085) {
    	Map<String,Object>  map = new HashMap<String, Object>();
    	
    	GtxtListResult<Map<String, Object>> ras=personnelArchives.returnQueryByArchiveCode(bec085);
     	 for (Map<String, Object> m : ras.getList())  
         {  
           for (String k : m.keySet())  
           {  
        	   map.put(k, m.get(k));
           }  
         }
     	 return map;
	}

    /**
     * 档案证明开具
     */
    @RequestMapping(value = "dazmkj")
    public String dazmkj(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "modules/gtxt/acceptance/archives/dazmkj";
        
        
    }
    
    @RequestMapping(value = "dazmkjsave")
    public String dazmkjsave(HttpServletRequest request, HttpServletResponse response, Model model,String aac002,String aac003,String bec100,RedirectAttributes redirectAttributes) {
    	if(aac002==null){
    		return "modules/gtxt/acceptance/archives/dazmkj";
    	}
    	System.out.println("aac002:"+aac002);
    	System.out.println("aac003:"+aac003);
    	System.out.println("bec100:"+bec100);
    	Map<String,String> maps=new HashMap<String, String>();
    	maps.put("aac002",aac002);
    	maps.put("aac003",aac003);
    	maps.put("bec100",bec100);
    	SimpleMapParam<Map<String,String>>  map = new SimpleMapParam<Map<String,String>>(maps);
    	SimpleResult sr = null;
		try {
			sr = personnelArchives.saveConfirmation(map);
			System.out.println("网新查阅添加:"+sr.getErrorCode());
			if("0".equals(sr.getErrorCode())){
				addMessage(redirectAttributes, "开具证明成功!");
			}else{
				addMessage(redirectAttributes, "开具证明失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return "redirect:"+Global.getAdminPath()+"/wx/WXCompany/dazmkj";
    }

    /**
     * 档案转入受理登记
     */
    @RequestMapping(value = "dazrsldj")
    public String dazrsldj(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "modules/gtxt/acceptance/archives/dazrsldj";
    }


    /**
     * 档案转入登记
     */
    @RequestMapping(value = "dazrdj")
    public String dazrdj(HttpServletRequest request, HttpServletResponse response, Model model) {
    /*	SimpleBeanParam<PersonnelArchiveView> viewData=new SimpleBeanParam<PersonnelArchiveView>();
    	PersonnelArchiveView pv=new PersonnelArchiveView();
    	pv.getAab004()
    	viewData.setT(t);
    	personnelArchives.transINregister(arg0)*/
    	
    	return "modules/gtxt/acceptance/archives/dazrdj";
    }
    
    
   
}