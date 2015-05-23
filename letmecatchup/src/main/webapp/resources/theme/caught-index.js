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

});