package fi.softala.jee.demo.d18.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fi.softala.jee.demo.d18.bean.Osoite;
import fi.softala.jee.demo.d18.dao.OsoiteDAO;

/**
 * Servlet implementation class OsoitteenTallennusServlet
 */
public class OsoitteenTallennusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OsoitteenTallennusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		OsoiteDAO dao = (OsoiteDAO) context.getBean("daoLuokka");


		String nimi = request.getParameter("nimi");
		String katuosoite = request.getParameter("katuosoite");
		String postinumero = request.getParameter("postinumero");
		String postitoimipaikka = request.getParameter("postitoimipaikka");
		String osavaltio = request.getParameter("osavaltio");
		String maa = request.getParameter("maa");
		Osoite osoite = new Osoite();
		osoite.setNimi(nimi);
		osoite.setKatuosoite(katuosoite);
		osoite.setPostinumero(postinumero);
		osoite.setPostitoimipaikka(postitoimipaikka);
		osoite.setOsavaltio(osavaltio);
		osoite.setMaa(maa);
		
		dao.talleta(osoite);
		
		ArrayList<Osoite> osoitteet = dao.haeKaikki();
		request.setAttribute("osoitteet", osoitteet);
		
		
		RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/nakymat/osoitteet.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
