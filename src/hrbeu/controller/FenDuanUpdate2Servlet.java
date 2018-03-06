package hrbeu.controller;

import hrbeu.dao.FenDuanDaoImpl;
import hrbeu.dao.JiGouDaoImpl;
import hrbeu.entity.FenDuan;
import hrbeu.entity.JiGou;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FenDuanUpdate2Servlet
 */
@WebServlet("/FenDuanUpdate2Servlet")
public class FenDuanUpdate2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FenDuanUpdate2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("ide");
		int ide = Integer.parseInt(id);
		String cureKind = request.getParameter("cureKind");
		String patientKind = request.getParameter("patientKind");
		String hosRank = request.getParameter("hosRank");
		String ceilingS = request.getParameter("ceiling");
		double ceiling = Double.parseDouble(ceilingS);
		String floorS = request.getParameter("floor");
		double floor = Double.parseDouble(floorS);
		String retioS = request.getParameter("ratio");
		double ratio = Double.parseDouble(retioS);
		FenDuan f = new FenDuan(ide, cureKind, patientKind, hosRank, ceiling, floor, ratio);
		//System.out.println(f);
		FenDuanDaoImpl fddi = new FenDuanDaoImpl();
		fddi.update(f);
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
