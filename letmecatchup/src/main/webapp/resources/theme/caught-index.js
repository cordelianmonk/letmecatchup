/**
 * 
 */
$(document).ready(function() {
	
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
			$("#" + shortID ).removeClass("animated fadeIn");
			$("#" + shortID ).hide();
			$("#" + id  ).css("border-bottom-right-radius", "10px");
			$("#" + id  ).css("border-bottom-left-radius", "10px");
		    $(this).data('clicked', false);	    
		} else {
			$("#" + id  ).css("background-color", "#49A7D5");
			$("#" + id  ).css("border-bottom-right-radius", "0px");
			$("#" + id  ).css("border-bottom-left-radius", "0px");
			$("#" + shortID ).show();
			$("#" + shortID ).addClass("animated fadeIn");
			$(this).data('clicked', true);
		}
		
	});

	$("[id^='edit-caught']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#caught-form-" + suffix).show();

		$("#caught-" + suffix + "-panelheadtitle").hide();
		$("#caught-" + suffix + "-comment").hide();

		var rating = +$("#caught-set-rating-" + suffix).val();
		$("#caught-form-" + suffix + "-rating").prop("disabled", false);
		$("#caught-form-" + suffix + "-rating").val(rating);

		$(function() {
			$('#caught-form-edit-star-rating-' + suffix).rateit({
				max : 10,
				step : 1,
				backingfld : "#caught-form-" + suffix + "-rating",
				value : rating
			});
		});

		$("#edit-caught-button-" + suffix).hide();
	});

	$("[id^='canceledit-caught']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#caught-form-" + suffix).hide();

		$("#caught-" + suffix + "-panelheadtitle").show();
		$("#caught-" + suffix + "-comment").show();
		$("#caught-" + suffix + "-rating").show();

		$("#edit-caught-button-" + suffix).show();

	});

	$("[id^='show-delete-caught']").click(function() {

		var suffix = this.id.split("-")[3];
		$("#caught-form-" + suffix + "-deletebuttons").show();
		$("#caught-form-" + suffix + "-editbuttons").hide();

	});

	$("[id^='canceldelete-caught']").click(function() {
		var suffix = this.id.split("-")[2];
		$("#caught-form-" + suffix + "-deletebuttons").hide();
		$("#caught-form-" + suffix + "-editbuttons").show();
	});

	// MOVIE
//	$("[id^='edit-caughtmovie']").click(function() {
//
//		var suffix = this.id.split("-")[2];
//		$("#caughtmovie-form-" + suffix).show();
//
//		$("#caughtmovie-" + suffix + "-panelheadtitle").hide();
//		$("#caughtmovie-" + suffix + "-comment").hide();
//		$("#caughtmovie-" + suffix + "-rating").hide();
//
//		var rating = +$("#caughtmovie-set-rating-" + suffix).val();
//		$("#caughtmovie-form-" + suffix + "-rating").prop("disabled", false);
//		$("#caughtmovie-form-" + suffix + "-rating").val(rating);
//		
//		$(function () { 
//			$('#caughtmovie-edit-star-rating-' + suffix).rateit( 
//					{ max: 10, 
//						step: 1, 
//						backingfld: "#caughtmovie-form-" + suffix + "-rating",
//						value: rating
//						} ); 
//		});
//
//
//		$("#edit-caughtmovie-button-" + suffix).hide();
//
//	});
//
//	$("[id^='canceledit-caughtmovie']").click(function() {
//
//		var suffix = this.id.split("-")[2];
//		$("#caughtmovie-form-" + suffix).hide();
//
//		$("#caughtmovie-" + suffix + "-panelheadtitle").show();
//		$("#caughtmovie-" + suffix + "-comment").show();
//		$("#caughtmovie-" + suffix + "-rating").show();
//
//		$("#edit-caughtmovie-button-" + suffix).show();
//
//	});
//
//	$("[id^='show-delete-caughtmovie']").click(function() {
//
//		var suffix = this.id.split("-")[3];
//		$("#caughtmovie-form-" + suffix + "-deletebuttons").show();
//		$("#caughtmovie-form-" + suffix + "-editbuttons").hide();
//
//	});
//
//	$("[id^='canceldelete-caughtmovie']").click(function() {
//		var suffix = this.id.split("-")[2];
//		$("#caughtmovie-form-" + suffix + "-deletebuttons").hide();
//		$("#caughtmovie-form-" + suffix + "-editbuttons").show();
//	});

});
