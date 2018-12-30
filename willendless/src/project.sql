drop database if exists project;
create database project DEFAULT charset utf8;

use project;

create table user (
                    id int(11) not null AUTO_INCREMENT,
                    name varchar(255) DEFAULT NULL,
                    password varchar(255) DEFAULT NULL,
                    email varchar(255) DEFAULT NULL,
                    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user values(null,'root','root','');
insert into user values(null,'测试用户1','password1','afd@qq.com');
insert into user values(null,'测试用户2','password2','asdf@163.com');
insert into user values(null,'测试用户3','password3','fasdf@abc.com');
insert into user values(null,'测试用户4','password4','asdfd@126.com');
insert into user values(null,'测试用户5','password5','asdfasdf@google.com');




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

use project;
create table placeStadium (
                            id int(11) not null auto_increment,
                            name varchar(255) default null,
                            num int(11) default null,
                            fare int(11) default null,
                            pid int(11) default null,
                            primary key(id),
                            constraint  fk_place FOREIGN KEY (pid) REFERENCES place (id)
)ENGINE=innoDB default charset=utf8;

insert into placeStadium values(null, "羽毛球场", 11, 20, 5);
insert into placeStadium values(null, "篮球场", 5, 100, 4);


create table stadiumPlan (
                           id int(11) not null auto_increment,
                           inode int(11) default null,
                           date DATE default null,
                           psid int(11) default null,
                           primary key(id),
                           constraint  fk_placeStadium FOREIGN KEY (psid) REFERENCES placeStadium (id)
)ENGINE=innoDB default charset=utf8;

create table stadiumPlanItem (
                               id int(11) not null auto_increment,
                               beg time ,
                               end time ,
                               inode int(11) default null,
                               status varchar(255) default null,
                               spid int(11) default null,
                               primary key(id),
                               constraint fk_stadiumPlan foreign key(spid) references stadiumPlan (id)

)Engine=innoDB default charset=utf8;






use project;
create table reserve (
                       id int(11) not null AUTO_INCREMENT,
                       time timestamp default null ,
                       name varchar(255) DEFAULT NULL,
                       fare int(11) default null,
                       status varchar(255) DEFAULT NULL,
                       uid int(11) default null,
                       primary key(id),
                       constraint  rs_user FOREIGN KEY (uid) REFERENCES user (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table reserveItem (
                           id int(11) not null AUTO_INCREMENT,
                           piid int(11) default null,
                           rid int(11) default null,
                           constraint  fk_planItem FOREIGN key(piid) references stadiumplanItem (id),
                           constraint  fk_reserve FOREIGN KEY (rid) REFERENCES reserve (id),
                           PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table News (
                    id int(11) not null AUTO_INCREMENT,
                    time timestamp default null ,
                    title varchar(255) DEFAULT NULL,
                    content varchar(255) DEFAULT NULL,
                    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `project`.`news` (`id`, `time`, `title`, `content`) VALUES ('1', '2018-12-19 18:08:18', '紧急通知', '爆炸了');
