package hrbeu.controller;

import hrbeu.dao.BingZhongDaoImpl;
import hrbeu.dao.FuWuDaoImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BingZhongDeleteServlet
 */
@WebServlet("/BingZhongDeleteServlet")
public class BingZhongDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BingZhongDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BingZhongDaoImpl bzdi = new BingZhongDaoImpl();
		String diseId = request.getParameter("diseId");
		PrintWriter out = null;
		out = response.getWriter();
		try{
			bzdi.delete(diseId);
		}catch(Exception e){
			e.printStackTrace();
			out.write("no");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
