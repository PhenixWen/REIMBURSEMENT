package hrbeu.controller;

import hrbeu.dao.PersonDaoImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonDeleteServlet
 */
@WebServlet("/PersonDeleteServlet")
public class PersonDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("into get");
		String no = request.getParameter("no");
		PersonDaoImpl cur = new PersonDaoImpl();
		
		try {
			cur.deletePerson(Integer.parseInt(no));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.write("no");
			out.flush();
			out.close();
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BUGGGGGGGG into post");
		doGet(request, response);
	}

}
