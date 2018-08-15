/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 业务条件分类Entity
 * @author YANG
 * @version 2016-09-07
 */
public class PConditionCate extends DataEntity<PConditionCate> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 条件分类名称
	private String code;		// 功能代码
	private String conment;		// 内容
	private String state;		// 状态
	private String ywType;		// 业务类型
	
	public PConditionCate() {
		super();
	}

	public PConditionCate(String id){
		super(id);
	}

	@Length(min=0, max=200, message="条件分类名称长度必须介于 0 和 200 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=100, message="功能代码长度必须介于 0 和 100 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=2000, message="内容长度必须介于 0 和 2000 之间")
	public String getConment() {
		return conment;
	}

	public void setConment(String conment) {
		this.conment = conment;
	}
	
	@Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Length(min=0, max=20, message="业务类型长度必须介于 0 和 20 之间")
	public String getYwType() {
		return ywType;
	}

	public void setYwType(String ywType) {
		this.ywType = ywType;
	}
	
}