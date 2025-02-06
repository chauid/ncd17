create table shop (
    num smallint auto_increment primary key,
    sangpum varchar(50),
    scolor varchar(20),
    scnt smallint,
    sprice int,
    sphoto varchar(50),
    ipgoday varchar(20),
    writeday datetime);
    
create table shopreple(
    idx smallint auto_increment primary key,
    num smallint,
    star smallint,
    message varchar(300),
    writeday datetime,
    foreign key(num) references shop(num) on delete cascade);