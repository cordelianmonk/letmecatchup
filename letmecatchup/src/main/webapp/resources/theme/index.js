/**
 * 
 */
$(document).ready(function() {

	$("#select-action").val('');

	$('#select-action').change(function() {
		if ($("#select-action").val() == "search") {
			$("#add-only-area").hide();
			$("#search-area").show();
			$("#search-mediatype").val("");
		} else if ($("#select-action").val() == "add") {
			$("#add-only-area").show();
			$("#add-status").val("");
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

	$("#search-mediatype").change(function() {
		if ($("#search-mediatype").val() == "book") {
			$("#search-area-form").show();
			$("#search-writer-area").show();
		} else if ( ($("#search-mediatype").val() == "movie") ) {
			$("#search-area-form").show();
			$("#search-writer-area").hide();
		} else {
			$("#search-area-form").hide();
		}

	});

	$("#search").click(function() {
		var title = $("#search-title").val();
		var writer = $("#search-writer").val();
		
		if ($("#search-mediatype").val() == "book"){
			searchBook(title, writer);
		}
		
		if ($("#search-mediatype").val() == "movie"){
			alert("FIGURE OUT THE MOVIE DATABASE YOU LAZY SOD");
		}
		
		$("#searched-catch").click(function(){
			generateCatchForm();
		} ) ;
		
	});

});

function searchBook(title, writer) {
	title = title.replace(/ /g, '+');

	if (writer.length > 0) {
		writer = writer.replace(/ /g, '+');
		title += "&author=" + writer;
	}
	;

	var url = "http://www.goodreads.com/book/title.xml?"
			+ "key=X4qHgEizBIWSv9v0v98WRQ&title=" + title;

	$
			.get(
					"http://query.yahooapis.com/v1/public/yql",
					{
						q : "select * from xml where url=\"" + url + "\"",
						format : "xml"
					},
					function(xml) {
						$("#image")
								.html(
										"<img src="
												+ xml
														.getElementsByTagName("image_url")[0].textContent
												+ ">");
						$("#creator")
								.html("<p>"+
										xml.getElementsByTagName("name")[0].textContent+"</p>");
						$("#link")
								.html(
										"<a href="
												+ xml
														.getElementsByTagName("url")[0].textContent
												+ ">See on Goodreads</a>");
						$("#searched-title")
								.html(
										xml.getElementsByTagName("title")[0].textContent);
						$("#searched-apikey")
						.html(
								xml.getElementsByTagName("id")[0].textContent);
						$("#searched-rating")
								.html(xml
														.getElementsByTagName("average_rating")[0].textContent
												+ " out of 5 stars");
						$("#searched-description")
								.html("<i>Description from GoodReads:</i><br/><br/>" + 
										xml.getElementsByTagName("description")[0].textContent);
						$("#reviews")
								.html(
										xml
												.getElementsByTagName("reviews_widget")[0].textContent);
						$("#goodreads-widget")[0].style.width = "100%";
						$("#goodreads-widget")[0].style.height = "350px";
						$("#the_iframe")[0].width = "100%";
						$("#the_iframe")[0].height = "400";
						$("#info-area").show(); // VERY IMPORRANT
					});
}

function searchMovie(title){
}

function generateCatchForm(){
	
	 $("#searched-form").html('<form action="addCatchMedia" method="post">' +
	'<input hidden name="mediatype" value="' + $("#search-mediatype").val() + '"></input>' +
	'<input hidden name="title" value="' + $("#searched-title").text()  + '"></input>' +
	'<input hidden name="apiID" + value= "' + $("#searched-apikey").text() + '"></input>' +
	'<textarea rows="5" cols="20" maxlength="300" placeholder="(300 characters or less)" name="comment"></textarea>' +
	'<button type="submit" class="btn btn-sm btn-primary" >Submit</button>' +
	'</form>'
	);
	
}
