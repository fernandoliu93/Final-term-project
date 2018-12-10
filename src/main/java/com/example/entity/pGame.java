package com.example.entity;

public class pGame {

	int id;
	String host;
	String guest;
	String time;
	String result;
	
	public pGame(int id, String host, String guest, String time,String result) {
		super();
		this.id = id;
		this.host = host;
		this.guest = guest;
		this.time = time;
		this.result = result;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
