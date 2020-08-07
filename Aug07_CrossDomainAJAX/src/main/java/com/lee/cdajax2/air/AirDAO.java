package com.lee.cdajax2.air;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class AirDAO {
	
	public String getAir(HttpServletRequest req) {
		try {
			String w = req.getParameter("when");
			String s = "http://openapi.seoul.go.kr:8088/4f6a6547456b6368333355736a714f/xml/DailyAverageAirQuality/1/50/" + w;
			URL u = new URL(s);
			HttpURLConnection huc =(HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			StringBuffer sb = new StringBuffer();
			
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
