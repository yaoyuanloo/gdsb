/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfocb;
import com.fortunes.javamg.modules.gtxt.gt.dao.GtYwinfocbDao;

/**
 * 柜台受理业务从表Service
 * @author Yang
 * @version 2016-09-09
 */
@Service
@Transactional(readOnly = true)
public class GtYwinfocbService extends CrudService<GtYwinfocbDao, GtYwinfocb> {

	public GtYwinfocb get(String id) {
		return super.get(id);
	}
	
	public List<GtYwinfocb> findList(GtYwinfocb gtYwinfocb) {
		return super.findList(gtYwinfocb);
	}
	
	public Page<GtYwinfocb> findPage(Page<GtYwinfocb> page, GtYwinfocb gtYwinfocb) {
		return super.findPage(page, gtYwinfocb);
	}
	
	@Transactional(readOnly = false)
	public void save(GtYwinfocb gtYwinfocb) {
		super.save(gtYwinfocb);
	}
	
	@Transactional(readOnly = false)
	public void delete(GtYwinfocb gtYwinfocb) {
		super.delete(gtYwinfocb);
	}
	
}