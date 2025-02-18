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
        
        div.photos img{
        	width: 200px;
        	border: 2px solid gray;
        	border-radius: 20px;
        	margin: 10px;
        }
     </style>
</head>
<body>
  <h4 class="alert alert-danger">Ajax 로 여러사진 업로드하기</h4>
  <input type="file" id="photoupload" multiple="multiple">

	<hr>
	<div class="photos" style="margin: 20px;"></div>
	
	<script type="text/javascript">
	$("#photoupload").change(function(e){
		let form=new FormData();
		//alert(e.target.files.length);//업로드한 파일의 갯수
		
		for(let i=0;i<e.target.files.length;i++){
			form.append("upload",e.target.files[i]);//선택한 사진 모두 추가
		}
		
		$.ajax({
			type:"post",
			dataType:"json",
			url:"./multiupload",
			data:form,
			processData:false,
			contentType:false,
			success:function(res){
				//.photos 안에 img 태그 생성해서 넣기
				let s="";
				$.each(res,function(idx,ele){
					s+=
						`<img src="./save/\${ele.photo}">`;
				});
				
				$(".photos").html(s);
			}
		});
	});
	</script>
</body>
</html>


















