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
 * Servlet implementation class pre_solve
 */
@WebServlet("/pre_solve")
public class pre_solve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String solveId = request.getParameter("solveId");
		new JiuZhenDaoImpl().update(solveId);
		JiuZhen jiuzhen = new JiuZhenDaoImpl().query(solveId, null, null, null).get(0);
		jiuzhen.calc();
		new JiuZhenDaoImpl().solve(solveId, jiuzhen.getSum(), jiuzhen.getZf(), jiuzhen.getZfyl(), jiuzhen.getBx(), jiuzhen.getZffd(), jiuzhen.getBxlj(), jiuzhen.getZflis(), jiuzhen.getYllis());
		request.setAttribute("solve", jiuzhen);
		request.getRequestDispatcher("/page/pre_solve.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
