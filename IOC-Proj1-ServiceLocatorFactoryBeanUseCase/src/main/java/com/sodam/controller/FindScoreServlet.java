package com.sodam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sodam.service.FindScoreService;

public class FindScoreServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5117297978069327411L;
	private ApplicationContext ctx;
	private FindScoreService service;

	@Override
	public void init() throws ServletException {
		ctx = new ClassPathXmlApplicationContext("/com/sodam/cfgs/applicationContext.xml");
		service = ctx.getBean("service", FindScoreService.class);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		String score = null;
		int matchId;
		matchId = Integer.parseInt(req.getParameter("mid"));
		try {
			score = service.findScore(matchId);
			req.setAttribute("scorecard", score);
			// forwarding result to view
			rd = req.getRequestDispatcher("/view_score.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
			// forwarind request to error page
			rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, resp);
		} // try
	}// doGet

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}// doPost

	@Override
	public void destroy() {
		// close ApplicationContext
		((AbstractApplicationContext) ctx).close();
	}// destroy

}
