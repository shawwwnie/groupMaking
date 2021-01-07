<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainPage</title>
</head>
<body>
	<div class="login">
		<p>아이디</p>
		<input type="text" id="id" value="">
		<p>비밀번호</p>
		<input type="text" id="pw" value="">
		<input type="submit" value="로그인">
		<input type="button" value="회원가입" onClick="location.href='${pageContext.request.contextPath}/member/signUp.do'">
	</div>
</body>
</html> 