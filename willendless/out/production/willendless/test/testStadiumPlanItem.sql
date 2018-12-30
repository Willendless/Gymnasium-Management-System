use project;
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