
----------------------------------
select *
from DLBAPM_SNS, DLBAPM_SNS_reply
where ds_no = dsr_ds_no; -- 댓글 하나 쓸때마다 글 하나씩

같이 가실 분 댓글요
	

----------------------------------------------------------
create table dlbapm_sns_reply(
	dsr_no number(5) primary key, -- 댓글번호
	dsr_ds_no number(4) not null,-- 소속된 글 번호가 필요
	
	dsr_owner varchar2(10 char) not null,
	dsr_txt varchar2(200 char) not null,
	dsr_when date not null,
	constraint sns_replyHaha -- 제약조건이름
		foreign key(dsr_ds_no) references dlbapm_sns(ds_no)
		on delete cascade, -- 글이 삭제될때 덧글 삭제
		
	constraint sns_reply_owner -- 
		foreign key(dsr_owner) references dlbapm_member(dm_id)
		on delete cascade -- 아이디가 삭제될때 댓글삭제
);
create sequence dlbapm_sns_reply_seq;


-- 회원탈퇴시 => 그 사람이 쓴 글 자동삭제
-- 없는 ID 안되게
-- 외래키(foreignKey)
-----------------------------------------
-- ID, 프사, 내용, 날짜, 색깔, 번호

select *
from(
	select rownum as rn, dm_photo, dm_id, ds_txt, ds_when, ds_color, ds_no
	from(
		select *
		from dlbapm_member, dlbapm_sns
		where dm_id = ds_owner and ds_txt like '%ㅋ%'
		order by ds_when desc
	)
)
where rn >= 2 and rn <= 4
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
delete from krleehomepage_member;
delete from dlbapm_sns;
delete from dlbapm_member;
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
create sequence krleehomepage_sns_seq;
drop sequence dlbapm_sns_seq;
drop table dlbapm_sns cascade constraint purge;
drop table dlbapm_member cascade constraint purge;
drop table dlbapm_member;
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
