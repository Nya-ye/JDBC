package com.lanou.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 最底层的java连接数据库方式
 * @author Nya
 * @version 2019年8月23日 下午9:00:32
 */
public class TestJDBC {

	public static void main(String[] args) throws SQLException {
		//要使用数据库，需要完成以下几个事情
		//1.连接数据库
		//mysql - u root -p
		//数据的ip地址，端口等等
		//在java代码里面，各个数据库厂商实现了sun定义的数据接口
		//因此每个厂商都定义了一套连接协议
		//导入mysql提供的jar包
		Driver driver = new com.mysql.cj.jdbc.Driver();
		//url里包含如下信息：
			//协议：jdbc:mysql   ----mysql数据库
				//jdbc:oracle:thin	----oracle数据库
				//jdbc:sqlserver  ----sql server数据库
			//ip地址：localhost
			//端口号： mysql（3306）  oracle（1521） sqlserver(1433)
			//数据库名:zzj191703
		//用户名
		//密码
		String url = "jdbc:mysql://localhost:3306/zzj191703?useSSL=false&serverTimezone=UTC";
		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "root");
		Connection con = driver.connect(url,info);
		System.out.println(con);
		//2.使用数据库
		//3.断开数据库连接
	}

}
