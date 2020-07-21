package com.lee.mb.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// Java/Python
//		외부에서 데이터 받아서 파싱(XML/JSON)
//		-> 내 DB서버에 저장

//		내 DB서버에 저장된 데이터
//		-> 분석용 파일로

// JSON Parsing - > json-simple.jar

public class MBMain {
	public static void main(String[] args) {
		// 파싱해서 기온, 날씨를 콘솔에 출력
		
		try {
			SqlSession ss = DBManager2.connect();
			
			
			String addr = "http://api.openweathermap.org/data/2.5/weather?q=seoul&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr";
			URL u = new URL(addr);

			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			huc.addRequestProperty("Authorization", "KakaoAK 00df1ed27f9258c68437812788bfbf96");
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			// {} : JS의 객체 json object
			// [] : JS의 배열 json array
			// URL주소에서 데이터 형태를 보고 뭘 쓸지 결정
			JSONParser jp = new JSONParser();
			//		처음 전체데이터는 중괄호라 Object
			JSONObject jo = (JSONObject) jp.parse(isr);
			// JSONObject 전체내용중 weather배열
			JSONArray weather = (JSONArray) jo.get("weather");
			// weather배열 0번째에있는 자료를 JSONArray weather의 0번째에 받아 넣음
			JSONObject w0 = (JSONObject) weather.get(0);
			// weather객체 안의 변수 description을 가져옴
			System.out.println(w0.get("description"));
			///////////////////////////////////////////////
			JSONObject main = (JSONObject) jo.get("main");
			System.out.println(main.get("temp"));

			// xx.get() -> JSONObject
			// xx.get() -> JSONOArray
			// xx.get() -> String
			// xx.get() -> Long
			// xx.get() -> Double
			// 저중에 하나로 형변환 해야함
			
//			String w = (String) w0.get("description");
			String desc = w0.get("description") + ""; // 스트링 형변환 이렇게도가능
			
			BigDecimal temp = new BigDecimal(main.get("temp") + "");
			System.out.println(temp);
			
			Weather ww = new Weather(null, desc, temp); 
			
			if (ss.insert("wm.writeCurWeather", ww) == 1) {
				ss.commit();
				System.out.println("성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	
	}
}
