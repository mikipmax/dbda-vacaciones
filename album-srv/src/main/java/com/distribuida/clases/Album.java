package com.distribuida.clases;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Album implements Serializable{


	private static final long serialVersionUID = 1L;

	private int id;
	private int singerId;
	private String title;
	private Date releaseDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSingerId() {
		return singerId;
	}
	public void setSingerId(int singerId) {
		this.singerId = singerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
}
