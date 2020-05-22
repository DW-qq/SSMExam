<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/21
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").on("click",function () {
                var uname = $("#uname").val();
                var pwd = $("#pwd").val();
                var falg=true;
                var error = '';

                if(uname==''||uname==undefined){
                    error='用户名为空';
                    falg= false;
                }

                if(pwd==''||pwd==undefined){
                    error='密码为空';
                    falg= false;
                }

                if(falg==true && error==''){
                    $("#fromId").submit();
                }else {
                    alert("用户名密码不能为空");
                }
            })

        })
    </script>
</head>
<body>
<h2>登入</h2>
<p style="color: red">${erroMsg}</p>
<form:form method="post" action="/doLogin" modelAttribute="user" id="fromId">
    用户名:<form:input path="uName" id="uname"/><br>
    密码:<form:password path="password" id="pwd"/><br>
    <input type="button" value="提交" id="btn">
</form:form>
</body>
</html>
