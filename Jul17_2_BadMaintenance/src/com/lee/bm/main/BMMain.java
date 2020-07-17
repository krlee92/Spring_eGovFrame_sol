package com.lee.bm.main;

import java.util.Scanner;

// 개발자 : 프로그램 개발 완료 - > 실행파일(.jar/.war(jsp면))
//		.jar - 컴파일 된(기계어 상태의) 소스파일 압축

//  포인트 1% -> 0.5% 바뀜
//	소스 수정 - > 테스트 -> j.ar -> .bat ->다시 줘야

// java소스에 있는 내용을 수정 - > 컴파일 -> 테스트 -> 실행파일 -> 배포
public class BMMain {
	public static void main(String[] args) {
		// 구매가격 : 100
		// 1% 적립
		// 적립되는 포인트 : 1
		
		Scanner k = new Scanner(System.in);
		System.out.println("구매가격 : ");
		int price = k.nextInt();
		double pointRate = 0.01;
		double point = price * pointRate;
		System.out.printf("포인트 : %.1f", point);
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
