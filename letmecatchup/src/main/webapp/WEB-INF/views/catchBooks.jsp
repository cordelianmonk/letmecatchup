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
<title>Books to Catch</title>
<link href="<c:url value="resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" />
<link href="<c:url value="resources/index.css" />" rel="stylesheet" />
<script src="<c:url value="/resources/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="resources/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/index.js" />"></script>
</head>
<body>

	<!-- NAVBAR -->
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
				<li><a href="searchmedia.html">Search</a></li>

				<li class="active" class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Catch<span class="caret" /></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="catch_books.html">Books</a></li>
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
	<!-- END OF NAVBAR -->

	<!-- BODY -->

	<h1 class="jumbotron">Your Reads</h1>

	<div id="booklist">
		<c:if test="${!empty catchBookList}">
				<c:forEach items="${catchBookList}" var="catchBook">

					<h2>${catchBook.title}</h2>
					<br />
					<p>${catchBook.comment}</p>
							<br />
							<form>
								<input hidden value="${catchBook.title}"></input>
								 <input hidden value="${catchBook.comment}"></input>
								<input hidden value="${catchBook.bid}"></input> 
								<input hidden value="${catchBook.apiID}"></input>
							</form>
				</c:forEach>
		</c:if>
	</div>

</body>
</html>