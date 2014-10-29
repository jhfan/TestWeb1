package com.mercury.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mercury.beans.User;
import com.mercury.dao.HelloDao;
import com.mercury.util.JdbcUtil;

import java.sql.*;

import oracle.jdbc.OracleTypes;

public class HelloDaoImpl implements HelloDao {
	private JdbcUtil util;
	// don't put connection here, it will become a stateful statement
	// so put it in function is better
	public HelloDaoImpl() {
		if (util==null){
			util = new JdbcUtil();
		}
	}
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		String sp="{?=call saveuser(?,?)}";
		try{
			Connection conn=JdbcUtil.getConnection();
			CallableStatement cs=conn.prepareCall(sp);
			cs.registerOutParameter(1,Types.INTEGER);
			cs.setString(2, user.getName());
			cs.setInt(3,user.getAge());
			cs.execute();
			cs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		String sp="{?=call queryuser()}";
		List<User> list=new ArrayList<User>();
		try{
			Connection conn=JdbcUtil.getConnection();
			CallableStatement cs=conn.prepareCall(sp);
			cs.registerOutParameter(1,OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs=(ResultSet)cs.getObject(1);
			while(rs.next()){
				User user=new User();
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				list.add(user);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		try {
			Connection conn = JdbcUtil.getConnection();
			//String sp = "{?=call saveUser(?,?)}";
			String sql = "update sample set age = ? where name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getAge());
			ps.setString(2, user.getName());
			ResultSet rs = ps.executeQuery();
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		try {
			Connection conn = JdbcUtil.getConnection();
			//String sp = "{?=call saveUser(?,?)}";
			String sql = "delete sample where name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ResultSet rs = ps.executeQuery();
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}

	@Override
	public User findByName(String name) {
		User user = new User();
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql = "select * from sample where name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			user.setName(rs.getString("name"));
			user.setAge(rs.getInt("age"));
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
