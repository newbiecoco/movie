<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>change-userinfo</title>
</head>
<body>
<div style="width: 1000px;margin: 0 auto">
    <form action="change-userinfo" method="post">
        <div>
            <label>用户名</label>
            <input type="text" name="userName" value="${userVO.userName}" autocomplete="off">
        </div>
        <div>
            <label>年龄</label>
            <input type="number" name="userAge" value="${userVO.userAge}" autocomplete="off">
        </div>
        <div>
            <label>性别</label>
            <select name="userSex">
                <c:choose>
                    <c:when test="${userVO.userSexStr=='未知'}">
                        <option value="" hidden>未知</option>
                    </c:when>
                    <c:when test="${userVO.userSexStr=='保密'}">
                        <option value="p" hidden>${userVO.userSexStr}</option>
                    </c:when>
                    <c:when test="${userVO.userSexStr=='男'}">
                        <option value="m" hidden>${userVO.userSexStr}</option>
                    </c:when>
                    <c:when test="${userVO.userSexStr=='女'}">
                        <option value="f" hidden>${userVO.userSexStr}</option>
                    </c:when>
                </c:choose>
                <option value="m">男</option>
                <option value="f">女</option>
                <option value="p">保密</option>
                <option value="">未知</option>
            </select>
        </div>
        <div>
            <label>出生日期</label>
            <input type="date" name="birthdate" value="${userVO.birthdateStr}" autocomplete="off">
        </div>
        <div>
            <input type="submit" value="立即提交">
        </div>
    </form>
</div>
</body>
</html>
