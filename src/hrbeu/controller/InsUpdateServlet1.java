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
 * Servlet implementation class InsUpdateServlet1
 */
@WebServlet("/InsUpdateServlet1")
public class InsUpdateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		InsDaoImpl cur = new InsDaoImpl();
		List<Ins>list = cur.selectAllIns(no, null, false);
		System.out.println(list.get(0));
		
		request.setAttribute("p", list.get(0));
		request.getRequestDispatcher("/page/institution_update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
