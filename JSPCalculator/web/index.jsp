<%-- 
    Document   : index
    Created on : Oct. 1, 2020, 8:03:52 a.m.
    Author     : Jonghyun Park
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple JSP Calculator</h1>
        
        <form action="jspCalculatorServlet" method="GET">
            First: <input type="text" name="first"><br/>
            Second: <input type="text" name="second"><br/>
            <input type="submit" name="add" value="+">
            <input type="submit" name="minus" value="-">
            <input type="submit" name="multiply" value="*">
            <input type="submit" name="divide" value="%">            
        </form>
        <br/>
        <span>RESULT: ${message}</span>
    </body>
</html>
