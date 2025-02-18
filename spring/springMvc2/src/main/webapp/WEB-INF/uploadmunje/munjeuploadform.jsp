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
        
        .plusfile,.minusfile{
        	font-size: 20px;
        	cursor: pointer;
        }
        
        .addfile{
        	margin-left: 40px;
        }
     </style>
</head>
<body>
<h3 class="alert alert-danger">여러개의 사진 업로드하기</h3>
<form action="./munjeprocess2" method="post" enctype="multipart/form-data">
	제목 : <input type="text" name="title"><br>
	사진 : <input type="file" name="upload" multiple style="width: 200px;">	
	    <i class="bi bi-plus-circle-fill plusfile"></i>
	    <i class="bi bi-dash-circle minusfile"></i><br>
	    <div class="addfile"></div>
			
	<button type="submit">전송</button>
</form>
<script type="text/javascript">
	$(".plusfile").click(function(){
		let s=`<input type="file" name="upload" class="files" multiple><br>`;
		$(".addfile").append(s);
	});
	
	$(".minusfile").click(function(){
		$(".addfile .files:last").remove();
		$(".addfile br:last").remove();
	});
</script>
</body>
</html>
















