package com.techelevator.model;

import java.util.List;

public interface TaskDAO {
	
	public void add(Task task);
	public List<Task> getTaskByUserId(int userId);
	public void markTaskCompletedById(int taskId);

}
