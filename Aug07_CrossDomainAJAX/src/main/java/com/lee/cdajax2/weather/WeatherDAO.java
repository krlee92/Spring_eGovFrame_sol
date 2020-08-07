package com.lee.cdajax2.weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class WeatherDAO {
	
	public String getWeather() {
		try {
			URL u = new URL("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=281858500");
			HttpURLConnection huc
				= (HttpURLConnection)u.openConnection();
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
