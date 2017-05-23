<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>SGP - App</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>

<body>

	<h1>Les collaborateurs</h1>
	<a href="./creer" class="btn btn-primary">Nouveau Collaborateur</a>

	<!-- Liste des noms -->



	<div class="table-responsive">
		<table class="table">
			<tr>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Date de naissance</th>
				<th>Adresse</th>
				<th>Numéro de secu</th>
				<th>eMail</th>
			</tr>
			<c:forEach var="collab" items="${collaborateurs}">
				<tr>
					<td>${collab.nom}</td>
					<td>${collab.prenom}</td>
					<td>${collab.dateDeNaissance}</td>
					<td>${collab.adresse}</td>
					<td>${collab.numéroDeSecuSociale}</td>
					<td>${collab.emailPro}</td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<!-- Ancienne méthode -->
	<!-- 
	<%List<Collaborateur> listeCollab = (List<Collaborateur>) request.getAttribute("collaborateurs");
			for (Collaborateur collab : listeCollab) {%>

	<table style="border: solid">
		<tr>
			<td>Nom</td>
			<td><%=collab.getNom()%></td>
		</tr>
		<tr>
			<td>Prénom</td>
			<td><%=collab.getPrenom()%></td>
		</tr>
		<tr>
			<td>Date de naissance</td>
			<td><%=collab.getDateDeNaissance()%></td>
		</tr>
		<tr>
			<td>Adresse</td>
			<td><%=collab.getAdresse()%></td>
		</tr>
		<tr>
			<td>Numéro de sécu</td>
			<td><%=collab.getNuméroDeSecuSociale()%></td>
		</tr>
		<tr>
			<td>Mail</td>
			<td><%=collab.getEmailPro()%></td>
		</tr>
	</table>
	<%}%>
 -->


</body>

</html>