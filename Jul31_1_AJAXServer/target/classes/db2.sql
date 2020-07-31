create table jul31_champ(
	c_name varchar2(10 char) primary key,
	c_skill varchar2(20 char) not null,
	c_ult varchar2(20 char) not null
);


select * from jul31_champ;

insert into jul31_champ values('샤코', '깜짝박스', '환각');
