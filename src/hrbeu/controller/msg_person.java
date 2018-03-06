package hrbeu.controller;

import hrbeu.dao.AnnualMoneyDaoImpl;
import hrbeu.dao.InsDaoImpl;
import hrbeu.dao.JiuZhenDaoImpl;
import hrbeu.dao.PatientKindDaoImpl;
import hrbeu.dao.PersonDaoImpl;
import hrbeu.entity.AnnualMoney;
import hrbeu.entity.JiuZhen;
import hrbeu.entity.Person;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class msg_person
 */
@WebServlet("/msg_person")
public class msg_person extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personId = request.getParameter("personId");
		AnnualMoneyDaoImpl amd = new AnnualMoneyDaoImpl();
		List<AnnualMoney> ams = amd.selectAllAM(personId, null, "2017");
		AnnualMoney am = ams.get(0);
		request.setAttribute("a", am);
		String patientId = new PersonDaoImpl().selectAllPerson(personId, null).get(0).getPatID();
		String patientKind = new PatientKindDaoImpl().queryKind(patientId);
		Person person = new PersonDaoImpl().selectAllPerson(personId, null).get(0);
	    int insId = person.getInsID();
	    String insName = new InsDaoImpl().selectAllIns(String.valueOf(insId), null, false).get(0).getInsName();
	    List<JiuZhen> jiuzhens = new JiuZhenDaoImpl().query(null, personId, null, null);
	    String last_date = "0", last_dise = "0", last_reason = "0";
	    for(JiuZhen jiuzhen : jiuzhens){
	    	String date = jiuzhen.getOutDate();
	    	if(date != null && date != "" && date.compareTo(last_date) >= 0){
	    		last_date = date;
	    		last_dise = jiuzhen.getDiseName();
	    		last_reason = jiuzhen.getOutReason();
	    	}
	    }
	    request.setAttribute("last_date", last_date);
	    request.setAttribute("last_dise", last_dise);
	    request.setAttribute("last_reason", last_reason);
	    request.setAttribute("patientKind", patientKind);
	    request.setAttribute("insName", insName);
		request.getRequestDispatcher("/page/msg_person.jsp").forward(request,response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
