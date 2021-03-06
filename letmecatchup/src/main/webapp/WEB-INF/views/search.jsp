<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Search</title>

<link href="<c:url value="resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" />

<link
	href='http://fonts.googleapis.com/css?family=Lobster|Droid+Serif|Raleway|Oswald'
	rel='stylesheet' type='text/css' />

<link href="<c:url value="resources/index.css" />" rel="stylesheet" />
<link href="<c:url value="resources/animate.css" />" rel="stylesheet" />

<link href="<c:url value="resources/rateit.css" />" rel="stylesheet" />

<script src="<c:url value="/resources/jquery-2.1.4.min.js" />"></script>

<script src="<c:url value="/resources/jquery.rateit.min.js" />"></script>


<script src="<c:url value="resources/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/search-index.js" />"></script>
</head>
<body>

	<!-- NAVIGATION BAR -->
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

				<li class="active"><a href="searchmedia.html">Search</a></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Catch<span class="caret" /></a>
					<ul class="dropdown-menu">
						<li><a href="catch_books.html">Books</a></li>
						<li><a href="catch_movies.html">Movies</a></li>
						<li><a href="catch_series.html">Series</a></li>
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
				<a class="navbar-link" href="log_out.html"> Log out</a>
			</div>

		</div>
	</div>
	</nav>

	<!-- MAIN BODY -->

	<div class="container">
		<div class="row">
			<div class="col-xs-12 animated bounceInRight">
				<div class="top-greeting ">
					<h3>Search and add media here</h3>
				</div>
			</div>
		</div>
		<c:if test="${!empty searchMessage}">
			<div class="alert alert-dismissible alert-success">
				<button type="button" class="close" data-dismiss="alert">x</button>
				${searchMessage}
			</div>
		</c:if>
		<c:if test="${!empty searchErrorMessage}">
			<div class="alert alert-dismissible alert-danger">
				<button type="button" class="close" data-dismiss="alert">x</button>
				${searchErrorMessage}
			</div>
		</c:if>
	</div>

	<div class="container">
		<div class="search-field animated bounceInDown">
			<div class="container">
				<div class="col-xs-12">
					<div class="form-group">
						<label for="select-action">Choose one from the selection</label> <select
							class="form-control" id="select-action" style="width: 250px">
							<option selected="selected"></option>
							<option value="search">Search and (maybe) save</option>
							<option value="add">Just add</option>
						</select>
					</div>

				</div>
			</div>


			<!-- SEARCH AREA -->
			<div class="container-fluid">
				<div hidden class="search-area" id="search-area">
					<div class="col-xs-12 col-md-12">
						<div class="form-group">
							<label for="mediatype">Select media type</label> <select
								class="form-control" name="mediatype" id="search-mediatype"
								style="width: 150px">
								<option selected="selected"></option>
								<option value="book">Book</option>
								<option value="movie">Movie</option>
								<option value="series">Series</option>
							</select>
						</div>
					</div>
					<div hidden id="search-area-form" class="form-group">
						<div class="col-xs-12 col-md-6">
							<label for="title">Title</label><br /> <input autofocus
								type="text" name="title" id="search-title" style="width: 80%"></input>
							<button type="button" class="btn btn-sm btn-primary" id="search">Search</button>
						</div>

						<div id="search-writer-area" class="col-xs-12 col-md-6">
							<label for="writer">Writer</label><br /> <input autofocus
								type="text" name="writer" id="search-writer" style="width: 90%"></input>
						</div>
					</div>
				</div>
			</div>

			<!-- ADD ONLY AREA -->
			<div class="container">
				<div hidden class="add-only-area" id="add-only-area">

					<div class="col-xs-12 col-md-6">
						<div class="form-group">
							<label for="status">Select Status</label> <select
								class="form-control" id="add-status" name="status"
								style="width: 150px">
								<option selected="selected"></option>
								<option value="catch">Catch</option>
								<option value="caught">Caught</option>
							</select>
						</div>
					</div>

					<form hidden action="addCatchMedia" method="post"
						id="add-catch-form">
						<div class="col-xs-12 col-md-12">
							<div class="form-group">
								<label for="mediatype">Select media type</label> <select
									class="form-control" id="mediatype" name="mediatype"
									style="width: 150px">
									<option value="book">Book</option>
									<option value="movie">Movie</option>
									<option value="series">Series</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12">
								<label for="title">Title</label><br /> <input autofocus
									type="text" name="title" id="title"></input><br /> <label
									for="comment">Comment</label></br>
								<textarea rows="5" maxlength="300"
									placeholder="(300 characters or less)" name="comment"
									id="comment" class="form-control"></textarea>
								<input hidden name="apiID"></input> <br />
								<button type="submit" class="btn btn-sm btn-primary" id="search">Submit</button>
							</div>
						</div>
					</form>

					<form hidden action="addCaughtMedia" method="post"
						id="add-caught-form">
						<div class="col-xs-12 col-md-12">
							<div class="form-group">
								<label for="mediatype">Select media type</label> <select
									class="form-control" id="mediatype" name="mediatype"
									style="width: 150px">
									<option value="book">Book</option>
									<option value="movie">Movie</option>
									<option value="series">Series</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12">

								<label for="title">Title</label><br /> <input autofocus
									class="form-control" type="text" name="title" id="title"></input><br />
								<label for="comment">Comment</label><br />
								<textarea class="form-control" rows="5" maxlength="300"
									placeholder="(300 characters or less)" name="comment"
									id="comment"></textarea>

								<input hidden name="apiID"></input> <br /> <label for="rating">Rate</label>
								<select class="form-control" id="rating" name="rating"
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
								<div class="rateit" data-rateit-backingfld="#rating"></div>
								<br />
								<button type="submit" class="btn btn-sm btn-primary" id="search">Submit</button>
							</div>
						</div>
					</form>
				</div>
			</div>

			<!-- INFO -->
			<br />
			<div hidden class="info-area" id="info-area">
				<div class="container-fluid">
					<!-- 1 / 3 -->
					<div class="col-xs-12 col-md-3">
						<div id="image"></div>
						<div id="link"></div>
						<div id="creator"></div>
						<div class="btn-group">
							<button type="button" class="btn btn-sm btn-warning"
								id="searched-catch">Catch</button>
							<button type="button" class="btn btn-sm btn-primary"
								id="searched-caught">Caught</button>
						</div>

						<div id="searched-form"></div>

					</div>
					<!-- 2 / 3 -->
					<div class="col-xs-12 col-md-5">
						<h4 id="searched-title"></h4>
						<p hidden id="searched-apikey"></p>
						<div class="rateit" data-rateit-ispreset="true"
							data-rateit-readonly="true" id="searched-rating"></div>
						<br />
						<!--  <h3 id="searched-rating">Rating</h3>  -->
						<p id="searched-description">Description</p>
					</div>
					<!-- 3/3 -->
					<div>
						<div class="col-xs-12 col-md-4">
							<div id="reviews"></div>
						</div>

					</div>
				</div>

			</div>
		</div>
		<div class="container footer">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="footer text-right"></div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>