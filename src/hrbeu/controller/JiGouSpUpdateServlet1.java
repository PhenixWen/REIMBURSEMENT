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


@WebServlet("/JiGouSpUpdateServlet1")
public class JiGouSpUpdateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		JiGouSpDaoImpl cur = new JiGouSpDaoImpl();
		
		System.out.println("into jigousp update 1" + no);
		
		List<JiGouSp>list = cur.select(-1, Integer.parseInt(no));
		
		System.out.println(list.get(0));
		
		request.setAttribute("p", list.get(0));
		request.getRequestDispatcher("/page/jigousp_update.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
