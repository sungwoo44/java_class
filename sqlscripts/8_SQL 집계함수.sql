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

/*
 * 집계함수 count, avg , sum, min, max 등 그룹 함수라고도 합니다. 
 * 그룹화 - 지정한 컬럼값이 같을 것을 갖는 행에 대해 집계 함수를 실행합니다.
 *      
 * 
 * select 
 *      그룹화컬럼, 그룹함수
 * 		from 테이블이름
 * 		[WHERE] 그룹화하기 이전의 조건식
 * 		GROUP BY 그룹화에 사용할 컬럼명
 * 		[HAVING] 그룹화 후에 그룹화 결과값을 사용하는 조건식
 * 		[ORDER BY] 정렬 컬럼
 */
--관련문제1) 학번(학생)별로 수강한 갯수와 평균을 조회 해보자
SELECT count(*),avg(jumsu) FROM TBL_SCORE ts GROUP BY STUNO;

--문제2) 위의 결과를 바탕으로 평균이 80점 미만인 학번(학생)을 조회해보자
SELECT count(*),avg(jumsu) FROM TBL_SCORE ts GROUP BY STUNO HAVING avg(jumsu)<80;
				-- if 예를 들어 점수가 80점 이상으로 한다면 where 조건절로 할수 있음 
				--			where jumsu >=80 group by stuno;

--문제2-2) 점수가 80점 이상 데이터만 조회해보자  ★★★☆☆예시1번과 데이터를 잘비교해봐야함!!
SELECT count(*),avg(jumsu) FROM TBL_SCORE ts WHERE JUMSU >=80 GROUP BY STUNO;


--문제3) 문제1번의 결과를 평균 내림차순으로 조회
SELECT count(*),avg(jumsu) FROM TBL_SCORE ts GROUP BY STUNO ORDER BY avg(JUMSU) DESC ;

--문제5) 학기 교사별 count -avg 조회
SELECT TERM ,TEACHER ,count(*),avg(JUMSU)
FROM TBL_SCORE ts 
GROUP BY TERM , TEACHER 	-- 학기별로 그룹화하가 2차로 학기가 같은 결과안에서 선생님별로 그룹화
ORDER BY TERM;



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




