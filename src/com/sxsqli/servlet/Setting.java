package com.sxsqli.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxsqli.domain.User;

/**
 * Servlet implementation class Setting
 */
public class Setting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String introduction = request.getParameter("introduction");
		if (introduction == null || introduction.isEmpty()) {
			response.getWriter().println("<h1>请输入介绍</h1>");
			response.getWriter().println("<a href='setting.jsp'>返回</a>");
		} else {
			((User) request.getSession().getAttribute("user")).setIntroduction(introduction);
			response.getWriter().println("<h1>修改成功</h1>");
			response.getWriter().println("<a href='index.jsp'>返回首页</a>");
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
