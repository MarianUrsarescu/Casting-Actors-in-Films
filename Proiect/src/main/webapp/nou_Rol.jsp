<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<link href="nou_Rol.css" rel="stylesheet" type="text/css" media="screen" /> 	
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adauga rol</title>
    </head>
    <jsp:useBean id="jb" scope="session" class="db.JavaBean" />
    <jsp:setProperty name="jb" property="*" />
    <body>
        <%
            int idFilm, idActor;
            String id1, id2, TitluFilm, TipFilm, NumeActor, PrenumeActor, Nationalitate, NumePersonaj;
            id1 = request.getParameter("idFilm");
            id2 = request.getParameter("idActor");
            NumePersonaj = request.getParameter("NumePersonaj");
            if (id1 != null) {
                jb.connect();
                jb.adaugaRol(java.lang.Integer.parseInt(id1), java.lang.Integer.parseInt(id2), NumePersonaj);
                jb.disconnect();
        %>
        <p>Datele au fost adaugate.</p><%
        } else {
        jb.connect();
        ResultSet rs1 = jb.vedeTabela("filme");
        ResultSet rs2 = jb.vedeTabela("actori");
        %>
        <h1> Suntem in tabela rol.</h1>
        <form action="nou_Rol.jsp" method="post">
            <table>
                <tr>
                    <td align="right">IdFilm:</td>
                    <td> 
                        Selectati filmul:
			<SELECT NAME="idFilm">
                                <%
                                    while(rs1.next()){
                                        idFilm = rs1.getInt("idFilm");
                                        TitluFilm = rs1.getString("Titlu");
                                        TipFilm = rs1.getString("TipFilm");
                                %>
                                    <OPTION VALUE="<%= idFilm%>"><%= idFilm%>,<%= TitluFilm%>,<%= TipFilm%></OPTION>
                                <%
                                    }
                                %>
			</SELECT>
                    
                    </td>
                </tr>
                <tr>
                    <td align="right">IdActor:</td>
                    <td> 
                        Selectati actorul:
			<SELECT NAME="idActor">
				<!-- OPTION selected="yes" VALUE="iris1">Iris 1</OPTION -->
                                <%
                                    while(rs2.next()){
                                        idActor = rs2.getInt("idActor");
                                        NumeActor = rs2.getString("Nume");
                                        PrenumeActor = rs2.getString("Prenume");
                                        Nationalitate = rs2.getString("Nationalitate");
                                %>
                                    <OPTION VALUE="<%= idActor%>"><%= idActor%>,<%= NumeActor%>,<%= PrenumeActor%>,<%= Nationalitate%></OPTION>
                                <%
                                    }
                                %>
			</SELECT>
                     </td>
                </tr>
                <tr>
                    <td align="right">NumePersonaj:</td>
                    <td> <input type="text" name="NumePersonaj" size="30" /></td>
                </tr>
            </table>
            <input type="submit" value="Adauga rolul" />
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