package hrbeu.controller;

import hrbeu.dao.FenDuanDaoImpl;
import hrbeu.dao.QiFuDaoImpl;
import hrbeu.entity.FenDuan;
import hrbeu.entity.QiFu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QiFuQueryServlet
 */
@WebServlet("/QiFuQueryServlet")
public class QiFuQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QiFuQueryServlet() {
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
		QiFuDaoImpl qfdi = new QiFuDaoImpl();
		Integer ide = null;
		if(id != null && !id.isEmpty())
			ide = Integer.parseInt(id);
		List<QiFu> list = qfdi.query(ide, cureKind, patientKind, hosRank);
		int allnum = list.size();
		allnum = allnum%5==0? allnum/5 : allnum/5 + 1;
//		System.out.println(allnum);
		List<QiFu> l = qfdi.queryPage(ide, cureKind, patientKind, hosRank, curPage);
//		for (FenDuan fenDuan : list) {
//			System.out.println(fenDuan);
//		}
		request.setAttribute("ide", ide);
		request.setAttribute("pages", allnum);
		request.setAttribute("curpage", curPage);
		request.setAttribute("cureKind", cureKind);
		request.setAttribute("patientKind", patientKind);
		request.setAttribute("hosRank", hosRank);
		request.setAttribute("qifulist", l);
		request.getRequestDispatcher("/page/qifuquery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
