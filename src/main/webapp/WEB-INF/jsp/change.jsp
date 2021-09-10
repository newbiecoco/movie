<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>change password</title>
</head>
<body>
<div style="width: 1000px;margin: 0 auto">
    <form action="change" method="post">
        <div>
            <label>原密码</label>
            <input type="text" name="oldPsw" autocomplete="off">
        </div>
        <div>
            <label>新密码</label>
            <input type="password" name="newPsw" autocomplete="off">
        </div>
        <div>
            <label>确认密码</label>
            <input type="password" name="confirmPsw" autocomplete="off">
        </div>
        <div>
            <input type="submit" value="立即修改">
        </div>
    </form>
</div>
</body>
</html>
