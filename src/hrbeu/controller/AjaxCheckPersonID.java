package hrbeu.controller;

import hrbeu.dao.LogInDaoImpl;
import hrbeu.entity.LogIn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AjaxCheckPersonID")
public class AjaxCheckPersonID extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("into CheckPersonID");
		String name = request.getParameter("name");
		System.out.println("curname = " + name);
		LogInDaoImpl a = new LogInDaoImpl();
		List<LogIn> list = a.selectALL(name, null, true);
		PrintWriter out = response.getWriter();
		if(list.isEmpty()){
			out.write("yes");
			System.out.println("out yes");
		}
		else{
			out.write("no");
			System.out.println("out no");
		}
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
