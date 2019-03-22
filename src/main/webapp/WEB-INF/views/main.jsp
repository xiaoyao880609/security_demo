<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html>
<head>
</head>
<body>
主页，谁都能访问的页面！（当前登陆用户：<sec:authentication property='name' />）<br>
<sec:authorize access="hasRole('ADMIN')">
这段只有<font color="red">管理员权限</font>才能看得到！<br>
</sec:authorize>
<sec:authorize access="hasRole('USER')">
这段只有<font color="red">用户权限</font>才能看得到！<br>
</sec:authorize>
<a href="/logout">注销</a>
</body>
</html>
