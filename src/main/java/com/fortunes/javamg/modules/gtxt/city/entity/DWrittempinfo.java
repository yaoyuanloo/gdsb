/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 文书模板信息表Entity
 * @author YANG
 * @version 2016-09-07
 */
public class DWrittempinfo extends DataEntity<DWrittempinfo> {
	
	private static final long serialVersionUID = 1L;
	private String cateId;		// 模板分类
	private String name;		// 模板名称
	private String code;		// 功能代码
	private String conment;		// 内容
	private String state;		// 状态
	
	public DWrittempinfo() {
		super();
	}

	public DWrittempinfo(String id){
		super(id);
	}

	@Length(min=0, max=35, message="模板分类长度必须介于 0 和 35 之间")
	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	@Length(min=0, max=200, message="模板名称长度必须介于 0 和 200 之间")
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
	
}