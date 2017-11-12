<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
      pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Osoitteet</title>
</head>
<body>
<h1>Osoitteet</h1>
<table border="1">
<caption>Osoitteet</caption>
<thead>
	<tr>
		<td>id</td>
		<td>nimi</td>
		<td>katuosoite</td>
		<td>postinumero</td>
		<td>postitoimipaikka</td>
		<td>osavaltio</td>
		<td>maa</td>
		<td>poista</td>
		<td>muokkaa</td>
	</tr>
</thead>
<tbody>
<c:forEach items="${osoitteet}" var="osoite">
	<tr>
		<td><c:out value="${osoite.id}"/></td>
		<td><c:out value="${osoite.nimi}"/></td>
		<td><c:out value="${osoite.katuosoite}"/></td>
		<td><c:out value="${osoite.postinumero}"/></td>
		<td><c:out value="${osoite.postitoimipaikka}"/></td>
		<td><c:out value="${osoite.osavaltio}"/></td>
		<td><c:out value="${osoite.maa}"/></td>
		<td><a href="/joulukortit2/kasky/<c:out value="${osoite.id}"/>">MUOKKAA</a></td>
		<td><a href="/joulukortit2/toiminto/<c:out value="${osoite.id}"/>">POISTA</a></td>
	</tr>
</c:forEach>
</tbody>
</table>


<p>
<a href="../kasky/lisaa">Lisää osoite.</a>
</p>
</body>
</html>