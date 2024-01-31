CREATE TABLE TBL_MENU (
	mcode nvarchar2(8) PRIMARY KEY,
	mname nvarchar2(10) NOT NULL UNIQUE,
	mprice number(7) NOT NULL
);

CREATE TABLE TBL_MEMBERS (
	code nvarchar2(8) PRIMARY KEY,
	name nvarchar2(4) NOT NULL,
	email nvarchar2(30),
	phone_number nvarchar2(20) unique,
	age number(3)
);

CREATE TABLE TBL_BUY_MENU (
	buy_index NUMBER(8) PRIMARY KEY,
	customer_id nvarchar2(8),
	menu_id nvarchar2(8),
	menu_quantity NUMBER NOT NULL,
	buy_date DATE DEFAULT sysdate,
	FOREIGN KEY (customer_id) REFERENCES TBL_MEMBERs(code),
	FOREIGN KEY (menu_id) REFERENCES TBL_MENU(mcode)
);

CREATE SEQUENCE burger_seq START WITH 1001;
-- 멤버 insert
--성우
INSERT INTO tbl_members values('jsw001','장성우','ssswww444@gmail.com','010-1122-1122',25); 
INSERT INTO tbl_members values('lhb002','임현범','hbhbhb001@naver.com','010-3344-5566',30); 
--채은
INSERT INTO TBL_MEMBERS VALUES ('lce001','임채은','lce1234@gmail.com','010-0123-4567',25);
INSERT INTO TBL_MEMBERS VALUES ('jir001','조이루','jir777@naver.com','010-0987-6543',22);
--예진
INSERT INTO tbl_members values('jyj001','전예진','yyyjjj001@gmail.com','010-1234-3278',21);
INSERT INTO tbl_members values('jjw001','정재원','jjjwww001@gmail.com','010-3278-1234',22);


--메뉴 insert--
--재원
INSERT INTO TBL_MENU VALUES ('QUAR4', '쿼터파운드 치즈버거', 8900);
INSERT INTO TBL_MENU VALUES ('BG1955', '1955 버거', 7200);
INSERT INTO TBL_MENU VALUES ('TOMA2', '토마토 치킨 스낵랩', 3800);
INSERT INTO TBL_MENU VALUES ('PEA1000', '천도 복숭아 칠러', 3700);
INSERT INTO TBL_MENU VALUES ('JEJU8', '제주 한라봉 칠러', 4300);

--이루
INSERT INTO TBL_MENU tm VALUES ('CH40','치즈버거',4000);
INSERT INTO TBL_MENU tm VALUES ('BM45','빅맥',4500);
INSERT INTO TBL_MENU tm VALUES ('BTD50','베토디',5000);
INSERT INTO TBL_MENU tm VALUES ('FF25','감자튀김',2500);
INSERT INTO TBL_MENU tm VALUES ('SP20','스트라이트',2000);

--현범
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jsw001', 'TOMA2', 3, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jsw001', 'BG1955', 2, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'lhb002', 'SP20', 4, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jyj001', 'BTD50', 2, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jyj001', 'JEJU8', 1, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jjw001', 'PEA1000', 1, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jjw001', 'BTD50', 1, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'lce001', 'FF25', 1, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'lce001', 'QUAR4', 1, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jir001', 'CH40', 1, sysdate);
INSERT INTO TBL_BUY_MENU VALUES (burger_seq.nextval, 'jir001', 'TOMA2', 1, sysdate);



INSERT INTO tbl_members VALUES ('hgd001', '홍길동', 'honggd@gmail.com', '010-1122-3344', 20);
INSERT INTO tbl_members VALUES ('lmr002', '이몽룡', 'limongryong@gmail.com', '010-2233-4455', 25);
INSERT INTO tbl_members VALUES ('bhd004', '변학도', 'byeonhakdo@gmail.com', '010-4455-6677', 30);
INSERT INTO tbl_members VALUES ('hjg005', '허준', 'heojun@gmail.com', '010-5566-7788', 28);
INSERT INTO tbl_members VALUES ('ybg006', '윤봉길', 'yunbonggil@gmail.com', '010-6677-8899', 27);
INSERT INTO tbl_members VALUES ('ajg007', '안중근', 'anjunggeun@gmail.com', '010-7788-9900', 31);
INSERT INTO tbl_members VALUES ('ygs008', '유관순', 'yugwansun@gmail.com', '010-8899-0011', 23);
INSERT INTO tbl_members VALUES ('lss010', '이순신', 'leesoonsin@gmail.com', '010-0011-2233', 35);
INSERT INTO tbl_members VALUES ('ssd011', '신사임당', 'shinsaimdang@gmail.com', '010-1122-3344', 26);
INSERT INTO tbl_members VALUES ('ygi012', '율곡이이', 'yulgok@gmail.com', '010-2233-4455', 32);
INSERT INTO tbl_members VALUES ('kg014', '김구', 'kimgu@gmail.com', '010-4455-6678', 27);
INSERT INTO tbl_members VALUES ('ahc015', '안창호', 'anchangho@gmail.com', '010-5566-7789', 28);
INSERT INTO tbl_members VALUES ('yjs016', '유재석', 'yoojaeseok@gmail.com', '010-6677-8900', 41);
INSERT INTO tbl_members VALUES ('pms017', '박명수', 'parkmyungsoo@gmail.com', '010-7788-9901', 47);
INSERT INTO tbl_members VALUES ('jhd018', '정형돈', 'jungmyungdon@gmail.com', '010-8899-0012', 45);
INSERT INTO tbl_members VALUES ('hh019', '하하', 'haha@gmail.com', '010-9900-1123', 46);
INSERT INTO tbl_members VALUES ('nhc020', '노홍철', 'nohongchul@gmail.com', '010-0011-2234', 44);
INSERT INTO tbl_members VALUES ('ysh021', '양세형', 'yangsehyung@gmail.com', '010-1122-3345', 37);
INSERT INTO tbl_members VALUES ('jjh022', '정준하', 'jeongjunha@gmail.com', '010-2233-4456', 45);
INSERT INTO tbl_members VALUES ('yny023', '유노윤호', 'yunoyunho@gmail.com', '010-3344-5567', 36);
INSERT INTO tbl_members VALUES ('cgc024', '최강창민', 'choikangchangmin@gmail.com', '010-4455-6679', 35);
INSERT INTO tbl_members VALUES ('kjs025', '김준수', 'kimjoonsu@gmail.com', '010-5566-7780', 34);
INSERT INTO tbl_members VALUES ('ywj026', '영웅재중', 'youngwoongjaejoong@gmail.com', '010-6677-8901', 35);
INSERT INTO tbl_members VALUES ('pyc027', '박유천', 'parkyuchun@gmail.com', '010-7788-9902', 34);
INSERT INTO tbl_members VALUES ('xjs028', '시아준수', 'xiajunsu@gmail.com', '010-8899-0013', 34);
INSERT INTO tbl_members VALUES ('hjy029', '한재영', 'hanjaeyoung@gmail.com', '010-9900-1124', 33);
INSERT INTO tbl_members VALUES ('lmh030', '이민호', 'leeminho@gmail.com', '010-0011-2235', 35);
INSERT INTO tbl_members VALUES ('ksy031', '김수현', 'kimsoohyun@gmail.com', '010-1122-3346', 34);
INSERT INTO tbl_members VALUES ('sjk032', '송중기', 'songjoongki@gmail.com', '010-2233-4457', 36);
INSERT INTO tbl_members VALUES ('pbg033', '박보검', 'parkbogum@gmail.com', '010-3344-5568', 28);
INSERT INTO tbl_members VALUES ('kdn034', '강다니엘', 'kangdaniel@gmail.com', '010-4455-6680', 25);
INSERT INTO tbl_members VALUES ('pjh035', '박지훈', 'parkjihoon@gmail.com', '010-5566-7781', 24);
INSERT INTO tbl_members VALUES ('kjw036', '김재환', 'kimjaehwan@gmail.com', '010-6677-8902', 24);
INSERT INTO tbl_members VALUES ('osw037', '옹성우', 'ongseongwu@gmail.com', '010-7788-9903', 25);
INSERT INTO tbl_members VALUES ('hmn038', '황민현', 'hwangminhyun@gmail.com', '010-8899-0014', 26);
INSERT INTO tbl_members VALUES ('yjs039', '윤지성', 'yoonjisung@gmail.com', '010-9900-1125', 27);
INSERT INTO tbl_members VALUES ('hsu040', '하성운', 'hasungwoon@gmail.com', '010-0011-2236', 26);
