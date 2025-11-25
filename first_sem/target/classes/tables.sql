create table teachers (
                          id serial primary key key,
                          full_name varchar(100) not null,
                          email varchar(100) unique not null,
                          password_hash varchar(255) not null
);

create table students (
                          id serial primary key,
                          full_name varchar(100) not null,
                          email varchar(100) unique not null ,
                          password_hash varchar(255) not null,
                          group_number varchar(20),
                          course_number int,
                          teacher_id int references teachers(id)
);

create table visits (
                        id serial primary key,
                        visit_date date not null,
                        visit_time time,
);
create table student_visit (
                               student_id int references students(id) on delete cascade ,
                               visit_id int references visits(id),
                               status varchar(50) default 'На рассмотрении',
                               visit_date date,
                               visit_time time,
                               primary key (student_id, visit_id)
);