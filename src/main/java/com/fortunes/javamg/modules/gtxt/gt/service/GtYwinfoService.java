/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfo;
import com.fortunes.javamg.modules.gtxt.gt.dao.GtYwinfoDao;

/**
 * 柜台业务受理表Service
 * @author Yang
 * @version 2016-09-09
 */
@Service
@Transactional(readOnly = true)
public class GtYwinfoService extends CrudService<GtYwinfoDao, GtYwinfo> {

	public GtYwinfo get(String id) {
		return super.get(id);
	}

	public GtYwinfo getByYwlsh(String ywlsh) {
		return dao.getByYwlsh(ywlsh);
	}

	public List<GtYwinfo> findByHzdh(String hzdh) {
		return dao.findByHzdh(hzdh);
	}

	public List<GtYwinfo> findList(GtYwinfo gtYwinfo) {
		return super.findList(gtYwinfo);
	}

	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param m
	 * @return
	 */
	public Page<GtYwinfo> findYwInfoByUserId(Page<GtYwinfo> page,Map m) {
		page.setList(dao.findYwInfoByUserId(m));
		return page;
	}


	
	
	@Transactional(readOnly = false)
	public void save(GtYwinfo gtYwinfo) {
		super.save(gtYwinfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(GtYwinfo gtYwinfo) {
		super.delete(gtYwinfo);
	}

	@Transactional(readOnly = false)
	public void updateLcztByYwlsh(GtYwinfo gtYwinfo) {
		dao.updateLcztByYwlsh(gtYwinfo);
	}

	@Transactional(readOnly = false)
	public void updateLcztByHzdh(GtYwinfo gtYwinfo) {
		dao.updateLcztByHzdh(gtYwinfo);
	}

	@Transactional(readOnly = false)
	public void updateFpztByHzdh(GtYwinfo gtYwinfo) {
		dao.updateFpztByHzdh(gtYwinfo);
	}

	@Transactional(readOnly = false)
	public void updateSynergyByYwidHzdh(GtYwinfo gtYwinfo) {
		dao.updateSynergyByYwidHzdh(gtYwinfo);
	}

	@Transactional(readOnly = false)
	public void updateCjdateByYwlsh(GtYwinfo gtYwinfo) {
		dao.updateCjdateByYwlsh(gtYwinfo);
	}

	public GtYwinfo findywinfoPre(GtYwinfo gtywinfo){
		return dao.findywinfoPre(gtywinfo);
	}
	public List<GtYwinfo> findYwInfoByUserId(Map m){
		return  dao.findYwInfoByUserId(m);
	}
	public  List<GtYwinfo> queryhzdh(String id){
		return dao.queryhzdh(id);
	}
}