package hrbeu.controller;

import hrbeu.dao.YaoPinSpDaoImpl;
import hrbeu.entity.YaoPinSp;

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
@WebServlet("/YaoPinSpQueryServlet")
public class YaoPinSpQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("into yaopinsp query");
		
		String pid = request.getParameter("pid");
		request.setAttribute("pid", pid);
		
		String page = request.getParameter("page");
		
		YaoPinSpDaoImpl a = new YaoPinSpDaoImpl();
		
		int curpage = 1;
		if(page != null){
			curpage = Integer.parseInt(page);
		}
		
		int cur = -1;
		if(pid != null && !pid.equals("")){
			cur = Integer.parseInt(pid);
		}
		List<YaoPinSp> aa = a.select(cur, -1);
		
		int allnum = aa.size();
		allnum = allnum%5==0? allnum/5 : allnum/5 + 1;
		
		List<YaoPinSp> list = a.selectPage(cur, -1, curpage);
		
		request.setAttribute("p", list);
		request.setAttribute("pages", allnum);
		request.setAttribute("curpage", curpage);
		///
		request.getRequestDispatcher("/page/yaopinsp.jsp").forward(request, response);
	}

}
