/**
 * 
 */
$(document).ready(function() {

	// SEARCH AREA FUNCTIONS
	$("#select-action").val('');

	$('#select-action').change(function() {
		$("#search-title").val('');
		$("#search-writer").val('');
		
		if ($("#select-action").val() == "search") {

			$("#add-only-area").hide();

			$("#search-area").show();
			$("#search-mediatype").val("");

			$("#info-area").hide();

		} else if ($("#select-action").val() == "add") {
			$("#add-only-area").show();
			$("#add-status").val("");

			$("#search-area").hide();

			$("#info-area").hide();

		} else {
			$("#add-only-area").hide();

			$("#search-area").hide();

			$("#info-area").hide();
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
		
		$("#search-title").val('');
		$("#search-writer").val('');
		
		if ($("#search-mediatype").val() == "book") {

			$("#search-area-form").show();
			$("#search-writer-area").show();

			$("#info-area").hide();

		} else if ( $("#search-mediatype").val() == "movie" || $("#search-mediatype").val() == "series" ) {
			$("#search-area-form").show();
			$("#search-writer-area").hide();

			$("#info-area").hide();

		} else {
			$("#search-area-form").hide();

			$("#info-area").hide();
		}

	});

	$("#search").click(function() {
		
		$("#searched-title").html('');
		$("#searched-description").html('');
		$("#creator").html('');
		$("#link").html('');
		$("#image").html('');
		$("#reviews").html('');
		$("#searched-form").empty();
		$("#searched-catch").show();
		$("#searched-caught").show();
		
		$("#info-area").hide();
		
		var title = $("#search-title").val();
		var writer = $("#search-writer").val();
		

		if ($("#search-mediatype").val() == "book") {
			searchBook(title, writer);
		}

		if ($("#search-mediatype").val() == "movie") {
			searchMovie(title);
		}

	});

	$("#searched-catch").click(function() {
		generateCatchForm();
		$("#searched-caught").hide();
	});

	$("#searched-caught").click(function() {
		generateCaughtForm();
		$("#searched-catch").hide();
	});

});

function searchBook(title, writer) {
	title = title.replace(/ /g, '+');

	if (writer.length > 0) {
		var writerArray = writer.split( " " );
		writer = "";
		
		$.each( writerArray, function(index, value){
			value = value.charAt(0).toUpperCase() + value.substring(1);
			writer=writer + value + "+";
		});
		
		writer = writer.substring(0, writer.length - 1 );
		
		title += "&author=" + writer;
		
	}

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

						if (xml.getElementsByTagName("error")[0] == undefined) {
							$("#image")
									.html(
											"<img class='center-block' src="
													+ xml
															.getElementsByTagName("image_url")[0].textContent
													+ ">");
							$("#creator")
									.html(
											"<p><b>Written by: </b>"
													+ xml
															.getElementsByTagName("name")[0].textContent
													+ "</p>");
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
									.rateit(
											"value",
											xml
													.getElementsByTagName("average_rating")[0].textContent);
							$("#searched-rating").rateit("max", 5);
							$("#searched-description")
									.html(
											xml
													.getElementsByTagName("description")[0].textContent);
							$("#reviews")
									.html(
											xml
													.getElementsByTagName("reviews_widget")[0].textContent);
							$("#goodreads-widget")[0].style.width = "100%";
							$("#goodreads-widget")[0].style.height = "450px";
							$("#the_iframe")[0].style.width = "100%";
							$("#the_iframe")[0].style.height = "450px";
							$("#info-area").show(); // VERY IMPORRANT
						} else {
							alert("No book found!");
						}

					});
}

function searchMovie(title) {

	$.ajax({
		method : "GET",
		url : "http://api.themoviedb.org/3/search/movie",
		contentType : 'application/json',
		dataType : 'jsonp',
		data : {
			api_key : "aff7e1ce102316f1349934e4c4228ac5",
			query : title
		},
		success : function(data) {
			var number = data.total_results;

			if (number >= 1) {
				var movieID = data.results[0].id;

				searchMovieByID(movieID);
				getMovieTrailer(movieID);
				getMovieCredits(movieID);
				$("#info-area").show()

			} else {
				alert("No movie found!")
			}

		},
		error : function(data) {
			console.log("Movie search error: " + JSON.stringify(data));
		}
	});

}

function searchMovieByID(movieID) {

	$.ajax({
		method : "GET",
		url : "http://api.themoviedb.org/3/movie/" + movieID,
		contentType : 'application/json',
		dataType : 'jsonp',
		data : {
			api_key : "aff7e1ce102316f1349934e4c4228ac5",

		},
		success : function(data) {
			$("#image").html(
					"<img class='center-block' height='140px' src=http://image.tmdb.org/t/p/w300"
							+ data.poster_path + ">");
			$("#link").html(
					"<a href=http://www.themoviedb.org/movie/" + data.id
							+ ">See on TMDb </a>");
			$("#searched-title").html(data.title);
			$("#searched-apikey").html(data.id);
			$("#searched-rating").rateit("value", +data.vote_average);
			$("#searched-rating").rateit("max", +10);
			$("#searched-description").html(data.overview);
		},
		error : function(data) {
			alert(JSON.stringify(data));
		}
	});

}

function getMovieTrailer(movieID) {

	$.ajax({
		method : "GET",
		url : "http://api.themoviedb.org/3/movie/" + movieID + "/videos",
		contentType : 'application/json',
		dataType : 'jsonp',
		data : {
			api_key : "aff7e1ce102316f1349934e4c4228ac5",
		},
		success : function(data) {

			if (data.results[0] == undefined) {
				$("#reviews").html("<h4>No trailer found.</h4>");
				return;
			}

			$("#reviews").html(
					'<iframe id="player" type="text/html" width="100%" height="300px" '
							+ 'src="http://www.youtube.com/embed/'
							+ data.results[0].key + '?enablejsapi=1"'
							+ 'frameborder="0"></iframe>');

		},
		error : function(data) {
			console.log("Movie trailer error: "+ JSON.stringify(data));
		}

	});

}

function getMovieCredits(movieID) {

	$.ajax({
		method : "GET",
		url : "http://api.themoviedb.org/3/movie/" + movieID + "/credits",
		contentType : 'application/json',
		dataType : 'jsonp',
		data : {
			api_key : "aff7e1ce102316f1349934e4c4228ac5",
		},
		success : function(data) {

			var actors = getCast(data);
			
			var crew = getCrew(data);
			

			$("#creator").html(actors + crew);

		},
		error : function(data) {
			console.log(JSON.stringify(data));
		}

	});

}

function getCast(data) {
	var actors = "<p><b>Cast: </b>";
	
	for (var i = 0; i <= 4; i++) {
		actors += data.cast[i].name + ", ";
	}
	
	return actors.substring(0, actors.length - 2) + "</p>";
}

function getCrew(data) {
	var director = "<b>Direction: </b> "
	var writing = "<b>Writing: </b> "

	$.each(data.crew, function(index, value) {
		if (value.job == "Director") {
			director += value.name + ", ";
		}

		if (value.job == "Writer" || value.job == "Screenplay"
				|| value.job == "Author" || value.job == "Novel") {
			writing += value.name + " (" + value.job + "), ";
		}
	});

	director = "<p>" + director.substring(0, director.length - 2) + "</p>";
	writing = "<p>" + writing.substring(0, writing.length - 2) + "</p>";

	return director + writing;

}

function generateCatchForm() {

	$("#searched-form")
			.html(
					'<form action="addCatchMedia" method="post">'
							+ '<input hidden name="mediatype" value="'
							+ $("#search-mediatype").val()
							+ '"></input>'
							+ '<input hidden name="title" value="'
							+ $("#searched-title").text()
							+ '"></input>'
							+ '<input hidden name="apiID" + value= "'
							+ $("#searched-apikey").text()
							+ '"></input>'
							+ '<textarea class="form-control" rows="5" maxlength="300" placeholder="(300 characters or less)" name="comment"></textarea>'
							+ '<br/><div class="btn-group"><button type="submit" class="btn btn-sm btn-primary" >Submit</button>'
							+ '<button type="button" class="btn btn-sm btn-default" id="searched-catch-cancel">Cancel</button></div>'
							+ '</form>');

	$("#searched-catch-cancel").click(function() {
		$("#searched-caught").show();
		$("#searched-form").empty();
	});

}

function generateCaughtForm() {

	$("#searched-form")
			.html(
					'<form action="addCaughtMedia" method="post">'
							+ '<input hidden name="mediatype" value="'
							+ $("#search-mediatype").val()
							+ '"></input>'
							+ '<input hidden name="title" value="'
							+ $("#searched-title").text()
							+ '"></input>'
							+ '<input hidden name="apiID" + value= "'
							+ $("#searched-apikey").text()
							+ '"></input>'
							+ '<textarea class="form-control" rows="5" maxlength="300" placeholder="(300 characters or less)" name="comment"></textarea>'
							+ '<br/><select id="caught-rating" name="rating" style="width: 80px"> <option selected="selected"'
							+ 'value="0">0</option><option value="1">1</option> <option value="2">2</option>'
							+ '<option value="3">3</option><option value="4">4</option><option value="5">5</option>'
							+ '<option value="6">6</option><option value="7">7</option><option value="8">8</option>'
							+ '<option value="9">9</option><option value="10">10</option></select>'
							+ '<div id="star-rating"></div><br/>'
							+ '<div class="btn-group"><button type="submit" class="btn btn-sm btn-primary" >Submit</button>'
							+ '<button type="button" class="btn btn-sm btn-default" id="searched-caught-cancel">Cancel</button>'
							+ '</div></form>');

	$("#searched-caught-cancel").click(function() {
		$("#searched-catch").show();
		$("#searched-form").empty();
	});

	$(function() {
		$('#star-rating').rateit({
			max : 10,
			step : 1,
			backingfld : '#caught-rating'
		});
	});

}
