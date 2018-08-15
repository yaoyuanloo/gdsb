/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PYwinfo;
import com.fortunes.javamg.modules.gtxt.publicyw.dao.PYwinfoDao;

/**
 * 公共业务信息表Service
 * @author YANG
 * @version 2016-09-07
 */
@Service
@Transactional(readOnly = true)
public class PYwinfoService extends CrudService<PYwinfoDao, PYwinfo> {

	public PYwinfo get(String id) {
		return super.get(id);
	}
	
	public List<PYwinfo> findList(PYwinfo pYwinfo) {
		return super.findList(pYwinfo);
	}
	
	public Page<PYwinfo> findPage(Page<PYwinfo> page, PYwinfo pYwinfo) {
		return super.findPage(page, pYwinfo);
	}
	
	@Transactional(readOnly = false)
	public void save(PYwinfo pYwinfo) {
		super.save(pYwinfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(PYwinfo pYwinfo) {
		super.delete(pYwinfo);
	}
	public PYwinfo  findYwinfoListBydiYwId(String ywId){
	return 	dao.findYwinfoListBydiYwId(ywId);
	}
}