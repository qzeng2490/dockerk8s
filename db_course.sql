create table pe_course
(
  id int auto_increment
    primary key,
  title varchar(100) null,
  description varchar(300) null
);

create table pe_user_course
(
  user_id int not null,
  course_id int not null
);



INSERT INTO pe_course (id, title, description) VALUES (1, '大学英语', '测试测试测试');

INSERT INTO pe_user_course (user_id, course_id) VALUES (1, 1);