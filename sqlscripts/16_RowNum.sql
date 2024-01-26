/*
 *		오라클 ROWNUM 컬럼: 오라클이 select 결과에 부여하는 행번호 
 *						 오라클이 내부적으로 관리를 위한 컬럼
 * */
--1) 상품 테이블의 가격을 내림차순으로 정렬하여 조회.
SELECT * FROM TBL_PRODUCT tp 
ORDER BY price DESC;

--2)rownum 컬럼을 출력해봅시다. 정렬 이전의 rownum! 
SELECT rownum,tp.* FROM TBL_PRODUCT tp 
ORDER BY price DESC; 

--3)서브쿼리를 이용한 rownum 출력
SELECT rownum, tp.*
FROM 
	(
	SELECT * 
	FROM TBL_PRODUCT tp 
	ORDER BY PRICE DESC
	)tp;
	
--4) 위에 결과에 조건을 붙여보자 
SELECT rownum, tp.*
FROM 
	(
	SELECT * 
	FROM TBL_PRODUCT tp 
	ORDER BY PRICE DESC
	)tp
--WHERE rownum = 1;	-- 잘나옴
--WHERE rownum = 2;	--	값을 못가져옴 rownum 1 이 포함되는 경우만 가능!
--WHERE rownum <4 ; -- 1~ 4 까지 
--WHERE rownum is not null;
	
--5) 중간 일부를 가져오기 위해서 between~and 연산으로 4)번을 대상으로 서브쿼리를 이용해야함.
	--ex) 게시판 페이지 번호를 적용하여 글목록 생성시 
SELECT *
FROM 
	(
	SELECT rownum r, tp.*
	FROM 
		(
		SELECT * 
		FROM TBL_PRODUCT tp 
		ORDER BY PRICE DESC
		)tp
	)
WHERE r BETWEEN 2 AND 4;

--6) 오라클 12C 버전부터 FETCH 명령이 있다. 
SELECT * FROM TBL_PRODUCT tp 
ORDER BY PRICE DESC 
FETCH first 4 ROWS ONLY;   --4)번 조건식 WHERE 부분이랑 동일



