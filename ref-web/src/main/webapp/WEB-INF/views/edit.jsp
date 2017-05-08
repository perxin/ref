<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>阅读论坛</title>
    <script type="text/javascript">
        contextPath = '<%=request.getContextPath()%>';
    </script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/bootstrap.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/animate.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/simple-line-icons.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/font.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/app.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/media/css/custom/custom.css" type="text/css" />
    <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/media/js/edit.js"></script>
</head>
<body>

<div class="app app-header-fixed" id="app">
    <jsp:include page="navbar.jsp" />
    <hr style="margin: 1px"/>
    <!-- content -->
    <div class="app-content navbar-collapse">
        <div ui-butterbar></div>
        <a href class="off-screen-toggle hide" data-toggle="class:off-screen" data-target=".app-aside" ></a>
        <div class="app-content-body fade-in-up content">
            <!-- COPY the content from "tpl/" -->
            <h4>编辑文章</h4>
            <div class="input-group edit-title">
                <span class="input-group-addon">标题</span>
                <input id="note_title" type="text" class="form-control" placeholder="请输入文章标题" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <span class="input-group-addon">文章描述</span>
                <input id="note_description" type="text" class="form-control" placeholder="请输入简短的描述语言" aria-describedby="basic-addon1">
            </div>
            <div>
                <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
            </div>
            <div class="btn-group btn-group-justified edit-submit" role="group" aria-label="...">
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default edit-submit-button" onclick="noteSubmit()">提交</button>
                </div>
            </div>
            <%--<div id="btns">
                <div>
                    <button onclick="getAllHtml()">获得整个html的内容</button>
                    <button onclick="getContent()">获得内容</button>
                    <button onclick="setContent()">写入内容</button>
                    <button onclick="setContent(true)">追加内容</button>
                    <button onclick="getContentTxt()">获得纯文本</button>
                    <button onclick="getPlainTxt()">获得带格式的纯文本</button>
                    <button onclick="hasContent()">判断是否有内容</button>
                    <button onclick="setFocus()">使编辑器获得焦点</button>
                    <button onmousedown="isFocus(event)">编辑器是否获得焦点</button>
                    <button onmousedown="setblur(event)" >编辑器失去焦点</button>
                </div>
                <div>
                    <button onclick="getText()">获得当前选中的文本</button>
                    <button onclick="insertHtml()">插入给定的内容</button>
                    <button id="enable" onclick="setEnabled()">可以编辑</button>
                    <button onclick="setDisabled()">不可编辑</button>
                    <button onclick=" UE.getEditor('editor').setHide()">隐藏编辑器</button>
                    <button onclick=" UE.getEditor('editor').setShow()">显示编辑器</button>
                    <button onclick=" UE.getEditor('editor').setHeight(300)">设置高度为300默认关闭了自动长高</button>
                </div>

                <div>
                    <button onclick="getLocalData()" >获取草稿箱内容</button>
                    <button onclick="clearLocalData()" >清空草稿箱</button>
                </div>

            </div>
            <div>
                <button onclick="createEditor()">
                    创建编辑器</button>
                <button onclick="deleteEditor()">
                    删除编辑器</button>
            </div>--%>
            <!-- PASTE above -->
        </div>
    </div>
    <!-- /content -->

    <jsp:include page="footer.jsp" />
<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');


    function isFocus(e){
        alert(UE.getEditor('editor').isFocus());
        UE.dom.domUtils.preventDefault(e)
    }
    function setblur(e){
        UE.getEditor('editor').blur();
        UE.dom.domUtils.preventDefault(e)
    }
    function insertHtml() {
        var value = prompt('插入html代码', '');
        UE.getEditor('editor').execCommand('insertHtml', value)
    }
    function createEditor() {
        enableBtn();
        UE.getEditor('editor');
    }
    function getAllHtml() {
        alert(UE.getEditor('editor').getAllHtml())
    }
    function getContent() {
        var arr = [];
//        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
//        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
//        alert(arr.join("\n"));
        return arr;
    }
    function getPlainTxt() {
        var arr = [];
        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    }
    function setContent(isAppendTo) {
        var arr = [];
        arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
        UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
        alert(arr.join("\n"));
    }
    function setDisabled() {
        UE.getEditor('editor').setDisabled('fullscreen');
        disableBtn("enable");
    }

    function setEnabled() {
        UE.getEditor('editor').setEnabled();
        enableBtn();
    }

    function getText() {
        //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
        var range = UE.getEditor('editor').selection.getRange();
        range.select();
        var txt = UE.getEditor('editor').selection.getText();
        alert(txt)
    }

    function getContentTxt() {
        var arr = [];
        arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
        arr.push("编辑器的纯文本内容为：");
        arr.push(UE.getEditor('editor').getContentTxt());
        alert(arr.join("\n"));
    }
    function hasContent() {
        var arr = [];
        arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
        arr.push("判断结果为：");
        arr.push(UE.getEditor('editor').hasContents());
        alert(arr.join("\n"));
    }
    function setFocus() {
        UE.getEditor('editor').focus();
    }
    function deleteEditor() {
        disableBtn();
        UE.getEditor('editor').destroy();
    }
    function disableBtn(str) {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            if (btn.id == str) {
                UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
            } else {
                btn.setAttribute("disabled", "true");
            }
        }
    }
    function enableBtn() {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        }
    }

    function getLocalData () {
        alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
    }

    function clearLocalData () {
        UE.getEditor('editor').execCommand( "clearlocaldata" );
        alert("已清空草稿箱")
    }
</script>

</body>
</html>