package com.sxsqli.dao;

import java.util.HashSet;
import java.util.Set;

import com.sxsqli.domain.User;
import com.sxsqli.domain.UserFactory;

public class UserDao {
	private static Set<User> USERS;
	static {
		USERS = new HashSet<User>();
		USERS.add(new UserFactory().CreateUser("zhangsan", "23"));
		USERS.add(new UserFactory().CreateUser("lisi", "24"));
		USERS.add(new UserFactory().CreateUser("wangwu", "25"));
		USERS.add(new UserFactory().CreateUser("zhaoliu", "26"));
	}

	public User getUser(String username, String password) {
		for (User user : USERS) {
			if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}

	public Set<User> getUsers() {
		return USERS;
	}

}
