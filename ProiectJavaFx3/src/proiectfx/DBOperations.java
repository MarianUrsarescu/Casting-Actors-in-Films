package proiectfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {

	String error;
	Connection con;
	// Conectarea la baza de date

	public DBOperations() {
	}

	public void connect() throws ClassNotFoundException, SQLException, Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aplicatie?useSSL=false", "root", "grizzly700");
		} catch (ClassNotFoundException cnfe) {
			error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date.";
			throw new ClassNotFoundException(error);
		} catch (SQLException cnfe) {
			error = "SQLException: Nu se poate conecta la baza de date.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date.";
			throw new Exception(error);
		}
	}
	// end connect()

	public ResultSet vedeTabel(String tabel) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select * from `aplicatie`.`" + tabel + "`;");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	}
	// end vedeTabel()

	public void disconnect() throws SQLException {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException sqle) {
			error = ("SQLException: Nu se poate inchide conexiunea la baza de date.");
			throw new SQLException(error);
		}
	} // disconnect()

	public void adaugaFilm(String Titlu, String TipFilm) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `aplicatie`.`filme`(Titlu, TipFilm) values('" + Titlu + "', '" + TipFilm + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	// end adaugaClient()

	public void adaugaActor(String Nume, String Prenume, String Nationalitate) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `aplicatie`.`actori`(Nume, Prenume, Nationalitate) values('" + Nume + "', '" + Prenume + "', '" + Nationalitate + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	
	public void adaugaRol(int idFilm, int idActor, String NumePersonaj) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `aplicatie`.`roluri`(idFilm, idActor, NumePersonaj) values('" + idFilm + "', '" + idActor + "', '" + NumePersonaj + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}

	public void stergeTabela(String tabela, String denumirePK, long id) throws SQLException, Exception {
		if (con != null) {
			try {
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("delete from " + tabela + " where " + denumirePK + " = '" + id + "';");
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Stergere nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of stergeTabela()

	public void modificaTabela(String tabela, String primarykey, long ID, String[] campuri, String[] valori)
			throws SQLException, Exception {
		String update = "update " + tabela + " set ";
		String temp = "";
		if (con != null) {
			try {
				for (int i = 0; i < campuri.length; i++) {
					if (i != (campuri.length - 1)) {
						temp = temp + campuri[i] + "='" + valori[i] + "', ";
					} else {
						temp = temp + campuri[i] + "='" + valori[i] + "' where " + primarykey + " = '" + ID + "';";
					}
				}
				update = update + temp;
				// create a prepared SQL statement
				Statement stmt;
				stmt = con.createStatement();

				stmt.executeUpdate(update);
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate." + sqle;
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of modificaTabela()

	public void afisare(ResultSet rs) throws ClassNotFoundException, SQLException, Exception{
		int idFilm;
		String Titlu, TipFilm;
		while(rs.next()){
			idFilm = rs.getInt("idFilm");
			Titlu = rs.getString("Titlu");
			TipFilm = rs.getString("TipFilm");
			System.out.println("idFilm = " + idFilm + ", Titlu = " + Titlu + ", TipFilm = " + TipFilm );
		}
	}
}