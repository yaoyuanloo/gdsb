/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwfzr;

/**
 * 地级市业务编号和负责人中间表DAO接口
 * @author Yang
 * @version 2016-09-09
 */
@MyBatisDao
public interface DYwfzrDao extends CrudDao<DYwfzr> {
	public void deleteByYwId(DYwfzr fzr);
	public void insertsdry(DYwfzr dYwfzr);

}