$(document).ready(function () {
	
		$("form").validate({
			
			rules : {
				userName : {
					required : true
				},
				password : {
					required : true,
					minlength: 10,
					maxlength: 128,
					complexPassword: true,
					noMoreThan2Duplicates: true
					
				},
				confirmPassword : {
					required : true,		
					equalTo : "#password"  
				}
			},
			messages : {			
				confirmPassword : {
					equalTo : "Passwords do not match"
				}
			},
			errorClass : "error"
		},$.validator.addMethod("complexPassword", function(value){

			var rulesPassed = 0;

			var containsUppercase = /[A-Z]/.test(value);
			if(containsUppercase){
				rulesPassed++;
			}
			var containsLowercase = /[a-z]/.test(value);
			if(containsLowercase){
				rulesPassed++;
			}
			var containsNumber = /[0-9]/.test(value);
			if(containsNumber){
				rulesPassed++;
			}
			var containsSpecialChar =/[^A-Za-z0-9]/.test(value);
			if(containsSpecialChar){
				rulesPassed++;
			}


			if(rulesPassed>=3){
				return true;
			}
			else
				return false;


			}, "Password is not complex enough."),
			$.validator.addMethod("noMoreThan2Duplicates", function(value){

			for(var i=0; i<value.length-2; i++){
				if(value.charAt(i)==value.charAt(i+1)&&
					value.charAt(i)==value.charAt(i+2)){
					return false;

				}
			}
			return true;

			}, "Password contains too many duplicate letters"));
		
	});



