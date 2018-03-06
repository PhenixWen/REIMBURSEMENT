package hrbeu.controller;

import hrbeu.dao.JiuZhenDaoImpl;
import hrbeu.entity.JiuZhen;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add_jz_solveId_ajax
 */
@WebServlet("/add_jz_solveId_ajax")
public class add_jz_solveId_ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String solveId = request.getParameter("solveId");
		List<JiuZhen> jiuzhens = new JiuZhenDaoImpl().query(solveId, null, null, null);
		PrintWriter out = response.getWriter();
		if(jiuzhens.size() == 0)out.write("no");
		else out.write("yes");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
