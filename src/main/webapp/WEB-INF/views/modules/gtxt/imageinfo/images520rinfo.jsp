<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<HTML>
<HEAD>
    <meta name="decorator" content="yhdefault"/>
    <TITLE>New Page</TITLE>
    <style type="text/css">
        .span12, .row, .blank_wrapper {
            position: relative;
            width: 100%;
            height: 100%;
            background-color: white;
        }

        html, body {
            height: 100%;
            width: 100%;
            background-color: white;
        }
    </style>
</HEAD>
<BODY>
<input id="uploadURL" hidden="hidden" value=""/>
<input id="uploadParams" hidden="hidden" value=""/>
<input id="nowCamera" hidden="hidden" value="0"/>
<div class="row">
    <div class="span12">
        <div class="blank_wrapper">
            <OBJECT id="CaluNumCtrl" align="CENTER" WIDTH=0 HEIGHT=0
                    classid="CLSID:30102439-2F42-41F4-93D9-CC6E4DAD06CB"
                    style="width: 90% ;height:90%">
            </OBJECT>
            <div class="col-sm-offset-2">
                <input type="button" class="btn yellow" value="拍照" id="btnOK"/>
                <input type="button" class="btn yellow" value="上传" id="upload"/>
                <input type="button" class="btn yellow" value="切换摄像头" id="exCamera"/>
                <input type="button" class="btn yellow" value="关闭摄像头" id="closeIt"/>
                <input type="button" class="btn grey" value="获取文件信息" id="btnGet"/>
            </div>
        </div>
    </div>
</div>
<script language="javascript">

    $(document).ready(function () {
        getUploadAddress();//获取上传地址 并写入隐藏域

        getUploadParams();//获取上传参数 并写入隐藏域

        openCarmera();//默认打开下方摄像头

        selectList();//下拉栏

        $("#btnOK").click(function () {
            takePic();//拍照
        });

        $("#upload").click(function () {//上传
            var cameratype = ${cameratype};// ;//相机类型

            var urlData = JSON.parse($("#uploadURL").val());//上传url
            var paramsData = JSON.parse($("#uploadParams").val());//上传params

//            if (!urlData.invokeSuccess) {//获取失败
//                alert("1");
//                return
//            }
//            if (!paramsData) {//获取失败
//                alert("2");
//                //弹框重新获取
//                return
//            }

            var uploadUrl = urlData.invokeData.data;//上传url
            var aab301 = paramsData.aab301;
            var busitype = paramsData.busitype;
            var loginid = paramsData.loginid;
            var yab003 = paramsData.yab003;
            var sysid = paramsData.sysid;

            var arrParams = new Array();
            arrParams[0] = uploadUrl + "/ucm/ucmAction!postFile.do";//"http://192.168.200.3:7005/yhucm/ucm/ucmAction!postFile.do";//上传地址
            arrParams[1] = sysid;//"fd_gtxt";//业务系统ID(sysid)
            arrParams[2] = aab301;//"440100000000";//行政区划(aab301)
            arrParams[3] = yab003;//"4401";//分中心(yab003)
            arrParams[4] = loginid;//"developer";/ / 操作人登录账号(loginid)
            arrParams[5] = busitype;//"busitype_a";//业务类别(busitype)

//            alert("arrParams:" + JSON.stringify(arrParams));
            var picPath = new Array();
            picPath[0] = "D:\\123.jpg";
            var result = CaluNumCtrl.FD_SetUploadParam(arrParams, arrParams.length);
            result = CaluNumCtrl.FD_UploadPic_Multi(picPath, picPath.length);
            alert("上传结果：" + result);
        });

        $("#exCamera").click(function () {
            exchangeCamera();//切换摄像头
        });

        $("#btnGet").click(function () {
            var CaluNumCtrl = document.getElementById("CaluNumCtrl");
            //测试获取拍照图片的名称和类型
//            alert("FD_ReturnFileInfo start");
            var StringArray = CaluNumCtrl.FD_ReturnFileInfo();
//            alert("FD_ReturnFileInfo end");
            var StringList = StringArray.toArray();
            alert(StringList[0]);
        });

        $("#closeIt").click(function () {
            var CaluNumCtrl = document.getElementById("CaluNumCtrl");
            CaluNumCtrl.FD_CloseCamera();
        });
    });

    /**
     * openCarmera
     */
    function openCarmera() {
        var cameratype = ${cameratype};// $ {cameratype};//相机类型 0.良田s520r  1.世达龙
        var CaluNumCtrl = document.getElementById("CaluNumCtrl");
        open = CaluNumCtrl.FD_OpenCamera(cameratype, 0, 0);
    }
    /**
     * exchangeCamera
     */
    function exchangeCamera() {
        var cameratype = ${cameratype};//相机类型 0.良田s520r  1.世达龙
        var nowCamera = $("#nowCamera").val();
        var CaluNumCtrl = document.getElementById("CaluNumCtrl");
//        alert("0.良田s520r 1.世达龙 " + cameratype);
        var open;
        if (cameratype == 0) {//0.良田s520r
            var result = CaluNumCtrl.FD_CloseCamera();
            if (nowCamera == 0) {//当前为下方摄像头
                open = CaluNumCtrl.FD_OpenCamera(cameratype, 1, 0);//1.上方摄像头  切换摄像头
                $("#nowCamera").val("1");//已经切换为上方摄像头
            } else {//当前为上方摄像头
                open = CaluNumCtrl.FD_OpenCamera(cameratype, 0, 0);//0.下方摄像头  切换摄像头
                $("#nowCamera").val("0");//已经切换为上方摄像头
            }

        }
        if (cameratype == 1) {//1.世达龙
            open = CaluNumCtrl.FD_ChangeSDLCam();//open + "上方摄像头");
        }
    }
    /**
     * takePic
     */
    function takePic() {
        var CaluNumCtrl = document.getElementById("CaluNumCtrl");
        CaluNumCtrl.FD_TakePic("D:\\123.jpg");
    }
    /**
     * 选择材料类型
     */
    function selectList() {
//        "selectList");
        //测试下拉列表类型设置
        var arrlist = new Array();
        arrlist[0] = "类型1---个人缴费";
        arrlist[1] = "类型2---大病报销";
        arrlist[2] = "类型3---住院医疗";
        arrlist[3] = "类型4---个人缴费";
        arrlist[4] = "类型5---大病报销";
        arrlist[5] = "类型6---住院医疗";
        arrlist[6] = "类型7---个人缴费";
        arrlist[7] = "类型8---asdasd";
        arrlist[8] = "类型9---住院医疗";

        CaluNumCtrl.FD_SendTypeList(arrlist, arrlist.length);
    }

    /**
     * 获取上传地址 并写入隐藏域
     */
    function getUploadAddress() {
        var url = "${ctx}/gtxt/utils/util/pic";
        $.get(url, function (result) {
            $("#uploadURL").val(JSON.stringify(result));
        });
    }
    /**
     *  获取上传参数 并写入隐藏域
     */
    function getUploadParams() {
        var url = "${ctx}/gtxt/utils/util/getUploadParams";
        $.get(url, function (result) {
            $("#uploadParams").val(JSON.stringify(result));
        });
    }

    function doTest() {

        var CaluNumCtrl = document.getElementById("CaluNumCtrl");

        //测试拍照
//            console.log("FD_OpenCamera start");
        var sum = CaluNumCtrl.FD_OpenCamera(0, 1, 0);
//            console.log("FD_OpenCamera end");

//            console.log("FD_TakePic start");
//            console.log("1");
        sum = CaluNumCtrl.FD_TakePic("D:\\123.jpg");
//            sum = CaluNumCtrl.FD_TakePic("D:\\1234.jpg");
//            console.log("FD_TakePic end");


        //测试下拉列表类型设置
        var arrlist = new Array();
        arrlist[0] = "类型1---个人缴费";
        arrlist[1] = "类型2---大病报销";
        arrlist[2] = "类型3---住院医疗";
        arrlist[3] = "类型4---个人缴费";
        arrlist[4] = "类型5---大病报销";
        arrlist[5] = "类型6---住院医疗";
        arrlist[6] = "类型7---个人缴费";
        arrlist[7] = "类型8---asdasd";
//            arrlist[8] = "类型9---住院医疗";

        //alert("FD_SendTypeList start");
        CaluNumCtrl.FD_SendTypeList(arrlist, arrlist.length);
        //alert("FD_SendTypeList end");

        //测试http上传参数设置
        var arrParams = new Array();
        arrParams[0] = uploadUrl + "/ucm/ucmAction!postFile.do";//"http://192.168.200.3:7005/yhucm/ucm/ucmAction!postFile.do";//上传地址
        arrParams[1] = sysid;//"fd_gtxt";//业务系统ID(sysid)
        arrParams[2] = aab301;//"440100000000";//行政区划(aab301)
        arrParams[3] = yab003;//"4401";//分中心(yab003)
        arrParams[4] = loginid;//"developer";/ / 操作人登录账号(loginid)
        arrParams[5] = busitype;//"busitype_a";//业务类别(busitype)

//        alert("arrParams:" + JSON.stringify(arrParams));
        CaluNumCtrl.FD_SetUploadParam(arrParams, arrParams.length);
//        alert("FD_SetUploadParam end");


//        alert("FD_UploadPic start");
        var picPath = new Array();
        picPath[0] = "D:\\123.jpg";
//            picPath[1] = "D:\\1234.jpg";

        var flag = CaluNumCtrl.FD_UploadPic_Multi(picPath, picPath.length);
//        alert("上传结果：" + flag);
    }

    function doGet() {
        var CaluNumCtrl = document.getElementById("CaluNumCtrl");
        //测试获取拍照图片的名称和类型
//        alert("FD_ReturnFileInfo start");
        var StringArray = CaluNumCtrl.FD_ReturnFileInfo();
//        alert("FD_ReturnFileInfo end");
        var StringList = StringArray.toArray();
//        alert(StringList[0]);
    }
</script>
</BODY>
</HTML>
