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
 * Servlet implementation class JiGouUpdate2Servlet
 */
@WebServlet("/JiGouUpdate2Servlet")
public class JiGouUpdate2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JiGouUpdate2Servlet() {
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
		String hosRank = request.getParameter("hosRank");
		String kind = request.getParameter("kind");
		String nam = request.getParameter("nam");
		String tel = request.getParameter("tel");
		String remarks = request.getParameter("remarks");
		JiGou j = new JiGou(compId, compName, hosRank, kind, nam, tel, remarks);
		//System.out.println(f);
		JiGouDaoImpl jgdi = new JiGouDaoImpl();
		jgdi.update(j);
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
