package com.fortunes.javamg.modules.gtxt.city.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.city.dao.DYwConditionDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwCondition;

/*
 * 业务条件中间表
 */
@Service
@Transactional(readOnly = true)
public class DYwConditionService extends CrudService<DYwConditionDao, DYwCondition>{
	@Transactional(readOnly = false)
	public void save(DYwCondition dYwCondition) {
		super.save(dYwCondition);
	}
	
	@Transactional(readOnly = false)
	public void deleteYwid(String ywid){
		dao.deleteYwid(ywid);
	}
}
