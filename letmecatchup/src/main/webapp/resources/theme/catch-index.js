/**
 * JS for catch jsps
 */
$(document).ready(function() {
	
	// BOOK 
	$("[id^='edit-catchbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchbook-form-" + suffix).show();
		$("#catchbook-" + suffix).hide();
		$("#caught-catchbook-"+suffix ).prop("class", "btn btn-sm btn-primary disabled");
	});

	$("[id^='canceledit-catchbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchbook-form-" + suffix).hide();
		$("#catchbook-" + suffix).show();
		$("#caught-catchbook-"+suffix ).prop("class", "btn btn-sm btn-primary");

	});
	
	$("[id^='show-delete-catchbook']").click(function() {
		var suffix = this.id.split("-")[3];
		$("#catchbook-form-" + suffix + "-deletebuttons").show();
		$("#catchbook-form-" + suffix + "-editbuttons").hide();
		
		
	});
	
	
	$("[id^='canceldelete-catchbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchbook-form-" + suffix + "-deletebuttons").hide();
		$("#catchbook-form-" + suffix + "-editbuttons").show();

	});

	$("[id^='caught-catchbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchbook-form-" + suffix).show();
		$("#catchbook-" + suffix).hide();
		
		$("#catchbook-form-" + suffix + "-editbuttons").hide();
		$("#catchbook-form-" + suffix + "-caughtbuttons").show();
		
		$("#catchbook-form-" + suffix + "-rating").prop("disabled", false);
		
		$("#edit-catchbook-"+suffix ).prop("class", "btn btn-sm btn-primary disabled");

	});
	
	$("[id^='cancelcaught-catchbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchbook-form-" + suffix).hide();
		$("#catchbook-" + suffix).show();
		
		$("#catchbook-form-" + suffix + "-editbuttons").show();
		$("#catchbook-form-" + suffix + "-caughtbuttons").hide();
		
		$("#catchbook-form-" + suffix + "-rating").prop("disabled", true);

		$("#edit-catchbook-"+suffix ).prop("class", "btn btn-sm btn-primary");
	});
	
	//MOVIE
	$("[id^='edit-catchmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchmovie-form-" + suffix).show();
		$("#catchmovie-" + suffix).hide();
		
		$("#caught-catchmovie-"+suffix ).prop("class", "btn btn-sm btn-primary disabled");

	});

	$("[id^='canceledit-catchmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchmovie-form-" + suffix).hide();
		$("#catchmovie-" + suffix).show();
		
		$("#caught-catchmovie-"+suffix ).prop("class", "btn btn-sm btn-primary");

	});
	
	$("[id^='show-delete-catchmovie']").click(function() {
		var suffix = this.id.split("-")[3];
		
		$("#catchmovie-form-" + suffix + "-editbuttons").hide();
		$("#catchmovie-form-" + suffix + "-deletebuttons").show();
		
	});
	
	
	$("[id^='canceldelete-catchmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchmovie-form-" + suffix + "-deletebuttons").hide();
		$("#catchmovie-form-" + suffix + "-editbuttons").show();

	});

	$("[id^='caught-catchmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchmovie-form-" + suffix).show();
		$("#catchmovie-" + suffix).hide();
		
		$("#catchmovie-form-" + suffix + "-editbuttons").hide();
		$("#catchmovie-form-" + suffix + "-caughtbuttons").show();
		
		$("#catchmovie-form-" + suffix + "-rating").prop("disabled", false);
		
		$("#edit-catchmovie-"+suffix ).prop("class", "btn btn-sm btn-primary disabled");

	});
	
	$("[id^='cancelcaught-catchmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchmovie-form-" + suffix).hide();
		$("#catchmovie-" + suffix).show();
		
		$("#catchmovie-form-" + suffix + "-editbuttons").show();
		$("#catchmovie-form-" + suffix + "-caughtbuttons").hide();
		
		$("#catchmovie-form-" + suffix + "-rating").prop("disabled", true);
		
		$("#edit-catchmovie-"+suffix ).prop("class", "btn btn-sm btn-primary");

	});
	
});