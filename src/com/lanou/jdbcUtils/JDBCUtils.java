package com.lanou.jdbcUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
/**
 * 通用JDBC工具类
 * @author Nya
 * @version 2019年8月23日 下午5:03:38
 */
public class JDBCUtils {
	private static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/zzj191703?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	/**
	 * 通用增删改
	 * @param sql
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public static int update(String sql, Object...parameters) throws Exception {
		Class.forName(DRIVERNAME);
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = con.prepareStatement(sql);) {
			for (int i = 0; i < parameters.length; i++) {
				ps.setObject(i + 1, parameters[i]);
			}
			ps.executeUpdate();
		}
		return 0;
	}
	
	/**
	 * 通用查询
	 * @param sql
	 * @param clazz
	 * @param parameters
	 * @return
	 * @throws Exception 
	 */
	public static <T> List<T> query(String sql, Class<T> clazz, Object...parameters) throws Exception {
		List<T> list = new ArrayList<T>();
		Class.forName(DRIVERNAME);
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = con.prepareStatement(sql);) {
			for (int i = 0; i < parameters.length; i++) {
				ps.setObject(i + 1, parameters[i]);
			}
			ResultSet rs = ps.executeQuery();
			//获取结果集元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				T t = clazz.newInstance();
				for (int i = 1; i <= columnCount; i++) {
					//读取列名
					String columName = rsmd.getColumnLabel(i);
					//通过反射获取与列名相同的java类的属性
					Field field = clazz.getDeclaredField(columName);
					field.setAccessible(true);
					field.set(t, rs.getObject(i));
				}
				list.add(t);
			}
		}
		return list;
	}
	
	public static <T> T queryOne(String sql,Class<T> clazz ,Object...parameters) throws Exception{
		List<T> list = query(sql,clazz,parameters);
		return list.size() == 0 ? null : list.get(0);
	}
	
}
