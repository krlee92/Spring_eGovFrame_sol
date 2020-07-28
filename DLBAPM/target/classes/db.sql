-- 회원탈퇴시 => 그 사람이 쓴 글 자동삭제
-- 없는 ID 안되게
-- 외래키(foreignKey)
-----------------------------------------
-- ID, 프사, 내용, 날짜, 색깔
select *
from dlbapm_member, dlbapm_sns
where dm_id = ds_owner;
-----------------------------------------
insert into dlbapm_sns 
values(100, 'kwon', 'ㅋㅋㅋㅋ', sysdate, '#FFFFFF');
insert into dlbapm_sns 
values(101, 'lee', 'ㅎㅋ', sysdate, '#FFFFFF');
insert into dlbapm_sns 
values(102, 'kwon', 'ㅡㅡ', sysdate, '#FFFFFF');
insert into dlbapm_sns 
values(103, 'hong', 'ㅎㅎㅎ', sysdate, '#FFFFFF');

delete from krleehomepage_sns;
delete from dlbapm_sns;
-----------------------------------------
create table dlbapm_sns(
	ds_no number(4) primary key, 			-- 글 번호
	ds_owner varchar2(10 char) not null, 	-- 글쓴이 ID
	ds_txt varchar2(300 char) not null,
	ds_when date not null,
	ds_color char(7) not null,
	constraint sns_owner3
		foreign key(ds_owner) references dlbapm_member(dm_id)
		on delete cascade
);
-- constraint 제약조건명
--		foreign key(필드명) references 상대테이블명(필드명)
--		on delete cascade

create sequence dlbapm_sns_seq;
drop sequence dlbapm_sns_seq;
------------------------------------------
create table dlbapm_member(
	dm_id varchar2(10 char) primary key,
	dm_pw varchar2(10 char) not null,
	dm_name varchar2(10 char) not null,
	dm_addr varchar2(200 char) not null,
	dm_photo varchar2(200 char) not null
);

select * from dlbapm_member;
select * from dlbapm_sns;
