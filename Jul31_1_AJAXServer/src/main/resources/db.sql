create table jul31_menu(
	m_name varchar2(10 char) primary key,
	m_price number(5) not null
);

drop table jul31_menu;

insert into jul31_menu values('잡채밥', 8000);

select * from jul31_menu;

그 테이블에있는거 index.jsp에 나오게
-- pom.xml => Spring + MyBatis에 필요한 jar파일들 가져오기
-- servlet-context.xml = > sqlsession 등록
-- xxxMapper.xml, xxxMapper(interface)
-- xxxMapper.xml를 servlet-context.xml에 등록

--- 체크한후 다시 

-- JavaBean
-- xxxMapper.xml에 select문 등록
-- xxxMapper.java에 메소드 등록
-- DAO
-- COntroller