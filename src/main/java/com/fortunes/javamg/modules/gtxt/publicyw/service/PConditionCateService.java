/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PConditionCate;
import com.fortunes.javamg.modules.gtxt.publicyw.dao.PConditionCateDao;

/**
 * 业务条件分类Service
 * @author YANG
 * @version 2016-09-07
 */
@Service
@Transactional(readOnly = true)
public class PConditionCateService extends CrudService<PConditionCateDao, PConditionCate> {

	public PConditionCate get(String id) {
		return super.get(id);
	}
	
	public List<PConditionCate> findList(PConditionCate pConditionCate) {
		return super.findList(pConditionCate);
	}
	
	public Page<PConditionCate> findPage(Page<PConditionCate> page, PConditionCate pConditionCate) {
		return super.findPage(page, pConditionCate);
	}
	
	@Transactional(readOnly = false)
	public void save(PConditionCate pConditionCate) {
		super.save(pConditionCate);
	}
	
	@Transactional(readOnly = false)
	public void delete(PConditionCate pConditionCate) {
		super.delete(pConditionCate);
	}
	
	public List<PConditionCate> findAll(){
		return dao.findAll();
	}
	
}