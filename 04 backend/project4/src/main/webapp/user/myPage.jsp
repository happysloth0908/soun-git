<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ include file="/header.jsp" %>
<div class="follow">

    <div class="container" id="followContainer">
        <div class="article">
            <h2 class="content-title">구독중인 채널</h2>
            <ul class="user-list row gy-4" id="userList">
            	<c:choose>
            		<c:when test="${empty subscribe}"><div><h2 class="nothing">구독중인 채널이 없습니다.</h2></div></c:when>
            		<c:otherwise>
		            	<c:forEach var='s' items="${subscribe}">
		            		<li>${s} <button onclick="location.href='${contextPath}/user?action=unSubscribe&channel=${s}'">구독 해제</button></li>
		            	</c:forEach>            		
            		</c:otherwise>
            	</c:choose>
            </ul>
        </div>

        <div style="background: rgba(0, 0, 0, 0);" class="section row gy-4 justify-content-center article">
            <h2 class="content-title">찜한 영상</h2>
            <div class="select-vedios col-xl-3 col-lg-4 col-md-6">
                <c:choose>
                	<c:when test="${empty like}"><h2 class="nothing">찜한 영상이 없습니다.</h2></c:when>
                	<c:otherwise>
		              <div style="height: 520px" class="swiper mySwiper">
		                <div class="swiper-wrapper">
		                <c:forEach var="v" items="${like}">
		                  <div class="swiper-slide">
		                    <div class="gallery-item h-100">
		                      <iframe width="560" height="360" src="${v.src}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
		                      <div class="text-box">
			                      <div>
				                      <h4>${v.channel}</h4>
				                      <p>${v.title}</p>
			                      </div>
			                      <div class="heart-btn gallery-links d-flex align-items-center justify-content-center">
			                        <a href="${contextPath}/user?action=unLike&video_id=${v.video_id}" class="details-link"><i class="bi bi-heart-fill"></i></a>
			                      </div>
		                      </div>
		                    </div>
		                  </div>
		                </c:forEach>                	
		                </div>
		                <div class="swiper-pagination"></div>
		              </div>
                	</c:otherwise>
                </c:choose>
                  
            </div>
        </div>


        <div class="ex-record">
          <h2 class="content-title">나의 운동 기록</h2>
          <form class="ex-record-form" action="${contextPath}/user" mathod="post">
          	<input type="hidden" name="action" value="record"/>
          	<div>
            <fieldset>
              <label for="exDate">날짜 선택</label>
              <input type="date" name="exDate" required="required">
            </fieldset>
            <fieldset>
              <div class="ex-record-add">
                <label for="part">운동 종류</label>
                <select name="part" required="required">
                  <option value="상체">상체</option>
                  <option value="하체">하체</option>
                  <option value="전신">전신</option>
                  <option value="복부">복부</option>
                  <option value="유산소">유산소</option>
                  <option value="스트레칭">스트레칭</option>
                </select>
                <div>
                  <label for="exTime">운동 시간</label>
                  <input type="text" name="exTime" required="required">
              	</div>
              </div>
            </fieldset>
            <button class="button">등 록</button>
          	</div>
          </form>
          <div class="ex-record-list">
          	<table class="ex-record-tbl"> 
				<tr>
					<th>날짜</th>
					<th>운동종류</th>
					<th>운동시간(분)</th>
				</tr>
			<c:choose>
				<c:when test="${empty exRecord}">
					<tr>
						<td colspan="3" style="font-weight: bold">어떤 운동을 하셨는지 기록해주세요!</td>
					</tr>
				</c:when>
			</c:choose>
            <c:forEach var="e" items="${exRecord}">
            	<tr>
            		<td>${e.exDate}</td>
            		<td>${e.part}</td>
            		<td>${e.exTime}</td>
            	</tr>
            </c:forEach>
          	</table>
          </div>
        </div>
    </div>
</div>
<%@ include file="/footer.jsp" %>
    <script>
    var swiper = new Swiper(".mySwiper", {
        slidesPerView: 1.5,
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
