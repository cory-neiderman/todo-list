package com.techelevator.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Task;

@Component
public class JDBCTaskDAO implements TaskDAO{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCTaskDAO(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public void add(Task task) {
		
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT nextval('task_task_id_seq')");
		results.next();
		int taskId = results.getInt(1);
		task.setTaskId(taskId);
		//user_id, creator_name, description, create_date, priority, due_date, is_completed
		String sqlInsertTask = "INSERT INTO task(task_id, user_id, creator_name, description, create_date, priority, due_date, is_completed) "+
				"VALUES(?,?,?,?,?,?,?, ?)";
		
		
		jdbcTemplate.update(sqlInsertTask, taskId, task.getUserId(), task.getNameOfCreator(), task.getDescription(), task.getDateCreated(), task.getPriority(), task.getDueDate(),  task.getIsCompleted());
		
		
	}

	@Override
	public List<Task> getTaskByUserId(int userId) {
		
		List<Task> taskListByUserId = new ArrayList<>();
		
		String sqlQueryForTaskByUserId = "SELECT * FROM task WHERE user_id=? ORDER BY priority, due_date, description";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQueryForTaskByUserId, userId);
		
		while(results.next()){
			Task task = new Task();
			task.setDescription(results.getString("description"));
			task.setTaskId(results.getInt("task_id"));
			task.setPriority(results.getInt("priority"));
			task.setDueDate(LocalDate.parse(results.getString("due_date")));
			task.setNameOfCreator(results.getString("creator_name"));
			task.setDateCreated(LocalDate.parse(results.getString("create_date")));
			task.setIsCompleted(Boolean.valueOf(results.getString("is_completed")));
			taskListByUserId.add(task);
		}
		
		return taskListByUserId;
	}

	@Override
	public void markTaskCompletedById(int taskId) {
		
		String sqlQueryUpdateIsCompleted = "UPDATE task SET is_completed ='true' WHERE task_id = ?";
		jdbcTemplate.update(sqlQueryUpdateIsCompleted, taskId);
	}

	@Override
	public void changeTaskPriority(int taskId, int newPriority) {
		
		String sqlQueryUpdatePriority = "UPDATE task SET priority = ? WHERE task_id = ?";
		jdbcTemplate.update(sqlQueryUpdatePriority, newPriority, taskId);
		
	}

	@Override
	public void changeDueDate(int taskId, String newDate) {
		
		
		
		String sqlQueryUpdateDueDate = "UPDATE task SET due_date = ? WHERE task_id = ?";
		jdbcTemplate.update(sqlQueryUpdateDueDate, LocalDate.parse(newDate), taskId);
		
	}

	@Override
	public void removeTaskByDueDate(int taskId) {
		
		String sqlDeleteTask = "DELETE FROM task WHERE task_id = ?";
		jdbcTemplate.update(sqlDeleteTask, taskId);
		
	}


}
