<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Note Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<style>
		p {
    		height:60px;
    		line-height:20px; 
    		overflow:hidden;
		}
			body{
			max-width:100%;
			overflow-x: hidden;
		}
		.navbar{
			color: #CAD3C8;
			background-color:#2C3A47;
		}
		.navbar-brand,
		.nav-link{
			color: #CAD3C8;
			background-color: transparent;
		}
		.footer {
   			position: fixed;
   			left: 0;
   			bottom: 0;
   			width: 100%;
   			background-color: #2C3A47;
   			color: #CAD3C8;
   			text-align: center;
		}
	</style>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark">
			<div>
				<a href="#" class="navbar-brand"> Notemaking App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Notes</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${note != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${note == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${note != null}">
            			Edit Note
            		</c:if>
						<c:if test="${note == null}">
            			Add New Note
            		</c:if>
					</h2>
				</caption>

				<c:if test="${note != null}">
					<input type="hidden" name="id" value="<c:out value='${note.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Note Title</label> <input type="text"
						value="<c:out value='${note.title}' />" class="form-control"
						name="title" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Note Description</label> <textarea class="form-control"
						name="despt" rows="15"><c:out value='${note.despt}' /></textarea>
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
	<div class="footer">Achyut M Sharma</div>
</body>
</html>