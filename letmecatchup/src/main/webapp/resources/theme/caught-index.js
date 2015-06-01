/**
 * 
 */
$(document).ready(function() {
	// BOOK
	$(".panel-heading" ).hover(function(){
		   
    	if ( $(this).data("clicked") ){
    		$("#" + this.id ).css("background-color", "#49A7D5");
    	} else {
    		$("#" + this.id ).css("background-color", "#73BDE1");
    	}
}
    	
   , function(){
	
	if ( $(this).data("clicked") ){
		$("#" + this.id  ).css("background-color", "#49A7D5");
	} else {
		$("#" + this.id ).css("background-color", "#F5F5F5");
	}
	
}); 
	
	$("[id*='panelheadtitle']").click(function() {
		
		var id = this.id; 
		var shortID = id.substring(0, id.lastIndexOf("-") );
		shortID = shortID + "-panel-body";
		
		if(jQuery( "#"+id ).data('clicked') ) {
			$("#" + id  ).css("background-color", "#73BDE1");
			$("#" + shortID ).hide();
		    $(this).data('clicked', false);	    
		} else {
			$("#" + id  ).css("background-color", "#49A7D5");
			$("#" + shortID ).show();
			$(this).data('clicked', true);
		}
		
	});

	$("[id^='edit-caughtbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#caughtbook-form-" + suffix).show();

		$("#caughtbook-" + suffix + "-panelheadtitle").hide();
		$("#caughtbook-" + suffix + "-comment").hide();
		

		var rating = +$("#caughtbook-set-rating-" + suffix).val();
		$("#caughtbook-form-" + suffix + "-rating").prop("disabled", false);

		$(function() {
			$('#caughtbook-form-edit-star-rating-' + suffix).rateit({
				max : 10,
				step : 1,
				backingfld : "#caughtbook-form-" + suffix + "-rating",
				value : rating
			});
		});

		$("#edit-caughtbook-button-" + suffix).hide();
	});

	$("[id^='canceledit-caughtbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#caughtbook-form-" + suffix).hide();

		$("#caughtbook-" + suffix + "-panelheadtitle").show();
		$("#caughtbook-" + suffix + "-comment").show();
		$("#caughtbook-" + suffix + "-rating").show();

		$("#edit-caughtbook-button-" + suffix).show();

	});

	$("[id^='show-delete-caughtbook']").click(function() {

		var suffix = this.id.split("-")[3];
		$("#caughtbook-form-" + suffix + "-deletebuttons").show();
		$("#caughtbook-form-" + suffix + "-editbuttons").hide();

	});

	$("[id^='canceldelete-caughtbook']").click(function() {
		var suffix = this.id.split("-")[2];
		$("#caughtbook-form-" + suffix + "-deletebuttons").hide();
		$("#caughtbook-form-" + suffix + "-editbuttons").show();
	});

	// MOVIE
	$("[id^='edit-caughtmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#caughtmovie-form-" + suffix).show();

		$("#caughtmovie-" + suffix + "-panelheadtitle").hide();
		$("#caughtmovie-" + suffix + "-comment").hide();
		$("#caughtmovie-" + suffix + "-rating").hide();

		var rating = +$("#caughtmovie-set-rating-" + suffix).val();
		$("#caughtmovie-form-" + suffix + "-rating").prop("disabled", false);
		$("#caughtmovie-form-" + suffix + "-rating").val(rating);
		
		$(function () { 
			$('#caughtmovie-edit-star-rating-' + suffix).rateit( 
					{ max: 10, 
						step: 1, 
						backingfld: "#caughtmovie-form-" + suffix + "-rating",
						value: rating
						} ); 
		});


		$("#edit-caughtmovie-button-" + suffix).hide();

	});

	$("[id^='canceledit-caughtmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#caughtmovie-form-" + suffix).hide();

		$("#caughtmovie-" + suffix + "-panelheadtitle").show();
		$("#caughtmovie-" + suffix + "-comment").show();
		$("#caughtmovie-" + suffix + "-rating").show();

		$("#edit-caughtmovie-button-" + suffix).show();

	});

	$("[id^='show-delete-caughtmovie']").click(function() {

		var suffix = this.id.split("-")[3];
		$("#caughtmovie-form-" + suffix + "-deletebuttons").show();
		$("#caughtmovie-form-" + suffix + "-editbuttons").hide();

	});

	$("[id^='canceldelete-caughtmovie']").click(function() {
		var suffix = this.id.split("-")[2];
		$("#caughtmovie-form-" + suffix + "-deletebuttons").hide();
		$("#caughtmovie-form-" + suffix + "-editbuttons").show();
	});

});
