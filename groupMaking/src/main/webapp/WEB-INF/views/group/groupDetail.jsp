<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout_groupDetail.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout_detailToggleStyle.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var theToggle = document.getElementById("toggle");
	// hasClass
	function hasClass(elem, className) {
	  return new RegExp(" " + className + " ").test(" " + elem.className + " ");
	}
	// addClass
	function addClass(elem, className) {
	  if (!hasClass(elem, className)) {
	    elem.className += " " + className;
	  }
	}
	// removeClass
	function removeClass(elem, className) {
	  var newClass = " " + elem.className.replace(/[\t\r\n]/g, " ") + " ";
	  if (hasClass(elem, className)) {
	    while (newClass.indexOf(" " + className + " ") >= 0) {
	      newClass = newClass.replace(" " + className + " ", " ");
	    }
	    elem.className = newClass.replace(/^\s+|\s+$/g, "");
	  }
	}
	// toggleClass
	function toggleClass(elem, className) {
	  var newClass = " " + elem.className.replace(/[\t\r\n]/g, " ") + " ";
	  if (hasClass(elem, className)) {
	    while (newClass.indexOf(" " + className + " ") >= 0) {
	      newClass = newClass.replace(" " + className + " ", " ");
	    }
	    elem.className = newClass.replace(/^\s+|\s+$/g, "");
	  } else {
	    elem.className += " " + className;
	  }
	}

	theToggle.onclick = function () {
	  toggleClass(this, "on");
	  return false;
	};
});
</script>

<input type="button" onclick="location.href='/main/main.do'" value="홈버튼">
<fieldset class="slideshow">

  <!-- Slide 1 -->
  <label class="slide-button" for="slideCheckbox1">그룹 정보</label>
  <input type="radio" id="slideCheckbox1" name="slide" checked></input>
  <div class="slide">
    <div class="slide__content">
      <h1>${group.group_name}</h1>
      <p>그룹 소개</p>
      <p>${group.group_intro}</p>
      <p>그룹 정보</p>
      <input type="hidden" id="group_num" value="${group.group_num}">
      <ul>
        <li>그룹지역 : ${group.group_location}</li>
        <li>모집기준 : ${group.group_required}</li>
        <li>활동시간 : ${group.group_time}</li>
      </ul>
    </div>  
  </div>

  <!-- Slide 2 -->
  <label class="slide-button" for="slideCheckbox2">그룹 게시판</label>
  <input type="radio" id="slideCheckbox2" name="slide"></input>
  <div class="slide">
    <div class="slide__content">
      <h1>그룹 게시판</h1>
      <div id="chatting">
      <hr size="1" width="100%">
    	 <div class=chatList>
    		<table border="1" id="board_list">
    			<thead>
    				<tr align="center" bgcolor="#e3e3e3">
    					<th>제목</th><th>작성자</th><th>작성일</th>
    				</tr>
    			</thead>
    			<tbody>
	     	 	<c:forEach var="board" items="${board}">
		     	 	<tr align="center" bgcolor="#e3e3e3">
    					<td><a href="/main/group/groupBoardDetail.do?board_num=${board.board_num}">${board.board_title}</a></td>
    					<td>${board.mem_id}</td>
    					<td>${board.board_date}</td>
    				</tr>
	     	 	</c:forEach>
	     	 	</tbody>
     	 	</table>
     	 </div>
	  <hr size="1" width="100%">
	  
     </div>
	  <input type="button" onClick="location.href='/main/group/groupBoardWrite.do?group_num=${group.group_num}'" value="글쓰기" style="display: inline-block; float: right;">
    </div> 
  </div>

  <!-- Slide 3 -->
  <label class="slide-button" for="slideCheckbox3">가입 멤버</label>
  <input type="radio" id="slideCheckbox3" name="slide"></input>
  <div class="slide">
    <div class="slide__content">
      <h1>가입 멤버</h1>
      <ul class="outCycle">
      <c:forEach var="members" items="${members}">
		<a id="id" style="font-size: x-large;">${members.mem_id}</a><a href="#menu" id="toggle"><span class="toggleSpan"></span></a>
			<div id="menu">
				<ul class="inMenuUl">
					<li class="inMenuLi"><a href="#home" class="inMenuA">메세지보내기</a></li>
					<li class="inMenuLi"><a href="/main/member/updateBlack.do?mem_num=${members.mem_num}&group_num=${group.group_num}" class="inMenuA">신고하기</a></li>
					<li class="inMenuLi"><a href="#contact" class="inMenuA">강퇴</a></li>
				</ul>
			</div>
      </c:forEach>
      </ul>
    </div>  
  </div>

  <!-- Slide 4 -->
  <label class="slide-button" for="slideCheckbox4">그룹 일정</label>
  <input type="radio" id="slideCheckbox4" name="slide"></input>
  <div class="slide">
    <div class="slide__content">
      <h1>그룹 일정</h1>
      <p>여기에 달력 api 이용해서 일정 넣기</p>
    </div>
  </div>

  <!-- Slide 5 -->
  <label class="slide-button" for="slideCheckbox5">그룹 관리</label>
  <input type="radio" id="slideCheckbox5" name="slide"></input>
  <div class="slide">
    <div class="slide__content">
      <h1>그룹관리</h1>
      <p>그룹 관리 넣기</p>
      
    </div>  
  </div>

  <!-- Add more slides here! -->

</fieldset>
</body>