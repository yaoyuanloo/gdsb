package com.fortunes.javamg.modules.gtxt.city.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.city.dao.DConditionMaterialDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DConditionMaterial;

@Service
@Transactional(readOnly = true)
public class DConditionMaterialService extends CrudService<DConditionMaterialDao, DConditionMaterial>{
	@Transactional(readOnly = false)
	public void save(DConditionMaterial dConditionMaterial) {
		super.save(dConditionMaterial);
	}
	
	@Transactional(readOnly = false)
	public void deletetj(String ywid){
		dao.deletetj(ywid);
	}
}
