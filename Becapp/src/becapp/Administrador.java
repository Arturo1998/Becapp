package becapp;

import java.util.Date;

public class Administrador extends Usuario {

	private String clave;

	private boolean estado;

	private String descripcion_puesto;

	private Date fecha_inc;

	public Administrador(String clave, boolean estado, String descripcion_puesto) {
		super();
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