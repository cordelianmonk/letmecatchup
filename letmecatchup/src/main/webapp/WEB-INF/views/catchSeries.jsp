<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Series to Catch</title>
<link href="<c:url value="resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" />

<link
	href='http://fonts.googleapis.com/css?family=Raleway:800,400|Lobster|Oswald'
	rel='stylesheet' type='text/css' />

<link href="<c:url value="resources/index.css" />" rel="stylesheet" />
<link href="<c:url value="resources/animate.css" />" rel="stylesheet" />

<script src="<c:url value="/resources/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/catch-index.js" />"></script>
<script src="<c:url value="resources/bootstrap/js/bootstrap.min.js" />"></script>

<link href="<c:url value="resources/rateit.css" />" rel="stylesheet" />
<script src="<c:url value="/resources/jquery.rateit.min.js" />"></script>
</head>
<body>

	<!-- NAVBAR -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<img class="pull-left" src="<c:url value="resources/64x64.png"/>"></img>
			<a class="navbar-brand"></a>
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#hamburger-navigation">
				<!-- data that needs to appear or disappear, targeting the hamburger-navigation -->
				<span class="sr-only">Navigation toggle</span>
				<!-- sr-only screen reader -->
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="hamburger-navigation">

			<ul class="nav navbar-nav">
				<li><a href="dash.html">Dashboard</a><span class="sr-only">current</span></li>
				<li><a href="searchmedia.html">Search</a></li>

				<li class="active" class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Catch<span class="caret" /></a>
					<ul class="dropdown-menu">
						<li><a href="catch_books.html">Books</a></li>
						<li><a href="catch_movies.html">Movies</a></li>
						<li class="active"><a href="catch_series.html">Series</a></li>
					</ul></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Caught<span class="caret" /></a>
					<ul class="dropdown-menu">
						<li><a href="caught_books.html">Books</a></li>
						<li><a href="caught_movies.html">Movies</a></li>
						<li><a href="caught_series.html">Series</a></li>
					</ul></li>

				<li><a href="user_settings.html">Settings</a></li>
			</ul>

			<div class="navbar-text navbar-right">
				<a class="navbar-link" href="log_out.html">Log out</a>
			</div>

		</div>
	</div>
	</nav>
	<!-- END OF NAVBAR -->

	<!-- BODY -->
	<div class="container">
		<div class="top-greeting animated bounceInRight">
			<h3>Series you want to follow</h3>
			<img class="top-greeting-img"
				src="<c:url value="resources/128x128-book.png"/>"></img>
		</div>
		<c:if test="${!empty catchSeriesMessage}">
			<div class="alert alert-dismissible alert-success">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<strong>${catchSeriesMessage}</strong>
			</div>
		</c:if>
	</div>


	<div id="serieslist">

		<c:if test="${!empty catchSeriesList}">
			<c:forEach items="${catchSeriesList}" var="catchSeries">
				<div class="container">
					<div class="panel panel-default" id="catch-${catchSeries.sid}">
						<div class="panel-heading"
							id="catch-${catchSeries.sid}-panelheadtitle">
							<h4 class="animated flipInX">${catchSeries.title}</h4>
						</div>
						<div hidden class="panel-body"
							id="catch-${catchSeries.sid}-panel-body">
							<h5 id="catch-${catchSeries.sid}-comment">${catchSeries.comment}</h5>

							<form hidden id="catch-form-${catchSeries.sid}"
								action="updateCatchSeries" method="post">
								<label for="title-${catchSeries.sid}">Title</label> <input
									class="form-control input-lg" name="title"
									id="title-${catchSeries.sid}" value="${catchSeries.title}"></input><br />
								<label for="comment-${catchSeries.sid}">Comment</label><br />
								<textarea class="form-control" rows="3" maxlength="300"
									name="comment" id="comment-${catchSeries.sid}">${catchSeries.comment}</textarea>
								<br /> <input hidden name="sid" value="${catchSeries.sid}"></input>
								<input hidden name="apiID" value="${catchSeries.apiID}"></input>

								<div class="btn-group pull-right"
									id="catch-form-${catchSeries.sid}-editbuttons">
									<button type="submit" class="btn btn-sm btn-primary"
										id="update-catch">Save</button>
									<button type="button" class="btn btn-sm btn-default"
										id="canceledit-catch-${catchSeries.sid}">Cancel</button>
									<button type="button" class="btn btn-sm btn-danger"
										id="show-delete-catch-${catchSeries.sid}">Delete</button>
								</div>


								<div hidden id="catch-form-${catchSeries.sid}-deletebuttons">
									<div class="btn-group pull-right">
										<button class="btn btn-sm btn-danger"
											formaction="deleteCatchSeries" id="delete-catch">Confirm
											Delete</button>
										<button type="button" class="btn btn-sm btn-default"
											id="canceldelete-catch-${catchSeries.sid}">Cancel</button>
									</div>
								</div>


								<div hidden id="catch-form-${catchSeries.sid}-caughtbuttons">
									<label for="catch-form-${catchSeries.sid}-rating">Rate</label><select
										id="catch-form-${catchSeries.sid}-rating" name="rating"
										style="width: 80px">
										<option selected="selected" value="0">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
									</select>
									<div id="catch-form-star-rating-${catchSeries.sid}"></div>

									<div class="btn-group pull-right">
										<button class="btn btn-sm btn-primary"
											formaction="caughtCatchSeries" id="caught-catch">Save</button>
										<button type="button" class="btn btn-sm btn-default"
											id="cancelcaught-catch-${catchSeries.sid}">Cancel</button>
									</div>

								</div>

							</form>

							<div class="btn-group pull-right"
								id="edit-caught-catch-${catchSeries.sid}">
								<button class="btn btn-sm btn-default"
									id="edit-catch-${catchSeries.sid}">Edit</button>
								<button class="btn btn-sm btn-primary"
									id="caught-catch-${catchSeries.sid}">Caught</button>
							</div>

						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>

	</div>

</body>
</html>