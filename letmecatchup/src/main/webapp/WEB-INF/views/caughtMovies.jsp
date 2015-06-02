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
<title>Caught Movies</title>
<link href="<c:url value="resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" />

<link
	href='http://fonts.googleapis.com/css?family=Raleway:800,400|Lobster|Oswald'
	rel='stylesheet' type='text/css' />

<link href="<c:url value="resources/index.css" />" rel="stylesheet" />
<link href="<c:url value="resources/animate.css" />" rel="stylesheet" />

<script src="<c:url value="/resources/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/caught-index.js" />"></script>
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
				<li><a href="searchmedia.html">Search <span class="glyphicon glyphicon-search"/></a></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Catch<span class="caret" /></a>
					<ul class="dropdown-menu">
						<li><a href="catch_books.html">Books</a></li>
						<li><a href="catch_movies.html">Movies</a></li>
					</ul></li>

				<li class="active" class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Caught<span class="caret" /></a>
					<ul class="dropdown-menu">
						<li><a href="caught_books.html">Books</a></li>
						<li class="active"><a href="caught_movies.html">Movies</a></li>
					</ul></li>
			</ul>

			<div class="navbar-text navbar-right">
				<a class="navbar-link" href="log_out.html"> Log out</a>
			</div>

		</div>
	</div>
	</nav>

	<!-- NAVBAR END -->
	<div class="container">
		<div class="top-greeting animated bounceInRight">
			<h3>Movies you've watched</h3>
		</div>
	</div>

	<div id="caught-movie-list">
		<c:if test="${!empty caughtMovieList}">
			<c:forEach items="${caughtMovieList}" var="caughtMovie">
				<div class="container">
					<div class="panel panel-default"
						id="caughtmovie-${caughtMovie.mid}">

						<div class="panel-heading"
							id="caughtmovie-${caughtMovie.mid}-panelheadtitle">
							<h4 class="animated flipInX">${caughtMovie.title}</h4>
							<div id="caughtmovie-${caughtMovie.mid}-rating" class="rateit animated flipInY"
								data-rateit-ispreset="true" data-rateit-readonly="true"
								data-rateit-value="${caughtMovie.rating}" data-rateit-max="10">
							</div>
						</div>
						<div hidden class="panel-body"
							id="caughtmovie-${caughtMovie.mid}-panel-body">
							<input hidden id="caughtmovie-set-rating-${caughtMovie.mid}"
								value="${caughtMovie.rating}"></input>
							<h5 id="caughtmovie-${caughtMovie.mid}-comment">${caughtMovie.comment}</h5>

							<form hidden id="caughtmovie-form-${caughtMovie.mid}"
								action="updateCaughtMovie" method="post">
								<label for="title">Title</label><br /> <input
									class="form-control" name="title" id="title-${caughtMovie.mid}"
									value="${caughtMovie.title}"></input> <br /> <label
									for="rating">Rating</label><br /> <select disabled="true"
									id="caughtmovie-form-${caughtMovie.mid}-rating"
									class="form-control" name="rating" style="width: 80px">
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
								<div id="caughtmovie-edit-star-rating-${caughtMovie.mid}"></div>
								<br />
								<br /> <label for="comment">Comment</label><br />
								<textarea rows="3" maxlength="300" name="comment"
									id="comment-${caughtMovie.mid}" class="form-control">${caughtMovie.comment}</textarea>
								<br /> <input hidden name="mid" value="${caughtMovie.mid}"></input>
								<input hidden name="apiID" value="${caughtMovie.apiID}"></input>

								<div class="btn-group pull-right"
									id="caughtmovie-form-${caughtMovie.mid}-editbuttons">
									<button type="submit" class="btn btn-sm btn-primary"
										id="update-caughtmovie">Save</button>
									<button type="button" class="btn btn-sm btn-warning"
										id="canceledit-caughtmovie-${caughtMovie.mid}">Cancel</button>
									<button type="button" class="btn btn-sm btn-danger"
										id="show-delete-caughtmovie-${caughtMovie.mid}">Delete</button>
								</div>

								<div hidden
									id="caughtmovie-form-${caughtMovie.mid}-deletebuttons">
									<div class="btn-group pull-right">
										<button class="btn btn-sm btn-danger"
											formaction="deleteCaughtBook" id="delete-caughtmovie">Confirm
											Delete</button>
										<button type="button" class="btn btn-sm btn-warning"
											id="canceldelete-caughtmovie-${caughtMovie.mid}">Cancel</button>
									</div>
								</div>
							</form>

							<div id="edit-caughtmovie-button-${caughtMovie.mid}">
								<button class="btn btn-sm btn-default pull-right"
									id="edit-caughtmovie-${caughtMovie.mid}">Edit</button>
							</div>

						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>

</body>
</html>