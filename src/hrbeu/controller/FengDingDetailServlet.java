package hrbeu.controller;

import hrbeu.dao.FengDingDaoImpl;
import hrbeu.dao.QiFuDaoImpl;
import hrbeu.entity.FengDing;
import hrbeu.entity.QiFu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FengDingDetailServlet
 */
@WebServlet("/FengDingDetailServlet")
public class FengDingDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FengDingDetailServlet() {
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
		FengDingDaoImpl fddi = new FengDingDaoImpl();
		List<FengDing> list = fddi.query(ide, null);
		request.setAttribute("ceil", list.get(0));
		request.getRequestDispatcher("/page/fengdingdetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
