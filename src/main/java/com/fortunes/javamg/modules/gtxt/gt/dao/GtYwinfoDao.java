/**
 *
 */
package com.fortunes.javamg.modules.gtxt.gt.dao;

import java.util.List;
import java.util.Map;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinfo;

/**
 * 柜台业务受理表DAO接口
 * @author Yang
 * @version 2016-09-09
 */
@MyBatisDao
public interface GtYwinfoDao extends CrudDao<GtYwinfo> {
	public List<GtYwinfo> findywinfo(String ywlsh);
	public List<GtYwinfo> findywinfoList(GtYwinfo gtywinfo);

	/**
	 * 二级分配人查询可以分配的业务列表
	 * @param m
	 * @return
	 */
	public List<GtYwinfo> findYwInfoByUserId(Map m);
	public GtYwinfo getByYwlsh(String ywlsh);
	public List<GtYwinfo> findByHzdh(String hzdh);
	public int updateLcztByYwlsh(GtYwinfo gtYwinfo);
	public int updateLcztByHzdh(GtYwinfo gtYwinfo);
	public int updateFpztByHzdh(GtYwinfo gtYwinfo);
	public int updateSynergyByYwidHzdh(GtYwinfo gtYwinfo);


	public GtYwinfo findywinfoPre(GtYwinfo gtywinfo);
	public int updateCjdateByYwlsh(GtYwinfo gtYwinfo);
	public  List<GtYwinfo> queryhzdh(String id);
}
