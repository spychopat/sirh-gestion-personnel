<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<%@ include file="./entete.jsp" %>


<body>
	<form class="form-horizontal" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>Editer un collaborateur</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="nom">Nom</label>
				<div class="col-md-4">
					<input id="nom" name="nom" type="text" placeholder="Nom" value="${collaborateur.nom}"
						class="form-control input-md" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="prenom">Prénom</label>
				<div class="col-md-4">
					<input id="prenom" name="prenom" type="text" placeholder="Prénom" value="${collaborateur.prenom}"
						class="form-control input-md" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="birth">Date de
					naissance</label>
				<div class="col-md-4">
					<input id="dateNaissance" name="dateNaissance" type="date" value="${collaborateur.dateDeNaissance}"
						placeholder="Date de naissance" class="form-control input-md"
						required="">

				</div>
			</div>

			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="adresse">Adresse</label>
				<div class="col-md-4">
					<textarea class="form-control" id="adresse" name="adresse"> ${collaborateur.adresse}</textarea>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="numsecu">Numéro
					sécu</label>
				<div class="col-md-4">
					<input id="numsecu" name="numsecu" type="text" value="${collaborateur.numéroDeSecuSociale}"
						placeholder="Numéro sécu" class="form-control input-md"
						required="">

				</div>
			</div>
			
			<input type="hidden" id="matricule" value="${collaborateur.matricule}">

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="envoyer"></label>
				<div class="col-md-4">
					<button id="envoyer" name="envoyer" class="btn btn-primary">Editer</button>
				</div>
			</div>

		</fieldset>
	</form>

</body>
</html>