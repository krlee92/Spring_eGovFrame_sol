package com.lee.mb.main;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.CORBA.Request;

public class SelectMain4 {
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
			
			// 얼마부터 얼마까지 1000~5000원 커피 찾기
			Scanner k = new Scanner(System.in);
			System.out.printf("커피 얼마부터 : ");
			BigDecimal start = k.nextBigDecimal();
//			BigDecimal bdbd = k.nextBigDecimal();
			System.out.printf("커피 얼마까지 :");
			BigDecimal end = k.nextBigDecimal();
			// BigDecimal 치환방법
			// int -> BigDecimal
			
			// 입력받은걸로 CoffeeSelector 객체 생성
			// 	ParameterType에 써먹을것
			CoffeeSelector cs = new CoffeeSelector(start, end);
			
			// Avengers - Ironman
			// List - ArrayList
			List<Coffee> coffees =  ss.selectList("lee.searchCoffeeByPrice2", cs); // Java.util
			//									Mapper에서 ("namespace.id")
			/*
			 mapper.xml
			 parameterType="com.lee.mb.main.Coffee" - 어떤값이 들어오는지(cc는 커피객체)
			resultType="com.lee.mb.main.Coffee"> - 어떤값으로 결과를 만들건지(커피객체로)
			where c_name = #{멤버변수명} #{c_name} = Mybatis 발동조건이 멤버변수명= DB테이블 필드명이라 웬만하면 같음
			
			SM3
			XML에서는 <가 시작태그라 < price 이런거 못씀, html스럽게 해결해야함
			< : &lt;
			> : &gt; 
			
			SM4
			얼마이상 이하로 검색하려면 숫자값 2개를 받아야하는데 기존 Coffee객체는 한개만 받을수 있음
			CoffeeSelector 객체를 새로 생성하여 값 2개 받을수 있게 세팅
			mapper.xml에서 파라메터에 CoffeeSelector 객체를 이용할 수 있게 세팅.
			이번에는 멤버변수명과 테이블 필드명이 다르다.#{start} #{end}
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
