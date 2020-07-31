package com.lee.t.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TMain {
	public static void main(String[] args) {
		
		// 서버측이 한글처리 어떻게 하고있는지?
		// 데이터 구조는 어떤지?
		// 받아온 데이터 파싱은 어떤식으로 할건지?
		
		try {
			URL u = new URL("http://192.168.0.88/ajax/menu.get");
			
			HttpURLConnection huc
				= (HttpURLConnection) u.openConnection();
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			System.out.println(br.readLine());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
