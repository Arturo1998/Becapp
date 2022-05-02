package becapp;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario {

	private Integer numero_familiares;

	private double ingreso_anual;

	private Integer telf;

	public ArrayList<Beca> becasFavoritas;

	public estudios_requisitos estudios_requisitos;
	public umbral_ingresos umbral_ingresos;
	
	

	public Alumno(Integer numero_familiares, double ingreso_anual, Integer telf,
			becapp.estudios_requisitos estudios_requisitos, becapp.umbral_ingresos umbral_ingresos) {
		super();
		this.numero_familiares = numero_familiares;
		this.ingreso_anual = ingreso_anual;
		this.telf = telf;
		this.estudios_requisitos = estudios_requisitos;
		this.umbral_ingresos=umbral_ingresos;
		becasFavoritas = new ArrayList<Beca>();
	}
	
	public Alumno(Integer numero_familiares, double ingreso_anual, Integer telf,
			becapp.estudios_requisitos estudios_requisitos) {
		super();
		this.numero_familiares = numero_familiares;
		this.ingreso_anual = ingreso_anual;
		this.telf = telf;
		this.estudios_requisitos = estudios_requisitos;
		umbral_ingresos=null;
		becasFavoritas = new ArrayList<Beca>();
	}
	
	
	public umbral_ingresos getUmbral_ingresos() {
		return umbral_ingresos;
	}

	public void setUmbral_ingresos(umbral_ingresos umbral_ingresos) {
		this.umbral_ingresos = umbral_ingresos;
	}

	
	public Integer getNumero_familiares() {
		return numero_familiares;
	}

	public void setNumero_familiares(Integer numero_familiares) {
		this.numero_familiares = numero_familiares;
	}

	public double getIngreso_anual() {
		return ingreso_anual;
	}

	public void setIngreso_anual(double ingreso_anual) {
		this.ingreso_anual = ingreso_anual;
	}

	public String calcularUmbral(Alumno A) {
		
		// 1 familiar
		if(A.getIngreso_anual()<=8871 && A.getNumero_familiares()==1) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL1);
		}
		if(A.getIngreso_anual()>8871 &&A.getIngreso_anual()<=13236 && A.getNumero_familiares()==1) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL2);
		}
		if(A.getIngreso_anual()>13236 && A.getNumero_familiares()==1) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL3);
		}

		// 2 familiares
		if(A.getIngreso_anual()>8871 && A.getIngreso_anual()<13306 && A.getNumero_familiares()==2) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL1);
		}
		if(A.getIngreso_anual()>13236 &&A.getIngreso_anual()<=22594 && A.getNumero_familiares()==2) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL2);
		}
		if(A.getIngreso_anual()>22594 && A.getNumero_familiares()==2) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL3);
		}
		
		// 3 familiares
		if(A.getIngreso_anual()>13306 && A.getIngreso_anual()<17742 && A.getNumero_familiares()==3) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL1);
		}
		if(A.getIngreso_anual()>25794 &&A.getIngreso_anual()<=30668 && A.getNumero_familiares()==3) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL2);
		}
		if(A.getIngreso_anual()>30668 && A.getIngreso_anual()==3) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL3);
		}
		
		// 4 familiares
		if(A.getIngreso_anual()>17742 && A.getIngreso_anual()<22177 && A.getNumero_familiares()==4) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL1);
		}
		if(A.getIngreso_anual()>30668 &&A.getIngreso_anual()<=40708 && A.getNumero_familiares()==4) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL2);
		}
		if(A.getIngreso_anual()>40708 && A.getNumero_familiares()==4) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL3);
		}
		
		// 5 familiares
		if(A.getIngreso_anual()>22177 && A.getIngreso_anual()<25726 && A.getNumero_familiares()==5) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL1);
		}
		if(A.getIngreso_anual()>40708 &&A.getIngreso_anual()<=43945 && A.getNumero_familiares()==5) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL2);
		}
		if(A.getIngreso_anual()>43945 && A.getNumero_familiares()==5) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL3);
		}
		
		// 6 familiares
		if(A.getIngreso_anual()>25726 && A.getIngreso_anual()<29274 && A.getNumero_familiares()==6) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL1);
		}
		if(A.getIngreso_anual()>43945 &&A.getIngreso_anual()<=47146 && A.getNumero_familiares()==6) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL2);
		}
		if(A.getIngreso_anual()>47146 && A.getNumero_familiares()==6) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL3);
		}
		
		// 7 familiares
		if(A.getIngreso_anual()>29274 && A.getIngreso_anual()<32822 && A.getNumero_familiares()==7) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL1);
		}
		if(A.getIngreso_anual()>47146 &&A.getIngreso_anual()<=50333 && A.getNumero_familiares()==7) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL2);
		}
		if(A.getIngreso_anual()>50333 && A.getNumero_familiares()==7) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL3);
		}
		
		// 8 familiares
		if(A.getIngreso_anual()>32822 && A.getIngreso_anual()<28371 && A.getNumero_familiares()>=8) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL1);
		}
		if(A.getIngreso_anual()>50333 && A.getIngreso_anual()<=53665 && A.getNumero_familiares()>=8) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL2);
		}	
		if(A.getIngreso_anual()>53665 && A.getNumero_familiares()>=8) {
			A.setUmbral_ingresos(umbral_ingresos.UMBRAL3);
		}
		return A.getUmbral_ingresos().toString();
	}

	public void aniadirFavorito(Beca beca, Alumno A) {
		A.becasFavoritas.add(beca);
	}

	public void mostrarBecaFavorita(ArrayList<Beca> becasFavoritas, Alumno A) {
		for (Beca beca : becasFavoritas) {
			System.out.println(beca);
		}
	}

	public void borrarBecaFavorita(Beca beca1, ArrayList<Beca> becasFavoritas, Alumno A) {
		for (Beca beca2 : becasFavoritas) {
			if(beca2.getCod()==beca1.getCod()) {
				becasFavoritas.remove(beca2);
			}
			
		}
	}

	
}