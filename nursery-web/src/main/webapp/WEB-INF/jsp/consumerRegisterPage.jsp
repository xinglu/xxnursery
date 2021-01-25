<%--
  Created by IntelliJ IDEA.
  User: NANNAN
  Date: 2021/1/24
  Time: 21:04
  注册中心|注册功能
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<%--注册表 register--%>
<div>
    <form id="register-form" name="register-form" action="/consumerRegister/register" method="post">
        <div id="div1">
            <input type="text" placeholder="用户名"/>
            <input type="date" placeholder="1997-07-03"/>
            <input type="radio" name="sex" value="男" checked>
            <input type="radio" name="sex" value="女">
            <button type="button">下一步</button>
        </div>
        <div id="div2">
            <div id="consumer_cellphone">
                <input type="text" placeholder="请输入手机号"/>
                <button type="button">发送</button>
            </div>
            <div id="consumer_checkCode">
                <input type="text" placeholder="验证码"/>
                <img src="#" alt="验证码" />
            </div>
            <input type="password" id="password" name="password" placeholder="******">
            <input type="password" id="equal_password" name="equel_password" placeholder="******">
            <button type="submit">提交</button>
        </div>
    </form>

</div>
</body>
</html>
