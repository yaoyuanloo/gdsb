/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 本地业务属性定义Entity
 * @author YUAN
 * @version 2016-09-07
 */
public class DYwinfoGroup2 extends DataEntity<DYwinfoGroup2> {
	
	private static final long serialVersionUID = 1L;
	private String ywId;		// 业务编号
	private String conment;		// 业务内容
	private String day;		// 工作日
	private String orgid;		// 机构代码
	private String state;		// 状态
	
	public DYwinfoGroup2() {
		super();
	}

	public DYwinfoGroup2(String id){
		super(id);
	}

	@Length(min=0, max=30, message="业务编号长度必须介于 0 和 30 之间")
	public String getYwId() {
		return ywId;
	}

	public void setYwId(String ywId) {
		this.ywId = ywId;
	}
	
	@Length(min=0, max=300, message="业务内容长度必须介于 0 和 300 之间")
	public String getConment() {
		return conment;
	}

	public void setConment(String conment) {
		this.conment = conment;
	}
	
	@Length(min=0, max=20, message="工作日长度必须介于 0 和 20 之间")
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	@Length(min=0, max=30, message="机构代码长度必须介于 0 和 30 之间")
	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	@Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}