package becapp;

public class Beca {

  private String cod;

  private String nombre;

  private String condiciones;

  private String descripcion;

  private String contacto;

  private String nombreProveedor;

  public tipo_beca tipo_beca;
  
  

  public Beca(String nombre, String condiciones, String descripcion, String contacto, String nombreProveedor,
		becapp.tipo_beca tipo_beca) {
	super();
	this.nombre = nombre;
	this.condiciones = condiciones;
	this.descripcion = descripcion;
	this.contacto = contacto;
	this.nombreProveedor = nombreProveedor;
	this.tipo_beca = tipo_beca;
		
}

public String mostrarBeca() {
  return null;
  }

  public int buscarBeca(String nombre) {
  return 1;
  }

  public String solicitarContacto() {
  return "contacto";
  }

}