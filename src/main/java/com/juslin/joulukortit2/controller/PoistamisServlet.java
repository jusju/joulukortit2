package com.juslin.joulukortit2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.juslin.joulukortit2.bean.Osoite;
import com.juslin.joulukortit2.dao.OsoiteDAO;

/**
 * Servlet implementation class PoistamisServlet
 */
public class PoistamisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PoistamisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("id");
		System.out.println(id);
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		OsoiteDAO dao = (OsoiteDAO) context.getBean("daoLuokka");
		dao.poista(Integer.parseInt(id+""));
		
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
