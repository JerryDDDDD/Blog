<%--
  Created by IntelliJ IDEA.
  User: 007
  Date: 2018/11/18
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="application/javascript" src="../js/jquery-1.11.0.js"></script>
    <%-- wangEditor依赖导入 --%>
    <link type="text/css" href="../css/wangEditor.css"/>
    <script type="application/javascript" src="../js/wangEditor.js"></script>
    <%-- bootstrap依赖导入 --%>
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.css"/>
    <script type="application/javascript" src="../../js/bootstrap.min.js"></script>
    <link type="text/css" href="../../css/background/writearticle.css" />
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-offset-2 col-lg-6">
            <form class="form-inline title_msg" style="width: 60%">
                <div class="form-group col-lg-3">
                    <label for="exampleInputName2"><h3>标题:</h3></label>
                    <input type="text" class="form-control" id="exampleInputName2" placeholder="请输入文章标题：">
                </div>
                <div class="form-group col-lg-3">
                    <label for="exampleInputEmail2"><h3>作者:</h3></label>
                    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="请输入文章作者">
                </div>

            </form>
        </div>
        <button type="submit" class="btn btn-default save_btn">保存文章</button>
    </div>
    <div id="editor">

    </div>
</div>
</body>
<script type="application/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.customConfig.zIndex = 100
    editor.create();
</script>
<style>
    .w-e-text-container {
        height: 88% !important; /*!important是重点，因为原div是行内样式设置的高度300px*/
    }
    .save_btn{
        float: right !important;
    }
</style>
</html>
