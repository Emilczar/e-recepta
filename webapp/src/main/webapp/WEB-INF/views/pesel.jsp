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
            <h1>podaj PESEL</h1>
			             
        </div>
 
        <form:form method="post" modelAttribute="newPacjent"> 
		 <table>
		<tr>
		<td>Pesel</td>
		
		</tr>
        
        <tr> 
        	<td>
        	<form:input path="pesel" id="pesel" type="text"/>
        	</td>
        	</form:form>
        </tr>
        
        <tr>
<td colspan="3">
<form action="/webapp/wyslij">
			
    	<input type="submit" value="wyslij"  />
    	
			</form></td>
	</tr>
        
        </table>
        
    
      

 <table>
    </table>    
    </body>
</html>