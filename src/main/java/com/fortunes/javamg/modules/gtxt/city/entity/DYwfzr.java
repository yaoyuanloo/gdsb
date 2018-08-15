/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.entity;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 地级市业务分类Entity
 * @author 杨
 * @version 2016-09-06
 */
public class DYwfzr extends DataEntity<DYwfzr> {
	
	private static final long serialVersionUID = 1L;
	private String ywId;		// 地级市业务编号

	public String getYwId() {
		return ywId;
	}

	public void setYwId(String ywId) {
		this.ywId = ywId;
	}

	private String  userid;		// 用户ID
	
	public DYwfzr() {
		super();
	}

	public DYwfzr(String id){
		super(id);
	}



	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}