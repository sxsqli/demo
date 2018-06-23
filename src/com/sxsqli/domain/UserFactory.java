package com.sxsqli.domain;

import java.sql.Timestamp;
import java.util.Date;

public class UserFactory {
	private final String DEFAULT_PHOTO_PATH = "img/photo/动物-013.gif";
	public User CreateUser(String username, String password) {
		User user = new User(username, password);
		user.setRegisterTime(new Timestamp(new Date().getTime()));
		user.setPhotoPath(DEFAULT_PHOTO_PATH);
		user.setIntroduction("这个用户很懒，什么也没留下");
		return user;
	}

	public User CreateUser(String username, String password, String photoPath) {
		User user = new User(username, password);
		user.setRegisterTime(new Timestamp(new Date().getTime()));
		user.setPhotoPath(photoPath);
		user.setIntroduction("这个用户很懒，什么也没留下");
		return null;
	}

	public User CreateUser(String username, String password, String photoPath, String introduction) {
		User user = new User(username, password);
		user.setRegisterTime(new Timestamp(new Date().getTime()));
		user.setPhotoPath(photoPath);
		user.setIntroduction(introduction);
		return null;
	}
}
