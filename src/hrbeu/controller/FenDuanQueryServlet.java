package hrbeu.controller;

import hrbeu.dao.FenDuanDaoImpl;
import hrbeu.dao.JiGouDaoImpl;
import hrbeu.entity.FenDuan;
import hrbeu.entity.JiGou;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FenDuanQueryServlet
 */
@WebServlet("/FenDuanQueryServlet")
public class FenDuanQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FenDuanQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("ide");
		String cureKind = request.getParameter("cureKind");
		String patientKind =  request.getParameter("patientKind");
		String hosRank = request.getParameter("hosRank");
		String page = request.getParameter("page");
		String mark = request.getParameter("mark");
		if(mark.equals("1")){
			if(cureKind != null)
				cureKind = new String(cureKind.getBytes("ISO-8859-1"), "UTF-8");
			if(patientKind != null)
				patientKind = new String(patientKind.getBytes("ISO-8859-1"), "UTF-8");
			if(hosRank != null)
				hosRank = new String(hosRank.getBytes("ISO-8859-1"), "UTF-8");
		}
		int curPage = 1;
		if(page != null){
			curPage = Integer.parseInt(page);
		}
		FenDuanDaoImpl fddi = new FenDuanDaoImpl();
		Integer ide = null;
		if(id != null && !id.isEmpty())
			ide = Integer.parseInt(id);
		List<FenDuan> list = fddi.query(ide, cureKind, patientKind, hosRank);
		int allnum = list.size();
		allnum = allnum%10==0? allnum/10 : allnum/10 + 1;
//		for (FenDuan fenDuan : list) {
//			System.out.println(fenDuan);
//		}
		List<FenDuan> l = fddi.queryPage(ide, cureKind, patientKind, hosRank, curPage);
		request.setAttribute("ide", ide);
		request.setAttribute("pages", allnum);
		request.setAttribute("curpage", curPage);
		request.setAttribute("cureKind", cureKind);
		request.setAttribute("patientKind", patientKind);
		request.setAttribute("hosRank", hosRank);
		request.setAttribute("fenduanlist", l);
		request.getRequestDispatcher("/page/fenduanquery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
