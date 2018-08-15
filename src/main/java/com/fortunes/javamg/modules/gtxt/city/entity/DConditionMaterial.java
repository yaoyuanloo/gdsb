/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 地级市条件和材料中间表Entity
 * @author Yang
 * @version 2016-09-09
 */
public class DConditionMaterial extends DataEntity<DConditionMaterial> {
	
	private static final long serialVersionUID = 1L;
	private String dConId;		// 地级市条件编号
	private String pMateId;		// 公共材料编号
	
	public DConditionMaterial() {
		super();
	}

	public DConditionMaterial(String id){
		super(id);
	}

	@Length(min=1, max=30, message="地级市条件编号长度必须介于 1 和 30 之间")
	public String getDConId() {
		return dConId;
	}

	public void setDConId(String dConId) {
		this.dConId = dConId;
	}
	
	@Length(min=1, max=30, message="公共材料编号长度必须介于 1 和 30 之间")
	public String getPMateId() {
		return pMateId;
	}

	public void setPMateId(String pMateId) {
		this.pMateId = pMateId;
	}
	
}