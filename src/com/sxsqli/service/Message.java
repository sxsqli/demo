package com.sxsqli.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sxsqli.domain.User;

public class Message {
	private List<String> message;

	public Message() {
		super();
		this.message = new ArrayList<String>();
	}

	public void send(User user, String message) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd hh:mm:ss");
		String time = simpleDateFormat.format(new Date());
		this.message.add(user.getUsername() + "(" + time + ")£º" + message);
	}

	public String getLast() {
		if (message.size() > 0) {
			return message.get(message.size() - 1);
		}
		return "";
	}

	public List<String> allMessage() {
		return message;
	}
}
