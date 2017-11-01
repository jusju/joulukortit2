package fi.softala.jee.demo.d18.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import fi.softala.jee.demo.d18.bean.Osoite;
import fi.softala.jee.demo.d18.dao.OsoiteDAO;

/**
 * Servlet implementation class KirjautumisServlet
 */
public class KirjautumisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public KirjautumisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kayttajatunnus = request.getParameter("kayttajatunnus");
		String salasana = request.getParameter("salasana");
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		OsoiteDAO dao = (OsoiteDAO) context.getBean("daoLuokka");
		ArrayList<Osoite> osoitteet = dao.haeKaikki();
		request.setAttribute("osoitteet", osoitteet);
		
		if(kayttajatunnus.equalsIgnoreCase("pauline") && salasana.equalsIgnoreCase("pauline")) {
			RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/nakymat/osoitteet.jsp");
			disp.forward(request, response);
		} else {
			RequestDispatcher disp = request.getRequestDispatcher("virhe.jsp");
			disp.forward(request, response);
		}
	}

}
