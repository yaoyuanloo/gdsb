/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwCondition;

/**
 * 地级市业务条件中间表DAO接口
 * @author Yang
 * @version 2016-09-09
 */
@MyBatisDao
public interface DYwConditionDao extends CrudDao<DYwCondition> {
	void deleteYwid(String ywid);
}