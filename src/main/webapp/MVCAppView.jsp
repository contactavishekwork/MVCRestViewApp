<%-- 
    Document   : MVCAppView
    Created on : Sep 21, 2017, 6:10:56 PM
    Author     : Avishek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>

    
<html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Passenger Control</title>
    </head>
    <body>
        <form action="getPassengerProfileById" method="GET">
            Enter Passenger ID: <input type="text" id="idLabel" placeholder="1234567890"/><input type="submit" value="Find"/>
        </form>        
        <h3>Passenger Information</h3>
        <table border="1" >
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>Phone Number</th>
                <th>Email ID</th>
            </tr>
            <c:forEach begin="1" var="">
                <tr>
                    <td><%= request.getParameter("firstName") %></td>
                    <td><%= request.getParameter("lastName") %></td>
                    <td><%= request.getParameter("address") %></td>
                    <td><%= request.getParameter("email") %></td>
                    
                </tr>
                
            </c:forEach>
        </table>
    </body>
</html>
