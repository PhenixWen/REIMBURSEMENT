package hrbeu.controller;

import hrbeu.dao.JiGouDaoImpl;
import hrbeu.entity.JiGou;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AjaxCheckCompID")
public class AjaxCheckCompID extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("into CheckCompID");
		String compID = request.getParameter("compID");
		
		JiGouDaoImpl a = new JiGouDaoImpl();
		List<JiGou> list = a.query(compID, null, null, null);
		PrintWriter out = response.getWriter();
		
		if(compID.equals("")){
			out.write("no");
			out.flush();
			out.close();
			return;
		}
		
		if(list.isEmpty()){
			out.write("no");
			System.out.println("out no");
		}
		else{
			System.out.println("out yes");
			out.write(list.get(0).getCompName());
		}
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
