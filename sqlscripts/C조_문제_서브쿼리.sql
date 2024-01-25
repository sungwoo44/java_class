-- 문제 : 가격이 1만원 이상의 상품마다 각각 고객들이 구매한 개수의 평균을 출력하시오. (출제자 : 임현범)
SELECT tp.PNAME "상품명", avg(tb.QUANTITY) "평균 구매 개수"
FROM TBL_BUY tb 
JOIN TBL_PRODUCT tp ON tb.PCODE = tp.PCODE
WHERE tp.PRICE >= 10000
GROUP BY tp.PNAME;

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