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

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String psw1 = request.getParameter("psw1");
		String psw2 = request.getParameter("psw2");
		LogInDaoImpl a = new LogInDaoImpl();
		List<LogIn> list = a.selectALL(name, null, true);
		
		if(!psw1.equals(psw2)){
			request.getRequestDispatcher("/page/sign_psw.jsp").forward(request, response);
		}
		else if(!list.isEmpty()){
			request.getRequestDispatcher("/page/sign_account.jsp").forward(request, response);
		}
		else{
			LogIn cur = new LogIn(name, psw1);
			a.insert(cur);
			request.getRequestDispatcher("/page/index.jsp").forward(request, response);
		}
	}

}
