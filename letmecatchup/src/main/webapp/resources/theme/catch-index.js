/**
 * JS for catch jsps
 */
$(document).ready(function() {
	
	// BOOK 
	$("[id^='edit-catchbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchbook-form-" + suffix).show();
		$("#catchbook-" + suffix).hide();

	});

	$("[id^='canceledit-catchbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchbook-form-" + suffix).hide();
		$("#catchbook-" + suffix).show();

	});

	$("[id^='caught-catchbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchbook-form-" + suffix).show();
		$("#catchbook-" + suffix).hide();
		
		$("#catchbook-form-" + suffix + "-editbuttons").hide();
		$("#catchbook-form-" + suffix + "-caughtbuttons").show();
		
		$("#catchbook-form-" + suffix + "-rating").prop("disabled", false);

	});
	
	$("[id^='cancelcaught-catchbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchbook-form-" + suffix).hide();
		$("#catchbook-" + suffix).show();
		
		$("#catchbook-form-" + suffix + "-editbuttons").show();
		$("#catchbook-form-" + suffix + "-caughtbuttons").hide();
		
		$("#catchbook-form-" + suffix + "-rating").prop("disabled", true);

	});
	
	//MOVIE
	$("[id^='edit-catchmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchmovie-form-" + suffix).show();
		$("#catchmovie-" + suffix).hide();

	});

	$("[id^='canceledit-catchmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchmovie-form-" + suffix).hide();
		$("#catchmovie-" + suffix).show();

	});

	$("[id^='caught-catchmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchmovie-form-" + suffix).show();
		$("#catchmovie-" + suffix).hide();
		
		$("#catchmovie-form-" + suffix + "-editbuttons").hide();
		$("#catchmovie-form-" + suffix + "-caughtbuttons").show();
		
		$("#catchmovie-form-" + suffix + "-rating").prop("disabled", false);

	});
	
	$("[id^='cancelcaught-catchmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchmovie-form-" + suffix).hide();
		$("#catchmovie-" + suffix).show();
		
		$("#catchmovie-form-" + suffix + "-editbuttons").show();
		$("#catchmovie-form-" + suffix + "-caughtbuttons").hide();
		
		$("#catchmovie-form-" + suffix + "-rating").prop("disabled", true);

	});
	
});