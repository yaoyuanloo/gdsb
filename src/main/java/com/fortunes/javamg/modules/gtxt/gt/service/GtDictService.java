/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.service;

import com.fortunes.javamg.common.service.CrudService;
import com.fortunes.javamg.common.utils.CacheUtils;
import com.fortunes.javamg.modules.gtxt.gt.dao.GtDictDao;
import com.fortunes.javamg.modules.gtxt.gt.entity.GtDict;
import com.fortunes.javamg.modules.gtxt.gt.utils.GtDictUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 字典Service
 * 
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class GtDictService extends CrudService<GtDictDao, GtDict> {
	
	/**
	 * 查询字段类型列表
	 * @return
	 */
	public List<GtDict> findTypeList(){
		return dao.findTypeList(new GtDict());
	}

	@Transactional(readOnly = false)
	public void save(GtDict gtDict) {
		super.save(gtDict);
		CacheUtils.remove(GtDictUtils.CACHE_GTDICT_MAP);
	}

	@Transactional(readOnly = false)
	public void delete(GtDict gtDict) {
		super.delete(gtDict);
		CacheUtils.remove(GtDictUtils.CACHE_GTDICT_MAP);
	}

}
