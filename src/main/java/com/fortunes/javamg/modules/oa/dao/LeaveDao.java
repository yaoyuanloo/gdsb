/**
 * There are <a href="#">javamg</a> code generation
 */
package com.fortunes.javamg.modules.oa.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.oa.entity.Leave;

/**
 * 请假DAO接口
 * 
 * @version 2013-8-23
 */
@MyBatisDao
public interface LeaveDao extends CrudDao<Leave> {
	
	/**
	 * 更新流程实例ID
	 * @param leave
	 * @return
	 */
	public int updateProcessInstanceId(Leave leave);
	
	/**
	 * 更新实际开始结束时间
	 * @param leave
	 * @return
	 */
	public int updateRealityTime(Leave leave);
	
}
