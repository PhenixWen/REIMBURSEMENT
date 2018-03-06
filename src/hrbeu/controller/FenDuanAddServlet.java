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
 * Servlet implementation class FenDuanAddServlet
 */
@WebServlet("/FenDuanAddServlet")
public class FenDuanAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FenDuanAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cureKind = request.getParameter("cureKind");
		String patientKind = request.getParameter("patientKind");
		String hosRank = request.getParameter("hosRank");
		String ceilingS = request.getParameter("ceiling");
		String floorS = request.getParameter("floor");
		String ratioS = request.getParameter("ratio");
		double ceiling;
		if(ceilingS != null && !ceilingS.isEmpty())
			ceiling = Double.parseDouble(ceilingS);
		else
			ceiling = -1;
		double floor = Double.parseDouble(floorS);
		double ratio = Double.parseDouble(ratioS);
		FenDuan f = new FenDuan(null, cureKind, patientKind, hosRank, ceiling, floor, ratio);
		//System.out.println(j);
		FenDuanDaoImpl fdpi = new FenDuanDaoImpl();
		fdpi.add(f);
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
