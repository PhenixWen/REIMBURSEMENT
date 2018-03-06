package hrbeu.controller;

import hrbeu.dao.LisDaoImpl;
import hrbeu.dao.YaoPinDaoImpl;
import hrbeu.entity.Lis;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class msg_cf
 */
@WebServlet("/msg_cf")
public class msg_cf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String solveId = request.getParameter("solveId");
		String personId = request.getParameter("personId");
		String page = request.getParameter("page");
		int pagenow =1;
		if(page != null){
			pagenow = Integer.parseInt(page);
		}
		LisDaoImpl lisd = new LisDaoImpl();
		List<Lis> liss = lisd.queryPage(solveId, null, pagenow, 1);
		if(liss.size() > 0){
			for(Lis lis : liss){
				lis.setExamine(new YaoPinDaoImpl().query(lis.getMediId(), null, null, null).get(0).getExamine());
			}
			request.setAttribute("liss", liss);
		}
		int total = lisd.page(solveId, null, 1);
		int pages = total%5==0?total/5:total/5+1;
		request.setAttribute("pages", pages);
		request.setAttribute("pagenow", pagenow);
		request.setAttribute("solveId", solveId);
		request.setAttribute("personId", personId);
		request.getRequestDispatcher("/page/msg_cf.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
