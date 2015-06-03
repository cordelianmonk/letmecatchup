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
<title>Your Settings</title>
<link href="<c:url value="resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" />

<link
	href='http://fonts.googleapis.com/css?family=Raleway:800,400|Lobster|Oswald'
	rel='stylesheet' type='text/css' />

<link href="<c:url value="resources/index.css" />" rel="stylesheet" />
<link href="<c:url value="resources/animate.css" />" rel="stylesheet" />

<script src="<c:url value="/resources/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/settings-index.js" />"></script>
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

				<li class="active"><a href="user_settings.html">Settings</a></li>
			</ul>

			<div class="navbar-text navbar-right">
				<a class="navbar-link" href="log_out.html">Log out</a>
			</div>

		</div>
	</div>
	</nav>

	<!--  END OF NAVBAR  -->

	<!-- BODY -->

	<div class="container">
		<div class="top-greeting animated bounceInRight">
			<div class="col-xs-12 col-md-6 col-md-offset-3">
				<h3>Your details</h3>
			</div>
		</div>
		<c:if test="${!empty userMessage}">
			<div class="alert alert-dismissible alert-success">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<strong>${userMessage}</strong>
			</div>
		</c:if>
		<c:if test="${!empty userErrorMessage}">
			<div class="alert alert-dismissible alert-danger">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<strong>${userErrorMessage}</strong>
			</div>
		</c:if>
	</div>

	<div class="container">
		<div class="col-xs-12 col-md-6 col-md-offset-3 animated flipInY">
			<div class="panel panel-default">
				<div class="panel-body">
					<form method="post">
						<label for="firstName">First Name</label><br /> <input
							disabled="true" class="form-control" type="text" id="firstName"
							name="firstname" value="${user.firstName}"></input><br /> <label
							for="lastName">Last Name</label><br /> <input disabled="true"
							class="form-control" type="text" id="lastName" name="lastname"
							value="${user.lastName}"></input><br /> <label for="email">E-mail
							address</label><br /> <input disabled="true" class="form-control"
							type="text" id="email" name="email" value="${user.email}"></input><br />

						<label for="password">Password</label><br /> <input
							disabled="true" class="form-control" type="password"
							id="password" name="password" placeholder="hidden"></input><br />

						<div class="btn-group pull-right" id="user-detail-buttons">
							<button type="button" class="btn btn-sm btn-primary"
								id="edit-names">Edit Name</button>
							<button type="button" class="btn btn-sm btn-primary"
								id="edit-email">Edit Email</button>
							<button type="button" class="btn btn-sm btn-primary"
								id="change-password">Change Password</button>
						</div>

						<div hidden id="edit-name-buttons">
							<div class="btn-group pull-right">
								<button class="btn btn-sm btn-primary" formaction="editNames">Save</button>
								<button type="button" class="btn btn-sm btn-default"
									id="cancel-edit-names">Cancel</button>
							</div>
						</div>

						<div hidden id="edit-email-buttons">
							<div class="btn-group pull-right">
								<button class="btn btn-sm btn-primary" formaction="editEmail">Save</button>
								<button type="button" class="btn btn-sm btn-default"
									id="cancel-edit-email">Cancel</button>
							</div>
						</div>

						<div hidden id="change-password-buttons">
							<div class="btn-group pull-right">
								<button class="btn btn-sm btn-primary"
									formaction="changePassword">Save</button>
								<button type="button" class="btn btn-sm btn-default"
									id="cancel-change-password">Cancel</button>
							</div>
						</div>

					</form>


				</div>

			</div>
		</div>
	</div>
</body>
</html>