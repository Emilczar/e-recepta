<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Potwierdzenie wykonania</title>
    </head>
    <body>
        <div align="center">
            <h1>Potwierdzenie</h1>
			             
        </div>
         
        <p>wykonano recepte <b>${wykonaj}</b></p>
        <form action="/webapp/apteka/">
    	<input type="submit" value="OK" />
			</form>
     
      

        
        
    </body>
</html>