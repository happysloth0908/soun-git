const videos1 = [
  { "id": "50WCSpZtdmA", "title": "Shim EuDdeum 10 Minute Morning Stretch Everydayㅣ2023 Renewal", "part": "전신", "channelName": "힘으뜸", "url": "https://www.youtube.com/embed/50WCSpZtdmA", "href":"./review_list.html" },
  { "id": "Kk7TQGqQ3nA", "title": "하루 두 번🧘🏻‍♀️반드시 해야하는 20분 전신순환 스트레칭 Ep.08 - 피로회복, 디톡스, 심신안정, 혈액순환, 라인정리 효과 (Whole body stretch)", "part": "전신", "channelName": "빵느", "url": "https://www.youtube.com/embed/Kk7TQGqQ3nA", "href":"./review_list.html"  },
  { "id": "MTU4iCDntjs", "title": "4 Minute OFFICE STRETCHING(full body)", "part": "전신", "channelName": "Allblanc TV", "url": "https://www.youtube.com/embed/MTU4iCDntjs", "href":"./review_list.html"  },
  { "id": "D3yExRi7EME&t=791s", "title": "뭉친 어깨, 뻣뻣한 골반 풀어주는 요가 | 앉아서 하는 요가 스트레칭 | 어깨 근육 풀기, 골반풀기", "part": "상체", "channelName": "Mindful Yoga with Eileen", "url": "https://www.youtube.com/embed/D3yExRi7EME&t=791s", "href":"./review_list.html"  },
  { "id": "02K-k6daPb4", "title": "15 MIN Fat Burning Cardio - 서서하는 유산소 - 다이어트 운동", "part": "전신", "channelName": "빅씨스 Bigsis", "url": "https://www.youtube.com/embed/02K-k6daPb4", "href":"./review_list.html"  },
  { "id": "gMaB-fG4u4g", "title": "전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", "part": "전신", "channelName": "ThankyouBUBU", "url": "https://www.youtube.com/embed/gMaB-fG4u4g", "href":"./review_list.html"  },
  { "id": "swRNeYw1JkY", "title": "하루 15분! 전신 칼로리 불태우는 다이어트 운동", "part": "전신", "channelName": "ThankyouBUBU", "url": "https://www.youtube.com/embed/swRNeYw1JkY", "href":"./review_list.html"  },
  { "id": "54tTYO-vU2E", "title": "상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", "part": "상체", "channelName": "ThankyouBUBU", "url": "https://www.youtube.com/embed/54tTYO-vU2E", "href":"./review_list.html"  },
  { "id": "QqqZH3j_vH0", "title": "상체비만 다이어트 최고의 운동 [상체 핵매운맛]", "part": "상체", "channelName": "ThankyouBUBU", "url": "https://www.youtube.com/embed/QqqZH3j_vH0", "href":"./review_list.html"  },
  { "id": "tzN6ypk6Sps", "title": "하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]", "part": "하체", "channelName": "김강민", "url": "https://www.youtube.com/embed/tzN6ypk6Sps" },
  { "id": "u5OgcZdNbMo", "title": "저는 하체 식주의자 입니다", "part": "하체", "channelName": "GYM종국", "url": "https://www.youtube.com/embed/u5OgcZdNbMo", "href":"./review_list.html"  },
  { "id": "PjGcOP-TQPE", "title": "11자복근 복부 최고의 운동 [복근 핵매운맛]", "part": "복부", "channelName": "ThankyouBUBU", "url": "https://www.youtube.com/embed/PjGcOP-TQPE", "href":"./review_list.html"  },
  // { "id": "7TLk7pscICk", "title": "(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", "part": "복부", "channelName": "SomiFit", "url": "https://www.youtube.com/embed/7TLk7pscICk", "href":"#none"  }
];


// 비디오 리스트 컨테이너 선택
const videoList = document.getElementById('video-list');

// 비디오 데이터를 이용해 HTML 요소 생성
videos1.forEach(video => {
    const videoItem = document.createElement('div');
    videoItem.className = 'video-item';

    videoItem.innerHTML = `
        <h3><a href="${video.href}">${video.title}</a></h3>
        <p>${video.channelName} - ${video.part}</p>
        <iframe src="${video.url}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
    `;

    videoList.appendChild(videoItem);
});
