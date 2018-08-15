package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r8.f14020216.F14020216Service;
import com.wondersgroup.interfaceServiceVS.retirementVS.r8.f14020216.params.*;
import com.wondersgroup.wssip.bc.generalbenefitmgmt.socialdelivermgr.model.dto.Acm4SaveDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 领取资格认证报到(本市领取异地居住、本市居住异地领取)
 * Created by cxd on 2016/10/27 0027.
 */
public class AuthenticationTest extends DubboTest {

    @Autowired
    F14020216Service service;

    /**
     * 领取资格认证报到(本市领取异地居住)
     * <p>
     * F14020216QueryInputParams;基类,该基类包含以下几个字段:
     * private int currentPage;    // 当前页码
     * private int rows;//每页大小
     * <p>
     * <p>
     * <p>
     * F14020216QueryOutputParams;基类,该基类包含以下几个字段:
     * int totalCounts;    // 总记录条数
     * int totalPage;      // 总页数
     * int currentPage;    // 当前页码
     * int rows;           // 每页大小
     * List<Acm4SaveDTO> baselist; //结果集
     * <p>
     * Acm4SaveDTO字段属性如下:
     * Long baa701;// 养老待遇领取资格认证报到事件ID
     * String aac003;// 姓名
     * String aac147;// 证件号码
     * String aaa027;// 发放机构代码
     * Long aae001;// 认证年度
     * String bae099;// 认证方式
     * String aaa094;// 待遇领取资格认证结果
     * String aaa080;// 异地认证标志
     * String aaa089;// 处理标志
     * Long aaz002;// 业务日志ID
     * Long aae410;//
     * Long aae411;
     */
    @Test
    public void test() {
        F14020216QueryInputParams input = new F14020216QueryInputParams();
        input.setCurrentPage(1);
        input.setRows(10);
        F14020216QueryOutputParams output = service.getAcm4InfoList(input);
        out(output);
    }

    /**
     * 领取资格认证报到保存（本市领取异地居住）
     * <p>
     * F14020216SaveInputParams;基类,该基类包含以下几个字段:
     * List<Acm4SaveDTO> baseacm4List=new    ArrayList<Acm4SaveDTO>();
     * <p>
     * Acm4SaveDTO字段属性如下:
     * Long baa701;// 养老待遇领取资格认证报到事件ID
     * String aac003;// 姓名
     * String aac147;// 证件号码
     * String aaa027;// 发放机构代码
     * Long aae001;// 认证年度
     * String bae099;// 认证方式
     * String aaa094;// 待遇领取资格认证结果
     * String aaa080;// 异地认证标志
     * String aaa089;// 处理标志
     * Long aaz002;// 业务日志ID
     * Long aae410;//
     * Long aae411;
     * <p>
     * F14020216SaveOutputParams;基类,该基类包含以下几个字段:
     * boolean bizSuccess;
     * String errorCode;
     * String message;
     */
    @Test
    public void test1() {
        F14020216SaveInputParams inputsave = new F14020216SaveInputParams();
        List<Acm4SaveDTO> baseacm4List = new ArrayList<Acm4SaveDTO>();
        Acm4SaveDTO baseacm4 = new Acm4SaveDTO();
        baseacm4.setAaa027("440000");
        baseacm4.setAaa080("1");
        baseacm4.setAaa089("1");
        baseacm4.setAaa094("1");
        baseacm4.setAaa121("1");
        baseacm4.setAac003("2");
        baseacm4.setAac147("852438195311039222");
        baseacm4.setAae001(Long.valueOf("1"));
        baseacm4.setAae011("1");
        baseacm4.setAaz002(Long.valueOf("1"));
        baseacm4.setBaa701(Long.valueOf("1"));
        baseacm4.setBae099("1");
        baseacm4.setBae127("1");
        baseacm4.setBae128("1");
        baseacm4List.add(baseacm4);
        inputsave.setBaseacm4List(baseacm4List);
        F14020216SaveOutputParams outputsave = service.saveAcm4InfoList(inputsave);
        out(outputsave);
    }

    /**
     * 领取资格认证报到查询（本市居住异地领取）
     *
     * F14020216jyQueryInputParams;基类,该基类包含以下几个字段:
     *
     * String aac147; //身份证
     *
     * F14020216jyQueryOutputParams;基类,该基类包含以下几个字段:
     *
     * boolean bizSuccess;
     * String errorCode;
     * String message;
     * String aac003; //姓名
     * String aac147; //身份证
     * String aaa027; //发放机构代码
     *
     */
    @Test
    public void test2(){
        F14020216jyQueryInputParams inputjy=new F14020216jyQueryInputParams();
        inputjy.setAac147("852438195311039222");
        F14020216jyQueryOutputParams outputjy=service.getjyInfo(inputjy);
        out(outputjy);
    }

    /**
     * 领取资格认证报到保存（本市居住异地领取）
     *
     * F14020216jySaveInputParams;基类,该基类包含以下几个字段:
     * String aaa094;// 认证结果
     * Long aae001;// 认证年度
     * String aae013;// 备注
     * String aac003;// 姓名
     * String aac147;// 证件号码
     * String aaa027;// 发放机构代码
     *
     * F14020216jySaveOutputParams基类,该基类包含以下几个字段:
     *
     * boolean bizSuccess;
     * String errorCode;
     * String message;
     */
    @Test
    public void test3(){
        F14020216jySaveInputParams savejy=new F14020216jySaveInputParams();
        savejy.setAaa027("");
        savejy.setAaa094("1");
        savejy.setAac003("2");
        savejy.setAac147("852438195311039222");
        savejy.setAae001(Long.valueOf("201601"));
        savejy.setAae013("bz");
        F14020216jySaveOutputParams outputsavejy=service.savejyInfo(savejy);
        out(outputsavejy);
    }
}
