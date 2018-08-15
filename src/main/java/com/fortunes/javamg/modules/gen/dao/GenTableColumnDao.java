/**
 * 
 */
package com.fortunes.javamg.modules.gen.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gen.entity.GenTable;
import com.fortunes.javamg.modules.gen.entity.GenTableColumn;

/**
 * 业务表字段DAO接口
 * 
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenTableColumnDao extends CrudDao<GenTableColumn> {
	
	public void deleteByGenTableId(GenTable genTable);
}
