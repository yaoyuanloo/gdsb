/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.dao;

import java.util.List;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialinfo;

/**
 * 公共业务材料表DAO接口
 * @author 杨
 * @version 2016-09-07
 */
@MyBatisDao
public interface PMaterialinfoDao extends CrudDao<PMaterialinfo> {
	/**
	 * 根据业务id查询
	 * @param genTable
	 * @return
	 */
	List<PMaterialinfo> queryInfo(String ywid);
	
	/*
	 * 查询条件下面的材料
	 */
	List<PMaterialinfo> qConditionCl(String tjid);
	
	/*
	 * 查询条件下面的材料
	 */
	List<PMaterialinfo> queryid(String id);
	
	/*
	 * 根据汇总单号查询业务
	 */
	public List<PMaterialinfo> queryXl(String id);
	
}