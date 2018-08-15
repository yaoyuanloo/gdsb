/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.gt.entity.YwMateinfo;
import com.fortunes.javamg.modules.gtxt.gt.dao.YwMateinfoDao;

/**
 * 业务和材料生成表Service
 * @author Yang
 * @version 2016-09-16
 */
@Service
@Transactional(readOnly = true)
public class YwMateinfoService extends CrudService<YwMateinfoDao, YwMateinfo> {

	public YwMateinfo get(String id) {
		return super.get(id);
	}
	
	public List<YwMateinfo> findList(YwMateinfo ywMateinfo) {
		return super.findList(ywMateinfo);
	}
	
	public Page<YwMateinfo> findPage(Page<YwMateinfo> page, YwMateinfo ywMateinfo) {
		return super.findPage(page, ywMateinfo);
	}
	
	@Transactional(readOnly = false)
	public void save(YwMateinfo ywMateinfo) {
		super.save(ywMateinfo);
	}

	@Transactional(readOnly = false)
	public void save(List<YwMateinfo> ywMateinfos) {
		for(YwMateinfo ywMateinfo : ywMateinfos){
			super.save(ywMateinfo);
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(YwMateinfo ywMateinfo) {
		super.delete(ywMateinfo);
	}
	
}