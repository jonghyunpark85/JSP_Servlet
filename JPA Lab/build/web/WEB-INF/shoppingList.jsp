<%-- 
    Document   : shoppingList
    Created on : Oct 24, 2018, 11:17:57 AM
    Author     : john
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <h2>Add Item</h2>
            <form action="SLcontroller" method="POST">
            Enter item: <input type="text" name="listitem">
            <input type="submit" value="Add">
        </form>
        
        ${requestScope.message}
        
        <h2>To Get</h2>
        <table border="1">
            <th>Item</th><th>In Cart</th><th>Delete</th>
            
            <c:forTokens var="itemLine" delims=";" items="${requestScope.notInCartItems}" >
                <c:set var="itemDetails" value="${fn:split(itemLine,',')}"/>
                <tr>
                    <td>${itemDetails[1]}</td>
                    <td><a href="SLcontroller?add=${itemDetails[0]}">Add to Cart</a></td>
                    <td><a href="SLcontroller?delete=${itemDetails[0]}">Delete</a></td>
                </tr>
            </c:forTokens>
                
        </table>
        
        <h2>In Cart</h2>
        <table border="1">
            <th>Item</th><th>Remove from Cart</th><th>Delete</th>
            
            <c:forTokens var="itemLine" delims=";" items="${requestScope.inCartItems}" >
                <c:set var="itemDetails" value="${fn:split(itemLine,',')}"/>
                <tr>
                    <td>${itemDetails[1]}</td>
                    <td><a href="SLcontroller?remove=${itemDetails[0]}">Remove from Cart</a></td>
                    <td><a href="SLcontroller?delete=${itemDetails[0]}">Delete</a></td>
                </tr>
            </c:forTokens>
                
        </table>    
        
    </body>
</html>
