package hrbeu.controller;

import hrbeu.dao.JiGouDaoImpl;
import hrbeu.dao.YaoPinDaoImpl;
import hrbeu.entity.JiGou;
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
 * Servlet implementation class AjaxCheckCompId
 */
@WebServlet("/AjaxCheckCompIdyz")
public class AjaxCheckCompIdyz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCheckCompIdyz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String compId = request.getParameter("compId");
		System.out.println(compId);
		JiGouDaoImpl jgdi = new JiGouDaoImpl();
		List<JiGou> list = jgdi.query(compId, null, null, null);
		PrintWriter out = response.getWriter();
		int l = compId.length();
		boolean p = false;
		for(int i = 0; i < l; ++i)
		{
			if(compId.charAt(i) < '0' || compId.charAt(i) > '9')
			{
				p = true;
				break;
			}
		}
		if(l < 4 || l > 8) p = true;
		if(p)
			out.write("empty");
		else
		if(list.size() == 0)
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
		doGet(request, response);
	}

}
