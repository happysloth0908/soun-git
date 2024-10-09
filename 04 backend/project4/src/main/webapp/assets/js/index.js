$(".section.parts .tab-menu li:nth-child(1)").click(function () {
  $(this).addClass("active");
  $(this).siblings().removeClass("active");

  $(".parts-vedios .swiper-slide").removeClass("active");
  $(".upperVideos").addClass("active");
});

$(".section.parts .tab-menu li:nth-child(2)").click(function () {
  $(this).addClass("active");
  $(this).siblings().removeClass("active");

  $(".parts-vedios .swiper-slide").removeClass("active");
  $(".lowerVideos").addClass("active");
});

$(".section.parts .tab-menu li:nth-child(3)").click(function () {
  $(this).addClass("active");
  $(this).siblings().removeClass("active");

  $(".parts-vedios .swiper-slide").removeClass("active");
  $(".wholeVideos").addClass("active");
});

$(".section.parts .tab-menu li:nth-child(4)").click(function () {
  $(this).addClass("active");
  $(this).siblings().removeClass("active");

  $(".parts-vedios .swiper-slide").removeClass("active");
  $(".abdomanVideos").addClass("active");
});
$(".section.parts .tab-menu li:nth-child(5)").click(function () {
  $(this).addClass("active");
  $(this).siblings().removeClass("active");

  $(".parts-vedios .swiper-slide").removeClass("active");
  $(".cardioVideos").addClass("active");
});
$(".section.parts .tab-menu li:nth-child(6)").click(function () {
  $(this).addClass("active");
  $(this).siblings().removeClass("active");

  $(".parts-vedios .swiper-slide").removeClass("active");
  $(".stretchVideos").addClass("active");
});