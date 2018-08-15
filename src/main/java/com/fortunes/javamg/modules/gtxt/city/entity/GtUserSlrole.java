/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 柜台用户受理角色关联表Entity
 * @author wan
 * @version 2016-09-09
 */
public class GtUserSlrole extends DataEntity<GtUserSlrole> {
	
	private static final long serialVersionUID = 1L;
	private String roleid;		// 角色编号

	private String userid;
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public GtUserSlrole() {
		super();
	}

	public GtUserSlrole(String id){
		super(id);
	}

	

	@Length(min=0, max=35, message="角色编号长度必须介于 0 和 35 之间")
	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	

	
	
}