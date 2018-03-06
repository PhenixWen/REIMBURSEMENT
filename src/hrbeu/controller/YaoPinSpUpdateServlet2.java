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
 * Servlet implementation class JiGouSpUpdateServlet2
 */
@WebServlet("/YaoPinSpUpdateServlet2")
public class YaoPinSpUpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("link to YaoPinSp Update SEVRLET2");
		String spID = request.getParameter("spID");
		String pID = request.getParameter("Id");
		String Name = request.getParameter("Name");
		String medi = request.getParameter("medi");
		String stdate = request.getParameter("stdate");
		String eddate = request.getParameter("eddate");
		///
		YaoPinSp cur = new YaoPinSp();
		cur.setMediId(medi);
		cur.setSpID(Integer.parseInt(spID));
		cur.setPersonID(Integer.parseInt(pID));
		cur.setStdate(stdate);
		cur.setEddate(eddate);
		cur.setPersonName(Name);
		
		System.out.println(cur);
		///
		YaoPinSpDaoImpl a = new YaoPinSpDaoImpl();
		a.update(cur);
		///
		request.getRequestDispatcher("/page/yaopinsp.jsp").forward(request, response);
	}

}
