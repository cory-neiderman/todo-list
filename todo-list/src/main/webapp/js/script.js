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
		for(var i=0; i<taskList.length; i++){
			var task = taskList[i];
			var $listItem = $("<li></li>");
			var $taskLink = $("<a href='#'></a>")
								.text(task.isCompleted)
								.attr("data-taskId", task.taskId)
								.click(handleClick);
					
			
			
			$("#taskList").append("<tr><td>"+task.description+"</td><td>"+taskList[i].priority+
					"</td><td>"+taskList[i].dueDateAsString+"</td><td>"+task.isCompleted+"</td></tr>");
			
			$("#completedList").append($listItem.append($taskLink));
		}
	}
	function handleClick(event) {
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
	



					

	
});