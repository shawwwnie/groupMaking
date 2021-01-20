<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javaScript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script>
$(document).ready(function(){
		
		var currentPage;
		var count;
		var rowCount;
		//목록 호출
		function selectData(pageNum){
			currentPage = pageNum;
			
			if(pageNum == 1){
				//처음 호출시는 해당 ID의 div의 내부 내용물을 제거
				$('#output').empty();
			}
			
			//로딩 이미지 노출
			$('#loading').show();
			
			$.ajax({
				type:'post',
				data:{pageNum:pageNum},
				url:'groupListAjax.do',
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(data){
					//로딩 이미지 감추기
					$('#loading').hide();
					count = data.count;
					rowCount = data.rowCount;
					var list = data.list;
					
					if(count < 0 || list == null){
						alert('목록 호출 오류 발생!');
					}else{
						$(list).each(function(index,item){
							
							var output = '<div class="container">';
								output += '<div class="card">';
									output += '<div class="front side">';
										output += '<h1 calss="logo">' + item.group_name + '</h1>';
									output += '</div>';
									output += '<div class="back side">';
										output += '<h2 class="name">' + item.group_name + '</h2>';
										output += '<a class="property" href="/main/group/groupDetail.do?group_num=' + item.group_num + '">그룹 입장하기</br></a>';
										output += '<div> 그룹소개 </br>' + item.group_intro + '</div>';
										output += '<div class="info">';
											output += '<p><span class="property"> 그룹지역 : </span>' + item.group_location + '</p>';
											output += '<p><span class="property"> 모집기준 : </span>' + item.group_required + '</p>';
											output += '<p><span class="property"> 활동시간 : </span>' + item.group_time + '</p>';
											output += '<p><span class="property"> 시작여부 : </span>' + item.group_start + '</p>';
											output += '<p><a class="property" href="/main/member/registerGroup.do?group_num=' + item.group_num + '">그룹 가입하기</a></p>';
										output += '</div>';
									output += '</div>';
								output += '</div>';
							output += '</div>';
							
							//문서 객체에 추가
							$('#output').append(output);
						});
						
					}
				},
				error:function(){
					//로딩 이미지 감추기
					$('#loading').hide();
					alert('네트워크 오류');
				}
		});
	}
	
	//스크롤시 데이터 추가
	$(window).scroll(function(){
		
		var scrollTop = $(document).scrollTop();
		var docHeight = $(document).height();
		var winHeight = $(window).height();
		
		if(scrollTop >= docHeight - winHeight){
			if(currentPage>=Math.ceil(count/rowCount)){
				//다음 페이지가 없음
				return;
			}else{
				//다음 페이지가 존재
				var pageNum = currentPage + 1;
				selectData(pageNum);
			}
		 }
	});
	
	//1페이지 호출
	selectData(1);
	
});
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout_groupList.css">
<div class="page_groupList">
	<input type="button" value="그룹만들기" onClick="location.href='${pageContext.request.contextPath}/group/groupMake.do'">
	<div class="groups">
		<div id="output">
			<!-- ajax 영역 -->
		</div>
	</div>
</div>