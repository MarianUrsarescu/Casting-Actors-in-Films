<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<link href="nou_Actor.css" rel="stylesheet" type="text/css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adauga Actor</title>
    </head>
    <jsp:useBean id="jb" scope="session" class="db.JavaBean" />
    <jsp:setProperty name="jb" property="*" />
    <body>
        <%
            String Nume = request.getParameter("Nume");
            String Prenume = request.getParameter("Prenume");
            String Nationalitate = request.getParameter("Nationalitate");
            if (Nume != null) {
                jb.connect();
                jb.adaugaActor(Nume, Prenume, Nationalitate);
                jb.disconnect();
        %>
        <p>Datele au fost adaugate.</p><%
        } else {
        %>
        <h1> Suntem in tabela Actori.</h1>
        <form action="nou_Actor.jsp" method="post">
            <table>
                <tr>
                    <td align="right">Nume Actor:</td>
                    <td> <input type="text" name="Nume" size="40" /></td>
                </tr>
                <tr>
                    <td align="right">Prenume Actor:</td>
                    <td> <input type="text" name="Prenume" size="30" /></td>
                </tr>
                <tr>
                    <td align="right">Nationalitate:</td>
                    <td> <input type="text" name="Nationalitate" size="30" /></td>
                </tr>
            </table>
            <input type="submit" value="Adauga actorul" />
        </form>
        <%
            }
        %>
        <br/>
        <p align="center">
        	<a href="index.html"><b>Home</b></a>
        <br/>
    </body>
</html>