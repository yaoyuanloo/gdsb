/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.dao.PMaterialinfoDao;

/**
 * 公共业务材料表Service
 * @author 杨
 * @version 2016-09-07
 */
@Service
@Transactional(readOnly = true)
public class PMaterialinfoService extends CrudService<PMaterialinfoDao, PMaterialinfo> {

	public PMaterialinfo get(String id) {
		return super.get(id);
	}
	
	public List<PMaterialinfo> findList(PMaterialinfo pMaterialinfo) {
		return super.findList(pMaterialinfo);
	}
	
	public Page<PMaterialinfo> findPage(Page<PMaterialinfo> page, PMaterialinfo pMaterialinfo) {
		return super.findPage(page, pMaterialinfo);
	}
	
	@Transactional(readOnly = false)
	public void save(PMaterialinfo pMaterialinfo) {
		super.save(pMaterialinfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(PMaterialinfo pMaterialinfo) {
		super.delete(pMaterialinfo);
	}
	
	public List<PMaterialinfo> queryInfo(String ywid){
		return dao.queryInfo(ywid);
	}
	
	public List<PMaterialinfo> qConditionCl(String tjid){
		return dao.qConditionCl(tjid);
	}
	
	public List<PMaterialinfo> queryid(String id){
		return dao.queryInfo(id);
	}
	public List<PMaterialinfo> queryXl(String id){
		return dao.queryXl(id);
	}
	
}