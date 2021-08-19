<%-- 
    Document   : spotlights
    Created on : 24 May, 2021, 2:09:07 PM
    Author     : DSK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <hr>
    <center>
        <form method="get">
            <select name="spotlights">
                <option value="1">Engineering</option>
                <option value="2">Law</option>
                <option value="3">MBA</option>
                <option value="4">VFIT</option>
            </select>
            <input type="submit" value="Submit">
        </form>
    </center>
    <hr>
<%
try{
int s = Integer.parseInt(request.getParameter("spotlights"));
if (s==1)
{
%>
<center>
<h2>Spotlights</h2>
<a href="#python">Python Coding Event</a><br><br>
<a href="#race">Real race Mechanics Contest</a><br><br>
<a href="#electronic">Electronics and You(Special Event)</a><br><br>
</center>
<%
}
else if(s==2)
{
%>
<center>
<h2>Spotlights</h2>
<a href="#lawyer">Hey Lawyers(Contest)</a><br><br>
<a href="#Dr. B. R. Ambedkar">Dr. B. R. Ambedkar the Legend(Talk Show)</a><br><br>
<a href="#Periyarism">Talk show on Periyarism</a><br><br>
</center>
<%}
else if (s==3)
{
%>
<center>
<h2>Spotlights</h2>
<a href="#MBA">MBA and You</a><br><br>
<a href="#Management">Management - an Art</a><br><br>
<a href="#Talk">Talk to Win</a><br><br>
</center>
<%   
}
else
{
%>
<center>
<h2>Spotlights</h2>
<a href="#Fashion">Fashion and You</a><br><br>
<a href="#Ancient Art">The Ancient Art</a><br><br>
<a href="#Fashion and Tamizh">Fashion and Tamizh(Massive Event)</a><br><br>
</center>
<%
}
} catch (Exception e)
{ 
}
%>
    </body>
</html>