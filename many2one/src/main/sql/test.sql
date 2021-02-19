drop table s_dept;
drop table s_emp;

create table s_dept(
    dept_id integer primary key not null,
    name varchar(25) not null
);

create table s_emp(
    id integer primary key not null,
    name varchar(25) not null,
    dept_id integer
);

alter table s_emp add constraint s_emp_dept_id_fk
    foreign key(dept_id) references s_dept(dept_id);

insert into s_dept values(1, '개발');
insert into s_emp values(1, '두두', 1);
insert into s_emp values(2, '디드', 1);