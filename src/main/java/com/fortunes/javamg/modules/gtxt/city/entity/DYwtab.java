/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.entity;

import com.fortunes.javamg.modules.sys.entity.Dict;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 地级市业务分类Entity
 * @author 杨
 * @version 2016-09-06
 */
public class DYwtab extends DataEntity<DYwtab> {
	
	private static final long serialVersionUID = 1L;
	private String ywid;		// 业务编号
	private Dict querytagid;		// 查询标签
	
	
	public DYwtab() {
		super();
	}

	public DYwtab(String id){
		super(id);
	}

	public String getYwid() {
		return ywid;
	}

	public void setYwid(String ywid) {
		this.ywid = ywid;
	}

	public Dict getQuerytagid() {
		return querytagid;
	}

	public void setQuerytagid(Dict querytagid) {
		this.querytagid = querytagid;
	}
}