/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.city.entity.GtUserSlrole;
import com.fortunes.javamg.modules.gtxt.city.dao.GtUserSlroleDao;

/**
 * 柜台用户受理角色关联表Service
 * @author wan
 * @version 2016-09-09
 */
@Service
@Transactional(readOnly = true)
public class GtUserSlroleService extends CrudService<GtUserSlroleDao, GtUserSlrole> {

	public GtUserSlrole get(String id) {
		return super.get(id);
	}
	
	public List<GtUserSlrole> findList(GtUserSlrole gtUserSlrole) {
		return super.findList(gtUserSlrole);
	}
	
	public Page<GtUserSlrole> findPage(Page<GtUserSlrole> page, GtUserSlrole gtUserSlrole) {
		return super.findPage(page, gtUserSlrole);
	}
	
	@Transactional(readOnly = false)
	public void save(GtUserSlrole gtUserSlrole) {
		super.save(gtUserSlrole);
	}
	
	@Transactional(readOnly = false)
	public void delete(GtUserSlrole gtUserSlrole) {
		super.delete(gtUserSlrole);
	}


}