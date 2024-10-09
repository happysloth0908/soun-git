<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ include file="/header.jsp" %>

  <main class="main review_regist ">

    <!-- Page Title -->
    <div>
      <div class="heading">
        <div class="container">
          <div class="row d-flex justify-content-center text-center">
              <h2 class="content-title">운동영상 리뷰</h2>
          </div>
        </div>
      </div>
      <div class="container">
        <form id="postForm" action="${contextPath}/board" method= "POST">
        <input type="hidden" name="action" value="write">
        <input type="hidden" name="videoIDR" value="${videoIDF}" readonly />
        <div class="video-title-container">
        	<h3>${videoTitle}</h3>
        </div>
            <div class="form-group">
                <input type="text" id="user_idtitle" name="title"  placeholder="제목" maxlength='100' required >
                <span id="titleCharCount" style="color: black;">공백 포함 0 / 100 자</span>
                <p id="titleWarningMessage" style="color: red; display: none;">최대 100자까지 입력할 수 있습니다.</p>
                
            </div>
            <div class="form-group">
                <textarea id="content" name="content" placeholder="내용" maxlength='330' required></textarea>
            <span id="contentCharCount" style="color: black;">공백 포함 0 / 300 자</span>
            <p id="contentWarningMessage" style="color: red; display: none;">최대 300자까지 입력할 수 있습니다.</p>
            </div>
            <div class="form-group button-group">
                 <button class="button">등록</button>
                <button onclick="history.back()" class="button">취소</button>
            </div>
        </form>
        <div id="result"></div>
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

<!-- tittle excess warning -->
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