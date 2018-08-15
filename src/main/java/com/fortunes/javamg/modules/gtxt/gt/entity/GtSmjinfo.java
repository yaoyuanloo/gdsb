/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 业务影像表Entity
 * @author Yang
 * @version 2016-09-10
 */
public class GtSmjinfo extends DataEntity<GtSmjinfo> {
	
	private static final long serialVersionUID = 1L;
	private String ywlsh;		// 业务流水号
	private String smjmc;		// 扫描件名称
	private String smjpath;		// 扫描件目录
	private String smjhjs;		// 扫描件合计数
	private String type;		// 扫描件类型(1普通2清单)
	private String state;		// 状态
	private String ywid;//业务id
	private String material;//材料id
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getYwid() {
		return ywid;
	}

	public void setYwid(String ywid) {
		this.ywid = ywid;
	}

	public GtSmjinfo() {
		super();
	}

	public GtSmjinfo(String id){
		super(id);
	}

	@Length(min=0, max=35, message="业务流水号长度必须介于 0 和 35 之间")
	public String getYwlsh() {
		return ywlsh;
	}

	public void setYwlsh(String ywlsh) {
		this.ywlsh = ywlsh;
	}
	
	@Length(min=0, max=300, message="扫描件名称长度必须介于 0 和 300 之间")
	public String getSmjmc() {
		return smjmc;
	}

	public void setSmjmc(String smjmc) {
		this.smjmc = smjmc;
	}
	
	@Length(min=0, max=2000, message="扫描件目录长度必须介于 0 和 2000 之间")
	public String getSmjpath() {
		return smjpath;
	}

	public void setSmjpath(String smjpath) {
		this.smjpath = smjpath;
	}
	
	@Length(min=0, max=35, message="扫描件合计数长度必须介于 0 和 35 之间")
	public String getSmjhjs() {
		return smjhjs;
	}

	public void setSmjhjs(String smjhjs) {
		this.smjhjs = smjhjs;
	}
	
	@Length(min=0, max=1, message="扫描件类型(1普通2清单)长度必须介于 0 和 1 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}