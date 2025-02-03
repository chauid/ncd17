<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 자바빈즈를 이용해서 처리하기 -->
<!-- useBean 으로 dao,dto 선언하고 setProperty로 전체 데이타 읽기 -->
<jsp:useBean id="dao" class="simpleboard.data.SimpleBoardDao"/>
<jsp:useBean id="dto" class="simpleboard.data.SimpleBoardDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
	//dao의 updateBoard 호출
	dao.updateBoard(dto);
	//상세보기로 이동
	response.sendRedirect("./contentdetail.jsp?num="+dto.getNum());
	
%>