
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<link href="m2_Film.css" rel="stylesheet" type="text/css" media="screen" />
    	
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela Film</title>
        <link href="table.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <jsp:useBean id="jb" scope="session" class="db.JavaBean" />
    <jsp:setProperty name="jb" property="*" />
    <body>
        <h1 align="center"> Tabela Filme:</h1>
        <br/>
        <p align="center"><a href="nou_Film.jsp"><b>Adauga un nou film.</b></a> <a href="index.html"><b>Home</b></a></p>
        <%
            jb.connect();
            int aux = java.lang.Integer.parseInt(request.getParameter("idFilm"));
            String Titlu = request.getParameter("Titlu");
            String TipFilm = request.getParameter("TipFilm");

            String[] valori = {Titlu, TipFilm};
            String[] campuri = {"Titlu", "TipFilm"};
            jb.modificaTabela("filme", "idFilm", aux, campuri, valori);
            jb.disconnect();
        %>
        <h1 align="center">Modificarile au fost efectuate !</h1>
        <p align="center">
            <a href="index.html"><b>Home</b></a>
            <br/>
    </body>
</html>