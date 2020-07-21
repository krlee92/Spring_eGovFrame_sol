create table jul21_weather(
	w_when date primary key,
	w_weather varchar2(20 char) not null,
	w_temp number(4, 2) not null
);

insert into jul21_weather values(sysdate, '맑음', 20.12);

delete from jul21_weather;

select * from jul21_weather;