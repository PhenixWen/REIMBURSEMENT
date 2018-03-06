package hrbeu.controller;

import hrbeu.dao.YaoPinDaoImpl;
import hrbeu.entity.YaoPin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class YaoPinQueryServlet
 */
@WebServlet("/YaoPinQueryServlet")
public class YaoPinQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YaoPinQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mediId = request.getParameter("mediId");
		String mediName = request.getParameter("mediName");
		String factorName = request.getParameter("factorName");
		String drugCertificate = request.getParameter("drugCertificate");
		String page = request.getParameter("page");
		String mark = request.getParameter("mark");
		if(mark.equals("1")){
			if(mediName != null)
				mediName = new String(mediName.getBytes("ISO-8859-1"), "UTF-8");
			if(factorName != null)
				factorName = new String(factorName.getBytes("ISO-8859-1"), "UTF-8");
		}
		int curPage = 1;
		if(page != null){
			curPage = Integer.parseInt(page);
		}
		YaoPinDaoImpl ypdi = new YaoPinDaoImpl();
		List<YaoPin> list = ypdi.query(mediId, mediName, factorName, drugCertificate);
		int allnum = list.size();
		allnum = allnum%5==0? allnum/5 : allnum/5 + 1;
		List<YaoPin> l = ypdi.queryPage(mediId, mediName, factorName, drugCertificate, curPage);
//		System.out.println(curPage);
//		for (YaoPin yaoPin : l) {
//			System.out.println(yaoPin);
//		}
		request.setAttribute("yaopinlist", l);
		request.setAttribute("pages", allnum);
		request.setAttribute("curpage", curPage);
		request.setAttribute("mediId", mediId);
		request.setAttribute("mediName", mediName);
		request.setAttribute("factorName", factorName);
		request.setAttribute("drugCertificate", drugCertificate);
		request.getRequestDispatcher("/page/yaopinquery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
