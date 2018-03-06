package hrbeu.controller;

import hrbeu.dao.FenDuanDaoImpl;
import hrbeu.dao.FengDingDaoImpl;
import hrbeu.entity.FenDuan;
import hrbeu.entity.FengDing;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxCheckSegServlet
 */
@WebServlet("/AjaxCheckSegServlet")
public class AjaxCheckSegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCheckSegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String patientKind = request.getParameter("patientKind");
		String hosRank = request.getParameter("hosRank");
		String cureKind =  request.getParameter("cureKind");
//		System.out.println(cureKind);
//		System.out.println(patientKind);
//		System.out.println(hosRank);
		FenDuanDaoImpl fddi = new FenDuanDaoImpl();
		List<FenDuan> list = fddi.query(null, cureKind, patientKind, hosRank);
		PrintWriter out = response.getWriter();
		if(list.size() != 0)
			out.write("no");
		else
			out.write("yes");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
