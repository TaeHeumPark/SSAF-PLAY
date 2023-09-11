DROP DATABASE IF EXISTS ssaf_play;
CREATE DATABASE ssaf_play;
USE ssaf_play;

CREATE TABLE Gender (
  gender_id INT AUTO_INCREMENT PRIMARY KEY,
  gender_name VARCHAR(20)
);

INSERT INTO Gender (gender_id, gender_name) VALUES
  (1, '남성'),
  (2, '여성');

CREATE TABLE Grade (
  grade_id INT AUTO_INCREMENT PRIMARY KEY,
  grade_name VARCHAR(20)
);

INSERT INTO Grade (grade_id, grade_name) VALUES
  (1, '브론즈'),
  (2, '실버'),
  (3, '골드'),
  (4, '플레티넘'),
  (5, '다이아');

CREATE TABLE Sports (
  sports_id INT AUTO_INCREMENT PRIMARY KEY,
  sports_name VARCHAR(20)
);

INSERT INTO Sports (sports_id, sports_name) VALUES
  (1, '축구'),
  (2, '농구');

CREATE TABLE Positions (
  position_id INT AUTO_INCREMENT PRIMARY KEY,
  position_name VARCHAR(20)
);

INSERT INTO Positions (position_id, position_name) VALUES
  (1, '공격수'),
  (2, '미드필더'),
  (3, '수비수'),
  (4, '골키퍼'),
  (5, '가드'),
  (6, '포워드'),
  (7, '센터'),
  (8, '자유');
  
CREATE TABLE User (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  profile_img VARCHAR(255),
  birth_date DATE NOT NULL,
  reg_date DATETIME NOT NULL,
  gender_id INT NOT NULL,
  manner_score INT NOT NULL,
  match_count INT NOT NULL,
  record VARCHAR(255) NOT NULL,
  grade_id INT NOT NULL,
  preferred_position INT NOT NULL,
  FOREIGN KEY (gender_id) REFERENCES Gender(gender_id),
  FOREIGN KEY (grade_id) REFERENCES Grade(grade_id),
  FOREIGN KEY (preferred_position) REFERENCES Positions(position_id)
);

CREATE TABLE Matches (
  match_id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  content TEXT NOT NULL,
  start_date DATETIME NOT NULL,
  curr_head_count INT NOT NULL,
  limit_head_count INT NOT NULL,
  address VARCHAR(255) NOT NULL,
  # location 추가 했음
  location VARCHAR(255) NOT NULL,
  latitude DOUBLE NOT NULL,
  longitude DOUBLE NOT NULL,
  sports_id INT NOT NULL,
  FOREIGN KEY (sports_id) REFERENCES Sports(sports_id)
);

CREATE TABLE `usermatch` (
  `user_match_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `match_id` int NOT NULL,
  `match_positions` int NOT NULL,
  `team` int NOT NULL,
  `team_idx` int NOT NULL,
  PRIMARY KEY (`user_match_id`),
  KEY `user_id` (`user_id`),
  KEY `match_id` (`match_id`),
  KEY `match_positions` (`match_positions`),
  CONSTRAINT `usermatch_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  #CONSTRAINT `usermatch_ibfk_2` FOREIGN KEY (`match_id`) REFERENCES `matches` (`match_id`),
  CONSTRAINT `usermatch_ibfk_3` FOREIGN KEY (`match_positions`) REFERENCES `positions` (`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `video` (
  `video_no` INT NOT NULL AUTO_INCREMENT,
  `id` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `date` DATETIME NOT NULL,
  `view_cnt` INT NOT NULL,
  `sports` INT NOT NULL,
  PRIMARY KEY (`video_no`))
ENGINE = InnoDB;

INSERT INTO User (email, password, name, phone_number, profile_img, birth_date, reg_date, gender_id, manner_score, match_count, record, grade_id, preferred_position)
VALUES
('user1@email.com', '1234', '싸피맨', '010-9845-6351', 'user1.jpg', '1987-02-15', '2023-05-18 00:00:00', 1, 76, 14, '2-0-12', 2, 1),
('user2@email.com', '1234', '이서영', '010-9841-1591', 'user2.jpg', '1967-02-02', '2023-05-19 00:00:00', 2, 97, 11, '10-1-0', 4, 2),
('user3@email.com', '1234', '박태흠', '010-3785-4567', 'user3.jpg', '1999-01-01', '2023-05-18 00:00:00', 1, 65, 15, '7-2-6', 3, 3),
('user4@email.com', '1234', '임수민', '010-2345-3785', 'user4.jpg', '1997-02-02', '2023-05-19 00:00:00', 2, 57, 4, '0-0-4', 1, 4),
('user5@email.com', '1234', '김갑수', '010-3457-3738', 'user5.jpg', '1994-01-01', '2023-05-18 00:00:00', 1, 85, 9, '5-1-3', 2, 1),
('user6@email.com', '1234', '최다정', '010-1567-5342', 'user6.jpg', '1997-02-02', '2023-05-19 00:00:00', 2, 89, 35, '12-3-20', 2, 2),
('user7@email.com', '1234', '배준영', '010-7888-7887', 'user7.jpg', '1994-01-01', '2023-05-18 00:00:00', 1, 82, 22, '8-2-12', 2, 3),
('user8@email.com', '1234', '이예은', '010-5432-3737', 'user8.jpg', '2001-02-02', '2023-05-19 00:00:00', 2, 71, 12, '6-0-6', 2, 4),
('user9@email.com', '1234', '이진혁', '010-4357-5678', 'user9.jpg', '1997-01-01', '2023-05-18 00:00:00', 1, 79, 18, '12-0-6', 3, 1),
('user10@email.com', '1234', '최유나', '010-9378-2783', 'user10.jpg', '1995-02-02', '2023-05-19 00:00:00', 2, 91, 16, '4-8-4', 2, 2),
('user11@email.com', '1234', '김동현', '010-1523-7853', 'user11.jpg', '1996-01-01', '2023-05-18 00:00:00', 1, 98, 18, '7-2-9', 2, 3),
('user12@email.com', '1234', '성미소', '010-2375-7865', 'user12.jpg', '2001-02-02', '2023-05-19 00:00:00', 2, 76, 24, '13-1-10', 3, 4),
('user13@email.com', '1234', '이진호', '010-4537-3785', 'user13.jpg', '1996-01-01', '2023-05-18 00:00:00', 1, 82, 42, '20-7-15', 3, 1),
('user14@email.com', '1234', '사용자 14', '010-9498-3754', 'user14.jpg', '1997-02-02', '2023-05-19 00:00:00', 2, 84, 31, '16-2-13', 3, 2),
('user15@email.com', '1234', '성준호', '010-3573-4538', 'user15.jpg', '1997-01-01', '2023-05-18 00:00:00', 1, 86, 5, '2-0-3', 1, 3),
('user16@email.com', '1234', '남현우', '010-2785-4653', 'user16.jpg', '1995-02-02', '2023-05-19 00:00:00', 2, 89, 8, '5-1-2', 2, 4),
('user17@email.com', '1234', '김용준', '010-4561-3751', 'user17.jpg', '1996-02-02', '2023-05-19 00:00:00', 1, 96, 40, '17-3-20', 3, 4),
('user18@email.com', '1234', '도민준', '010-3452-8357', 'user18.jpg', '2001-02-02', '2023-05-19 00:00:00', 2, 91, 28, '0-0-28', 2, 4),
('user19@email.com', '1234', '김준서', '010-3513-4538', 'user19.jpg', '1997-01-01', '2023-05-18 00:00:00', 1, 86, 16, '8-0-8', 2, 8),
('user20@email.com', '1234', '이가영', '010-2715-4653', 'user20.jpg', '1995-02-02', '2023-05-19 00:00:00', 2, 89, 8, '2-0-6', 1, 7),
('user21@email.com', '1234', '최성민', '010-4211-3751', 'user21.jpg', '1996-02-02', '2023-05-19 00:00:00', 1, 96, 38, '28-0-10', 4, 6),
('user22@email.com', '1234', '리설주', '010-3252-8357', 'user22.jpg', '2001-02-02', '2023-05-19 00:00:00', 2, 91, 28, '12-0-16', 2, 5),
('user23@email.com', '1234', '임현주', '010-2385-4653', 'user23.jpg', '1995-02-02', '2023-05-19 00:00:00', 2, 89, 8, '3-0-5', 1, 6),
('user24@email.com', '1234', '김정은', '010-4461-3751', 'user24.jpg', '1996-02-02', '2023-05-19 00:00:00', 1, 96, 40, '24-0-16', 3, 7),
('user25@email.com', '1234', '임정은', '010-3552-8357', 'user25.jpg', '2001-02-02', '2023-05-19 00:00:00', 2, 91, 28, '10-0-18', 2, 5);

INSERT INTO Matches
VALUES
(0, '재밌게 공 차실 분들', '끝나고 회식도 해요', '2023-05-27 10:00:00', 1, 22, '서울특별시 종로구 5가길 11', '서울', 37.566567, 126.978091, 1),
(0, '마이클 조던 찾아요', '프로 준비 중임', '2023-05-28 12:00:00', 1, 10, '대전광역시 유성구  661-1', '대전', 37.510204, 127.044422, 2),
(0, '손 떨리는 분들만', '살살 경기하실 분들 찾는 중', '2023-05-28 16:00:00', 1, 22, '충청북도 마로구 5구길 155', '충북', 37.566567, 126.978091, 1),
(0, '회식 좋아하시는 분?', '필참이에요', '2023-05-29 12:00:00', 1, 6, '대전광역시 부산구 역삼동 101-1', '대전', 37.510204, 127.044422, 2),
(0, '축구할사람', '찾아용', '2023-05-29 14:00:00', 1, 22, '대전광역시 유성구 2구길 11', '대전', 37.566567, 126.978091, 1),
(0, '농구할사람', '찾아용', '2023-05-29 18:00:00', 1, 10, '서울특별시 강북구 삼역동 81-1', '서울', 37.510204, 127.044422, 2),
(0, '리프팅 10회 이상 분들 모집', '고수방입니다', '2023-05-30 10:00:00', 1, 22, '대전광역시 로종 3길 11', '대전', 37.566567, 126.978091, 1),
(0, '선착순 5명', '못하는 분들 오셨으면..', '2023-05-31 12:00:00', 1, 6, '대전광역시 유성구 삼약동 18-1', '대전', 37.510204, 127.044422, 2),
(0, 'NBA 광팬이신분들', '농구를 같이 할 사람을 찾습니다.', '2023-05-31 18:00:00', 1, 10, '대전광역시 유성구 구성 2길 21', '대전', 37.510204, 127.044422, 2);

insert into UserMatch 
    VALUES
    (0, 1, 7, 1, 1, 1),
    (0, 2, 7, 1, 1, 2),
    (0, 3, 7, 2, 1, 3),
    (0, 4, 7, 2, 1, 4),
    (0, 5, 7, 2, 1, 5),
    (0, 6, 7, 2, 1, 6),
    (0, 7, 7, 3, 1, 7),
    (0, 8, 7, 3, 1, 8),
    (0, 9, 7, 3, 1, 9),
    (0, 10, 7, 3, 1, 10),
    (0, 11, 7, 4, 1, 11),
    (0, 12, 7, 1, 2, 1),
    (0, 13, 7, 1, 2, 2),
    (0, 14, 7, 2, 2, 3),
    (0, 15, 7, 2, 2, 4),
    (0, 16, 7, 2, 2, 5),
    (0, 17, 7, 2, 2, 6),
    (0, 18, 7, 3, 2, 7),
    (0, 19, 7, 3, 2, 8),
    (0, 20, 7, 3, 2, 9),
    (0, 21, 7, 3, 2, 10),
    (0, 22, 7, 4, 2, 11),
    (0, 12, 8, 5, 1, 1),
    (0, 13, 8, 5, 1, 2),
    (0, 18, 8, 6, 1, 3),
    (0, 19, 8, 6, 1, 4),
    (0, 20, 8, 7, 1, 5),
    (0, 21, 8, 5, 2, 1),
    (0, 22, 8, 5, 2, 2),
    (0, 23, 8, 6, 2, 3),
    (0, 24, 8, 6, 2, 4),
    (0, 25, 8, 7, 2, 5),
    (0, 1, 5, 1, 1, 6),
 (0, 2, 5, 1, 1, 5),
 (0, 3, 5, 2, 1, 3),
 (0, 4, 5, 2, 1, 1),
 (0, 5, 5, 2, 2, 5),
 (0, 6, 5, 2, 2, 3),
 (0, 7, 5, 3, 2, 1);
 select * from usermatch;