<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lisää osoite</title>
</head>
<body>
<h1>Lisää osoite</h1>
<form action="OsoitteenTallennusServlet" method="post">
	<table>
		<tr><td>Nimi:</td><td><input type="text" name="nimi"></td></tr>
		<tr><td>Katuosoite:</td><td><input type="text" name="katuosoite"></td></tr>
		<tr><td>Postinumero:</td><td><input type="text" name="postinumero"></td></tr>
		<tr><td>Postitoimipaikka:</td><td><input type="text" name="postitoimipaikka"></td></tr>
		<tr><td>Osavaltio:</td><td><input type="text" name="osavaltio"></td></tr>
		<tr><td>Maa:</td><td><input type="text" name="maa"></td></tr>
		<tr><td>&nbsp;</td><td><input type="submit" value="Tallenna"></td></tr>
	</table>
</form>

</body>
</html>