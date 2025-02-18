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
<input type="text" id="title" placeholder="제목입력"><br>
<input type="file" id="upload">
<hr>
<h2 class="title"></h2>
<div class="photo"></div>

<script type="text/javascript">
$("#upload").change(function(e){
	let form=new FormData();
	form.append("upload",e.target.files[0]);
	form.append("title",$("#title").val());

	$.ajax({
		type:"post",
		dataType:"json",
		url:"./munjeprocess1",
		processData:false,
		contentType:false,
		data:form,
		success:function(res){
			$("h2.title").html(res.title);
			$(".photo").html(`<img src="./save/\${res.photo}">`);
		}
	});
});

</script>
</body>
</html>