/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwinfo;

import java.util.List;

/**
 * 本地业务制定DAO接口
 * @author xwm
 * @version 2016-09-07
 */
@MyBatisDao
public interface DYwinfoDao extends CrudDao<DYwinfo> {
    public List<DYwinfo> findChecksYwList();

    /**
     * 查找用户所授权的业务
     */
    public List<DYwinfo> findUserYwMenu(String userId);
    /**
     * 保存地级市业务
     */
    public void save(DYwinfo dywinfo);
    
    /**
     * 查找用户所授权的业务
     */
    public DYwinfo getYwid(String ywid);
    
    /*
     * 根据业务id查询业务信息
     */
    public DYwinfo queryYwid(String ywid);
    
    
    /*
     * 根据业务id更新
     */
    void updateywid(DYwinfo yw);


}