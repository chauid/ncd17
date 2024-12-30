-- emp 테이블로 연습
-- job 컬럼의 데이타중 중복되는데이타는 한번만 출력해보자
select DISTINCT job from emp;
select DISTINCT job,ename from emp;-- 다른 컬럼하고 같이 쓸경우 적용이 안되거나 오류가 날수도 있다
select * from emp; --전체 컬럼데이타 조회
select ename,job from emp; --일부 컬럼만 조회
select ename,job from emp order by ename; -- ename 의 오름차순 조회(asc 인경우는 생략)
select ename,job from emp order by ename desc;-- ename의 내림차순 조회(desc 인경우는 생략안됨)

-- job 의 오름차순,같은 job 일경우는 ename 의 내림차순 조회
select job,ename from emp order by job,ename desc;
-- job 의 오름차순,같은 job 일경우는 ename 도 오름차순 조회
select job,ename from emp order by job,ename;
--순서를 정할때 컬럼명 대신 컬럼번호로 해도 된다(첫번째 컬럼은 1)
select job,ename from emp order by 1,2; -- job(1),ename(2)

--sal 의 오름차순 정렬
select * from emp order by 6;
select * from emp order by sal;

--empno 의 오름차순 조회
select ename,sal,comm,job,empno from emp order by 5;
select ename,sal,comm,job,empno from emp order by empno;

-- ename 의 내림차순
select ename,sal,comm,job,empno from emp order by 1 desc;
select ename,sal,comm,job,empno from emp order by ename desc;

-- where 조건문
select ename,job,sal,comm from emp where sal>=1500;
select ename,job,sal,comm from emp where ename='allen'; --데이타는 대소문자 정확히 써야한다
select ename,job,sal,comm from emp where ename='ALLEN'; 

-- ENAME 이 A로 시작하는 데이타 조회
select ename,job,sal,comm from emp where ename LIKE 'A%';
-- ENAME 에 A가 포함되는 데이타 조회
select ename,job,sal,comm from emp where ename LIKE '%A%';
--ENAME 에 A로 시작하거나 S로 시작하는 데이타 조회
select ename,job,sal,comm from emp where ename LIKE 'A%' OR ename LIKE 'S%';
--ENAME 에 A와 S를 모두 포함하는 데이타만 출력
select ename,job,sal,comm from emp where ename LIKE '%A%' AND ename LIKE '%S%';

--ENAME 의 두번째 글자가 A 인사람만 조회
select ename,job,sal,comm from emp where ename LIKE '_A%' ORDER BY SAL;
--ENAME 의 두번째 글자가 A이거나 세번째가 A 인사람만 조회
select ename,job,sal,comm from emp where ename LIKE '_A%' OR ENAME LIKE '__A%';

--ENAME 이 N이나 K 로 끝나는 사람만 조회
select ename,job,sal,comm from emp WHERE ENAME LIKE '%N' OR ENAME LIKE '%K';

--JOB 이 ANALYST이면서 SAL 이 1500 이상인 사람 조회
select ename,job,sal,comm from emp WHERE JOB='ANALYST' AND SAL>=1500;

--SAL 1200~2000 사이값 조회
select ename,job,sal,comm from emp WHERE SAL>1200 AND SAL<=2000; --방법1
select ename,job,sal,comm from emp WHERE SAL BETWEEN 1200 AND 2000;--방법2

-- JOB 이 MANAGER,SALESMAN,ANALYST 이 3가지 직업의 사람을 조회
select ename,job,sal,comm from emp WHERE JOB='MANAGER' OR JOB='SALESMAN' OR JOB='ANALYST';--방법1
select ename,job,sal,comm from emp WHERE JOB IN ('MANAGER','SALESMAN','ANALYST');--방법2

--EMPNO 가 7654,7788,7844,7902 인 사람만 조회(IN 을 이용해서)
select EMPNO,ename,job,sal,comm from emp WHERE EMPNO IN (7654,7788,7844,7902);

--COMM 이 NULL 인 데이타만 조회
select ename,job,sal,comm from emp WHERE COMM IS NULL;

--COMM 이 NULL이 아닌경우 데이타만 조회
select ename,job,sal,comm from emp WHERE COMM IS NOT NULL;

--MGR 이 NULL 이 아닌경우만 조회
select * from emp where mgr is not null;

--comm 이 null 인경우는 0으로 출력,mgr은 null인경우 100으로
select ename,job,sal,NVL(mgr,100),NVL(comm,0) from emp;

select sal,comm,sal+comm from emp; -- comm 이 null 일경우 sal+comm 도 null
-- 위의 경우 sal+comm 이경우 comm이 null 이면 0으로 계산
select sal,comm,sal+NVL(comm,0) from emp; 








