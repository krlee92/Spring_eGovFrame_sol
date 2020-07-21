package com.lee.mb.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

// 내 DB서버에 저장된 데이터
//		-> 분석용 파일로 만들기

public class MBMain2 {
	public static void main(String[] args) {
		// DB에 있는거 다 select해서
		// 콘솔에 출력
		// 연,월,일,요일,시(24),분,날씨,기온
		//	2020,07,21,화,12,37,맑음,30.00
		
		// Date <-> String
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd,EE,kk,mm,");
		BufferedWriter bw = null;
		try {
			SqlSession ss = DBManager2.connect();
			List<Weather> weathers = ss.selectList("wm.getWeatherInfo");
			
			// 인코딩 방식 뭘지?
			// FileWriter를 바로 쓰면 인코딩방식 변경 불가
//			FileWriter fw = new FileWriter("D:/lee/eGovFrame/weather.csv", true);
			
			FileOutputStream fos
				= new FileOutputStream("D:/lee/eGovFrame/weather.csv", true);
			
			// 여기서 인코딩방식 조절가능
			OutputStreamWriter osw
				= new OutputStreamWriter(fos, "utf-8");
			
			bw = new BufferedWriter(osw);
			
			for (Weather w : weathers) {
				bw.write(sdf.format(w.getW_when()));
				bw.write(w.getW_weather() + ",");
				bw.write(w.getW_temp() + "\r\n");
				bw.flush();
			}
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
