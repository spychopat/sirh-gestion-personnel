<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>

<body>

<h1>Les collaborateurs</h1>

<!-- Liste des noms -->



<%

List<Collaborateur> listeCollab = (List<Collaborateur>)request.getAttribute("collaborateurs");

for (Collaborateur collab : listeCollab) {

%>

<table style="border:solid">
<tr><td>Nom</td><td><%= collab.getNom() %></td></tr>
<tr><td>Prénom</td><td><%= collab.getPrenom() %></td></tr>
<tr><td>Date de naissance</td><td><%= collab.getDateDeNaissance() %></td></tr>
<tr><td>Adresse</td><td><%= collab.getAdresse() %></td></tr>
<tr><td>Numéro de sécu</td><td><%= collab.getNuméroDeSecuSociale() %></td></tr>

</table>



<%

}

%>



</body>

</html>