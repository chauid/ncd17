-- system 에 등록된 table 들 확인하기
-- 커서가 있는곳의 sql 문 실행 단축키 : ctrl+enter
select * from tab;

--등록된 user(계정)들 확인
select username from dba_users; -- dba_users 테이블에서 username 이라는 컬럼만 확인하기

--dba_users 라는 테이블에는 어떤 컬럼이 있을까
desc dba_users; --기본 구조만 확인(데이타는 확인안됨)
select username,account_status from dba_users; -- 계정과 lock상태 알아보기

-- scott 계정에 비번은 tiger 로 생성해보자
create user scott IDENTIFIED by tiger; --오류 발생, 12버전부터 오류발생

-- 12버전부터는 user명에 공통문자열 c## 이 들어가야된다
-- 일단 c##scott/ 비번은 tiger 로 만들어보자
create user c##scott IDENTIFIED by tiger;

--c##scott 계정을 삭제후 공통문자열을 안넣고도 생성하는 방법으로 다시 생성해보자
drop user c##scott;

alter SESSION set "_ORACLE_SCRIPT"=TRUE;--SESSION 변경    

--C## 공통문자열을 빼고 다시 생성해보자(SCOTT/TIGER)
create user scott IDENTIFIED by tiger;

--angel/a1234 로 만들어보자
CREATE user angel IDENTIFIED by a1234;

select username,account_status from dba_users; -- 계정과 lock상태 알아보기

-- angel 계정에 lock 설정
alter user angel ACCOUNT lock;

-- angel 계정에 lock 설정해제
alter user angel ACCOUNT UNLOCK;

-- scott와 angel 계정에 기본 권한을 주자
--connect:접속할수 있는 권한
--resource:데이타 관리를 할수있는권한
grant connect,resource to angel;
grant connect,resource to scott;

--생성된 계정에서 테이블을 생성하고 데이타를 추가하려고 하면 table space 에 대한 오류가 발생
--table space 를 unlimit 로 설정(system 계정에서만 할수있다)
alter user angel default tablespace users quota unlimited on users;
alter user scott default tablespace users quota unlimited on users;

-- angel 의 비번을 a1234 에서 pw1234 로 변경해보자
alter user angel IDENTIFIED by pw1234;



