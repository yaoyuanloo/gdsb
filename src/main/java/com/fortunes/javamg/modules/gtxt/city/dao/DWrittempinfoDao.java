/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.dao;

import java.util.List;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DWrittempinfo;

/**
 * 文书模板信息表DAO接口
 * @author YANG
 * @version 2016-09-07
 */
@MyBatisDao
public interface DWrittempinfoDao extends CrudDao<DWrittempinfo> {
	
	List<DWrittempinfo> finddwrittempinfoist(String zone);
	
}