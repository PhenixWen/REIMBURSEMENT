package hrbeu.controller;

import hrbeu.dao.FengDingDaoImpl;
import hrbeu.dao.QiFuDaoImpl;
import hrbeu.entity.FengDing;
import hrbeu.entity.QiFu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FengDingAddServlet
 */
@WebServlet("/FengDingAddServlet")
public class FengDingAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FengDingAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String patientKind = request.getParameter("patientKind");
		String ceilingS = request.getParameter("ceiling");
		double ceiling = Double.parseDouble(ceilingS);
		FengDing f = new FengDing(null, patientKind, ceiling);
		//System.out.println(j);
		FengDingDaoImpl fddi = new FengDingDaoImpl();
		fddi.add(f);
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
