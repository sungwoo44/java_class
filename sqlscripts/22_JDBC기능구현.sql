--jdbc 프로젝트를 위한 SQL 테스트 


--회원가입 
INSERT 


--회원정보수정 : email, age
UPDATE TBL_CUSTOM SET EMAIL ='test@gmail.com',age=22
WHERE CUSTOM_ID ='nayeon2';



--회원 탈퇴: 
 DELETE  FROM TBL_CUSTOM tc 
 WHERE custom_id ='toto';

--주요 정리 : 컬럼조회 한 결과는 1개 또는 1개 이상에 따라 리턴 형식을 결정하자 (List!)
--상품 검색하기 		ProductVo,tblProductDao 만들기
--								ㄴ selectByCategory, selectByPname  메소드 만듭시다. 
--1) 어떤 카테고리가 있는지 보여주기 
SELECT DISTINCT CATEGORY 		--중복된 값은 한번만.(중복제거)
FROM TBL_PRODUCT tp; 

--2) 특정 타케고리에 대해 상품 목록 보여주기 
SELECT * FROM TBL_PRODUCT tp 
WHERE CATEGORY = 'B1';

--3) 상품명 유사(like) 검색
SELECT *
FROM TBL_PRODUCT tp 
WHERE PNAME LIKE '%'||'사과'||'%';


--MyPage 기능의 메소드를 위한 SQL
-- selectCustomBuyList --> tblBuyDao
						--> 아래 조회된 행들에 대한 컬럼과 매핑되는 CustomBuyvo를 만들어야합니다.
SELECT buy_idx,tb.PCODE,pname,price,QUANTITY ,BUY_DATE 
FROM TBL_BUY tb 
JOIN TBL_PRODUCT tp 
ON tb.PCODE  = tp.PCODE 
WHERE tb.CUSTOMID = 'mina012';



