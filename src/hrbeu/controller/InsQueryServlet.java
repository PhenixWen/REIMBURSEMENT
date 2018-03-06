package hrbeu.controller;

import hrbeu.dao.InsDaoImpl;
import hrbeu.entity.Ins;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsQueryServlet
 */
@WebServlet("/InsQueryServlet")
public class InsQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("no");
		String name = request.getParameter("name");
		String page = request.getParameter("page");
		
		int curpage = 1;
		if(page != null){
			curpage = Integer.parseInt(page);
		}
		
		InsDaoImpl cur = new InsDaoImpl();
		List<Ins> aa = cur.selectAllIns(id, name, false);
		int allnum = aa.size();
		allnum = allnum%5==0? allnum/5 : allnum/5 + 1;
		
		List<Ins> list = cur.selectPageIns(id, name, curpage);
		
		request.setAttribute("list", list);
		request.setAttribute("pages", allnum);
		request.setAttribute("curpage", curpage);
		
		request.getRequestDispatcher("/page/basical_institutions.jsp").forward(request, response);
		
	}

}
