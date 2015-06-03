/**
 * 
 */
$(document).ready(function() {

	$("#edit-names").click(function(){
		
		$("#user-detail-buttons").hide();
		
		$("#edit-name-buttons").show();
		
		$("#firstName").prop("disabled", false);
		
		$("#lastName").prop("disabled", false);
		
	});
	
	$("#cancel-edit-names").click(function(){
		
		$("#edit-name-buttons").hide();
		
		$("#user-detail-buttons").show();
		
		$("#firstName").prop("disabled", true);
		
		$("#lastName").prop("disabled", true);
		
	});
		
	$("#edit-email").click(function(){
		
		$("#user-detail-buttons").hide();
		
		$("#edit-email-buttons").show();
		
		$("#email").prop("disabled", false);
	});
	
	$("#cancel-edit-email").click(function(){
	
		$("#email").prop("disabled", true);

		$("#edit-email-buttons").hide();
		
		$("#user-detail-buttons").show();
		
	});
	
	$("#change-password").click(function(){
		
		$("#user-detail-buttons").hide();
		
		$("#change-password-buttons").show();
		
		$("#password").prop("disabled", false);
	
	});
	
	$("#cancel-change-password").click(function(){
		
		$("#password").prop("disabled", true);

		$("#change-password-buttons").hide();
		
		$("#user-detail-buttons").show();
		
	});
	
});
