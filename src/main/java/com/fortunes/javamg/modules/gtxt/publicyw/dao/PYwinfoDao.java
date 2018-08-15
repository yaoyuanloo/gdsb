/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PYwinfo;

/**
 * 公共业务信息表DAO接口
 * @author YANG
 * @version 2016-09-07
 */
@MyBatisDao
public interface PYwinfoDao extends CrudDao<PYwinfo> {

    public PYwinfo  findYwinfoListBydiYwId(String ywId);

}