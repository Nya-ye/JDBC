package com.lanou.jdbcUtils;

import java.util.List;

public class TestJDBCUtils {

	public static void main(String[] args) throws Exception {
		
//		String sql = "update stu set isDelete = ? where name = ?";
//		JDBCUtils.update(sql, 0, "张三");
		
		String sql = "select stu_id id, name, sex, age, major, phone phone from stu where isDelete = ?"; //查询语句里的别名应与类的属性名相同
		List<Student> list = JDBCUtils.query(sql, Student.class, 1);
		for (Student s : list) {
			System.out.println(s);
		}
		
//		String sql = "select tno id, tname name, tsex sex from teacher where tno > ?";
//		Teacher t = JDBCUtils.queryOne(sql, Teacher.class, 825);
//		System.out.println(t);
		
	}

}
