/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.city.entity.DWrittempinfo;
import com.fortunes.javamg.modules.gtxt.city.dao.DWrittempinfoDao;

/**
 * 文书模板信息表Service
 * @author YANG
 * @version 2016-09-07
 */
@Service
@Transactional(readOnly = true)
public class DWrittempinfoService extends CrudService<DWrittempinfoDao, DWrittempinfo> {

	public DWrittempinfo get(String id) {
		return super.get(id);
	}
	
	public List<DWrittempinfo> findList(DWrittempinfo dWrittempinfo) {
		return super.findList(dWrittempinfo);
	}
	
	public Page<DWrittempinfo> findPage(Page<DWrittempinfo> page, DWrittempinfo dWrittempinfo) {
		return super.findPage(page, dWrittempinfo);
	}
	
	@Transactional(readOnly = false)
	public void save(DWrittempinfo dWrittempinfo) {
		super.save(dWrittempinfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(DWrittempinfo dWrittempinfo) {
		super.delete(dWrittempinfo);
	}
	public List<DWrittempinfo> finddwrittempinfoist(String zone) {
		return dao.finddwrittempinfoist(zone);
	}
	
}