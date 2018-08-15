/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.entity;

import com.fortunes.javamg.modules.sys.entity.Dict;
import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 地级市业务属性Entity
 * @author cxd
 * @version 2016-09-10
 */
public class DYwatter extends DataEntity<DYwatter> {
	
	private static final long serialVersionUID = 1L;
	private String ywid;		// 地级市业务编号
	private String isjds;		// 是否打印决定书
	private String issjhz;		// 是否打印收件回执
	private String isbqcl;		// 是否打印补齐材料通知单
	private String isbb;		// 是否打印报表
	private String slTempid;		// 受理模板编号
	private String bbTempid;		// 报表模板编号
	private String sjTempid;		// 收件模板编号
	private String bqTempid;		// 补齐材料模板编号
	private Dict flowcode;		// 主流程方式代码
	private Dict lzfscode;		// 流转方式代码
	private String fpfscode;		// 分配方式代码
	private Dict shjbcode;		// 审核级别代码
	private String state;		// 状态
	private String userList;//设定人员

	public String getUserList() {
		return userList;
	}

	public void setUserList(String userList) {
		this.userList = userList;
	}

	public DYwatter() {
		super();
	}

	public DYwatter(String id){
		super(id);
	}

	@Length(min=0, max=35, message="地级市业务编号长度必须介于 0 和 35 之间")
	public String getYwid() {
		return ywid;
	}

	public void setYwid(String ywid) {
		this.ywid = ywid;
	}
	
	@Length(min=0, max=1, message="是否打印决定书长度必须介于 0 和 1 之间")
	public String getIsjds() {
		return isjds;
	}

	public void setIsjds(String isjds) {
		this.isjds = isjds;
	}
	
	@Length(min=0, max=1, message="是否打印收件回执长度必须介于 0 和 1 之间")
	public String getIssjhz() {
		return issjhz;
	}

	public void setIssjhz(String issjhz) {
		this.issjhz = issjhz;
	}
	
	@Length(min=0, max=1, message="是否打印补齐材料通知单长度必须介于 0 和 1 之间")
	public String getIsbqcl() {
		return isbqcl;
	}

	public void setIsbqcl(String isbqcl) {
		this.isbqcl = isbqcl;
	}
	
	@Length(min=0, max=1, message="是否打印报表长度必须介于 0 和 1 之间")
	public String getIsbb() {
		return isbb;
	}

	public void setIsbb(String isbb) {
		this.isbb = isbb;
	}
	
	@Length(min=0, max=35, message="受理模板编号长度必须介于 0 和 35 之间")
	public String getSlTempid() {
		return slTempid;
	}

	public void setSlTempid(String slTempid) {
		this.slTempid = slTempid;
	}
	
	@Length(min=0, max=35, message="报表模板编号长度必须介于 0 和 35 之间")
	public String getBbTempid() {
		return bbTempid;
	}

	public void setBbTempid(String bbTempid) {
		this.bbTempid = bbTempid;
	}
	
	@Length(min=0, max=35, message="收件模板编号长度必须介于 0 和 35 之间")
	public String getSjTempid() {
		return sjTempid;
	}

	public void setSjTempid(String sjTempid) {
		this.sjTempid = sjTempid;
	}
	
	@Length(min=0, max=35, message="补齐材料模板编号长度必须介于 0 和 35 之间")
	public String getBqTempid() {
		return bqTempid;
	}

	public void setBqTempid(String bqTempid) {
		this.bqTempid = bqTempid;
	}

	public Dict getFlowcode() {
		return flowcode;
	}

	public void setFlowcode(Dict flowcode) {
		this.flowcode = flowcode;
	}

	public Dict getLzfscode() {
		return lzfscode;
	}

	public void setLzfscode(Dict lzfscode) {
		this.lzfscode = lzfscode;
	}

	@Length(min=0, max=35, message="分配方式代码长度必须介于 0 和 35 之间")
	public String getFpfscode() {
		return fpfscode;
	}

	public void setFpfscode(String fpfscode) {
		this.fpfscode = fpfscode;
	}

	public Dict getShjbcode() {
		return shjbcode;
	}

	public void setShjbcode(Dict shjbcode) {
		this.shjbcode = shjbcode;
	}

	@Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}