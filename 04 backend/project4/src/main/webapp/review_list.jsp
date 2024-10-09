<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

  <!-- Header Include -->
  <%@ include file="/header.jsp" %>


  <main class="main review_list">
    <!-- Page Title -->
    <div class="page_container" style="">
      <div class="heading">
        <div class="container">
          <div class="row d-flex justify-content-center text-center">
              <h1>운동 영상</h1>
          </div>
        </div>
      </div>
      <div class="page-title" data-aos="fade">
        <div class="heading2">
	          <div class="container">
	            <div class="row d-flex justify-content-center text-center">
	              <div class="video-box col-lg-8">
	                 <iframe width="560" height="420" src="${video.src}" title="${video.title}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
	              </div>
	              <div class="video-info">
		              <div class="txt-box">
		                <h2>${video.title}</h2>
		                <p><em>채널명</em> <span>${video.channel}</span> <span> | <em>조회수</em> ${video.view_cnt}</span></p>
		              </div>
		              <div class="btns">
			            <c:choose>
			            <c:when test="${empty sessionScope.userInfo}">
			            	<button class="heart" onclick="location.href='${contextPath}/user?action=loginForm'"><i class="bi bi-suit-heart"></i></button>
			            </c:when>
			            <c:otherwise>
			            	<button class="heart" onclick="location.href='${contextPath}/user?action=${isLiked ? 'unLike' : 'like'}&video_id=${video.video_id}&action2=videoDetail'"><i class="bi ${isLiked ? 'bi-suit-heart-fill' : 'bi-suit-heart'}"></i></button>
			            </c:otherwise>
			            </c:choose>
			          
		               <c:choose>
	            		<c:when test="${empty sessionScope.userInfo}">
	            			<button class="btn-b" onclick="location.href='${contextPath}/user?action=loginForm'">채널 구독</button>
	            		</c:when>
	            		<c:otherwise>
	            			<button class="btn-b" onclick="location.href='${contextPath}/user?action=${isSubscribed ? 'unSubscribe' : 'subscribe'}&channel=${video.channel}&action2=videoDetail&video_id=${video.video_id}'">${isSubscribed ? '구독 취소' : '채널 구독'}</button>
	            		</c:otherwise>
	            		</c:choose> 
	            		
		              </div>
	              </div>
	              
	            </div>
	          </div>
        </div>
    </div>
    <div class="container review-list-box">
        <ol class="review-head pricing-item d-flex justify-content-between">
          <li style="width: 50%;">제목</li>
          <li style="width: 20%;">작성자</li>
          <li style="width: 10%;">조회수</li>
          <li style="width: 20%;">작성시간</li>
        </ol>
        <c:forEach var="review" items="${list}">
        <ol class="review-data pricing-item d-flex justify-content-between">
            <li class="title" style="width: 50%;"><a href="${contextPath}/board?action=detail&review_id=${review.review_id}">${review.title}</a></li> 
            <li style="width: 20%;">${review.user_id}</li>
            <li style="width: 10%;">${review.view_cnt}</li>
            <li style="width: 20%;">${review.regTime}</li>
        </ol>
        </c:forEach>
    </div>
      <nav class="breadcrumbs">
        <div class="container" id="regist">
        	<c:choose>
        		<c:when test="${empty sessionScope.userInfo}">
        			<button class="btn-w" onclick="location.href='${contextPath}/user?action=loginForm'">댓글 쓰기</button>
        		</c:when>
        		<c:otherwise>        		
            		<button class="btn-w" onclick="location.href='${contextPath}/board?action=writeForm&video_id=${video.video_id}'">댓글 쓰기</button>
        		</c:otherwise>
        	
        	</c:choose>
            <!--   <div class="searchBox">
                <img class="glass" src="/assets/img/glass.png" alt="돋보기"> 
                <input type="text" placeholder="제목으로 검색"> 
            </div>-->
        </div>
      </nav>
    <div class="page-nav">	
        <button style="margin: 20px 10px;">&lt</button>
      <button style="margin: 20px 10px;">&gt</button>
    </div>
    </div>
    
        </form><!-- End Contact Form -->
      </div>

    </section><!-- /Contact Section -->

  </main>

  <!-- Footer Include -->	
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
  <script src="assets/js/reviewmovie.js"></script>

</body>

</html>

