package becapp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class conexion_BBDD {

	private String bd = "XE";
	private String login = "TALLER";
	private String password = "TALLER";
	private String url = "jdbc:oracle:thin:@localhost:1521:" + bd;
	java.sql.Statement st = null;
	java.sql.ResultSet rs = null;

	Connection connection = null;

	// CONECTAR CON LA BASE DE DATOS
	public void conectar() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, login, password);
			if (connection != null) {
				System.out.println("Conexion realizada correctamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
  public void registrarAlumno(String counsulta) throws SQLException {
  String consulta= "insert into tabla1 values(?)";
		PreparedStatement ps = connection.prepareStatement(consulta);

		ps.setInt(1, 11);
		ps.setString(2, "Eduardo");
		ps.setString(3, "Calle cooperacion,29");
		ps.setString(4, "654654654");
		ps.setString(5, "01/01/21");
		ps.executeUpdate();

		ps = connection.prepareStatement("select * from clientes_taller");
		rs = ps.executeQuery();

		while (rs.next()) {

			System.out.println("Numero empleado= " + rs.getInt(1) + " nombre= " + rs.getString(2) + " direccion= "
					+ rs.getString(3) + " telefono= " + rs.getString(4) + " fecha alta= " + rs.getString(5));

		}

		ps.close();
  }
 	/**
	 * 

  public void darDeBajaAlumno(Alumno A) {
  
  }

  public void consultarAlumno(Alumno A) {
  
  }

	 */

	
		}

