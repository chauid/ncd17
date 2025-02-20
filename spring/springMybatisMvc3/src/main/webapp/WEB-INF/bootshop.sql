create table bootshop (
     num smallint auto_increment primary key,
     sangpum varchar(30),
     scolor varchar(20),
     sprice int,
     scnt smallint,
     sphoto varchar(1000),
     ipgoday varchar(30),
     writeday datetime);
     
create table bootshopreple (
   idx smallint auto_increment primary key,
   num smallint,
   photo varchar(50),
   message varchar(300),
   likes smallint default 0,
   writetime datetime default now(),
   foreign key(num) references bootshop(num) on delete cascade);