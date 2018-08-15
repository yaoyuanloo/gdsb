/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinput;
import com.fortunes.javamg.modules.gtxt.gt.dao.GtYwinputDao;

/**
 * 柜台业务录入表Service
 * @author Yang
 * @version 2016-09-09
 */
@Service
@Transactional(readOnly = true)
public class GtYwinputService extends CrudService<GtYwinputDao, GtYwinput> {

	public GtYwinput get(String id) {
		return super.get(id);
	}

	public List<GtYwinput> findByYwlsh(String ywlsh) {
		return dao.findByYwlsh(ywlsh);
	}

	public GtYwinput getByYwlshLczt(GtYwinput gtYwinput) {
		return dao.getByYwlshLczt(gtYwinput);
	}
	
	public List<GtYwinput> findList(GtYwinput gtYwinput) {
		return super.findList(gtYwinput);
	}
	
	public Page<GtYwinput> findPage(Page<GtYwinput> page, GtYwinput gtYwinput) {
		return super.findPage(page, gtYwinput);
	}
	
	@Transactional(readOnly = false)
	public void save(GtYwinput gtYwinput) {
		super.save(gtYwinput);
	}
	
	@Transactional(readOnly = false)
	public void delete(GtYwinput gtYwinput) {
		super.delete(gtYwinput);
	}
	
}