use project;

create table News (
                    id int(11) not null AUTO_INCREMENT,
                    time timestamp default null ,
                    title varchar(255) DEFAULT NULL,
                    content varchar(255) DEFAULT NULL,
                    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

