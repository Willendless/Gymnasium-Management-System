use project;

create table stadiumPlan (
                           id int(11) not null auto_increment,
                           inode int(11) default null,
                           date DATE default null,
                           psid int(11) default null,
                           primary key(id),
                           constraint  fk_placeStadium FOREIGN KEY (psid) REFERENCES placeStadium (id)
)ENGINE=innoDB default charset=utf8;



