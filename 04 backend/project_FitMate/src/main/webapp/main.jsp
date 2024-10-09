<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>FitMate</title>
  <meta name="description" content="">
  <meta name="keywords" content="">

  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Fonts -->
  <link href="https://fonts.googleapis.com" rel="preconnect">
  <link href="https://fonts.gstatic.com" rel="preconnect" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Cardo:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
  <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
  
  <!-- Main CSS File -->
  <link href="assets/css/main.css" rel="stylesheet">
  <link href="assets/css/reset.css" rel="stylesheet">
  
  <!-- CUSTOM CSS -->
  <link href="assets/css/custom.css" rel="stylesheet">
  
</head>
<body class="main">
	<header>
		<nav>
			<ul>
			<c:choose>
				<c:when test="${empty sessionScope.memberInfo}">
					<li><a href="${contextPath}/member?action=loginForm">로그인</a></li>
					<li><a href="${contextPath}/member?action=joinForm">회원가입</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="">마이페이지</a></li>
					<li><a href="${contextPath}/member?action=logout">로그아웃</a></li>
				</c:otherwise>
			</c:choose>
			
			</ul>	
		</nav>
	</header>
	
	<h2>대전 4반 - 메인 페이지</h2>
	<div>
		<a href="${contextPath}/review?action=list">게시판 이동</a>
<%-- 		<a href="${contextPath}/board?action=list">게시판 이동</a> --%>
	</div>
	
	<!--   -->
	
	 <header id="header" class="header d-flex align-items-center sticky-top">
    <div class="container-fluid position-relative d-flex align-items-center justify-content-between">

      <a href="index.html" class="logo d-flex align-items-center me-auto me-xl-0">
        <i class="bi bi-twitter-x"></i>
        <h1 class="sitename">FitMate</h1>
      </a>

      <nav id="navmenu" class="navmenu">
        <ul>
          <li><a href="index.html" class="active">Home<br></a></li>
          <li><a href="about.html">운동 추천</a></li>
          <li><a href="about.html">다이어트 정보</a></li>
          <li><a href="about.html">커뮤니티</a></li>
          <li class="dropdown"><a href="gallery.html"><span>운동 영상</span> <i class="bi bi-chevron-down toggle-dropdown"></i></a>
            <ul>
              <li><a href="gallery.html">웨이트</a></li>
              <li><a href="gallery.html">유산소</a></li>
              <li><a href="gallery.html">홈 필라테스</a></li>
              <li><a href="gallery.html">커플 운동</a></li>
            </ul>
          </li>
        </ul>
        <i class="mobile-nav-toggle d-xl-none bi bi-list"></i>
      </nav>

      <div class="header-social-links">
        <a href="./gpt_follow.html" class="twitter"><i class="bi bi-balloon-heart"></i>마이페이지</a>
        <a href="./gpt_sign_and_login copy.html" class="facebook"><i class="bi bi-person-plus-fill"></i>회원가입</a>
        <a href="./gpt_login.html" class="instagram"><i class="bi bi-check"></i>로그인</a>
      </div>
    </div>
  </header>

  <main class="main">

    <!-- Hero Section -->
    <section id="hero" class="hero">

      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-6 text-center" data-aos="fade-up" data-aos-delay="100">
            <h2 style="margin-bottom: 30px; position: relative; z-index: 10;"><span>당신을 위한</span> 운동 메이트<br><span class="underlight">FixMate</span></span></h2>
            <a style="position: relative; z-index: 10;" href="#none" class="btn-get-started">운동 시작하기<br></a>
          </div>
        </div>
      </div>
    </section><!-- /Hero Section -->

    <!-- Gallery Section -->
    <section id="gallery" class="gallery section">
      <div class="container-fluid" data-aos="fade-up" data-aos-delay="100">
        <div class="section row gy-4 justify-content-center">
          <h3 class="content-title">오늘의 운동 추천</h3>
          <div id="video-list" class="video-container"></div>
        </div>
        <div class="section row gy-4 justify-content-center">
          <h3 class="content-title">찜한 영상</h3>
          <div class="select-vedios col-xl-3 col-lg-4 col-md-6">
            <div class="swiper mySwiper">
              <div class="swiper-wrapper">
                <div class="swiper-slide">
                  <div class="gallery-item h-100">
                    <iframe width="560" height="360" src="https://www.youtube.com/embed/50WCSpZtdmA?si=tPMOc_AdLb0RujuT" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                    <h4>심으뜸의 영상</h4>
                    <p>집에서 하는 유연한 운동</p>
                    <div class="gallery-links d-flex align-items-center justify-content-center">
                      <a href="assets/img/gallery/gallery-2.jpg" title="Gallery 2" class="glightbox preview-link"><i class="bi bi-arrows-angle-expand"></i></a>
                      <a href="gallery-single.html" class="details-link"><i class="bi bi-link-45deg"></i></a>
                      <a href="gallery-single.html" class="details-link"><i class="bi bi-heart"></i></a>
                    </div>
                  </div>
                </div>
                <div class="swiper-slide">
                  <div class="gallery-item h-100">
                    <iframe width="560" height="360" src="https://www.youtube.com/embed/50WCSpZtdmA?si=tPMOc_AdLb0RujuT" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                    <h4>심으뜸의 영상</h4>
                    <p>집에서 하는 유연한 운동</p>
                    <div class="gallery-links d-flex align-items-center justify-content-center">
                      <a href="assets/img/gallery/gallery-2.jpg" title="Gallery 2" class="glightbox preview-link"><i class="bi bi-arrows-angle-expand"></i></a>
                      <a href="gallery-single.html" class="details-link"><i class="bi bi-link-45deg"></i></a>
                      <a href="gallery-single.html" class="details-link"><i class="bi bi-heart"></i></a>
                    </div>
                  </div>
                </div>
                <div class="swiper-slide">
                  <div class="gallery-item h-100">
                    <iframe width="560" height="360" src="https://www.youtube.com/embed/50WCSpZtdmA?si=tPMOc_AdLb0RujuT" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                    <h4>심으뜸의 영상</h4>
                    <p>집에서 하는 유연한 운동</p>
                    <div class="gallery-links d-flex align-items-center justify-content-center">
                      <a href="assets/img/gallery/gallery-2.jpg" title="Gallery 2" class="glightbox preview-link"><i class="bi bi-arrows-angle-expand"></i></a>
                      <a href="gallery-single.html" class="details-link"><i class="bi bi-link-45deg"></i></a>
                      <a href="gallery-single.html" class="details-link"><i class="bi bi-heart"></i></a>
                    </div>
                  </div>
                </div>
                <div class="swiper-slide">
                  <div class="gallery-item h-100">
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/50WCSpZtdmA?si=tPMOc_AdLb0RujuT" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                    <h4>심으뜸의 영상</h4>
                    <p>집에서 하는 유연한 운동</p>
                    <div class="gallery-links d-flex align-items-center justify-content-center">
                      <a href="assets/img/gallery/gallery-2.jpg" title="Gallery 2" class="glightbox preview-link"><i class="bi bi-arrows-angle-expand"></i></a>
                      <a href="gallery-single.html" class="details-link"><i class="bi bi-link-45deg"></i></a>
                      <a href="gallery-single.html" class="details-link"><i class="bi bi-heart"></i></a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="swiper-pagination"></div>
            </div>
          </div>
        </div>
      </div>

    </section><!-- /Gallery Section -->

  </main>
	
  <footer id="footer" class="footer">
    <div class="container">
      <div class="copyright text-center ">
        <p>FitMate로 건강해지는 생활</p>
      </div>
      <div class="social-links d-flex justify-content-center">
        <a href=""><i class="bi bi-twitter-x"></i></a>
        <a href=""><i class="bi bi-facebook"></i></a>
        <a href=""><i class="bi bi-instagram"></i></a>
        <a href=""><i class="bi bi-linkedin"></i></a>
      </div>
      <div class="credits">
        Made by <a href="https://bootstrapmade.com/">정표 * 소운 * 연주</a>
      </div>
    </div>
  </footer>

  <!-- Scroll Top -->
  <a href="#" id="scroll-top" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Preloader 
  <div id="preloader">
    <div class="line"></div>
  </div> -->

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>

  <!-- Main JS File -->
  <script src="assets/js/main.js"></script>
  <script src="app.js"></script>


  <script>
    var swiper = new Swiper(".mySwiper", {
      slidesPerView: 3.5,
      spaceBetween: 30,
      freeMode: true,
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
    });
  </script>
	
</body>
</html>






