<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<link href="m1_Rol.css" rel="stylesheet" type="text/css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela Roluri</title>
        <link href="table.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <jsp:useBean id="jb" scope="session" class="db.JavaBean" />
    <jsp:setProperty name="jb" property="*" />
    <body>
        <h1 align="center">Tabela Roluri:</h1>
        <br/>
        <p align="center"><a href="nou_Rol.jsp"><b>Adauga un nou rol.</b></a> <a href="index.html"><b>Home</b></a></p>
        <%
            jb.connect();
            String TitluFilm, TipFilm, NumeActor, PrenumeActor, Nationalitate, NumePersonaj;

            int aux = java.lang.Integer.parseInt(request.getParameter("primarykey"));
            ResultSet rs = jb.intoarceRolId(aux);
            rs.first();
            int id1 = rs.getInt("idFilm_rol");
            int id2 = rs.getInt("idActor_rol");

            TitluFilm = rs.getString("TitluFilm");
            TipFilm = rs.getString("TipFilm");
            NumeActor = rs.getString("NumeActor");
            PrenumeActor = rs.getString("PrenumeActor");
            Nationalitate = rs.getString("Nationalitate");
            NumePersonaj = rs.getString("NumePersonaj");

            ResultSet rs1 = jb.vedeTabela("filme");
            ResultSet rs2 = jb.vedeTabela("actori");
            int idFilm, idActor;


        %>
        <form action="m2_Rol.jsp" method="post">
            <table align="center">
                <tr>
                    <td align="right">IdRol:</td>
                    <td> <input type="text" name="idRol" size="30" value="<%= aux%>" readonly/></td>
                </tr>
                <tr>
                    <td align="right">idFilm:</td>
                    <td> 
                        <SELECT NAME="idFilm">
                            <%
                                while (rs1.next()) {
                                    idFilm = rs1.getInt("idFilm");
                                    TitluFilm = rs1.getString("Titlu");
                                    TipFilm = rs1.getString("TipFilm");
                                    if (idFilm != id1) {
                            %>
                            <OPTION VALUE="<%= idFilm%>"><%= idFilm%>, <%= TitluFilm%>, <%= TipFilm%></OPTION>
                                <%
                                        } else {
                                %>                
                            <OPTION selected="yes" VALUE="<%= idFilm%>"><%= idFilm%>, <%= TitluFilm%>, <%= TipFilm%></OPTION>
                                <%
                                        }
                                    }
                                %>
                        </SELECT>

                    </td>
                </tr>
                <tr>
                    <td align="right">idActor:</td>
                    <td> 
                        <SELECT NAME="idActor">
                            <%
                                while (rs2.next()) {
                                    idActor = rs2.getInt("idActor");
                                    NumeActor = rs2.getString("Nume");
                                    PrenumeActor = rs2.getString("Prenume");
                                    Nationalitate = rs2.getString("Nationalitate");
                            if (idActor != id2) {
                            %>
                            <OPTION VALUE="<%= idActor%>"><%= idActor%>, <%= NumeActor%>, <%= PrenumeActor%>, <%= Nationalitate%></OPTION>
                                <%
                                        } else {
                                %>                
                            <OPTION selected="yes" VALUE="<%= idActor%>"><%= idActor%>, <%= NumeActor%>, <%= PrenumeActor%>, <%= Nationalitate%></OPTION>
                                <%
                                        }
                                    }
                                %>
                        </SELECT>

                    </td>
                </tr>
                <tr>
                    <td align="right">NumePersonaj:</td>
                    <td> <input type="text" name="NumePersonaj" size="30" value="<%= NumePersonaj%>"/></td>
                </tr>
     
            </table><p align="center">
                <input type="submit" value="Modifica linia">
            </p>
        </form>
        <p align="center"">
            <a href="index.html"><b>Home</b></a>
            <br/>
    </body>
    <%
        rs.close();
        rs1.close();
        rs2.close();
        jb.disconnect();
    %>
</html>