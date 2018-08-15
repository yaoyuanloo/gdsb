/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.dao;

import java.util.List;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.city.entity.GtRole;
import com.fortunes.javamg.modules.sys.entity.Role;

/**
 * 柜台受理角色管理DAO接口
 * @author 万
 * @version 2016-09-07
 */
@MyBatisDao
public interface GtRoleDao extends CrudDao<GtRole> {
   List<Role> getRoleListDi(GtRole role);
}