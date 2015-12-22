<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RECEPTA</title>
    </head>
    <body>
        <div align="center">
            <h1>RECETPA</h1>
			             
        </div>  
     

 <table>
<c:forEach var="emp" items="${listaId}">
 	<tr>
		<td> ${emp}</td>
		
	</tr>  
</c:forEach>
<td><form action="/webapp/apteka/wykonaj/${Id}">
    	<input type="submit" value="wykonaj" />
			</form>
			
			<td><form action="/webapp/apteka/">
    	<input type="submit" value="Anuluj" />
			</form>
		</td>
		</td>
    </table>    
    </body>
</html>