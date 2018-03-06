package hrbeu.controller;

import hrbeu.dao.YaoPinDaoImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YaoPinDeleteServlet
 */
@WebServlet("/YaoPinDeleteServlet")
public class YaoPinDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		YaoPinDaoImpl ypdi = new YaoPinDaoImpl();
		String mediId = request.getParameter("mediId");
		PrintWriter out = null;
		out = response.getWriter();
		try {
			ypdi.delete(mediId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.write("no");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
