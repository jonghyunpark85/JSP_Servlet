<%-- 
    Document   : useBean
    Created on : Oct. 1, 2020, 8:47:14 a.m.
    Author     : Jonghyun Park
--%>

<%@page import="ca.sait.itsd.Userbean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Use User Bean</h1>
        <form action ="useBean.jsp" method="GET">
            <br>
            Enter username: <input type="text" name ="username"></br>
            <input type = "submit" value="Set username">
        </form>

        <%
            Userbean username = new Userbean(request.getParameter("username"));

            if (username.getUsername() == "" || username.getUsername() == null) {

            } else {
                out.println("Your name is " + username.getUsername());
            }
        %>

        <jsp:useBean id="userBean" class="ca.sait.itsd.Userbean" scope="session" />
        <jsp:setProperty name="userBean" property="username" value="${param.username}"/>



    </body>
</html>
