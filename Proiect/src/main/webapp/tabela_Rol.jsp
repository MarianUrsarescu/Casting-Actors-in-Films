<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<link href="tabela_Rol.css" rel="stylesheet" type="text/css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela Rol</title>
    </head>
    <jsp:useBean id="jb" scope="session" class="db.JavaBean" />
    <jsp:setProperty name="jb" property="*" />
    <body>
        <h1 align="center"> Tabela Rol:</h1>
        <br/>
        <p align="center"><a href="nou_Rol.jsp"><b>Adauga un nou rol.</b></a> <a href="index.html"><b>Home</b></a></p>
        <form action="sterge_Rol.jsp" method="post">
            <table border="1" align="center">
                <tr>
                    <td><b>Mark:</b></td>
                    <td><b>IdRol:</b></td>
                    <td><b>IdFilm:</b></td>
                    <td><b>TitluFilm:</b></td>
                    <td><b>TipFilm:</b></td>
                    <td><b>IdActor:</b></td>
                    <td><b>NumeActor:</b></td>
                    <td><b>PrenumeActor:</b></td>
                    <td><b>Nationalitate:</b></td>
                    <td><b>NumePersonaj:</b></td>
                </tr>
                <%
                    jb.connect();
                    ResultSet rs = jb.vedeRol();
                    long x;
                    while (rs.next()) {
                        x = rs.getInt("idRol");
                %>
                <tr>
                    <td><input type="checkbox" name="primarykey" value="<%= x%>" /></td><td><%= x%></td>
                    <td><%= rs.getInt("idFilm_rol")%></td>
                    <td><%= rs.getString("TitluFilm")%></td>
                    <td><%= rs.getString("TipFilm")%></td>
                    <td><%= rs.getInt("idActor_rol")%></td>
                    <td><%= rs.getString("NumeActor")%></td>
                    <td><%= rs.getString("PrenumeActor")%></td>
                    <td><%= rs.getString("Nationalitate")%></td>
                    <td><%= rs.getString("NumePersonaj")%></td>
                    <%
                        }
                    %>
                </tr>
            </table><br/>
            <p align="center">
                <input type="submit" value="Sterge liniile marcate">
            </p>
        </form>
        <%
            rs.close();
            jb.disconnect();
        %>
        <br/>
        <p align="center">
            <a href="index.html"><b>Home</b></a>
            <br/>
        </p>
    </body>
</html>