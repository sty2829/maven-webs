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

import com.maven.web.dao.TheaterDAO;

public class TheaterDAOImpl implements TheaterDAO {

	@Override
	public List<Map<String, String>> getTheaterList(Map<String,String> pti) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "jtest";
		String pwd = "ezen1234";
		String sql = "select * from theater_info where 1=1";
		int cnt = 0;
		if(pti!=null) {
			if(pti.get("ti_name") != null && !"".equals(pti.get("ti_name"))) {
				sql += " and ti_name like '%' || ? || '%'";
				cnt++;
			}
			if(pti.get("ti_address") != null && !"".equals(pti.get("ti_address"))) {
				sql += " and ti_address like '%' || ? || '%'";
				cnt++;
			}
		}

		sql += " order by ti_num";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String,String>> theaterList = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);
			if(pti!=null) {
				if(pti.get("ti_address") != null && !"".equals(pti.get("ti_address"))) {
					ps.setString(cnt--, pti.get("ti_address"));
				}
				if(pti.get("ti_name") != null && !"".equals(pti.get("ti_name"))) {
					ps.setString(cnt--, pti.get("ti_name"));
				}
			}
			rs = ps.executeQuery();
			while(rs.next()){
				Map<String,String> theater = new HashMap<>();
				theater.put("ti_num", rs.getString("ti_num"));
				theater.put("ti_name", rs.getString("ti_name"));
				theater.put("ti_address", rs.getString("ti_address"));
				theater.put("ti_phone1", rs.getString("ti_phone1"));
				theater.put("ti_phone2", rs.getString("ti_phone2"));
				
				theaterList.add(theater);
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

		return theaterList;
	}

}
