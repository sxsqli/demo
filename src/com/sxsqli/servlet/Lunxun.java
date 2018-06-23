package com.sxsqli.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxsqli.domain.User;
import com.sxsqli.service.Message;
import com.sxsqli.service.MessageSingleFactory;

/**
 * Servlet implementation class Lunxun
 */
public class Lunxun extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Message message = new MessageSingleFactory().getMessage();
		synchronized (message) {
			try {
				message.wait();
			} catch (InterruptedException e) {
				//ignore
			}
			@SuppressWarnings("unchecked")
			Set<User> onlineUsers = (Set<User>) getServletContext().getAttribute("onlineUsers");
			String json = "{onlineUsersSize:" + onlineUsers.size() + ",out:'" + message.getLast() + "'}";
			response.getWriter().println(json);
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
