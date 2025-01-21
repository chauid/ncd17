<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="module" src="../components/back-button.js"></script>
<title>502 study</title>
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
	rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
body * {
	font-family: 'Jua';
}
</style>
<body>
	<h1>Hello</h1>
	<%!int a = 10;%>
	<%
	for (int i = 0; i < 5; i++) {
		out.println("Hello JSP<br />" + a++);
	}

	String search = request.getParameter("search");
	if (search != null) {
		out.println("search: " + search);
	}
	if (search != null) {
		out.println("search: " + search);
	}
	%>
	<form action="ex1_start.jsp" method="get">
		<input type="text" name="search" value="<%=search%>" /> <input type="submit" value="search" />
	</form>
</body>
</html>
