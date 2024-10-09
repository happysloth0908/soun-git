<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

  <!-- Header Include -->
  <%@ include file="/header.jsp" %>

<!DOCTYPE html>
<html lang="en">


  <main class="main review-detail">

    <!-- Page Title -->
    <div class="main-review-container page_container">
	    <div class="page-title" data-aos="fade">
	      <div class="heading">
	        <div class="container">
	          <div class="row d-flex justify-content-start text-center">
	            <div class="col-lg-8">
	              <h2>ㅡ</h2>
	            </div>
	          </div>
	        </div>
	      </div>
	      <!-- <nav class="breadcrumbs"> -->
	      <!-- </nav> -->
	    </div><!-- End Page Title -->
	
	   
	    <section id="content contact" class="contact ">
	      <div class="container" data-aos="fade-up" data-aos-delay="100">
	        <form action="forms/contact.php" method="post" class="php-email-form" data-aos="fade-up" data-aos-delay="300">
	          <div class="contents-box row gy-4">
	            <div class="col-md-12">
	              <div class="review-tit form-control" name="내용입력." rows="6" >
	                <span>${board.title}</span>
	                <span>${board.user_id} | ${board.regTime} | 조회수 ${board.view_cnt} </span>
	              </div>
	              <div class="review-con form-control" name="추천" rows="6" >${board.content}</div>
	              <div class="col-md-12"> </div>
	        </form><!-- End Contact Form -->
	      </div>
	    </section><!-- /Contact Section -->
        <div class="container btns">
            <a href="${pageContext.request.contextPath}/board?action=delete&review_id=${board.review_id}" class="리뷰삭제" style="float: right;"> <button class="삭제버튼 btn-w">삭제</button></a></li>
            <a style="" href="${pageContext.request.contextPath}/board?action=updateForm&review_id=${board.review_id}"class="리뷰생성" style="float: right;"> <button class="수정버튼 btn-w" >수정하기</button></a></li>
            <a href="${pageContext.request.contextPath}/video?action=videoDetail&video_id=${board.video_id}" class="목록 list-btn" style="float: left;"> <button class="목록버튼 btn-w">리뷰목록</button></a></li>
        </div>
    </div>
  </main>

  <%@ include file="/footer.jsp" %>


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

</body>

</html>