<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
  <!-- Header Include -->
  <%@ include file="/header.jsp" %>

<!-- <head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>리뷰 작성</title>
  <meta name="description" content="">
  <meta name="keywords" content="">

  Favicons
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  Fonts
  <link href="https://fonts.googleapis.com" rel="preconnect">
  <link href="https://fonts.gstatic.com" rel="preconnect" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Inter:wght@100;200;300;400;500;600;700;800;900&family=Cardo:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">

  Vendor CSS Files
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  Main CSS File
  <link href="assets/css/main.css" rel="stylesheet">
    
    CUSTOM CSS
  	<link href="assets/css/custom.css" rel="stylesheet">
</head>

<body class="contact-page">

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
  </header> -->

  <main class="main review_update">

    <!-- Page Title -->
    <div class="page-title" data-aos="fade">
      <div class="heading">
        <div class="container">
          <div class="row d-flex justify-content-center text-center">
            <div class="col-lg-8">
              <h1>리뷰 수정하기</h1>
            </div>
          </div>
        </div>
      </div>
      
     
    </div><!-- End Page Title -->

   
    <section id="contact" class="contact section">

      <div class="container" data-aos="fade-up" data-aos-delay="100">

        

        <form action="${contextPath}/board" method="post">
        	<input type="hidden" name="action" value="update"/>
        	<input type="hidden" name="review_id" value="${board.review_id}"/>
          	<div class="row gy-4">
            <div class="col-md-12">
              	<!-- <textarea class="form-control" name="내용입력." rows="6" placeholder="와~효과만점 운동 영상입니다." required=""></textarea> -->
              	<textarea id="user_idtitle" class="form-control" name="title" rows="6" >${board.title}</textarea>
              	 <span id="titleCharCount" style="color: black;">공백 포함 0 / 100 자</span>
                <p id="titleWarningMessage" style="color: red; display: none;">최대 100자까지 입력할 수 있습니다.</p>
            </div>
            <div class="col-md-12">
              	<textarea id="content" class="form-control" name="content" rows="6" >${board.content}</textarea>
              	<span id="contentCharCount" style="color: black;">공백 포함 0 / 300 자</span>
            <p id="contentWarningMessage" style="color: red; display: none;">최대 300자까지 입력할 수 있습니다.</p>
            </div>
          	
             <!--<button type="button" onclick="location.href='${contextPath}/board?action=update&review_id=${board.review_id}'" class="수정버튼">수정</button>
          -->
          	<div class="button-group">
		        <button class="button" type="submit">수정</button>
            	<button class="button" type="button" onclick="location.href='${contextPath}/board?action=detail&review_id=${board.review_id}'" class="취소버튼">취소</button>
            </div>
            
          </div>
        </form><!-- End Contact Form -->

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

  <!-- Preloader -->

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>

  <!-- Main JS File -->
  <script src="assets/js/main.js"></script>

<script>
document.addEventListener('DOMContentLoaded', function() {
  var titleInput = document.getElementById('user_idtitle');
  var charCount = document.getElementById('titleCharCount');
  var warningMessage = document.getElementById('titleWarningMessage');
  
  titleInput.addEventListener('input', function() { // 사용자가 입력할 때마다 실행됨. 
    this.value = this.value.slice(0, 100); // 100자로 잘라냄
    var remainingChars = 100 - this.value.length;
    charCount.textContent = '공백 포함 ' + this.value.length + ' / 100 자';

    if (remainingChars <= 0) {
    	titleWarningMessage.style.display = 'block';
    } else {
    	titleWarningMessage.style.display = 'none';
    }
  });

  document.getElementById('postForm').addEventListener('submit', function(e) { // 무결성을 위해 추가
    if (titleInput.value.length > 100) {
      e.preventDefault();
      alert('제목은 100자를 초과할 수 없습니다.');
    }
  });
});
</script>
<!-- content excess warning -->
<script>
document.addEventListener('DOMContentLoaded', function() {
  var contentInput = document.getElementById('content');
  var contentCharCount = document.getElementById('contentCharCount');
  var contentWarningMessage = document.getElementById('contentWarningMessage');

  contentInput.addEventListener('input', function() { // 사용자가 입력할 때마다 실행됨. 
	 this.value = this.value.slice(0, 300); // 300자로 잘라냄
    var contentRemainingChars = 300 - this.value.length;
    contentCharCount.textContent = '공백 포함 ' + this.value.length + ' / 300 자';

    if (contentRemainingChars <= 0) {
    	contentWarningMessage.style.display = 'block';

    } else {
    	contentWarningMessage.style.display = 'none';
    }
  });

  document.getElementById('postForm').addEventListener('submit', function(e) { // 무결성을 위해 추가
    if (contentInput.value.length > 300) {
      e.preventDefault();
      alert('내용은 300자를 초과할 수 없습니다.');
    }
  });
});
</script>

</body>

</html>