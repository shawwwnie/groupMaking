<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var free_photo;
	$('#board_fileUpload').change(function(){
		var upload = document.getElementById('board_fileUpload');
		
		free_photo = upload.files[0];
		if(free_photo){
			var reader = new FileReader();
			reader.readAsDataURL(free_photo);
			
			reader.onload = function(){
				$('.free_file').attr('src',reader.result).show();
			}				
		}
	});
});
</script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout_boardWrite.css">
<div class="wrapper">
  <form:form commandName="groupVO" action="groupBoardWrite.do" enctype="multipart/form-data" class="form">
    <h1>글쓰기</h1>
    <div class="btn-box"><label class="btn btn-link" for="board_fileUpload">파일 업로드</label>
    	<input type="file" name="board_fileUpload" id="board_fileUpload" style="visibility:hidden;">
    	<img id="free_file" class="free_file" alt="free image"
				 style="max-width:350px; max-height:350px; display:none; position:relative;">
    </div>
    <form:input type="text" path="group_num" style="display:none;" value="${writer.group_num}"/>
    <hr class="sep"/>
    <div class="group">
      
      <form:input type="text" required="required" path="board_title" /><span class="highlight"></span><span class="bar"></span>
      <label class="placeholder">제목</label>
    </div>
    <div class="group">
      <form:input type="text" required="required" path="board_location"/><span class="highlight"></span><span class="bar"></span>
      <label class="placeholder">장소</label>
    </div>
    <div class="group">
      <form:input type="date" required="required" path="board_limit"/><span class="highlight"></span><span class="bar"></span>
      <label class="placeholder">기한</label>
    </div>
    <div class="group">
      <form:textarea type="textarea" rows="5" required="required" path="board_content" class="textarea"/><span class="highlight"></span><span class="bar"></span>
      <label class="placeholder">글 내용</label>
    </div>
    <div class="btn-box">
      <button class="btn btn-submit" type="submit">등록</button>
      <button class="btn btn-cancel" type="button" onClick="location.href='groupDetail.do?group_num=${writer.group_num}'">취소</button>
    </div>
  </form:form>
</div>