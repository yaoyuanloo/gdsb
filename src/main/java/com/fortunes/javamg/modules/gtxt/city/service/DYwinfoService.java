/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwinfo;
import com.fortunes.javamg.modules.gtxt.city.dao.DYwinfoDao;

/**
 * 本地业务制定Service
 * @author xwm
 * @version 2016-09-07
 */
@Service
@Transactional(readOnly = true)
public class DYwinfoService extends CrudService<DYwinfoDao, DYwinfo> {

	public DYwinfo get(String id) {
		return super.get(id);
	}

	public List<DYwinfo> findList(DYwinfo dYwinfo) {
		return super.findList(dYwinfo);
	}

	public Page<DYwinfo> findPage(Page<DYwinfo> page, DYwinfo dYwinfo) {
		return super.findPage(page, dYwinfo);
	}

	@Transactional(readOnly = false)
	public void saveDj(DYwinfo dYwinfo) {
		if (dYwinfo.getIsNewRecord()) {
			dYwinfo.preInsert();
			dao.insert(dYwinfo);
		}
	}

	@Transactional(readOnly = false)
	public void delete(DYwinfo dYwinfo) {
		super.delete(dYwinfo);
	}
	
	
	

	public List<DYwinfo> findChecksYwList() {
		return dao.findChecksYwList();

   }

	/**
	 * 根据用户ID查找用户所授权的业务
	 * @param userId
	 * @return
     */
	public List<DYwinfo> findUserYwMenu(String userId){
		return  dao.findUserYwMenu(userId);
	}
	
	/**
	 * 根据业务ID查找用户所授权的业务
	 * @param pYwinfo
	 * @return
     */
	public DYwinfo getYwid(String ywid){
		return  dao.getYwid(ywid);
	}

	
	public DYwinfo queryYwid(String ywid){
		return  dao.queryYwid(ywid);
	}
	
	public void updateywid(DYwinfo yw){
		 dao.updateywid(yw);
	}

}