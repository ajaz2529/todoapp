<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.entities.Note"%>
<%@ page import="helpers.FactoryHelper"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Notes</title>
<%@include file="css_js/css_js.jsp"%>
</head>
<body>
	<div><%@include file="navbar.jsp"%></div>
	<h2>All Notes Here</h2>
	<br>
	<%
	Session s = FactoryHelper.GetFactory().openSession();
	Query q = s.createQuery("from Note");
	List<Note> list = q.list();
	for (Note note : list) {
	%>
	<div class="card">
		<img class="card-img-top" style ="max-width: 50px"src="img/noteimage.avif" alt="Card image cap">
		<div class="card-body">
			<h5 class="card-title"><%=note.getTitle() %></h5>
			<p class="card-text"><%=note.getDescription() %></p>
			<a href="deleteNote?id=<%=note.getId()%>" class="btn btn-danger " >Delete</a>
		</div>
	</div>
	<%
	}
	s.close();
	
	%>

</body>
</html>