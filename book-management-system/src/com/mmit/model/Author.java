package com.mmit.model;

import java.time.LocalDate;

public class Author {

	private int id;
	private String name;
	private LocalDate birthday;
	private String nativeTown;
	private User created_by;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getNativeTown() {
		return nativeTown;
	}
	public void setNativeTown(String nativeTown) {
		this.nativeTown = nativeTown;
	}
	public User getCreated_by() {
		return created_by;
	}
	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}
	
	public String getEntryBy() {
		return this.created_by.getUserName();
	}
	
	
}
