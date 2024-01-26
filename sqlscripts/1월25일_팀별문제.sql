/*
 * 
 * 팀별 예시 문제 :
 * 
 * */
--A조
--====================================================================================
--김미나가 구매한 상품 금액 합계(이광원)
SELECT CUSTOMID  ,SUM(PRICE * QUANTITY) "구매 금액"
FROM  TBL_PRODUCT tp
JOIN  TBL_BUY tb ON tp.PCODE = tb.PCODE
AND CUSTOMID ='mina012'
GROUP BY CUSTOMID  ;



--홍길동이 구매한 상품의 갯수는?(권태윤)
SELECT NAME ,SUM(QUANTITY) "상품 갯수"
FROM  TBL_CUSTOM tc 
JOIN  TBL_BUY tb ON tc.CUSTOM_ID = tb.CUSTOMID 
AND NAME ='홍길동'
GROUP BY NAME ;



-- 20살이상 고객님들의 구매한 상품(강주찬)
SELECT tp.*
FROM TBL_PRODUCT tp 
JOIN TBL_BUY tb 
ON tp.PCODE  = tb.PCODE 
JOIN TBL_CUSTOM tc
ON tb.CUSTOMID = tc.CUSTOM_ID
WHERE tc.AGE > 20;

-- 사과를 구매한 사람의 이름과 구매한 갯수만큼의 가격의 합을 구해줘(고길현)
SELECT tc.NAME, sum("구매 금액의 합")
FROM 
	(
	SELECT NAME, tp.PRICE , tp.PRICE * tb.QUANTITY "구매 금액의 합" 
	FROM TBL_CUSTOM tc 
	JOIN TBL_BUY tb 
	ON tc.CUSTOM_ID = tb.CUSTOMID 
	JOIN TBL_PRODUCT tp 
	ON tp.PCODE = tb.PCODE AND tp.PNAME = '청송사과 5kg'
	)tc 
GROUP BY tc.NAME;

-- with 구문이용하여 saleMoney를 그룹으로 묶고 그 중 구매합산 금액 중 20000~70000사이 값을 출력하시오(김태완)
WITH saleMoney
AS
(SELECT tp.PCODE, QUANTITY, PRICE, QUANTITY*PRICE "구매 금액"
      FROM TBL_PRODUCT tp ,TBL_BUY tb 
      WHERE tp.PCODE = tb.PCODE
)
SELECT saleMoney.PCODE,SUM(saleMoney.QUANTITY),SUM("구매 금액")
FROM saleMoney
GROUP BY saleMoney.pcode
HAVING SUM("구매 금액") BETWEEN 20000 AND 70000;

--my
WITH saleMoney
as
(
SELECT tp.PCODE ,tp.PNAME ,tp.PRICE ,(tp.PRICE*tb.QUANTITY) "구매금액"
FROM TBL_BUY tb ,TBL_PRODUCT tp 
WHERE tp.PCODE = tb.PCODE 
)
SELECT salemoney.pname, sum("구매금액")
FROM saleMoney
GROUP BY saleMoney.pname
HAVING sum("구매금액") BETWEEN 20000 AND 70000;


--B조
--====================================================================================
---이대환
--나이가 30이상인 회원들의 나이와 상품코드를 서브쿼리와 조인을 모두 사용해 조회하세요.
SELECT abc.age, abc.pcode FROM (
SELECT * FROM TBL_BUY tb
JOIN TBL_CUSTOM tc ON tb.CUSTOMID = tc.CUSTOM_ID AND age>30) abc
GROUP BY abc.age, abc.pcode;

--my
SELECT tc.NAME ,tc.AGE ,tb.PCODE  
FROM TBL_CUSTOM tc 
JOIN TBL_BUY tb 
ON tc.CUSTOM_ID = tb.CUSTOMID AND tc.AGE >30;




---김승한
--물건을 구매한 사람 중, 가장 나이가 많은 고객을 찾으려고 한다.
--다음 빈칸에 맞는 코드를 넣으시오.
--(테이블이 되는 코드는 ‘13_9번문제.sql 파일을 기반으로 한다.
SELECT tc.CUSTOM_ID, tc.name, tc.age
FROM TBL_CUSTOM tc
JOIN TBL_BUY tb ON CUSTOM_ID=tb.CUSTOMID
WHERE tc.AGE =
(SELECT MAX(age)
FROM TBL_CUSTOM);


SELECT  tc.NAME, tc.AGE  
FROM TBL_CUSTOM tc 
JOIN TBL_BUY tb ON  tc.CUSTOM_ID =tb.CUSTOMID 
WHERE tc.age = (SELECT max(age) FROM TBL_CUSTOM tc2 );



---노희영
--2021년 12월1일 부터 2022년 03월17일 사이에 가장 많이 산 사람의 이름 , 물건이름 , 수량
--순으로 조회하시오
SELECT A.NAME "이름", C.PNAME "물건이름", MAX(B.QUANTITY) ||'개'"수량"
FROM TBL_CUSTOM A, TBL_BUY B, TBL_PRODUCT C
WHERE A.CUSTOM_ID = B.CUSTOMID
AND B.PCODE = C.PCODE
AND QUANTITY = (SELECT MAX(QUANTITY)
FROM TBL_BUY
WHERE BUY_DATE BETWEEN TO_DATE('2021-12-01','yyyy-mm-dd')
AND TO_DATE('2022-03-17','yyyy-mm-dd'))
GROUP BY A.NAME,C.PNAME ;




---이예진
--회원별로 가장 많은 사용금액을 구하시
WITH BIG
AS (
	SELECT TB.PCODE,TB.CUSTOMID, MAX(tp.PRICE * tb.QUANTITY) AS "많이 쓴 금액"
	FROM TBL_PRODUCT tp JOIN TBL_BUY tb ON tp.PCODE = tb.PCODE
	GROUP BY TB.PCODE,TB.CUSTOMID
	)
SELECT BIG.CUSTOMID, MAX("많이 쓴 금액") AS "하나"
FROM BIG
GROUP BY BIG.CUSTOMID;




---이재훈
--구매이력이 2 이상인 고객 중에 나이가 20을 초과한 인원만 조회하세요
SELECT tc.CUSTOM_ID , tc.NAME , tc.EMAIL ,tc.AGE , tb.QUANTITY 
FROM TBL_CUSTOM tc  LEFT JOIN TBL_BUY tb ON tc.CUSTOM_ID = tb.CUSTOMID  
WHERE tb.QUANTITY >=2 AND tc.AGE >20;  

 SELECT *
 FROM TBL_CUSTOM tc 
 JOIN TBL_BUY tb ON tc.CUSTOM_ID= tb.CUSTOMID 
 WHERE tc.AGE >20 AND tb.QUANTITY >=2; 




--민찬희
--tbl_student 와 tbl_score 에서 '김모모'라는 이름을 가진 2021001 학번의 점수를 각각
--출력하고 평균을 구하시오
SELECT st.stuno 학생번호, st.name 이름,sc.JUMSU 점수,(SELECT avg(JUMSU) FROM tbl_score sc WHERE
sc.STUNO='2021001'),sc.SUBJECT 과목 
FROM TBL_STUDENT st INNER JOIN TBL_SCORE sc ON st.stuno = sc.stuno
WHERE st.name = '김모모';


SELECT *
FROM TBL_STUDENT ts1 ; 

SELECT  *
FROM TBL_SCORE ts2 ;

--my
SELECT ts1.STUNO ,ts1.NAME ,ts2.JUMSU ,(SELECT avg(JUMSU) "평균" FROM TBL_SCORE ts WHERE ts.stuno='2021001')
FROM TBL_STUDENT ts1 
JOIN TBL_SCORE ts2 ON ts1.STUNO =ts2.STUNO 
WHERE ts1.name = '김모모';

GROUP BY ts1.STUNO ,ts1.NAME ,ts2.JUMSU;

--C조
--====================================================================================
-- 문제 : 가격이 1만원 이상의 상품마다 각각 고객들이 구매한 개수의 평균을 출력하시오. (출제자 : 임현범)
SELECT tp.PNAME "상품명", avg(tb.QUANTITY) "평균 구매 개수"
FROM TBL_BUY tb 
JOIN TBL_PRODUCT tp ON tb.PCODE = tp.PCODE
WHERE tp.PRICE >= 10000
GROUP BY tp.PNAME;

SELECT *
FROM TBL_BUY tb ;

-- 문제 : 진라면을 구매한 고객의 이름, 구매수량, 구매날짜를 조회하자. (출제자 : 전예진)
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

-- 문제 : 20대 사용자들이 구매한 가격의 평균, 이름, id 조회 (출제자 : 조이루)
SELECT tc.custom_id, tc.name, AVG(tp.price) AS avg_price
FROM TBL_CUSTOM  tc 
JOIN TBL_BUY tb ON tc.custom_id = tb.customId
JOIN TBL_PRODUCT tp ON tb.pcode = tp.pcode
WHERE tc.age BETWEEN 20 AND 29
GROUP BY tc.custom_id, tc.name;

-- 문제 : 2023년에 팔린 상품의 이름과 코드,총 판매액 그리고 총 판매개수를 구하시오. (출제자 : 정제원)
SELECT total.PCODE,PNAME, SUM(QUANTITY) "총 구매개수", SUM("총 가격")
FROM (
    SELECT tp.PCODE,PNAME, QUANTITY, QUANTITY * PRICE "총 가격", BUY_DATE  
    FROM TBL_PRODUCT tp, TBL_BUY tb 
    WHERE tp.PCODE = tb.PCODE AND to_char(BUY_DATE, 'yyyy') = '2023'
) total
GROUP BY total.PCODE, PNAME;

-- 문제 : 미나와 길동이는 한집에 살고 있습니다. 미나와 길동이가 구매한 상품,수량,가격을 조회하세요. (출제나 : 장성우)
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

--D조
--======================================================================================
-- 조하연 문제 : 진라면을 가장 많이 구매한 회원을 구매금액이 높은 순으로 회원아이디와
-- 총 진라면 구매금액을 보여주세요.
SELECT X.CUSTOMID, X.SUM
FROM
(
	SELECT tb.customid, tb.quantity, tp.price, tb.quantity * tp.price AS sum
	FROM TBL_PRODUCT tp, tbl_buy tb
	WHERE tp.pcode = tb.pcode AND tp.pcode = 'JINRMn5'
) X
ORDER BY SUM DESC;
-- 한진만 문제 : 팔린 갯수가 가장 많은 순서로 상품(상품코드와 상품이름)을 정렬하고 총
--팔린 금액을 출력하시오
SELECT tp.PCODE, tp.PNAME, tb.QUANTITY "팔린 갯수" , tb.QUANTITY * tp.PRICE "총
팔린 금액"
FROM TBL_PRODUCT tp LEFT JOIN TBL_BUY tb ON tb.PCODE = tp.PCODE
WHERE tb.BUY_IDX IS NOT NULL
ORDER BY QUANTITY DESC ;
-- 황병훈 문제 : 진라면을 구매한 고객들의 평균 나이를 제품코드(PCODE)와 함께출력해
---주세요.
SELECT PCODE ,AVG(AGE)" 진라면 구매자의 평균 나이"
FROM
(
	SELECT AGE, PCODE
	FROM TBL_CUSTOM tc , TBL_BUY tb
	WHERE tc.CUSTOM_ID = tb.CUSTOMID
	AND PCODE = 'JINRMn5'
)
GROUP BY PCODE;
--조지수 문제 : 30이하 회원별 구매금액을 구하고 회원으로 그룹바이해서 구매금액 합계가
--큰 순으로 정렬
SELECT abc.CUSTOMID, sum(pay_sum) AS total
FROM
(
	SELECT tb.customid, tp.price * tb.quantity AS pay_sum
	FROM TBL_PRODUCT tp, TBL_buy tb
	JOIN TBL_CUSTOM tc ON tb.CUSTOMID = tc.CUSTOM_ID AND age<30
	WHERE tp.pcode = tb.pcode
) abc
GROUP BY abc.CUSTOMID
ORDER BY total DESC;
--한주영 문제 2023년 구매 금액 5만원 이상에게 할인쿠폰을 발송하려 한다.
--CUSTOMID,구매 총액, 구매 일자를 구하시오. COUPON 사용하기
SELECT COUPON.CUSTOMID "고객id", SUM(COUPON.TOTAL) "구매 총액"
FROM (
SELECT
	tb.QUANTITY * tp.PRICE AS TOTAL,BUY_DATE ,tb.CUSTOMID,QUANTITY,PRICE
	FROM
		TBL_PRODUCT tp,TBL_BUY tb
	WHERE tp.PCODE = tb.PCODE AND TO_CHAR(BUY_DATE,'YYYY')='2023'
	) COUPON
GROUP BY COUPON.CUSTOMID
HAVING SUM(COUPON.QUANTITY * COUPON.PRICE)>50000;
-- 차정호 문제 :
--문제 햇반의 총 매출과 팔린 갯수 산사람의 회원 아이디를 구하세요
SELECT dongwon.CUSTOMID, dongwon.Price1 "가격", dongwon.quantity "개수"
FROM
(
	SELECT tb.customid, tb.quantity, tp.price, tp.price* tb.quantity AS Price1
	FROM TBL_PRODUCT tp,
	tbl_buy tb
	WHERE tp.pcode = tb.pcode AND tp.pcode = 'CJBAb12g'
)dongwon