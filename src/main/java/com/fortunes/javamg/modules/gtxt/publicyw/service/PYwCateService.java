/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PYwCate;
import com.fortunes.javamg.modules.gtxt.publicyw.dao.PYwCateDao;

/**
 * 公共业务类别Service
 * @author 杨
 * @version 2016-09-06
 */
@Service
@Transactional(readOnly = true)
public class PYwCateService extends CrudService<PYwCateDao, PYwCate> {

	public PYwCate get(String id) {
		return super.get(id);
	}
	
	public List<PYwCate> findList(PYwCate pYwCate) {
		return super.findList(pYwCate);
	}
	
	public Page<PYwCate> findPage(Page<PYwCate> page, PYwCate pYwCate) {
		return super.findPage(page, pYwCate);
	}
	
	@Transactional(readOnly = false)
	public void save(PYwCate pYwCate) {
		super.save(pYwCate);
	}
	
	@Transactional(readOnly = false)
	public void delete(PYwCate pYwCate) {
		super.delete(pYwCate);
	}
	
}