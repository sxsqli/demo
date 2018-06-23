package com.sxsqli.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxsqli.domain.User;
import com.sxsqli.service.Message;
import com.sxsqli.service.MessageSingleFactory;

/**
 * Servlet implementation class Chat
 */
public class Chat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String in = request.getParameter("in");
		Message message = new MessageSingleFactory().getMessage();
		message.send((User) request.getSession().getAttribute("user"), in);
		synchronized (message) {
			message.notifyAll();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
