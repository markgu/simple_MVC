package com.my.mvc.vo;

public class UserVO {

	private String userId;
	private String name;
	private String sex;
	private String address;
	private String favoriteFood;
	
	public UserVO(String userId, String name, String sex, String address, String favoriteFood) {
		super();
		this.userId = userId;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.favoriteFood = favoriteFood;
	}
	
	public UserVO(){
		
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFavoriteFood() {
		return favoriteFood;
	}
	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", name=" + name + ", sex=" + sex
				+ ", address=" + address + ", favoriteFood=" + favoriteFood
				+ "]";
	}
	
}
