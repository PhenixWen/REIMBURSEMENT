package hrbeu.controller;

import hrbeu.dao.YaoPinDaoImpl;
import hrbeu.entity.YaoPin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YaoPinAddServlet
 */
@WebServlet("/YaoPinAddServlet")
public class YaoPinAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YaoPinAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mediId = request.getParameter("mediId");
		String mediName = request.getParameter("mediName");
		String hosRank = request.getParameter("hosRank");
		String feeKind = request.getParameter("feeKind");
		String ceilingPri = request.getParameter("ceilingPri");
		String chargeRank = request.getParameter("chargeRank");
		String drugCertificate = request.getParameter("drugCertificate");
		String useFrequency = request.getParameter("useFrequency");
		String useMethod = request.getParameter("useMethod");
		String place = request.getParameter("place");
		String dayy = request.getParameter("dayy");
		String remarks = request.getParameter("remarks");
		String factorName = request.getParameter("factorName");
		String examine = request.getParameter("examine");
		double ceiling;
		if(ceilingPri != null && !ceilingPri.isEmpty())
			ceiling = Double.parseDouble(ceilingPri);
		else
			ceiling = -1;
		Integer day = null;
		if(dayy != null && !dayy.isEmpty())
			day = Integer.parseInt(dayy);
		YaoPin y = new YaoPin(mediId, mediName, feeKind,
				chargeRank, ceiling, hosRank,
				factorName, drugCertificate, remarks,
				useFrequency, useMethod, place, day, examine);
		YaoPinDaoImpl ydpi = new YaoPinDaoImpl();
		ydpi.add(y);
		request.getRequestDispatcher("/page/yaopinquery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
