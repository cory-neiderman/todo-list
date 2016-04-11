package com.techelevator.model;

import java.time.LocalDate;

public class Task {
	
	int priority;
	int taskId;
	int userId;
	String nameOfCreator;
	String description;
	boolean isCompleted;
	LocalDate dateCreated;
	LocalDate dueDate;
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNameOfCreator() {
		return nameOfCreator;
	}
	public void setNameOfCreator(String nameOfCreator) {
		this.nameOfCreator = nameOfCreator;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	
	public String getDateCreatedAsString(){
		return dateCreated.toString();
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	public String getDueDateAsString(){
		return dueDate.toString();
	}
	
	
	
	
}
