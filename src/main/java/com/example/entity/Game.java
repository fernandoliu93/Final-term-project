package com.example.entity;

public class Game {

	int id;
	String host;
	String guest;
	String time;
	
	public Game(int id, String host, String guest, String time) {
		super();
		this.id = id;
		this.host = host;
		this.guest = guest;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
