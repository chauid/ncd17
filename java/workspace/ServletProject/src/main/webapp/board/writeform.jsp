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
        
        .tab1 tbody th{
        	background-color: #fff0f5;
        }
     </style>
     <script type="text/javascript">
     	$(function(){
     		if(localStorage.loginok==null){
     			$(".nologin").show();
     			$(".oklogin").hide();
     		}else{
     			$(".nologin").hide();
     			$(".oklogin").show();
     		}
     		
     		//input 태그에 닉네임과 프로필사진넣기
     		$("#writer").val(localStorage.writer);
     		$("#photo").val(localStorage.photo);
     		$(".imgphoto").attr("src",localStorage.photo);
     	});
     </script>
</head>
<body>
<jsp:include page="../kakao/kakaologin.jsp"/>
<br><br>
<hr>
<div style="margin: 20px;width: 500px;text-align: center;" class="nologin">
	<h2>글을 쓰려면 먼저 로그인을 해주세요</h2>
</div>

<div style="margin: 20px;width: 500px;" class="oklogin">
  <form action="./insert" method="post">
  		<!-- hidden -->
  		<input type="hidden" name="regroup" value="${regroup}">
  		<input type="hidden" name="restep" value="${restep}">
  		<input type="hidden" name="relevel" value="${relevel}">
  		<input type="hidden" name="num" value="${num}">  		
  
	   <table  class="tab1 table table-bordered">
	   		<caption align="top"><b>
	   		${num==0?"글쓰기":"답글쓰기"}
	   		</b></caption>
	   		<tbody>
		   		<tr>
		   			<th width="100">닉네임</th>
		   			<td>
		   				<input  type="text" name="writer" id="writer"
		   				required="required" readonly="readonly"
		   				class="form-control">	   				
		   			</td>
		   		</tr>
		   		<tr>
		   			<th width="100">사진</th>
		   			<td class="input-group">
		   				<input  type="text" name="photo" id="photo"
		   				required="required" readonly="readonly"
		   				class="form-control">	
		   				<img src="" class="imgphoto" width="40">   				
		   			</td>
		   		</tr>
		   		<tr>
		   			<th>제목</th>
		   			<td>
		   				<input type="text" name="subject" class="form-control"
		   				required="required" value="${subject}">
		   			</td>
		   		</tr>
		   		<tr>
		   			<th>내용</th>
		   			<td>
		   				<textarea style="width: 100%;height:120px;"
		   				name="content" required="required"></textarea>
		   			</td>
		   		</tr>
		   		
		   		<tr>
		   			<th>비밀번호</th>
		   			<td>
		   				<input type="password" name="passwd" class="form-control"
		   				required="required" style="width: 200px;"
		   				maxlength="8" pattern="^[a-zA-Z0-9]+$"> 
		   				<!-- 숫자,영문대소문자만 가능
		   				 https://neomania.tistory.com/3 참고 -->
		   			</td>
		   		</tr>
		   		<tr>
		   			<td colspan="2" align="center">
		   				<button type="submit"
		   				class="btn btn-sm btn-outline-secondary">저장하기</button>
		   				
		   				<button type="button" 
		   				class="btn btn-sm btn-outline-secondary"
		   				onclick="history.back()">이전으로</button>		   				
		   				
		   			</td>
		   		</tr>
	   		</tbody>
	   </table>
   </form>
</div>
</body>
</html>























