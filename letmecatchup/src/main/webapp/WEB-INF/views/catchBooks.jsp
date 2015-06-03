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
<title>Books to Catch</title>
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
						<li class="active"><a href="catch_books.html">Books</a></li>
						<li><a href="catch_movies.html">Movies</a></li>
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
			<h3>Your reading list</h3>
		</div>
	</div>

	<div id="booklist">

		<c:if test="${!empty catchBookList}">
			<c:forEach items="${catchBookList}" var="catchBook">
				<div class="container">
					<div class="panel panel-default" id="catchbook-${catchBook.bid}">
						<div class="panel-heading"
							id="catchbook-${catchBook.bid}-panelheadtitle">
							<h4 class="animated flipInX">${catchBook.title}</h4>
						</div>
						<div hidden class="panel-body"
							id="catchbook-${catchBook.bid}-panel-body">
							<h5 id="catchbook-${catchBook.bid}-comment">${catchBook.comment}</h5>

							<form hidden id="catchbook-form-${catchBook.bid}"
								action="updateCatchBook" method="post">
								<label for="title-${catchBook.bid}">Title</label> <input
									class="form-control input-lg" name="title"
									id="title-${catchBook.bid}" value="${catchBook.title}"></input><br />
								<label for="comment-${catchBook.bid}">Comment</label><br />
								<textarea class="form-control" rows="3" maxlength="300"
									name="comment" id="comment-${catchBook.bid}">${catchBook.comment}</textarea>
								<br /> <input hidden name="bid" value="${catchBook.bid}"></input>
								<input hidden name="apiID" value="${catchBook.apiID}"></input>

								<div class="btn-group pull-right"
									id="catchbook-form-${catchBook.bid}-editbuttons">
									<button type="submit" class="btn btn-sm btn-primary"
										id="update-catchbook">Save</button>
									<button type="button" class="btn btn-sm btn-default"
										id="canceledit-catchbook-${catchBook.bid}">Cancel</button>
									<button type="button" class="btn btn-sm btn-danger"
										id="show-delete-catchbook-${catchBook.bid}">Delete</button>
								</div>


								<div hidden id="catchbook-form-${catchBook.bid}-deletebuttons">
									<div class="btn-group pull-right">
										<button class="btn btn-sm btn-danger"
											formaction="deleteCatchBook" id="delete-catchbook">Confirm
											Delete</button>
										<button type="button" class="btn btn-sm btn-default"
											id="canceldelete-catchbook-${catchBook.bid}">Cancel</button>
									</div>
								</div>


								<div hidden id="catchbook-form-${catchBook.bid}-caughtbuttons">
									<label for="catchbook-form-${catchBook.bid}-rating">Rate</label><select
										id="catchbook-form-${catchBook.bid}-rating" name="rating"
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
									<div id="catchbook-form-star-rating-${catchBook.bid}"></div>

									<div class="btn-group pull-right">
										<button class="btn btn-sm btn-primary"
											formaction="caughtCatchBook" id="caught-catchbook">Save</button>
										<button type="button" class="btn btn-sm btn-default"
											id="cancelcaught-catchbook-${catchBook.bid}">Cancel</button>
									</div>

								</div>

							</form>

							<div class="btn-group pull-right"
								id="edit-caught-catchbook-${catchBook.bid}">
								<button class="btn btn-sm btn-default"
									id="edit-catchbook-${catchBook.bid}">Edit</button>
								<button class="btn btn-sm btn-primary"
									id="caught-catchbook-${catchBook.bid}">Caught</button>
							</div>

						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>

	</div>

</body>
</html>