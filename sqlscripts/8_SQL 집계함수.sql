/* 
 *
 *	SQL 집계 함수
 *			개수,최대값, 최소값,합계,평균 , 그룹함수
 * 									(group by 와 함께 자주 사용)
 * 
 * */


--1) '성적' 테이블의 전체 행 개수 
SELECT count(*) AS "count" FROM TBL_SCORE ts ;
				 --▲  조회된 함수 결과에 컬럼명을 주려면 as "컬럼명" 으로 합니다.
				 -- 'as' 생략가능

--2) '성적' 테이블의 과목 컬럼 '국어' 값을 갖는 전체 행 개수
SELECT COUNT(*) FROM TBL_SCORE ts  WHERE subject ='국어';

--오류	: 집계함수는 다른 컬럼과 함께 조회하려면 group by 가 필요합니다.
--SELECT subject, COUNT(*) FROM TBL_SCORE ts ;  
--SELECT SUBJECT ,COUNT(*) FROM TBL_SCORE ts  WHERE subject ='국어';

--group by subject 구문이 있으므로 조회 컬럼에 subject 를 추가할 수있다. 
SELECT SUBJECT,COUNT(*)	FROM TBL_SCORE ts GROUP BY SUBJECT; 
SELECT STUNO ,COUNT(*)	FROM TBL_SCORE ts GROUP BY STUNO ; 
-- group by 는 그룹화 컬럼명1, 그룹화 컬럼명2,...,로 정 할수 있다 .

--3) '성적' 테이블의 'jumsu '컬럼의  합계 
SELECT COUNT(*),sum(jumsu) FROM TBL_SCORE ts ;
--4) '성적' 테이블의 '국어'과목 'jumsu'컬럼의 합계
SELECT sum(jumsu) FROM TBL_SCORE ts WHERE SUBJECT = '국어';
--5) '성적' 테이블의 'jumsu '컬럼의  평균 
SELECT AVG(jumsu) FROM TBL_SCORE ts ;
--6) '성적' 테이블의 '국어'과목 'jumsu'컬럼의 평균
SELECT AVG(jumsu) FROM TBL_SCORE ts WHERE SUBJECT = '국어';
--7) '성적' 테이블의 'jumsu '컬럼의  평균 
SELECT MAX(jumsu) FROM TBL_SCORE ts ;
--8) '성적' 테이블의 '국어'과목 'jumsu'컬럼의 평균
SELECT max(jumsu) FROM TBL_SCORE ts WHERE SUBJECT = '역사';

SELECT COUNT(*)"count",SUM(jumsu)"점수",AVG(jumsu)"평균",max(jumsu)"최고점"  FROM TBL_SCORE ts WHERE SUBJECT = '영어';




