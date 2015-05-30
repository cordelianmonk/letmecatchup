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
<title>Dashboard</title>

<link href="<c:url value="resources/animate.css" />" rel="stylesheet" />
<link href="<c:url value="resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" />
	
<link href='http://fonts.googleapis.com/css?family=Lobster|Bitter:700' rel='stylesheet' type='text/css' />

<link href="<c:url value="resources/index.css" />" rel="stylesheet" />

<script src="<c:url value="/resources/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/jquery.lettering.js" />"></script>
<script src="<c:url value="/resources/jquery.textillate.js" />"></script>

<script src="<c:url value="/resources/dash-index.js" />"></script>

<script src="<c:url value="resources/bootstrap/js/bootstrap.min.js" />"></script>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
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
				<li class="active"><a href="dash.html">Dashboard</a><span
					class="sr-only">current</span></li>
				<li><a href="searchmedia.html">Search</a></li>

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

	<!-- MAIN AREA -->
	<div class="top-greeting">
		<h1>Hello ${userName}!</h1>
	</div>

	<div class="container-fluid">
		<p>Do you want to...</p>
		<div class="col-xs-12">
			<div class="well titles" id="catch-booklist">
				<p class="small text-muted">...catch up with your reading?</p>
				<h3 class="tlt">
					<ul class="texts">
						<c:if test="${!empty catchBookList}">
							<c:forEach items="${catchBookList}" var="catchBook">
								<li>${catchBook.title}</li>
							</c:forEach>
						</c:if>
					</ul>
				</h3>
				<a href="catch_books.html" class="pull-right">more...</a>
			</div>
		</div>

		<div class="col-xs-12">
			<div class="well titles" id="catch-movielist">
				<p class="small text-muted">...catch a movie?</p>
				<h3 class="tlt">
					<ul class="texts">
						<c:if test="${!empty catchMovieList}">
							<c:forEach items="${catchMovieList}" var="catchMovie">
								<li>${catchMovie.title}</li>
							</c:forEach>
						</c:if>
					</ul>
				</h3>
				<a href="catch_movies.html" class="pull-right">more...</a>
			</div>
		</div>

		<div class="col-xs-12">
			<div class="well titles" id="caught-booklist">
				<p class="small text-muted">...read this book again?</p>
				<h3 class="tlt">
					<ul class="texts">
						<c:if test="${!empty caughtBookList}">
							<c:forEach items="${caughtBookList}" var="caughtBook">
								<li>${caughtBook.title}</li>
							</c:forEach>
						</c:if>
					</ul>
				</h3>
				<a href="caught_books.html" class="pull-right">more...</a>
			</div>
		</div>


		<div class="col-xs-12">
			<div class="well titles" id="caught-movielist">
			<p class="small text-muted">...watch this movie again?</p>
				<h3 class="tlt">
					<ul class="texts">
						<c:if test="${!empty caughtMovieList}">
							<c:forEach items="${caughtMovieList}" var="caughtMovie">
								<li>${caughtMovie.title}</li>
							</c:forEach>
						</c:if>
					</ul>
				</h3>
				<a href="caught_books.html" class="pull-right">more...</a>
			</div>
		</div>

	</div>


</body>
</html>