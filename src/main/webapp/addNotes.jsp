<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Note</title>
<%@include file="css_js/css_js.jsp"%>
</head>
<body>
	<div><%@include file="navbar.jsp"%></div>
	<p style="margin-left: 42%"><%if(request.getAttribute("mess")!=null)
	{ out.println(request.getAttribute("mess"));}%></p>
	
	<form action="addNote" method="post">
		<div class="form-group">
			<label for="note">Enter Title</label>
			 <input required
				type="text" class="form-control" placeholder="Enter your Title Here" name="title">
		</div>
		<div class="form-group">
			<label for="description">Description</label> 
			<textarea required class="form-control" id="description"
			 name="description" placeholder="Enter Description"
			 style="height:250px"></textarea>
		</div>
		<div class="text-center"><button type="submit" class="btn btn-primary ">ADD</button></div>
	</form>

</body>
</html>