package com.lee.jul22.sdi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 유지보수하기 좋게
//	수정이 일어날 만한 부분이 .java에 있으면 수정이 힘듬
//	 :프로그램을 수정해야 -> 컴파일 다시 -> 테스트 다시 -> .jar다시 -> 배포

//	수정이 일어날 만한 부분을 외부파일에(.xml)
//	 : 그 파일만 수정하면 끝


// DI(Dependency Injection = 의존성 주입)
//		객체 만들고, 속성값 넣고
// IoC(Inversion of Control = 제어권의 역전)
//		게임 플레이 신기록 -> 파일에 저장
//		프로그램 -> 파일
//		프로그램의 결과를 파일에 쓰는 : 자연스러움
//		파일 -> 프로그램
//		파일로 프로그램 제어 :IoC

// EJB(Enterprise JavaBean)
//		자바빈 자체에 세팅을 해서 화려하게 사용
//		어렵고 무겁고 ...

//		EJB시절 : winter에 비유

// Spring
//		IoC로 DI를 지원하는 Framework
//		POJO(Plain Old Java Object)를 .xml에 만들어놓고 
//		자바에서는 그객체 불러다 쓰게

public class DataMaker {
	public static void make(HttpServletRequest req) {
		
		// DI : 개 만들고, 이름세팅, 나이세팅
		// DI를 자바소스로
		// 자바소스 바꾸면 -> 컴파일 -> 테스트
		// -> war만들어서 -> 서버로
		Dog d = new Dog("뽀삐", 3);
		req.setAttribute("d", d);
		
		// Spring Bean Configuration File 불러오기
		//	거기 등록된 객체 다 만들어짐
		AbstractApplicationContext aac
			= new ClassPathXmlApplicationContext("abcd.xml");
		
		// aac가 없어질 때
		//	거기 등록된 개체들 메모리 다 정리되게
		aac.registerShutdownHook();
		
		// aac에 등록해놓은 id가 m1인 객체를 가져오기
		// Menu클래스 객체 생성하고, setter사용하여 속성값 설정함
		Menu m = aac.getBean("m1", Menu.class);
		req.setAttribute("m", m);
		
		// 뿌삐, 2살짜리 개
		// constructor-arg : 생성자로 객체 생성
		//	value는 순서대로
//		Dog dd = aac.getBean("d2", Dog.class);
//		req.setAttribute("dd", dd);
		req.setAttribute("dd", aac.getBean("d2", Dog.class));
		
		req.setAttribute("h1", aac.getBean("h1", Human.class));
		
		req.setAttribute("h2", aac.getBean("h2", Human.class));
		
		// aac를 닫기 -> 거기 등록된 객체들 정리
		aac.close();
		
	}
}
