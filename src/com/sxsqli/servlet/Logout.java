package com.sxsqli.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxsqli.domain.User;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		Set<User> onlineUsers = (Set<User>) getServletContext().getAttribute("onlineUsers");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		onlineUsers.remove(user);
		session.invalidate();
		response.getWriter().println("<h1>注销成功，<span id='time'>2</span>秒后返回</h1>");
		response.setHeader("Refresh", "2;index.jsp");
		response.getWriter().println("<script type='text/javascript' src='js/main.js'></script>");
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
