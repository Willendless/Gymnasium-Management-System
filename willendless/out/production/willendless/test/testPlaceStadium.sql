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
