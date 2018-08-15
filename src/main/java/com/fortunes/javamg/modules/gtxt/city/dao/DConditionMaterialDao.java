/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.dao;
import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DConditionMaterial;

/**
 * 地级市条件和材料中间表DAO接口
 * @author Yang
 * @version 2016-09-09
 */
@MyBatisDao
public interface DConditionMaterialDao extends CrudDao<DConditionMaterial> {
	void deletetj(String tjid);
}