/**
 * 
 */
package com.fortunes.javamg.modules.gen.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gen.entity.GenTemplate;

/**
 * 代码模板DAO接口
 * 
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenTemplateDao extends CrudDao<GenTemplate> {
	
}
