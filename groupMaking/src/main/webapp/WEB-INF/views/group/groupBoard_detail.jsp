<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout_groupBoardDetail.css">


<article>
	<h1>
		<span class="the">Title</span> 
		<span class="heart">${detail.board_title}</span>
	</h1>
	<cite>
		작성자 : <span class="name">${detail.mem_id}</span> |
		작성일 : <span class="name">${detail.board_date}</span>
	</cite>
		<c:if test="${!empty detail.board_filename}">
			<img src="${pageContext.request.contextPath}/group/imageView.do?board_num=${detail.board_num}"/>
		</c:if>
		<c:if test="${empty detail.board_filename}">
		<!-- 아래 src에 임시이미지 주소 넣기 -->
			<img src="${pageContext.request.contextPath}/group/imageView.do?board_num=${detail.board_num}"/>
		</c:if>
	<main>
		<p>내용</p>
		<p>${detail.board_content}</p>
		<hr size="1" width="70%" color="#939393">
		<p>장소</p>
		<p>${detail.board_location}</p>
		<hr size="1" width="70%" color="#939393">
		<p>기한</p>
		<p>${detail.board_limit}</p>
		<hr size="3" width="100%" color="#939393">
		<p>여기에 댓글창 만들고 댓글기능 넣기</p>
	</main>
	
	
</article>