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
 * Servlet implementation class edi_cf2
 */
@WebServlet("/edi_cf2")
public class edi_cf2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personId = request.getParameter("personId");
		String _ide = request.getParameter("ide");
		String mediId = request.getParameter("mediId");
		String projId = request.getParameter("projId");
		String servId = request.getParameter("servId");
		String _price = request.getParameter("price");
		String _num = request.getParameter("num");
		String _sum = request.getParameter("sum");
		String solveId = request.getParameter("solveId");
		int ide = Integer.parseInt(_ide);
		float price = Float.parseFloat(_price);
		int num = Integer.parseInt(_num);
		float sum = Float.parseFloat(_sum);
		Lis lis = new Lis(ide,mediId,projId,servId,price,num,sum,solveId,null,null,null,null);
		LisDaoImpl lisd = new LisDaoImpl();
		lisd.update(lis);
		String page = request.getParameter("page");
		int pagenow =1;
		if(page != null){
			pagenow = Integer.parseInt(page);
		}
		List<Lis> liss = lisd.queryPage(solveId, null, pagenow, 1);
		if(liss.size() > 0) request.setAttribute("liss", liss);
		int total = lisd.page(solveId, null, 1);
		int pages = total%10==0?total/10:total/10+1;
		request.setAttribute("pages", pages);
		request.setAttribute("solveId", solveId);
		request.setAttribute("personId", personId);
		request.getRequestDispatcher("/page/msg_cf.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
