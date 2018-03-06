package hrbeu.controller;

import hrbeu.dao.CureKindDaoImpl;
import hrbeu.dao.FeeKindDaoImpl;
import hrbeu.entity.CureKind;
import hrbeu.entity.FeeKind;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class AjaxCureKindServlet
 */
@WebServlet("/AjaxCureKindServlet")
public class AjaxCureKindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCureKindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CureKindDaoImpl ckdi = new CureKindDaoImpl();
		List<CureKind> list = ckdi.queryAll();
		JSONArray jsonarray = JSONArray.fromObject(list);
		//System.out.println(jsonarray.toString());
		PrintWriter out = response.getWriter();
		out.write(jsonarray.toString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
