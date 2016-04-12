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
		console.log("test2");
		for(var i = 0; i < taskList.length; i++) {
			
					
			$("#taskList").append($listItem.append(taskList.description));
		}
	}
	
	
	
	
	
	
});