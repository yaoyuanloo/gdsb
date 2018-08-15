<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ attribute name="replace" type="java.lang.String" required="true" description="需要替换的textarea编号"%>
<%@ attribute name="uploadPath" type="java.lang.String" required="false" description="文件上传路径，路径后自动添加年份。若不指定，则编辑器不可上传文件"%>
<%@ attribute name="height" type="java.lang.String" required="false" description="编辑器高度"%>
<%--
<%@ attribute name="valList" type="java.util.List" required="true" description="标签集合"%>
<c:forEach items="${valList}" var="tpl">
    &lt;%&ndash;<c:if test="${category.inList eq '1'}"> &ndash;%&gt;
    <c:choose>
        <c:when test="${tpl}">
            <ul id="myTab" class="nav nav-tabs">
                <li><a href="#YWCXBQ09" data-toggle="tab">查询医疗信息</a></li>
                <li><a href="#YWCXBQ02" data-toggle="tab">单位基本信息</a></li>
                <li><a href="#YWCXBQ08" data-toggle="tab">个人基本信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">个人缴费基本信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">历史缴费信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">历史住院信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">转诊信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">长住异地信息</a></li>
                <li><a href="#YWCXBQ06" data-toggle="tab">门诊病种信息</a></li>
            </ul>
        </c:when>
      </c:choose></li>
    &lt;%&ndash;</c:if> &ndash;%&gt;
</c:forEach>--%>
<ul id="myTab" class="nav nav-tabs">
    <li><a href="#YWCXBQ09" data-toggle="tab">查询医疗信息</a></li>
    <li><a href="#YWCXBQ02" data-toggle="tab">单位基本信息</a></li>
    <li><a href="#YWCXBQ08" data-toggle="tab">个人基本信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">个人缴费基本信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">历史缴费信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">历史住院信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">转诊信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">长住异地信息</a></li>
    <li><a href="#YWCXBQ06" data-toggle="tab">门诊病种信息</a></li>
</ul>
<div id="myTabContent" class="tab-content">
    <div class="tab-pane" id="YWCXBQ09">
        <!-- 生育待遇信息 -->
        生育待遇信息
    </div>
    <div class="tab-pane" id="YWCXBQ05">
        <!-- 生育待遇信息 -->
        生育待遇信息
    </div>
    <!-- 养老待遇信息 -->
    <div class="tab-pane" id="YWCXBQ07">
        <!-- 养老待遇信息 -->
        养老待遇信息
    </div>
    <!-- 个人账户基本信息 -->
    <div class="tab-pane" id="YWCXBQ08">
        <!-- 个人账户基本信息 -->
        <div>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th colspan="6">个人账户基本信息</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>身份证号码</th>
                    <td colspan="2">7633000</td>
                    <th>人员身份</th>
                    <td colspan="2">在职</td>
                </tr>
                <tr>
                    <th>姓名</th>
                    <td>赵月红</td>
                    <th>出生日期</th>
                    <td>19800503</td>
                    <th>社会保险状态</th>
                    <td>参保缴费</td>
                </tr>
                <tr>
                    <th>IC卡号</th>
                    <td>7633000</td>
                    <th>退休待遇类型</th>
                    <td colspan="3"></td>
                </tr>
                <tr>
                    <th>性别</th>
                    <td>女</td>
                    <th>参加工作年月</th>
                    <td >201012</td>
                    <th>用工形式</th>
                    <td >城镇合同制职工</td>
                </tr>
                <tr>
                    <th>民族</th>
                    <td>汉</td>
                    <th>视同缴费月数</th>
                    <td >0</td>
                    <th>个人身份</th>
                    <td >其他</td>
                </tr>
                <tr>
                    <th>特殊工种标识</th>
                    <td>普通</td>
                    <th>特殊工种加发月数</th>
                    <td >0</td>
                    <th>社保身份</th>
                    <td >其他</td>
                </tr>
                <tr>
                    <th>技术职称</th>
                    <td></td>
                    <th>特殊工种缴费总月数</th>
                    <td >0</td>
                    <th>视同账户建账状态</th>
                    <td ></td>
                </tr>
                <tr>
                    <th>电话号码</th>
                    <td>7633000</td>
                    <th>联系人</th>
                    <td>张三</td>
                    <th>联系电话</th>
                    <td>7633000</td>
                </tr>
                <tr>
                    <th>邮政编码</th>
                    <td>519040</td>
                    <th>电子邮件地址</th>
                    <td></td>
                    <th>户口性质</th>
                    <td>珠户非农业户口</td>
                </tr>
                <tr>
                    <th>资料申档标识</th>
                    <td>未申档</td>
                    <th>通讯地址</th>
                    <td colspan="3">珠海市横琴红旗村天和街30号西楼281</td>
                </tr>
                <tr>
                    <th>组织机构代码</th>
                    <td>519040</td>
                    <th>单位名称</th>
                    <td colspan="3">珠海泰坦电路电子集团有限公司</td>

                </tr>
                <tr>
                    <th>实际缴费月数</th>
                    <td>104</td>
                    <th>1998年7月前实际缴费月数</th>
                    <td></td>
                    <th>人员去向</th>
                    <td>非中断或终止</td>
                </tr>
                <tr>
                    <th>实际缴费起止年月</th>
                    <td>200403-201607</td>
                    <th>建账方式</th>
                    <td></td>
                    <th>调入年月</th>
                    <td></td>
                </tr>
                <tr>
                    <th>最近转入地</th>
                    <td></td>
                    <th>建账总额</th>
                    <td>0.0</td>
                    <th>特殊工种时段</th>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <!-- 工伤待遇查询 -->
    <div class="tab-pane" id="YWCXBQ06">
        <!-- 工伤待遇查询 -->
    </div>
    <!-- 历史缴费信息 -->
    <div class="tab-pane" id="YWCXBQ04">
        <!-- 历史缴费信息 -->
        <div>
            <table id="contentTable1" class="table table-striped table-bordered table-condensed"
                   style="border-width: 2px;">
                <thead>
                <tr>
                    <th>险种</th>
                    <th>开始年月</th>
                    <th>结束年月</th>
                    <th>缴费月数</th>
                    <th>工资</th>
                    <th>单位缴</th>
                    <th>个人缴</th>
                    <th>单位划入</th>
                    <th>缴费类型</th>
                    <th>法人代码</th>
                    <th>单位名称</th>
                    <th>业务事件</th>
                </tr>
            </table>
        </div>
    </div>


    <div class="tab-pane" id="YWCXBQ03">
        <div>
            <table id="contentTablefas" class="table table-striped table-bordered table-condensed"
                   style="border-width: 2px;" >
                <thead >
                <tr>
                    <td colspan="15">
                        记录数                页次1/21
                    </td>
                </tr>

                <tr>
                    <td colspan="15">
                        险种<select>
                        <option>全部</option>
                    </select>


                        缴费类型<select>
                        <option>全部</option>
                    </select>


                        到账标志<select>
                        <option>全部</option>
                    </select>

                        缴费年月
                        <input>
                        至
                        <input>


                        单位名称
                        <input>

                        <button class="btn" style="width: 100px;"><i class="icon-credit-card"></i>&nbsp;提交</button>
                    </td>
                </tr>

                <tr>
                    <th>序号</th>
                    <th>险种</th>
                    <th>缴费月份</th>
                    <th>台账月份</th>
                    <th>缴费工资</th>
                    <th>个人缴费</th>
                    <th>单位入户拨额</th>
                    <th>单位入户专额</th>
                    <th>缴费类型</th>
                    <th>到账标志</th>
                    <th>单位名称</th>
                    <th>总金额</th>
                    <th>到账日期</th>
                    <th>操作时间</th>
                    <th>业务事件</th>

                </tr>
                <tr>
                    <td>1</td>
                    <td>基本养老保险</td>
                    <td>201607</td>
                    <td>201607</td>
                    <td>3000.0</td>
                    <td>240.0</td>
                    <td>391.0</td>
                    <td>0.0</td>
                    <td>正常缴</td>
                    <td>已实现</td>
                    <td>珠海泰坦店里电子集团有限公司</td>
                    <td>630.0</td>
                    <td>20160721</td>
                    <td>20160721164542</td>
                    <td></td>
                </tr>

                <tr>
                    <td>1</td>
                    <td>基本养老保险</td>
                    <td>201607</td>
                    <td>201607</td>
                    <td>3000.0</td>
                    <td>240.0</td>
                    <td>391.0</td>
                    <td>0.0</td>
                    <td>正常缴</td>
                    <td>已实现</td>
                    <td>珠海泰坦店里电子集团有限公司</td>
                    <td>630.0</td>
                    <td>20160721</td>
                    <td>20160721164542</td>
                    <td></td>
                </tr>

                <tr>
                    <td>1</td>
                    <td>基本养老保险</td>
                    <td>201607</td>
                    <td>201607</td>
                    <td>3000.0</td>
                    <td>240.0</td>
                    <td>391.0</td>
                    <td>0.0</td>
                    <td>正常缴</td>
                    <td>已实现</td>
                    <td>珠海泰坦店里电子集团有限公司</td>
                    <td>630.0</td>
                    <td>20160721</td>
                    <td>20160721164542</td>
                    <td></td>
                </tr>

                <tr>
                    <td>1</td>
                    <td>基本养老保险</td>
                    <td>201607</td>
                    <td>201607</td>
                    <td>3000.0</td>
                    <td>240.0</td>
                    <td>391.0</td>
                    <td>0.0</td>
                    <td>正常缴</td>
                    <td>已实现</td>
                    <td>珠海泰坦店里电子集团有限公司</td>
                    <td>630.0</td>
                    <td>20160721</td>
                    <td>20160721164542</td>
                    <td></td>
                </tr>

                <tr>
                    <td>1</td>
                    <td>基本养老保险</td>
                    <td>201607</td>
                    <td>201607</td>
                    <td>3000.0</td>
                    <td>240.0</td>
                    <td>391.0</td>
                    <td>0.0</td>
                    <td>正常缴</td>
                    <td>已实现</td>
                    <td>珠海泰坦店里电子集团有限公司</td>
                    <td>630.0</td>
                    <td>20160721</td>
                    <td>20160721164542</td>
                    <td></td>
                </tr>

                <tr>
                    <td>1</td>
                    <td>基本养老保险</td>
                    <td>201607</td>
                    <td>201607</td>
                    <td>3000.0</td>
                    <td>240.0</td>
                    <td>391.0</td>
                    <td>0.0</td>
                    <td>正常缴</td>
                    <td>已实现</td>
                    <td>珠海泰坦店里电子集团有限公司</td>
                    <td>630.0</td>
                    <td>20160721</td>
                    <td>20160721164542</td>
                    <td></td>
                </tr>

                <tr>
                    <td>1</td>
                    <td>基本养老保险</td>
                    <td>201607</td>
                    <td>201607</td>
                    <td>3000.0</td>
                    <td>240.0</td>
                    <td>391.0</td>
                    <td>0.0</td>
                    <td>正常缴</td>
                    <td>已实现</td>
                    <td>珠海泰坦店里电子集团有限公司</td>
                    <td>630.0</td>
                    <td>20160721</td>
                    <td>20160721164542</td>
                    <td></td>
                </tr>


                <tr>
                    <td>1</td>
                    <td>基本养老保险</td>
                    <td>201607</td>
                    <td>201607</td>
                    <td>3000.0</td>
                    <td>240.0</td>
                    <td>391.0</td>
                    <td>0.0</td>
                    <td>正常缴</td>
                    <td>已实现</td>
                    <td>珠海泰坦店里电子集团有限公司</td>
                    <td>630.0</td>
                    <td>20160721</td>
                    <td>20160721164542</td>
                    <td></td>
                </tr>
                </thead>
            </table>
        </div>
    </div>


    <div class="tab-pane" id="YWCXBQ02">
        <!-- 单位 -->
        <div>
            <table id="contentTable11" class="table table-striped table-bordered table-condensed"
                   style="border-width: 2px;" >
                <thead >
                <tr>
                    <td colspan="7">单位基本信息</td>
                </tr>
                <tr>
                    <th>组织机构代码</th>
                    <td>91440400778183973</td>
                    <th>单位电话</th>
                    <td>未提供电话</td>
                    <th>传真号码</th>
                    <td>3325889</td>
                </tr>
                <tr>
                    <th>单位名次</th>
                    <td colspan="3">珠海泰坦新能源系统有限公司</td>
                    <th>单位状态</th>
                    <td>参保缴费</td>
                </tr>

                <tr>
                    <th>单位地址</th>
                    <td colspan="3">珠海市吉大石花西路60号三楼</td>
                    <th>单位状态</th>
                    <td>参保缴费</td>
                </tr>

                <tr>
                    <th>邮政编号</th>
                    <td>&nbsp;</td>
                    <th>电子邮件地址</th>
                    <td>&nbsp;</td>
                    <th>经济类型 </th>
                    <td>私营有限责任公司</td>
                </tr>

                <tr>
                    <th>辖区 </th>
                    <td>香洲</td>
                    <th>银行名称</th>
                    <td>工商行分行营业部</td>
                    <th>单位类型</th>
                    <td>企业</td>
                </tr>

                <tr>
                    <th>缴费开户银行代码 </th>
                    <td>0030207</td>
                    <th>银行帐号</th>
                    <td>2002020719100278549</td>
                    <th>缴费开户户名</th>
                    <td>珠海科利尔能源科技有限公司</td>
                </tr>

                <tr>
                    <th>隶属关系 </th>
                    <td>县</td>
                    <th>行政区域</th>
                    <td>440402000</td>
                    <th>主管部门或总机构</td>
                    <td>市直属市直区</td>
                </tr>


                <tr>
                    <th>成立日期</th>
                    <td>20090404</td>
                    <th>联系人姓名</th>
                    <td>李小滨 </td>
                    <th>联系电话</th>
                    <td>&nbsp; </td>
                </tr>


                <tr>
                    <th>通讯地址</th>
                    <td colspan="3">珠海市吉大石花西路60号三楼</td>
                    <th>单位密码</th>
                    <td>*******</td>
                </tr>

                <tr>
                    <th>工商登记执照种类</th>
                    <td>法人营业执照</td>
                    <th>工商登记执照号码</th>
                    <td>440400000019059</td>
                    <th>工商登记发证日期</th>
                    <td>20050708</td>
                </tr>

                <tr>
                    <th>工商登记有效期限</th>
                    <td>20150708</td>
                    <th>批准文号</th>
                    <td>&nbsp;</td>
                    <th>纳税人编码</th>
                    <td>4404020000157</td>
                </tr>
                <tr>
                    <th>法人代表人身份证号码</th>
                    <td>44040119570504041X</td>
                    <th>法人代表人姓名</th>
                    <td>李欣青</td>
                    <th>税务机构名称</th>
                    <td>&nbsp;</td>
                </tr>

                <tr>
                    <th>批准成立单位</th>
                    <td>&nbsp;</td>
                    <th>行业代码</th>
                    <td>4190</td>
                    <th>行业名称</th>
                    <td>其他电子设备制造业</td>
                </tr>
                <tr>
                    <th>工伤级别</th>
                    <td>二级</td>
                    <th>工伤浮动比例</th>
                    <td>1</td>
                    <th>工商费率</th>
                    <td>0.8</td>
                </tr>


                <tr>
                    <th>档案编号</th>
                    <td>G111012008120024</td>
                    <th>银行统发标识</th>
                    <td>非统发银行</td>
                    <th>单位征收类型</th>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <th colspan="4">备注</th>
                    <th>单位社保号</th>
                    <td>0402200008643</td>
                </tr>
                </thead>
            </table>

        </div>


    </div>

    <!-- 个人基本信息 -->
    <div class="tab-pane" id="YWCXBQ01">
        <div>
            <table id="contentTableaas" class="table table-striped table-bordered table-condensed"
                   style="border-width: 2px;" >
                <thead >
                <tr>
                    <td colspan="6">个人基本信息</td>
                </tr>
                <tr>
                    <th>公民身份证</th>
                    <td>547987461654647987987</td>
                    <th>姓名</th>
                    <td>赵月红</td>
                    <th>性别</th>
                    <td>女</td>
                </tr>
                <tr>
                    <th>出生日期</th>
                    <td>19080616</td>
                    <th>参加工作年月</th>
                    <td>201212</td>
                    <th>参保工资</th>
                    <td>3250.00</td>
                </tr>

                <tr>
                    <th>户口类型</th>
                    <td>珠户非农业户口</td>
                    <th>人员类别</th>
                    <td>在职</td>
                    <th>工种类型</th>
                    <td>普通</td>
                </tr>

                <tr>
                    <td>&nbsp; </td>
                    <td>&nbsp;</td>
                    <th>医保状态</th>
                    <td>在职</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>

                <tr>
                    <th>用工形式 </th>
                    <td>城镇合同制职工</td>
                    <th>个人身份</th>
                    <td>其他</td>
                    <th>社保身份</th>
                    <td>正常</td>
                </tr>

                <tr>
                    <th>医疗类别 </th>
                    <td>基本医疗</td>
                    <th>电话号码</th>
                    <td>7633000</td>
                    <th>联系人</th>
                    <td>&nbsp;</td>
                </tr>

                <tr>
                    <th>联系人电话 </th>
                    <td>&nbsp;</td>
                    <th>邮政编号</th>
                    <td>519040</td>
                    <th>电子邮箱</th>
                    <td>&nbsp;</td>
                </tr>


                <tr>
                    <th>民族</th>
                    <td>汉族</td>
                    <th>通讯地址</th>
                    <td colspan="3">珠海市横琴红旗天河街30号西楼281室</td>
                </tr>


                <tr>
                    <th>IC卡</th>
                    <td>092007778</td>
                    <th>人员去向</th>
                    <td>非中断或终止</td>
                    <th>纳税人编码</th>
                    <td>465464654</td>
                </tr>

                <tr>
                    <th>档案编号</th>
                    <td>J1674749874</td>
                    <th>银行账户</th>
                    <td>4646546546546546545644</td>
                    <th>开户银行</th>
                    <td>&nbsp;</td>
                </tr>

                <tr>
                    <th>组织机构代码</th>
                    <td>7965465</td>
                    <th>单位名称</th>
                    <td colspan="3">珠海泰坦电力电子有限公司</td>
                </tr>

                <tr>
                    <th>是否邮寄收据</th>
                    <td>否</td>
                    <th>退休待遇类型</th>
                    <td>&nbsp;</td>
                    <th>个账审档标识</th>
                    <td>未审档</td>
                </tr>
                <tr>
                    <th>地税增员时间</th>
                    <td>20160522</td>
                    <th>地税减员时间</th>
                    <td>&nbsp;</td>
                    <th>社会保险状态</th>
                    <td>参保缴费</td>
                </tr>

                <tr>
                    <th>个人编号</th>
                    <td>1654213</td>
                    <th>账户标记</th>
                    <td>一般账户</td>
                    <th>有效起始时间</th>
                    <td>20160523</td>
                </tr>
                <tr>
                    <th>有效终止时间</th>
                    <td colspan="5"></td>
                </tr>
                </thead>
            </table>
            <table id="contentTables" class="table table-striped table-bordered table-condensed"
                   style="border-width: 2px;" >
                <thead >
                <tr>
                    <th>险种</th>
                    <th>状态</th>
                    <th>参保信息</th>
                    <th>停保月份</th>
                    <th>征收月份</th>
                    <th>首次参保月份</th>
                </tr>
                <tr>
                    <th>养老</th>
                    <td style="color: red;">参保</td>
                    <td>201610</td>
                    <td>0</td>
                    <td>200907</td>
                    <td>199210</td>
                </tr>
                <tr>
                    <th>工伤</th>
                    <td style="color: red;">参保</td>
                    <td>201610</td>
                    <td>0</td>
                    <td>200907</td>
                    <td>199210</td>
                </tr>

                <tr>
                    <th>失业</th>
                    <td style="color: red;">参保</td>
                    <td>201610</td>
                    <td>0</td>
                    <td>200907</td>
                    <td>199210</td>
                </tr>

                <tr>
                    <th>医疗</th>
                    <td style="color: red;">参保</td>
                    <td>201610</td>
                    <td>0</td>
                    <td>200907</td>
                    <td>199210</td>
                </tr>
                <tr>
                    <th>生育</th>
                    <td style="color: red;">参保</td>
                    <td>201610</td>
                    <td>0</td>
                    <td>200907</td>
                    <td>199210</td>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<!---标签TAB--结束-->