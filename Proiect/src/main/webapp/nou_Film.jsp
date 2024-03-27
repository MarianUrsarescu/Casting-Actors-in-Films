<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<link href="nou_Film.css" rel="stylesheet" type="text/css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adauga film</title>
    </head>
    <jsp:useBean id="jb" scope="session" class="db.JavaBean" />
    <jsp:setProperty name="jb" property="*" />
    <body>
        <%
            String Titlu = request.getParameter("Titlu");
            String TipFilm = request.getParameter("TipFilm");
            if (Titlu != null) {
                jb.connect();
                jb.adaugaFilm(Titlu, TipFilm);
                jb.disconnect();
        %>
        <p>Datele au fost adaugate.</p><%
        } else {
        %>
        <h1> Suntem in tabela Film.</h1>
        <form action="nou_Film.jsp" method="post">
            <table>
                <tr>
                    <td align="right">Titlu Film:</td>
                    <td> <input type="text" name="Titlu" size="40" /></td>
                </tr>
                <tr>
                    <td align="right">Tip Film:</td>
                    <td> <input type="text" name="TipFilm" size="30" /></td>
                </tr>
                
            </table>
            <input type="submit" value="Adauga filmul" />
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