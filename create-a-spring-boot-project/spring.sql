create database spring;

use spring;
create table springmodels
(
  id varchar(10) not null,
  stt int,
  primary key(id)
);

INSERT INTO springmodels (id,stt) VALUES ('mot',1);
INSERT INTO springmodels (id,stt) VALUES ('hai',2);
INSERT INTO springmodels (id,stt) VALUES ('ba',3);
INSERT INTO springmodels (id,stt) VALUES ('bon',4);
INSERT INTO springmodels (id,stt) VALUES ('nam',5);

select * 
from springmodels
order by stt

