create table board (
    idx smallint auto_increment primary key,
    myid varchar(30),
    writer varchar(30),
    subject varchar(300),
    content varchar(2000),
    readcount smallint default 0,
    regroup smallint,
    relevel smallint,
    restep smallint,
    writeday datetime default now());
    
create table boardfile (
   num smallint auto_increment primary key,
   idx smallint,
   filename varchar(50),
   foreign key(idx) references board(idx)
   on delete cascade);