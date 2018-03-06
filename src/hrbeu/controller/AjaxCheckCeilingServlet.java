package hrbeu.controller;

import hrbeu.dao.FengDingDaoImpl;
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
 * Servlet implementation class AjaxCheckCeilingServlet
 */
@WebServlet("/AjaxCheckCeilingServlet")
public class AjaxCheckCeilingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCheckCeilingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String patientKind = request.getParameter("patientKind");
		FengDingDaoImpl fddi = new FengDingDaoImpl();
		List<FengDing> list = fddi.query(null, patientKind);
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
