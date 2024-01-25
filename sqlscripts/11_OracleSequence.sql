/*
 *  시퀀스 : 오라클의 객체. 값을 자동으로 생성해줌.
 * 	ex) 일련번호로 사용하는 값. 행을 식별하기위함 
 *  	mysql 은 auto increment 속성으로 사용
 * 
 */

--1. 시퀀스 생성
CREATE SEQUENCE test_seq;

--2. 시퀀스 사용을 위한 함수 : nextval (다음 시퀀스 값)& currval (현재 시퀀스 값)


SELECT test_seq.nextval FROM dual; --  현재시퀀스값(currval)은 nextval 을 실행시킨후 (= 값이 생성된 이후)
SELECT test_seq.currval FROM dual;



--3. 시퀀스 시작값을 바꿔보기
CREATE SEQUENCE test_seq2 START WITH 2002;

SELECT test_seq2.nextval FROM dual; --  현재시퀀스값(currval)은 nextval 을 실행시킨후 (= 값이 생성된 이후)
SELECT test_seq2.currval FROM dual;


--4. 증가값 바꾸기 
CREATE SEQUENCE test_seq3 INCREMENT BY 5;
SELECT test_seq3.nextval FROM dual; --  현재시퀀스값(currval)은 nextval 을 실행시킨후 (= 값이 생성된 이후)
SELECT test_seq3.currval FROM dual;
