/*
 * DML  : select , insert , update ,delete
 * 		: 테이블의 행 데이터에 대한 조작.
 * 
 * 		※ 기본키가 필요한 이유 ==> 행식별
 * */


--update 테이블명  set 컬럼명1= 변경할 값, 컬럼명2= 변경할 값.....
--			 	where 조건식;

--※예시1 : mina012 회원이 구매한 상품 CJBAb12g의 수량을 모두 10으로 변경하기 
UPDATE TBL_EXBUY 
SET ITEM_QUANTITY =10
WHERE ID = 'mina012' AND ITEM_CODE ='CJBAb12g';

--※예시2 : buy_idx  값이 1001 인 행의 수량을 5로 변경하기 
-- 		: 조건식 컬럼이  pk 컬럼일 때에는 반드시 1개의 행만 수정이 적용된다.

UPDATE TBL_EXBUY 
SET ITEM_QUANTITY =5
WHERE buy_idx = 1001;
SELECT * FROM TBL_EXBUY te ORDER BY BUY_IDX ;


UPDATE TBL_EXBUY 
SET ITEM_QUANTITY =5; -- WHERE 조건이 없는 SQL 은 신중하게!!! 꼭 필요시에만!!






--delete  from 테이블명 where 조건식 : 행전체를 삭제 


DELETE FROM TBL_EXBUY te WHERE buy_idx = 1001;


--결론 : pk 컬럼은 응용프로그램 개발시 없으면 특정 기능을 만들수 없다. 
--★★★★★(행식별)!!!      조회 select 수정 update 삭제 delete 에 반영되는 행을 지정할 수 있다.

------------------------------------------------------------------------------------------

--트랜잭션 : insert, update, delete 에서 반드시 하나의 단위로 처리해야할 작업
--  ex)  momo -> mina 5만원 이체를 합니다. 
-- 		(momo -5) and (mina +5)
-- update 2번!!  2개가 모두실행O 또는 2개 모두실행X   <== 트랜잭션
-- 자동 커밋 : insert, update, delete 가 바로 테이블에 반영되는것.
-- 수동 커밋 : insert, update, delete 가 commit 명령어를 통해 테이블에 반영되는것.
-- rollback : 트랜잭션 취소 명령어


--sql plus  명령어 
-- show autocommit;
-- set autocommit off[on];

--디비버의 auto commit 해제하기. 메뉴 - 데이터베이스 - 트랜잭션 모드 - manual commit!
INSERT INTO tbl_exbuy (buy_idx,id,item_code,item_Quantity)
 VALUES(exbuy_pk_seq.nextval , 'mina012', 'CJBAb12g' , 5);
SELECT * FROM TBL_EXBUY te ;
UPDATE TBL_EXBUY 
SET ITEM_QUANTITY =12
WHERE buy_idx = 1016;
-- 수동 커밋 상태에서 sql plus 실행 c##idev 계정으로 접속하기 
-- 디비버  사용자가 추가한 insert 는 커밋 전까지는 sqlplus 사용자에게 보이지 않는다.
-- 시퀀스는 rollback 적용불가 계속 증가함.

--트랜잭션 취소
ROLLBACK; 

--트랜잭션 처리 완료
COMMIT;
CREATE SEQUENCE Test_seq4;

SELECT Test_seq4.nextval FROM dual;                                                                                   


 