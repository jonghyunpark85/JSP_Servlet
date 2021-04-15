<%-- 
    Document   : wordForm
    Created on : Oct. 2, 2020, 10:21:26 a.m.
    Author     : Jonghyun Park
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Word Form</title>
    </head>
    <body>
         <h1>Word Form</h1>
        <form action="UCwordController" method="GET">
            Enter a word in lower case: <input type="text" name="lowerCase"><br/>
            <input type="submit" value="Make Upper Case">
        </form>
        
        ${message}
    </body>
</html>
