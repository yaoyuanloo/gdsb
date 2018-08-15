/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 柜台协同从表Entity
 * @author YANG
 * @version 2016-09-16
 */
public class GtYwsynergy extends DataEntity<GtYwsynergy> {
	
	private static final long serialVersionUID = 1L;
	private String ywlsh;		// ywlsh
	private String slhzh;		// slhzh
	private String hzdh;		// hzdh
	
	public GtYwsynergy() {
		super();
	}

	public GtYwsynergy(String id){
		super(id);
	}

	@Length(min=0, max=60, message="ywlsh长度必须介于 0 和 60 之间")
	public String getYwlsh() {
		return ywlsh;
	}

	public void setYwlsh(String ywlsh) {
		this.ywlsh = ywlsh;
	}
	
	@Length(min=0, max=60, message="slhzh长度必须介于 0 和 60 之间")
	public String getSlhzh() {
		return slhzh;
	}

	public void setSlhzh(String slhzh) {
		this.slhzh = slhzh;
	}
	
	@Length(min=0, max=60, message="hzdh长度必须介于 0 和 60 之间")
	public String getHzdh() {
		return hzdh;
	}

	public void setHzdh(String hzdh) {
		this.hzdh = hzdh;
	}
	
}