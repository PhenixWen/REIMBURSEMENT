package hrbeu.controller;

import hrbeu.dao.JiGouSpDaoImpl;
import hrbeu.entity.JiGouSp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JiGouSpQueryServlet
 */
@WebServlet("/JiGouSpQueryServlet")
public class JiGouSpQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("intot jigousp query");
		
		String pid = request.getParameter("pid");
		String page = request.getParameter("page");
		request.setAttribute("pid", pid);
		
		
		JiGouSpDaoImpl a = new JiGouSpDaoImpl();
		
		int curpage = 1;
		if(page != null){
			curpage = Integer.parseInt(page);
		}
		
		int cur = -1;
		if(pid != null && !pid.equals("")){
			cur = Integer.parseInt(pid);
		}
		List<JiGouSp> aa = a.select(cur, -1);
		int allnum = aa.size();
		allnum = allnum%5==0? allnum/5 : allnum/5 + 1;
		
		List<JiGouSp> list = a.selectPage(cur, -1, curpage);
		
		request.setAttribute("p", list);
		request.setAttribute("pages", allnum);
		request.setAttribute("curpage", curpage);
		///
		request.getRequestDispatcher("/page/jigousp.jsp").forward(request, response);
	}

}
