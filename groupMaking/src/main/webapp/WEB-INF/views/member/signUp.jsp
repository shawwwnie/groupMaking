<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입페이지</title>
</head>
<body>
	<h2>회원가입</h2>
	<form class="signUpForm" action="">
		<ul> 
			<li>
				<a>아이디</a>
				<input type="text" class="insertId" name="mem_id">
				<input type="button" class="confirmId" value="중복확인">
			</li>
			<li>
				<a>비밀번호</a>
				<input type="password" class="insertPw" name="mem_pw">
			</li>
			<li>
				<a>비밀번호 확인</a>
				<input type="password" class="insertPw2" name="mem_pw2">
			</li>
			<li>
				<a>성별</a>
				<input type="radio" class="insertGender" name="mem_gender" value="male" >남자
				<input type="radio" class="insertGender" name="mem_gender" value="female">여자
				<input type="radio" class="insertGender" name="mem_gender" value="other">기타
			</li>
			<li>
				<a>전화번호</a>
				<input type="tel" class="insertPhone" name="mem_phone" placeholder="숫자만 입력하세요">
			</li>
			<li>
				<a>이메일</a>
				<input type="email" class="insertEmail" name="mem_email">
			</li>
			<li>
				<a>우편번호</a>
				<input type="number" class="insertZipcode" name="mem_zipcode">
				<input type="button" class="findZip" value="우편번호찾기">
			</li>
			<li>
				<a>주소</a>
				<input type="text" class="insertAddr1" name="mem_addr1">
			</li>
			<li>
				<a>상세주소</a>
				<input type="text" class="insertAddr2" name="mem_addr2">
			</li>
			<li>
				<a>자기소개</a>
				<input type="text" class="insertIntro" name="mem_intro">
			</li>
		</ul>
		<input type="submit" value="회원가입" class="signUpBtn">
	</form>
</body>
</html>