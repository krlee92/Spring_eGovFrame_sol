package com.lee.jsp.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstController")
public class FirstController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FirstController() {
        super();
    }
    
    // 어떤 사이트에 처음 접속 : GET방식 요청
     
    // 주소를 브라우저에 직접 쳐서 들어가는거 : GET방식 request
    // 눌러서 들어가는거<a></a> - GET방식 요청
    // JavaScript로 - GET방식 요청
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("firstV.jsp").forward(request, response);
	}
	
	// POST방식 요청은 <form> + <button>으로만 가능
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
