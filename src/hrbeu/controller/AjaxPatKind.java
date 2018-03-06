package hrbeu.controller;

import hrbeu.dao.PatientKindDaoImpl;
import hrbeu.entity.PatientKind;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;



@WebServlet("/AjaxPatKind")
public class AjaxPatKind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatientKindDaoImpl a = new PatientKindDaoImpl();
		List<PatientKind> list = a.queryall();
		JSONArray jsonarray = JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
		out.write(jsonarray.toString());
		out.flush();
		out.close();
		System.out.println(jsonarray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
