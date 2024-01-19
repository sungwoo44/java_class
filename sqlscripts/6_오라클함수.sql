-- 24-01-19

--실제로는 테이블의 컬럼으로 함수 실행합니다.   select lower(컬럼명) from 테이블명;

--1. 문자열 함수 
SELECT  INITCAP('hello')		-- 예상 : Hello
			FROM dual;			--initail capital : 첫번째 대문자
SELECT upper('hello') FROM dual; --대문자로 변환.
SELECT LOWER('OraCle') FROM dual; --소문자로 변환.
SELECT LENGTH ('oracle') FROM dual; --문자열 길이 6.
SELECT SUBSTR('java program',3,5) FROM dual; --부분 추출(문자열,위치,길이).결과:
											--*오라클에서 문자열 위치 인덷ㄱ스는 1부터 시작*
SELECT SUBSTR('java program',-5,3) FROM dual; -- 부분 추출결과 : 위치 음수이면 뒤에서부터 

SELECT REPLACE ('java program','pro','프로') FROM dual; -- 문자열 바꾸기. java 프로gram

SELECT INSTR('java program','og') FROM dual; -- 자바의 indexOf
												--결과 8. 해당 문자열이 없으면 결과 0
SELECT trim('java program      ') FROM dual; -- 공백(불필요한 앞뒤 공백 )제거

SELECT LENGTH ('java program     ') FROM dual; -- 공백 포함 17
SELECT LENGTH (trim('java program     ')) FROM dual; -- 공백 제거 후에는  12



--2. 숫자 관련 함수 (정수 또는 실수 number를 대상으로 하는 함수)
--abs(n) : 절대값
--trunc(숫자, 자릿수) : 자리수 맞추기 위해서 버림 
SELECT TRUNC(3.177567,2) FROM dual; ----> 3.17

--round(숫자,자릿수) 반올림
SELECT ROUND(3.177567,2) FROM dual; ----> 3.18

--ceil(숫자) : 실수 -> 정수로 올림 변환
SELECT CEIL (3.177567) FROM dual; ----> 4

--floor(숫자) : 실수 -> 정수로 내림 변환
SELECT FLOOR( 3.177567) FROM dual; ----> 3



-- 3. 날짜 함수 : to_char(날짜 -> 문자열)변환 
--		    to_date (문자열 -> 날짜)변환 
--
SELECT SYSDATE,SYSTIMESTAMP FROM dual; -- systimetamp : 표준시와의 시차(타임존) 표시
SELECT TO_CHAR(SYSDATE,'YYYY"년"-MM"월"-DD"일"') FROM dual;

--yyyy-mm-dd hh24:mi:ss 24시간 기준
--yyyy-mm-dd hh:mi:ss am 12시간 기준 (am 대신 pm 가능)

--TBl_member 테이블에  JOin_date 컬럼 insert
--자동캐스팅 패턴 yyyy-mm-dd 만 가능

INSERT INTO TBL_MEMBER VALUES (2,'박나연','parkny@gmail.com','2022-10-24 13:24:55');  --오류

--★★★ 문자열의 날짜패턴을 알려주고 날짜형식으로 변경하기 ★★★
INSERT INTO TBL_MEMBER VALUES (2,'박나연','parkny@gmail.com',TO_date('2023-10-24 13:24:55','yyyy-mm-dd hh24:mi:ss')); 
INSERT INTO TBL_MEMBER VALUES(10,'홍길동','gdHong@daum.net',TO_date('20240109','yyyymmdd'));

--4. 월 함수
SELECT ADD_MONTHS(sysdate,3) FROM dual; --오늘 날짜 3개월 이후. .첫번째 인자는 날짜 형식, 두번째는 더해지는 값
SELECT to_char(ADD_MONTHS(sysdate,3),'yyyy/mm/dd') FROM dual; --문자열 패턴 기호 - 또는 / 또는 구분기호 없음 가능
SELECT MONTHS_BETWEEN(sysdate,to_date('2022-09-23')) FROM dual; --지정된 2개의 날짜 사이에 간격(월). 결과는 소수점
SELECT TRUNC(sysdate) - to_date('19910404','YYYYMMDD') FROM dual; -- 2개의 날짜형식 값 간격(일)
																-- 2개의 날짜의 간격(일),TRUNC(sysdate) 는 일(day)까지로 변환
SELECT  TRUNC(SYSDATE) FROM dual; 
SELECT SYSDATE  FROM dual;
SELECT SYSDATE +4 FROM dual;
SELECT SYSDATE +123 FROM dual;


