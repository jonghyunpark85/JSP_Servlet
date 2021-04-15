<%-- 
    Document   : index
    Created on : Oct. 7, 2020, 11:00:30 p.m.
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Web Counter</h1>

        <form action ="WebCounterController" method="POST">
            <input type="submit" name ="button" value="Increment">
            <input type="submit" name ="button" value="Reset">
            <input type="hidden" name="webCount" value="${param.webCount}">
        </form>

        Count: ${param.webCount}
    </body>
</html>
