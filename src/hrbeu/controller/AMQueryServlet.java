package hrbeu.controller;

import hrbeu.dao.AnnualMoneyDaoImpl;
import hrbeu.entity.AnnualMoney;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AMQueryServlet
 */
@WebServlet("/AMQueryServlet")
public class AMQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String nianfen = request.getParameter("nianfen");
		String page = request.getParameter("page");
		
		int curpage = 1;
		
		if(page != null){
			curpage = Integer.parseInt(page);
		}
		
		AnnualMoneyDaoImpl cur = new AnnualMoneyDaoImpl();
		List<AnnualMoney> aa = cur.selectAllAM(id, name, nianfen);
		int allnum = aa.size();
		allnum = allnum%5==0? allnum/5 : allnum/5 + 1;
		
		List<AnnualMoney> list = cur.selectPageAM(id, name, nianfen, curpage);
		
		request.setAttribute("list", list);
		request.setAttribute("pages", allnum);
		request.setAttribute("curpage", curpage);
		
		request.getRequestDispatcher("/page/annual_baoxiao.jsp").forward(request, response);
		
	}

}
