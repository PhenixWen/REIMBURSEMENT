package hrbeu.controller;

import hrbeu.dao.FengDingDaoImpl;
import hrbeu.dao.PatientKindDaoImpl;
import hrbeu.dao.QiFuDaoImpl;
import hrbeu.entity.FengDing;
import hrbeu.entity.QiFu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FengDingQueryServlet
 */
@WebServlet("/FengDingQueryServlet")
public class FengDingQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FengDingQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String patientKind =  request.getParameter("patientKind");
		String page = request.getParameter("page");
		String mark = request.getParameter("mark");
		FengDingDaoImpl fddi = new FengDingDaoImpl();
		int curPage = 1;
		if(mark.equals("1"))
			patientKind = new String(patientKind.getBytes("ISO-8859-1"), "UTF-8");
		if(page != null){
			curPage = Integer.parseInt(page);
		}
		List<FengDing> list = fddi.query(null, patientKind);
//		for (FenDuan fenDuan : list) {
//			System.out.println(fenDuan);
//		}
		List<FengDing> l = fddi.queryPage(null, patientKind, curPage);
		int allnum = list.size();
		allnum = allnum%5==0? allnum/5 : allnum/5 + 1;
		request.setAttribute("pages", allnum);
		request.setAttribute("curpage", curPage);
		request.setAttribute("patientKind", patientKind);
		request.setAttribute("fengdinglist", l);
		request.getRequestDispatcher("/page/fengdingquery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
