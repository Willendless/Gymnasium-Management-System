use project;

create table reserveItem (
                    id int(11) not null AUTO_INCREMENT,
                    piid int(11) default null,
                    rid int(11) default null,
                    constraint  fk_planItem FOREIGN key(piid) references stadiumplanItem (id),
                    constraint  fk_reserve FOREIGN KEY (rid) REFERENCES reserve (id),
                    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;