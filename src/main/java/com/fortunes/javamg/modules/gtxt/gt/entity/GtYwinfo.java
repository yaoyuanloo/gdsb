/**
 *
 */
package com.fortunes.javamg.modules.gtxt.gt.entity;

import com.fortunes.javamg.modules.sys.entity.Dict;
import com.fortunes.javamg.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fortunes.javamg.common.persistence.DataEntity;

/**
 * 柜台业务受理表Entity
 * @author Yang
 * @version 2016-09-09
 */
public class GtYwinfo extends DataEntity<GtYwinfo> {
	private static final long serialVersionUID = 1L;
	private String ywlsh;		// 业务流水号
	private String slhzh;		// 受理回执号
	private String hzdh;		// 汇总单号
	private String hzhjs;		// 汇总合计数
	private String ywid;		// 地级市业务id
	private String ywbh;		// 业务功能代码
	private String ywmc;		// 业务名称
	private String grsbh;		// 个人社保卡号
	private String sfzh;		// 个人身份证号
	private String dnh;		// 个人身份证号
	private String xm;		// 姓名
	private String dwbh;		// 单位编号
	private String dwmc;		// 单位名称
	private String smjbh;		// 扫描件编号
	private User slr;		// 受理人
	private String fqbh;		// 分区编号
	private String lczt;		// 流程状态
	private Date cjdate;		// 创建时间
	private Dict sbfs;		// 申报方式
	private String slqy;		// 受理区域
	private String yzdh;		// 邮政单号
	private Integer blgzr;		// 办理时限
	private User shry;		// 审核人
	private User fpr;		// 分配人
	private String gnj;		// 功能键
	private String by1;		// 备用1
	private String by2;		// 备用2
	private String by3;		// 备用3
	private String by4;		// 备用4
	private String by5;		// 备用5
	private String by6;		// 备用6
	private String by7;		// 备用7
	private String by8;		// 备用8
	private Dict fpzt;      //分配状态
    private String synergy = "0";

	public GtYwinfo() {
		super();
	}

	public Dict getFpzt() {
		return fpzt;
	}

	public void setFpzt(Dict fpzt) {
		this.fpzt = fpzt;
	}

	public GtYwinfo(String id){
		super(id);
	}

	@Length(min=1, max=35, message="业务流水号长度必须介于 1 和 35 之间")
	public String getYwlsh() {
		return ywlsh;
	}

	public void setYwlsh(String ywlsh) {
		this.ywlsh = ywlsh;
	}

	public String getSlhzh() {
		return slhzh;
	}

	public void setSlhzh(String slhzh) {
		this.slhzh = slhzh;
	}

	@Length(min=0, max=30, message="汇总合计数长度必须介于 0 和 30 之间")
	public String getHzhjs() {
		return hzhjs;
	}

	public void setHzhjs(String hzhjs) {
		this.hzhjs = hzhjs;
	}

	@Length(min=0, max=35, message="汇总单号长度必须介于 0 和 35 之间")
	public String getHzdh() {
		return hzdh;
	}

	public void setHzdh(String hzdh) {
		this.hzdh = hzdh;
	}

	@Length(min=0, max=40, message="地级市业务id长度必须介于 0 和 40 之间")
	public String getYwid() {
		return ywid;
	}

	public void setYwid(String ywid) {
		this.ywid = ywid;
	}

	@Length(min=0, max=35, message="业务功能代码长度必须介于 0 和 35 之间")
	public String getYwbh() {
		return ywbh;
	}

	public void setYwbh(String ywbh) {
		this.ywbh = ywbh;
	}

	@Length(min=0, max=200, message="业务名称长度必须介于 0 和 200 之间")
	public String getYwmc() {
		return ywmc;
	}

	public void setYwmc(String ywmc) {
		this.ywmc = ywmc;
	}

	@Length(min=0, max=35, message="个人社保卡号长度必须介于 0 和 35 之间")
	public String getGrsbh() {
		return grsbh;
	}

	public void setGrsbh(String grsbh) {
		this.grsbh = grsbh;
	}

	@Length(min=0, max=30, message="个人身份证号长度必须介于 0 和 30 之间")
	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	@Length(min=0, max=35, message="电脑号长度必须介于 0 和 35 之间")
	public String getDnh() {
		return dnh;
	}

	public void setDnh(String dnh) {
		this.dnh = dnh;
	}

	@Length(min=0, max=30, message="姓名长度必须介于 0 和 30 之间")
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	@Length(min=0, max=30, message="单位编号长度必须介于 0 和 30 之间")
	public String getDwbh() {
		return dwbh;
	}

	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}

	@Length(min=0, max=30, message="单位名称长度必须介于 0 和 30 之间")
	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	@Length(min=0, max=35, message="扫描件编号长度必须介于 0 和 35 之间")
	public String getSmjbh() {
		return smjbh;
	}

	public void setSmjbh(String smjbh) {
		this.smjbh = smjbh;
	}

    public User getSlr() {
        return slr;
    }

    public void setSlr(User slr) {
        this.slr = slr;
    }

    @Length(min=0, max=30, message="分区编号长度必须介于 0 和 30 之间")
	public String getFqbh() {
		return fqbh;
	}

	public void setFqbh(String fqbh) {
		this.fqbh = fqbh;
	}

	@Length(min=0, max=30, message="流程状态长度必须介于 0 和 30 之间")
	public String getLczt() {
		return lczt;
	}

	public void setLczt(String lczt) {
		this.lczt = lczt;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCjdate() {
		return cjdate;
	}

	public void setCjdate(Date cjdate) {
		this.cjdate = cjdate;
	}

	public Dict getSbfs() {
		return sbfs;
	}

	public void setSbfs(Dict sbfs) {
		this.sbfs = sbfs;
	}

	@Length(min=0, max=30, message="受理区域长度必须介于 0 和 30 之间")
	public String getSlqy() {
		return slqy;
	}

	public void setSlqy(String slqy) {
		this.slqy = slqy;
	}

	@Length(min=0, max=30, message="邮政单号长度必须介于 0 和 30 之间")
	public String getYzdh() {
		return yzdh;
	}

	public void setYzdh(String yzdh) {
		this.yzdh = yzdh;
	}

	public Integer getBlgzr() {
		return blgzr;
	}

	public void setBlgzr(Integer blgzr) {
		this.blgzr = blgzr;
	}

	@Length(min=0, max=35, message="审核人长度必须介于 0 和 35 之间")
	public User getShry() {
		return shry;
	}

	public void setShry(User shry) {
		this.shry = shry;
	}

	@Length(min=0, max=35, message="分配人长度必须介于 0 和 35 之间")
	public User getFpr() {
		return fpr;
	}

	public void setFpr(User fpr) {
		this.fpr = fpr;
	}

	@Length(min=0, max=35, message="功能键长度必须介于 0 和 35 之间")
	public String getGnj() {
		return gnj;
	}

	public void setGnj(String gnj) {
		this.gnj = gnj;
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

	@Length(min=0, max=30, message="备用4长度必须介于 0 和 30 之间")
	public String getBy4() {
		return by4;
	}

	public void setBy4(String by4) {
		this.by4 = by4;
	}

	@Length(min=0, max=30, message="备用5长度必须介于 0 和 30 之间")
	public String getBy5() {
		return by5;
	}

	public void setBy5(String by5) {
		this.by5 = by5;
	}

	@Length(min=0, max=30, message="备用6长度必须介于 0 和 30 之间")
	public String getBy6() {
		return by6;
	}

	public void setBy6(String by6) {
		this.by6 = by6;
	}

	@Length(min=0, max=30, message="备用7长度必须介于 0 和 30 之间")
	public String getBy7() {
		return by7;
	}

	public void setBy7(String by7) {
		this.by7 = by7;
	}

	@Length(min=0, max=30, message="备用8长度必须介于 0 和 30 之间")
	public String getBy8() {
		return by8;
	}

	public void setBy8(String by8) {
		this.by8 = by8;
	}

	public String getSynergy() {
		return synergy;
	}

	public void setSynergy(String synergy) {
		this.synergy = synergy;
	}
}