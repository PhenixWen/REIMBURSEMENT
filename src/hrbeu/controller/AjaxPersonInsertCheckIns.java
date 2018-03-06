package hrbeu.controller;

import hrbeu.dao.InsDaoImpl;
import hrbeu.entity.Ins;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AjaxPersonInsertCheckIns")
public class AjaxPersonInsertCheckIns extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("into checkIns");
		String InsID = request.getParameter("InsID");
		InsDaoImpl a = new InsDaoImpl();
		List<Ins>list = a.selectAllIns(InsID, null, true);
		PrintWriter out = response.getWriter();
		if(list.isEmpty()){
			out.write("no");
			System.out.println("out no");
		}
		else{
			out.write(list.get(0).getInsName());
			System.out.println("out yes");
		}
		out.flush();
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
