/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.gt.entity;

import com.fortunes.javamg.modules.sys.entity.Dict;
import org.hibernate.validator.constraints.Length;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 柜台业务录入表Entity
 * @author Yang
 * @version 2016-09-09
 */
public class GtYwinput extends DataEntity<GtYwinput> {
	
	private static final long serialVersionUID = 1L;
	private String ywlsh;		// 业务流水号
	private Dict lrzt;		// 录入状态(审核状态,审批状态)
	private String jsoninfo;		// JOSN数据内容
	private String state;		// 状态
	private String lczt;		// 流程状态
	
	public GtYwinput() {
		super();
	}

	public GtYwinput(String id){
		super(id);
	}

	public GtYwinput(String ywlsh, String lczt){
		this.ywlsh = ywlsh;
		this.lczt = lczt;
	}

	@Length(min=1, max=35, message="业务流水号长度必须介于 1 和 35 之间")
	public String getYwlsh() {
		return ywlsh;
	}

	public void setYwlsh(String ywlsh) {
		this.ywlsh = ywlsh;
	}

	public Dict getLrzt() {
		return lrzt;
	}

	public void setLrzt(Dict lrzt) {
		this.lrzt = lrzt;
	}

	public String getJsoninfo() {
		return jsoninfo;
	}

	public void setJsoninfo(String jsoninfo) {
		this.jsoninfo = jsoninfo;
	}

	@Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLczt() {
		return lczt;
	}

	public void setLczt(String lczt) {
		this.lczt = lczt;
	}
}