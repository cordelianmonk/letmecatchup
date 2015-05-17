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

	$("#search").click(function() {
		var a = $("#search-title").val();
		async(a);
	});

});

function async(word) {
	word = word.replace(/ /g, '+');
	var url = "http://www.goodreads.com/book/title.xml?"
			+ "key=X4qHgEizBIWSv9v0v98WRQ&title=" + word;

	$
			.get(
					"http://query.yahooapis.com/v1/public/yql",
					{
						q : "select * from xml where url=\"" + url + "\"",
						format : "xml"
					},
					function(xml) {

						$("#cover")
								.html(
										"<img src="
												+ xml
														.getElementsByTagName("image_url")[0].textContent
												+ ">");
						$("#writer")
								.html(
										xml.getElementsByTagName("name")[0].textContent);
						$("#gr-link")
								.html(
										"<a href="
												+ xml
														.getElementsByTagName("url")[0].textContent
												+ ">link to GoodReads</a>");
						$("#book-title")
								.html(
										xml.getElementsByTagName("title")[0].textContent);
						$("#book-rating")
								.html("Rated "+
										xml
												.getElementsByTagName("average_rating")[0].textContent + "/5 stars");
						$("#book-description")
								.html(
										xml.getElementsByTagName("description")[0].textContent);
						$("#reviews")
								.html(
										xml
												.getElementsByTagName("reviews_widget")[0].textContent);
						// contains XML with the following structure:
						// <query>
						// <results>
						// <GoodreadsResponse>
						// ...
						console
								.log(xml.getElementsByTagName("average_rating")[0].textContent );
					});

	/*
	 * $.ajax({ method : "GET", url :
	 * "http://www.goodreads.com/book/title.xml?", crossDomain: true, dataType :
	 * "application/xml", data : { key : "X4qHgEizBIWSv9v0v98WRQ", title : word },
	 * success : function(data) {
	 * 
	 * alert("success"); },
	 * 
	 * error : function(data) { alert(data.message); } });
	 */

}
