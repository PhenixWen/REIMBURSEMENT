package hrbeu.controller;

import hrbeu.dao.FuWuDaoImpl;
import hrbeu.dao.ZhenLiaoDaoImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FuWuDeleteServlet
 */
@WebServlet("/FuWuDeleteServlet")
public class FuWuDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuWuDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FuWuDaoImpl fwdi = new FuWuDaoImpl();
		String servId = request.getParameter("servId");
		PrintWriter out = null;
		out = response.getWriter();
		try{
			fwdi.delete(servId);
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
