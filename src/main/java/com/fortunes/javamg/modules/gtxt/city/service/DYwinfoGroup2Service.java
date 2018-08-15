/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwinfoGroup2;
import com.fortunes.javamg.modules.gtxt.city.dao.DYwinfoGroup2Dao;

/**
 * 本地业务属性定义Service
 * @author YUAN
 * @version 2016-09-07
 */
@Service
@Transactional(readOnly = true)
public class DYwinfoGroup2Service extends CrudService<DYwinfoGroup2Dao, DYwinfoGroup2> {

	public DYwinfoGroup2 get(String id) {
		return super.get(id);
	}
	
	public List<DYwinfoGroup2> findList(DYwinfoGroup2 dYwinfoGroup2) {
		return super.findList(dYwinfoGroup2);
	}
	
	public Page<DYwinfoGroup2> findPage(Page<DYwinfoGroup2> page, DYwinfoGroup2 dYwinfoGroup2) {
		return super.findPage(page, dYwinfoGroup2);
	}
	
	
	public List<DYwinfoGroup2> findChecksYwList() {
        return dao.findChecksYwList();
    }
	  public DYwinfoGroup2 getModePare(DYwinfoGroup2 targets) {
	        return dao.getModePare(targets);
	    }
	
	
	
	
	
	@Transactional(readOnly = false)
	public void save(DYwinfoGroup2 dYwinfoGroup2) {
		super.save(dYwinfoGroup2);
	}
	
	@Transactional(readOnly = false)
	public void delete(DYwinfoGroup2 dYwinfoGroup2) {
		super.delete(dYwinfoGroup2);
	}
	
}