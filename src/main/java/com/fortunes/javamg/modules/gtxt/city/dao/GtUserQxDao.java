/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.city.entity.GtUserQx;

/**
 * 柜台用户权限关联表DAO接口
 * @author wan
 * @version 2016-09-09
 */
@MyBatisDao
public interface GtUserQxDao extends CrudDao<GtUserQx> {



    public GtUserQx getUserIdByQxId(String userId);
}