package hrbeu.controller;

import hrbeu.dao.JiGouSpDaoImpl;
import hrbeu.entity.JiGouSp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JiGouSpInsertServlet
 */
@WebServlet("/JiGouSpInsertServlet")
public class JiGouSpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("into insert jigousp servlet");
		String Id = request.getParameter("Id");
		String Name = request.getParameter("Name");
		String compID = request.getParameter("compID");
		String stdate = request.getParameter("stdate");
		String eddate = request.getParameter("eddate");
		
		///
		JiGouSp cur = new JiGouSp();
		cur.setCompID(compID);
		cur.setPersonID(Integer.parseInt(Id));
		cur.setStdate(stdate);
		cur.setPersonName(Name);
		cur.setEddate(eddate);
		///
		JiGouSpDaoImpl a = new JiGouSpDaoImpl();
		a.insert(cur);
		///
		request.getRequestDispatcher("/page/jigousp.jsp").forward(request, response);
	}

}
