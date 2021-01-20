<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout_groupDetail.css">
<body>
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
      <ul>
        <li>그룹지역 : ${group.group_location}</li>
        <li>모집기준 : ${group.group_required}</li>
        <li>활동시간 : ${group.group_time}</li>
      </ul>
    </div>  
  </div>

  <!-- Slide 2 -->
  <label class="slide-button" for="slideCheckbox2">게시판</label>
  <input type="radio" id="slideCheckbox2" name="slide"></input>
  <div class="slide">
    <div class="slide__content">
      <h1>게시판</h1>
      <p>여기에 채팅창 넣기</p>
    </div> 
  </div>

  <!-- Slide 3 -->
  <label class="slide-button" for="slideCheckbox3">가입 멤버</label>
  <input type="radio" id="slideCheckbox3" name="slide"></input>
  <div class="slide">
    <div class="slide__content">
      <h1>가입 멤버</h1>
      <p>여기에 가입멤버 리스트 넣기</p>
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