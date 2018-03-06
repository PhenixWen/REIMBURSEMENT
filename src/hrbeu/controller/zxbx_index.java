package hrbeu.controller;

import hrbeu.dao.AnnualMoneyDaoImpl;
import hrbeu.dao.FengDingDaoImpl;
import hrbeu.dao.JiuZhenDaoImpl;
import hrbeu.dao.PatientKindDaoImpl;
import hrbeu.dao.PersonDaoImpl;
import hrbeu.entity.AnnualMoney;
import hrbeu.entity.JiuZhen;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class zxbx_index
 */
@WebServlet("/zxbx_index")
public class zxbx_index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personId = request.getParameter("personId");
		String personName= request.getParameter("personName");
		
		
		String page = request.getParameter("page");
		int pagenow =1;
		if(page != null){
			pagenow = Integer.parseInt(page);
		}
		AnnualMoneyDaoImpl amd = new AnnualMoneyDaoImpl();
		List<AnnualMoney> ams = amd.selectPageAM(personId, personName, "2017", pagenow);
		List<AnnualMoney> ams2 = amd.selectAllAM(personId, personName, "2017");
		int total = ams2.size();
		int pages = total%5==0?total/5:total/5+1;
		if(ams.size() > 0){
			for(AnnualMoney am : ams){
				String per = String.valueOf(am.getPersonID());
				List<JiuZhen> jiuzhens = new JiuZhenDaoImpl().query(null, per, null, null);
				if(jiuzhens.size() == 0) am.setDone("尚无记录");
				else {
					boolean done = true;
					for(JiuZhen jiuzhen : jiuzhens){
						if(jiuzhen.getSettlement().equals("未结算")){
							done = false;
							break;
						}
					}
					if(done) am.setDone("结算完毕");
					else am.setDone("未结算完毕");
				}
				int ID = am.getPersonID();
				String personID = String.valueOf(ID);
				String patientId = new PersonDaoImpl().selectAllPerson(personID, null).get(0).getPatID();
				String patientKind = new PatientKindDaoImpl().queryKind(patientId);
				double fd = (double)(new FengDingDaoImpl().query(null, patientKind).get(0).getCeiling());
				am.setFd(fd);
			}
			request.setAttribute("ams", ams);			
		}
		request.setAttribute("pages", pages);
		request.setAttribute("pagenow", pagenow);
		request.getRequestDispatcher("/page/zxbx_index.jsp").forward(request,response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
