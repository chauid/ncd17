<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>파파고</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/variable/pretendardvariable-dynamic-subset.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<jsp:include page="../../layout/title.jsp" />
	<div style="margin: 20px; width: 600px;">
		<div style="height: 200px; border: 1px solid black;">
			<textarea id="message"
				style="width: 100%; height: 100%; resize: none; border: none;"></textarea>
		</div>
		<div class="input-group">
			<h5>번역할 언어를 선택하세요</h5>
			<select id="lang" class="form-select" style="margin-left: 30px;">
				<option value="ko">한국어</option>
				<option value="en">영어</option>
				<option value="ja">일본어</option>
				<option value="zh-CN">중국어 간체</option>
				<option value="zh-TW">중국어 번체</option>
				<option value="es">스페인어</option>
				<option value="fr">프랑스어</option>
				<option value="de">독일어</option>
				<option value="ru">러시아어</option>
				<option value="vi">베트남어</option>
				<option value="th">태국어</option>
				<option value="id">인도네시아어</option>
			</select>
			<button id="btntrans" type="button" class="btn btn-sm btn-success"
				style="margin-left: 20px;">번역하기</button>
		</div>
		<pre id="result"
			style="height: 200px; border: 1px solid black; margin-top: 20px; font-size: 1.2rem;"></pre>
	</div>
	<script type="text/javascript">
	$("#btntrans").click(function() {
			let message = $("#message").val();
			let lang = $("#lang").val();
			$.ajax({
				url : "/naver/trans",
				type : "post",
				dataType: "json",
				data : {
					message : message,
					lang : lang
				},
				success : function(res) {
					let tranJson = JSON.parse(res.text);
					if(tranJson.message !== undefined) {
						$("#result").html(tranJson.message.result.translatedText);
					}
				}
			});
		});
	</script>
</body>
</html>