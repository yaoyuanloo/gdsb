/**
 * 
 */
package com.fortunes.javamg.modules.gen.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.utils.StringUtils;
import com.fortunes.javamg.common.web.BaseController;
import com.fortunes.javamg.modules.sys.entity.User;
import com.fortunes.javamg.modules.sys.utils.UserUtils;
import com.fortunes.javamg.modules.gen.entity.GenTable;
import com.fortunes.javamg.modules.gen.service.GenTableService;
import com.fortunes.javamg.modules.gen.util.GenUtils;

/**
 * 业务表Controller
 * 业务表配置
 * @version 2013-10-15
 */
@Controller
@RequestMapping(value = "${adminPath}/gen/genTable")
public class GenTableController extends BaseController {

	@Autowired
	private GenTableService genTableService;
	
	@ModelAttribute
	public GenTable get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return genTableService.get(id);
		}else{
			return new GenTable();
		}
	}
	
	/**业务表列表*/
	@RequiresPermissions("gen:genTable:view")
	@RequestMapping(value = {"list", ""})
	public String list(GenTable genTable, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			genTable.setCreateBy(user);
		}
        Page<GenTable> page = genTableService.find(new Page<GenTable>(request, response), genTable); //获取业务表列表
        model.addAttribute("page", page);
		return "modules/gen/genTableList";
	}
	
	/**业务表添加*/
	@RequiresPermissions("gen:genTable:view")
	@RequestMapping(value = "form")
	public String form(GenTable genTable, Model model) {
		// 验证表是否存在	//genTable.id为空，并且genTable.name已经存在     则失败
		if (StringUtils.isBlank(genTable.getId()) && !genTableService.checkTableName(genTable.getName())){
			addMessage(model, "下一步失败！" + genTable.getName() + " 表已经添加！");
			genTable.setName("");
		}
		// 获取物理表字段
		else{
			genTable = genTableService.getTableFormDb(genTable);//修改业务表的时候用，由于查询里边有性能优化，这里就不用判断是否是修改了
		}
		// 获取物理表列表 tableList 本来这段实在该方法顶部的
		List<GenTable> tableList = genTableService.findTableListFormDb(new GenTable());
		model.addAttribute("tableList", tableList);//添加和修改的时候都用到
		model.addAttribute("genTable", genTable);//修改业务表的时候用到
		model.addAttribute("config", GenUtils.getConfig());
		return "modules/gen/genTableForm";
	}

	@RequiresPermissions("gen:genTable:edit")
	@RequestMapping(value = "save")
	public String save(GenTable genTable, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, genTable)){
			return form(genTable, model);
		}
		// 验证表是否已经存在
		if (StringUtils.isBlank(genTable.getId()) && !genTableService.checkTableName(genTable.getName())){
			addMessage(model, "保存失败！" + genTable.getName() + " 表已经存在！");
			genTable.setName("");
			return form(genTable, model);
		}
		genTableService.save(genTable);
		addMessage(redirectAttributes, "保存业务表'" + genTable.getName() + "'成功");
		return "redirect:" + adminPath + "/gen/genTable/?repage";
	}
	
	@RequiresPermissions("gen:genTable:edit")
	@RequestMapping(value = "delete")
	public String delete(GenTable genTable, RedirectAttributes redirectAttributes) {
		genTableService.delete(genTable);
		addMessage(redirectAttributes, "删除业务表成功");
		return "redirect:" + adminPath + "/gen/genTable/?repage";
	}

}
