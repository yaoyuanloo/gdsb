/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 扫描件清单表Entity
 * @author Yang
 * @version 2016-09-09
 */
public class GtSmjcb extends DataEntity<GtSmjcb> {
	
	private static final long serialVersionUID = 1L;
	private String smjid;		// 影像ID
	private String smjmc;		// 扫描件名称
	private String smjpath;		// 扫描件目录
	private String smjhjs;		// 扫描件合计数
	private String state;		// 状态
	
	public GtSmjcb() {
		super();
	}

	public GtSmjcb(String id){
		super(id);
	}

	@Length(min=1, max=35, message="影像ID长度必须介于 1 和 35 之间")
	public String getSmjid() {
		return smjid;
	}

	public void setSmjid(String smjid) {
		this.smjid = smjid;
	}
	
	@Length(min=1, max=300, message="扫描件名称长度必须介于 1 和 300 之间")
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
	
	@Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}