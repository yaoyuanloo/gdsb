/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.dao;

import java.util.List;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PMaterialCate;

/**
 * 业务材料分类DAO接口
 * @author 杨
 * @version 2016-09-07
 */
@MyBatisDao
public interface PMaterialCateDao extends CrudDao<PMaterialCate> {
	/**
	 * 查询所有信息
	 * @param genTable
	 * @return
	 */
	List<PMaterialCate> findAll();
}