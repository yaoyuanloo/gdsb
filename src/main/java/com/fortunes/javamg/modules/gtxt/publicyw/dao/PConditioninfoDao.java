/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.dao;

import java.util.List;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PConditioninfo;

/**
 * 公共条件信息表DAO接口
 * @author 杨
 * @version 2016-09-07
 */
@MyBatisDao
public interface PConditioninfoDao extends CrudDao<PConditioninfo> {
	/**
	 * 根据业务id查询
	 * @param genTable
	 * @return
	 */
	List<PConditioninfo> queryInfo(String ywid);	
	List<PConditioninfo> queryid(String id);
}