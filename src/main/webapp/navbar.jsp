<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Note Taker</title>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-primary text-light ml-0">
		<h3 class="navbar-brand">NoteTaker</h3>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="addNotes.jsp">Add Note</a></li>
				
				<li class="nav-item"><a class="nav-link" href="DisplayNotes.jsp">Display Notes</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0" action="searchNote" method="post">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search" name="search">
				<button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
</body>
</html>