import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


public class UF2ACT2 {

	public String Consulta () {

		Connection connection = null;
		Statement stmt = null;

		try
		{
			// Conectem amb la base de dades
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/alumnes", "root", "");

			stmt = connection.createStatement();

			// Comencem la transaccio
			try {
				connection.setAutoCommit(false);
				stmt.execute("DELETE FROM alumnes WHERE dni = '24322522X';");
				Thread.sleep(2000);
				stmt.execute("INSERT INTO alumnes VALUES ('NomProba','24322522X','2002-2-2','CarrerExemple',2123,'PoblacioExemple')");
				connection.commit();
				connection.setAutoCommit(true);
				// Si ha anat be retornem misatge
				return("Transaccio executada amb exit");
			} catch (SQLException s) {
				// Si ha fallat fem un rollback i retornem la excepcio
				connection.rollback();
				return(s.getMessage());
			}

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return("Error general");
	}
}
