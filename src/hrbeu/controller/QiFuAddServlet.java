package hrbeu.controller;

import hrbeu.dao.FenDuanDaoImpl;
import hrbeu.dao.QiFuDaoImpl;
import hrbeu.entity.FenDuan;
import hrbeu.entity.QiFu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QiFuAddServlet
 */
@WebServlet("/QiFuAddServlet")
public class QiFuAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QiFuAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cureKind = request.getParameter("cureKind");
		String patientKind = request.getParameter("patientKind");
		String hosRank = request.getParameter("hosRank");
		String stdS = request.getParameter("std");
		double std = Double.parseDouble(stdS);
		QiFu q = new QiFu(null, cureKind, patientKind, hosRank, std);
		//System.out.println(j);
		QiFuDaoImpl qfdi = new QiFuDaoImpl();
		qfdi.add(q);
		request.getRequestDispatcher("/page/qifuquery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
