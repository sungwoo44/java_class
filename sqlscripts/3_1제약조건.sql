/*
 * 
 * 제약 조건 constraint  <-- 테이블에 저장되는 데이터가 '요구사항'에 대한 부적절한 값 을 갖지 않도록 규정.
 * 1) 반드시 값이 있어야 한다.	 NULL허용?
 * 2) 같은 값을 가질수 없다.	 UNIQUE		(무결성 제약 조건 위반)
 * 3)1~4 범위로만 한다.		 CHECK
 * 
 * 4)기본키
 * 
 * 
 * */
CREATE TABLE tbl_constr1(
-- 제약 조건 컬럼레벨 설정하기 
	aname varchar2(20) NOT null,
	bname varchar2(20) UNIQUE, --NULL 허용
	cno number(4) NOT NULL UNIQUE,
	dno number(4) ChEck(dno BETWEEN 1 and 4) -- NULL 허용
);


--INSERT INTO TBL_CONSTR1 (aname,cno) VALUES ('apple',3); -- 필수 입력 컬럼  

--1) 입력 오류 발생하는 경우 : unique 위반
INSERT INTO TBL_CONSTR1 (aname,bname,cno) VALUES ('apple','banana',3); --  cno 컬럼값 중복
INSERT INTO TBL_CONSTR1 (aname,bname,cno) VALUES ('apple','banana',4); -- bname 컬럼값 중복
SELECT * FROM TBL_CONSTR1; 


--2) 입력 오류 발생하는 경우 :  not null 위반
INSERT INTO TBL_CONSTR1 (cno) VALUES (3); -- aname 입력을 안함


--3) 입력 오류 발생하는 경우
--INSERT INTO TBL_CONSTR1 (aname,dno) VALUES ('apple',13); --  dno 입력 범위를 초과함

