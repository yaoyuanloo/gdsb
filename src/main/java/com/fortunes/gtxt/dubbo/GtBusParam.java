package com.fortunes.gtxt.dubbo;


import com.yinhai.dubbo.common.AbstractParam;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/21.
 */
public class GtBusParam extends AbstractParam {

    private static final long serialVersionUID = -4995012502642768284L;
    private String ywlsh;		// 业务流水号
    private String slhzh;		// 受理回执号
    private String hzdh;		// 汇总单号
    private String hzhjs;		// 汇总合计数
    private String ywid;		// 地级市业务id
    private String ywbh;		// 业务功能代码
    private String ywmc;		// 业务名称
    private String grsbh;		// 个人社保卡号
    private String sfzh;		// 个人身份证号
    private String dnh;		    // 个人身份证号
    private String xm;		     // 姓名
    private String dwbh;		// 单位编号
    private String dwmc;		// 单位名称
    private String smjbh;		// 扫描件编号
    private String slr;		    // 受理人
    private String fqbh;		// 分区编号
    private String lczt;		// 流程状态
    private Date cjdate;		// 创建时间
    private String slqy;		// 受理区域
    private String yzdh;		// 邮政单号
    private String blgzr;		// 办理时限
    private String synergy = "0";
    private String zone;        //地区

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

    public String getHzdh() {
        return hzdh;
    }

    public void setHzdh(String hzdh) {
        this.hzdh = hzdh;
    }

    public String getHzhjs() {
        return hzhjs;
    }

    public void setHzhjs(String hzhjs) {
        this.hzhjs = hzhjs;
    }

    public String getYwid() {
        return ywid;
    }

    public void setYwid(String ywid) {
        this.ywid = ywid;
    }

    public String getYwbh() {
        return ywbh;
    }

    public void setYwbh(String ywbh) {
        this.ywbh = ywbh;
    }

    public String getYwmc() {
        return ywmc;
    }

    public void setYwmc(String ywmc) {
        this.ywmc = ywmc;
    }

    public String getGrsbh() {
        return grsbh;
    }

    public void setGrsbh(String grsbh) {
        this.grsbh = grsbh;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getDnh() {
        return dnh;
    }

    public void setDnh(String dnh) {
        this.dnh = dnh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getSmjbh() {
        return smjbh;
    }

    public void setSmjbh(String smjbh) {
        this.smjbh = smjbh;
    }

    public String getSlr() {
        return slr;
    }

    public void setSlr(String slr) {
        this.slr = slr;
    }

    public String getFqbh() {
        return fqbh;
    }

    public void setFqbh(String fqbh) {
        this.fqbh = fqbh;
    }

    public String getLczt() {
        return lczt;
    }

    public void setLczt(String lczt) {
        this.lczt = lczt;
    }

    public Date getCjdate() {
        return cjdate;
    }

    public void setCjdate(Date cjdate) {
        this.cjdate = cjdate;
    }

    public String getSlqy() {
        return slqy;
    }

    public void setSlqy(String slqy) {
        this.slqy = slqy;
    }

    public String getYzdh() {
        return yzdh;
    }

    public void setYzdh(String yzdh) {
        this.yzdh = yzdh;
    }

    public String getBlgzr() {
        return blgzr;
    }

    public void setBlgzr(String blgzr) {
        this.blgzr = blgzr;
    }

    public String getSynergy() {
        return synergy;
    }

    public void setSynergy(String synergy) {
        this.synergy = synergy;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}
