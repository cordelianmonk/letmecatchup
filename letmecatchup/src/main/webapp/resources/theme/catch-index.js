/**
 * JS for catch jsps
 */
$(document).ready(function() {
	
	$(".panel-heading" ).hover(function(){
		   
    	if ( $(this).data("clicked") ){
    		$("#" + this.id ).css("background-color", "#FF8F63");
    	} else {
    		$("#" + this.id ).css("background-color", "#FFA987");
    	}
}
    	
   , function(){
	
	if ( $(this).data("clicked") ){
		$("#" + this.id  ).css("background-color", "#FF8F63");
	} else {
		$("#" + this.id ).css("background-color", "#F5F5F5");
	}
	
}); 
	
	$("[id*='panelheadtitle']").click(function() {
		
		var id = this.id; 
		var shortID = id.substring(0, id.lastIndexOf("-") );
		shortID = shortID + "-panel-body";
		
		if(jQuery( "#"+id ).data('clicked') ) {
			$("#" + id  ).css("background-color", "#FFA987");
			$("#" + shortID ).removeClass("animated fadeIn");
			$("#" + shortID ).hide();
			$("#" + id  ).css("border-bottom-right-radius", "10px");
			$("#" + id  ).css("border-bottom-left-radius", "10px");
		    $(this).data('clicked', false);	    
		} else {
			$("#" + id  ).css("background-color", "#FF8F63");
			$("#" + id  ).css("border-bottom-right-radius", "0px");
			$("#" + id  ).css("border-bottom-left-radius", "0px");
			$("#" + shortID ).show();
			$("#" + shortID ).addClass("animated fadeIn");
			$(this).data('clicked', true);
		}
		
	});
	
	//BOOK
	$("[id^='edit-catchbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchbook-form-" + suffix).show();
		
		
		$("#catchbook-" + suffix +"-panelheadtitle").hide();
		$("#catchbook-" + suffix +"-comment").hide();
		
		$("#edit-caught-catchbook-"+suffix ).hide();
	});

	$("[id^='canceledit-catchbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchbook-form-" + suffix).hide();
		$("#catchbook-" + suffix +"-panelheadtitle").show();
		$("#catchbook-" + suffix +"-comment").show();
		
		$("#edit-caught-catchbook-"+suffix ).show();

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
		
		$("#catchbook-" + suffix +"-panelheadtitle").hide();
		$("#catchbook-" + suffix +"-comment").hide();
		
		$("#catchbook-form-" + suffix + "-editbuttons").hide();
		$("#catchbook-form-" + suffix + "-caughtbuttons").show();
		
		$("#catchbook-form-" + suffix + "-rating").prop("disabled", false);
		
		$(function () { 
			$('#catchbook-form-star-rating-' + suffix).rateit( { max: 10, step: 1, backingfld: "#catchbook-form-" + suffix + "-rating" } ); 
		});
		
		$("#edit-caught-catchbook-"+suffix ).hide();

	});
	
	$("[id^='cancelcaught-catchbook']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchbook-form-" + suffix).hide();
		
		$("#catchbook-" + suffix +"-panelheadtitle").show();
		$("#catchbook-" + suffix +"-comment").show();
		
		$("#catchbook-form-" + suffix + "-editbuttons").show();
		$("#catchbook-form-" + suffix + "-caughtbuttons").hide();
		
		$("#catchbook-form-" + suffix + "-rating").prop("disabled", true);

		$("#edit-caught-catchbook-"+suffix ).show();
	});
	
	//MOVIE
	$("[id^='edit-catchmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchmovie-form-" + suffix).show();
		
		$("#catchmovie-" + suffix +"-panelheadtitle").hide();
		$("#catchmovie-" + suffix +"-comment").hide();
		
		$("#edit-caught-catchmovie-"+suffix ).hide();

	});

	$("[id^='canceledit-catchmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchmovie-form-" + suffix).hide();
		
		$("#catchmovie-" + suffix +"-panelheadtitle").show();
		$("#catchmovie-" + suffix +"-comment").show();
		
		$("#edit-caught-catchmovie-"+suffix ).show();

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
		
		$("#catchmovie-" + suffix +"-panelheadtitle").hide();
		$("#catchmovie-" + suffix +"-comment").hide();
		
		$("#catchmovie-form-" + suffix + "-editbuttons").hide();
		$("#catchmovie-form-" + suffix + "-caughtbuttons").show();
		
		$("#edit-caught-catchmovie-"+suffix ).hide();
		$("#catchmovie-form-" + suffix + "-rating").prop("disabled", false);
		
		$(function () { 
			$('#catchmovie-form-star-rating-' + suffix).rateit( 
					{ max: 10, 
						step: 1, 
						backingfld: "#catchmovie-form-" + suffix + "-rating" 
						} ); 
		});

	});
	
	$("[id^='cancelcaught-catchmovie']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catchmovie-form-" + suffix).hide();
		
		$("#catchmovie-" + suffix +"-panelheadtitle").show();
		$("#catchmovie-" + suffix +"-comment").show();
		
		$("#catchmovie-form-" + suffix + "-editbuttons").show();
		$("#catchmovie-form-" + suffix + "-caughtbuttons").hide();
		
		$("#catchmovie-form-" + suffix + "-rating").prop("disabled", true);
		
		$("#edit-caught-catchmovie-"+suffix ).show();

	});
	
});