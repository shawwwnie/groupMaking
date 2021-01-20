<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입페이지</title>
</head>
<body>
	<h2>회원가입</h2>
	<form:form class="signUpForm" action="/main/group/makeGroup.do" commandName="groupVO">
		<ul> 
			<li>
				<a>그룹이름</a>
				<form:input type="text" class="group_name" name="group_name" path="group_name" />
				<input type="button" class="confirmId" value="그룹명 중복확인">
			</li>
			<li>
				<a>그룹 소개</a>
				<form:input type="text" class="group_intro" name="group_intro" path="group_intro" />
			</li>
			<li>
				<a>그룹 지역 선택</a>
				<form:input type="text" class="group_location" name="group_location" path="group_location" />
			</li>
			<li>
				<a>그룹 모집기준</a>
				<form:input type="text" class="group_required" name="group_required" path="group_required"/>
			</li>
			<li>
				<a>그룹 활동시간</a>
				<form:input type="text" class="group_time" name="group_time" path="group_time"/>
			</li>
		</ul>
		<input type="submit" value="그룹 만들기" class="makingGroupBtn">
	</form:form>
</body>
</html>