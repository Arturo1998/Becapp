package becapp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class conexion_BBDD {

	// datos pendientes de cambiar a la base de datos valida

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

	// CIERRA CONEXION
	public void cerrar() throws SQLException {

		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		if (connection != null)
			connection.close();

	}

	/**
	 * @author Eduardo
	 */

	/**
	 * En este metodo recibimos los datos correspondiente a la beca que queremos dar
	 * de alta, a excepción del numero de beca, que conseguimos en la primera parte
	 * del metodo de la tabla beca.cod y le sumamos +1 para que siga el orden
	 * correlativo. En la segunda parte del metodo hacemos un insert con todo los
	 * datos recopilados con el metodo consulta preparada.
	 * 
	 * @param nombre          datos beca
	 * @param condiciones     datos beca
	 * @param descripcion     datos beca
	 * @param contacto        datos beca
	 * @param nombreProveedor datos beca
	 * @param tipo_beca       datos beca
	 * @return true en caso de exito, false en caso contrario
	 */
	private boolean aniadirBeca(String nombre, String condiciones, String descripcion, String contacto,
			String nombreProveedor, becapp.tipo_beca tipo_beca) {

		boolean alta = false;
		// convertimos el enum a String
		String tBeca = tipo_beca.toString();
		int cod;

		// En proceos de evaluacion
		// Beca beca = new Beca(nombre, condiciones, descripcion, contacto,
		// nombreProveedor, tipo_beca);

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("select max(cod)from becas");
			rs = ps.executeQuery();
			cod = rs.getInt(1) + 1;

			ps = connection.prepareStatement("insert into becas values(?,?,?,?,?,?,?)");
			ps.setInt(1, cod);
			ps.setString(2, nombre);
			ps.setString(3, condiciones);
			ps.setString(4, descripcion);
			ps.setString(5, contacto);
			ps.setString(6, nombreProveedor);
			ps.setString(7, tBeca);
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se encuantan los datos en la base de datos");
			alta = false;
			return alta;
		}

		return alta;
	}

	/**
	 * Este metodo a partir del codigo de beca recibido, borrara la beca
	 * correspondiente.
	 * 
	 * @param cod numero de beca referencia para el borrado
	 * @return true en caso de exito, false en caso contrario
	 */
	private boolean borrarBeca(int cod) {

		boolean borrado = false;

		PreparedStatement ps;

		try {
			ps = connection.prepareStatement("delete from becas where cod=" + cod);
			rs = ps.executeQuery();

			borrado = true;

		} catch (SQLException e) {
			System.out.println("No se a podido realizar el borrado de la beca");
			borrado = false;
			return borrado;
		}

		return borrado;
	}

	/**
	 * Con este metodo podremos actualizar determinados datos de las distintaas
	 * becas de nuestra BBDD
	 * 
	 * @param columna       campo del que queremos hacer la actualizacion
	 * @param cod           codigo del cliente al que se le hace el cambio
	 * @param actualizacion dato que se cambia en la columna
	 * @return true en caso de exito, false en caso contrario
	 */
	private boolean modificarBeca(String columna, int cod, String actualizacion) {

		boolean modificado = false;

		PreparedStatement ps;

		try {
			ps = connection
					.prepareStatement("update becas set " + columna + " = " + actualizacion + " where ncliente=" + cod);
			rs = ps.executeQuery();

			modificado = true;

		} catch (SQLException e) {
			System.out.println("No se a podido realizar la actualizacion de la beca");
			modificado = false;
			return modificado;
		}

		return modificado;
	}

	/**
	 * Este metodo nos saca de la base de datos toda la informacion relativa a
	 * nuestras becas
	 * 
	 * @return devuelve un string con la informacion solicita o un mensaje de error
	 *         en caso de fallo
	 */
	public String listarBecas() {

		PreparedStatement ps;
		String lista = "";

		try {
			ps = connection.prepareStatement("select * from becas");
			rs = ps.executeQuery();
			while (rs.next()) {

				lista += "Codigo beca= " + rs.getInt(1) + " nombre beca = " + rs.getString(2) + " condiciones= "
						+ rs.getString(3) + " descripcion= " + rs.getString(4) + " contacto= " + rs.getString(5)
						+ " nombre proveedor= " + rs.getString(6) + " tipo de beca= " + rs.getString(7) + "\n";

			}

		} catch (SQLException e) {

			return "La lista no se ha podido cargar";
		}

		return lista;
	}

	/**
	 * Con este metodos daremos de alta administradores en la tabla de
	 * administradores, a partir de un objeto administrador que herreda de usuario
	 * 
	 * @param a Objeto de la calse administrador con todos los datos
	 * @return true en caso de exito, false en caso contrario
	 */

	public boolean darAltaAdmin(Administrador a) {

		boolean alta = false;
		int cod;

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("select max(id_usuario)from administradores");
			rs = ps.executeQuery();
			// variar en un futuro para poder hacer la incorpoacion en una tabla vacia
			cod = rs.getInt(1) + 1;

			ps = connection.prepareStatement("insert into becas values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, a.getId_usuario());
			ps.setString(2, a.getDni());
			ps.setString(3, a.getNombre());
			ps.setString(4, a.getApellido());
			ps.setString(5, a.getNacionalidad());
			ps.setString(6, a.getEmail());
			ps.setInt(7, a.getTelf());
			// pendiente de ver al interaccion de este dato
			ps.setDate(8, (Date) a.getFecha_nac());
			ps.setString(9, a.getClave());
			ps.setBoolean(10, a.isEstado());
			ps.setString(11, a.getDescripcion_puesto());
			ps.setString(12, "sysdate");
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se insertar los datos");
			alta = false;
			return alta;
		}

		return alta;

	}
	
	/**
	 * Metodo que borra un admin de la tabla admin a partir de una id de usuario
	 * 
	 * @param id_usuario dato que filtra el borrado del administrador
	 * @return true en caso de exito, false en caso contrario
	 */

	public boolean darBajaAdmin(int id_usuario) {

		boolean borrado = false;

		PreparedStatement ps;

		try {
			ps = connection.prepareStatement("delete from administradores where id_usuario=" + id_usuario);
			rs = ps.executeQuery();

			borrado = true;

		} catch (SQLException e) {
			System.out.println("No se a podido realizar el borrado del administrador");
			borrado = false;
			return borrado;
		}

		return borrado;
	}

}