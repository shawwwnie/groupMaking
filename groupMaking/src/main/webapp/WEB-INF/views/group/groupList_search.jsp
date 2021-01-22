<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javaScript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script>

</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout_groupList.css">
<div class="page_groupList">
	<input type="button" value="그룹만들기" onClick="location.href='${pageContext.request.contextPath}/group/groupMake.do'">
	<form action="groupListSearch.do" id="search_form" method="get">
		<ul class="search">
			<li>
				<select name="keyfield" id="keyfield">
						<option value="group_name">그룹이름</option>
						<option value="group_admin">그룹장 아이디</option>
						<option value="all">전체</option>
				</select>
			</li>
			<li><input type="text" name="keyword" id="keyword"></li>
			<li><input type="submit" value="찾기" style="width:60px;"> 
			<input type="button" value="목록" onclick="location.href='groupList.do'" style="width:60px;">
			</li>
		</ul>
	</form>
	<div class="groups">
		<div id="output">
			<c:forEach var="boardList" items="${list}">
				<div class="container">
					<div class="card">
						<div class="front side">
							<h1 class="logo">${boardList.group_name}</h1>
						</div>
							<div class="back side">
							<h2 class="name">${boardList.group_name}</h2>
							<a class="property" href="/main/group/groupDetail.do?group_num=${boardList.group_num}">그룹 입장하기</a>
							<div class="info">
								<div> 그룹소개 </br>${boardList.group_intro}</div>
								<div> 그룹지역 </br>${boardList.group_location}</div>
								<div> 모집기준 </br>${boardList.group_required}</div>
								<div> 활동시간 </br>${boardList.group_time}</div>
								<div> 시작여부 </br>${boardList.group_start}</div>
								<p><a class="property" href="/main/member/registerGroup.do?group_num=${boardList.group_num}">그룹 가입하기</a></p>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>