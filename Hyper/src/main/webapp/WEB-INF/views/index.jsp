<%@page import="com.min.app.dto.User_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<title>Hyper Layout</title>
<style type="text/css">
body {
	background: #222;
	/* 	background-image: */
	/* 		url("https://images.unsplash.com/photo-1461783436728-0a9217714694?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2100&q=80"); */
	/* 	background-repeat: no-repeat; */
	/* 	background-position: top center; */
	/* 	background-size: cover; */
}

#container {
	position: absolute;
	top: 50%;
	left: 50%;
	width: 700px;
	height: 500px;
	margin: -250px 0 0 -350px;
	vertical-align: middle;
}
</style>
<link type="text/css" rel="stylesheet"
	href="./resources/css/modeBox.css">
<link type="text/css" rel="stylesheet"
	href="./resources/css/widgetBox.css">
<link type="text/css" rel="stylesheet"
	href="./resources/css/widgetBoxArea.css">
<link type="text/css" rel="stylesheet"
	href="./resources/css/linkBox.css">
<link type="text/css" rel="stylesheet"
	href="./resources/css/searchBox.css">
<link
	href="https://fonts.googleapis.com/css?family=Lobster&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap"
	rel="stylesheet">

</head>
<script src="https://kit.fontawesome.com/3ab76b56de.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<%
	User_Dto Ldto = (User_Dto) session.getAttribute("Ldto");

%>
<body onkeydown="modeChange()">
	<%
		if (Ldto == null) { // 비회원이라면
	%>
	<jsp:include page="./layout/widgetBox.jsp" />
	<jsp:include page="./layout/widgetBoxArea.jsp" />

	<%
		} else { // 회원이라면
	%>
	<jsp:include page="./layout/widgetBoxLogin.jsp" />
	<jsp:include page="./layout/widgetBoxArea.jsp" />
	<a href="./fileup">파일업로드 하러가기</a>

	<%
		}
	%>
	<jsp:include page="./layout/modeBox.jsp" />
	<div id="container">
		<jsp:include page="./layout/linkBox.jsp" />
		<jsp:include page="./layout/searchBox.jsp" />
	</div>

</body>
<script type="text/javascript" src="./resources/js/hotkey.js"></script>
<script type="text/javascript" src="./resources/js/widget.js"></script>
<script type="text/javascript" src="./resources/js/signup.js"></script>
<script type="text/javascript" src="./resources/js/signin.js"></script>
</html>