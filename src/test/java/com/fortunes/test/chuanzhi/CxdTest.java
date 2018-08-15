package com.fortunes.test.chuanzhi;

import com.fortunes.test.DubboTest;
import com.google.common.collect.Lists;
import com.powersi.biz.medicare.medicareCoreBiz.dto.mediBizDTO;
import com.powersi.biz.medicare.medicareSpecial.dto.MediSpecDTO;
import com.powersi.dubbo.medicare.inter.ReimDeclareInterface;
import com.powersi.dubbo.medicare.medicareSpecial.dto.ChangeHospitalDTO;
import com.powersi.dubbo.medicare.medicareSpecial.toFangDi.SecondReturnHospitalInterface;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cxd on 2016/10/31 0031.
 */
public class CxdTest extends DubboTest {

    @Autowired
    ReimDeclareInterface service;

    @Autowired
    SecondReturnHospitalInterface service1;

    /**
     * 修改就诊信息
     */
    @Test
    public void test(){
        mediBizDTO m = new mediBizDTO();
        m.setBka401("0");
        m.setBkc111("0");
        m.setBke958("0");
        m.setDfbz("0");
        m.setBka004("1");
        m.setBkc110("1");
        m.setBka030("3");
        m.setAka130("12");
        m.setBka006("120");
        m.setBka116("123");
        m.setBka408("183");
        m.setAae140("310");
        m.setAae013("");
        m.setBka928("");
        m.setAkb020("002001");
        m.setBka017("20161005");
        m.setBka032("20161008");
        m.setAab001("41305360");
        m.setAac001("1057926332");
        m.setAaz218("0000001610000509");
        m.setBilllist("[{\"bka418\":\"126\",\"bka116\":\"123\",\"bka416\":\"1\",\"bka404\":\"1\",\"aae019\":\"6000\",\"aae013\":\"\"}]");
        m.setDatam("135_x_138_x_140_x_143_x_150_x_142");
        m.setAka120("M81900/0");
        m.setBka409("广东省人民医院");
        m.setBka008("广州市番禺区中心医院(广州市番禺区人民医院)");
        m.setAka121("小梁性腺瘤");
        m.setAac003("张某某");

        Map<String, Object> mPara = new HashMap<String, Object>();

        mPara.put("biz", m);
        mPara.put("preakb020", "002001");
        Map<String, Object> re = service.saveModifyBizInfo(mPara);
        out(re);
    }

    /**
     * 二次返院 查询
     */
    @Test
    public void test1(){
        MediSpecDTO p = new MediSpecDTO();
        p.setAac001(1007725703L);
        p.setAka083("122");
        List<Map<String, Object>> list = service1.querySecondReturnHospitalInfo(p);
        out(list);
    }

    /**
     * 二次返院 初审
     * aaz267:序列号；
     * bka137:初审人工号；
     * bke021:初审人；
     * bke024:初审意见；
     * aae140:险种；
     * aac001:个人电脑号；
     * aaa027:所属区；
     * aae016:审核标志(2:初审通过；3：初审不通过)
     */
    @Test
    public void test2(){
       /* ChangeHospitalDTO p = new ChangeHospitalDTO();
        List<MediSpecDTO> list = Lists.newArrayList();
        MediSpecDTO p1 = new MediSpecDTO();
        p1.setAaz267(11000289L);
        p1.setBka137("1029");
        p1.setBke021("杨晴");
        p1.setBke024("测试意见");
        p1.setAae140("310");
        p1.setAac001(1007725703);
        p1.setAaa027("441821");
        p1.setAae016("2");
        list.add(p1);
        p.setChangeList(list);
        Map<String, Object> map = service1.auditSecondReturnHospitalInfo(p);
        out(map);*/
    }
}
