package hrbeu.controller;

import hrbeu.dao.BingZhongDaoImpl;
import hrbeu.dao.FuWuDaoImpl;
import hrbeu.entity.BingZhong;
import hrbeu.entity.FuWu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BingZhongDetailServlet
 */
@WebServlet("/BingZhongDetailServlet")
public class BingZhongDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BingZhongDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String diseId = request.getParameter("diseId");
		BingZhongDaoImpl bzdi = new BingZhongDaoImpl();
		List<BingZhong> list = bzdi.query(diseId, null, null);
		request.setAttribute("disease", list.get(0));
		request.getRequestDispatcher("/page/bingzhongdetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
