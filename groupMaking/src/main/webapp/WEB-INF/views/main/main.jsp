<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainPage</title>
</head>
<body>
	<form:form class="login" action="/main/member/login.do" commandName="memberVO">
		<p>아이디</p>
		<form:input type="text" id="mem_id" path="mem_id" />
		<p>비밀번호</p>
		<form:input type="password" id="mem_pw"  path="mem_pw" />
		<input type="submit" value="로그인">
		<input type="button" value="회원가입" onClick="location.href='${pageContext.request.contextPath}/member/signUp.do'">
	</form:form>
</body>
</html> 