package hrbeu.controller;

import hrbeu.dao.FuWuDaoImpl;
import hrbeu.dao.ZhenLiaoDaoImpl;
import hrbeu.entity.FuWu;
import hrbeu.entity.ZhenLiao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FuWuQueryServlet
 */
@WebServlet("/FuWuQueryServlet")
public class FuWuQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuWuQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servId = request.getParameter("servId");
		String servName = request.getParameter("servName");
		String page = request.getParameter("page");
		String mark = request.getParameter("mark");
		if(mark.equals("1"))
			servName = new String(servName.getBytes("ISO-8859-1"), "UTF-8");
		int curPage = 1;
		if(page != null){
			curPage = Integer.parseInt(page);
		}
		FuWuDaoImpl fwdi = new FuWuDaoImpl();
		List<FuWu> list = fwdi.query(servId, servName);
		int allnum = list.size();
		allnum = allnum%5==0? allnum/5 : allnum/5 + 1;
		
//		for (ZhenLiao zhenLiao : list) {
//			System.out.println(zhenLiao);
//		}
		List<FuWu> l = fwdi.queryPage(servId, servName, curPage);
		request.setAttribute("pages", allnum);
		request.setAttribute("curpage", curPage);
		request.setAttribute("servId", servId);
		request.setAttribute("servName", servName);
		request.setAttribute("fuwulist", l);
		request.getRequestDispatcher("/page/fuwuquery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
