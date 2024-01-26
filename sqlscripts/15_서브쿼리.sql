/*
 * 
 *  서브쿼리(sub query) : select 조회 결과가(여러개의행) 다른 DML 명령어에 쓰일 수 있습니다. 
 * 													ㄴ select,insert,update,delete
 * 					 그때 다른 DML(select,insert,update,delete ) 에 포함되는 select를 서브쿼리라고 합니다. 
 * 
 * 
 * 	select  함께 쓰이는 서브쿼리
 * 					: select  컬럼1,컬럼2 from ( select.....)
 * 										where 컬럼명1 = 값(select....)
 * 
 * 	select 서브쿼리는 join으로 대체가능
 * 
 * 
 * --1) where 에서 쓰는 서브쿼리 : twice 가 구매한 상품 정보 
 * 
 * */
--조인
SELECT tp.*
FROM TBL_PRODUCT tp  ,TBL_BUY tb 
WHERE tp.PCODE =tb.PCODE 			--1)크로스 연산
AND tb.CUSTOMID ='twice' ; 			--2)조건식 연산


--서브쿼리
SELECT tp.*
FROM TBL_PRODUCT tp  
WHERE PCODE  IN 					--2)조건식 연산		
(SELECT PCODE FROM TBL_BUY tb WHERE tb.CUSTOMID ='twice');--1)조건식 연산

--SELECT tp.PCODE ,tp.PNAME , tb.QUANTITY ,tp.PRICE  ,tp.PRICE * tb.QUANTITY "금액" 
--	FROM TBL_PRODUCT tp  ,TBL_BUY tb 
--	WHERE tp.PCODE =tb.PCODE;

--2) from 에서 사용되는 서브쿼리1
SELECT 
	saleMoney.PCODE,sum(QUANTITY),sum("금액")
FROM 
	(SELECT tp.PCODE ,tp.PNAME , tb.QUANTITY ,tp.PRICE  ,tp.PRICE * tb.QUANTITY "금액" 
	FROM TBL_PRODUCT tp  ,TBL_BUY tb 
	WHERE tp.PCODE =tb.PCODE) saleMoney
GROUP BY saleMoney.PCODE;

--2) from 에서 사용되는 서브쿼리2
SELECT 
    tp.PCODE,
    SUM(tb.QUANTITY) ,
    SUM(tp.PRICE * tb.QUANTITY) 
FROM 
    TBL_PRODUCT tp
JOIN 
    TBL_BUY tb ON tp.PCODE = tb.PCODE
GROUP BY 
    tp.PCODE;
   
--2) from 에서 사용되는 서브쿼리3
SELECT 
    tp.PCODE,
    SUM(tb.QUANTITY) ,
    SUM(tp.PRICE * tb.QUANTITY) 
FROM 
    TBL_PRODUCT tp, TBL_BUY tb
WHERE 
    tp.PCODE = tb.PCODE
GROUP BY 
    tp.PCODE;
    
--오라클 with 구문 : select 조회 결과를 저장해 놓고 사용하도록 합니다. 
WITH saleMoney   
AS
(
	SELECT tp.PCODE ,tp.PNAME , tb.QUANTITY ,tp.PRICE  ,tp.PRICE * tb.QUANTITY "금액" 
	FROM TBL_PRODUCT tp  ,TBL_BUY tb 
	WHERE tp.PCODE=tb.PCODE
)
SELECT saleMoney.PCODE,
    SUM(saleMoney.QUANTITY) ,
    SUM(saleMoney.PRICE * saleMoney.QUANTITY) 
FROM SALEMONEY
GROUP BY SALEMONEY.pcode;
	
-- 서브쿼리와 조인을 이용한 문제를 한개씩 만들어 팀별로 공유해보세요.
WITH minaGD
as(
SELECT *
FROM TBL_BUY tb 
WHERE CUSTOMID = 'twice' OR  CUSTOMID ='hongGD' 
)
SELECT tp.PNAME, minaGD.quantity,tp.PRICE 
FROM minaGD
JOIN TBL_PRODUCT tp
ON minaGD.PCODE = tp.PCODE ;

--현범
--가격이 1만원 이상의 상품마다 각각 고객들이 구매한 개수의 평균을 출력하시오.
SELECT tp.PNAME "상품명", avg(tb.QUANTITY)
FROM TBL_BUY tb 
JOIN TBL_PRODUCT tp ON tb.PCODE = tp.PCODE
WHERE tp.PRICE >= 10000
GROUP BY tp.PNAME;

--재원
-- 2023년에 팔린 상품의 이름과 코드,총 판매액 그리고 총 판매개수를 구하시오.
SELECT total.PCODE,PNAME, SUM(QUANTITY) "총 구매개수", SUM("총 가격")
FROM (
    SELECT tp.PCODE,PNAME, QUANTITY, QUANTITY * PRICE "총 가격", BUY_DATE  
    FROM TBL_PRODUCT tp, TBL_BUY tb 
    WHERE tp.PCODE = tb.PCODE AND to_char(BUY_DATE, 'yyyy') = '2023'
) total
GROUP BY total.PCODE, PNAME;

--조이루
--20대 사용자들이 구매한 가격의 평균, 이름, id 조회
SELECT tc.custom_id, tc.name, AVG(tp.price) AS avg_price
FROM TBL_CUSTOM  tc 
JOIN TBL_BUY tb ON tc.custom_id = tb.customId
JOIN TBL_PRODUCT tp ON tb.pcode = tp.pcode
WHERE tc.age BETWEEN 20 AND 29
GROUP BY tc.custom_id, tc.name;

--전예진
--진라면을 구매한 고객의 이름, 구매수량, 구매날짜를 조회하자.
WITH bi 
AS (
    SELECT CUSTOMID, PCODE, QUANTITY "구매수량", BUY_DATE "구매날짜"
    FROM TBL_BUY
    WHERE PCODE = 'JINRMn5'
)
SELECT tc.NAME "고객명", bi.구매수량, bi.구매날짜
FROM bi
JOIN TBL_CUSTOM tc 
ON bi.CUSTOMID = tc.CUSTOM_ID;

-- 서브쿼리와 조인을 이용한 문제를 한 개씩 만들어 팀별로 공유해보세요.
--	ㄴ 조장이 문제와 답을 모아주세요, 내일 수업 전에 전달해 주세요 .
--고객별로 구맥금액이 가장 높은 상품코드를 조회하세요.
--  ㄴ 오라클 rank 함수	(그룹화 결과에 대한 순위를 제공)
--  내림차순 또는 오름차순 정렬된 결과에서 TOP3 조회하기   


