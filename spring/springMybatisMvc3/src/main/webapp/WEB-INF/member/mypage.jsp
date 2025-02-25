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

.profilelargephoto {
	width: 150px;
	height: 150px;
	border: 1px solid gray;
	border-radius: 100px;
}

.changecamera {
	position: relative;
	cursor: pointer;
	font-size: 1.5em;
	left: -30px;
	top: 50px;
}
</style>
</head>
<body>
	<jsp:include page="../../layout/title.jsp" />
	<div style="margin: 30px 100px;">
		<img src="${dto.mphoto}" class="profilelargephoto"
			onerror="this.src='../save/noimage.png'"> <input type="file"
			id="fileupload" style="display: none;"> <i
			class="bi bi-camera-fill changecamera"></i>
		<script>
		$(".changecamera").click(function(){
			$("#fileupload").trigger("click");
		});
		
		//사진변경 이벤트
		$("#fileupload").change(function(e){
			let form=new FormData();
			form.append("upload",e.target.files[0]);
			form.append("num",${dto.num});
			
			$.ajax({
				type:"post",
				dataType:"text",
				data:form,
				url:"./changephoto",
				processData:false,
				contentType:false,
				success:function(){
					location.reload();
				}
			});
		});
	</script>
		<div style="display: inline-block; margin: 20px 50px;">
			<h6>회원명 : ${dto.mname}</h6>
			<h6>아이디 : ${dto.myid}</h6>
			<h6>핸드폰 : ${dto.mhp}</h6>
			<h6>주소 : ${dto.maddr}</h6>
			<h6>
				가입일 :
				<fmt:formatDate value="${dto.gaipday}" pattern="yyyy-MM-dd HH:mm" />
			</h6>
			<br> <br>
			<button type="button" class="btn btn-sm btn-danger"
				onclick="memberdel(${dto.num})">회원탈퇴</button>

			<script>
			function memberdel(num){
				let ans=confirm("정말 탈퇴하시겠습니까?");
				if(ans){
					$.ajax({
						type:"get",
						dataType:"text",
						data:{"num":num},
						url:"./mypagedel",
						success:function(){
							location.href='../';
						}
					});
				}
			}
		</script>
			<button type="button" class="btn btn-sm btn-primary"
				data-bs-toggle="modal" data-bs-target="#updateModal">회원정보
				수정</button>
		</div>
		<div class="modal fade" id="updateModal" tabindex="-1"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="staticBackdropLabel">회원정보 수정</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<form action="./update" method="post">
						<div class="modal-body">
							<div class="row mb-3">
								<label for="mname" class="col-sm-2 col-form-label">회원명</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="mname"
										value="${dto.mname}">
								</div>
							</div>
							<div class="row mb-3">
								<label for="mhp" class="col-sm-2 col-form-label">핸드폰</label>
								<div class="col-sm-10">
									<input type="tel" class="form-control" id="mhp"
										value="${dto.mhp}">
								</div>
							</div>
							<div class="row mb-3">
								<label for="maddr" class="col-sm-2 col-form-label">주소</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="maddr"
										value="${dto.maddr}">
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">닫기</button>
							<button id="submit-update" type="button" class="btn btn-primary">수정</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<script>
			$("#submit-update").click(function(){
                let mname=$("#mname").val();
                let mhp=$("#mhp").val();
                let maddr=$("#maddr").val();
                $.ajax({
                    type:"post",
                    dataType:"text",
                    data:{"mname":mname,"mhp":mhp,"maddr":maddr, "num":${dto.num}},
                    url:"./update",
                    success:function(){
                        location.reload();
                    }
                });
            });
		</script>
	</div>
</body>
</html>

















