package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.google.common.collect.Lists;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020104.params.*;
import com.wondersgroup.interfaceServiceVS.retirementVS.r1.f14020104.vs.F14020104Service;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * 直接纳入人员补登记
 * Created by cxd on 2016/10/25 0025.
 */
public class JustAddTest extends DubboTest implements Serializable {
    private static final long serialVersionUID = -1747202511665136753L;

    @Resource
    F14020104Service justAdd;

    /**
     * 保存申请直接纳入人员信息
     * <p>
     * SaveAndRegInputParams类
     * Long    aac001;//人员ID（非空）
     * String  aac004; //性别
     * String  aac003;//AAC003姓名
     * String  aac058;//证件类型
     * String  aac147;//证件号码
     * Long    aac006;//出生日期，档案出生日期
     * String 	aae140;//险种类型
     * Long 	aac007; //参加工作日期,档案参加工作时间
     * Long 	aab001;//单位编号（非空）
     * String 	aab024;//单位名称
     * String 	aab004;//单位名称
     * String 	aic161;//退休类别（非空）
     * Long 	aic162;//退休年月（非空）
     * Long 	aae210;//待遇执行起始年月
     * String 	aac063;//待遇享受类别（非空）
     * String 	aac064;//军转干部级别
     * String 	aac020;//行政职务
     * String 	aac085;//原工商业者标志
     * String 	aac081;//建国前老工人标志
     * String 	aac014;//专业技术职务
     * String 	aac015;//职业资格等级
     * String 	retirementAge;//退休年龄
     * String 	aae013_infoInput;//申请备注
     * List<BenefitItemDTO> benefitItemDTOs;
     * PaywayDTO  paywayDTO ;
     * String 	aaa121; //业务类型编码
     * String 	outgoing;//业务流向
     * <p>
     * PaywayDTO 实体属性：
     * <p>
     * String 	aaa079 ; //拨付方式  （非空）
     * String 	aae145 ; //发放渠道  （非空）
     * String 	aae147 ; //本人定居生活地 （非空）
     * String 	bae118 ; //银行代码  （非空）
     * String 	aae009 ; //户名  （非空）
     * String 	aae010 ; //银行帐号   （非空）
     * String 	bab007 ; //银行名称
     * <p>
     * BenefitItemDTO 实体属性：
     * String 	aaa036 ;  // 待遇项目代码（非空）
     * Long 	aae041 ;  // 开始年月
     * Long 	aae042 ;  // 结束年月
     * Double  aae129 ;  // 核发金额
     * String 	aae013 ;  // 备注
     * String 	aae140 ;  // 险种类型
     */
    @Test
    public void test() {
        SaveAndRegInputParams params = new SaveAndRegInputParams();
        params.setAac001(1000000045L);
        params.setAac004("1");
        params.setAac003("测试退休人员45");
        params.setAac058("1");
        params.setAac147("832851194907094112");
        params.setAac006(19490709L);
        params.setAae140("110");
        params.setAac007(20160918L);
        params.setAab001(100000401L);
        params.setAic161("8");
        params.setAic162(20161025L);
        params.setAae210(201611L);
        params.setAac063("22");
        params.setRetirementAge("67");
        BenefitItemDTO benefitItemDTO = new BenefitItemDTO();
        benefitItemDTO.setAaa036("08");
        benefitItemDTO.setAae042(299912L);
        benefitItemDTO.setAae041(201610L);
        benefitItemDTO.setAae129(0.0);
        params.setBenefitItemDTOs(Lists.newArrayList(benefitItemDTO));
        PaywayDTO paywayDTO = new PaywayDTO();
        paywayDTO.setAaa079("1");
        paywayDTO.setAae145("11");
        paywayDTO.setAae147("1");
        paywayDTO.setBae118("305");
        paywayDTO.setAae009("测试户名1");
        paywayDTO.setAae010("62284800000000000");
        paywayDTO.setBab007("测试银行名称1");
        params.setPaywayDTO(paywayDTO);
        params.setAaa121("F140233");
        params.setOutgoing("提交申请");

        params.setAab024("");
        params.setAab004("");
        params.setAac064("");
        params.setAac020("");
        params.setAac014("");
        params.setAac014("");
        params.setAac014("");
        params.setAac014("");
        params.setAae013_infoInput("");

        SaveAndRegOutputParams out = justAdd.savePersonRegInfo(params);

        out(out);
    }

    /**
     * 入参：UncheckedDetailInputParams类
     *
     * Long aaz170; //AC71核定事件主键
     *
     * 出参：UncheckedDetailOutputParams类
     *
     * Long aac001;//人员ID
     * String aac004; //性别
     * String aac003;//AAC003姓名
     * String aac058;//证件类型
     * String aac147;//证件号码
     * Long aac006;//出生日期，档案出生日期
     * String aae140;//险种类型
     * Long aac007; //参加工作日期,档案参加工作时间
     * Long aab001;//单位编号
     * String aab024;//单位名称aab024(ac01表),aab004(ic10表)
     * String aab004;//单位名称
     * String aic161;//退休类别
     * Long aic162;//退休年月
     * Long aae210;//待遇执行起始年月
     * String aac063;//待遇享受类别#
     * String aac064;//军转干部级别
     * String aac020;//行政职务
     * String aac085;//原工商业者标志
     * String aac081;//建国前老工人标志
     * String aac014;//专业技术职务
     * String aac015;//职业资格等级
     * String retirementAge;//退休年龄
     * String aae013_infoInput;//申请备注
     * List<BenefitItemDTO> benefitItemDTOs;//项目明细列表
     * PaywayDTO paywayDTO ;//待遇发放方式
     * String aaa121; //业务类型编码
     */
    @Test
    public void test2(){
        UncheckedDetailInputParams params = new UncheckedDetailInputParams();
        params.setAaz170(1000000000001304L);
        UncheckedDetailOutputParams out = justAdd.getUncheckedDetail(params);
        out(out);
        GetBenefitItemsInputParams params1 = new GetBenefitItemsInputParams();
        params1.setAaz170(1000000000001304L);
        GetBenefitItemsOutputParams out1 = justAdd.getBenefitItems(params1);
        out(out1);
    }

}
