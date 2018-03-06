package hrbeu.controller;

import hrbeu.dao.YaoPinDaoImpl;
import hrbeu.entity.YaoPin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YaoPinUpdate1Servlet
 */
@WebServlet("/YaoPinUpdate1Servlet")
public class YaoPinUpdate1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YaoPinUpdate1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mediId = request.getParameter("mediId");
		YaoPinDaoImpl ypdi = new YaoPinDaoImpl();
		List<YaoPin> list = ypdi.query(mediId, null, null, null);
		request.setAttribute("medicine", list.get(0));
		//System.out.println(list.get(0));
		request.getRequestDispatcher("/page/yaopinupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
