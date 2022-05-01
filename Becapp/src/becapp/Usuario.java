package becapp;

import java.util.Date;

public class Usuario {

	private int id_usuario;

	private String dni;

	private String apellido;

	private String nombre;

	private String nacionalidad;

	private String email;

	private int telf;

	private Date fecha_nac;

	public String getDni() {
		return dni;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public String getEmail() {
		return email;
	}

	public int getTelf() {
		return telf;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

}