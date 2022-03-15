create table board(
  no int not null auto_increment PRIMARY KEY,
  title varchar(100) not null,
  content varchar(255) not null,
  viewCount int,
  createdDate date
);

alter table board
  add constraint primary key (no),
  modify column no int not null auto_increment;
  
  alter table board
  modify column no int not null auto_increment,
  modify column viewCount int,
  modify column createDate date;
  
