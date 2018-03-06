package hrbeu.controller;

import hrbeu.dao.ZhenLiaoDaoImpl;
import hrbeu.entity.ZhenLiao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ZhenLiaoUpdate1Servlet
 */
@WebServlet("/ZhenLiaoUpdate1Servlet")
public class ZhenLiaoUpdate1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZhenLiaoUpdate1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String projId = request.getParameter("projId");
		ZhenLiaoDaoImpl zldi = new ZhenLiaoDaoImpl();
		List<ZhenLiao> list = zldi.query(projId, null);
		request.setAttribute("project", list.get(0));
		request.getRequestDispatcher("/page/zhenliaoupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
