<%--
  Created by IntelliJ IDEA.
  User: 007
  Date: 2018/11/16
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>欢迎登录</title>
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.css"/>

    <script type="application/javascript" src="../../js/jquery-1.11.0.js"></script>
    <script type="application/javascript" src="../../js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="../../css/login.css"/>
    <script type="application/javascript" src="../../js/login.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <form action="/account/login" method="post">
                <div class="form-group">
                    <label for="inputusername" class="col-lg-4 control-label text-right">用户名：</label>
                    <div class="col-lg-8">
                        <input id="inputusername" name="inputusername" type="text" class="form-control"
                               placeholder="请输入用户名" onfocus="checkUserName()" onblur="onblurUsername()"/>
                        <span id="usernameCheck"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputpassword" class="col-lg-4 control-label text-right">密码：</label>
                    <div class="col-lg-8">
                        <input id="inputpassword" name="inputpassword" type="password" class="form-control"
                               placeholder="请输入密码" onfocus="checkPassword()" onblur="onblurPassword()"/>
                        <span id="passwordCheck"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputcheck" class="col-lg-4 control-label text-right">请再次输入密码：</label>
                    <div class="col-lg-8">
                        <input id="inputcheck" type="password" class="form-control" placeholder="请再次输入密码"
                               onfocus="reCheckassword()" onblur="onblurReCheckPassword()"/>
                        <span id="passwordReCheck"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="captcha" class="col-lg-4 control-label text-right">请输入验证码：</label>
                    <div class="col-lg-6">
                        <input id="captcha" name="captcha" type="text" class="form-control col-lg-5"
                                   placeholder="请输入验证码"/>
                    </div>

                    <div class="col-lg-2">
                        <img src="/account/captcha" alt="图片找不到">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-8">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> 记住密码?
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-8">
                        <button type="submit" class="btn btn-default">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
