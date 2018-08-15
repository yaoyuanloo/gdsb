package com.fortunes.javamg.modules.gtxt.acceptance.transfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.modules.gtxt.city.service.DYwatterService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwinfoService;
import com.fortunes.javamg.modules.gtxt.city.service.DYwtabService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfoService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinfocbService;
import com.fortunes.javamg.modules.gtxt.gt.service.GtYwinputService;
import com.fortunes.javamg.modules.gtxt.publicyw.service.PMaterialinfoService;

@Controller
@RequestMapping(value = "${adminPath}/gtxt/accept/transfer")
public class TransferController extends BaseController {

	@Autowired
	private DYwinfoService dYwinfoService;
	@Autowired
	private GtYwinputService gtYwinputService;
	@Autowired
	private GtYwinfoService gtYwinfoService;
	@Autowired
	private GtYwinfocbService gtYwinfocbService;
	@Autowired
	private DYwatterService dYwatterService;
	@Autowired
	private PMaterialinfoService pMaterialinfoService;
	@Autowired
	private DYwtabService dYwtabService;

	//
	@RequestMapping(value = { "list" })
	public String list() {
		return "modules/gtxt/acceptance/pension/stjzList";
	}

	// 部队养老保险关系转出受理
	@RequestMapping(value = { "armyPensonLinkTranster" })
	public String armyPensonLinkTranster(String type, Model model) {
		String typeName = "账户标记";
		boolean checkMultiLabel = false;
		List<Map<String, String>> types = new ArrayList<Map<String, String>>();
		Map<String, String> map;
		String[] typeNames = { "一般账户", "临时账户" };
		for (int i = 0; i < typeNames.length; i++) {
			map = new HashMap<String, String>();
			map.put("id", String.valueOf(i));
			map.put("name", typeNames[i]);
			types.add(map);
		}
		// path = "modules/gtxt/pension/normalchange";
		model.addAttribute("type", type);
		model.addAttribute("typename", typeName);
		model.addAttribute("types", types);
		model.addAttribute("checkMultiLabel", checkMultiLabel);

		return "modules/gtxt/acceptance/transter/armyPensionTranster";
	}

	// 部队养老关系转入 受理
	@RequestMapping(value = { "armypensionIn" })
	public String armypensionIn() {
		return "modules/gtxt/acceptance/transter/armypensionIn";
	}

	// 部队养老关系申请 受理
	@RequestMapping(value = { "armypensionapply" })
	public String armypensionapply() {
		return "modules/gtxt/acceptance/transter/armypensionlinkInApply";
	}

	// 行业统筹企业养老保险关系转出 受理
	@RequestMapping(value = { "pensionOuthytc" })
	public String pensionOuthytc() {

		return "modules/gtxt/acceptance/transter/pensionOuthytc";
	}

	// 行业统筹企业养老保险关系转入 受理
	@RequestMapping(value = { "pensionInhytc" })
	public String pensionInhytc() {

		return "modules/gtxt/acceptance/transter/pensionInhytc";
	}

	// 跨省养老关系转出 受理
	@RequestMapping(value = { "outshenpensionout" })
	public String outshenpensionout() {

		return "modules/gtxt/acceptance/transter/outshenpensionout";
	}

	// 跨省养老关系转入 受理
	@RequestMapping(value = { "outshenpensionIn" })
	public String outshenpensionIn() {

		return "modules/gtxt/acceptance/transter/outshenpensionIn";
	}

	// 跨省失业保险关系转入 受理
	@RequestMapping(value = { "outSUnemploylinkInApply" })
	public String outSUnemploylinkInApply() {

		return "modules/gtxt/acceptance/transter/outSUnemploylinkInApply";
	}

	// 跨省养老保险关系转出 受理
	@RequestMapping(value = { "outshenBxpensionout" })
	public String outshenBxpensionout() {

		return "modules/gtxt/acceptance/transter/outshenBxpensionout";
	}

	// 跨省养老保险关系转入 受理
	@RequestMapping(value = { "outshenBxpensionIn" })
	public String outshenBxpensionIn() {

		return "modules/gtxt/acceptance/transter/outshenBxpensionIn";
	}

	// 跨省养老保险关系转入申请 受理
	@RequestMapping(value = { "outpensionBxlinkInApply" })
	public String outpensionBxlinkInApply() {

		return "modules/gtxt/acceptance/transter/outpensionBxlinkInApply";
	}

	// 跨省医疗保险关系转出 受理
	@RequestMapping(value = { "outYlBxLinkOut" })
	public String outYlBxLinkOut() {

		return "modules/gtxt/acceptance/transter/outYlBxLinkOut";
	}

	// 跨省医疗保险关系转入 受理
	@RequestMapping(value = { "outYlBxLinkIn" })
	public String outYlBxLinkIn() {

		return "modules/gtxt/acceptance/transter/outYlBxLinkIn";
	}

	// 跨省医疗保险关系转入申请 受理
	@RequestMapping(value = { "outYlBxlinkInApply" })
	public String outYlBxlinkInApply() {

		return "modules/gtxt/acceptance/transter/outYlBxlinkInApply";
	}

	// 省内失业保险关系转出 受理
	@RequestMapping(value = { "inunployeeBxLinkOut" })
	public String inunployeeBxLinkOut() {

		return "modules/gtxt/acceptance/transter/inunployeeBxLinkOut";
	}

	// 省内失业保险关系转入 受理
	@RequestMapping(value = { "inunemployeeBxLinkIn" })
	public String inunemployeeBxLinkIn() {

		return "modules/gtxt/acceptance/transter/inunemployeeBxLinkIn";
	}

	// 省内养老保险关系转入申请 受理
	@RequestMapping(value = { "inpensionBxLinkInApply" })
	public String inpensionBxLinkInApply() {

		return "modules/gtxt/acceptance/transter/inpensionBxLinkInApply";
	}

	// 省内养老保险关系转出 受理
	@RequestMapping(value = { "inpensionBxLinkout" })
	public String inpensionBxLinkout() {

		return "modules/gtxt/acceptance/transter/inpensionBxLinkout";
	}

	// 省内养老保险关系转入 受理
	@RequestMapping(value = { "inspensionBxlinkIn" })
	public String inspensionBxlinkIn() {

		return "modules/gtxt/acceptance/transter/inspensionBxlinkIn";
	}

	// 省内医疗保险关系转出 受理
	@RequestMapping(value = { "inylBxLinkout" })
	public String inylBxLinkout() {
        System.out.println("11111111111111");
		return "modules/gtxt/acceptance/transter/inylBxLinkout";
	}

	// 省内医疗保险关系转入 受理
	@RequestMapping(value = { "inylBxLinkin" })
	public String inylBxLinkin() {

		return "modules/gtxt/acceptance/transter/inylBxLinkin";
	}

	// 省内医疗保险关系转入申请
	@RequestMapping(value = { "inYlBxLinkInApply" })
	public String inYlBxLinkInApply() {
//		return "modules/gtxt/acceptance/transter/inYlBxLinkInApply";
		return "modules/gtxt/acceptance/transter/inYlBxLinkInApply";
	}
	// 跨省失业保险关系转出 受理
	@RequestMapping(value = { "outOut" })
	public String outOut() {

	  return "modules/gtxt/acceptance/transter/inylBxLinkin";
	}
	// 跨省失业保险关系转入申请 受理
	@RequestMapping(value = { "outSUnemploylinkInApplysl" })
	public String outSUnemploylinkInApplysl() {
		return "modules/gtxt/acceptance/transter/outSUnemploylinkInApplysl";
	}
   // 省内失业保险关系转入申请  
	@RequestMapping(value = { "inunemployeeBxLinkInApply" })
	public String inunemployeeBxLinkInApply() {
		return "modules/gtxt/acceptance/transter/inunemployeeBxLinkInApply";
	}
	 // 跨省养老保险参保缴费凭证  
	@RequestMapping(value = { "outpensionPay" })
	public String outpensionPay() {
		return "modules/gtxt/acceptance/transter/outpensionPay";
	}
	 // 临时账户转移联系函打印（养老跨省）  
	@RequestMapping(value = { "accuntpensionPrint" })
	public String accuntpensionPrint() {
		return "modules/gtxt/acceptance/transter/accuntpensionPrint";
	}
	// 医疗缴费凭证打印  
	@RequestMapping(value = { "ylpayPrint" })
	public String ylpayPrint() {
		return "modules/gtxt/acceptance/transter/ylpayPrint";
	}
	// 医疗保险关系转入申请（东软） 
	@RequestMapping(value = { "ylBxLinkInApply" })
	public String ylBxLinkInApply() {
		return "modules/gtxt/acceptance/transter/ylBxLinkInApply";
	}
	// 城乡养老缴费凭证打印（东软） 
	@RequestMapping(value = { "cityPensionPrint" })
	public String cityPensionPrint() {
		return "modules/gtxt/acceptance/transter/cityPensionPrint";
	}
	// 城乡养老保险转入申请（东软） 
	@RequestMapping(value = { "cityPensionInApply" })
	public String cityPensionInApply() {
		return "modules/gtxt/acceptance/transter/cityPensionInApply";
	}
}
