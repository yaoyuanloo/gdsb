/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 邮政送达详情表Entity
 * @author Yang
 * @version 2016-09-09
 */
public class GtEmsinfo extends DataEntity<GtEmsinfo> {
	
	private static final long serialVersionUID = 1L;
	private String ywlsh;		// 业务流水号
	private String sddz;		// 送达详细地址
	private String sjr;		// 收件人
	private String lxfs;		// 联系电话
	private String bydh;		// 备用电话
	private String by1;		// 备用1
	private String by2;		// 备用2
	private String by3;		// 备用3
	private String state;		// 送达状态
	private String sdqy;		// 送达区域
	
	public GtEmsinfo() {
		super();
	}

	public GtEmsinfo(String id){
		super(id);
	}

	@Length(min=1, max=35, message="业务流水号长度必须介于 1 和 35 之间")
	public String getYwlsh() {
		return ywlsh;
	}

	public void setYwlsh(String ywlsh) {
		this.ywlsh = ywlsh;
	}
	
	@Length(min=1, max=300, message="送达详细地址长度必须介于 1 和 300 之间")
	public String getSddz() {
		return sddz;
	}

	public void setSddz(String sddz) {
		this.sddz = sddz;
	}
	
	@Length(min=1, max=35, message="收件人长度必须介于 1 和 35 之间")
	public String getSjr() {
		return sjr;
	}

	public void setSjr(String sjr) {
		this.sjr = sjr;
	}
	
	@Length(min=1, max=3035, message="联系电话长度必须介于 1 和 3035 之间")
	public String getLxfs() {
		return lxfs;
	}

	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}
	
	@Length(min=0, max=35, message="备用电话长度必须介于 0 和 35 之间")
	public String getBydh() {
		return bydh;
	}

	public void setBydh(String bydh) {
		this.bydh = bydh;
	}
	
	@Length(min=0, max=30, message="备用1长度必须介于 0 和 30 之间")
	public String getBy1() {
		return by1;
	}

	public void setBy1(String by1) {
		this.by1 = by1;
	}
	
	@Length(min=0, max=30, message="备用2长度必须介于 0 和 30 之间")
	public String getBy2() {
		return by2;
	}

	public void setBy2(String by2) {
		this.by2 = by2;
	}
	
	@Length(min=0, max=30, message="备用3长度必须介于 0 和 30 之间")
	public String getBy3() {
		return by3;
	}

	public void setBy3(String by3) {
		this.by3 = by3;
	}
	
	@Length(min=0, max=30, message="送达状态长度必须介于 0 和 30 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Length(min=0, max=30, message="送达区域长度必须介于 0 和 30 之间")
	public String getSdqy() {
		return sdqy;
	}

	public void setSdqy(String sdqy) {
		this.sdqy = sdqy;
	}
	
}