<%-- 
    Document   : generateleavereq
    Created on : 24 May, 2021, 9:49:04 AM
    Author     : DSK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leave Request</title>
</head>
<body>
<center>
    <hr>
    <h2>Request Details</h2>
    <%
        out.println("<br />Regno: " + request.getParameter("regno"));
        out.println("<br />Name: " + request.getParameter("name"));
        out.println("<br />Reason: " + request.getParameter("reason"));
        out.println("<br />From: " + request.getParameter("from") + " | To: " + request.getParameter("to"));
    %>
    <hr>
    <br>
    <%out.println("Your Leave Request from " + request.getParameter("from") + " to " + request.getParameter("to") + " will be processed" + " and responded shortly!");%>
    <br>
    <hr>
    <br><br><a href = "mainmenu.html" style="text-decoration: none">Return to Main Menu</a>
</center>
</body>
</html>