package com.ssafy.hello.model;

import java.util.Arrays;

public class MultiDto {
	private String userId;
	private String userName;
	private String[] fruit;

	public String getUserid() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String[] getFruit() {
		return fruit;
	}

	public void setFruit(String[] fruit) {
		this.fruit = fruit;
	}

	@Override
	public String toString() {
		return "MultiDto [userId=" + userId + ", userName=" + userName + ", fruit=" + Arrays.toString(fruit) + "]";
	}



}
