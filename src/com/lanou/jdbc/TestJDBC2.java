package com.lanou.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC2 {

	public static void main(String[] args) throws SQLException {
		
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		String url = "jdbc:mysql://localhost:3306/zzj191703?useSSL=false&serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "root", "root");
		System.out.println(con);
	
	}

}
