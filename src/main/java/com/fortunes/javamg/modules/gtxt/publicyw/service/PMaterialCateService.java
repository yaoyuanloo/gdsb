/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialCate;
import com.fortunes.javamg.modules.gtxt.publicyw.dao.PMaterialCateDao;

/**
 * 业务材料分类Service
 * @author 杨
 * @version 2016-09-07
 */
@Service
@Transactional(readOnly = true)
public class PMaterialCateService extends CrudService<PMaterialCateDao, PMaterialCate> {
	@Autowired
	private PMaterialCateDao pMaterialCateDao;
	
	
	public PMaterialCate get(String id) {
		return super.get(id);
	}
	
	public List<PMaterialCate> findList(PMaterialCate pMaterialCate) {
		return super.findList(pMaterialCate);
	}
	
	public Page<PMaterialCate> findPage(Page<PMaterialCate> page, PMaterialCate pMaterialCate) {
		return super.findPage(page, pMaterialCate);
	}
	
	@Transactional(readOnly = false)
	public void save(PMaterialCate pMaterialCate) {
		super.save(pMaterialCate);
	}
	
	@Transactional(readOnly = false)
	public void delete(PMaterialCate pMaterialCate) {
		super.delete(pMaterialCate);
	}
	
	public List<PMaterialCate> findAll() {
		return pMaterialCateDao.findAll();
	}
	
}