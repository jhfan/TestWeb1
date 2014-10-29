package com.mercury.beans;

import java.util.List;

public class UserInfo {
	private String msg;
	private List<User> users;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
