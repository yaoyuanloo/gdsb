/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 地级市业务条件中间表Entity
 * @author Yang
 * @version 2016-09-09
 */
public class DYwCondition extends DataEntity<DYwCondition> {
	
	private static final long serialVersionUID = 1L;
	private String ywId;		// 地级市业务编号
	private String pConId;		// 公共条件编号
	
	public DYwCondition() {
		super();
	}

	public DYwCondition(String id){
		super(id);
	}

	@Length(min=1, max=30, message="地级市业务编号长度必须介于 1 和 30 之间")
	public String getYwId() {
		return ywId;
	}

	public void setYwId(String ywId) {
		this.ywId = ywId;
	}
	
	@Length(min=1, max=30, message="公共条件编号长度必须介于 1 和 30 之间")
	public String getPConId() {
		return pConId;
	}

	public void setPConId(String pConId) {
		this.pConId = pConId;
	}
	
}