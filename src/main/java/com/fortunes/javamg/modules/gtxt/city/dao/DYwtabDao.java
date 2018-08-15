/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwtab;

import java.util.List;

/**
 * 地级市业务编号和负责人中间表DAO接口
 * @author Yang
 * @version 2016-09-09
 */
@MyBatisDao
public interface DYwtabDao extends CrudDao<DYwtab> {
	public List<DYwtab> findYwtabByYwId(String ywid);

	public void deleteTabByDiYwId(DYwtab tab);
}  