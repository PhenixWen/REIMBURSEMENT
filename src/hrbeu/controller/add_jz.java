package hrbeu.controller;

import hrbeu.dao.HosRankDaoImpl;
import hrbeu.dao.JiuZhenDaoImpl;
import hrbeu.dao.PersonDaoImpl;
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
 * Servlet implementation class add_jz
 */
@WebServlet("/add_jz")
public class add_jz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String solveId = request.getParameter("solveId");
		String personId = request.getParameter("personId");
		String nianfen = "2017";
		String hosRankId = new HosRankDaoImpl().queryId(request.getParameter("hosRank"));
		String compId = request.getParameter("compId");
		String cureId = request.getParameter("cureId");
		String inDate = request.getParameter("inDate");
		String outDate = request.getParameter("outDate");
		String diseId = request.getParameter("diseId");
		String outReason = request.getParameter("outReason");
		String settlement = "未结算";
		JiuZhen jiuzhen = new JiuZhen(solveId, personId, nianfen, hosRankId, compId, cureId, inDate, outDate, diseId, outReason, settlement);
		JiuZhenDaoImpl jiuzhend = new JiuZhenDaoImpl();
		jiuzhend.insert(jiuzhen);
		//-----------------------------------------------------
		String page = request.getParameter("page");
		int pagenow =1;
		if(page != null){
			pagenow = Integer.parseInt(page);
		}
		PersonDaoImpl persond = new PersonDaoImpl();
		List<Person> persons = persond.selectAllPerson(personId, null);
		String personName = persons.get(0).getPersonName();
		List<JiuZhen> jiuzhens = jiuzhend.queryPage(null, personId, null, pagenow, null);
		int size = jiuzhens.size();
		if(size > 0) request.setAttribute("jiuzhens", jiuzhens);
		int total = jiuzhend.page(null, personId, null, null);
		int pages = total%5==0?total/5:total/5+1;
		request.setAttribute("pages", pages);
		request.setAttribute("pagenow", pagenow);
		request.setAttribute("personId", personId);
		request.setAttribute("personName", personName);
		request.getRequestDispatcher("/page/msg_jz.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
