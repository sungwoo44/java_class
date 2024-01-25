CREATE TABLE tbl_excustomer (
	id char(7) PRIMARY KEY,   
	name varchar2(30) NOT NULL,  
	email varchar2(100),
	age number(3),	
	join_date DATE default sysdate 
);

CREATE TABLE tbl_exproduct(
	item_code nvarchar2(10) PRIMARY key,
	category varchar2(10) NOT NULL,
	item_name varchar2(30) NOT NULL,
	item_price number(10)
);

CREATE TABLE tbl_exbuy(
	id char(7),
	item_code nvarchar2(10),
	item_Quantity number(10) ,
	purchase_date DATE DEFAULT sysdate,
	FOREIGN KEY
			(id)			
	REFERENCES 
		tbl_excustomer(id),
	FOREIGN KEY
			(item_code) 			
	REFERENCES 
		tbl_exproduct(item_code)
);

-- 회원 예시 데이터
INSERT INTO tbl_excustomer VALUES('mina012', '김미나', 'kimm@gmail.com', 20, to_date('2022-03-10 14:23:25','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_excustomer VALUES('hongGD', '홍길동', 'gil@korea.com', 32, to_date('2021-10-21 11:12:23','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_excustomer VALUES('twice', '박모모', 'momo@daum.net', 29, to_date('2021-12-25 19:23:45','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_excustomer VALUES('wonder', '이나나', 'lee@naver.com', 40, sysdate);


-- 상품 예시 데이터
INSERT INTO tbl_exproduct VALUES('DOWON123a', 'B2', '동원참치선물세트', 54000);
INSERT INTO tbl_exproduct VALUES('CJBAb12g', 'B1', '햇반 12개입', 14500);
INSERT INTO tbl_exproduct VALUES('JINRMn5', 'B1', '진라면 5개입', 6350);
INSERT INTO tbl_exproduct VALUES('APLE5kg', 'A1', '청송사과 5kg', 66000);
INSERT INTO tbl_exproduct VALUES('MANGOTK4r', 'A2', '애플망고 1kg', 32000);


--구매 예시 데이터
INSERT INTO tbl_exbuy VALUES('mina012' , 'CJBAb12g' , 5 , to_date('2022-03-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_exbuy VALUES('mina012' , 'APLE5kg' , 2 , to_date('2022-03-10 14:33:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_exbuy VALUES('mina012' , 'JINRMn5' , 2 , to_date('2022-03-16 10:13:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_exbuy VALUES( 'twice' , 'JINRMn5' , 3 , to_date('2021-12-25 19:32:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_exbuy VALUES('mina012' , 'MANGOTK4r' , 2 , to_date('2021-12-25 19:32:15','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_exbuy VALUES( 'hongGD' , 'DOWON123a' , 1 , to_date('2021-10-21 11:13:25','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tbl_exbuy VALUES('mina012' ,  'APLE5kg' , 1 , to_date('2022-04-21 11:13:25','yyyy-mm-dd hh24:mi:ss'));

--내문제
SELECT id"아이디" , ITEM_CODE "상품 코드" , ITEM_QUANTITY "상품 수량" ,PURCHASE_DATE "구매 날짜" FROM  TBL_EXBUY te  WHERE id  like '%ina%' ;
--전예진
SELECT ID  FROM TBL_EXCUSTOMER te WHERE NAME ='김미나';
--임현범
SELECT * FROM TBL_EXCUSTOMER te WHERE MONTHS_BETWEEN(SYSDATE,JOIN_DATE) >= 12  ;
--조이루
SELECT id"아이디",ITEM_CODE"상품코드",ITEM_QUANTITY"수량",sum(ITEM_QUANTITY)"합계" FROM TBL_EXBUY te GROUP BY id , ITEM_CODE,ITEM_QUANTITY; 
SELECT UPPER(id) "구매회원", sum(ITEM_QUANTITY)"구매한개수" FROM TBL_EXBUY GROUP BY id;

--차정호
SELECT ITEM_CODE "상품코드", max(ITEM_QUANTITY) AS "최댓값" FROM TBL_EXBUY te GROUP BY ITEM_CODE ORDER BY  "최댓값" DESC ; 
--정재원
SELECT name FROM TBL_EXCUSTOMER te WHERE  AGE <=33;





--구매 테이블에 기본키 만들기 
--1) 기본키에 들어갈 값은 시퀀스로 만듭니다.  exbuy_pk_seq  시작값 1001
CREATE SEQUENCE exbuy_pk_seq START WITH 1001;
 

--2) 기본키 컬럼명을 buy_idx 로 하여 컬럼 추가 number(8)
ALTER TABLE tbl_exbuy ADD buy_idx number(8); 



--3) 기본 행에 적용할 buy_idx 컬럼값을 저장하기. not null & unique



--4) buy_idx 컬럼에 대하여  primary key 설정
ALTER TABLE TBL_EXBUY ADD CONSTRAINT tbl_exbuy_pk PRIMARY KEY (buy_idx);

--5) 이제부터 새로운 행을 추가할 때에는 시쿼스 함수로  pk 값을 insert 한다. 
INSERT INTO tbl_exbuy (buy_idx,id,item_code,item_Quantity)
 VALUES(exbuy_pk_seq.nextval , 'mina012', 'CJBAb12g' , 5);









