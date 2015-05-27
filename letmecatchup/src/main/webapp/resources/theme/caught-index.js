/**
 * 
 */
$(document).ready(function() {
	// BOOK
	$("[id^='edit-caughtbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#caughtbook-form-" + suffix).show();
		$("#caughtbook-" + suffix).hide();

		var rating = +$("#caughtbook-set-rating-" + suffix).val();
		$("#caughtbook-form-" + suffix + "-rating").prop("disabled", false);
		$("#caughtbook-form-" + suffix + "-rating").val(rating);

	});

	$("[id^='canceledit-caughtbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#caughtbook-form-" + suffix).hide();
		$("#caughtbook-" + suffix).show();

	});
	
	$("[id^='show-delete-caughtbook']").click(function(){
		
		var suffix = this.id.split("-")[3];
		$("#caughtbook-form-"+ suffix +"-deletebuttons").show();
		$("#caughtbook-form-" + suffix + "-editbuttons").hide();
		
	});
	
	$("[id^='canceldelete-caughtbook']").click(function() {
		var suffix = this.id.split("-")[2];
		$("#caughtbook-form-"+ suffix +"-deletebuttons").hide();
		$("#caughtbook-form-" + suffix + "-editbuttons").show();
	});

	// MOVIE
	$("[id^='edit-caughtmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#caughtmovie-form-" + suffix).show();
		$("#caughtmovie-" + suffix).hide();

		var rating = +$("#caughtmovie-set-rating-" + suffix).val();
		$("#caughtmovie-form-" + suffix + "-rating").prop("disabled", false);
		$("#caughtmovie-form-" + suffix + "-rating").val(rating);

	});

	$("[id^='canceledit-caughtmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#caughtmovie-form-" + suffix).hide();
		$("#caughtmovie-" + suffix).show();

	});
	
$("[id^='show-delete-caughtmovie']").click(function(){
		
		var suffix = this.id.split("-")[3];
		$("#caughtmovie-form-"+ suffix +"-deletebuttons").show();
		$("#caughtmovie-form-" + suffix + "-editbuttons").hide();
		
	});
	
	$("[id^='canceldelete-caughtmovie']").click(function() {
		var suffix = this.id.split("-")[2];
		$("#caughtmovie-form-"+ suffix +"-deletebuttons").hide();
		$("#caughtmovie-form-" + suffix + "-editbuttons").show();
	});

});