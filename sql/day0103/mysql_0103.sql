select * from person;
-- 테이블 구조 변경
-- 1. 컬럼 추가 hp 
alter table person add hp varchar(20);
-- 2. today 컬럼 제거
alter table person drop column today;
desc person;-- 구조 확인
-- 3. 타입 변경 name 을 바이트 20에서 30으로 변경
alter table person modify name varchar(30);
-- 4. writeday 를 today 로 수정
alter table person rename column writeday to today;

-- 5. hp 에 데이타 넣기
update person set hp='010-7766-9988' where num=6;

-- join 연습용 테이블 생성하기
-- 부모테이블은 person 으로 하고 person 의 num 을 외부키로갖는 stu 생성
create table stu (
     idx tinyint auto_increment primary key,
     num smallint,
     kor smallint default 0,
     eng smallint default 0,
     sum smallint,
     constraint fk_stu_num foreign key(num) references person(num)
        on delete cascade); 
        -- person 데이타 삭제시 stu에 추가된 데이타는 자동으로 지워짐

-- stu 에 데이타 추가하기
insert into stu (num,kor,eng) values (1,78,89);
insert into stu (num,kor,eng) values (3,100,99);
insert into stu (num,kor,eng) values (4,67,94);
insert into stu (num,kor,eng) values (5,50,60);
insert into stu (num,kor,eng) values (6,97,79);
-- 전체학생들의 sum 구하기
update stu set sum=kor+eng;

-- person 과 stu 를 join 해서 전체를 출력하는 방법
-- 방법1
select * from person p,stu s where p.num=s.num;
-- 방법2
select p.name,p.blood,p.age,s.kor,s.eng,s.sum
from person p,stu s where p.num=s.num;
-- 방법3
select name,blood,age,hp,kor,eng,sum
from person p inner join stu s on p.num=s.num;

-- stu 생성시 on delete cascade 설정
-- person 에서 1번을 삭제하면 stu 에서도 같이 삭제됨
delete from person where num=1;

-- stu 만 조회
select * from stu;








