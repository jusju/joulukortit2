<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
      pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lisää osoite</title>
</head>
<body>
<h1>Lisää osoite</h1>

		<form:form action="osoitelisays" modelAttribute="osoite" method="post">
		  	<fieldset>		
				<legend>Uusi osoite</legend>
				<p>
					<form:hidden path="id"></form:hidden><br/>
					<form:hidden path="id" />		
				</p>
				<p>
					<form:label	path="nimi">nimi</form:label><br/>
					<form:input path="nimi" />		
				</p>
				<p>	
					<form:label path="katuosoite">katuosoite</form:label><br/>
					<form:input path="katuosoite" />
				</p>
				<p>	
					<form:label path="postinumero">postinumero</form:label><br/>
					<form:input path="postinumero" />
				</p>
				<p>	
					<form:label path="postitoimipaikka">postitoimipaikka</form:label><br/>
					<form:input path="postitoimipaikka" />
				</p>
				<p>	
					<form:label path="osavaltio">osavaltio</form:label><br/>
					<form:input path="osavaltio" />
				</p>
				<p>	
					<form:label path="maa">maa</form:label><br/>
					<form:input path="maa" />
				</p>
		
				<p>	
					<button type="submit">Lisää</button>
				</p>
			</fieldset>
		</form:form>

</body>
</html>