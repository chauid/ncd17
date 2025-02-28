<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>502 jsp study</title>
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
body * {
	font-family: 'Jua';
}

.profilePhoto {
	width: 50px;
	height: 50px;
	border: 1px solid gray;
	border-radius: 100px;
	margin-right: 10px;
}

.day {
	font-size: 13px;
	color: gray;
}

#photoupload {
	display: none;
}

.addphoto {
	font-size: 1.5em;
	cursor: pointer;
	margin-left: 10px;
	margin-right: 10px;
}

.replelist {
	margin: 10px 10px;
}

img.mini {
	width: 30px;
	height: 30px;
	border: 1px solid gray;
	margin-right: 10px;
	cursor: pointer;
}

span.day {
	color: #bbb;
	font-size: 0.9em;
	margin-left: 20px;
	margin-right: 20px;
}

.repledel {
	color: red;
	cursor: pointer;
	font-size: 0.9em;
	margin-left: 10px;
}
</style>
<script type="text/javascript">
	$(function() {
		let file;
		let num;
        replelist();
        
 		$(".addphoto").click(function(){
 			$("#photoupload").trigger("click");
 		});
 		
 		$("#photoupload").change(function(e){
 			file=e.target.files[0];
 			console.log(file);
 		});

		$('.modify-img-button').hover(function() {
			$(this).css({
				"background-color": "rgba(200, 200, 200, 0.5)",
				"opacity": "1"
			});
		}, function() {
			$(this).css({
				"background-color": "rgba(200, 200, 200, 0.5)",
				"opacity": "0"
			});
		});

		$('#modify-img-input').change(function(e) {
			file=e.target.files[0];
			console.log(file);
			let reader = new FileReader();
			reader.onload = function(e) {
				$('#replemodify-img').attr('src', e.target.result);
			}
			reader.readAsDataURL(file);
		});

 		
 		$("#btnaddreple").click(function(){
 			console.log("asdsad");
 			let m=$("#message").val();
 			if(m==''){
 				alert("댓글을 입력해주세요");
 				return;
 			}
 			
/*  			if(file==null){
 				alert("사진을 선택해주세요");
 				return;
 			} */
 			let form=new FormData();
 			console.log(file);
 			form.append("idx",${dto.idx});
 			form.append("message",m);
 			form.append("photo",file);
 			
 			
 			$.ajax({
 				type:"post",
 				dataType:"text",
 				url:"./addreple",
 				data:form,
 				processData:false,
 				contentType:false,
 				success:function(){
 					$("#message").val("");
 					file=null;
 					replelist();
 				}
 			});
 		});

		$('#modify').click(function() {
			let message = $("#replemodify-text").val();
			let photo = $("#replemodify-img").attr("src");
			let repleNum = $("#replemodify-img").attr("num");
			let form=new FormData();
 			form.append("num", repleNum);
 			form.append("message",message);
 			form.append("photo",file);
			$.ajax({
				type: "put",
				dataType: "text",
				url: "./updatereple",
				data: form,
				processData:false,
				contentType:false,
				success: function() {
					replelist();
				}
			});
		});
	});
	
	$(document).on("click",".repledel",function(){
		let num=$(this).attr("num");
		let ans=confirm("해당 댓글을 삭제할까요?");
		if(!ans) return;//취소 클릭시 함수 종료
		
		$.ajax({
			type:"delete",
			dataType:"text",
			data:{"num":num},
			url:"./deletereple",
			success:function(){
				//댓글 삭제후 전체 댓글 다시 출력
				replelist();
			}
		});
	});
	
	//미니 댓글 사진 클릭시 원본사진 보기
	$(document).on("click","img.mini",function(){
		let imgSrc=$(this).attr("alt");
		$("img.replelarge").attr("src","https://kr.object.ncloudstorage.com/bitcamp-bucket-springmvc3/board/reple/"+imgSrc);
	});

	$(document).on("click","button.replemodify",function(){
		let imgSrc=$(this).attr("pname");
		$("#replemodify-img").attr("src","https://kr.object.ncloudstorage.com/bitcamp-bucket-springmvc3/board/reple/"+imgSrc);
		$("#replemodify-img").attr("num",$(this).attr("num"));
		$("#replemodify-text").val($(this).attr("message"));
	});
	
	function replelist(){
 		$.ajax({
 			type:"get",
 			dataType:"json",
 			url:"./replelist",
 			data:{"idx":${dto.idx}},
 			success:function(res){
 				let s="";
 				
 				$.each(res,function(idx,item){
 					s+=`
 					 <div class="item" style="margin-bottom:5px;">
 							<img src="https://s8iggryl8725.edge.naverncp.com/Jy5pSYRAWb/board/reple/\${item.photo}?type=f&w=30&h=30&faceopt=true&ttype=jpg" alt="\${item.photo}" class="mini"
 								data-bs-toggle="modal" data-bs-target="#myMiniPhotoModal" onerror="this.src='../save/noimage.png'">
 							<span>\${item.writer}</span>
 							<span style="margin-left: 5px;">\${item.message}</span>
 							<span class="day">\${item.writeday}</span>
 							<span style:"float:right;">
 							    <button class="btn btn-sm btn-light replemodify" num="\${item.num}" pname="\${item.photo}" data-bs-toggle="modal" data-bs-target="#updateModal" message="\${item.message}">수정</button>
 								<i class="bi bi-x-lg repledel" num="\${item.num}"></i>
 							</span>
 					</div>
 					`;
 					
 				});
 				s+="</div>";
 				$("div.replelist").html(s);
 			}
 		});
 	}
</script>
</head>
<body>
	<!--로그인을 안할경우 경고후 이전페이지로 이동 -->
	<c:if test="${sessionScope.loginstatus==null}">
		<script>
			alert("회원게시판입니다\n먼저 로그인을 해주세요");
			history.back();
		</script>
	</c:if>
	<jsp:include page="/layout/title.jsp" />

	<div style="margin: 30px;">
		<h3>
			<b>${dto.subject}</b>
		</h3>
		<img src="${naverurl}/member/${memberPhoto}" class="profilePhoto"
			align="left" onerror="this.src='/save/noimage.png'"> <span>${dto.writer}</span><br>
		<span class="day"> <fmt:formatDate value="${dto.writeday}"
				pattern="yyyy-MM-dd HH:mm" /> &nbsp;&nbsp; 조회&nbsp;${dto.readcount}
		</span>
		<pre style="margin-top: 30px; font-size: 15px;">${dto.content}</pre>
		<div style="margin-top: 30px;">
			<c:forEach var="photo" items="${dto.photos}">
				<img src="${naverurl}/board/${photo}" style="max-width: 300px;">
			</c:forEach>
		</div>
		<p></p>
		<div class="repleform input-group"
			style="width: 600px; margin-top: 20px">
			<input type="text" id="message" class="form-control"
				style="width: 400px;" placeholder="댓글입력"> <input type="file"
				id="photoupload"> <i class="bi bi-camera-fill addphoto"></i>
			<button type="button" class="btn btn-sm btn-info" id="btnaddreple">등록</button>
		</div>
		<div class="replelist"></div>
		<div style="margin-top: 30px;">
			<button type="button" class="btn btn-success btn-sm"
				style="width: 80px;" onclick="location.href='./writeform'">
				<i class="bi bi-pencil-fill"></i> 글쓰기
			</button>

			<button type="button" class="btn btn-outline-secondary btn-sm"
				style="width: 80px;"
				onclick="location.href='./writeform?idx=${dto.idx}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&pageNum=${pageNum}'">
				답글</button>

			<c:if test="${sessionScope.loginid==dto.myid}">
				<button type="button" class="btn btn-outline-secondary btn-sm"
					style="width: 80px;"
					onclick="location.href='./updateform?idx=${dto.idx}&pageNum=${pageNum}'">수정</button>

				<button type="button" class="btn btn-outline-secondary btn-sm"
					style="width: 80px;"
					onclick="location.href='./delete?idx=${dto.idx}&pageNum=${pageNum}'">삭제</button>
			</c:if>

			<button type="button" class="btn btn-outline-secondary btn-sm"
				style="width: 80px; margin-left: 50px;"
				onclick="location.href='./list?pageNum=${pageNum}'">목록</button>
		</div>
	</div>
	<!-- The Modal -->
	<div class="modal" id="myMiniPhotoModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">원본사진</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<img src="" class="replelarge" style="width: 100%;" onerror="this.src='../save/noimage.png'">
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>
	<!-- The Modal -->
	<div class="modal" id="updateModal">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">댓글 수정</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<p>댓글이미지</p>
					<div style="position: relative; width: 100%; height: 100%;">
						<img src="" id="replemodify-img" style="width: 100%;" onerror="this.src='../save/noimage.png'">
						<input id="modify-img-input" type="file" style="display: none;">
						<label for="modify-img-input" class="modify-img-button" style="position: absolute; display: flex; justify-content: center; align-items: center; top: 0; width: inherit; height: inherit; cursor: pointer; font-size: 1.3rem; opacity: 0;">클릭해서 사진 변경하기</label>
					</div>
					<br>
					<p>댓글 수정</p>
					<input id="replemodify-text" class="form-control" type="text" style="width: 100%;">
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button id="modify" type="button" class="btn btn-primary"
						data-bs-dismiss="modal">수정하기</button>
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">닫기</button>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
