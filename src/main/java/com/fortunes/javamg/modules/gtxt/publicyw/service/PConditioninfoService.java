/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.publicyw.entity.PConditioninfo;
import com.fortunes.javamg.modules.gtxt.publicyw.dao.PConditioninfoDao;

/**
 * 公共条件信息表Service
 * @author 杨
 * @version 2016-09-07
 */
@Service
@Transactional(readOnly = true)
public class PConditioninfoService extends CrudService<PConditioninfoDao, PConditioninfo> {

	public PConditioninfo get(String id) {
		return super.get(id);
	}
	
	public List<PConditioninfo> findList(PConditioninfo pConditioninfo) {
		return super.findList(pConditioninfo);
	}
	
	public Page<PConditioninfo> findPage(Page<PConditioninfo> page, PConditioninfo pConditioninfo) {
		return super.findPage(page, pConditioninfo);
	}
	
	@Transactional(readOnly = false)
	public void save(PConditioninfo pConditioninfo) {
		super.save(pConditioninfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(PConditioninfo pConditioninfo) {
		super.delete(pConditioninfo);
	}
	public List<PConditioninfo> queryInfo(String ywid){
		return dao.queryInfo(ywid);
	}
	
/*	public List<PConditioninfo> queryInfo(String ywid){
		return dao.queryInfo(ywid);
	}*/
	
	public List<PConditioninfo> queryid(String id){
		return dao.queryid(id);
	}
	
	
	
}