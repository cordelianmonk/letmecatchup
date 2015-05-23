<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Search</title>
<link href="<c:url value="resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" />
<link href="<c:url value="resources/index.css" />" rel="stylesheet" />
<script src="<c:url value="/resources/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="resources/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/search-index.js" />"></script>
</head>
<body>

	<!-- NAVIGATION BAR -->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">CatchMeUp</a>
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
					</ul></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Caught<span class="caret" /></a>
					<ul class="dropdown-menu">
						<li><a href="caught_books.html">Books</a></li>
						<li><a href="caught_movies.html">Movies</a></li>
					</ul></li>
			</ul>

			<div class="navbar-text navbar-right">
				<a class="navbar-link" href="account_settings.html"> Account
					Settings </a>
			</div>

		</div>
	</div>
	</nav>

	<!-- MAIN BODY -->

	<h1 class="jumbotron">Look up and add media</h1>
	<div class="container-fluid">
		<h2>What would you like to do?</h2>
		<div class="col-xs-12 col-md-12">
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
			<h2>Search and add</h2>
			<div class="col-xs-12 col-md-12">
				<div class="form-group">
					<label for="mediatype">Select media type</label> <select
						class="form-control" name="mediatype" id="search-mediatype"
						style="width: 150px">
						<option selected="selected"></option>
						<option value="book">Book</option>
						<option value="movie">Movie</option>
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
	<div class="container-f">
		<div hidden class="add-only-area" id="add-only-area">
			<h2>Add only</h2>

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

			<form hidden action="addCatchMedia" method="post" id="add-catch-form">
				<div class="col-xs-12 col-md-12">
					<div class="form-group">
						<label for="mediatype">Select media type</label> <select
							class="form-control" id="mediatype" name="mediatype"
							style="width: 150px">
							<option value="book">Book</option>
							<option value="movie">Movie</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12">
						<label for="title">Title</label><br /> <input autofocus
							type="text" name="title" id="title"></input><br /> <label
							for="comment">Comment</label></br>
						<textarea rows="5" width="100%" maxlength="300"
							placeholder="(300 characters or less)" name="comment"
							id="comment"></textarea>
							<input hidden name="apiID"></input>
						<br />
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
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12">
						
						<label for="title">Title</label><br /> <input autofocus
							type="text" name="title" id="title"></input><br /> 
							
						<label
							for="comment">Comment</label><br />
						<textarea rows="5" width="100%" maxlength="300"
							placeholder="(300 characters or less)" name="comment"
							id="comment"></textarea>
						
						<input hidden name="apiID"></input>
							
						<br /> 
						<label for="rating">Rate</label> <select
							class="form-control" id="rating" name="rating"
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
						</select> <br />
						<button type="submit" class="btn btn-sm btn-primary" id="search">Submit</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- INFO -->
	<div class="info-area" id="info-area">
		<div class="container-fluid">
			<!-- 1 / 3 -->
			<div class="col-xs-12 col-md-2">
				<div id="image"></div>
				<div id="creator"></div>
				<br/>
				<div id="link"></div>
				<br/>
				<button id="searched-catch">Catch</button>
				<br/>
				<button id="searched-caught">Caught</button>
				<br/>
				<!--  HIDDEN FORM -->
				<div id="searched-form">
				
				</div>
				
			</div>
			<!-- 2 / 3 -->
			<div class="col-xs-12 col-md-6">
				<h2 id="searched-title">Title</h2>
				<p hidden id="searched-apikey"></p>
				<br />
				<h3 id="searched-rating">Rating</h3>
				<br />
				<p id="searched-description">Description</p>
				<br />
			</div>
			<!-- 3/3 -->
			<div class="col-xs-12 col-md-4">
				<div id="reviews">
				</div>
			</div>
		</div>
	</div>
	
	
	




</body>
</html>