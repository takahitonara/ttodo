package com.takahitonara.ttodo;



public class Task {
	
	private Integer id;
	private String title;
	private String description;
	private Integer status;
	private String startTime;
	private String endTime;

	public Task(Integer id, String title, String description, Integer status,
			String startTime, String endTime) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}
