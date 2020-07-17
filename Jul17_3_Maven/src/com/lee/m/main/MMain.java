package com.lee.m.main;

import com.oreilly.servlet.MultipartRequest;

// XML파싱 : kxml2.jar 구해서 프로젝트에 --> Maven jar파일자동관리시스템

// Java : 전세계적으로 많이 사용하는 언어
//		작업한거를 공유 : maven중앙저장소  mvnrepository.com
//		공유된거를 잘 활용하는게 자바를 잘하는거
//			mvnrepository.com에서 찾아서 maven소스 복사
//			pom.xml에 붙이기 
//				</build> 밑에 <dependencies>파서 그 안에 붙이기. 
//				-> 자동으로 로컬저장소로 다운, 프로젝트로 세팅.
//				-> C:\사용자\계정\.m2\repository
//				c:\Users\홍길동\.m2 -> 경로에 한글 x

// Maven으로 .jar관리
// 		단순Java프로젝트 -변환-> Maven프로젝트
//		단순JSP프로젝트 -변환-> Maven프로젝트
//			프로젝트 우클릭 -> configure -> convert Maven project

//	바꾸면 pom.xml생김 <<---핵심
//	kxml2.jar

// ojdbc8이 메이븐 중앙 저장소에 없음(가끔없는거있음) 
//		-> 사설 저장소 : 인터넷 검색(ojdbc repository...)

public class MMain {
	
	public static void main(String[] args) {
		
	}
}
