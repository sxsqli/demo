package com.sxsqli.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sxsqli.domain.User;

/**
 * Application Lifecycle Listener implementation class OnlineCount
 *
 */
public class InitOnlineUsers implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public InitOnlineUsers() {
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		Set<User> onlineUsers = new HashSet<User>();
		sce.getServletContext().setAttribute("onlineUsers", onlineUsers);
	}

}
