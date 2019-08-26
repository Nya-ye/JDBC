package com.lanou.jdbcUtils;

public class Student {
	private String id;
	private String name;
	private String sex;
	private int age;
	private String major;
	private String phone;
	
	public Student() {
		super();
	}
	public Student(String id, String name, String sex, int age, String major, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.major = major;
		this.phone = phone;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", major=" + major
				+ ", phone=" + phone + "]";
	}
	
	

}
