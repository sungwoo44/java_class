 /*
 * 오라클의 rank 함수
 * 	예제: 고객-상품별 최대구매금액을 구하고 해당 상품코드 조회하기 
 * 		ㄴ 고객ID 1차 그룹화, 고객 내에서 상품코드로 2차 그룹화
 * 
 * */
 --미나 진라면 추가구매
 INSERT INTO TBL_BUY tb values(buy_pk_seq.nextval,'mina012','JINRMn5',13,'2024-01-26');
 

--1)
 SELECT tb.CUSTOMID , tb.PCODE ,sum(tp.PRICE*tb.QUANTITY) as "금액"
 		--가격*수량에 대한 그룹화 함수  sum 실행
 FROM TBL_BUY tb ,TBL_PRODUCT tp 
 WHERE tb.PCODE = tp.PCODE 
 GROUP BY tb.CUSTOMID ,tb.PCODE;
 

--2) 1)결과에 정렬 해보자
 SELECT tb.CUSTOMID , tb.PCODE ,sum(tp.PRICE*tb.QUANTITY) as "금액"
 		--가격*수량에 대한 그룹화 함수  sum 실행
 FROM TBL_BUY tb ,TBL_PRODUCT tp 
 WHERE tb.PCODE = tp.PCODE 
 GROUP BY tb.CUSTOMID ,tb.PCODE
 ORDER BY tb.CUSTOMID ,"금액" desc;


--3) RANK  함수를 이용해서 고객별 최대금액 물품만 조회해 보자 
 SELECT tb.CUSTOMID , tb.PCODE ,sum(tp.PRICE*tb.QUANTITY) as "금액"
 		, RANK() over(ORDER BY sum(tp.PRICE*tb.QUANTITY) DESC)AS "ranking" -- 전체 금액 순위
			--over() 안에는 어떤 컬럼으로 정렬해서 순위를 매기는지 대한내용.	
 FROM TBL_BUY tb ,TBL_PRODUCT tp 
 WHERE tb.PCODE = tp.PCODE 
 GROUP BY tb.CUSTOMID ,tb.PCODE;

--4) 
 SELECT tb.CUSTOMID , tb.PCODE ,sum(tp.PRICE*tb.QUANTITY) as "금액"
 		, RANK() over(PARTITION BY tb.CUSTOMID ORDER BY sum(tp.PRICE*tb.QUANTITY) DESC)AS "ranking" -- 전체 금액 순위
 FROM TBL_BUY tb ,TBL_PRODUCT tp 
 WHERE tb.PCODE = tp.PCODE 
 GROUP BY tb.CUSTOMID ,tb.PCODE;


SELECT tb.CUSTOMID , sum(tb.QUANTITY* tp.PRICE),RANK() over(PARTITION BY tb.CUSTOMID ORDER BY sum(tb.QUANTITY* tp.PRICE)desc)AS "rank"
FROM TBL_BUY tb ,TBL_PRODUCT tp 
WHERE tb.PCODE = tp.PCODE 
GROUP BY tb.CUSTOMID ;



--5) 4번을 서브쿼리로 하여 rank =1 인 조건을 적용하기
WITH customTop
AS
( SELECT tb.CUSTOMID , tb.PCODE ,sum(tp.PRICE*tb.QUANTITY) as "금액"
 		, RANK() over(PARTITION BY tb.CUSTOMID ORDER BY sum(tp.PRICE*tb.QUANTITY) DESC)AS "ranking" -- 전체 금액 순위
 FROM TBL_BUY tb ,TBL_PRODUCT tp 
 WHERE tb.PCODE = tp.PCODE 
 GROUP BY tb.CUSTOMID ,tb.PCODE
)
SELECT *
FROM customTop
WHERE "ranking" =1;

 