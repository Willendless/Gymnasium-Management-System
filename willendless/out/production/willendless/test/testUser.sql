use project;

create table user (
    id int(11) not null AUTO_INCREMENT,
    name varchar(255) DEFAULT NULL,
    password varchar(255) DEFAULT NULL,
    email varchar(255) DEFAULT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user values(null,'测试用户1','password1','afd@qq.com');
insert into user values(null,'测试用户2','password2','asdf@163.com');
insert into user values(null,'测试用户3','password3','fasdf@abc.com');
insert into user values(null,'测试用户4','password4','asdfd@126.com');
insert into user values(null,'测试用户5','password5','asdfasdf@google.com');