/**
 * 
 */
package com.fortunes.javamg.modules.cms.dao;

import com.fortunes.javamg.common.persistence.CrudDao;
import com.fortunes.javamg.common.persistence.annotation.MyBatisDao;
import com.fortunes.javamg.modules.cms.entity.Guestbook;

/**
 * 留言DAO接口
 * 
 * @version 2013-8-23
 */
@MyBatisDao
public interface GuestbookDao extends CrudDao<Guestbook> {

}
