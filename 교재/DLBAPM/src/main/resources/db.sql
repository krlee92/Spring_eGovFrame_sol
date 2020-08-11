delete from dlbapm_member;
create table dlbapm_gallery(
	dg_no number(5) primary key, 			
	dg_owner varchar2(10 char) not null,
	dg_title varchar2(25 char) not null, 
	dg_file varchar2(200 char) not null
);
create sequence dlbapm_gallery_seq;
-------------------------------------------
create table dlbapm_dataroom(
	dd_no number(4) primary key,
	dd_owner varchar2(10 char) not null,
	dd_title varchar2(25 char) not null,
	dd_cate varchar2(10 char) not null,
	dd_file varchar2(200 char) not null,
	dd_when date not null
);
create sequence dlbapm_dataroom_seq;
-------------------------------------------
create table dlbapm_sns_reply(
	dsr_no number(5) primary key, -- 댓글번호
	dsr_ds_no number(4) not null, -- 소속된 글 번호
	dsr_owner varchar2(10 char) not null,
	dsr_txt varchar2(200 char) not null,
	dsr_when date not null,
	constraint sns_replyHaha
		foreign key(dsr_ds_no) references dlbapm_sns(ds_no)
		on delete cascade,
	constraint sns_reply_ownerHaha
		foreign key(dsr_owner) references dlbapm_member(dm_id)
		on delete cascade
); 
create sequence dlbapm_sns_reply_seq;
-----------------------------------------
create table dlbapm_sns(
	ds_no number(4) primary key, 			-- 글 번호
	ds_owner varchar2(10 char) not null, 	-- 글쓴이 ID
	ds_txt varchar2(300 char) not null,
	ds_when date not null,
	ds_color char(7) not null,
	constraint sns_owner
		foreign key(ds_owner) references dlbapm_member(dm_id)
		on delete cascade
);
create sequence dlbapm_sns_seq;
------------------------------------------
create table dlbapm_member(
	dm_id varchar2(10 char) primary key,
	dm_pw varchar2(10 char) not null,
	dm_name varchar2(10 char) not null,
	dm_addr varchar2(200 char) not null,
	dm_photo varchar2(200 char) not null
);
