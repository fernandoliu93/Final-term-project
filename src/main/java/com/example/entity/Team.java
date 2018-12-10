package com.example.entity;

public class Team {

	int id;
	String cname;
	int win;
	int loss;
	String location;
	String info;
	String logo;
	String name;
	
	public Team(int id, String cname, int win, int loss, String location,String info,String logo,String name) {
		super();
		this.id = id;
		this.cname = cname;
		this.win = win;
		this.loss = loss;
		this.location = location;
		this.info = info;
		this.logo = logo;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLoss() {
		return loss;
	}

	public void setLoss(int loss) {
		this.loss = loss;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
