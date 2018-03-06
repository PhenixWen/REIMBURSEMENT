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
 * Servlet implementation class InsInsertServlet
 */
@WebServlet("/InsInsertServlet")
public class InsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("into insert ins");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String address = request.getParameter("address");
		String postcode = request.getParameter("postcode");
		String tel = request.getParameter("tel");
		
		///
		Ins curins = new Ins();
		
		curins.setInsName(name);
		curins.setInsAdd(address);
		curins.setInsType(type);
		curins.setInsPost(postcode);
		curins.setInsTel(tel);
		
		///
		System.out.println(curins);
		if(name.equals("")){
			request.setAttribute("message", "请输入用户姓名");
			request.getRequestDispatcher("/page/institution_add.jsp").forward(request, response);
		}
		else{
			InsDaoImpl cur = new InsDaoImpl();
			cur.insertIns(curins);
			request.getRequestDispatcher("/page/basical_institutions.jsp").forward(request, response);
		}
	}

}
