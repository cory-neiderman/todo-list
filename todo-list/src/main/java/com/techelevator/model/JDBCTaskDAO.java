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
		
		String sqlQueryForTaskByUserId = "SELECT * FROM task WHERE user_id=?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQueryForTaskByUserId, userId);
		
		while(results.next()){
			Task task = new Task();
			task.setDescription(results.getString("description"));
			task.setPriority(results.getInt("priority"));
			task.setDueDate(LocalDate.parse(results.getString("due_date")));
			task.setNameOfCreator(results.getString("creator_name"));
			task.setDateCreated(LocalDate.parse(results.getString("create_date")));
			taskListByUserId.add(task);
		}
		
		return taskListByUserId;
	}


}
