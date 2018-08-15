<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(function () {
            var Sys = {};
            var ua = navigator.userAgent.toLowerCase();
            var s;
            (s = ua.match(/rv:([\d.]+)\) like gecko/)) ? Sys.ie = s[1] :
                    (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
                            (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
                                    (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
                                            (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
                                                    (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;

            /*if (Sys.ie) document.write('IE: ' + Sys.ie);
             if (Sys.firefox) document.write('Firefox: ' + Sys.firefox);
             if (Sys.chrome) document.write('Chrome: ' + Sys.chrome);
             if (Sys.opera) document.write('Opera: ' + Sys.opera);
             if (Sys.safari) document.write('Safari: ' + Sys.safari);*/
            if (Sys.ie) {
                var html = '<table class="table table-bordered">' +
                        '<tr>' +
                        '<td align="center">' +
                        '<ul class="nav nav-tabs nav-stacked">' +
                        '<li class=""><a id="lts520r" href="#">1. 良田高拍仪S520-R</a></li>' +
                        '<li class=""><a id="sdl"  href="#">2. 世达龙高拍仪</a></li>' +
                        '<li class=""><a id="sdsc">3. 手动上传</a></li>' +
//                        '<li class=""><a href="#">4. 富士通高速扫描仪</a></li>' +
                        '</ul>' +
                        '</td>' +
                        '</tr>' +
                        '</table>';
                $(document).ready(function () {
                    $.jBox(html, {
                        title: "请选择扫描设备",
                        width: 450,
                        height: 230,
                        opacity: 0.5,
                        border: 1,
                        iframeScrolling: "yes",
                        persistent: true,
                        buttons: {},
                        showClose: true,
                        closed: function () {
                            history.back(-1);
                        },
                        loaded: function (h) {
                            $("#lts520r", h).click(function () {
                                $.jBox.close(true);
                                location.href = "${ctx}/gt/gtSmjinfo/images520rinfo?ywlsh=${ywlsh}&type=" + 0;
                            });
                            $("#sdl", h).click(function () {
                                $.jBox.close(true);
                                location.href = "${ctx}/gt/gtSmjinfo/images520rinfo?ywlsh=${ywlsh}&type=" + 1;
                            });
                            $("#sdsc", h).click(function () {
                                $.jBox.close(true);
                                location.href = "${ctx}/gt/gtSmjinfo/list?ywlsh=${ywlsh}";
                            });
                        }
                    });
                });
            }
            if (Sys.firefox || Sys.chrome || Sys.opera || Sys.safari) {
                var mess = "检测到您使用的浏览器不是IE浏览器，请切换至IE浏览器！";
                $.jBox.info(mess, '提示', {
                    closed: function () {
                        if (typeof closed == 'function') {
                            closed();
                        }
                    },
                    persistent: true,
                    showClose: false,
                    submit: function (v) {
                        $.fn.jerichoTab.closeCurrentTab();
                    }
                });
                $('.jbox-body .jbox-icon').css('top', '55px');
            }
        });
    </script>
    <%--<!--[if !IE]><!-->
    <script type="text/javascript">
        var mess = "检测到您使用的浏览器不是IE浏览器，请切换至IE浏览器！";
        $.jBox.info(mess, '提示', {
            closed: function () {
                if (typeof closed == 'function') {
                    closed();
                }
            },
            persistent: true,
            showClose: false,
            submit: function(v){
                $.fn.jerichoTab.closeCurrentTab();
            }
        });
        $('.jbox-body .jbox-icon').css('top', '55px');
    </script>
    <!--<![endif]-->
    <!--[if IE]>
    <script type="text/javascript">
        $(document).ready(function () {
            var html = '<table class="table table-bordered">' +
                    '<tr>' +
                    '<td align="center">' +
                    '<ul class="nav nav-tabs nav-stacked">' +
                    '<li class=""><a id="fortunes"  href="#">1. 方迪自主高拍仪</a></li>' +
                    '<li class=""><a id="lts520r" href="#">2. 良田高拍仪S520-R</a></li>' +
                    '<li class=""><a href="#">3. 良田高拍仪S520</a></li>' +
                    '<li class=""><a href="#">4. 富士通高速扫描仪</a></li>' +
                    '</ul>' +
                    '</td>' +
                    '</tr>' +
                    '</table>';
            $.jBox(html, {
                title: "请选择扫描设备",
                width: 450,
                height: 230,
                opacity: 0.5,
                border: 1,
                iframeScrolling: "yes",
                persistent: true,
                buttons: {},
                showClose: false,
                loaded: function (h) {
                    $("#fortunes", h).click(function () {
                        location.href = "${ctx}/Image/ImageInfo/ImageInfos";
                        $.jBox.close(true);
                    });
                    $("#lts520r", h).click(function () {
                        location.href = "${ctx}/Image/ImageInfo/Images520rInfos";
                        $.jBox.close(true);
                    });
                }
            });
        });
    </script>
    <![endif]-->--%>
</head>
<body>
</body>
</html>
