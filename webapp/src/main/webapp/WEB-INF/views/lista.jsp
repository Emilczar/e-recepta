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
            <h1>Lista Leków</h1>
			             
        </div>
        <center>
    <table>   
    <tr>
   <c:set var="age" value="26"/>
    
   <c:if test="${licznik <= 0}"> 
 <c:set var="dostep" value="disabled"/>
  </c:if>
    

      <td><a href="/webapp/szukaj" class="btn btn-primary " role="button">Dodaj</a>	
      
      
     
			</td>
			
			
			<td>
			
			<a href="/webapp/pesel" class="btn btn-primary ${dostep}" role="button">Wyslij</a>	
		
		
			
			</td>
  </tr>
  	</table>  
  	<table>  
<c:forEach var="emp" items="${leki}">
 	<tr>
		<td> ${emp}</td>
		<td>
		<a href="/webapp/usun/${emp}" class="btn btn-danger " role="button">Usun</a>	
		
		
		
		</td>
	</tr>  
</c:forEach>
    </table>    
    </center>
    </body>
</html>