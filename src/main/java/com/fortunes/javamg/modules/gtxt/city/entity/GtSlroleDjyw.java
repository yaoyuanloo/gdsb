/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.entity;

import java.util.List;

import org.hibernate.validator.constraints.Length;


import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 柜台受理角色业务管理表Entity
 * @author 万
 * @version 2016-09-08
 */
public class GtSlroleDjyw extends DataEntity<GtSlroleDjyw> {
	
	private static final long serialVersionUID = 1L;
	private String roleid;		// 受理角色
	private DYwinfo ywinfo;
	private List<DYwinfo> ywList;
	public List<DYwinfo> getYwList() {
		return ywList;
	}

	public void setYwList(List<DYwinfo> ywList) {
		this.ywList = ywList;
	}

	
	public GtSlroleDjyw() {
		super();
	}

	public GtSlroleDjyw(String id){
		super(id);
	}

	@Length(min=0, max=35, message="受理角色长度必须介于 0 和 35 之间")
	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	@Length(min=0, max=35, message="地级市业务ID长度必须介于 0 和 35 之间")
	public DYwinfo getYwId() {
		return ywinfo;
	}
	
	public void setYwId(DYwinfo ywId) {
		this.ywinfo = ywId;
	}
	
}