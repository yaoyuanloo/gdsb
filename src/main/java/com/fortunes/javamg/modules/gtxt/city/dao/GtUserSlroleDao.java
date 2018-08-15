/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.city.entity.GtUserSlrole;

/**
 * 柜台用户受理角色关联表DAO接口
 * @author wan
 * @version 2016-09-09
 */
@MyBatisDao
public interface GtUserSlroleDao extends CrudDao<GtUserSlrole> {

    public GtUserSlrole getUserIdByRoleId(String userId);

}