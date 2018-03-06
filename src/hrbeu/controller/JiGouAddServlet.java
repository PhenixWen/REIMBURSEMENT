package hrbeu.controller;

import hrbeu.dao.FuWuDaoImpl;
import hrbeu.dao.JiGouDaoImpl;
import hrbeu.entity.FuWu;
import hrbeu.entity.JiGou;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JiGouAddServlet
 */
@WebServlet("/JiGouAddServlet")
public class JiGouAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JiGouAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String compId = request.getParameter("compId");
		String compName = request.getParameter("compName");
		String hosrank = request.getParameter("hosRank");
		String kind = request.getParameter("kind");
		String nam = request.getParameter("nam");
		String tel = request.getParameter("tel");
		String remarks = request.getParameter("remarks");
		JiGou j = new JiGou(compId, compName, hosrank, kind, nam, tel, remarks);
		//System.out.println(j);
		JiGouDaoImpl jgpi = new JiGouDaoImpl();
		jgpi.add(j);
		request.getRequestDispatcher("/page/jigouquery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
