create table book
(
   id integer not null AUTO_INCREMENT,
   name varchar(255) not null,
   author varchar(255) not null,
   price double not null,
   is_recommended boolean not null,
   createdate date not null,
   updatedate date,
   createuser varchar(255) not null,
   updateuser varchar(255),
   active boolean,
   primary key(id)
);

create table user
(
   id integer not null AUTO_INCREMENT,
   name varchar(255) not null,
   surname varchar(255) not null,
   date_of_birth date not null,
   username varchar(255) not null,
   password varchar(255) not null,
   createdate date not null,
   updatedate date,
   createuser varchar(255) not null,
   updateuser varchar(255),
   active boolean,
   primary key(id),
);

create table `order`
(
   id integer not null AUTO_INCREMENT,
   userid integer not null ,
   bookid integer not null ,
   price double not null ,
   createdate date not null,
   updatedate date,
   createuser varchar(255) not null,
   updateuser varchar(255),
   active boolean,
   primary key(id),
);

	