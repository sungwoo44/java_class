/*
 * 단어장 프로그램을 위한 테이블
 * 0.테이블 명 : tbl_javaword
 * 1.테이블 구조
 * 										3. to-do(요구사항에 대한 제약조건)
 * 		idx			number(8)			※ 같은 값 x /반드시 존재
 * 		english		varchar2(100)		※ 같은 값 x /반드시 존재
 * 		korean		nvarchar2(100)		※ 반드시 존재
 * 		step		number(1)			※ null 가능 / 1~4까지의 범위
 * 		
 * 									◆TIP◆ <기본키>
 * 										--> 검색속도를 향상시키기 위한 컬럼을 정해라.
 * 											데이터 행을 식별할수 있는 컬럼을 정해라					
 * 2.테이블 행 추가 -데이터 입력하기
 * 
 *
 * */

CREATE TABLE tbl_javaword(
idx NUMBER(8) PRIMARY KEY, -- UNIQUE & NOT NULL 
english varchar2(100) UNIQUE NOT null,
korean nvarchar2(100)NOT null,
step number(1) CHECK (step BETWEEN 1 AND 4) 
);


INSERT INTO TBL_JAVAWORD tj VALUES(1,'public','공용의',1);
--INSERT INTO TBL_JAVAWORD tj VALUES(1,'private','사적인',1); --  오류 무결성 제약조건
--INSERT INTO TBL_JAVAWORD tj VALUES(2,'public','사적인',1); --  오류 무결성 제약조건
--INSERT INTO TBL_JAVAWORD tj VALUES(null,'public','사적인',1); --  오류 프라이머리키  null






INSERT INTO tbl_javaword values(1,'public','공공의',1);	
INSERT INTO tbl_javaword values(2,'private','사적인',2);	
INSERT INTO tbl_javaword values(3,'protected','보호된',2);	
INSERT INTO tbl_javaword values(4,'apple','사과',1);	
INSERT INTO tbl_javaword values(5,'banana','바나나',1);	
INSERT INTO tbl_javaword (idx,korean,step)values(6,'바나나',1);	
INSERT INTO tbl_javaword (idx,korean)values(7,'바나나');	




SELECT * FROM tbl_javaword;
-- select 컬럼명1,컬럼명2,...from 테이블명 --> 모든 컬럼을 지정하는 문자는 *(와일드카드 문자)
SELECT ENGLISH,KOREAN  FROM tbl_javaword;

SELECT * FROM  TBL_JAVAWORD WHERE step IS NOT NULL;
SELECT * FROM  TBL_JAVAWORD WHERE ENGLISH  IS NULL;
SELECT * FROM  TBL_JAVAWORD WHERE idx=2;
SELECT * FROM  TBL_JAVAWORD WHERE ENGLISH ='public';
SELECT * FROM  TBL_JAVAWORD WHERE ENGLISH ='public' AND Step =2; --NOT,AND,OR : 논리연산
SELECT * FROM  TBL_JAVAWORD WHERE ENGLISH like '%va';  --sh로 끝나는 단어 %기호는 don't care
SELECT * FROM  TBL_JAVAWORD WHERE idx BETWEEN 1 and 4;  -- idx=1~4
SELECT * FROM  TBL_JAVAWORD WHERE ENGLISH < 'banana';  -- 문자도 가능!

DROP TABLE TBL_JAVAWORD ;

