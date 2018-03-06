package hrbeu.controller;

import hrbeu.dao.LisDaoImpl;
import hrbeu.entity.Lis;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add_cf
 */
@WebServlet("/add_zlxm")
public class add_zlxm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personId = request.getParameter("personId");
		String mediId = request.getParameter("mediId");
		String projId = request.getParameter("projId");
		String servId = request.getParameter("servId");
		String _price = request.getParameter("price");
		String _num = request.getParameter("num");
		String _sum = request.getParameter("sum");
		String solveId = request.getParameter("solveId");
		float price = Float.parseFloat(_price);
		int num = Integer.parseInt(_num);
		float sum = Float.parseFloat(_sum);
		Lis lis = new Lis(0,mediId,projId,servId,price,num,sum,solveId,null,null,null,null);
		LisDaoImpl lisd = new LisDaoImpl();
		lisd.insert(lis);
		String page = request.getParameter("page");
		int pagenow =1;
		if(page != null){
			pagenow = Integer.parseInt(page);
		}
		lisd = new LisDaoImpl();
		List<Lis> liss = lisd.queryPage(solveId, null, pagenow, 2);
		if(liss.size() > 0) request.setAttribute("liss", liss);
		int cnt = lisd.page(solveId, null, 2);
		int pages = cnt%10==0?cnt/10:cnt/10+1;
		request.setAttribute("pages", pages);
		request.setAttribute("solveId", solveId);
		request.setAttribute("personId", personId);
		request.getRequestDispatcher("/page/msg_zlxm.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
