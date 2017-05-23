<%@page import="java.util.List"%>
<%@page import="dev.sgp.util.StatsPage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>


<%@ include file="./entete.jsp" %>


<body>

	<h1>Statistiques</h1>

	<!-- Liste des noms -->





	<div class="table-responsive">
		<table class="table">
			<tr>
				<th>Chemin</th>
				<th>Nb visites</th>
				<th>Min (ms)</th>
				<th>Max (ms)</th>
				<th>Moyenne (ms)</th>
			</tr>
			<c:forEach var="stat" items="${stats}">
				<tr>
					<td>${stat.chemin}</td>
					<td>${stat.totalVisite}</td>
					<td>${stat.minTemps}</td>
					<td>${stat.maxTemps}</td>
					<td>${stat.moyenneTemps}</td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>

</html>