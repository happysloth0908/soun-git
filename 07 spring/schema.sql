DROP DATABASE IF EXISTS spring_test; -- 이미 디비가 있다면 삭제
CREATE DATABASE spring_test; -- 새로운 테이블 생성
USE spring_test; -- 테이블 이용

CREATE TABLE specialty (
    specialty_code INT PRIMARY KEY, -- specialty_code를 주식별자로 설정
    specialty_name VARCHAR(100) NOT NULL   -- 빈값이 못 오도록
);

CREATE TABLE doctor (
    doctor_id INT PRIMARY KEY, -- 주식별자
    name VARCHAR(100) NOT NULL, -- 빈값 못 오게 
    age INT NOT NULL, 
    specialty_code INT, 
    experience_years INT, 
    FOREIGN KEY (specialty_code) REFERENCES specialty(specialty_code)
    ON DELETE CASCADE
    -- 외래키로 specialty테이블의 specialty_code 사용, 만약 전공 삭제하면 삭제되도록 하기
);
-- 값 추가하기
INSERT INTO specialty (specialty_code, specialty_name) values (100, "정형외과");
INSERT INTO specialty (specialty_code, specialty_name) values (200, "성형외과");
INSERT INTO specialty (specialty_code, specialty_name) values (300, "내과");

INSERT INTO doctor (doctor_id, name, age, specialty_code, experience_years) values (1, "김소운", 25, 200, 5);
INSERT INTO doctor (doctor_id, name, age, specialty_code, experience_years) values (2, "김예운", 28, 300, 7);

DELETE FROM specialty WHERE specialty_code = 100;

SELECT * FROM specialty;
SELECT * FROM doctor;