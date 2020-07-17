package com.lee.jsp.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondController
 */
@WebServlet("/SecondController")
public class SecondController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SecondController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		M.make1(request, response);
		M.print1(request);
		request.getRequestDispatcher("secondV.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
