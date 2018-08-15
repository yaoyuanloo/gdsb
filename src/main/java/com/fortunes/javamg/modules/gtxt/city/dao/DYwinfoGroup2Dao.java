/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.dao;

import java.util.List;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwinfoGroup2;

/**
 * 本地业务属性定义DAO接口
 * @author YUAN
 * @version 2016-09-07
 */
@MyBatisDao
public interface DYwinfoGroup2Dao extends CrudDao<DYwinfoGroup2> {
	public List<DYwinfoGroup2> findChecksYw();

    public String findChecksYwDmnr(String userId);

    public List<DYwinfoGroup2> findUserYwList(String[] arr);

    public List<DYwinfoGroup2> findtagsList();

    public List<DYwinfoGroup2> findTaiojianList(String dmbh);

    public List<DYwinfoGroup2> findIOList(String[] dmbh);

    public DYwinfoGroup2 getModePare(DYwinfoGroup2 DYwinfoGroup2);

    public List<DYwinfoGroup2> findChecksYwList();

    public String gettags(String dmbh);

    public String findTags(String[] dmbh);

    public List<DYwinfoGroup2> findAllLb(String str);
	
}