/**
 * 
 */
$(document).ready(function() {
	$("#select-action").val('');
	$('#select-action').change(function() {
		if ($("#select-action").val() == "search") {
			$("#add-only-area").hide();
			$("#search-area").show();
		} else if ($("#select-action").val() == "add") {
			$("#add-only-area").show();
			$("#search-area").hide();
		} else {
			$("#add-only-area").hide();
			$("#search-area").hide();
		}
	});

	$('#add-status').change(function() {
		if ($("#add-status").val() == "catch") {
			$("#add-caught-form").hide();
			$("#add-catch-form").show();
		} else if ($("#add-status").val() == "caught") {
			$("#add-catch-form").hide();
			$("#add-caught-form").show();
		} else {
			$("#add-catch-form").hide();
			$("#add-caught-form").hide();
		}

	});

});
