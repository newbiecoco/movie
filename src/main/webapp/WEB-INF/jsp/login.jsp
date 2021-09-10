<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<div style="width: 1000px;margin: 0 auto">
    <form action="login" method="post">
        <div>
            <label>登录名</label>
            <input type="text" name="loginName" autocomplete="off">
        </div>
        <div>
            <label>登录密码</label>
            <input type="password" name="loginPassword" autocomplete="off">
        </div>
        <div>
            <input type="submit" value="立即登录">
        </div>
    </form>
</div>
</body>
</html>
