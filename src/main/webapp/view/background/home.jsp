<%--
  Created by IntelliJ IDEA.
  User: 007
  Date: 2018/11/18
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>后台管理界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
    <script type="application/javascript" src="../js/jquery-1.11.0.js"></script>
    <script type="application/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body>
<body style=" background-color: #fff;">
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>欢迎来到Layman的主页 <small> ——Layman</small></h1>
        </div>
    </div>

    <div class="row">
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#allarticle" aria-controls="home" role="tab" data-toggle="tab">全部文章</a></li>
            <li role="presentation"><a href="#writearticle" aria-controls="profile" role="tab" data-toggle="tab">编写文章</a></li>
            <li role="presentation"><a href="#usermanage" aria-controls="profile" role="tab" data-toggle="tab">用户管理</a></li>
        </ul>

        <!-- 全部文章 -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade active panel-default" id="allarticle">

                <div class="embed-responsive embed-responsive-16by9">
                    <iframe class="embed-responsive-item" src="a.html"></iframe>
                </div>
            </div>

            <!-- 编写文章 -->
            <div role="tabpanel" class="tab-pane fade" id="writearticle">
                <div class="embed-responsive embed-responsive-16by9">
                    <iframe class="embed-responsive-item" src="/backgroundhome/writeArticle"></iframe>
                </div>
            </div>

            <div role="tabpanel" class="panel" id="usermanage">

            </div>
        </div>
    </div>


    <!-- Footer -->
    <div class="row">
        <div class="panel-footer">
            <address class="col-lg-offset-2">
                <strong>Layman</strong><br>
                192.168.213.66<br>
                xianning, hubei, CN 437100<br>
                <abbr title="Phone">P:</abbr> (123) 456-7890
            </address>
        </div>
    </div>
</div>
</body>
</body>
</html>
