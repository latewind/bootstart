package com.latewind.bootstart.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/helloServlet")
public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -929463785882423928L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		HttpSession session = req.getSession();
		System.out.println("===> request invoke getSession :" + session.getId());
		writer.print("Hello Servlet");
		resp.setContentType("text/html;charset=UTF-8");

	}

}
