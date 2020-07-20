package com.lee.mb.main;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.CORBA.Request;

public class SelectMain2 {
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
			
			// 커피이름으로 db내 커피검색
			Scanner k = new Scanner(System.in);
			System.out.printf("커피 이름 : ");
			String n = k.next();
			
			// 입력받은걸로 Coffee 객체 생성
			Coffee cc = new Coffee(n, null);
			
			// Avengers - Ironman
			// List - ArrayList
			List<Coffee> coffees =  ss.selectList("lee.searchCoffeeByName", cc); // Java.util
			//									Mapper에서 ("namespace.id")
			/*
			 SM2
			 mapper.xml
			 parameterType="com.lee.mb.main.Coffee" - 어떤값이 들어오는지(cc는 커피객체)
			resultType="com.lee.mb.main.Coffee"> - 어떤값으로 결과를 만들건지(커피객체로)
			where c_name = #{멤버변수명} #{c_name} = Mybatis 발동조건이 멤버변수명= DB테이블 필드명이라 웬만하면 같음
			  */
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
