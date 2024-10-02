<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>팔로우 기능 구현 (서버 없이)</title>
    <style>

    </style>
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/css/main.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    
    <link href="assets/css/custom.css" rel="stylesheet">

</head>
<body class="follow">
    <div id="login-box" class="container">
        <h2 style="color: white;" >로그인</h2>
        <form id="login">
            <div class="form-group">
                <label for="loginUsername" style="color: white ;">아이디:</label>
                <input type="text"  style="box-sizing: border-box;" id="loginUsername" name="loginUsername" required>
            </div>
            <div class="form-group">
                <button type="submit">로그인</button>
            </div>
            <p class="message" id="loginMessage"></p>
        </form>
    </div>

    <div class="container" id="followContainer" style="display: none;">
        <div class="article">
            <h2>사용자 목록</h2>
            <ul class="user-list" id="userList">
            </ul>
        </div>

        <div style="background: rgba(0, 0, 0, 0);" class="section row gy-4 justify-content-center article">
            <h2 class="content-title">찜한 영상</h2>
            <div class="select-vedios col-xl-3 col-lg-4 col-md-6">
              <div style="height: 520px" class="swiper mySwiper">
                <div class="swiper-wrapper">
                  <div class="swiper-slide">
                    <div class="gallery-item h-100">
                      <iframe width="560" height="360" src="https://www.youtube.com/embed/50WCSpZtdmA?si=tPMOc_AdLb0RujuT" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                      <h4>심으뜸의 영상</h4>
                      <p>집에서 하는 유연한 운동</p>
                      <div class="heart-btn gallery-links d-flex align-items-center justify-content-center">
                        <a href="gallery-single.html" class="details-link"><i class="bi bi-heart"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="swiper-slide">
                    <div class="gallery-item h-100">
                      <iframe width="560" height="360" src="https://www.youtube.com/embed/50WCSpZtdmA?si=tPMOc_AdLb0RujuT" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                      <h4>심으뜸의 영상</h4>
                      <p>집에서 하는 유연한 운동</p>
                      <div class="heart-btn gallery-links d-flex align-items-center justify-content-center">
                        <a href="gallery-single.html" class="details-link"><i class="bi bi-heart"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="swiper-slide">
                    <div class="gallery-item h-100">
                      <iframe width="560" height="360" src="https://www.youtube.com/embed/50WCSpZtdmA?si=tPMOc_AdLb0RujuT" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                      <h4>심으뜸의 영상</h4>
                      <p>집에서 하는 유연한 운동</p>
                      <div class="heart-btn gallery-links d-flex align-items-center justify-content-center">
                        <a href="gallery-single.html" class="details-link"><i class="bi bi-heart"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="swiper-slide">
                    <div class="gallery-item h-100">
                      <iframe width="560" height="360" src="https://www.youtube.com/embed/50WCSpZtdmA?si=tPMOc_AdLb0RujuT" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                      <h4>심으뜸의 영상</h4>
                      <p>집에서 하는 유연한 운동</p>
                      <div class="heart-btn gallery-links d-flex align-items-center justify-content-center">
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

    <script>
        const users = ['user1', 'user2', 'user3', 'user4', 'user5'];
        let currentUser = null;

        // 로그인 폼 제출 이벤트 핸들러
        document.getElementById('login').addEventListener('submit', function(event) {
            event.preventDefault(); // 폼 제출 방지
            const username = document.getElementById('loginUsername').value;
            currentUser = username;
            document.getElementById('loginMessage').innerText = '로그인 성공! 환영합니다, ' + currentUser + '님.';
            document.getElementById('login-box').style.display = 'none';
            document.getElementById('followContainer').style.display = 'block';
            displayUsers();
        });

        // 사용자 목록 표시 함수
        function displayUsers() {
            const userList = document.getElementById('userList');
            userList.innerHTML = ''; // 기존 목록 초기화

            users.forEach(user => {
                if (user !== currentUser) { // 현재 사용자 자신은 목록에서 제외
                    const li = document.createElement('li');
                    li.textContent = user;

                    const followButton = document.createElement('button');
                    followButton.textContent = isFollowing(user) ? '팔로잉 중' : '팔로우';
                    followButton.classList.toggle('followed', isFollowing(user));
                    followButton.addEventListener('click', () => toggleFollow(user, followButton));

                    li.appendChild(followButton);
                    userList.appendChild(li);
                }
            });
        }

        // 팔로우 상태 확인 함수
        function isFollowing(user) {
            const followedUsers = JSON.parse(localStorage.getItem(currentUser + '_follows')) || [];
            return followedUsers.includes(user);
        }

        // 팔로우/언팔로우 토글 함수
        function toggleFollow(user, button) {
            let followedUsers = JSON.parse(localStorage.getItem(currentUser + '_follows')) || [];

            if (followedUsers.includes(user)) {
                followedUsers = followedUsers.filter(u => u !== user);
                button.textContent = '팔로우';
                button.classList.remove('followed');
            } else {
                followedUsers.push(user);
                button.textContent = '팔로잉 중';
                button.classList.add('followed');
            }

            localStorage.setItem(currentUser + '_follows', JSON.stringify(followedUsers));
        }
    </script>

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
