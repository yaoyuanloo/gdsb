/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtEmsinfo;

/**
 * 邮政送达详情表DAO接口
 * @author Yang
 * @version 2016-09-09
 */
@MyBatisDao
public interface GtEmsinfoDao extends CrudDao<GtEmsinfo> {
	
}