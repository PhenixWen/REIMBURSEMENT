package hrbeu.controller;

import hrbeu.dao.FenDuanDaoImpl;
import hrbeu.dao.QiFuDaoImpl;
import hrbeu.entity.FenDuan;
import hrbeu.entity.QiFu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QiFuDetailServlet
 */
@WebServlet("/QiFuDetailServlet")
public class QiFuDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QiFuDetailServlet() {
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
		QiFuDaoImpl qfdi = new QiFuDaoImpl();
		List<QiFu> list = qfdi.query(ide, null, null, null);
		request.setAttribute("standard", list.get(0));
		request.getRequestDispatcher("/page/qifudetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
