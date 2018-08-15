/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.city.entity.GtSlroleDjyw;
import com.fortunes.javamg.modules.gtxt.city.dao.GtSlroleDjywDao;

/**
 * 柜台受理角色业务管理表Service
 * @author 万
 * @version 2016-09-08
 */
@Service
@Transactional(readOnly = true)
public class GtSlroleDjywService extends CrudService<GtSlroleDjywDao, GtSlroleDjyw> {

	public GtSlroleDjyw get(String id) {
		return super.get(id);
	}
	
	public List<GtSlroleDjyw> findList(GtSlroleDjyw gtSlroleDjyw) {
		return super.findList(gtSlroleDjyw);
	}
	
	public Page<GtSlroleDjyw> findPage(Page<GtSlroleDjyw> page, GtSlroleDjyw gtSlroleDjyw) {
		return super.findPage(page, gtSlroleDjyw);
	}
	
	@Transactional(readOnly = false)
	public void save(GtSlroleDjyw gtSlroleDjyw) {
		if (gtSlroleDjyw.getIsNewRecord()) {
			gtSlroleDjyw.preInsert();
			dao.insert(gtSlroleDjyw);
		}
	}

	@Transactional(readOnly = false)
	public void deleteYwInfoListByRoleId(String roleId){
		dao.deleteByRoleId(roleId);
	}
	public List<GtSlroleDjyw> findYwListByRoleId(String id){
	return 	dao.findYwinfoListByRoleId(id);
	}
	@Transactional(readOnly = false)
	public void delete(GtSlroleDjyw gtSlroleDjyw) {
		super.delete(gtSlroleDjyw);
	}
	
	  /**
		 * 保存部门与业务授权信息
		 * @param roleidYwid
		 * @return
		 */  
		@Transactional(readOnly = false)
		public void saveRoleidYwid(GtSlroleDjyw  roleidYwid) {
			// 删除业务授权信息
			if (roleidYwid.getIsNewRecord()) {
				roleidYwid.preInsert();
				dao.insert(roleidYwid);
			}
				
		}
	
}