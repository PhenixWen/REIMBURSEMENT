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
 * Servlet implementation class edi_jz1
 */
@WebServlet("/edi_jz1")
public class edi_jz1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personName= request.getParameter("personName");
		String personId = request.getParameter("personId");
		String solveId = request.getParameter("solveId");
		JiuZhen jiuzhen = new JiuZhenDaoImpl().query(solveId, null, null, null).get(0);
		request.setAttribute("jiuzhen", jiuzhen);
		request.setAttribute("personId", personId);
		request.setAttribute("solveId", solveId);
		request.setAttribute("personName", personName);
		request.getRequestDispatcher("/page/edi_jz.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
