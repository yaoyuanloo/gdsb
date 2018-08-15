/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortunes.javamg.common.persistence.Page;
import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.modules.gtxt.city.dao.DYwatterDao;
import com.fortunes.javamg.modules.gtxt.city.entity.DYwatter;

/**
 * 文书模板信息表Service
 * @author YANG
 * @version 2016-09-07
 */
@Service
@Transactional(readOnly = true)
public class DYwatterService extends CrudService<DYwatterDao, DYwatter> {
	

	public DYwatter get(String id) {
		return super.get(id);
	}
	/**
	 * 通过地级市业务id获取业务配置数据
	 * @param ywid
	 * @return
	 */
	public DYwatter getByYwId(String ywid) {
		return dao.getByYwId(ywid);
	}
	public List<DYwatter> findList(DYwatter dYwatter) {
		return super.findList(dYwatter);
	}
	
	public Page<DYwatter> findPage(Page<DYwatter> page, DYwatter dYwatter) {
		return super.findPage(page, dYwatter);
	}
	
	@Transactional(readOnly = false)
	public void save(DYwatter dYwatter) {
		super.save(dYwatter);
	}
	@Transactional(readOnly = false)
	public void saveWaater(DYwatter dYwatter) {
		if (dYwatter.getIsNewRecord()){
			dYwatter.preInsert();
			dao.insert(dYwatter);
		}
	}
	@Transactional(readOnly = false)
	public void update(DYwatter dYwatter) {
		dao.update(dYwatter);
	}


	public void delsave(DYwatter dYwatter) {
		//查询出原来的数据
		DYwatter dy=dao.getByYwId(dYwatter.getYwid());
		if(dy!=null){
		//说明数据库存在
			dy.setFlowcode(dYwatter.getFlowcode());
			dy.setLzfscode(dYwatter.getLzfscode());
			dy.setShjbcode(dYwatter.getShjbcode());
			save(dy);
	
		}else{
			//直接插入
			save(dYwatter);
		}
		
	}
	
	
	@Transactional(readOnly = false)
	public void delete(DYwatter dYwatter) {
		super.delete(dYwatter);
	}
	
}