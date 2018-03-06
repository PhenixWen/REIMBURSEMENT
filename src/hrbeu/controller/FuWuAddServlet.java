package hrbeu.controller;

import hrbeu.dao.FuWuDaoImpl;
import hrbeu.dao.ZhenLiaoDaoImpl;
import hrbeu.entity.FuWu;
import hrbeu.entity.ZhenLiao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FuWuAddServlet
 */
@WebServlet("/FuWuAddServlet")
public class FuWuAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuWuAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servId = request.getParameter("servId");
		String servName = request.getParameter("servName");
		String feeKind = request.getParameter("feeKind");
		String rge = request.getParameter("rge");
		String remarks = request.getParameter("remarks");
		FuWu f = new FuWu(servId, servName, feeKind, remarks, rge);
		//System.out.println(z);
		FuWuDaoImpl fwpi = new FuWuDaoImpl();
		fwpi.add(f);
		request.getRequestDispatcher("/page/fuwuquery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
