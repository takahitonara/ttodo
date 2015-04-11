package com.takahitonara.ttodo;

import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.thymeleaf.util.StringUtils;

@Entity
@Table(name = "task")
public class TaskEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String description;
	private Integer status;
	
	@Convert(converter = LocalDateTimePersistenceConverter.class)
	private LocalDateTime startDateTime;

	@Convert(converter = LocalDateTimePersistenceConverter.class)
	private LocalDateTime endDateTime;
	
	public TaskEntity() {
		super();
	}

	public TaskEntity(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	// for debug
	public String toString() {
		return "[title:" + title + ", description:" + description
				+ ", status: " + StringUtils.toString(status)
				+ ", startDateTime: " + StringUtils.toString(startDateTime)
				+ ", endDateTime: " + StringUtils.toString(endDateTime) + "]";
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

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

}
