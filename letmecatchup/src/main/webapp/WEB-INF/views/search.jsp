<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Search</title>
<link href="<c:url value="resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" />
<link href="<c:url value="resources/index.css" />" rel="stylesheet" />
<script src="<c:url value="/resources/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="resources/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/index.js" />"></script>
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
						<li><a href="catch_all.html">All</a></li>
						<li><a href="catch_books.html">Books</a></li>
						<li><a href="catch_movies.html">Movies</a></li>
					</ul></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Caught<span class="caret" /></a>
					<ul class="dropdown-menu">
						<li><a href="caught_all.html">All</a></li>
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

	<div class="search-area">
		<div class="col-xs-12 col-md-6">
			<div class="form-group">
				<label for="mediatype">Select media type</label> <select
					class="form-control" id="mediatype">
					<option selected="selected">Media Type</option>
					<option value="book">Book</option>
					<option value="movie">Movie</option>
				</select>
			</div>
		</div>
		<div class="col-xs-12 col-md-6">
			<div class="form-group">
				<label for="title">Title</label><br /> <input type="text"
					name="title" id="title"></input>
				<button type="submit" class="btn btn-sm btn-primary" id="search">Submit</button>
			</div>
		</div>
	</div>







</body>
</html>