/**
 * 
 */
package com.fortunes.javamg.test.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.test.entity.TestDataMain;

/**
 * 主子表生成DAO接口
 * 
 * @version 2015-04-06
 */
@MyBatisDao
public interface TestDataMainDao extends CrudDao<TestDataMain> {
	
}