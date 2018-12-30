use project;
create table place (
  id int(11) not null AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  ename varchar(255) DEFAULT NULL,
  location varchar(255) DEFAULT NUll,
  introduction text DEFAULT NULL,
  primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into place values(null, '测试场地1', "ceshichangdi1", "中山北路1号", "lalala");
insert into place values(null, '测试场地2', "ceshichangdi2", "中山北路2号", "lalala");
insert into place values(null, '测试场地3', "ceshichangdi3", "中山北路3号", "lalala");
insert into place values(null, '测试场地4', "ceshichangdi4", "中山北路4号", "lalala");
insert into place values(null, '测试场地5', "ceshichangdi5", "中山北路5号", "lalala");
insert into place values(null, '测试场地6', "ceshichangdi6", "中山北路6号", "lalala");
insert into place values(null, '测试场地7', "ceshichangdi7", "中山北路7号", "lalala");
