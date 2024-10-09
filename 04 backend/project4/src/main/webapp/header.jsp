<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>${pageTitle != null ? 'FitMate - ' + pageTitle : 'FitMate'}</title>
<meta name="description" content="">
<meta name="keywords" content="">

<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

 <!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Fonts -->
<link href="https://fonts.googleapis.com" rel="preconnect">
<link href="https://fonts.gstatic.com" rel="preconnect" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Cardo:ital,wght@0,400;0,700;1,400;1,700&display=swap"
	rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT@2/fonts/variable/woff2/SUIT-Variable.css" rel="stylesheet">


<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
	
	<!-- 
<link href="assets/vendor/aos/aos.css" rel="stylesheet"> --> 
<link href="assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

<!-- Main CSS File -->
<link href="assets/css/main.css" rel="stylesheet">
<link href="assets/css/reset.css" rel="stylesheet">

<!-- CUSTOM CSS -->
<link href="assets/css/custom.css" rel="stylesheet">
<link href="assets/css/review_list.css" rel="stylesheet">

<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

</head>
<body class="main contact-page">

	<header id="header" class="header d-flex align-items-center sticky-top">
		<div
			class="container-fluid position-relative d-flex align-items-center justify-content-between">

			<a href="${contextPath}/main"
				class="logo d-flex align-items-center me-auto me-xl-0"> <i
				class="bi bi-twitter-x"></i>
				<h1 class="sitename">FitMate</h1>
			</a>

			<nav id="navmenu" class="navmenu">
				<ul>
					<li><a href="${contextPath}/main" class="active">Home<br></a></li>
					<li><a href="#none">운동 추천</a></li>
					<li><a href="#nonel">다이어트 정보</a></li>
					<li><a href="#nonel">커뮤니티</a></li>
					<li class="dropdown"><a href="#none"><span>운동
								영상</span> <i class="bi bi-chevron-down toggle-dropdown"></i></a>
						<ul>
							<li><a href="#none">상체집중</a></li>
							<li><a href="#none">하체집중</a></li>
							<li><a href="#none">전신근력향상</a></li>
							<li><a href="#none">뱃살집중타파</a></li>
							<li><a href="#none">유산소</a></li>
							<li><a href="#none">스트레칭</a></li>
						</ul></li>
				</ul>
				<i class="mobile-nav-toggle d-xl-none bi bi-list"></i>
			</nav>

			<div class="header-social-links">
				<c:choose>
					<c:when test="${empty sessionScope.userInfo}">
						<a href="${contextPath}/user?action=signupForm" class="facebook"><i
							class="bi bi-person-plus-fill"></i>회원가입</a>
						<a href="${contextPath}/user?action=loginForm" class="instagram"><i
							class="bi bi-check"></i>로그인</a>
					</c:when>
					<c:otherwise>
						<a href="${contextPath}/user?action=myPage" class="twitter"><i
							class="bi bi-balloon-heart"></i>마이페이지</a>
						<a href="${contextPath}/user?action=logout">로그아웃</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</header>