/**
 *
 */
package com.fortunes.javamg.modules.gtxt.city.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.city.dao.DYwtabDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwtab;

import java.util.List;

/**
 * 文书模板信息表Service
 *
 * @author YANG
 * @version 2016-09-07
 */
@Service
@Transactional(readOnly = true)
public class DYwtabService extends CrudService<DYwtabDao, DYwtab> {

    public void insertywbq(DYwtab dYwtab) {
        dao.insert(dYwtab);
    }

    public List<DYwtab> findYwtabByYwId(String ywid) {
        return dao.findYwtabByYwId(ywid);
    }

    @Transactional(readOnly = false)
    public void update(DYwtab dYwtab) {
        dao.update(dYwtab);
    }

    @Transactional(readOnly = false)
    public void deleteTabByDiYwId(DYwtab dYwtab) {
        dao.deleteTabByDiYwId(dYwtab);
    }

    @Transactional(readOnly = false)
    public void save(DYwtab dYwtab) {
        if (dYwtab.getIsNewRecord()) {
            dYwtab.preInsert();
            dao.insert(dYwtab);
        }

    }


}