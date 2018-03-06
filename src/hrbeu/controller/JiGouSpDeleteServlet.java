package hrbeu.controller;

import hrbeu.dao.JiGouSpDaoImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JiGouSpDeleteServlet
 */
@WebServlet("/JiGouSpDeleteServlet")
public class JiGouSpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		JiGouSpDaoImpl cur = new JiGouSpDaoImpl();
		cur.delete(Integer.parseInt(no));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
