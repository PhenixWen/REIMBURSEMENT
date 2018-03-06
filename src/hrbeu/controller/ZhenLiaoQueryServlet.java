package hrbeu.controller;

import hrbeu.dao.YaoPinDaoImpl;
import hrbeu.dao.ZhenLiaoDaoImpl;
import hrbeu.entity.YaoPin;
import hrbeu.entity.ZhenLiao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ZhenLiaoQueryServlet
 */
@WebServlet("/ZhenLiaoQueryServlet")
public class ZhenLiaoQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZhenLiaoQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String projId = request.getParameter("projId");
		String projName = request.getParameter("projName");
		String page = request.getParameter("page");
		String mark = request.getParameter("mark");
		if(mark.equals("1")){
			if(projName != null)
				projName = new String(projName.getBytes("ISO-8859-1"), "UTF-8");
		}
		ZhenLiaoDaoImpl zldi = new ZhenLiaoDaoImpl();
		int curPage = 1;
		if(page != null){
			curPage = Integer.parseInt(page);
		}
		List<ZhenLiao> list = zldi.query(projId, projName);
		int allnum = list.size();
		allnum = allnum%5==0? allnum/5 : allnum/5 + 1;
		List<ZhenLiao> l = zldi.queryPage(projId, projName, curPage);
		
//		for (ZhenLiao zhenLiao : list) {
//			System.out.println(zhenLiao);
//		}
		request.setAttribute("zhenliaolist", l);
		request.setAttribute("pages", allnum);
		request.setAttribute("curpage", curPage);
		request.setAttribute("projId", projId);
		request.setAttribute("projName", projName);
		request.getRequestDispatcher("/page/zhenliaoquery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
