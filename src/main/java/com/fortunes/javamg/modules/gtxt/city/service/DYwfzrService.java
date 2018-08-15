/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.service;

import com.fortunes.javamg.modules.sys.dao.UserDao;
import com.fortunes.javamg.modules.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.city.dao.DYwfzrDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwfzr;

import java.util.List;

/**
 * 文书模板信息表Service
 * @author YANG
 * @version 2016-09-07
 */
@Service
@Transactional(readOnly = true)
public class DYwfzrService extends CrudService<DYwfzrDao, DYwfzr> {
    @Autowired
    private UserDao userDao;
    @Transactional(readOnly = false)
    public void deleteByYwId(DYwfzr fzr){
        dao.deleteByYwId(fzr);
    }
    public void saveDyFzr(DYwfzr entity) {
        if (entity.getIsNewRecord()) {
            entity.preInsert();
            dao.insert(entity);
        }
    }

    public List<User> userList(String ywid){
        return userDao.findUserfzrByUserId(ywid);
    }
}