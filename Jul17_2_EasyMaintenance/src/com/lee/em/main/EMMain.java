package com.lee.em.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


// 수정이 일어날만한 부분 : 외부파일에(d:/lee/pointRate.txt)
// java에서는 그 파일 불러다 사용
// 
public class EMMain {
	public static void main(String[] args) {
		// 구매가격 : 100
		// 1% 적립
		// 적립되는 포인트 : 1
		try {
			Scanner k = new Scanner(System.in);
			System.out.println("구매가격 : ");
			int price = k.nextInt();
			
			// 포인트적립율은 외부파일 읽어와서
			FileReader fr = new FileReader("d:/lee/pointRate.txt");
			BufferedReader br = new BufferedReader(fr); // 쓰기쉽게 덮어씌움
			String pr = br.readLine();
			double pointRate = Double.parseDouble(pr); // 자주바뀌는 포인트적립율을 외부파일로
			
//			double pointRate = 0.01;
			double point = price * pointRate;
			System.out.printf("포인트 : %.1f", point);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
