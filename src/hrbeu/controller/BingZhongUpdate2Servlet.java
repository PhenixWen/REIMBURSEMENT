package hrbeu.controller;

import hrbeu.dao.BingZhongDaoImpl;
import hrbeu.dao.FuWuDaoImpl;
import hrbeu.entity.BingZhong;
import hrbeu.entity.FuWu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BingZhongUpdate2Servlet
 */
@WebServlet("/BingZhongUpdate2Servlet")
public class BingZhongUpdate2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BingZhongUpdate2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String diseId = request.getParameter("diseId");
		String diseName = request.getParameter("diseName");
		String diseKind = request.getParameter("diseKind");
		String diseM = request.getParameter("diseM");
		String remarks = request.getParameter("remarks");
		BingZhong b = new BingZhong(diseId, diseName, diseKind, diseM, remarks);
		//System.out.println(b);
		BingZhongDaoImpl bzpi = new BingZhongDaoImpl();
		bzpi.update(b);
		request.getRequestDispatcher("/page/bingzhongquery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
