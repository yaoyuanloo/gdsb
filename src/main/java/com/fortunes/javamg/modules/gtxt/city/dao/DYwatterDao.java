/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwatter;

/**
 * 文书模板信息表DAO接口
 * @author YANG
 * @version 2016-09-07
 */
@MyBatisDao
public interface DYwatterDao extends CrudDao<DYwatter> {

    /**
     * 通过地级市业务id获取业务配置数据
     * @param ywid
     * @return
     */
    public DYwatter getByYwId(String ywid);

	public void delsave(DYwatter dYwatter);
	public int update(DYwatter dYwatter);
	public DYwatter getDYwatterByywid(DYwatter dYwatter);
	public void insertywatter (DYwatter dYwatter);
	
	
}