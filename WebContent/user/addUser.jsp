<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a class="navbar-brand"> Training App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/user"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<form action="user" method="post">
					<input type="hidden" name="action" value="save" />
					<caption>
						<h2>
							<c:if test="${user != null}">
            			Edit User
            		</c:if>
							<c:if test="${user == null}">
            			Add New User
            		</c:if>
						</h2>
					</caption>

					<c:if test="${user != null}">
						<input type="hidden" name="id"
							value="<c:out value='${user.id}' />" />
					</c:if>

					<fieldset class="form-group">
						<label>User Name</label> <input type="text"
							value="<c:out value='${user.name}' />" class="form-control"
							name="name" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>User Email</label> <input type="text"
							value="<c:out value='${user.email}' />" class="form-control"
							name="email">
					</fieldset>

					<fieldset class="form-group">
						<label>User Country</label> <input type="text"
							value="<c:out value='${user.country}' />" class="form-control"
							name="country">
					</fieldset>

					<fieldset class="form-group">
						<label>User Streetline1</label> <input type="text"
							value="<c:out value='${user.streetline1}' />"
							class="form-control" name="country">
					</fieldset>
					<fieldset class="form-group">
						<label>User Streetline2</label> <input type="text"
							value="<c:out value='${user.streetline2}' />"
							class="form-control" name="country">
					</fieldset>
					<fieldset class="form-group">
						<label>User City</label> <input type="text"
							value="<c:out value='${user.city}' />" class="form-control"
							name="country">
					</fieldset>
					<fieldset class="form-group">
						<label>User Pin</label> <input type="text"
							value="<c:out value='${user.pin}' />" class="form-control"
							name="country">
					</fieldset>
					<fieldset class="form-group">
						<label>User State</label> <input type="text"
							value="<c:out value='${user.state}' />" class="form-control"
							name="country">
					</fieldset>



					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
