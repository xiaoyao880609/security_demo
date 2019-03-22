<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
<form action="/login-process" method="post">
账号：<input type="username" name="username"><br>
密码：<input type="password" name="password">
<button type="submit">登录</button> <br>
<input type="hidden" id="errMsg" value="${errMsg}" />
</form>
</body>
<script src="resources/plugins/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){ 
	if ($("#errMsg").val() != null && $("#errMsg").val().length > 0) {
		alert($("#errMsg").val());
	}
});
</script>
</html>
