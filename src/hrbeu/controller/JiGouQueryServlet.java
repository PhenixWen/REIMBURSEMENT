package hrbeu.controller;

import hrbeu.dao.FuWuDaoImpl;
import hrbeu.dao.JiGouDaoImpl;
import hrbeu.entity.FuWu;
import hrbeu.entity.JiGou;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JiGouQueryServlet
 */
@WebServlet("/JiGouQueryServlet")
public class JiGouQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JiGouQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String compId = request.getParameter("compId");
		String compName = request.getParameter("compName");
		String hosRank =  request.getParameter("hosRank");
		String kind = request.getParameter("kind");
		JiGouDaoImpl jgdi = new JiGouDaoImpl();
		String page = request.getParameter("page");
		String mark = request.getParameter("mark");
//		System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
//		System.out.println(compName);
//		System.out.println(hosRank);
//		System.out.println(kind);
		if(mark.equals("1")){
			if(compName != null)
			compName = new String(compName.getBytes("ISO-8859-1"), "UTF-8");
			hosRank = new String(hosRank.getBytes("ISO-8859-1"), "UTF-8");
			kind = new String(kind.getBytes("ISO-8859-1"), "UTF-8");
		}
		int curPage = 1;
		if(page != null){
			curPage = Integer.parseInt(page);
		}
		List<JiGou> list = jgdi.query(compId, compName, hosRank, kind);
		int allnum = list.size();
		allnum = allnum%5==0? allnum/5 : allnum/5 + 1;
		List<JiGou> l = jgdi.queryPage(compId, compName, hosRank, kind, curPage);
		
//		for (JiGou jiGou : list) {
//			System.out.println(jiGou);
//		}
		request.setAttribute("pages", allnum);
		request.setAttribute("curpage", curPage);
		request.setAttribute("compName", compName);
		request.setAttribute("compId", compId);
		request.setAttribute("hosRank", hosRank);
		request.setAttribute("kind", kind);
		request.setAttribute("jigoulist", l);
		request.getRequestDispatcher("/page/jigouquery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
