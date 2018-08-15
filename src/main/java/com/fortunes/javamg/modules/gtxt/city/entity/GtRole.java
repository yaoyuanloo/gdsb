/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.entity;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;


import com.google.common.collect.Lists;
import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 柜台受理角色管理Entity
 * @author 万
 * @version 2016-09-07
 */
public class GtRole extends DataEntity<GtRole> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 角色名
	private String conment;		// 角色说明
	private String code;		// 角色编号
	private String zone;		// 机构编号
	private String roleType;		// 角色类型
	private String state;		// 状态
	private List<DYwinfo> ywList = Lists.newArrayList(); // 拥有业务列表
	private String ywIds;
	public List<String> getYwIdList() {
		List<String> ywIdList = Lists.newArrayList();
		for (DYwinfo ywinfo : ywList) {
			ywIdList.add(ywinfo.getId());
		}
		return ywIdList;
	}
	public List<DYwinfo> getYwList() {
		return ywList;
	}

	public void setYwList(List<DYwinfo> ywList) {
		this.ywList = ywList;
	}

	public String getYwIds() {
		return StringUtils.join(getYwIdList(), ",");
	}
	
	public void setYwIds(String ywIds) {
		this.ywIds = ywIds;
		ywList = Lists.newArrayList();
		if (ywIds != null){
			String[] ids = StringUtils.split(ywIds, ",");
			setYwIdList(Lists.newArrayList(ids));
		}
	}

	public void setYwIdList(List<String> YwIdList) {
		ywList = Lists.newArrayList();
		for (String ywid : YwIdList) {
			DYwinfo yw = new DYwinfo();
			yw.setId(ywid);
			ywList.add(yw);
		}
	}
	public GtRole() {
		super();
	}

	public GtRole(String id){
		super(id);
	}

	@Length(min=0, max=35, message="角色名长度必须介于 0 和 35 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=300, message="角色说明长度必须介于 0 和 300 之间")
	public String getConment() {
		return conment;
	}

	public void setConment(String conment) {
		this.conment = conment;
	}
	
	@Length(min=0, max=35, message="角色编号长度必须介于 0 和 35 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=40, message="机构编号长度必须介于 0 和 40 之间")
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	
	@Length(min=0, max=35, message="角色类型长度必须介于 0 和 35 之间")
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	@Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
}