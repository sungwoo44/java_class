/*
 *  스키마 : 데이터베이스 스키마는 데이터베이스에서 자료의 구조, 자료의 표현 방법, 자료 간의 관계를 형식 언어로 정의한 구조
 *			사용자가 계정을 받아서 여러가지 방법으로 데이터(자료)를 저장하고 관리하는 공간
 *			오라클 등  dbms 는 여러객체를 생성하여 사용
 *  view : 가상테이블
 * 			ㄴ 자주사용하는 select 조회 결과를 미리 컴파일 하여 오라클 객체로 저장.ㅏ
 * 			ㄴ select 조회 할때 테이블 처럼 사용.
 * 			ㄴ 그러나 insert,update,delete는 제약이 많고 잘 사용되지 않음.
 * 
 * create view: 권한이 별도로 필요  ==> 관리자 계정 sys 또는 System 
 * 
 * 		실제 비지니스 로직을 처리하는 sql 이 많이 복잡해질 수 있다. (조인 및 서브쿼리 증가)
 * 		--> 잦은 사용으로 인해 성능과 효율적인 측면에서 문제!!
 * 		--> 가상 테이블(뷰) or 프로시져(트랜젝션 단위로 구성)를 사용한다. 
 * 
 * 
 * --<뷰 사용 권한 부여>
 * cmd --> sqlplus
					사용자명 입력: system
					비밀번호 입력:
					마지막 성공한 로그인 시간: 목 1월  18 2024 13:45:26 +09:00
					
					다음에 접속됨:
					Oracle Database 21c Express Edition Release 21.0.0.0.0 - Production
					Version 21.3.0.0.0
					
					SQL> grant create view		<-- 권한 부여
					  2  to c##idev;

 *
 *    디비버에서 접속 재연결!!!
 * 
 *  */
CREATE OR REPLACE VIEW v_customsale
AS 
 SELECT tb.CUSTOMID , tb.PCODE ,sum(tp.PRICE*tb.QUANTITY) as "금액"
 		, RANK() over(PARTITION BY tb.CUSTOMID ORDER BY sum(tp.PRICE*tb.QUANTITY) DESC)AS "ranking" -- 전체 금액 순위
 FROM TBL_BUY tb ,TBL_PRODUCT tp 
 WHERE tb.PCODE = tp.PCODE 
 GROUP BY tb.CUSTOMID ,tb.PCODE;

--일반 테이블의 select 처럼 조회 형식 모두 사용 가능
SELECT *
FROM V_CUSTOMSALE vc 
WHERE CUSTOMID ='mina012';

SELECT *
FROM V_CUSTOMSALE vc 
WHERE "ranking" = 2;

