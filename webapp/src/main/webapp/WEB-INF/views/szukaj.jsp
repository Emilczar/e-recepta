<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Manager Home</title>
    </head>
    <body>
        <div align="center">
            <h1>Szukaj Leków</h1>
			             
        </div>
       
       
       
       
       
   
        
        <form:form method="post" modelAttribute="newLek"> 
		 <table>
		<tr>
		<td>lista</td>
		
		</tr>
        
        <tr> 
        	<td>
        	<form:input path="lek" id="lek" type=""/>
        	</td>
        </tr>
        
        <tr>
<td colspan="3"><input type="submit" value="Szukaj"/></td>
	</tr>
        
        </table>
        
    </form:form>
      

 <table>
<c:forEach var="emp" items="${lekLista}">
 	<tr>
		<td> ${emp}</td>
		<td><form action="/webapp/szukaj/${emp}">
    	<input type="submit" value="Dodaj" />
			</form>
		</td>
	</tr>  
</c:forEach>
    </table>    
    </body>
</html>