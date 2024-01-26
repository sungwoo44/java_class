/*
 *  프로시저 직접 만들어보기 : money_of_day
 * 	매개변수 IN : 고객id, 날짜(패턴은 'yyyy-mm-dd')
 * 	매개변수 OUT : IN으로 받은 값들을 tbl_buy에서 상품코드를 조회하여 총 구매 금액을 구합니다.
 * 
 * 			단, 고객은 1일 1품목만 구매 가능합니다.
 * 
 * 	프로시저 실행
 * 	DECLARE
 * 		vmoney number(8);
 * 	BEGIN
 * 		money_of_day('mina012', '2023-11-10', vmoney);
 * 		dbms_output.put_line('고객님의 구매금액은 ' || vmoney || '입니다.');
 * 	END; 
 * */

CREATE OR REPLACE PROCEDURE "C##IDEV".money_of_day (
	acustomid IN tbl_buy.CUSTOMID %TYPE,
	abuydate IN DATE,
	amoney OUT NUMBER
)
IS
	vpcode tbl_buy.PCODE %TYPE;
	vquantity NUMBER;
	vprice NUMBER;
BEGIN
	SELECT PCODE, QUANTITY
		INTO vpcode, vquantity
	FROM TBL_BUY
	WHERE
		CUSTOMID = acustomid AND 
		TO_CHAR(BUY_DATE, 'yyyy-mm-dd') = abuydate;
	SELECT PRICE
		INTO vprice
	FROM TBL_PRODUCT
	WHERE PCODE = vpcode;
	SELECT vprice * vquantity
		INTO amoney
	FROM dual;
	dbms_output.put_line('총 구매 금액 : ' || vprice);
	EXCEPTION
		WHEN OTHERS THEN
		dbms_output.put_line('실행 실패!');
END;

DECLARE
	vmoney number(8);
BEGIN
	money_of_day('mina012', '2023-11-10', vmoney);
	dbms_output.put_line('고객님의 구매금액은 ' || vmoney || '입니다.');
END; 

	
