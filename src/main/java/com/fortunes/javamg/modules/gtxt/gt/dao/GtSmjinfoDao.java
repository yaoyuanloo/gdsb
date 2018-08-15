/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.dao;

import java.util.List;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtSmjinfo;

/**
 * 业务影像表DAO接口
 * @author Yang
 * @version 2016-09-10
 */
@MyBatisDao
public interface GtSmjinfoDao extends CrudDao<GtSmjinfo> {
	public List<GtSmjinfo> queryLsh(String ywlsh);
	public int update(GtSmjinfo gtSmjinfo);
	public int countSmj(String ywlsh,String name);
	public int updateId(GtSmjinfo g);
	public List<GtSmjinfo> getMaterialid(GtSmjinfo g);
	public List<GtSmjinfo> queryMateriainfoid(String ywlsh);
}