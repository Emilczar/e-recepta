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
            <h1>Lista Leków</h1>
			             
        </div>
       
       <form action="/webapp/szukaj">
    	<input type="submit" value="dodaj leki" />
			</form>
      

 <table>
<c:forEach var="emp" items="${leki}">
 	<tr>
		<td> ${emp}</td>
		<td><form action="/webapp/usun/${emp}">
    	<input type="submit" value="Usun" />
			</form>
		</td>
	</tr>  
</c:forEach>
    </table>    
    </body>
</html>