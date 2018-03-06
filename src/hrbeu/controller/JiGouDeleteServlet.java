package hrbeu.controller;

import hrbeu.dao.JiGouDaoImpl;
import hrbeu.dao.ZhenLiaoDaoImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JiGouDeleteServlet
 */
@WebServlet("/JiGouDeleteServlet")
public class JiGouDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JiGouDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JiGouDaoImpl jgdi = new JiGouDaoImpl();
		String compId = request.getParameter("compId");
//		System.out.println(compId);
		PrintWriter out = null;
		out = response.getWriter();
		try{
			jgdi.delete(compId);
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
