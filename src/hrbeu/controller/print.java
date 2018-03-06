package hrbeu.controller;

import hrbeu.dao.JiuZhenDaoImpl;
import hrbeu.entity.JiuZhen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class print
 */
@WebServlet("/print")
public class print extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String solveId = request.getParameter("solveId");
		JiuZhen jiuzhen = new JiuZhenDaoImpl().query(solveId, null, null, null).get(0);
		new JiuZhenDaoImpl().solveflag(solveId);
		request.setAttribute("solve", jiuzhen);
		request.getRequestDispatcher("/page/print.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
