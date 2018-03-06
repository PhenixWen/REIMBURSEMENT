package hrbeu.controller;

import hrbeu.dao.PersonDaoImpl;
import hrbeu.entity.Person;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






@WebServlet("/PersonQueryServlet")
public class PersonQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		String page = request.getParameter("page");
		
		int curpage = 1;
		if(page != null){
			curpage = Integer.parseInt(page);
		}
		
		PersonDaoImpl cur = new PersonDaoImpl();
		List<Person> aa = cur.selectAllPerson(pid, pname);
		
		int allnum = aa.size();
		allnum = allnum%5==0? allnum/5 : allnum/5 + 1;
		
		List<Person> persons = cur.selectPagePerson(pid, pname, curpage);

		request.setAttribute("pages", allnum);
		request.setAttribute("curpage", curpage);
		
		request.setAttribute("personlist", persons);
		request.getRequestDispatcher("/page/basical_people.jsp").forward(request, response);
		//重定向
	}

}
