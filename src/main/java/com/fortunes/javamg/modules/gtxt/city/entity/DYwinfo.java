/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.entity;

import com.fortunes.javamg.modules.gtxt.publicyw.entity.PYwinfo;
import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 本地业务制定Entity
 * @author xwm
 * @version 2016-09-07
 */
public class DYwinfo extends DataEntity<DYwinfo> {
	
	private static final long serialVersionUID = 1L;
	private PYwinfo pywinfo;		// 业务编号
	private String conment;		// 业务内容
	private String day;		// 工作日
	private String orgid;		// 机构代码
	private String state;		// 状态
	private String remarks;//备注信息
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	private String name;
	private String pid;
	private String pname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public DYwinfo() {
		super();
	}

	public DYwinfo(String id){
		super(id);
	}

	public PYwinfo getPywinfo() {
		return pywinfo;
	}

	public void setPywinfo(PYwinfo pywinfo) {
		this.pywinfo = pywinfo;
	}

	@Length(min=0, max=300, message="业务内容长度必须介于 0 和 300 之间")
	public String getConment() {
		return conment;
	}

	public void setConment(String conment) {
		this.conment = conment;
	}
	
	@Length(min=0, max=20, message="工作日长度必须介于 0 和 20 之间")
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	@Length(min=0, max=30, message="机构代码长度必须介于 0 和 30 之间")
	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	@Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}