package becapp;

import java.util.List;

public class Alumno extends Usuario {

  private Integer numero_familiares;

  private double ingreso_anual;

  private Integer telf;

  public List<Beca> becasFavoritas;

    public estudios_requisitos estudios_requisitos;
    public umbral_ingresos umbral_ingresos;

  public double calcularUmbral() {
  return 0.0;
  }

  public void registrarAlumno(Alumno A) {
  }

  public void darDeBajaAlumno(Alumno A) {
  }

  public void consultarAlumno(Alumno A) {
  }

  public void aniadirFavorito(Beca beca) {
  }

  public String mostrarBecaFavorita() {
  return null;
  }

  public void borrarBecaFavorita(Beca beca) {
  }

}