package com.lanou.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lanou.jdbcUtils.Student;

public class TestJDBC4 {

	public static void main(String[] args) throws Exception {

//		update();
		query();
	}
	
	public static void update() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/zzj191703?useSSL=false&serverTimezone=UTC";
		
//		String sql = "insert into stu values(?,?,?,?,?,?,?)";
//		try(Connection con = DriverManager.getConnection(url, "root", "root");
//				PreparedStatement ps = con.prepareStatement(sql);){
//			ps.setString(1, "ZZJ190703-45");
//			ps.setString(2, "张三");
//			ps.setString(3, "男");
//			ps.setInt(4, 25);
//			ps.setString(5, "艺术设计");
//			ps.setString(6, "15103864967");
//			ps.setInt(7, 0);
//			ps.executeUpdate();
//		}
		
		String sql = "update stu set isDelete = ? where name = ?";
		try (Connection con = DriverManager.getConnection(url, "root", "root");
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, 1);
			ps.setString(2, "张三");
			ps.executeUpdate();
		}
	}
	
	public static void query() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/zzj191703";
		String sql = "select * from stu where isDelete = ?";
		try (Connection con = DriverManager.getConnection(url, "root", "root");
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setObject(1, 0);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("stu_id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				int age = rs.getInt("age");
				String major = rs.getString("major");
				String phone = rs.getString("phone");
				Student stu = new Student(id, name, sex, age, major, phone);
				System.out.println(stu);
			}
		}
	}

}
