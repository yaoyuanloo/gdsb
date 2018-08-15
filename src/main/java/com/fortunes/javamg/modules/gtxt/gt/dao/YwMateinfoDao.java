/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.gt.entity.YwMateinfo;

/**
 * 业务和材料生成表DAO接口
 * @author Yang
 * @version 2016-09-16
 */
@MyBatisDao
public interface YwMateinfoDao extends CrudDao<YwMateinfo> {
	
}