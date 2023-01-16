package com.racing.model.vo;

public class User {
	private int uNo;
	private String id;
	private String password;
	private String name;

	public User() {
		super();
	}

	public User(int uNo, String id, String password, String name) {
		super();
		this.uNo = uNo;
		this.id = id;
		this.password = password;
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [uNo=" + uNo + ", id=" + id + ", password=" + password + ", name=" + name + "]";
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}