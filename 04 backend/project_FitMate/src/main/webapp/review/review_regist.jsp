<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>리뷰 등록</title>
  <meta name="description" content="">
  <meta name="keywords" content="">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
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

  <!-- Main CSS File -->
  <link href="assets/css/main.css" rel="stylesheet">

  <!-- ë´ CSS -->
   <link href="assets/css/review_regist.css" rel="stylesheet">
    
    <!-- CUSTOM CSS -->
  	<link href="assets/css/custom.css" rel="stylesheet">
  <style>
  

  </style>
</head>

<body class="contact-page review_regist ">

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
        <a href="#" class="twitter"><i class="bi bi-balloon-heart">마이페이지</i></a>
        <a href="#" class="facebook"><i class="bi bi-person-plus-fill">회원가입</i></a>
        <a href="#" class="instagram"><i class="bi bi-check">로그인</i></a>
      </div>

    </div>
  </header>

  <main class="main">

    <!-- Page Title -->
    <div>
      <div class="heading">
        <div class="container">
          <div class="row d-flex justify-content-center text-center">
              <h1>운동영상 리뷰</h1>
          </div>
        </div>
      </div>
      <div class="container">
        <form id="postForm">
            <div class="form-group">
                <input type="text" id="title" name="title"  placeholder="제목" required>
            </div>
            <div class="form-group">
                <textarea id="content" name="content" placeholder="내용" required></textarea>
            </div>
            <div class="form-group">
                <button type="submit">제출하기</button>
                <button type="submit" class="return">취소</button>
            </div>
        </form>
        <div id="result"></div>
    </div>
    </section><!-- /Contact Section -->

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
        Made by <a href="https://bootstrapmade.com/">정표 * 종수 * 연주</a>
      </div>
    </div>
  </footer>

  <!-- Scroll Top -->
  <a href="#" id="scroll-top" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>

  <!-- Main JS File -->
  <script src="assets/js/main.js"></script>
  <script src="assets/js/reviewmovie.js"></script>

</body>

</html>