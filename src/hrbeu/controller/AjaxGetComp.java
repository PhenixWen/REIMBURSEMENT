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

import net.sf.json.JSONArray;


@WebServlet("/AjaxGetComp")
public class AjaxGetComp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JiGouDaoImpl aa = new JiGouDaoImpl();
		List<JiGou> list = aa.query(null, null, null, null);
		JSONArray jsonarray = JSONArray.fromObject(list);
		System.out.println(jsonarray);
		
		PrintWriter out = response.getWriter();
		out.write(jsonarray.toString());
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
