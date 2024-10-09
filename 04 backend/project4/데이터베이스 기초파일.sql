DROP DATABASE IF EXISTS FitMate;

CREATE DATABASE FitMate;
USE FitMate;

CREATE TABLE IF NOT EXISTS users (
    `user_id` varchar(100) NOT NULL PRIMARY KEY,
    `password` varchar(100) NOT NULL,
    `email` varchar(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS video (
    video_id VARCHAR(50) PRIMARY KEY,
    channel VARCHAR(50) NOT NULL,
    title VARCHAR(300) NOT NULL,
    src VARCHAR(400) NOT NULL,
    part VARCHAR(30) NOT NULL,
    view_cnt INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS review(
	review_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(300) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    reg_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id VARCHAR(100) NOT NULL,
    video_id VARCHAR(50) NOT NULL,
    view_cnt INT DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (video_id) REFERENCES video(video_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS subscribe(
	user_id VARCHAR(100) NOT NULL,
    channel VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS liked (
    user_id VARCHAR(100) NOT NULL,
    video_id VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id) 
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY (video_id) REFERENCES video(video_id) 
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS exRecord (
	part VARCHAR(30) NOT NULL,
    ex_date DATE NOT NULL,
    ex_time INT NOT NULL,
    user_id VARCHAR(100) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS video (
    video_id VARCHAR(50) PRIMARY KEY,
    channel VARCHAR(50) NOT NULL,
    title VARCHAR(300) NOT NULL,
    src VARCHAR(400) NOT NULL,
    part VARCHAR(30) NOT NULL,
    view_cnt INT DEFAULT 0
);


INSERT INTO video(video_id, title, src, part, channel) 
VALUES( '50WCSpZtdmA', 'Shim EuDdeum 10 Minute Morning Stretch Everydayㅣ2023 Renewal', 'https://www.youtube.com/embed/50WCSpZtdmA', '전신' ,  '힘으뜸'),
( 'Kk7TQGqQ3nA',  '하루 두 번🧘🏻‍♀️반드시 해야하는 20분 전신순환 스트레칭 Ep.08 - 피로회복, 디톡스, 심신안정, 혈액순환, 라인정리 효과 (Whole body stretch)', 'https://www.youtube.com/embed/Kk7TQGqQ3nA', '전신' , '빵느'),
( 'MTU4iCDntjs',  '4 Minute OFFICE STRETCHING(full body)', 'https://www.youtube.com/embed/MTU4iCDntjs' , '전신', 'Allblanc TV'),
( 'D3yExRi7EME&t=791s',  '뭉친 어깨, 뻣뻣한 골반 풀어주는 요가 | 앉아서 하는 요가 스트레칭 | 어깨 근육 풀기, 골반풀기', 'https://www.youtube.com/embed/D3yExRi7EME&t=791s', '상체',  'Mindful Yoga with Eileen'),
( '02K-k6daPb4',  '15 MIN Fat Burning Cardio - 서서하는 유산소 - 다이어트 운동', 'https://www.youtube.com/embed/02K-k6daPb4', '전신' ,'빅씨스 Bigsis'),
( 'gMaB-fG4u4g',  '전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]', 'https://www.youtube.com/embed/gMaB-fG4u4g', '전신' , 'ThankyouBUBU'),
( 'swRNeYw1JkY',  '하루 15분! 전신 칼로리 불태우는 다이어트 운동', 'https://www.youtube.com/embed/swRNeYw1JkY', '전신' , 'ThankyouBUBU'),
( '54tTYO-vU2E',  '상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]', 'https://www.youtube.com/embed/54tTYO-vU2E', '상체' , 'ThankyouBUBU'),
( 'QqqZH3j_vH0',  '상체비만 다이어트 최고의 운동 [상체 핵매운맛]', 'https://www.youtube.com/embed/QqqZH3j_vH0', '상체' , 'ThankyouBUBU'),
( 'tzN6ypk6Sps',  '하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]', 'https://www.youtube.com/embed/tzN6ypk6Sps', '하체' , '김강민'),
( 'u5OgcZdNbMo',  '저는 하체 식주의자 입니다', 'https://www.youtube.com/embed/u5OgcZdNbMo', '하체' , 'GYM종국'),
( 'PjGcOP-TQPE',  '11자복근 복부 최고의 운동 [복근 핵매운맛]','https://www.youtube.com/embed/PjGcOP-TQPE', '복부' , 'ThankyouBUBU');


SELECT *
FROM users;

# SELECT * FROM users WHERE user_id = 'ssafy' AND password = 1234;
INSERT INTO users(user_id, password, email) VALUES('ssafy', '1234', 'ssafy@ssafy.com');
INSERT INTO subscribe(user_id, channel) VALUES('ssafy', '힘으뜸');
INSERT INTO subscribe(user_id, channel) VALUES('ssafy', 'ThankyouBUBU');

SELECT * FROM subscribe;

SELECT * FROM video;

SELECT * FROM liked;

SELECT * FROM exRecord;	

SELECT sum(ex_time), part 
FROM exRecord 
WHERE ex_date BETWEEN date(DATE_ADD(NOW(), INTERVAL-1 WEEK)) AND date(now())
AND user_id = 'ssafy'
GROUP BY part
ORDER BY sum(ex_time) ASC
LIMIT 1;

SELECT * FROM review;
# DELETE FROM exRecord;