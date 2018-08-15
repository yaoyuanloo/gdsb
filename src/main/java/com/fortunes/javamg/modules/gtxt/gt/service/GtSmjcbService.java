/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtSmjcb;
import com.fortunes.javamg.modules.gtxt.gt.dao.GtSmjcbDao;

/**
 * 扫描件清单表Service
 * @author Yang
 * @version 2016-09-09
 */
@Service
@Transactional(readOnly = true)
public class GtSmjcbService extends CrudService<GtSmjcbDao, GtSmjcb> {

	public GtSmjcb get(String id) {
		return super.get(id);
	}
	
	public List<GtSmjcb> findList(GtSmjcb gtSmjcb) {
		return super.findList(gtSmjcb);
	}
	
	public Page<GtSmjcb> findPage(Page<GtSmjcb> page, GtSmjcb gtSmjcb) {
		return super.findPage(page, gtSmjcb);
	}
	
	@Transactional(readOnly = false)
	public void save(GtSmjcb gtSmjcb) {
		super.save(gtSmjcb);
	}
	
	@Transactional(readOnly = false)
	public void delete(GtSmjcb gtSmjcb) {
		super.delete(gtSmjcb);
	}
	
	public List<GtSmjcb> getByJid(String jId){
		return dao.getByJid(jId);
	}
	public List<GtSmjcb> queryMateriainfoName(String id){
		return dao.queryMateriainfoName(id);
	}
	
	
	
}