/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.publicyw.entity;

import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 公共业务信息表Entity
 * @author YANG
 * @version 2016-09-07
 */
public class PYwinfo extends DataEntity<PYwinfo> {
	
	private static final long serialVersionUID = 1L;
	private PYwCate pywCate;		// 业务分类
	private String name;		// 业务名称
	private String code;		// 功能代码

	public PYwCate getPywCate() {
		return pywCate;
	}

	public void setPywCate(PYwCate pywCate) {
		this.pywCate = pywCate;
	}

	private String conment;		// 内容
	private String state;		// 状态
	private String acceptaddress;		// 受理地址
	private String examineaddress;		// 审核地址
	private String trialaddress;		// 初审地址
	private String reviewaddress;		// 复审地址
	private String approveaddress;		// 审批地址
	
	public PYwinfo() {
		super();
	}

	public PYwinfo(String id){
		super(id);
	}


	@Length(min=0, max=200, message="业务名称长度必须介于 0 和 200 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=100, message="功能代码长度必须介于 0 和 100 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=2000, message="内容长度必须介于 0 和 2000 之间")
	public String getConment() {
		return conment;
	}

	public void setConment(String conment) {
		this.conment = conment;
	}
	
	@Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAcceptaddress() {
		return acceptaddress;
	}

	public void setAcceptaddress(String acceptaddress) {
		this.acceptaddress = acceptaddress;
	}

	public String getExamineaddress() {
		return examineaddress;
	}

	public void setExamineaddress(String examineaddress) {
		this.examineaddress = examineaddress;
	}

	public String getTrialaddress() {
		return trialaddress;
	}

	public void setTrialaddress(String trialaddress) {
		this.trialaddress = trialaddress;
	}

	public String getReviewaddress() {
		return reviewaddress;
	}

	public void setReviewaddress(String reviewaddress) {
		this.reviewaddress = reviewaddress;
	}

	public String getApproveaddress() {
		return approveaddress;
	}

	public void setApproveaddress(String approveaddress) {
		this.approveaddress = approveaddress;
	}

	
	
}