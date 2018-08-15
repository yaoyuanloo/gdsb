/**
 * 
 */
package com.fortunes.javamg.modules.gtxt.city.entity;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 地级市业务分类Entity
 * @author 杨
 * @version 2016-09-06
 */
public class DWlzfs extends DataEntity<DWlzfs> {
	
	private static final long serialVersionUID = 1L; 
	private String jRevi;		// 业务审核流转方式
	private String jAss;		// 业务分配方式
	private String jClass;		// 业务审核级别
	private String primaryPerson;		// 设定人
	public String getjRevi() {
		return jRevi;
	}
	public void setjRevi(String jRevi) {
		this.jRevi = jRevi;
	}
	public String getjAss() {
		return jAss;
	}
	public void setjAss(String jAss) {
		this.jAss = jAss;
	}
	public String getjClass() {
		return jClass;
	}
	public void setjClass(String jClass) {
		this.jClass = jClass;
	}
	public String getPrimaryPerson() {
		return primaryPerson;
	}
	public void setPrimaryPerson(String primaryPerson) {
		this.primaryPerson = primaryPerson;
	}
	
	

	
	
}