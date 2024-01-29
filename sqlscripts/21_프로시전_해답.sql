
SELECT PCODE, QUANTITY							
   FROM TBL_BUY
   WHERE CUSTOMID = 'mina012' AND to_char(BUY_DATE,'yyyy-mm-dd') = '2023-11-10';




CREATE OR REPLACE PROCEDURE "C##IDEV".money_of_day(
   p_id IN tbl_custom.custom_id %TYPE,      -- 출력(리턴) 변수
   p_date IN varchar2,      -- 출력(리턴) 변수
   p_money OUT NUMBER
)
IS
   v_pcode TBL_BUY.PCODE %TYPE;
   v_quantity TBL_BUY.QUANTITY %TYPE;
   v_price TBL_PRODUCT.PRICE %TYPE;
BEGIN
   SELECT PCODE, QUANTITY								-- 1일 1구매 조건으로 오직 1개의 행이 조회됩니다.
      INTO v_pcode , v_quantity							-- 조회 결과가 n 개의 행이면 프로시저의 커서 기능을 이용합니다.
      --into는 프로시저에서만 사용한다. (조회 결과를 저장하기 위함)
   FROM TBL_BUY
   WHERE CUSTOMID = p_id AND to_char(BUY_DATE,'yyyy-mm-dd') = p_date;
   
   DBMS_OUTPUT.PUT_LINE(CHR(10)||'* p : ' || v_pcode ||CHR(10)||'*수량: ' || v_quantity );
   SELECT PRICE
      INTO v_price
   FROM TBL_PRODUCT
   WHERE PCODE = v_pcode;
   DBMS_OUTPUT.PUT_LINE('* p : ' || v_price);
   SELECT v_quantity * v_price
      INTO p_money
   FROM dual;					-- 수량*가격 수식 연산결과를 출력매개변수 p_money 에 저장
   								-- 특정 테이블과 상관 없으므로 dual 임시 테이블 사용하여 연산합니다.
   DBMS_OUTPUT.PUT_LINE('* m : ' || p_money);
   EXCEPTION
   WHEN no_data_found then
   DBMS_OUTPUT.PUT_LINE(CHR(10)||'조건에 맞는 데이터가 없습니다.');
   p_money :=0;
END;


DECLARE
    VMONEY NUMBER(8);  		-- 프로시저 실행결과 OUT 매개변수값 저장.
    vid tbl_custom.custom_id %TYPE;
    vdate varchar2(20);
BEGIN
	vid :='mina012';
	vdate :='2023-11-10';
    MONEY_OF_DAY(vid,vdate,vmoney); 
    -- vid, vdate IN 매개변수에 프로시저 실행 결과를 전달 받습니다.
    DBMS_OUTPUT.PUT_LINE('고객ID: ' || VID||CHR(10) ||'날짜: '||VDATE);
    DBMS_OUTPUT.PUT_LINE('고객님의 구매금액은 ' || vmoney|| '입니다.');
END;
   