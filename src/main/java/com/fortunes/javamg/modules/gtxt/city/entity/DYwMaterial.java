/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 地级市业务材中间表Entity
 * @author Yang
 * @version 2016-09-09
 */
public class DYwMaterial extends DataEntity<DYwMaterial> {
	
	private static final long serialVersionUID = 1L;
	private String ywId;		// 地级业务编号
	private String pMateId;		// 公共材料编号
	
	public DYwMaterial() {
		super();
	}

	public DYwMaterial(String id){
		super(id);
	}

	@Length(min=1, max=35, message="地级业务编号长度必须介于 1 和 35 之间")
	public String getYwId() {
		return ywId;
	}

	public void setYwId(String ywId) {
		this.ywId = ywId;
	}
	
	@Length(min=1, max=35, message="公共材料编号长度必须介于 1 和 35 之间")
	public String getPMateId() {
		return pMateId;
	}

	public void setPMateId(String pMateId) {
		this.pMateId = pMateId;
	}
	
}