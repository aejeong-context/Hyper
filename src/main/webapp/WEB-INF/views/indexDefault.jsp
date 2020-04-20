<%@page import="com.min.app.dto.User_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<title>Hyper - 비회원</title>
<link type="text/css" rel="stylesheet" href="./resources/css/layout.css">
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
<script type="text/javascript">
	var theme = '${Sdto.setting_theme}';
	var backgroundImage = '${backImgPath}';
</script>
<script type="text/javascript" src="./resources/js/theme.js"></script>
<script src="https://kit.fontawesome.com/3ab76b56de.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>

<body onkeydown="modeChange()">
	<jsp:include page="layout/default/widgetBoxDefault.jsp" />
	<jsp:include page="layout/default/widgetAreaDefault.jsp" />
	<jsp:include page="component/common/modeBox.jsp" />

	<div id="container">
		<jsp:include page="component/common/linkBox.jsp" />
		<jsp:include page="component/common/searchBox.jsp" />
	</div>

</body>
<script type="text/javascript" defer src="./resources/js/hotkey.js"></script>
<script type="text/javascript" defer src="./resources/js/widget.js"></script>
<script type="text/javascript" defer src="./resources/js/signup.js"></script>
<script type="text/javascript" defer src="./resources/js/signin.js"></script>
</html>