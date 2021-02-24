package com.maven.web.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.maven.web.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<Map<String, String>> getUserList(Map<String,String> pUser) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		int cnt = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "jtest";
		String pwd = "ezen1234";
		String sql = "select ui_num, ui_name, ui_id, \r\n" + 
				"ui_pwd, ui_genre, ui_email, \r\n" + 
				"ui_phone1 || '-' || substr(ui_phone2, 1, 4) || '-' || substr(ui_phone2, 5, 4) phone, \r\n" + 
				"ui_address, \r\n" + 
				"to_char(to_date(credat),'yyyy-mm-dd') credat, \r\n" + 
				"to_char(to_date(cretim, 'hh24miss'),'hh24:mi:ss') cretim, \r\n" + 
				"to_char(to_date(moddat, 'yyyymmdd'), 'yyyy-mm-dd') moddat, \r\n" + 
				"to_char(to_date(modtim, 'hh24miss'), 'hh24:mi:ss') modtim\r\n" + 
				"from user_info where 1=1";
		if(pUser!=null) {
			if(pUser.get("ui_id") != null && !"".equals(pUser.get("ui_id"))) {
				sql += " and ui_id like '%' || ? || '%'";
				cnt++;
			}
			if(pUser.get("ui_name") != null && !"".equals(pUser.get("ui_name"))) {
				sql += " and ui_name like '%' || ? || '%'";
				cnt++;
			}
			if(pUser.get("ui_phone") != null && !"".equals(pUser.get("ui_phone"))) {
				sql += " and ui_phone1 || '-' || substr(ui_phone2, 1, 4) || '-' || substr(ui_phone2, 5, 4) like '%' || ? || '%'";
				cnt++;
			}
			if(pUser.get("ui_address") != null && !"".equals(pUser.get("ui_address"))) {
				sql += " and ui_address like '%' || ? || '%'";
				cnt++;
			}
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String,String>> userList = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, id , pwd);
			ps = con.prepareStatement(sql);
			if(pUser!=null) {
				if(pUser.get("ui_address") != null && !"".equals(pUser.get("ui_address"))) {
					ps.setString(cnt--, pUser.get("ui_address"));
				}
				if(pUser.get("ui_phone") != null && !"".equals(pUser.get("ui_phone"))) {
					ps.setString(cnt--, pUser.get("ui_phone"));
				}
				if(pUser.get("ui_name") != null && !"".equals(pUser.get("ui_name"))) {
					ps.setString(cnt--, pUser.get("ui_name"));
				}
				if(pUser.get("ui_id") != null && !"".equals(pUser.get("ui_id"))) {
					ps.setString(cnt--, pUser.get("ui_id"));
				}
			}
			rs = ps.executeQuery();
			while(rs.next()){
				Map<String,String> user = new HashMap<>();
				user.put("ui_num", rs.getString("ui_num"));
				user.put("ui_name", rs.getString("ui_name"));
				user.put("ui_id", rs.getString("ui_id"));
				user.put("ui_pwd", rs.getString("ui_pwd"));
				user.put("ui_genre", rs.getString("ui_genre"));
				user.put("phone", rs.getString("phone"));
				user.put("ui_email", rs.getString("ui_email"));
				user.put("ui_address", rs.getString("ui_address"));
				user.put("credat", rs.getString("credat"));
				user.put("cretim", rs.getString("cretim"));
				user.put("moddat", rs.getString("moddat"));
				user.put("modtim", rs.getString("modtim"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userList;
	}

}
