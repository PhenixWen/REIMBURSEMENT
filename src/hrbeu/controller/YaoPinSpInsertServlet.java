package hrbeu.controller;

import hrbeu.dao.YaoPinSpDaoImpl;
import hrbeu.entity.YaoPinSp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JiGouSpInsertServlet
 */
@WebServlet("/YaoPinSpInsertServlet")
public class YaoPinSpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("into insert jyaopinsp servlet");
		String Id = request.getParameter("Id");
		String Name = request.getParameter("Name");
		String medi = request.getParameter("medi");
		String stdate = request.getParameter("stdate");
		String eddate = request.getParameter("eddate");
		
		///
		YaoPinSp cur = new YaoPinSp();
		cur.setMediId(medi);
		cur.setPersonID(Integer.parseInt(Id));
		cur.setStdate(stdate);
		cur.setPersonName(Name);
		cur.setEddate(eddate);
		///
		YaoPinSpDaoImpl a = new YaoPinSpDaoImpl();
		a.insert(cur);
		///
		request.getRequestDispatcher("/page/yaopinsp.jsp").forward(request, response);
	}

}
