/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 公共业务类别Entity
 * @author 杨
 * @version 2016-09-06
 */
public class PYwCate extends DataEntity<PYwCate> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String code;		// 功能代码
	private String conment;		// 内容
	private String state;		// 状态
	private String ywType;		// 业务类别
	
	public PYwCate() {
		super();
	}

	public PYwCate(String id){
		super(id);
	}

	@Length(min=0, max=200, message="名称长度必须介于 0 和 200 之间")
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
	
	@Length(min=0, max=20, message="业务类别长度必须介于 0 和 20 之间")
	public String getYwType() {
		return ywType;
	}

	public void setYwType(String ywType) {
		this.ywType = ywType;
	}
	
}