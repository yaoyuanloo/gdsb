/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtYwinput;

import java.util.List;

/**
 * 柜台业务录入表DAO接口
 * @author Yang
 * @version 2016-09-09
 */
@MyBatisDao
public interface GtYwinputDao extends CrudDao<GtYwinput> {
    public List<GtYwinput> findByYwlsh(String ywlsh);
    public GtYwinput getByYwlshLczt(GtYwinput gtYwinput);
}