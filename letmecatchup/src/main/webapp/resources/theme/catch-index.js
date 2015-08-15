/**
 * JS for catch jsps
 */
$(document).ready(function() {
	
	//PANEL FUNCTIONS
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
	
	//BUTTON FUNCTIONS
	$("[id^='edit-catch']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catch-form-" + suffix).show();
		
		
		$("#catch-" + suffix +"-panelheadtitle").hide();
		$("#catch-" + suffix +"-comment").hide();
		
		$("#edit-caught-catch-"+suffix ).hide();
	});

	$("[id^='canceledit-catch']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catch-form-" + suffix).hide();
		$("#catch-" + suffix +"-panelheadtitle").show();
		$("#catch-" + suffix +"-comment").show();
		
		$("#edit-caught-catch-"+suffix ).show();

	});
	
	$("[id^='show-delete-catch']").click(function() {
		var suffix = this.id.split("-")[3];
		$("#catch-form-" + suffix + "-deletebuttons").show();
		$("#catch-form-" + suffix + "-editbuttons").hide();
	});
	
	
	$("[id^='canceldelete-catch']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catch-form-" + suffix + "-deletebuttons").hide();
		$("#catch-form-" + suffix + "-editbuttons").show();

	});

	$("[id^='caught-catch']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catch-form-" + suffix).show();
		
		$("#catch-" + suffix +"-panelheadtitle").hide();
		$("#catch-" + suffix +"-comment").hide();
		
		$("#catch-form-" + suffix + "-editbuttons").hide();
		$("#catch-form-" + suffix + "-caughtbuttons").show();
		
		$("#catch-form-" + suffix + "-rating").prop("disabled", false);
		
		$(function () { 
			$('#catch-form-star-rating-' + suffix).rateit( { max: 10, step: 1, backingfld: "#catch-form-" + suffix + "-rating" } ); 
		});
		
		$("#edit-caught-catch-"+suffix ).hide();

	});
	
	$("[id^='cancelcaught-catch']").click(function() {

		var suffix = this.id.split("-")[2];
		$("#catch-form-" + suffix).hide();
		
		$("#catch-" + suffix +"-panelheadtitle").show();
		$("#catch-" + suffix +"-comment").show();
		
		$("#catch-form-" + suffix + "-editbuttons").show();
		$("#catch-form-" + suffix + "-caughtbuttons").hide();
		
		$("#catch-form-" + suffix + "-rating").prop("disabled", true);

		$("#edit-caught-catch-"+suffix ).show();
	});
	
});