package com.lee.mb.main;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 유지보수에 용이
//		수정이 일어날만한 부분은 외부파일에
//		java에서는 그 파일 불러다 사용

// 그 외부파일이 어떤 형식이 있으면 좋을것 : .xml

// XML(각종 설정파일에서 사용)
// JSON(네트워크 상에서 데이터 주고 받을 때 : 주력)

// DB
//								서버정보			SQL		
//		JDBC					DBManager.java에	DAO.java에
//		ConnectionPool(JSP)		context.xml			DAO.java
//		MyBatis					xxxConfig.xml		xxxMapper.xml

// MyBatis(3.x)
//		iBatis(~2.x)
//		DB ORM(Object Relational Mapping) Framework
//		myBatis.jar - Maven 검색으로 넣기

public class ConnectMain {
	public static void main(String[] args) {
		// 자동으로 닫음
		// Java 시절 Connection객체 -> MyBatis : SqlSession객체
		try {
			String cfgName = "config.xml"; // 패키지안에있으면 com/lee/...
			InputStream is = Resources.getResourceAsStream(cfgName); 
//			InputStream is = Resources.getResourceAsStream("config.xml");
			
			SqlSessionFactoryBuilder ssfb = 
					new SqlSessionFactoryBuilder();
			
			SqlSessionFactory ssf = ssfb.build(is);
			SqlSession ss = ssf.openSession();
			System.out.println("성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
