$(document).ready(function () {
	
	 
	var applicationURL = "http://localhost:8080/todo-list/editTask";
	
	$.ajax({
    	url : applicationURL+"/edit", 
        type: "GET",
        dataType: "json"
    }).success(function (result) {  
        populateTaskList(result);
    }).fail(function(xhr, status, errorMessage){
        console.log(errorMessage);
        console.log(status);
        console.log(xhr);
        console.log("test");
    });
	
	function populateTaskList(taskList) {
		
		$("#taskList").empty();
		$("#completedList").empty();
		$headerRow = $("<tr></tr>").append("<th>Task</th>").append("<th>Priority</th>").append("<th>Due Date</th>").append("<th>Is Task Completed?</th>");
		$("#taskList").append($headerRow);
		for(var i=0; i<taskList.length; i++){
			
			var task = taskList[i];
			
			var $tableItem=$("<td></td>");
			
			var $isCompletedLink = $("<a href='#'></a>")
										.text(task.isCompleted)
										.attr("data-taskId", task.taskId)
										.click(changeCompleted);
			
			var $priorityLink = $("<a href='#'></a>")
										.text(task.priority)
										.attr("data-taskId", task.taskId)
										.click(changePriority);
			
			var $descriptionLink = $("<a href='#'></a>")
									.text(task.description)
									.attr("data-taskId", task.taskId)
									.click(changeDescription);
			
			var $dueDateLink = $("<a href='#'></a>")
										.text(task.dueDateAsString)
										.attr("data-taskId", task.taskId)
										.click(changeDueDate);
			var $removeTask = $("<a href='#'></a>")
										.text("remove")
										.attr("data-taskId", task.taskId)
										.click(removeTask);
			
			$taskRow = $("<tr></tr>");
			
			$priorityColumn=$("<td></td>").text(task.priority);
			$descriptionColumn=$("<td></td>").text(task.description);
			$dueDateColumn=$("<td></td").text(task.dueDateAsString);
			$completedColumn=$("<td></td>").append($isCompletedLink);
			
			$taskRow.append($("<td></td>").append($descriptionLink))
					.append($("<td></td>").append($priorityLink))
					.append($("<td></td>").append($dueDateLink))
					.append($("<td></td>").append($isCompletedLink))
					.append($("<td></td>").append($removeTask));
			$("#taskList").append($taskRow);
			
			
		}
	}
	function changeCompleted(event) {
		
		
	    var r = confirm("Did you really finish?  Don't lie!");
	    if(r==true){
			var taskId = $(this).attr("data-taskId");
	
			$.ajax({
				url : applicationURL+"/edit/"+taskId,
				type : "POST",
				dataType : "json"
			}).success(function(result) {
				populateTaskList(result);
			}).fail(function(xhr, status, errorMessage) {
				console.log(errorMessage);
				console.log(status);
				console.log(xhr);
			});
	    }
	}
	
	function changePriority(event){
		
		var taskId = $(this).attr("data-taskId");
		var newPriority = prompt("Enter the new priority");

		
		
		$.ajax({
			url : applicationURL+"/edit/"+taskId+"/1/"+newPriority,
			type : "POST",
			dataType : "json"
		}).success(function(result) {
			populateTaskList(result);
		}).fail(function(xhr, status, errorMessage) {
			console.log(errorMessage);
			console.log(status);
			console.log(xhr);
		});
	}
	
function changeDescription(event){
		
	}
function changeDueDate(event){
	
	var taskId = $(this).attr("data-taskId");
	var newDate = prompt("Enter the new due date");
	
	$.ajax({
		url : applicationURL+"/edit/"+taskId+"/2/"+newDate,
		type : "POST",
		dataType : "json"
	}).success(function(result) {
		populateTaskList(result);
	}).fail(function(xhr, status, errorMessage) {
		console.log(errorMessage);
		console.log(status);
		console.log(xhr);
	});
	
}

function removeTask(event){
	
	var taskId = $(this).attr("data-taskId");
	
	$.ajax({
		url : applicationURL+"/remove/"+taskId,
		type : "POST",
		dataType : "json"
	}).success(function(result) {
		populateTaskList(result);
	}).fail(function(xhr, status, errorMessage) {
		console.log(errorMessage);
		console.log(status);
		console.log(xhr);
	});
	
}



					

	
});