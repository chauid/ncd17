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
        
        img.large{
        	width: 300px;
        	height:350px;
        	border: 2px solid black;
        }
        
        img.small{
        	cursor: pointer;
        	width: 80px;
        	height: 80px;
        	border: 1px solid gray;
        	margin: 10px;
        }
        
        .colorbox{
        	display: inline-block;
        	width:30px;
        	height: 30px;
        	border: 1px solid black;
        	border-radius: 100px;
        }
        
        #photoupload{
        	display: none;
        }
        
        .addphoto{
        	font-size: 1.5em;
        	cursor: pointer; 
        	margin-left: 10px;   
        	margin-right: 10px;       	
        }
        
        .replelist{
        	margin: 10px 10px;
        }
     </style>
     <script type="text/javascript">     	
     	let file;
     	$(function(){
     		replelist();//처음 로딩시 댓글 출력
     		
     		//카메라 아이콘 이벤트
     		$(".addphoto").click(function(){
     			$("#photoupload").trigger("click");
     		});
     		//파일 업로드 이벤트
     		$("#photoupload").change(function(e){
     			file=e.target.files[0];
     			console.log(file);
     		});
     		//댓글 등록버튼 이벤트
     		$("#btnaddreple").click(function(){     			
     			let m=$("#message").val();
     			if(m==''){
     				alert("댓글을 입력해주세요");
     				return;
     			}
     			
     			if(file==null){
     				alert("사진을 선택해주세요");
     				return;
     			}
     			let form=new FormData();
     			console.log(file);
     			form.append("upload",file);
     			form.append("message",m);
     			form.append("num",${dto.num});
     			
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
     		
     	});
     	
     	function replelist()
     	{
     		
     	}
     </script>
</head>
<body>
<div style="margin: 20px;width: 500px;">
	<table>
		<tr>
			<td width="120">
				<c:forTokens var="photo" items="${dto.sphoto}" delims=",">
					<img src="../save/${photo}" class="small">
					
					<script type="text/javascript">
						$("img.small").click(function(){
							$("img.large").attr("src",$(this).attr("src"));
						});
					</script>
				</c:forTokens>
			</td>
			<td>
				<img src="../save/${dto.mainPhoto}" class="large"
				onerror="this.src='../save/noimage.png'">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div style="margin: 20px 100px;font-size: 17px;">
					<mark>상품명 : ${dto.sangpum}</mark><br>
					가 격 : <fmt:formatNumber value="${dto.sprice}" type="number"/>원<br>
					색 상 : ${dto.scolor}
					 <div class="colorbox"
					 style="background-color: ${dto.scolor}"></div>
					<br>
					입고일 : ${dto.ipgoday}<br>
					등록일 : <fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/>
				</div>
			</td>		
		</tr>
		<tr>
			<td colspan="2">
				<div class="repleform input-group" style="width: 600px;">
				  	<input type="text" id="message" class="form-control"
				  	style="width: 400px;" placeholder="댓글입력">
				  	
				  	<input type="file" id="photoupload">
				  	<i class="bi bi-camera-fill addphoto"></i>
				  	<button type="button" class="btn btn-sm btn-info" id="btnaddreple">등록</button>
				</div>
				<div class="replelist">
				
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" class="btn btn-sm btn-outline-secondary"
				style="width: 90px;"
				onclick="location.href='./addform'">상품등록</button>
				
				<button type="button" class="btn btn-sm btn-outline-secondary"
				style="width: 90px;"
				onclick="location.href='./list'">목록</button>
				
				<button type="button" class="btn btn-sm btn-outline-secondary"
				style="width: 90px;"
				onclick="location.href='updateform?num=${dto.num}'">수정</button>
				
				<button type="button" class="btn btn-sm btn-outline-secondary"
				style="width: 90px;"
				onclick="sangdel(${dto.num})">삭제</button>
				
				<script type="text/javascript">
					function sangdel(num)
					{
						//alert(num);
						let ans=confirm("해당 게시물을 삭제하려면 [확인]을 눌러주세요");
						if(ans){
							location.href="./delete?num="+num;
						}
					}
				</script>
				
				<button type="button" class="btn btn-sm btn-outline-secondary"
				style="width: 90px;"
				onclick="location.href='photos?num=${dto.num}'">사진수정</button>
				
			</td>
		</tr>
	</table>
</div>
</body>
</html>














