package hrbeu.controller;

import hrbeu.dao.InsDaoImpl;
import hrbeu.entity.Ins;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsUpdateServlet2
 */
@WebServlet("/InsUpdateServlet2")
public class InsUpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("link to Ins Update SEVRLET2");
		String id = request.getParameter("insID");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String address = request.getParameter("address");
		String postcode = request.getParameter("postcode");
		String tel = request.getParameter("tel");
		
		///
		Ins curins = new Ins(Integer.parseInt(id), name, type
		,address, postcode, tel);
		System.out.println(curins + " " + "update ins");
		///
		InsDaoImpl cur = new InsDaoImpl();
		cur.updateIns(curins);
		
		request.getRequestDispatcher("/page/basical_institutions.jsp").forward(request, response);
	}

}
