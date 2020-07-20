package com.lee.mb.main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.CORBA.Request;

public class SelectMain {
	public static void main(String[] args) {
		try {
			String cfgName = "config.xml"; // 패키지안에있으면 com/lee/...
			InputStream is = Resources.getResourceAsStream(cfgName); 
//			InputStream is = Resources.getResourceAsStream("config.xml");
			
			SqlSessionFactoryBuilder ssfb = 
					new SqlSessionFactoryBuilder();
			
			SqlSessionFactory ssf = ssfb.build(is);
			SqlSession ss = ssf.openSession();
			// MyBatis는 sql결과를 자동으로 arraylist로, 결과 타입을 지정가능(만들어놓은 커피객체 경로 자세히써서)
			
			
			// Avengers - Ironman
			// List - ArrayList
			List<Coffee> coffees =  ss.selectList("lee.getAllCoffee"); // Java.util
			//									Mapper에서 ("namespace.id")
			for (Coffee c : coffees) {
				System.out.println(c.getC_name());
				System.out.println(c.getC_price());
				System.out.println("----");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
