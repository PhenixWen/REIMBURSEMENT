package hrbeu.controller;

import hrbeu.dao.JiuZhenDaoImpl;
import hrbeu.entity.JiuZhen;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cancel1
 */
@WebServlet("/cancel1")
public class cancel1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personId = request.getParameter("personId");
		String personName = request.getParameter("personName");
		String page = request.getParameter("page");
		int pagenow =1;
		if(page != null){
			pagenow = Integer.parseInt(page);
		}
		JiuZhenDaoImpl jiuzhend = new JiuZhenDaoImpl();
		List<JiuZhen> jiuzhens = jiuzhend.queryPage(null, personId, personName, pagenow, "已结算");
		if(jiuzhens.size() > 0) request.setAttribute("solves", jiuzhens);
		int total = jiuzhend.page(null, personId, personName, "已结算");
		int pages = total%5==0?total/5:total/5+1;
		request.setAttribute("pagenow", pagenow);
		request.setAttribute("pages", pages);
		request.setAttribute("personId", personId);
		request.setAttribute("personName", personName);
		request.getRequestDispatcher("/page/cancel.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
