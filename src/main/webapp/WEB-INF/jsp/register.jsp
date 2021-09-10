<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<div style="width: 1000px;margin: 0 auto">
    <form action="register" method="post">
        <div>
            <p style="background: #ffebeb;color: #f40;padding: 6px">加*为必填项，请务必填写完整</p>
        </div>
        <div>
            <label>用户名<span style="color:#f40;">*</span></label>
            <input type="text" name="userName" autocomplete="off">
        </div>
        <div>
            <label>登录名<span style="color:#f40;">*</span></label>
            <input type="text" name="loginName" autocomplete="off">
        </div>
        <div>
            <label>登录密码<span style="color:#f40;">*</span></label>
            <input type="text" name="loginPassword" autocomplete="off">
        </div>
        <div>
            <label>性别</label>
            <select name="userSex">
                <option value="">请选择</option>
                <option value="m">男</option>
                <option value="f">女</option>
                <option value="p">保密</option>
            </select>
        </div>
        <div>
            <label>出生日期<span style="color:#f40;">*</span></label>
            <input id="input-birthdate" type="date" name="birthdate" autocomplete="off">
        </div>
        <div style="pointer-events: none">
            <label>年龄</label>
            <input id="input-age" type="number" name="userAge" autocomplete="off">
        </div>
        <div>
            <input type="submit" value="立即注册">
        </div>
    </form>
</div>
<script type="application/javascript">
    var dateEle = document.getElementById("input-birthdate");
    // value值发生改变时，触发事件
    dateEle.oninput = function() {
        var inputYear = new Date(this.value).getFullYear();
        var nowYear = new Date().getFullYear();
        var age = nowYear - inputYear;
        var ageEle = document.getElementById("input-age");
        ageEle.value = age;
    }
</script>
</body>
</html>
