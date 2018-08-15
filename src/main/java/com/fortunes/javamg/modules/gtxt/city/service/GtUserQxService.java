/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.city.entity.GtUserQx;
import com.fortunes.javamg.modules.gtxt.city.dao.GtUserQxDao;

/**
 * 柜台用户权限关联表Service
 * @author wan
 * @version 2016-09-09
 */
@Service
@Transactional(readOnly = true)
public class GtUserQxService extends CrudService<GtUserQxDao, GtUserQx> {

	public GtUserQx get(String id) {
		return super.get(id);
	}
	
	public List<GtUserQx> findList(GtUserQx gtUserQx) {
		return super.findList(gtUserQx);
	}
	
	public Page<GtUserQx> findPage(Page<GtUserQx> page, GtUserQx gtUserQx) {
		return super.findPage(page, gtUserQx);
	}
	
	@Transactional(readOnly = false)
	public void save(GtUserQx gtUserQx) {
		super.save(gtUserQx);
	}
	
	@Transactional(readOnly = false)
	public void delete(GtUserQx gtUserQx) {
		super.delete(gtUserQx);
	}

	public GtUserQx getUserIdByQxId(String userId){
		return dao.getUserIdByQxId(userId);
	}
	
}