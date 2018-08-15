/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.dao;

import java.util.List;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PConditionCate;

/**
 * 业务条件分类DAO接口
 * @author YANG
 * @version 2016-09-07
 */
@MyBatisDao
public interface PConditionCateDao extends CrudDao<PConditionCate> {
	List<PConditionCate> findAll();
}