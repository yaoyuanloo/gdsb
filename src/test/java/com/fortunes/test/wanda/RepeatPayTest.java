package com.fortunes.test.wanda;

import com.fortunes.test.DubboTest;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020307.F14020307Service;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020307.params.F14020307QueryInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020307.params.F14020307QueryOutputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020307.params.F14020307SaveInputParams;
import com.wondersgroup.interfaceServiceVS.retirementVS.r3.f14020307.params.F14020307SaveOutputParams;
import com.wondersgroup.wssip.bc.generalbenefitmgmt.socialdelivermgr.model.dto.BankAccountAduitDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 重复缴费
 * Created by cxd on 2016/10/25 0025.
 */
public class RepeatPayTest extends DubboTest {

    @Autowired
    F14020307Service service;

    /**
     * 查询
     * Long aac001
     *
     * String message;
     * Long aae201; // 实际缴费月数
     * String aae410;// 业务年月
     * String Aae140;// 险种类型
     * String aaa027;// 统筹区
     * Long aab001;// 单位id
     * List<Ac43ViewDTO> listac43;
     *
     * Ac43ViewDTO实体属性如下:
     * Long aac001; //人员ID
     * Double aaa041; //个人缴费比例或定额标准
     * Long aae002; //费款所属期
     * Double aae180; //人员缴费基数
     * Double aae023; //个人应缴划入个人账金额
     * String aae140; //险种类型
     * Double aae083; //个人实缴划入个人账户金额
     * Long aae079; //足额到账年月
     * Long   aab191; //到帐日期
     * Long  aae003; //对应费款所属期
     * String  aaa027; //统筹区编码
     * Long aab001; //单位ID
     * Long aaz061; //  城镇职工单位征缴明细ID
     * Double aac040; //工资
     * Long bae189; //累计缴费月数增加额、
     * String bae152; // 缴费标志
     * String aac066; // 参保身份
     * String aaa115;//
     * Long months;  //缴费月数
     * Long aae041; //缴费开始时间
     * Long aae042; //缴费结束时间
     * Double aae020;// 单位应缴金额
     * Double aae022;// 个人应缴金额
     */
    @Test
    public void test(){
        F14020307QueryInputParams params = new F14020307QueryInputParams();
        params.setAac001(1000000577L);
        F14020307QueryOutputParams out = service.queryF14020307Info(params);
        out(out);
    }

    /**
     * private Long aac001;// 个人ID
     * Long aab001;// 单位ID
     * Long aaz257;// 定期 待遇领取人员ID
     * String aae013;// 备注
     * String outgoing;//流程状态
     * BankAccountAduitDTO bankAccountAduitvo;//发放信息
     * List<Ac43ViewDTO> listac43;//缴费信息
     *
     * BankAccountAduitDTO 字段属性如下：
     *
     * Long   aaz097 ;         //待遇发放方式登记事件ID
     * Long   aac001 ;         //人员ID
     * Long   aaz257 ;         //享受定期待遇人员ID
     * Long   aaz003 ;         //当事人银行账号ID
     * String aae145 ;         //发放渠道
     * String aaa079 ;         //拨付方式
     * String aae006 ;         //地址
     * String aae007 ;         //邮政编码
     * Long   aaz009 ;         //代发机构ID
     * String bae118 ;         //银行代码
     * String bae119 ;         //银行网点代码
     * String bab007 ;         //银行名称
     * String aae009 ;         //户名
     * String aae010 ;         //银行帐号
     * String aaa126 ;         //开户状态标志
     * String aaa027 ;         //统筹区编码
     * String bae183 ;         //异地发放标志
     * String aab301 ;         //所属行政区代码
     * String aae013 ;         //备注
     * String aae005 ;         //联系电话
     * String aae147 ;         //本人定居生活地
     * String bae127 ;         //备用标识
     * String aae413 ;         //审批人姓名
     * String bae128 ;         //业务描述
     * String aaa121 ;         //业务类型
     * Long   aaz002 ;         //业务日志ID
     *
     * Ac43ViewDTO字段属性如下:
     *
     * Long aac001; //人员ID
     * Double aaa041; //个人缴费比例或定额标准
     * Long aae002; //费款所属期
     * Double aae180; //人员缴费基数
     * Double aae023; //个人应缴划入个人账金额
     * String aae140; //险种类型
     * Double aae083; //个人实缴划入个人账户金额
     * Long aae079; //足额到账年月
     * Long   aab191; //到帐日期
     * Long  aae003; //对应费款所属期
     * String  aaa027; //统筹区编码
     * Long aab001; //单位ID
     * Long aaz061; //  城镇职工单位征缴明细ID
     * Double aac040; //工资
     * Long bae189; //累计缴费月数增加额、
     * String bae152; // 缴费标志
     * String aac066; // 参保身份
     * String aaa115;//
     * Long months;  //缴费月数
     * Long aae041; //缴费开始时间
     * Long aae042; //缴费结束时间
     * Double aae020;// 单位应缴金额
     * Double aae022;// 个人应缴金额
     */
    @Test
    public void test1(){
        F14020307QueryInputParams params1 = new F14020307QueryInputParams();
        params1.setAac001(Long.valueOf("1000000577"));
        F14020307QueryOutputParams out1 = service.queryF14020307Info(params1);
        F14020307SaveInputParams params = new F14020307SaveInputParams();
        params.setAac001(Long.valueOf("1000000577"));
        params.setAab001(Long.valueOf("100000421"));
        params.setAaz257(100000L);
        params.setListac43(out1.getListac43());
        /**
         * private String aaa079 ;         //拨付方式
         private String aae145 ;         //发放渠道
         private String aae147 ;         //本人定居生活地
         private String bae118 ;         //银行代码
         private String bae119 ;         //银行网点代码
         private String bab007 ;         //银行名称
         private String aae009 ;         //户名
         private String aae010 ;         //银行帐号
         */
        BankAccountAduitDTO bank = new BankAccountAduitDTO();
        bank.setAac001(Long.valueOf("1000000577"));
        bank.setAaa079("1");
        bank.setAae145("11");
        bank.setAae147("1");
        bank.setBae118("001");
        bank.setBab007("测试银行");
        bank.setAae009("测试人员");
        bank.setAae010("62284800000000000");
        params.setBankAccountAduitvo(bank);
        F14020307SaveOutputParams out =service.saveF14020307Info(params);out(out);
    }

}
