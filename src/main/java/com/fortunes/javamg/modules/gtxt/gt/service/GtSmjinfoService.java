/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtSmjinfo;
import com.fortunes.javamg.modules.gtxt.gt.dao.GtSmjinfoDao;

/**
 * 业务影像表Service
 * @author Yang
 * @version 2016-09-10
 */
@Service
@Transactional(readOnly = true)
public class GtSmjinfoService extends CrudService<GtSmjinfoDao, GtSmjinfo> {

	public GtSmjinfo get(String id) {
		return super.get(id);
	}
	
	public List<GtSmjinfo> findList(GtSmjinfo gtSmjinfo) {
		return super.findList(gtSmjinfo);
	}
	
	public Page<GtSmjinfo> findPage(Page<GtSmjinfo> page, GtSmjinfo gtSmjinfo) {
		return super.findPage(page, gtSmjinfo);
	}
	
	@Transactional(readOnly = false)
	public void save(GtSmjinfo gtSmjinfo) {
		super.save(gtSmjinfo);
	}
	
	@Transactional(readOnly = false)
	public int update(GtSmjinfo gtSmjinfo) {
		return dao.update(gtSmjinfo);
	}
	
	
	@Transactional(readOnly = false)
	public void delete(GtSmjinfo gtSmjinfo) {
		super.delete(gtSmjinfo);
	}
	
	public List<GtSmjinfo> queryLsh(String ywlsh) {
		return dao.queryLsh(ywlsh);
	}
	
	
	public int countSmj(String ywlsh,String name){
		return dao.countSmj(ywlsh, name);
	}
	
	public int updateId(GtSmjinfo g){
		return dao.updateId(g);
	}
	
	
	public List<GtSmjinfo> getMaterialid(GtSmjinfo g){
		return dao.getMaterialid(g);
	}
	
	public List<GtSmjinfo> queryMateriainfoid(String ywlsh){
		return dao.queryMateriainfoid(ywlsh);
	}
	
	
	
}