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
	<!-- 나중에 method="GET" 빼주기 -->
	<form:form class="signUpForm" action="/main/member/signUp1.do" commandName="memberVO" method="GET">
		<ul> 
			<li>
				<a>아이디</a>
				<form:input type="text" class="mem_id" name="mem_id" path="mem_id" />
				<input type="button" class="confirmId" value="중복확인">
			</li>
			<li>
				<a>비밀번호</a>
				<form:input type="password" class="mem_pw" name="mem_pw" path="mem_pw"/>
			</li>
			<li>
				<a>비밀번호 확인</a>
				<input type="password" class="mem_pw2" name="mem_pw2">
			</li>
			<li>
				<a>이름</a>
				<form:input type="text" class="mem_name" name="mem_name" path="mem_name" />
			</li>
			<li>
				<a>성별 입력</a>
				<form:select id="mem_gender" path="mem_gender">
					<form:option value="1" label="성별을 선택해주세요" />
					<form:option value="1" label="남자" />
					<form:option value="2" label="여자" />
					<form:option value="3" label="기타" />
				</form:select>
			</li>
			<li>
				<a>전화번호</a>
				<form:input type="text" class="mem_phone" name="mem_phone" placeholder="숫자만 입력하세요" path="mem_phone"/>
			</li>
			<li>
				<a>이메일</a>
				<form:input type="text" class="mem_email" name="mem_email" path="mem_email"/>
			</li>
			<li>
				<a>우편번호</a>
				<form:input type="text" class="mem_zipcode" name="mem_zipcode" path="mem_zipcode"/>
				<input type="button" class="findZip" value="우편번호찾기">
			</li>
			<li>
				<a>주소</a>
				<form:input type="text" class="mem_addr1" name="mem_addr1" path="mem_addr1"/>
			</li>
			<li>
				<a>상세주소</a>
				<form:input type="text" class="mem_addr2" name="mem_addr2" path="mem_addr2"/>
			</li>
			<li>
				<a>자기소개</a>
				<form:input type="text" class="mem_intro" name="mem_intro" path="mem_intro"/>
			</li>
		</ul>
		<input type="submit" value="회원가입" class="signUpBtn">
	</form:form>
</body>
</html>