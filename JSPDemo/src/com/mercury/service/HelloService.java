package com.mercury.service;

import com.mercury.beans.User;
import com.mercury.beans.UserInfo;
import com.mercury.dao.HelloDao;
import com.mercury.dao.impl.HelloDaoImpl;

public class HelloService {
private HelloDao hd;
	
	public HelloService(){
		if(hd==null){
			hd = new HelloDaoImpl();
		}
	}
	
	public String sayHello(User user){
		// for local variable, you can you stringbuilder or stringbuffer
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
		sb.append("<font color = blue>");
		sb.append("Hello " + user.getName() + " with age " + user.getAge() + ", welcome to JSP!");
		sb.append("</font>");
		sb.append("</body></html>");
		return sb.toString();
	}
	
	public String sayHello2(User user){
		return "Hello " + user.getName() + "(" +user.getAge() + "), welcome to JSP!";
	}
	
	public UserInfo process(User user){
		hd.save(user);
		UserInfo userInfo = new UserInfo();
		userInfo.setMsg(this.sayHello2(user));
		userInfo.setUsers(hd.queryAll());
		return userInfo;
	}
}
