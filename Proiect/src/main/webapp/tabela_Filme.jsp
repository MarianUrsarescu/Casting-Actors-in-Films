<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="tabela_Filme.css" rel="stylesheet" type="text/css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tabela Filme</title>
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<h1 align="center">Tabela Filme:</h1>
	<br />
	<p align="center">
		<a href="nou_Film.jsp"><b>Adauga un nou film.</b></a> <a
			href="index.html"><b>Home</b></a>
	</p>
	<form action="sterge_Film.jsp" method="post">
		<table border="1" align="center">
			<tr>
				<td><b>Mark:</b></td>
				<td><b>IdFilm:</b></td>
				<td><b>Titlu:</b></td>
				<td><b>TipFilm:</b></td>

			</tr>
			<%
                    jb.connect();
                    ResultSet rs = jb.vedeTabela("filme");
                    long x;
                    while (rs.next()) {
                        x = rs.getInt("idFilm");
                %>
			<tr>
				<td><input type="checkbox" name="primarykey" value="<%= x%>" /></td>
				<td><%= x%></td>
				<td><%= rs.getString("Titlu")%></td>
				<td><%= rs.getString("TipFilm")%></td>
				<%
                        }
                    %>
			</tr>
		</table>
		<br />
		<p align="center">
			<input type="submit" value="Sterge liniile marcate">
		</p>
	</form>
	<%
            rs.close();
            jb.disconnect();
        %>
	<br />
	<p align="center">
		<a href="index.html"><b>Home</b></a> <br />
	</p>
</body>
</html>