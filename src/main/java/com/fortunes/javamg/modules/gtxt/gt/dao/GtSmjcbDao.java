/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.dao;

import java.util.List;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtSmjcb;

/**
 * 扫描件清单表DAO接口
 * @author Yang
 * @version 2016-09-09
 */
@MyBatisDao
public interface GtSmjcbDao extends CrudDao<GtSmjcb> {
	 List<GtSmjcb> getByJid(String jId);
	 List<GtSmjcb> queryMateriainfoName(String id);
}