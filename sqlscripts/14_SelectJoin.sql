/*
 * 테이블 조인 : 테이블의 컬럼을 합하는 연산입니다. 
 * 
 * (tip)  UNION : 테이블의 행을 합하는 연산.
 * 
 * step.1 : from 뒤에 2개의 테이블을 나열해보자 
 * 
 * */
 SELECT *
 FROM TBL_CUSTOM tc ,TBL_BUY tb ;
 -- 결과 : 2개의 테이블 공통 컬럼인 custom_id로 모든 경우의 수를 조합하여 합친다.

--step.2 : (동등 조인) = 위의 결과 중 고객 ID 값이 같은 것만 의미가 있으므로 조건식을 추가한 것
SELECT *
FROM TBL_CUSTOM tc ,TBL_BUY tb 
WHERE tc.CUSTOM_ID =tb.CUSTOMID ; 
--tip 고객 중 구매를 한번도 하지 않았다면 조인 결과에 없다.!!

--step.3 : 2단계를 결과로 예시를 만들오보자 
			--1) 2024년에 상품을 구매한 고객의 이메일을 모두 조회하세요
SELECT tb.CUSTOMID ,tc.EMAIL ,tb.BUY_DATE 
FROM TBL_CUSTOM tc ,TBL_BUY tb 
WHERE tc.CUSTOM_ID =tb.CUSTOMID
AND TO_CHAR(BUY_DATE,'yyyy')='2024' ;


--2) 회원 twice가 구매한 상품명과 가격을 조회하세요
SELECT tb.CUSTOMID ,tp.PNAME , tb.QUANTITY ,tp.PRICE  ,tp.PRICE* tb.QUANTITY "금액" 
FROM TBL_PRODUCT tp  ,TBL_BUY tb 
WHERE tp.PCODE =tb.PCODE 
AND tb.CUSTOMID ='twice' ; 


--3) 두개의 테이블을 조인하는 예시를 생각해보자
--  B1 카테고리 상품의 구매 현황(상품명,가격,수량,구매날짜)를 조회하세요.
SELECT tp.PNAME ,tp.PRICE ,tb.QUANTITY ,tb.BUY_DATE 
FROM TBL_BUY tb ,TBL_PRODUCT tp 
WHERE tb.PCODE =tp.PCODE 
AND tp.CATEGORY ='B1';


-- 		2023년에 물품을 구매한 고객의 나이
SELECT tc.NAME ,tc.AGE, tb.BUY_DATE 
FROM TBL_BUY tb ,TBL_CUSTOM tc 
WHERE tb.CUSTOMID =tc.CUSTOM_ID 
AND TO_CHAR(BUY_DATE,'yyyy')='2023';

-- 동등조인 형식 1) select *from 테이블1 t1, 테이블2 t2 where t1.공통컬럼 =t2.공통컬럼;
--			  2) select *
--					from 테이블1 t1
--					JOIN 테이블2 t2
--					on t1.공통컬럼 =t2.공통컬럼;

select *
from TBL_PRODUCT tp 	
JOIN TBL_BUY tb 
on tp.PCODE =tb.PCODE ;


--외부조인 : 테이블2에 없는 값도 테이블1에 있으면 조인에 포함시킴 ex) 구매한 적이 없는 wonder가 나오게함. line12
--		select *
----		from 테이블1 t1
----		left [outer] JOIN 테이블2 t2
----		on t1.공통컬럼 =t2.공통컬럼;

--테이블2 에 없는 값도 테이블1에 있으면 조인에 포함!!
--테이블2 에 해당하는 컬럼값은 null 입니다.
select *
from TBL_CUSTOM tc  	
LEFT JOIN TBL_BUY tb 
on tc.CUSTOM_ID  =tb.CUSTOMID  ;


--예시 : 구매이력이 없는 회원을 조회하세요
select tc.CUSTOM_ID ,tc.NAME ,tc.EMAIL 
from TBL_CUSTOM tc  	
LEFT JOIN TBL_BUY tb 
on tc.CUSTOM_ID =tb.CUSTOMID where tb.BUY_IDX IS null;

-- 구매테이블 상품테이블 위의 추가 예시 
-- 구매이력이 없는 상품 추가
INSERT INTO TBL_PRODUCT tp values('SNACK99','C1','새우깡',5500);

SELECT tp.*, tb.*
from TBL_PRODUCT tp  	
LEFT JOIN TBL_BUY tb 
on tp.PCODE  =tb.PCODE  
where tb.PCODE  IS null;


--형식 3: 오라클에서만 사용하는 조인 형식 (외부 outer 조인)
SELECT *
FROM TBL_PRODUCT tp ,TBL_BUY tb 
WHERE tp.PCODE =tb.PCODE(+) ; -- NULL 값이 발생하는 테이블 컬럼에 "+" 표기 

