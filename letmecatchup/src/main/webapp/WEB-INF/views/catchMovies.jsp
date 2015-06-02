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
<title>Movies to Catch</title>
<link href="<c:url value="resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" />

<link
	href='http://fonts.googleapis.com/css?family=Raleway:800,400|Lobster|Oswald'
	rel='stylesheet' type='text/css' />

<link href="<c:url value="resources/index.css" />" rel="stylesheet" />
<link href="<c:url value="resources/animate.css" />" rel="stylesheet" />

<script src="<c:url value="/resources/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="resources/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/catch-index.js" />"></script>

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
				<li><a href="searchmedia.html">Search <span class="glyphicon glyphicon-search"/></a></li>

				<li class="active" class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Catch<span class="caret" /></a>
					<ul class="dropdown-menu">
						<li><a href="catch_books.html">Books</a></li>
						<li class="active"><a href="catch_movies.html">Movies</a></li>
					</ul></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Caught<span class="caret" /></a>
					<ul class="dropdown-menu">
						<li><a href="caught_books.html">Books</a></li>
						<li><a href="caught_movies.html">Movies</a></li>
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
			<h3>Your watch list</h3>
		</div>
	</div>

	<div id="catch-movie-list">

		<c:if test="${!empty catchMovieList}">
			<c:forEach items="${catchMovieList}" var="catchMovie">
				<div class="container">

					<div class="panel panel-default" id="catchmovie-${catchMovie.mid}">
						<div class="panel-heading"
							id="catchmovie-${catchMovie.mid}-panelheadtitle">
							<h4 class="animated flipInX">${catchMovie.title}</h4>
						</div>
						<div hidden class="panel-body"
							id="catchmovie-${catchMovie.mid}-panel-body">
							<h5 id="catchmovie-${catchMovie.mid}-comment">${catchMovie.comment}</h5>


							<form hidden id="catchmovie-form-${catchMovie.mid}"
								action="updateCatchMovie" method="post">
								<label for="title">Title</label><br /> <input name="title"
									id="title-${catchMovie.mid}" value="${catchMovie.title}"
									class="form-control"></input><br /> <label for="comment">Comment</label><br />
								<textarea rows="3" maxlength="300" name="comment"
									id="comment-${catchMovie.mid}" class="form-control">${catchMovie.comment}</textarea>
								<br /> <input hidden name="mid" value="${catchMovie.mid}"></input>
								<input hidden name="apiID" value="${catchMovie.apiID}"></input>

								<div class="btn-group pull-right"
									id="catchmovie-form-${catchMovie.mid}-editbuttons">
									<button type="submit" class="btn btn-sm btn-primary"
										id="update-catchmovie">Save</button>
									<button type="button" class="btn btn-sm btn-warning"
										id="canceledit-catchmovie-${catchMovie.mid}">Cancel</button>
									<button type="button" class="btn btn-sm btn-danger"
										id="show-delete-catchmovie-${catchMovie.mid}">Delete</button>
								</div>

								<div hidden id="catchmovie-form-${catchMovie.mid}-deletebuttons">
									<div class="btn-group pull-right">
										<button class="btn btn-sm btn-danger"
											formaction="deleteCatchMovie" id="delete-catchmovie">Confirm
											Delete</button>
										<button type="button" class="btn btn-sm btn-warning"
											id="canceldelete-catchmovie-${catchMovie.mid}">Cancel</button>
									</div>
								</div>


								<div hidden id="catchmovie-form-${catchMovie.mid}-caughtbuttons">
									<label for="rating">Rate</label> <select disabled="true"
										id="catchmovie-form-${catchMovie.mid}-rating"
										class="form-control" name="rating" style="width: 80px">
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

									<div id="catchmovie-form-star-rating-${catchMovie.mid}"></div>

									<div class="btn-group pull-right">
										<button class="btn btn-sm btn-primary"
											formaction="caughtCatchMovie" id="caught-catchmovie">Save</button>
										<button type="button" class="btn btn-sm btn-warning"
											id="cancelcaught-catchmovie-${catchMovie.mid}">Cancel</button>
									</div>
								</div>
							</form>
							<div class="btn-group pull-right"
								id="edit-caught-catchmovie-${catchMovie.mid}">
								<button class="btn btn-sm btn-default"
									id="edit-catchmovie-${catchMovie.mid}">Edit</button>
								<button class="btn btn-sm btn-info"
									id="caught-catchmovie-${catchMovie.mid}">Caught!</button>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>

</body>
</html>