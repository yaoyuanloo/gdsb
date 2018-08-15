/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 柜台用户权限关联表Entity
 * @author wan
 * @version 2016-09-09
 */
public class GtUserQx extends DataEntity<GtUserQx> {
	
	private static final long serialVersionUID = 1L;
	private String qxid;		// 权限编号
	private String userid;
	
	

	public GtUserQx() {
		super();
	}

	public GtUserQx(String id){
		super(id);
	}

	@Length(min=0, max=30, message="权限编号长度必须介于 0 和 30 之间")
	public String getQxid() {
		return qxid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setQxid(String qxid) {
		this.qxid = qxid;
	}
	
	
	
}