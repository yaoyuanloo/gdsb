/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.dao;


import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.city.entity.GtSlroleDjyw;

import java.util.List;

/**
 * 柜台受理角色业务管理表DAO接口
 * @author 万
 * @version 2016-09-08
 */
@MyBatisDao
public interface GtSlroleDjywDao extends CrudDao<GtSlroleDjyw> {
	
	/**
	 * 受理角色编号_业务名称编号DAO接口
	 * @author wan
	 * @version 2016-07-23
	 */
	
		
		public int insert(GtSlroleDjyw roleidYwid);
		public List<GtSlroleDjyw> findYwinfoListByRoleId(String id);

        public  void deleteByRoleId(String id);


	
	
}