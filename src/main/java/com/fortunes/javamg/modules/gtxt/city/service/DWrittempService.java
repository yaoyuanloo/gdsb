/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.city.entity.DWrittemp;
import com.fortunes.javamg.modules.gtxt.city.dao.DWrittempDao;

/**
 * 地级市业务分类Service
 * @author 杨
 * @version 2016-09-06
 */
@Service
@Transactional(readOnly = true)
public class DWrittempService extends CrudService<DWrittempDao, DWrittemp> {

	public DWrittemp get(String id) {
		return super.get(id);
	}
	
	public List<DWrittemp> findList(DWrittemp dWrittemp) {
		return super.findList(dWrittemp);
	}
	
	public Page<DWrittemp> findPage(Page<DWrittemp> page, DWrittemp dWrittemp) {
		return super.findPage(page, dWrittemp);
	}
	
	@Transactional(readOnly = false)
	public void save(DWrittemp dWrittemp) {
		super.save(dWrittemp);
	}
	
	@Transactional(readOnly = false)
	public void delete(DWrittemp dWrittemp) {
		super.delete(dWrittemp);
	}
	
}