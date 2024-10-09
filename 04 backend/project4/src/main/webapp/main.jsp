<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!-- Header Include -->
<%@ include file="/header.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
  <main class="main">

    <!-- Hero Section -->
    <section id="hero" class="hero">

      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-6 text-center">
            <h2 class="visual-tit" style="margin-bottom: 30px; position: relative; z-index: 10;"><span>당신을 위한</span> 운동 메이트<br><strong class="underlight">FitMate</strong></h2>
          		<c:choose>
          			<c:when test="${not empty sessionScope.userInfo}">
          				<c:choose>
          					<c:when test="${not empty part}">
		            			<span class="visual-sub-tit">${sessionScope.userInfo.id}님, 오늘은 <a style="position: relative; z-index: 10;" href="#none" id="scroll-down" class="btn-get-started"><strong>${part}</strong>운동</a>으로 함께해요!</span>
		          				<span class="visual-sub-tit">Let's Get it!</span>
          					</c:when>
          					<c:otherwise>
          						<span class="visual-sub-tit">${sessionScope.userInfo.id}님, 이번 한 주는 <a style="position: relative; z-index: 10;" href="${contextPath}/user?action=myPage" class="btn-get-started"><strong>어떤 </strong>운동</a>을 하셨나요?</span>
		          				<span class="visual-sub-tit">Let's Get it!</span>
          					</c:otherwise>
          				</c:choose>
          			</c:when>
          			<c:otherwise>
          			</c:otherwise>
          		</c:choose>
          </div>
        </div>
      </div>
    </section><!-- /Hero Section -->

    <!-- Gallery Section -->
    <section id="gallery" class="gallery section">
      <div class="contents container-fluid">
        <div class="popular row gy-4 justify-content-center">
          <h3 class="content-title">인기 영상</h3>
          <span class="sub-title">많은 회원님들이 보고 계신 영상</span>
          <div class="swiper mySwiper2">
          	<div class="swiper-wrapper">
	          <c:forEach var="v" items="${videos}">
		         <div id="video-list" class="video-container swiper-slide">
		         	<div class="txt-box">
			         	<h3><a href="${contextPath}/video?action=videoDetail&video_id=${v.video_id}">${v.title}</a></h3>
						<p>${v.channel} - ${v.part}</p>
						<span>조회수 ${v.view_cnt}</span>
		         	</div>
					<iframe src="${v.src}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		         </div>
			  </c:forEach>
			  
          	</div>
			  <div class="swiper-navigation">
			    <div class="swiper-button-prev"></div>
			    <div class="swiper-button-next"></div>
			  </div>
			  <div class="swiper-pagination1"> </div>
          </div>
		</div>
		
        <div id="parts1" class="section parts row gy-4 justify-content-center">
          <h3 class="content-title">부위별 영상</h3>
          <ul class="tab-menu">
          	<li class="active">상체집중</li>
          	<li>하체집중</li>
          	<li>전신근력향상</li>
          	<li>뱃살집중타파</li>
          	<li>유산소</li>
          	<li>스트레칭</li>
          </ul>
          <div class="parts-vedios">
            <div class="swiper mySwiper">
                <div class="swiper-wrapper">
                  <c:forEach var="v" items="${upperVideos}">
                    <div id="video-list" class="active upperVideos video-container swiper-slide">
                    <div class="txt-box">
	                    <h3><a href="${contextPath}/video?action=videoDetail&video_id=${v.video_id}">${v.title}</a></h3>
	                    <p>${v.channel} - ${v.part}</p>
                    </div>
                    <iframe src="${v.src}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </div>
                  </c:forEach>
                  <c:forEach var="v" items="${lowerVideos}">
                    <div id="video-list" class="lowerVideos video-container swiper-slide">
                    <div class="txt-box">
	                    <h3><a href="${contextPath}/video?action=videoDetail&video_id=${v.video_id}">${v.title}</a></h3>
	                    <p>${v.channel} - ${v.part}</p>
                    </div>
                    <iframe src="${v.src}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </div>
                  </c:forEach>
                  <c:forEach var="v" items="${wholeVideos}">
                    <div id="video-list" class="wholeVideos video-container swiper-slide">
                    <div class="txt-box">
	                    <h3><a href="${contextPath}/video?action=videoDetail&video_id=${v.video_id}">${v.title}</a></h3>
	                    <p>${v.channel} - ${v.part}</p>
                    </div>
                    <iframe src="${v.src}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </div>
                  </c:forEach>
                  <c:forEach var="v" items="${abdomanVideos}">
                    <div id="video-list" class="abdomanVideos video-container swiper-slide">
                    <div class="txt-box">
	                    <h3><a href="${contextPath}/video?action=videoDetail&video_id=${v.video_id}">${v.title}</a></h3>
	                    <p>${v.channel} - ${v.part}</p>
                    </div>
                    <iframe src="${v.src}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </div>
                  </c:forEach>
                  <c:forEach var="v" items="${cardioVideos}">
                    <div id="video-list" class="cardioVideos video-container swiper-slide">
                    <div class="txt-box">
	                    <h3><a href="${contextPath}/video?action=videoDetail&video_id=${v.video_id}">${v.title}</a></h3>
	                    <p>${v.channel} - ${v.part}</p>
                    </div>
                    <iframe src="${v.src}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </div>
                  </c:forEach>
                  <c:forEach var="v" items="${stretchVideos}">
                    <div id="video-list" class="stretchVideos video-container swiper-slide">
                    <div class="txt-box">
	                    <h3><a href="${contextPath}/video?action=videoDetail&video_id=${v.video_id}">${v.title}</a></h3>
	                    <p>${v.channel} - ${v.part}</p>
                    </div>
                    <iframe src="${v.src}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </div>
                  </c:forEach>
                </div>
              </div>

            </div>
          </div>
          
          
        </div>
      </div>

    </section><!-- /Gallery Section -->

  </main>

  <!-- Footer Include -->
  <%@ include file="/footer.jsp" %>

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
  
  <!--<script src="assets/js/app.js"></script>-->


  <script>
    var swiper = new Swiper(".mySwiper", {
      slidesPerView: 3.5,
      spaceBetween: 30,
      freeMode: true,
      pagination: {
        el: ".swiper-pagination1",
        clickable: true,
      },
      navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
      },
    });
    
    var swiper = new Swiper(".mySwiper2", {
    	loop : true,	
        effect: "coverflow",
        grabCursor: true,
        centeredSlides: true,
        initialSlide: -1,
        // slidesPerView: "auto",
        slidesPerView: "3",

        coverflowEffect: {
          rotate: 50,
          stretch: 0,
          depth: 100,
          modifier: 1,
          slideShadows: true,
        },
        pagination: {
          el: ".swiper-pagination2",
        },
      });
  </script>
	
</body>
</html>






