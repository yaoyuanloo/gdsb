/**
 * 
 */
package com.fortunes.javamg.modules.sys.dao;

import java.util.List;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.sys.entity.Dict;

/**
 * 字典DAO接口
 * 
 * @version 2014-05-16
 */
@MyBatisDao
public interface DictDao extends CrudDao<Dict> {

	public List<Dict> findTypeList(Dict dict);
	public List<Dict> findtabListBytype(String type);
	
	
}
