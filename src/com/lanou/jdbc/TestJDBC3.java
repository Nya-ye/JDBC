package com.lanou.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 加载驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/zzj191703?useSSL=false&serverTimezone=UTC";
		// 连接数据库
		try (Connection con = DriverManager.getConnection(url, "root", "root");) {
			System.out.println(con);
			
			Statement stmt = con.createStatement();
//			String sql = "update stu set isDelete = 1 where stu_id = 'ZZJ190703-15'";
//			String sql = "update stu set sex = '男' where name = '李光'";
//			String sql = "insert into stu values('zzj190703-45', '张三', '男', 25, '艺术设计', 15103864967, 0)";
//			String sql = "delete from stu where name = '张三'";
//			String sql = "select * from stu where name = '李光'";
			String sql = "select * from stu where isDelete = 0 and stu_id > 'ZZJ190703-15'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("name");
				String age = rs.getString("age");
				System.out.println(name + " " + age);
			}
			
//			int s = stmt.executeUpdate(sql);
//			System.out.println(s);
		}
	}

}
