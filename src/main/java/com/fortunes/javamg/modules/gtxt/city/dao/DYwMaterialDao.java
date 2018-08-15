/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.dao;

import java.util.List;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwMaterial;

/**
 * 地级市业务材中间表DAO接口
 * @author Yang
 * @version 2016-09-09
 */
@MyBatisDao
public interface DYwMaterialDao extends CrudDao<DYwMaterial> {
	List<DYwMaterial> queryInfo(String ywId);
	List<DYwMaterial> queryGetid(String ywId);
	void deleteYwid(String ywId);
	
}