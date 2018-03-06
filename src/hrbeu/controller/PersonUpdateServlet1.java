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


@WebServlet("/PersonUpdateServlet1")
public class PersonUpdateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		PersonDaoImpl cur = new PersonDaoImpl();
		List<Person>list = cur.selectAllPerson(no, null);
		System.out.println(list.get(0));
		
		request.setAttribute("p", list.get(0));
		request.getRequestDispatcher("/page/person_update.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("bug in person update servlet1");
	}

}
