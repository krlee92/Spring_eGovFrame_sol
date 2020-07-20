package com.lee.mb.main;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InsertMain {
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
			System.out.printf("메뉴명 : ");
			String n = k.next();
//			BigDecimal bdbd = k.nextBigDecimal();
			System.out.printf("가격 :");
			BigDecimal p = k.nextBigDecimal();
			
			// 	ParameterType에 써먹을것
			
			Coffee cc = new Coffee(n, p); 
			
//			ss.insert("lee.regCoffee", cc);
			
			// 		namespace.id	파라메터명
			// return값 int니까 한줄 변화가돼야 성공
			if (ss.insert("lee.regCoffee", cc) == 1) {
				
				// 실제로 작업을 서버에 반영
				ss.commit();
				System.out.println("성공");
			} 
			// 작업 취소
//			ss.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
