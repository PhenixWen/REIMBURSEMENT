package hrbeu.controller;


import hrbeu.dao.LogInDaoImpl;
import hrbeu.entity.LogIn;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String psw = request.getParameter("psw");
		LogInDaoImpl a = new LogInDaoImpl();
		
		List<LogIn> list = a.selectALL(name, psw, true);
		
		if(list.isEmpty()){
			request.setAttribute("message", "用户名或密码错误，请重新登录！");
			request.getRequestDispatcher("/page/login.jsp").forward(request, response);
		}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("user", name);	
			request.getRequestDispatcher("/page/index.jsp").forward(request, response);
		}
	}

}
