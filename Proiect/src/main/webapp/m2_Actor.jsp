<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<link href="m2_Actor.css" rel="stylesheet" type="text/css" media="screen" />
    	
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela Actori</title>
        <link href="table.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <jsp:useBean id="jb" scope="session" class="db.JavaBean" />
    <jsp:setProperty name="jb" property="*" />
    <body>
        <h1 align="center"> Tabela Actori:</h1>
        <br/>
        <p align="center"><a href="nou_Actor.jsp"><b>Adauga un nou actor.</b></a> <a href="index.html"><b>Home</b></a></p>
        <%
            jb.connect();
            int aux = java.lang.Integer.parseInt(request.getParameter("idActor"));
            String Nume = request.getParameter("Nume");
            String Prenume = request.getParameter("Prenume");
            String Nationalitate = request.getParameter("Nationalitate");

            String[] valori = {Nume, Prenume, Nationalitate};
            String[] campuri = {"Nume", "Prenume", "Nationalitate"};
            jb.modificaTabela("actori", "idActor", aux, campuri, valori);
            jb.disconnect();
        %>
        <h1 align="center">Modificarile au fost efectuate !</h1>
        <p align="center">
            <a href="index.html"><b>Home</b></a>
            <br/>
    </body>
</html>