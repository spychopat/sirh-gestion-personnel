<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>



<head>

<meta charset="UTF-8">

<title>SGP - App</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>


	<a href="./lister" class="btn btn-primary">Liste Collaborateur</a>
	<a href="./creer" class="btn btn-primary">Nouveau Collaborateur</a>
	<a href="./statistiques" class="btn btn-primary">Statistiques</a>