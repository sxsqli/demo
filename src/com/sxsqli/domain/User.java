package com.sxsqli.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements Serializable, HttpSessionActivationListener {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private Timestamp registerTime;
	private String photoPath;
	private String introduction;

	protected User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.registerTime = new Timestamp(0);
		this.photoPath = "";
		this.introduction = "";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "{username:" + username + ", password:" + password + ", registerTime:" + registerTime + ", photo:"
				+ photoPath + ", introduction:" + introduction + "}";
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		@SuppressWarnings("unchecked")
		Set<User> onlineUsers = (Set<User>) se.getSession().getServletContext().getAttribute("onlineUsers");
		onlineUsers.add(this);
		System.out.println(onlineUsers);
	}

}
