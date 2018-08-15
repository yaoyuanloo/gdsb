/**
 * 
 */
package com.fortunes.javamg.modules.sys.dao;

import com.fortunes.javamg.common.persistence.TreeDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.sys.entity.Office;

/**
 * 机构DAO接口
 * 
 * @version 2014-05-16
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	
}
