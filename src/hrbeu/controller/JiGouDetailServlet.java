package hrbeu.controller;

import hrbeu.dao.FuWuDaoImpl;
import hrbeu.dao.JiGouDaoImpl;
import hrbeu.entity.FuWu;
import hrbeu.entity.JiGou;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JiGouDetailServlet
 */
@WebServlet("/JiGouDetailServlet")
public class JiGouDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JiGouDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String compId = request.getParameter("compId");
		JiGouDaoImpl jgdi = new JiGouDaoImpl();
		List<JiGou> list = jgdi.query(compId, null, null, null);
		request.setAttribute("company", list.get(0));
		request.getRequestDispatcher("/page/jigoudetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
