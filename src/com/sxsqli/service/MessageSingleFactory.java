package com.sxsqli.service;

public class MessageSingleFactory {
	private static Message message;
	static {
		message = new Message();
	}

	public Message getMessage() {
		return message;
	}
}
