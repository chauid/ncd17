-- 12월 30일 오라클 문제
--1 . 어떤 종류의 직업이 있는지 job 을 한번씩만 출력하는데 직업의 오름차순으로 출력하시오
select DISTINCT job from emp order by job;
--2.  ename 에 대소문자 상관없이 's'를 포함하고 있는 데이타출력(컬럼:ename,job,sal)
select ename,job,sal from emp where lower(ename) like '%s%';
--3.  ename 의 3번째 글자가 L 인 사람을 조회하시오(컬럼:ename,sal,comm)
select ename,sal,comm from emp where ename like '__L%';
--4.  comm 이 null 이 아닌사람중에 sal이 1500 이상인 사람 출력(컬럼: ename,sal,comm)
select ename,sal,comm from emp where comm is not null and sal>=1500;
--5. hiredate 입사일이 5월인 사람은 모두 출력(컬럼:ename,hiredate,sal)
select ename,hiredate,sal from emp where to_char(hiredate,'mm')='05';
select ename,hiredate,sal from emp where to_char(hiredate,'mm')=5;
--6. hiredate 입사일이 1985-01-01 이후에 입사한사람 출력(컬럼: ename,hiredate,sal)
select ename,hiredate,sal from emp where hiredate>='1985-01-01';
--7. sal이 1500-3000 사이인 사람을 출력하는데 관계연산자와 and를 이용해서 출력
select ename,sal,mgr from emp where sal>=1500 and sal<=3000;
--8  7번의 결과를 between 을 이용해서 출력(컬럼:ename,sal,mgr)
select ename,sal,mgr from emp where sal BETWEEN 1500 and 3000;
--9. in을 이용해서 job 이 clerk,president,manager 인 사람의 전체 컬럼을 모두 출력
select * from emp where job in ('CLERK','PRESIDENT','MANAGER');
--10.ename,sal,comm,sal*comm 을 출력하는데 comm 이 null 인경우 1로 변경해서 출력하고 계산하기
select ename,sal,NVL(comm,1),sal*NVL(comm,1) from emp;
--11. ename 이 ADAMS인 사람의 SAL보다 더 많이 받는사람출력(컬럼명:ENAME,JOB,SAL)
select ENAME,JOB,SAL from emp where sal>(select sal from emp where ename='ADAMS');
--12. 평균SAL 보다 작은 사람의 전체 컬럼 출력
SELECT * FROM EMP WHERE SAL<(SELECT AVG(SAL) FROM EMP);
--13. ENAME 이 A나 S나 M으로 시작하는 모든 사람 출력(컬럼:ENAME,JOB,SAL)
SELECT ENAME,JOB,SAL FROM EMP WHERE ENAME LIKE 'A%' OR ENAME LIKE 'S%' OR ENAME LIKE 'M%'; 
SELECT ENAME,JOB,SAL FROM EMP WHERE ENAME IN ('A%','S%','M%');--안됨
--14. MGR 을 GROUP 로 인원수와 평균SAL 을 구하시오(평균SAL은 무조건 올림으로)-1원단위는 반올림
SELECT MGR,COUNT(*) 인원수,ROUND(AVG(SAL),-1) 평균급여 FROM EMP WHERE MGR IS NOT NULL GROUP BY MGR;
--15. SCOTT 의 SAL 과 같은 SAL 을 받는사람을 조회하시오(컬럼:ENAME,SAL)
SELECT ENAME,SAL FROM EMP WHERE SAL=(SELECT SAL FROM EMP WHERE ENAME='SCOTT');
--16. ENAME 의 글자길이가 4글자인 사람만 조회(컬럼:ENAME,JOB)
SELECT ENAME,JOB FROM EMP WHERE LENGTH(ENAME)=4;
--17. ENAME의 3번째 글자가 R이거나 A인사람 조회(컬럼:ENAME,JOB)
SELECT ENAME,JOB FROM EMP WHERE ENAME LIKE '__R%' OR ENAME LIKE '__A%';
--18. JOB 직업별로 인원수와 최고연봉을 출력하는데 직업의 오름차순으로 출력
SELECT JOB 직업,COUNT(*) 인원수,MAX(SAL) 최고연봉 FROM EMP GROUP BY JOB ORDER BY 1;
--19. || 연산자를 이용하여 다음과 같이 하나의 컬럼으로 출력하시오(EMP테이블로)
----    (예) SCOTT 의 직업은 CLERK 이며 입사년도는 1989년 05월입니다(컬럼명은 자기소개)
SELECT ENAME||'의 직업은 '||JOB||'이며 입사년도는 '||TO_CHAR(HIREDATE,'YYYY')||'년'
||TO_CHAR(HIREDATE,'MM')||'월입니다' 자기소개 FROM EMP;
























