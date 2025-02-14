<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>502 jsp study</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
        body *{
            font-family: 'Jua';
        }
     </style>
</head>
<body>
<div style="margin: 20px;">
	<!--  자바코드로 날짜를 얻어서 JSTL 의 today 변수에 직접 저장하려면 -->
	<c:set var="today" value="<%=new Date() %>"/>
	<h5>${today}</h5>
	<h5>
		<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>
	</h5>
	<h5>
		<fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss"/>
	</h5>
	<h5>
		<fmt:formatDate value="${today}" pattern="yyyy-MM-dd a hh:mm"/>
	</h5>
	<h5>
		<fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm EEE"/>
	</h5>
	
	<!-- 날짜 포멧 양식을 지정후 변수 day 1에 저장하기 -->
	<fmt:formatDate value="${today}" pattern="yyyy년 MM월 dd일 HH시"
		 var="day1"/>
	
	<h1>${day1}</h1>
	<hr>
	<c:set var="money" value="4567890"/>
	<c:set var="average" value="89.56789"/>
	
	<h5>급여 : ${money }</h5>
	<h5>평균 : ${average}</h5>
	<h5>
		급여 :
		<fmt:formatNumber value="${money}" type="number"/>
	</h5>
	<h5>
		급여 :
		<fmt:formatNumber value="${money}" type="currency" currencySymbol="$"
		maxFractionDigits="0"/>
	</h5>
	<h5>
		급여 :
		<fmt:formatNumber value="${money}" type="currency" currencySymbol="￦"
		maxFractionDigits="0"/>
	</h5>
	<h5>
		급여 :
		<fmt:formatNumber value="${money}" type="number"/>원
	</h5>
	<h5>
		평균(솟수점이하 자릿수 2자리):
		<fmt:formatNumber value="${average }" maxFractionDigits="2"/>
	</h5>
	
	<c:set var="num1" value="45.6789"/>
	<c:set var="num2" value="27.8"/>
	<h5>
		<!-- pattern="0.00" : 무조건 두자리로 맞춤 -->
		숫자(솟수점이하 자릿수 2자리):
		<fmt:formatNumber value="${num1}" pattern="0.00" />
		,
		<fmt:formatNumber value="${num2}" pattern="0.00" />
	</h5>
	<h5>
		<!-- pattern="0.##" : 두자리로 맞추는데 값이 없을경우 출력안됨 -->	
		숫자(솟수점이하 자릿수 2자리):
		<fmt:formatNumber value="${num1}" pattern="0.##" />
		,
		<fmt:formatNumber value="${num2}" pattern="0.##" />
	</h5>
</div>
</body>
</html>























