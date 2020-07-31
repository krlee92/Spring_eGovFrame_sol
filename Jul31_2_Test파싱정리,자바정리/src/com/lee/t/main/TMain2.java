package com.lee.t.main;



public class TMain2 {
	public static void main(String[] args) {
//		애완동물 d;
		// 애완동물 : 클래스 - 객체를 만들 때 사용하는 틀
		// 애완동물 타입의 변수 d
		
		애완동물 d = new 애완동물();
		System.out.println(d);
		d.test();
		System.out.println("-----");
		개 dd = new 개();
		dd.test();
		System.out.println("-----");
		// 애완동물 객체를 생성 : 컴퓨터가 적당하다고 판단한 번지에
		
		// 클래스 vs 객체(인스턴스)
		// 클래스는 찍어내는 붕어빵 틀, 객체는 틀로 찍어낸 붕어빵

		// x라는 변수에 있는 객체는 정확하게 뭐 : 개
		애완동물 x = new 개(); // 다형성
		x.test();
		System.out.println("=========");
		
//		메뉴 m = new 메뉴(); // 인터페이스는 객체를 만들지 못함
		
		제육덮밥 j = new 제육덮밥();
		j.test2();
		System.out.println("-------------");
		
		
	}

}
