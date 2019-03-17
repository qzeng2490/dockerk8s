
create table pe_teacher
(
  user_id int auto_increment
    primary key,
  intro varchar(64) null,
  stars int null
);

create table pe_user
(
  id int auto_increment
    primary key,
  username varchar(32) null,
  password varchar(32) null,
  real_name varchar(32) null,
  mobile varchar(32) null,
  email varchar(32) null
);

INSERT INTO db_user.pe_teacher (user_id, intro, stars) VALUES (1, '毕业于北京师范英语', 4);
INSERT INTO db_user.pe_user (id, username, password, real_name, mobile, email) VALUES (1, 'qzeng', '827ccb0eea8a706c4c34a16891f84e7b', '曾强', '13710711111', 'qzeng2017@163.com');
INSERT INTO db_user.pe_user (id, username, password, real_name, mobile, email) VALUES (2, 'test', '827ccb0eea8a706c4c34a16891f84e7b', null, '11111111', 'aaaaaaaa');