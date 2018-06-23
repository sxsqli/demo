package com.sxsqli.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxsqli.dao.UserDao;
import com.sxsqli.domain.User;

/**
 * Servlet implementation class CheckForm
 */
public class CheckForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new UserDao().getUser(username, password);
		if (user != null) {
			@SuppressWarnings("unchecked")
			Set<User> onlineUsers = (Set<User>) getServletContext().getAttribute("onlineUsers");
			if (onlineUsers.add(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.getWriter().println("<h1>登陆成功，<span id='time'>2</span>秒后返回</h1>");
			} else {
				response.getWriter().println("<h1>此用户已在线，<span id='time'>2</span>秒后返回</h1>");
			}
		} else {
			response.getWriter().println("<h1>登陆失败，<span id='time'>2</span>秒后返回</h1>");
		}
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
