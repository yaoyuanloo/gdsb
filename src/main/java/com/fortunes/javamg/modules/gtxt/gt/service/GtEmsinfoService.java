/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtEmsinfo;
import com.fortunes.javamg.modules.gtxt.gt.dao.GtEmsinfoDao;

/**
 * 邮政送达详情表Service
 * @author Yang
 * @version 2016-09-09
 */
@Service
@Transactional(readOnly = true)
public class GtEmsinfoService extends CrudService<GtEmsinfoDao, GtEmsinfo> {

	public GtEmsinfo get(String id) {
		return super.get(id);
	}
	
	public List<GtEmsinfo> findList(GtEmsinfo gtEmsinfo) {
		return super.findList(gtEmsinfo);
	}
	
	public Page<GtEmsinfo> findPage(Page<GtEmsinfo> page, GtEmsinfo gtEmsinfo) {
		return super.findPage(page, gtEmsinfo);
	}
	
	@Transactional(readOnly = false)
	public void save(GtEmsinfo gtEmsinfo) {
		super.save(gtEmsinfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(GtEmsinfo gtEmsinfo) {
		super.delete(gtEmsinfo);
	}
	
}