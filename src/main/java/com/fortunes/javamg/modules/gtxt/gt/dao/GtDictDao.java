/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtDict;

import java.util.List;

/**
 * 字典DAO接口
 * 
 * @version 2014-05-16
 */
@MyBatisDao
public interface GtDictDao extends CrudDao<GtDict> {

	public List<GtDict> findTypeList(GtDict gtDict);
	
}
