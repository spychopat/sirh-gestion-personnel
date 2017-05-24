<%@page import="java.util.List"%>
<%@page import="dev.sgp.util.StatsPage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>


<%@ include file="./entete.jsp" %>


<body>

	<h1>Activités depuis le démarrage de l'application</h1>
	
	<div class="table-responsive">
		<table class="table">
			<tr>
				<th>Date/Heure</th>
				<th>Action</th>
				<th>Matricule</th>
			</tr>
			<c:forEach var="act" items="${activites}">
				<tr>
					<td>${act.dateHeure}</td>
					<td>${act.type}</td>
					<td>${act.matricule}</td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>

</html>