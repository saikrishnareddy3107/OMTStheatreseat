package com.movie.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="theatre_info")
public class TheatreDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="THEATRE_ID",length=10)
	int theatre_Id;
	@Column(name="THEATRE_NAME",length=10)
	String theatre_Name;
	@Column(name="SCREEN_ID",length=7)
	String screen_Id;
	@Column(name="MANAGER_NAME",length=18)
	String manager_Name;
	@Column(name="CONTACT_INFORMATION",length=25)
	String contact_Information;
	

	public int getTheatre_Id() {
		return theatre_Id;
	}
	public void setTheatre_Id(int theatre_Id) {
		this.theatre_Id = theatre_Id;
	}
	public String getTheatre_Name() {
		return theatre_Name;
	}
	public void setTheatre_Name(String theatre_Name) {
		this.theatre_Name = theatre_Name;
	}
	public String getScreen_Id() {
		return screen_Id;
	}
	public void setScreen_Id(String screen_Id) {
		this.screen_Id = screen_Id;
	}
	public String getManager_Name() {
		return manager_Name;
	}
	public void setManager_Name(String manager_Name) {
		this.manager_Name = manager_Name;
	}
	public String getContact_Information() {
		return contact_Information;
	}
	public void setContact_Information(String contact_Information) {
		this.contact_Information = contact_Information;
	}


}