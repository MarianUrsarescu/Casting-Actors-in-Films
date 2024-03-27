<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<link href="m1_Actor.css" rel="stylesheet" type="text/css" media="screen" />
    	
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela Actori</title>
        <link href="table.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <jsp:useBean id="jb" scope="session" class="db.JavaBean" />
    <jsp:setProperty name="jb" property="*" />
    <body>
        <h1 align="center">Tabela Actori:</h1>
        <br/>
        <p align="center"><a href="nou_Actor.jsp"><b>Adauga un nou actor.</b></a> <a href="index.html"><b>Home</b></a></p>
        <%
            jb.connect();
            int aux = java.lang.Integer.parseInt(request.getParameter("primarykey"));
            ResultSet rs = jb.intoarceLinieDupaId("actori", "idActor", aux);
            rs.first();
            String Nume = rs.getString("Nume");
            String Prenume = rs.getString("Prenume");
            String Nationalitate = rs.getString("Nationalitate");
            rs.close();
            jb.disconnect();
        %>
        <form action="m2_Actor.jsp" method="post">
            <table align="center">
                <tr>
                    <td align="right">IdActor:</td>
                    <td> <input type="text" name="idActor" size="30" value="<%= aux%>" readonly/></td>
                </tr>
                <tr>
                    <td align="right">Nume:</td>
                    <td> <input type="text" name="Nume" size="30" value="<%= Nume%>"/></td>
                </tr>
                <tr>
                    <td align="right">Prenume:</td>
                    <td> <input type="text" name="Prenume" size="30" value="<%= Prenume%>"/></td>
                </tr>
                <tr>
                    <td align="right">Nationalitate:</td>
                    <td> <input type="text" name="Nationalitate" size="30" value="<%= Nationalitate%>"/></td>
                </tr>
            </table><p align="center">
                <input type="submit" value="Modifica linia">
            </p>
        </form>
        <p align="center"">
            <a href="index.html"><b>Home</b></a>
            <br/>
    </body>
</html>