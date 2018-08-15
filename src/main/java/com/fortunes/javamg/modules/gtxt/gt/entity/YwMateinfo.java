/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 业务和材料生成表Entity
 * @author Yang
 * @version 2016-09-16
 */
public class YwMateinfo extends DataEntity<YwMateinfo> {
	
	private static final long serialVersionUID = 1L;
	private String ywlsh;		// ywlsh
	private String mateid;		// mateid
	
	public YwMateinfo() {
		super();
	}

	public YwMateinfo(String id){
		super(id);
	}

	public YwMateinfo(String ywlsh, String mateid){
		this.ywlsh = ywlsh;
		this.mateid = mateid;
	}

	@Length(min=1, max=60, message="ywlsh长度必须介于 1 和 60 之间")
	public String getYwlsh() {
		return ywlsh;
	}

	public void setYwlsh(String ywlsh) {
		this.ywlsh = ywlsh;
	}
	
	@Length(min=1, max=60, message="mateid长度必须介于 1 和 60 之间")
	public String getMateid() {
		return mateid;
	}

	public void setMateid(String mateid) {
		this.mateid = mateid;
	}
	
}