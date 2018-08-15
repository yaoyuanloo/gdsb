/**
 * 
 */
package com.fortunes.javamg.modules.sys.dao;

import com.fortunes.javamg.common.persistence.TreeDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.sys.entity.Area;

/**
 * 区域DAO接口
 * 
 * @version 2014-05-16
 */
@MyBatisDao
public interface AreaDao extends TreeDao<Area> {


    public String seqId();
}
