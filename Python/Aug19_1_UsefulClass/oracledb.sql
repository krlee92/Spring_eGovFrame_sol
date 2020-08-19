create table aug19_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(5) not null
);

select * from aug19_coffee;

create table weather(
	w_m number(2) not null,
	w_d number(2) not null,
	w_h number(2) not null,
	w_desc varchar2(15 char) not null,
	w_temp number(4, 2) not null,
	w_fl number(4, 2) not null,
	w_humidity number(4, 2) not null
);
drop table weather;

select * from WEATHER;