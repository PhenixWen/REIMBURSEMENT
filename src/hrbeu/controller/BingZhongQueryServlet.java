package hrbeu.controller;

import hrbeu.dao.BingZhongDaoImpl;
import hrbeu.dao.FuWuDaoImpl;
import hrbeu.entity.BingZhong;
import hrbeu.entity.FuWu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BingZhongQueryServlet
 */
@WebServlet("/BingZhongQueryServlet")
public class BingZhongQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BingZhongQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String diseId = request.getParameter("diseId");
		String diseName = request.getParameter("diseName");
		String diseKind =  request.getParameter("diseKind");
		String page = request.getParameter("page");
		String mark = request.getParameter("mark");
		if(mark.equals("1"))
			diseKind = new String(diseKind.getBytes("ISO-8859-1"), "UTF-8");
//		System.out.println(diseKind);
		int curPage = 1;
		if(page != null){
			curPage = Integer.parseInt(page);
		}
		BingZhongDaoImpl bzdi = new BingZhongDaoImpl();
		List<BingZhong> list = bzdi.query(diseId, diseName, diseKind);
		int allnum = list.size();
		allnum = allnum%5==0? allnum/5 : allnum/5 + 1;
//		System.out.println(allnum);
		List<BingZhong> l = bzdi.queryPage(diseId, diseName, diseKind, curPage);
		request.setAttribute("pages", allnum);
		request.setAttribute("curpage", curPage);
		request.setAttribute("bingzhonglist", l);
		request.setAttribute("diseId", diseId);
		request.setAttribute("diseName", diseName);
		request.setAttribute("diseKind", diseKind);
		request.getRequestDispatcher("/page/bingzhongquery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
