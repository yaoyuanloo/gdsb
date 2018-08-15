/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.city.entity.GtRole;
import com.fortunes.javamg.modules.gtxt.city.dao.GtRoleDao;

/**
 * 柜台受理角色管理Service
 * @author 万
 * @version 2016-09-07
 */
@Service
@Transactional(readOnly = true)
public class GtRoleService extends CrudService<GtRoleDao, GtRole> {

	public GtRole get(String id) {
		return super.get(id);
	}
	
	public List<GtRole> findList(GtRole gtRole) {
		return super.findList(gtRole);
	}
	
	public Page<GtRole> findPage(Page<GtRole> page, GtRole gtRole) {
		return super.findPage(page, gtRole);
	}
	
	@Transactional(readOnly = false)
	public void save(GtRole gtRole) {
		super.save(gtRole);
	}
	
	@Transactional(readOnly = false)
	public void delete(GtRole gtRole) {
		super.delete(gtRole);
	}
	
	
	public  List<GtRole> findroleList(GtRole role){
		// 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
		//user.getSqlMap().put("dsf", dataScopeFilter(user.getCurrentUser(), "o", "a"));
		List<GtRole> list =dao.findList(role);
		return list;
	}
}