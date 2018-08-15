/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.entity;

import com.fortunes.javamg.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 柜台受理业务从表Entity
 * @author Yang
 * @version 2016-09-09
 */
public class GtYwinfocb extends DataEntity<GtYwinfocb> {
	
	private static final long serialVersionUID = 1L;
	private String ywlsh;		// 业务流水号
	private String ywlc;		// 业务流程
	private String cljg;		// 处理结果
	private String clyj;		// 处理意见
	private User clr;		// 处理人
	
	public GtYwinfocb() {
		super();
	}

	public GtYwinfocb(String id){
		super(id);
	}

	@Length(min=1, max=35, message="业务流水号长度必须介于 1 和 35 之间")
	public String getYwlsh() {
		return ywlsh;
	}

	public void setYwlsh(String ywlsh) {
		this.ywlsh = ywlsh;
	}
	
	@Length(min=1, max=10, message="业务流程长度必须介于 1 和 10 之间")
	public String getYwlc() {
		return ywlc;
	}

	public void setYwlc(String ywlc) {
		this.ywlc = ywlc;
	}
	
	@Length(min=0, max=100, message="处理结果长度必须介于 0 和 100 之间")
	public String getCljg() {
		return cljg;
	}

	public void setCljg(String cljg) {
		this.cljg = cljg;
	}
	
	@Length(min=0, max=200, message="处理意见长度必须介于 0 和 200 之间")
	public String getClyj() {
		return clyj;
	}

	public void setClyj(String clyj) {
		this.clyj = clyj;
	}

	public User getClr() {
		return clr;
	}

	public void setClr(User clr) {
		this.clr = clr;
	}
}