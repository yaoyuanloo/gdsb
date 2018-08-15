/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.city.dao.DYwMaterialDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwMaterial;

/**
 * 本地业务属性定义Service
 * @author YUAN
 * @version 2016-09-07
 */
@Service
@Transactional(readOnly = true)
public class DYwMaterialService extends CrudService<DYwMaterialDao, DYwMaterial> {
	@Transactional(readOnly = false)
	public void save(DYwMaterial dYwMaterial) {
		super.save(dYwMaterial);
	}
	
	public List<DYwMaterial> queryInfo(String ywId) {
		return dao.queryInfo(ywId);
	}
	
	public List<DYwMaterial> queryGetid(String ywId) {
		return dao.queryGetid(ywId);
	}
	@Transactional(readOnly = false)
	public void deleteYwid(String ywId){
		 dao.deleteYwid(ywId);
	}
	
	
}