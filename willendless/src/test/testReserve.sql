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