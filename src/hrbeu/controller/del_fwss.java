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
 * Servlet implementation class del_fwss
 */
@WebServlet("/del_fwss")
public class del_fwss extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personId = request.getParameter("personId");
		String ide = request.getParameter("ide");
		LisDaoImpl lisd = new LisDaoImpl();
		lisd.delete(ide);
		String solveId= request.getParameter("solveId");
		String page = request.getParameter("page");
		int pagenow =1;
		if(page != null){
			pagenow = Integer.parseInt(page);
		}
		lisd = new LisDaoImpl();
		List<Lis> liss = lisd.queryPage(solveId, null, pagenow, 3);
		if(liss.size() > 0) request.setAttribute("liss", liss);
		int total = lisd.page(solveId, null, 3);
		int pages = total%10==0?total/10:total/10+1;
		request.setAttribute("pages", pages);
		request.setAttribute("solveId", solveId);
		request.setAttribute("personId", personId);
		request.getRequestDispatcher("/page/msg_fwss.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
