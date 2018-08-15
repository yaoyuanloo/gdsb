/**
 * 
 */
package com.fortunes.javamg.test.dao;

import com.fortunes.javamg.common.persistence.TreeDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.test.entity.TestTree;

/**
 * 树结构生成DAO接口
 * 
 * @version 2015-04-06
 */
@MyBatisDao
public interface TestTreeDao extends TreeDao<TestTree> {
	
}