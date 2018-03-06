package hrbeu.controller;

import hrbeu.dao.PersonDaoImpl;
import hrbeu.entity.Person;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxCheckRealPersonID
 */
@WebServlet("/AjaxCheckRealPersonID")
public class AjaxCheckRealPersonID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("into check real person");
		String no = request.getParameter("no");
		PrintWriter out = response.getWriter();
		if(no.equals("")){
			out.write("no"); 
			return;
		}
		///
		PersonDaoImpl a = new PersonDaoImpl();
		List<Person> list = a.selectAllPerson(no, null);
		///
		if(list.isEmpty()){
			out.write("no");
		}
		else{
			out.write(list.get(0).getPersonName());
		}
		///
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
