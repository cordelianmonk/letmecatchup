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
<title>Caught Books</title>
<link href="<c:url value="resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" />

<link
	href='http://fonts.googleapis.com/css?family=Raleway:800,400|Lobster|Oswald'
	rel='stylesheet' type='text/css' />

<link href="<c:url value="resources/index.css" />" rel="stylesheet" />
<link href="<c:url value="resources/animate.css" />" rel="stylesheet" />

<script src="<c:url value="/resources/jquery-2.1.4.min.js" />"></script>

<link href="<c:url value="resources/rateit.css" />" rel="stylesheet" />
<script src="<c:url value="/resources/jquery.rateit.min.js" />"></script>

<script src="<c:url value="resources/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/caught-index.js" />"></script>
</head>
<body>

	<!-- NAVBAR -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand"></a> <img class="pull-left"
				src="<c:url value="resources/64x64.png"/>"></img>

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

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Catch<span class="caret" /></a>
					<ul class="dropdown-menu">
						<li><a href="catch_books.html">Books</a></li>
						<li><a href="catch_movies.html">Movies</a></li>
					</ul></li>

				<li class="active" class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Caught<span class="caret" /></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="caught_books.html">Books</a></li>
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

	<!-- NAVBAR END -->
	<div class="container">
		<div class="top-greeting animated bounceInRight">
			<h3>Your read books</h3>
			<img class="top-greeting-img"
				src="<c:url value="resources/128x128-closedbook.png"/>"></img>
			
		</div>
		<c:if test="${!empty caughtBookMessage}">
			<div class="alert alert-dismissible alert-success">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<strong>${caughtBookMessage}</strong>
			</div>
		</c:if>
	</div>
	<div id="caught-book-list">
		<c:if test="${!empty caughtBookList}">
			<c:forEach items="${caughtBookList}" var="caughtBook">
				<div class="container">
					<div class="panel panel-default" id="caughtbook-${caughtBook.bid}">
						<div class="panel-heading"
							id="caughtbook-${caughtBook.bid}-panelheadtitle">
							<h4 class="animated flipInX">${caughtBook.title}</h4>
							<div id="caughtbook-${caughtBook.bid}-star-rating"
								class="rateit animated flipInY" data-rateit-ispreset="true"
								data-rateit-readonly="true"
								data-rateit-value="${caughtBook.rating}" data-rateit-max="10"></div>
						</div>
						<div hidden class="panel-body"
							id="caughtbook-${caughtBook.bid}-panel-body">
							<input hidden id="caughtbook-set-rating-${caughtBook.bid}"
								value="${caughtBook.rating}"></input>
							<h5 id="caughtbook-${caughtBook.bid}-comment">${caughtBook.comment}</h5>
							<form hidden id="caughtbook-form-${caughtBook.bid}"
								action="updateCaughtBook" method="post">

								<label for="title">Title</label><br /> <input name="title"
									id="title-${caughtBook.bid}" value="${caughtBook.title}"
									class="form-control"></input><br />
									
									 <label for="rating">Rating</label><select
									disabled="true" id="caughtbook-form-${caughtBook.bid}-rating"
									class="form-control" name="rating">
									<option value="0">0</option>
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
								
								<div id="caughtbook-form-edit-star-rating-${caughtBook.bid}"></div>
								<br /> <br /> 
								
								<label for="comment">Comment</label><br />
								<textarea rows="3" class="form-control" maxlength="300"
									name="comment" id="comment-${caughtBook.bid}">${caughtBook.comment}</textarea>
								<br /> 
								
								<input hidden name="bid" value="${caughtBook.bid}"></input>
								<input hidden name="apiID" value="${caughtBook.apiID}"></input>

								<div class="btn-group pull-right"
									id="caughtbook-form-${caughtBook.bid}-editbuttons">
									<button type="submit" class="btn btn-sm btn-primary"
										id="update-caughtbook">Save</button>
									<button type="button" class="btn btn-sm btn-default"
										id="canceledit-caughtbook-${caughtBook.bid}">Cancel</button>
									<button type="button" class="btn btn-sm btn-danger"
										id="show-delete-caughtbook-${caughtBook.bid}">Delete</button>
								</div>

								<div hidden id="caughtbook-form-${caughtBook.bid}-deletebuttons">
									<div class="btn-group pull-right">
										<button class="btn btn-sm btn-danger"
											formaction="deleteCaughtBook" id="delete-caughtbook">Confirm
											Delete</button>
										<button type="button" class="btn btn-sm btn-default"
											id="canceldelete-caughtbook-${caughtBook.bid}">Cancel</button>
									</div>
								</div>
							</form>

							<div id="edit-caughtbook-button-${caughtBook.bid}">
								<button class="btn btn-sm btn-default pull-right"
									id="edit-caughtbook-${caughtBook.bid}">Edit</button>
							</div>

						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>

</body>
</html>