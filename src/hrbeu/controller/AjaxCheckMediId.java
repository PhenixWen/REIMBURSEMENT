package hrbeu.controller;

import hrbeu.dao.YaoPinDaoImpl;
import hrbeu.entity.YaoPin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxCheckmediId
 */
@WebServlet("/AjaxCheckMediId")
public class AjaxCheckMediId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mediId = request.getParameter("mediId");
		YaoPinDaoImpl yaopind = new YaoPinDaoImpl();
		List<YaoPin> yaopins = yaopind.query(mediId, null, null, null);
		PrintWriter out = response.getWriter();
		int l = mediId.length();
		boolean p = false;
		for(int i = 0; i < l; ++i)
		{
			if(mediId.charAt(i) < '0' || mediId.charAt(i) > '9')
			{
				p = true;
				break;
			}
		}
		if(l < 4 || l > 8) p = true;
		if(p)
			out.write("empty");
		else
		if(yaopins.size() == 0)
			out.write("yes");
		else
			out.write("no");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
