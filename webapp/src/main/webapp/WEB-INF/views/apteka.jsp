<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Produkty</title>
    </head>
    <body>
    <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">
	Wyloguj się</a>
        <div align="center">
            <h1>Szukaj Recepty</h1>
			             
        </div>  
        <form:form method="post" modelAttribute="newPacjent">
  <center>
		 <table>
		<tr>
		<td>Pesel</td>
		
		</tr>
        
        <tr> 
        	<td>
        	<form:input path="Pesel" id="Pesel" type=""/>
        	</td>
     
        
   
<td colspan="3"><input type="submit" class="btn btn-primary " value="Szukaj"/></td>
	</tr>
        
        </table>
        
    </form:form>
      
<td> ${uwaga}</td>
 <table>
<c:forEach var="emp" items="${recepta}">
 	<tr>
		<td><p>Numer recepty: <b> ${emp}</b></p></td>
		<td><form action="/webapp/apteka/${emp}">
    	<input type="submit" class="btn btn-primary "  value="wykonaj" />
			</form>
		</td>
	</tr>  
</c:forEach>
    </table>   
      </center> 
    </body>
</html>