-- PL-SQL 이란 SQL 언어에 절차적 언어요소를 추가해서 프로그래밍한것을 PL/SQL 이라고 한다
-- 형식
-- DECLARE
--     변수,커서 선언
-- BEGIN
--   SQL구문이나 PL/SQL문으로 코딩
-- END
-- / (실행)

--스크립트 출력창에 결과가 출력되도록 한번만 설정
SET SERVEROUTPUT ON  --켜기
SET SERVEROUTPUT Off --끄기 (dbm창으로 확인하려면 꺼도됨)

-- 예제 1
DECLARE
    v_no number(4,1); --변수 선언,4자리수에 소숫점이하 1자리
begin
    v_no:=12.7; --값 대입(오라클에서 = 은 비교연산자, := 는 대입연산자)
    dbms_output.put_line(v_no); --콘솔창에 출력
end;
/
    
--DECLARE
--begin
--    dbms_output.put_line(v_no);
--end;

--예제 2
DECLARE
    vcolor varchar2(20);
    vprice number(10);
    vsangpum varchar2(20);
begin
    vcolor:='오렌지색';
    vprice:=35000;
    vsangpum:='모직코트';
    
    dbms_output.put_line('상품명 : '||vsangpum);
    dbms_output.put_line('가 격 : '||vprice||'원');
    dbms_output.put_line('색 상 : '||vcolor);
end;
/

--예제 3
DECLARE
    vscode varchar2(20);
    vsprice number(10);
    vsangpum varchar2(30);
begin
    vscode:='A300';
    
    -- vscode값에 해당하는 상품데이타 가져오기
    select sangprice,sangname
    into vsprice,vsangpum
    from shop
    where sangcode=vscode;
    
    dbms_output.put_line('상품명 : '||vsangpum);
    dbms_output.put_line('가 격 : '||vsprice||'원');
    dbms_output.put_line('코드번호 : '||vscode);
end;
/

--예제3 if문 --년도에 따라서 띠를 구해보자
--쥐(子), 소(丑), 호랑이(寅), 토끼(卯), 용(辰), 뱀(巳), 말(午), 양(未), 원숭이(申), 닭(酉), 개(戌), 돼지(亥)
DECLARE
   v_year number(4):=2025;
   v_mod number(2):=mod(v_year,12);--서기1년은 닭띠이다..12년이 원숭이띠
   v_ddi varchar2(20);--띠저장할 변수
begin
    if v_mod=0 then v_ddi:='원숭이띠';
    elsif v_mod=1 then v_ddi:='닭띠';
    elsif v_mod=2 then v_ddi:='개띠';
    elsif v_mod=3 then v_ddi:='돼지띠';
    elsif v_mod=4 then v_ddi:='쥐띠';
    elsif v_mod=5 then v_ddi:='소띠';
    elsif v_mod=6 then v_ddi:='호랑이띠';
    elsif v_mod=7 then v_ddi:='토끼띠';
    elsif v_mod=8 then v_ddi:='용띠';
    elsif v_mod=9 then v_ddi:='뱀띠';
    elsif v_mod=10 then v_ddi:='말띠';
    elsif v_mod=11 then v_ddi:='양띠';
    end if;   
    
    dbms_output.put_line(v_year||'년도는 '||v_ddi||'해이다');
end;
/

-- accept 를 이용해서 년도를 직접 입력해서 띠를 알아보자
accept year prompt '년도를 입력해주세요'; --키보드로 값 입력받기

DECLARE
   v_year number(4):='&year'; --입력받은 year값 가져오기
   v_mod number(2):=mod(v_year,12);--서기1년은 닭띠이다..12년이 원숭이띠
   v_ddi varchar2(20);--띠저장할 변수
begin
    if v_mod=0 then v_ddi:='원숭이띠';
    elsif v_mod=1 then v_ddi:='닭띠';
    elsif v_mod=2 then v_ddi:='개띠';
    elsif v_mod=3 then v_ddi:='돼지띠';
    elsif v_mod=4 then v_ddi:='쥐띠';
    elsif v_mod=5 then v_ddi:='소띠';
    elsif v_mod=6 then v_ddi:='호랑이띠';
    elsif v_mod=7 then v_ddi:='토끼띠';
    elsif v_mod=8 then v_ddi:='용띠';
    elsif v_mod=9 then v_ddi:='뱀띠';
    elsif v_mod=10 then v_ddi:='말띠';
    elsif v_mod=11 then v_ddi:='양띠';
    end if;   
    
    dbms_output.put_line(v_year||'년도는 '||v_ddi||'해이다');
end;
/

--예제4 ,상품코드,상품명,가격을 입력받아 shop 테이블에 추가해보자
ACCEPT scode prompt 'A로 시작하는 상품코드를 입력하세요';
ACCEPT ssang prompt '상품명을 입력하세요';
ACCEPT sprice prompt '가격을 입력하세요';

declare
    v_code varchar2(20) :='&scode';
    v_sang varchar2(30) := '&ssang';
    v_price number(10) := '&sprice';
begin
    insert into shop (sangcode,sangname,sangprice)
     values (v_code,v_sang,v_price);
    dbms_output.put_line(v_sang||' 상품정보를 테이블에 추가했습니다'); 
end;
/

-- 예제5 Cursor 와 for문을 이용하여 shop 의 데이타들을 읽어오자
DECLARE
    --커서객체에 select sql 문을 이용해서 넣기
    CURSOR s1
    is
    select * from shop;
begin
    for s in s1 loop  --record 단위로 s가 가져온다
        dbms_output.put_line(s.sangcode||'   '||s.sangname||'   '||s.sangprice);
        exit when s1%notfound; --더이상 데이타가 없으면 for문을 빠져나가라
    end loop;
end;
/

--응용:join sql 문을 이용해서 cartnum,sangcode,sangname,sangprice,cntnum,cartday 를 출력하시오
DECLARE
    --커서객체에 select sql 문을 이용해서 넣기
    CURSOR s1
    is
    select
        c.cartnum,s.sangcode,s.sangname,s.sangprice,c.cntnum,
        to_char(cartday,'yyyy-mm-dd') cartday
        from shop s,cart c
        where s.sangcode=c.sangcode;
begin
    for s in s1 loop  --record 단위로 s가 가져온다
        dbms_output.put_line(s.cartnum||' '||s.sangcode||' '||s.sangname
        ||' '||s.sangprice||'  '||s.cntnum||'  '||s.cartday);
        exit when s1%notfound; --더이상 데이타가 없으면 for문을 빠져나가라
    end loop;
end;
/

-- 상품코드와 상품명과 가격을 accept를 이용해서 입력후
--shop 에 해당 상품코드가 존재할경우 update 로 수정을 하고
--존재하지 않을겨우 insert 로 추가를 하시오
ACCEPT scode prompt 'A로 시작하는 상품코드를 입력하세요';
ACCEPT ssang prompt '상품명을 입력하세요';
ACCEPT sprice prompt '가격을 입력하세요';

declare
    v_code varchar2(20) :='&scode';
    v_sang varchar2(30) := '&ssang';
    v_price number(10) := '&sprice';
    v_cnt number(2);--count 값을 가져올 변수    
begin
    select count(*) into v_cnt
    from shop where sangcode=v_code; --존재하면 1, 존재하지 않으면 0
    
    if v_cnt=1 then
        --update처리
        update shop set sangname=v_sang,sangprice=v_price
        where sangcode=v_code;
        commit;
        dbms_output.put_line(v_code||'상품이 수정되었습니다');
    else
        --insert 처리
        insert into shop (sangcode,sangname,sangprice) values 
        (v_code,v_sang,v_price);
        commit;
        dbms_output.put_line(v_code||'상품이 추가되었습니다');
    end if;   
end;
/

--상품명을 입력하면 shop 테이블에서 그 이름을 포함하고 있는 데이타들을 모두 출력
accept sangpum prompt '상품명을 입력해주세요';

DECLARE
    v_sangpum varchar2(30) :='&sangpum';
    --커서객체에 select sql 문을 이용해서 넣기
    CURSOR s1
    is
    select * from shop where sangname like '%'||v_sangpum||'%';
    
    --갯수를 얻어올 변수
    v_cnt number(2);
begin
    -- 입력한 상품명을 포함한 레코드의 갯수를 얻어보자
    select count(*) into v_cnt
    from shop where sangname like '%'||v_sangpum||'%';
    if v_cnt=0 then
         dbms_output.put_line(v_sangpum||'상품은 존재하지 않습니다');
    else
        dbms_output.put_line('상품코드    상품명    상품가격');
        dbms_output.put_line('-----------------------------');
        for s in s1 loop  --record 단위로 s가 가져온다
            dbms_output.put_line(s.sangcode||'   '||s.sangname||'   '||s.sangprice);
            exit when s1%notfound; --더이상 데이타가 없으면 for문을 빠져나가라
        end loop;
    end if;
end;
/







