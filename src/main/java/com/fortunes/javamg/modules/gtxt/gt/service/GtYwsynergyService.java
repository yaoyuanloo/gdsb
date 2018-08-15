/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwsynergy;
import com.fortunes.javamg.modules.gtxt.gt.dao.GtYwsynergyDao;

/**
 * 柜台协同从表Service
 * @author YANG
 * @version 2016-09-16
 */
@Service
@Transactional(readOnly = true)
public class GtYwsynergyService extends CrudService<GtYwsynergyDao, GtYwsynergy> {

	public GtYwsynergy get(String id) {
		return super.get(id);
	}
	
	public List<GtYwsynergy> findList(GtYwsynergy gtYwsynergy) {
		return super.findList(gtYwsynergy);
	}
	
	public Page<GtYwsynergy> findPage(Page<GtYwsynergy> page, GtYwsynergy gtYwsynergy) {
		return super.findPage(page, gtYwsynergy);
	}
	
	@Transactional(readOnly = false)
	public void save(GtYwsynergy gtYwsynergy) {
		super.save(gtYwsynergy);
	}
	
	@Transactional(readOnly = false)
	public void delete(GtYwsynergy gtYwsynergy) {
		super.delete(gtYwsynergy);
	}
	
}