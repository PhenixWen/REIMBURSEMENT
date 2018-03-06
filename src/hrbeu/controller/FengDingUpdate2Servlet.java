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
 * Servlet implementation class FengDingUpdate2Servlet
 */
@WebServlet("/FengDingUpdate2Servlet")
public class FengDingUpdate2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FengDingUpdate2Servlet() {
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
		String patientKind = request.getParameter("patientKind");
		String ceilingS = request.getParameter("ceiling");
		double ceiling = Double.parseDouble(ceilingS);
		FengDing f = new FengDing(ide, patientKind, ceiling);
		//System.out.println(f);
		FengDingDaoImpl fddi = new FengDingDaoImpl();
		fddi.update(f);
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
