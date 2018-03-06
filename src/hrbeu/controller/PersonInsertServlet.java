package hrbeu.controller;

import hrbeu.dao.AnnualMoneyDaoImpl;
import hrbeu.dao.PersonDaoImpl;
import hrbeu.entity.Person;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonInsertServlet
 */
@WebServlet("/PersonInsertServlet")
public class PersonInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cID = request.getParameter("cID");
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String patID = request.getParameter("patID");
		String InsID = request.getParameter("InsID");
		String compID = request.getParameter("compID");
		///
		Person curins = new Person();
		curins.setCertifiType(type);
		curins.setPersonName(name);
		curins.setCertifiID(cID);
		curins.setBirthday(birthday);
		curins.setPatID(patID);
		curins.setInsID(Integer.parseInt(InsID));
		curins.setPersonSex(sex);
		curins.setCompID(compID);
		///
		System.out.println("link to personINSERT SEVRLET" + curins.getBirthday());
		PersonDaoImpl cur = new PersonDaoImpl();
		cur.insertPerson(curins);
		///
		
		AnnualMoneyDaoImpl c = new AnnualMoneyDaoImpl();
		c.insertAM(null);
		
		request.getRequestDispatcher("/page/basical_people.jsp").forward(request, response);
	}

}
