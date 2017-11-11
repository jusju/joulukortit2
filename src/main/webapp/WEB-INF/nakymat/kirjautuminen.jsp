<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Osoitteet - login</title>
</head>
<body>
<h1>Kirjaudu</h1>

		<form:form action="kirjaudu" modelAttribute="kayttaja" method="post">
		  	<fieldset>		
				<legend>Tunnukset</legend>
				<p>
					<form:label	path="kayttajatunnus">Käyttäjätunnus</form:label><br/>
					<form:input path="kayttajatunnus" />		
				</p>
				<p>	
					<form:label path="salasana">Salasana</form:label><br/>
					<form:input path="salasana" />
				</p>
				<p>	
					<button type="submit">Kirjaudu</button>
				</p>
			</fieldset>
		</form:form>
Hint: name of a daughter both for username and password. Uusi versio.

</body>
</html>

