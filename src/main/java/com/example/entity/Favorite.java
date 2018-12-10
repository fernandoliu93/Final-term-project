package com.example.entity;

public class Favorite {

	int id;
	int userId;
	String teamName;

	public Favorite(int id, int userId, String teamName) {
		super();
		this.id = id;
		this.userId = userId;
		this.teamName = teamName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


}
