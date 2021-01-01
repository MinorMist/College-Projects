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

	<div class="row">
		<div class="container">
			<h3 class="text-center">Notes</h3>
			<hr>
			<div class="container">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Note</a>
			</div>
			<br>
			<div class="row">
			
			<c:forEach var="note" items="${listNote}">
			
			<div class="card col-sm-4 col-md-4">
  				<div class="card-body ">
    			<div class="thumbnail">
        		<caption><h3><c:out value="${note.title}" /></h3></caption>
        			<p><c:out value="${note.despt}" /></p>
        			<p><a class="btn" href="edit?id=<c:out value='${note.id}' />">Edit<span class="glyphicon glyphicon-pencil"></span></a> <a class="btn btn-success" href="delete?id=<c:out value='${note.id}' />">Delete<span class="glyphicon glyphicon-trash"></span></a></p>
      			</div>
   			 </div>
  			</div>
  <br><br>
  </c:forEach>
  </div>
</div>
					
					
	
		</div>
	</div>
	<div class="footer">Achyut M Sharma</div>
</body>
</html>