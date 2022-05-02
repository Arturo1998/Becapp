package becapp;

import java.util.Date;

public class Administrador extends Usuario {

	private String clave;

	private boolean estado;

	private String descripcion_puesto;

	private Date fecha_inc;

	
	public Administrador(int id_usuario, String dni, String nombre, String apellido, String nacionalidad, String email,
			int telf, Date fecha_nac, String clave, boolean estado, String descripcion_puesto) {
		super(id_usuario, dni, nombre, apellido, nacionalidad, email, telf, fecha_nac);
		this.clave = clave;
		this.estado = estado;
		this.descripcion_puesto = descripcion_puesto;
	}

	public String getClave() {
		return clave;
	}

	public boolean isEstado() {
		return estado;
	}

	public String getDescripcion_puesto() {
		return descripcion_puesto;
	}

	public Date getFecha_inc() {
		return fecha_inc;
	}

}